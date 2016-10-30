package factory;

import commands.Adder;
import commands.Calculation;
import commands.Divider;
import commands.Multiplier;
import commands.WrongCommand;

public class CommandFactory {
	
	
	public Calculation createCalculation(String command){
		switch (command) {
		case "add":
			return new Adder();		
		case "multiply":
			return new Multiplier();
		case "divide":
			return new Divider();
		default:
			return new WrongCommand();
		}
	}

}
