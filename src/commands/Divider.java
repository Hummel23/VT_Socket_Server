package commands;

public class Divider implements Calculation{

	@Override
	public String process(String[] args) {
		double result = Double.parseDouble(args[1]);
		for (int i = 2; i < args.length; i++) {
			if(Double.parseDouble(args[i])== 0){
				return "Division with '0' not possible";
			}
			result /= Double.parseDouble(args[i]);
		}
		return String.valueOf(result);
		
	}

}
