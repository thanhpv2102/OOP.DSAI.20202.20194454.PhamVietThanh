package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.InvalidDataException;

public class Disc extends Media{

	private String director;
	private int length;
	
	public Disc() {
		// TODO Auto-generated constructor stub
	}
	
	public Disc(String title, String category, String director, int length, float cost) throws InvalidDataException{
		super(title, category, cost);
		this.director = director;
		this.length = length;
		if (length <= 0) {
			throw new InvalidDataException("Length is not positive");
		}
		if (director.strip().equals("")) {
			throw new InvalidDataException("Field(s) is missing data");
		}
	}
	
	public Disc(String title, String category, String director, float cost) throws InvalidDataException{
		super(title, category, cost);
		this.director = director;
		if (director.strip().equals("")) {
			throw new InvalidDataException("Field(s) is missing data");
		}
	}
	
	public Disc(String title, String category, float cost) throws InvalidDataException{
		super(title, category, cost);
	}
	
	public Disc(String title) throws InvalidDataException{
		super(title);
	}

	public String getDirector() {
		return director;
	}

	public int getLength() {
		return length;
	}
	
}
