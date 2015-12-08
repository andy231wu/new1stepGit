package au.com.new1step.apps.vip.rs.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="BookList")
public class BookList {
    private List<Book> bookList;

	public List<Book> getBookList() {
		if(bookList == null){
			bookList = new ArrayList<Book>();
		}
		return bookList;
	}

	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}
}
