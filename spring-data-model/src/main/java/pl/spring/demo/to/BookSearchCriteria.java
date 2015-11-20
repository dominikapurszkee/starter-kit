package pl.spring.demo.to;

public class BookSearchCriteria {
private String author;
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getLibraryName() {
	return libraryName;
}
public void setLibraryName(String libraryName) {
	this.libraryName = libraryName;
}
private String title;
private String libraryName;

}
