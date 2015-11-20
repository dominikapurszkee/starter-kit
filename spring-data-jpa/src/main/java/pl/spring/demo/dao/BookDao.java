package pl.spring.demo.dao;

import java.util.List;

import pl.spring.demo.entity.BookEntity;
import pl.spring.demo.to.BookSearchCriteria;

public interface BookDao extends Dao<BookEntity, Long> {

    List<BookEntity> findBookByTitle(String title);

	List<BookEntity> findBooksBySearchCriteria(BookSearchCriteria searchCriteria);

	


}

