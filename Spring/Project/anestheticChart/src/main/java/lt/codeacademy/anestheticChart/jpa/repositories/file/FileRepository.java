package lt.codeacademy.anestheticChart.jpa.repositories.file;

import lt.codeacademy.anestheticChart.jpa.entity.file.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, Long>  {
}
