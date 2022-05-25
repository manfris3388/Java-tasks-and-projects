package lt.codeacademy.anestheticChart.entity;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Getter
@Table(name = "ANESTHETIC_CHARTS")
public class ChartEntity {
    @Id
    @GeneratedValue()
    private Long id;
    private UUID uuid;
    private String name;
    private String surname;
    private String hospitalNumber;
    private String dob;
    private String operation;
}
