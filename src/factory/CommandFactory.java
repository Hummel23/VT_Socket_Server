package factory;

import commands.Adder;
import commands.Calculation;
import commands.Divider;
import commands.Multiplier;
import commands.WrongCommand;

public class CommandFactory {
	
	public static final String MULTIPLY = "multiply";
	public static final String DIVIDE = "divide";
	public static final String ADD = "add";
	
	public Calculation createCalculation(String command){
		switch (command) {
		case ADD:
			return new Adder();		
		case MULTIPLY:
			return new Multiplier();
		case DIVIDE:
			return new Divider();
		default:
			return new WrongCommand();
		}
	}

}
