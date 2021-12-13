package edu.greet;

import edu.Greetable;

public class MorningGreet extends Greetable{

	@Override
	public String buildResponse(String userName) {
		// TODO Auto-generated method stub
		return "Good mornig, "+userName;
	}

}
