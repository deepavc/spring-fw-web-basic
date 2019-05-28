package com.deepavc.group.springstartup.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.deepavc.group.springstartup.datamapping.Author;
import com.deepavc.group.springstartup.datamapping.Book;
import com.deepavc.group.springstartup.dto.BooksAndAuthors;
import com.deepavc.group.springstartup.repos.BookRepo;

@Controller
public class BooksAuthorsController {
	
	private BookRepo booksRepo;
	private static final String GETBOOKS_MAPPING = "booksandauthors";
	
	public BooksAuthorsController(BookRepo booksRepo) {
		this.booksRepo = booksRepo;
	}

	@RequestMapping("/books")
	public String getBooks(Model model){
		Iterator<Book> bookItr = this.booksRepo.findAll().iterator();
		List<BooksAndAuthors> booksAndAuthors = new ArrayList<BooksAndAuthors>();
		while(bookItr.hasNext()){
			BooksAndAuthors booksAndAuthor = new BooksAndAuthors();
			Book book = bookItr.next();
			List<String> authorNames = new ArrayList<>();
			for(Author author : book.getAuthors()){
				String name = author.getLastname() + "," + author.getFirstname();
				authorNames.add(name);
			}
			booksAndAuthor = new BooksAndAuthors(book.getName(), book.getIsbn(), book.getPublisher().getName(), book.getPublisher().getAddress(), authorNames);
			booksAndAuthors.add(booksAndAuthor);
		}
		model.addAttribute("booksAndAuthors", booksAndAuthors);
		return GETBOOKS_MAPPING;
	}

}
