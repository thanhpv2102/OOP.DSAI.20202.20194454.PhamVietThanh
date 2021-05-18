package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class Track implements Playable {

	private int length;
	private String title;

	public Track() {
		// TODO Auto-generated constructor stub
	}

	public int getLength() {
		return length;
	}

	public String getTitle() {
		return title;
	}

	public void play() throws PlayerException{
		if (this.getLength() > 0) {
			System.out.println("Playing track: " + this.getTitle());
			System.out.println("Track length: " + this.getLength());
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
}
