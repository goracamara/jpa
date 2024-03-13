package sn.yes.jpa.repositories;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sn.yes.jpa.models.Author;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer>, JpaSpecificationExecutor<Author> {
    @Transactional
    List<Author> findByNamedQuery(@Param("age") int age);
    @Modifying
    @Transactional
    void updateByNamedQuery(@Param("age") int age);

    // update Author a set a.age = 22 where a.id = 1
    @Modifying
    @Transactional
    @Query("update Author a set a.age = :age where a.id= :id")
    int updateAuthor(int age, int id);

    // update Author a set a.age = 22 where a.id = 1
    @Modifying
    @Transactional
    @Query("update Author a set a.age = :age")
    int updateAllAuthorAge(int age);

    // select * from author where first_name = "ali"
    List<Author> findAllByFirstName(String firstName);

    // select * from author where first_name = "al"
    List<Author> findAllByFirstNameIgnoreCase(String firstName);

    // select * from author where first_name like "%ali%"
    List<Author> findAllByFirstNameContainingIgnoreCase(String firstName);

    // select * from author where first_name like "ali%"
    List<Author> findAllByFirstNameStartingWithIgnoreCase(String firstName);

    // select * from author where first_name like "%ali"
    List<Author> findAllByFirstNameEndingWithIgnoreCase(String firstName);

    //select * from author where first_name in ("ali", "bou", "coding")
    List<Author> findAllByFirstNameInIgnoreCase(List<String> firstName); //or ...String


}
