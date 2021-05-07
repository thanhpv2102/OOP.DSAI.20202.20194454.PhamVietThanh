package hust.soict.dsai.aims.media;

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

	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}
	
	public boolean equals(Track track) {
		if (this.title.equals(track.getTitle()) && this.length == track.getLength()) {
			return true;
		}
		return false;
	}
}
