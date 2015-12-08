package au.com.new1step.apps.vip.hash;

import java.util.HashMap;

import au.com.new1step.apps.vip.rs.model.Book;

public class HashDB {
	private static HashMap<String, Book> map = new HashMap<String, Book>();
	static{
		
		Book book = new Book();
		book.setBookId(1);
		book.setBookName("Book Name1");
		book.setAuthor("Andy Wu");
		map.put(book.getBookName(), book);
		
		book = new Book();
		book.setBookId(2);
		book.setBookName("Book Name2");
		book.setAuthor("Lianfu Wu");
		map.put(book.getBookName(), book);
		
		book = new Book();
		book.setBookId(3);
		book.setBookName("Book Name3");
		book.setAuthor("Katherine Wu");
		map.put(book.getBookName(), book);
		
		book = new Book();
		book.setBookId(4);
		book.setBookName("Book Name4");
		book.setAuthor("William Wu");
		map.put(book.getBookName(), book);
		
		book = new Book();
		book.setBookId(5);
		book.setBookName("Book Name5");
		book.setAuthor("Ethan Wu");
		map.put(book.getBookName(), book);
		
	}
	public static Book getBook(String bookName){
		System.out.println("ANDY2: " + bookName);
		return map.get(bookName);		
	}
	
	public static void insertBook(Book book){
		long id = map.size() + 1;
		book.setBookId(id);
		map.put(book.getBookName(), book);		
	}

}
