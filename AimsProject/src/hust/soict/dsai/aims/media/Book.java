package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.exception.InsertionException;
import hust.soict.dsai.aims.exception.InvalidDataException;
import hust.soict.dsai.aims.exception.RemoveException;

public class Book extends Media{
	
	private List<String> authors =  new ArrayList<String>();
	
	public Book(String title, String category, float cost) throws InvalidDataException{
		super(title, category, cost);
	}
	
	public Book(String title) throws InvalidDataException{
		super(title);
	}

	public String addAuthor(String authorName) throws InsertionException{
		if (authors.contains(authorName)) {
			throw new InsertionException(authorName + " already in list");
		} else {
			authors.add(authorName);
			return (authorName + " added");
		}
	}
	
	public String removeAuthor(String authorName) throws RemoveException{
		if (authors.contains(authorName)) {
			authors.remove(authors.indexOf(authorName));
			return (authorName + " removed");
		} else {
			throw new RemoveException(authorName + " not in list");
		}
	}
	
	public String getDetail() {
		return ("Book ID "+ this.getId() +": - title: " + this.getTitle() + " - category: " + this.getCategory() +": " + this.getCost() + " $");
	}
}
