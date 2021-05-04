package hust.soict.dsai.aims.media;


public class DigitalVideoDisc extends Disc {
	
	private static int nbDigitalVideoDiscs = 0;
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
		this.id = nbDigitalVideoDiscs;
		nbDigitalVideoDiscs += 1;
	}


	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
		this.id = nbDigitalVideoDiscs;
		nbDigitalVideoDiscs += 1;
	}

	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.id = nbDigitalVideoDiscs;
		nbDigitalVideoDiscs += 1;
	}

	public DigitalVideoDisc(String title) {
		super();
		this.title = title;
		this.id = nbDigitalVideoDiscs;
		nbDigitalVideoDiscs += 1;
	}

	public String getDirector() {
		return director;
	}
	
	public int getLength() {
		return length;
	}
	
	public String getDetail() {
		return ("DVD - " + title + " - " + category + " - " + director + " - " + length +": " + cost + " $");
	}
	public boolean search(String title) {
		if (title == this.title) {
			return true;
		} else {
			return false;
		}
	}

}
