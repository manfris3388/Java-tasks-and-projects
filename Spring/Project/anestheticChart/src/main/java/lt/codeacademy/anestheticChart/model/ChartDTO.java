package lt.codeacademy.anestheticChart.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ChartDTO {
    private String name;
    private String surname;
    private String hospitalNumber;
    private LocalDate dob;

}
