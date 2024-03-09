package sn.yes.jpa.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
@Entity
//@Table(name = "AUTHOR_TBL")
public class Author {
    @Id
   /* @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "author_sequence"
    )
    @SequenceGenerator(
            name = "author_sequence",
            sequenceName = "author_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.TABLE,
            generator = "author_id_gen"
    )
    @TableGenerator(
            name = "author_id_gen",
            table = "id_generator",
            pkColumnName = "id_name",
            valueColumnName = "id_value",
            allocationSize = 1
    )*/
    private Integer id;

    @Column(
        name = "f_name",
        length = 40
    )
    private String firstName;

    private String lastName;
    @Column(
        unique = true,
        nullable = false
    )
    private String email;

    private int age;

    @Column(
            insertable = false,
            nullable = false
    )
    private LocalDateTime createdAt;

    @Column(
            insertable = false
    )
    private LocalDateTime lastModified;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
