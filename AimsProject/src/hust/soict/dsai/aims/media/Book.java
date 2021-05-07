package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media{
	
	private List<String> authors =  new ArrayList<String>();
	
	public Book(String title, String category, float cost) {
		super(title, category, cost);
		// TODO Auto-generated constructor stub
	}
	
	public Book(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}

	public void addAuthor(String authorName) {
		if (authors.contains(authorName)) {
			System.out.println(authorName + " already in list");
		} else {
			authors.add(authorName);
			System.out.println(authorName + " added");
		}
	}
	
	public void removeAuthor(String authorName) {
		if (authors.contains(authorName)) {
			authors.remove(authors.indexOf(authorName));
			System.out.println(authorName + " removed");
		} else {
			System.out.println(authorName + " not in list");
		}
	}
	
	public String getDetail() {
		return ("Book ID "+ this.getId() +": - title: " + this.getTitle() + " - category: " + this.getCategory() +": " + this.getCost() + " $");
	}
}
