package server;

import commands.Adder;
import commands.Divider;
import commands.Multiplier;

public class Protocol {



	public String process(String msg){

		String arr[] = msg.split(" ");
		String command = arr[0].trim().toLowerCase();

		if(command.equals("add")){
			Adder adder = new Adder();
			return adder.process(arr);
		}
		if(command.equals("multiply")){
			Multiplier multiplier = new Multiplier();
			return multiplier.process(arr);
		}
		else{
			Divider divider = new Divider();
			return divider.process(arr);
		}

	}

}
