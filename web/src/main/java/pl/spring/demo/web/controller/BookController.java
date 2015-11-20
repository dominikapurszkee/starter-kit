package pl.spring.demo.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.spring.demo.service.BookService;
import pl.spring.demo.service.impl.BookServiceImpl;
import pl.spring.demo.to.BookTo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class BookController {
	@Autowired
	private BookService bookService;

	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public String bookList(Map<String, Object> params) {
		final List<BookTo> allBooks = bookService.findAllBooks();
		params.put("books2", allBooks);
		return "bookList";
	}

	/*@RequestMapping(value = "/books/delete/{id}", method = RequestMethod.POST)
	public String deleteId(@ModelAttribute(value = "id") Long id, Map<String, Object> params) {
		BookTo deletedBookTo = bookService.getBook(id);

		bookService.deleteBook(id);
		final List<BookTo> allBooks = bookService.findAllBooks();
		params.put("books", allBooks);

		params.put("deletedBook", deletedBookTo);
		return "bookList2";

	}*/
	
	@RequestMapping(value = "/books/add", method = RequestMethod.POST)
public String add(@RequestBody BookTo bookTo, Map<String, Object> params) {
	BookTo newBook=bookService.saveBook(bookTo);
	params.put("newBook",newBook);
	return "confirmation";

	}

	@RequestMapping(value = "/book/{id}/update", method = RequestMethod.POST)
	public String update(@RequestBody BookTo bookTo , Map<String, Object> params) {
		//title i author ustawiamy w json
		BookTo updatedBook=bookService.saveBook(bookTo);
		params.put("newBook",updatedBook);
		return "confirmation";

 }
	
	
	
	
	@RequestMapping(value="/books/deleteId/{id}",method = RequestMethod.POST)
	String deleteId(@ModelAttribute (value="id")Long id,Map<String,Object>params){
		BookTo deletedBookId= bookService.getBook(id);
		bookService.deleteBook(id);
		List<BookTo>allBooks=bookService.findAllBooks();
		params.put("books", allBooks);
		params.put("deletedBookId", deletedBookId);
		return "bookList2";
		
	}
	

}