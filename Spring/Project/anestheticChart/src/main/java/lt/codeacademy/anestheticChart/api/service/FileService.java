package lt.codeacademy.anestheticChart.api.service;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.anestheticChart.api.dto.FileResponse;
import lt.codeacademy.anestheticChart.jpa.entities.file.File;
import lt.codeacademy.anestheticChart.jpa.repositories.file.FileRepository;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;

@Service
@Slf4j
@RequiredArgsConstructor
public class FileService {

  private final FileRepository fileRepository;
  private final Path fileLocation = Paths.get("./files").toAbsolutePath().normalize();

  @Transactional
  public FileResponse saveFile(MultipartFile file) {
    createDirectory();

    try {
      String[] splitFile = file.getOriginalFilename().split("\\.");

      File savedFileInDb = fileRepository.save(
              File.builder()
                      .fileName(splitFile[0])
                      .fileExtension(splitFile[1])
                      .size(file.getSize())
                      .mediaType(file.getContentType())
                      .build());

      Path filePathWithFileName = fileLocation.resolve(savedFileInDb.getUniqFileName());
      Files.copy(file.getInputStream(), filePathWithFileName, StandardCopyOption.REPLACE_EXISTING);
      return FileResponse.builder()
              .originalFileName(savedFileInDb.getUniqFileName())
              .build();
    } catch (IOException e) {
      log.error("Cannot create file", e);
      e.printStackTrace();
    }
    return null;
  }

  private void createDirectory() {
    try {
      if (!Files.exists(fileLocation)) {
        Files.createDirectory(fileLocation);
      }
    } catch (IOException e) {
      log.error("Cannot create directory", e);
      e.printStackTrace();
    }
  }

  public Resource getFile(String fileName) {
    try {
      InputStream inputStream = Files.newInputStream(fileLocation.resolve(fileName));

      return new InputStreamResource(inputStream);
    } catch (IOException e) {
      log.error("Cannot get/create file by file name", e);
      e.printStackTrace();
    }
    return null;
  }

  public MediaType getFileMediaTypeByFileName(String fileName) {
    return MediaType.valueOf(URLConnection.guessContentTypeFromName(fileName));
  }
}
