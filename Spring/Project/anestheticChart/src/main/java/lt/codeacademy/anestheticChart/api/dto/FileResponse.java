package lt.codeacademy.anestheticChart.api.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class FileResponse {
    private String originalFileName;
}
