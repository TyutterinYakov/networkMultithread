package edu.greet;

import edu.Greetable;

public class DayGreet extends Greetable {

	@Override
	public String buildResponse(String userName) {
		return "Good day "+userName;
	}
	
	
	
}
