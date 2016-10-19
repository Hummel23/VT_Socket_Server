
public abstract class Command {
	
	String name;
	
	public String process(String[] args){
		
		return args[0];
		
	}

}
