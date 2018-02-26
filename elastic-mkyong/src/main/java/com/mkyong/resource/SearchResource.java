package com.mkyong.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mkyong.model.Book;
import com.mkyong.repository.BookRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rest/search")
public class SearchResource {

	@Autowired
	BookRepository bookRepository;

	@GetMapping(value = "/title/{title}")
	public List<Book> searchTitle(@PathVariable final String title) {
		return bookRepository.findByTitle(title);
	}

	@GetMapping(value = "/author/{author}")
	public List<Book> searchAuthor(@PathVariable final String author) {
		List<Book> booksList = new ArrayList<>();
		Page<Book> books = bookRepository.findByAuthor(author, new PageRequest(0, 10));
		books.forEach(booksList::add);
		return booksList;
	}

	@GetMapping(value = "/all")
	public List<Book> searchAll() {
		List<Book> booksList = new ArrayList<>();
		Iterable<Book> books = bookRepository.findAll();
		books.forEach(booksList::add);
		return booksList;
	}

}
