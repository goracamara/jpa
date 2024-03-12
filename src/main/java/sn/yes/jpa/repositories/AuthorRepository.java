package sn.yes.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.yes.jpa.models.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
