package commands;

public class Divider implements Calculation{

	@Override
	public String process(String[] args) {
		int result = Integer.parseInt(args[1]);
		for (int i = 2; i < args.length; i++) {
			if(Integer.parseInt(args[i])== 0){
				return "Division with '0' not possible";
			}
			result /= Integer.parseInt(args[i]);
		}
		return String.valueOf(result);
		
	}

}
