import java.util.StringTokenizer;

public class Protocol {

	private static Protocol instance;

	//private constructor to prevent instantion
	private Protocol(){
	}

	public static Protocol getInstance(){
		if (instance == null){
			instance = new Protocol();
		}
		return instance;
	}
	
	
	public String process(String msg) {
		String result;
		
		if (msg == "") {
			result = "The input was invalid, please try again.";
		}else{
			String[] input = new String[3];
			StringTokenizer t = new StringTokenizer(msg);
			String word ="";
			int counter = 0;
			while(t.hasMoreTokens())
			{
			    word = t.nextToken();
			    input[counter]=word;
			    counter++;
			}
			
		}
		
		
		
		
		return result;
	}

}
