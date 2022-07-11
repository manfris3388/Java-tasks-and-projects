package lt.codeacademy.anestheticChart.api.controller;

import lombok.AllArgsConstructor;
import lt.codeacademy.anestheticChart.api.service.FileService;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@RestController
public class FileController {

    private final FileService fileService;

    @PostMapping("api/file/upload")
    public void saveFile(@RequestParam MultipartFile file) {
        fileService.saveFile(file);
    }


    @GetMapping("/api/file/download")
    public ResponseEntity<Resource> getFileByFileName(@RequestParam String fileName) {
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(fileService.getFile(fileName));
    }
}
