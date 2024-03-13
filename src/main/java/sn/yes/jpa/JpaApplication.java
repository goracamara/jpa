package sn.yes.jpa;

import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.domain.Specification;
import sn.yes.jpa.models.Author;
import sn.yes.jpa.models.Video;
import sn.yes.jpa.models.specification.AuthorSpecification;
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
			for(int i= 0; i < 50 ; i++){
				Faker faker = new Faker();
				var author= Author.builder()
						.firstName(faker.name().firstName())
						.lastName(faker.name().lastName())
						.age(faker.number().numberBetween(19, 50))
						.email(faker.name().username()+ "@gmail.com")
						.build();
				authorRepository.save(author);
			}

			/*var video = Video.builder()
					.name("match Real")
					.lenght(6)
					.build();
			videoRepository.save(video);*/

			// update author with id = 1
			var author= Author.builder()
					.id(1)
					.firstName("Gora")
					.lastName("Camara")
					.age(34)
					.email("camou.gora@gmail.com")
					.build();
			//authorRepository.save(author);

			// update Author a set a.age = 22 where a.id = 1
			//authorRepository.updateAuthor(100, 1);

			// update all author age
			//authorRepository.updateAllAuthorAge(99);

			// find by named query
			// authorRepository.findByNamedQuery(70)
					//.forEach(System.out::println);
			 // update by namedQuery
			//authorRepository.updateByNamedQuery(12);

			Specification<Author> specification = Specification
					.where(AuthorSpecification.hasAge(39))
					.and(AuthorSpecification.firstnameLike("Ma"));
			authorRepository.findAll(specification).forEach(System.out::println);
		};

	}

}
