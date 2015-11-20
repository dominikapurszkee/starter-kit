package pl.spring.demo.mapper;

import java.util.ArrayList;
import java.util.List;

import pl.spring.demo.entity.BookEntity;
import pl.spring.demo.to.BookTo;

public class BookMapper {

    public static BookTo map(BookEntity bookEntity) {
        if (bookEntity != null) {
            return new BookTo(bookEntity.getId(), bookEntity.getTitle(), bookEntity.getAuthors());
        }
        return null;
    }

    public static BookEntity map(BookTo bookTo) {
        if (bookTo != null) {
            return new BookEntity(bookTo.getId(), bookTo.getTitle(), null,null);//do naprawy
        }
        return null;
    }

    public static List<BookTo> map2To(List<BookEntity> bookEntities) {
       
    	List<BookTo> toList= new ArrayList();
    	for(BookEntity bookEntity: bookEntities){
    		toList.add(BookMapper.map(bookEntity));
    	}
    	return toList;
        
    }

    public static List<BookEntity> map2Entity(List<BookTo> bookToList) {
    	List<BookEntity> entityList= new ArrayList();
    	for(BookTo bookTo: bookToList){
    		entityList.add(BookMapper.map(bookTo));
    	}
    	return entityList;
    }
}
