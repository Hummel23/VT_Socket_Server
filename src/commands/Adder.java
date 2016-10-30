package commands;

public class Adder implements Calculation {

	@Override
	public String process(String[] args) {
		double result = Integer.parseInt(args[1]);
		for (int i = 2; i < args.length; i++) {
			result += Double.parseDouble(args[i]);
		}
		return String.valueOf(result);
	}

}
