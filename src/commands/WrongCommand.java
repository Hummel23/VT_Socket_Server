package commands;

public class WrongCommand implements Calculation{

	@Override
	public String process(String[] args) {
		
		return "Not an arithmetic operation, please try again." ;
	}

}
