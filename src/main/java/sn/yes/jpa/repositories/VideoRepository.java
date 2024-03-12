package sn.yes.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.yes.jpa.models.Video;

public interface VideoRepository extends JpaRepository<Video , Integer> {
}
