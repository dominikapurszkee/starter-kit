package pl.spring.demo.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;




@Entity
@Table(name = "BOOK")
public class BookEntity implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false, length = 50)
	private String title;
	@ManyToMany
	@JoinTable(name = "BOOK_AUTHOR_RELATION", joinColumns = {
			@JoinColumn(name = "BOOK_ID", nullable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "AUTHOR_ID", nullable = false) })
	private List<AuthorEntity> authors;

	@ManyToOne(optional=false,cascade=CascadeType.ALL)
	@JoinColumn(name="LIBRARY_ID",nullable=false)
    //@OnDelete(action=OnDeleteAction.CASCADE)
	private LibraryEntity library;
	
	
	
	public LibraryEntity getLibrary() {
		return library;
	}

	public void setLibrary(LibraryEntity library) {
		this.library = library;
	}

	// for hibernate
	protected BookEntity() {
	}

	public BookEntity(Long id, String title, List<AuthorEntity> authors,LibraryEntity library) {
		this.id = id;
		this.title = title;
		this.authors = authors;
		this.library=library;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<AuthorEntity> getAuthors() {
		return authors;
	}

	public void setAuthors(List<AuthorEntity> authors) {
		this.authors = authors;
	}
}
