package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable{

	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(title, category, director, length, cost);
	}


	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super(title, category, director, cost);
	}

	public DigitalVideoDisc(String title, String category, float cost) {
		super(title, category, cost);
	}

	public DigitalVideoDisc(String title) {
		super(title);
	}

	public boolean search(String title) {
		if (title == this.getTitle()) {
			return true;
		} else {
			return false;
		}
	}

	public void play() throws PlayerException {
		if (this.getLength() > 0) {
			System.out.println("Playing DVD: " + this.getTitle());
			System.out.println("DVD length: " + this.getLength());
		} else {
			throw new PlayerException("ERROR: DVD length is non-positive!");
		}
	}
	
	public String getDetail() {
		return ("DVD ID "+ this.getId() +": - title: " + this.getTitle() + " - category: " + this.getCategory() + " - director: " + this.getDirector() + " - length: " + this.getLength() +": " + this.getCost() + " $");
	}
}
