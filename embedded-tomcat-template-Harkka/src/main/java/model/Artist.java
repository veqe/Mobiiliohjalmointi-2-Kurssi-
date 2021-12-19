package model;

public class Artist {
	
	private long id;
	private String name;
	
	public Artist(String artist) {
		this.name = artist;
	}
	
	public Artist(long id2, String name2) {
		this.id = id2;
		this.name = name2;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
