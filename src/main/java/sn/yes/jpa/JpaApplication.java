package sn.yes.jpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import sn.yes.jpa.models.Author;
import sn.yes.jpa.models.Video;
import sn.yes.jpa.repositories.AuthorRepository;
import sn.yes.jpa.repositories.VideoRepository;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(
		AuthorRepository authorRepository,
		VideoRepository videoRepository
	){
		return args -> {
			/*var author= Author.builder()
					.firstName("Gora")
					.lastName("Camara")
					.age(34)
					.email("camou.gora@gmail.com")
					.build();
			authorRepository.save(author);*/
			var video = Video.builder()
					.name("match Real")
					.lenght(6)
					.build();
			videoRepository.save(video);
		};
	}

}
