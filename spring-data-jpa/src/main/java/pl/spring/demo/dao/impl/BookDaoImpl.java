package pl.spring.demo.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.util.StringUtils;

import pl.spring.demo.dao.BookDao;
import pl.spring.demo.entity.BookEntity;
import pl.spring.demo.entity.QBookEntity;
import pl.spring.demo.entity.QLibraryEntity;
import pl.spring.demo.to.BookSearchCriteria;

import com.mysema.query.BooleanBuilder;
import com.mysema.query.jpa.HQLTemplates;
import com.mysema.query.jpa.JPASubQuery;
import com.mysema.query.jpa.impl.JPAQuery;
public class BookDaoImpl extends AbstractDao<BookEntity, Long> implements BookDao {

    @Override
    public List<BookEntity> findBookByTitle(String title) {
        TypedQuery<BookEntity> query = entityManager.createQuery(
                "select book from BookEntity book where upper(book.title) like concat(upper(:title), '%')", BookEntity.class);
        query.setParameter("title", title);
        return query.getResultList();
    }
    @Override
	public List<BookEntity> findBooksBySearchCriteria(BookSearchCriteria searchCriteria) {
		final QBookEntity bookEntity = QBookEntity.bookEntity;
		final JPAQuery query = new JPAQuery(entityManager, HQLTemplates.DEFAULT).from(bookEntity);
		
		if(searchCriteria != null) {
			final BooleanBuilder predicate = new BooleanBuilder();
			
			if (!StringUtils.isEmpty(searchCriteria.getTitle())) {
               final String title = searchCriteria.getTitle();
                predicate.and(bookEntity.title.startsWithIgnoreCase(title));
          }
			if (!StringUtils.isEmpty(searchCriteria.getAuthor())) {
               final String author = searchCriteria.getAuthor();
                predicate.and(bookEntity.authors.any().personalData.name.startsWithIgnoreCase(author)
                        .or(bookEntity.authors.any().personalData.surname.startsWithIgnoreCase(author)));
            }
			if (!StringUtils.isEmpty(searchCriteria.getLibraryName())) {
                QLibraryEntity libEntity = QLibraryEntity.libraryEntity;
                predicate.and(new JPASubQuery().from(libEntity).where(libEntity.books.any().bookEntity.title.eq(bookEntity.title)).exists());
            }
			query.where(predicate);
			return query.listResults(bookEntity).getResults();
		}
		
		return null;
	}
   
}
