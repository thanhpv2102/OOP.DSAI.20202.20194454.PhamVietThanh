package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.exception.InsertionException;
import hust.soict.dsai.aims.exception.InvalidDataException;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.exception.RemoveException;

public class CompactDisc extends Disc implements Playable {

	
	private String artist;
	private List<Track> tracks = new ArrayList<>();
	
	public CompactDisc() {
		// TODO Auto-generated constructor stub
	}
	
	public CompactDisc(String title, String category, String artist, String director, float cost) throws InvalidDataException{
		super(title, category, director, cost);
		this.artist = artist;
	}
	
	public CompactDisc(String title, String category, String artist, float cost) throws InvalidDataException{
		super(title, category, cost);
		this.artist = artist;
	}
	
	public CompactDisc(String title, String category, float cost) throws InvalidDataException{
		super(title, category, cost);
		// TODO Auto-generated constructor stub
	}
	
	public CompactDisc(String title) throws InvalidDataException{
		super(title);
		// TODO Auto-generated constructor stub
	}

	public String getArtist() {
		return artist;
	}
	
	public String addTrack(Track track) throws InsertionException{
		if (tracks.contains(track)) {
			throw new InsertionException(track.getTitle() + " already in list");
		} else {
			tracks.add(track);
			return (track + " added");
		}
	}
	
	public String removeTrack(Track track) throws RemoveException{
		if (tracks.contains(track)) {
			tracks.remove(tracks.indexOf(track));
			return (track.getTitle() + " removed");
		} else {
			throw new RemoveException(track.getTitle() + " not in list");
		}
	}
	
	public int getLength() {
		int lengthTotal = 0;
		for (int i = 0; i < tracks.size(); i++) {
			lengthTotal += tracks.get(i).getLength();
		}
		return lengthTotal;
	}
	
	public String play() throws PlayerException {
		String trackList = "";
		if (this.getLength() > 0) {
			for (int i = 0; i < tracks.size(); i++) {
				try {
					trackList += tracks.get(i).play() + '\n';
				} catch (PlayerException e) {
					throw e;
				}
			}
			return trackList;
		} else {
			throw new PlayerException("ERROR: CD length is non-positive!");
		}
	}
	
	public String getDetail() {
		return ("CD ID " + this.getId() +": - title: " + this.getTitle() + " - category: " + this.getCategory() + " - artist: " + this.getArtist() +": " + this.getCost() + " $");
	}
}
