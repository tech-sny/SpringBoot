package life.care.health.azure.Education;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "about")
public class Education {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name="degree")
    private String degree;
    @Column(name="year")
    private String year;
    @Column(name="location")
    private String location;
    @Column(name="specialization")
    private String specialization;
    @Column(name="image")
    private String image;
    
}