package com.example.springData.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.springData.models.Book;
import com.example.springData.repositories.bookRepository;

@Service
public class BookService {
	private final bookRepository bookRepository;
	
	public BookService(bookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	// returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    //updates a book
    public Book updateBook(Long id, String title, String desc, String lang, int pages) {
    	Book book = bookRepository.findById(id).get();
    	if (book != null) {
    		book.setTitle(title);
    		book.setDescription(desc);
    		book.setLanguage(lang);
    		book.setNumberOfPages(pages);
    		return bookRepository.save(book);
    	} else return null;
    }
    //updates a book
    public void deleteBook(Long id) {
    	bookRepository.deleteById(id);
    }
}

