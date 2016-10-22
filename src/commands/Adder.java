package commands;

public class Adder implements Calculation {

	@Override
	public String process(String[] args) {
		int result = Integer.parseInt(args[1]);
		for (int i = 2; i < args.length; i++) {
			result += Integer.parseInt(args[i]);
		}
		return String.valueOf(result);
	}

}
