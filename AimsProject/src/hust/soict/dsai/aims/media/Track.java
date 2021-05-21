package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class Track implements Playable {

	private int length;
	private String title;

	public Track(int length, String title) {
		this.length = length;
		this.title = title;
	}
	
	public Track(String title) {
		this.title = title;
	}

	public int getLength() {
		return length;
	}

	public String getTitle() {
		return title;
	}

	public String play() throws PlayerException{
		if (this.getLength() > 0) {
			return ("Playing track: " + this.getTitle() + "\n" + "Track length: " + this.getLength());
		} else {
			throw new PlayerException("ERROR: Track length is non-positive!");
		}
		
	}
	
	public boolean equals(Track track) {
		if (this.title.equals(track.getTitle()) && this.length == track.getLength()) {
			return true;
		}
		return false;
	}
	
	public String toString() {
		return "Track " + getTitle() + ": " + getLength();
	}
}
