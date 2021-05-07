package hust.soict.dsai.test.media;

import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class TestPolymorphism {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Media> mediae = new ArrayList<Media>();
		CompactDisc cd = new CompactDisc("Title A", "Category A", "Artist A", "Director A", 69.420f); 
		DigitalVideoDisc dvd = new DigitalVideoDisc("Title B", "Category B", "Director B", 87, 5f);
		Book book = new Book("Title C", "Category C", 5f);
		mediae.add(cd);
		mediae.add(dvd);
		mediae.add(book);
		for (Media m: mediae) {
			System.out.println(m.toString());
		}
	}

}
