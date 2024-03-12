package sn.yes.jpa.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
//@Inheritance(strategy =InheritanceType.SINGLE_TABLE )
//@Inheritance(strategy =InheritanceType.SINGLE_TABLE )
//@DiscriminatorColumn(name = "resource_type")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Resources {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private int size;

    private String url;

    @OneToOne
    @JoinColumn(name = "lecture_id")
    private Lecture lecture;
}
