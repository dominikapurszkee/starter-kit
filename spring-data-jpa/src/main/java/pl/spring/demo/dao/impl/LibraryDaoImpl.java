package pl.spring.demo.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import pl.spring.demo.dao.LibraryDao;
import pl.spring.demo.entity.BookEntity;
import pl.spring.demo.entity.LibraryEntity;

public class LibraryDaoImpl extends AbstractDao<LibraryEntity, Long>implements LibraryDao {

	
	@Override
	public List<LibraryEntity> findLibraryByName(String name) {
		TypedQuery<LibraryEntity> query = entityManager.createQuery(
                "select library from LibraryEntity library where upper(library.libraryName) like concat(upper(:libraryName), '%')", LibraryEntity.class);
        query.setParameter("libraryName", name);
        return query.getResultList();
	}

}
