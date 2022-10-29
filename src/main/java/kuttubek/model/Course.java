package kuttubek.model;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String courseName;
    private String duration;

    @ManyToOne
    private Company company;

    @ManyToMany(fetch = FetchType.EAGER,
            mappedBy = "courseList", cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Group> groupList;

    @OneToOne(mappedBy = "course", cascade = CascadeType.REMOVE)
    private Teacher teacher;


}
