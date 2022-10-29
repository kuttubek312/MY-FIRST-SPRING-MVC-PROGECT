package kuttubek.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String companyName;

    private String LocatedCountry;

    @OneToMany(fetch = FetchType.EAGER,
    cascade = {CascadeType.MERGE, CascadeType.REMOVE},
    mappedBy = "company")
    public List<Course> courses;


    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", LocatedCountry='" + LocatedCountry + '\'' +
                ", courses=" + courses +
                '}';
    }
}
