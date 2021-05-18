package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable {

	
	private String artist;
	private List<Track> tracks = new ArrayList<>();
	
	public CompactDisc() {
		// TODO Auto-generated constructor stub
	}
	
	public CompactDisc(String title, String category, String artist, String director, float cost) {
		super(title, category, director, cost);
		this.artist = artist;
	}
	
	public CompactDisc(String title, String category, String artist, float cost) {
		super(title, category, cost);
		this.artist = artist;
	}
	
	public CompactDisc(String title, String category, float cost) {
		super(title, category, cost);
		// TODO Auto-generated constructor stub
	}
	
	public CompactDisc(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}

	public String getArtist() {
		return artist;
	}
	
	public void addTrack(Track track) {
		if (tracks.contains(track)) {
			System.out.println(track.getTitle() + " already in list");
		} else {
			tracks.add(track);
			System.out.println(track + " added");
		}
	}
	
	public void removeTrack(Track track) {
		if (tracks.contains(track)) {
			tracks.remove(tracks.indexOf(track));
			System.out.println(track.getTitle() + " removed");
		} else {
			System.out.println(track.getTitle() + " not in list");
		}
	}
	
	public int getLength() {
		int lengthTotal = 0;
		for (int i = 0; i < tracks.size(); i++) {
			lengthTotal += tracks.get(i).getLength();
		}
		return lengthTotal;
	}
	
	public void play() throws PlayerException{
		if (this.getLength() > 0) {
			for (int i = 0; i < tracks.size(); i++) {
				try {
					tracks.get(i).play();
				} catch (PlayerException e) {
					throw e;
				}
			}
		} else {
			throw new PlayerException("ERROR: CD length is non-positive!");
		}
	}
	
	public String getDetail() {
		return ("CD ID " + this.getId() +": - title: " + this.getTitle() + " - category: " + this.getCategory() + " - artist: " + this.getArtist() +": " + this.getCost() + " $");
	}
}
