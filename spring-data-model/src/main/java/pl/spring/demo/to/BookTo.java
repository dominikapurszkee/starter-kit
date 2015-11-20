package pl.spring.demo.to;

import java.util.List;

import pl.spring.demo.entity.AuthorEntity;

public class BookTo {
    private Long id;
    private String title;
    private String authors;

    public BookTo() {
    }

    public BookTo(Long id, String title, String authors) {
        this.id = id;
        this.title = title;
        this.authors = authors;
    }
    
    public BookTo(Long id, String title, List<AuthorEntity> authors) {
        this.id = id;
        this.title = title;
        this.authors = mapAuthorsToString(authors);
  
    }

    private String mapAuthorsToString(List<AuthorEntity> authors) {
		StringBuilder stringBuilder=new StringBuilder();
    	for(AuthorEntity author:authors){
			stringBuilder.append(author.getPersonalData().getName());
			stringBuilder.append(" ");
			stringBuilder.append(author.getPersonalData().getSurname());
			stringBuilder.append(", ");
		}
    	
		return stringBuilder.toString().substring(0, stringBuilder.length()-2);
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

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }
}
