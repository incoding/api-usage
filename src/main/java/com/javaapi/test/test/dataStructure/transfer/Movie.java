package com.javaapi.test.test.dataStructure.transfer;

public class Movie {
	private int rank;
	private String description;
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Movie [rank=");
		builder.append(rank);
		builder.append(", description=");
		builder.append(description);
		builder.append("]");
		return builder.toString();
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Movie(int rank, String description) {
		super();
		this.rank = rank;
		this.description = description;
	}

}
