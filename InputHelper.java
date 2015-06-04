import java.io.*;
import java.util.*;

public class InputHelper{
	public static String inputLine = "";
	public static Stack<String> myStack;

	public InputHelper() {
		myStack = new Stack<String>();
	}

	public void outputRequest(){
		System.out.println("Welcome to the CS9G RPN simulator!");
		System.out.println("You can type numbers or operators (+, -, /, *, pop, clear, midi, quit)");
		while(inputLine != "quit"){
			System.out.println("+- STACK -- top ---------+");
			for(int iter = myStack.size() - 1; iter > -1; iter--) {
				System.out.println("|                      " + myStack.get(iter) + " |");
			}
			System.out.print("+--------- bottom -------+ Input: ");
			try {
				BufferedReader is = new BufferedReader ( new InputStreamReader(System.in));
				inputLine = is.readLine();
				if (inputLine.length() == 0 ) { 
					System.out.println("null");
				} else {
					Eval.calculateStack();
				}
			} 
			catch (IOException e) {
				System.out.println("IOException: " + e); 
			}
		}
	}
}