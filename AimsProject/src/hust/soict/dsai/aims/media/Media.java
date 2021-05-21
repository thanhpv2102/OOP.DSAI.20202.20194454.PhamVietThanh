package hust.soict.dsai.aims.media;

import java.util.Comparator;

import hust.soict.dsai.aims.exception.InvalidDataException;

public abstract class Media {

	//id created when add to store
	private int id;
	private String title;
	private String category;
	private float cost;
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
	
	public Media() {
		
	}
	
	public Media(String title, String category, float cost) throws InvalidDataException{
		super();
		if (cost < 0) {
			throw new InvalidDataException("Cost is negative");
		}
		if (title.strip().equals("")) {
			throw new InvalidDataException("Field(s) is missing data");
		}
		if (category.strip().equals("")) {
			throw new InvalidDataException("Field(s) is missing data");
		}
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
	
	public Media(String title) throws InvalidDataException{
		super();
		if (title.strip().equals("")) {
			throw new InvalidDataException("Field(s) is missing data");
		}
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getCategory() {
		return category;
	}

	public float getCost() {
		return cost;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Media) {
			try {
				Media media = (Media) obj;
				if (this.title.equals(media.getTitle())) {
					return true;
				}
			} catch (NullPointerException | ClassCastException e2) {
				return false;
			}
		}
		return false;
	}
	
	public String getDetail() {
		return "";
	}
	
	public String toString() {
		return this.getDetail();
	}
}
