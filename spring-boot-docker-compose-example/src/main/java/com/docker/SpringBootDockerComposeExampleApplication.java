package com.docker;

import com.docker.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/books")
public class SpringBootDockerComposeExampleApplication {

	@Autowired
	private BooksRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDockerComposeExampleApplication.class, args);
	}

	@PostMapping
	public Book addBooks(@RequestBody Book book){
		return  repository.save(book);
	}

	@GetMapping
	public List<Book> getAllBooks(){

		return repository.findAll();
	}
}
