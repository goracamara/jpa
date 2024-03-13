package sn.yes.jpa.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@NamedQueries({
        @NamedQuery(
                name = "Author.findByNamedQuery",
                query = "select a from Author a where a.age >= :age"
        ),
        @NamedQuery(
                name = "Author.updateByNamedQuery",
                query = "update Author a set a.age = :age"
        )
})

public class Author extends BaseEntity {

    private String firstName;

    private String lastName;

    @Column(
        unique = true,
        nullable = false
    )
    private String email;

    private int age;

    @ManyToMany(mappedBy = "authors", fetch = FetchType.EAGER)
    private List<Course> courses;

}
