package com.javaapi.test.application.test.testmockito.mockitSpring.po;

public class RouteMatrix {

	private String airlineCode;

	public String getAirlineCode() {
		return airlineCode;
	}

	public void setAirlineCode(String airlineCode) {
		this.airlineCode = airlineCode;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RouteMatrix [airlineCode=");
		builder.append(airlineCode);
		builder.append("]");
		return builder.toString();
	}


	

}
