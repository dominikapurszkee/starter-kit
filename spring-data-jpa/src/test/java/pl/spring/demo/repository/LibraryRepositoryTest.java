package pl.spring.demo.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.spring.demo.entity.BookEntity;
import pl.spring.demo.entity.LibraryEntity;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "CommonRepositoryTest-context.xml")
public class LibraryRepositoryTest {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private LibraryRepository libraryRepository;
    
    @Test
    public void testShouldDeleteLibraryAndAllBooksByCascade() {
    	// given 
        List<LibraryEntity> libraries = libraryRepository.findAll();
        assertNotNull(libraries);
        assertFalse(libraries.isEmpty());
        assertEquals(1,libraries.size());
        
        List<BookEntity> booksEntity = bookRepository.findAll();
        // then
        assertNotNull(booksEntity);
        assertFalse(booksEntity.isEmpty());
        assertEquals(3, booksEntity.size());
        
        libraryRepository.delete(libraries);
        libraries = libraryRepository.findAll();
        assertNotNull(libraries);
        assertTrue(libraries.isEmpty());

       booksEntity = bookRepository.findAll();
        assertNotNull(booksEntity);
        assertTrue(booksEntity.isEmpty());
       
    }
    @Test
    public void testShouldFindLibraryByName() {
        // given
        final String name = "biblio";
        // when
        List<LibraryEntity> libraryEntity = libraryRepository.findLibrarykByName(name);
        // then
        assertNotNull(libraryEntity);
        assertFalse(libraryEntity.isEmpty());
        assertEquals("Biblioteka Miejska", libraryEntity.get(0).getLibraryName());
    }
   
}
