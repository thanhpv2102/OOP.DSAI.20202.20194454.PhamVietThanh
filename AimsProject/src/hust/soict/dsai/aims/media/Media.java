package hust.soict.dsai.aims.media;

public abstract class Media {

	protected int id;
	protected String title;
	protected String category;
	protected float cost;
	
	public Media() {
		// TODO Auto-generated constructor stub
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
}
