package hust.soict.dsai.test.media;

import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class TestSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Media> mediae = new ArrayList<Media>();
		CompactDisc cd = new CompactDisc("Title A", "Category A", "Artist A", "Director A", 7f); 
		CompactDisc cd2 = new CompactDisc("Title A", "Category B", "Artist B", "Director B", 6f);
		DigitalVideoDisc dvd = new DigitalVideoDisc("Title D", "Category B", "Director B", 87, 4f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Title C", "Category B", "Director B", 87, 4f);
		Book book = new Book("Title B", "Category C", 5f);
		mediae.add(cd);
		mediae.add(cd2);
		mediae.add(dvd);
		mediae.add(dvd2);
		mediae.add(book);
		System.out.println("===Before sorting===\n");
		for (Media m: mediae) {
			System.out.println(m.toString());
		}
		System.out.println("\n===Sort by title then cost===\n");
		mediae.sort(Media.COMPARE_BY_TITLE_COST);
		for (Media m: mediae) {
			System.out.println(m.toString());
		}
		System.out.println("\n===Sort by cost then title===\n");
		mediae.sort(Media.COMPARE_BY_COST_TITLE);
		for (Media m: mediae) {
			System.out.println(m.toString());
		}
	}

}
