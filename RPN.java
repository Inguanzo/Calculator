import java.io.*;
import java.lang.Math;
import java.util.*;

public class RPN {
	public static void main(String[] args){
		RPN simulation = new RPN();
		simulation.calculate();
	}

	public void calculate(){
		InputHelper inputHelper = new InputHelper();
		inputHelper.outputRequest();
	}
}
