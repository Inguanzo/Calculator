import java.io.*;
import java.lang.Math;
import java.util.*;

public class Test {
	public static void main(String[] args){
		//RPN simulation = new RPN();
		//simulation.calculate();
		InputHelper tester = new InputHelper();
		tester.inputLine = "4";
		Eval.calculateStack();
		System.out.println("should print 4: " + tester.myStack.get(0));

		tester.inputLine = "one";
		System.out.print("should print error #: ");

		Eval.calculateStack();

		tester.inputLine = "1";
		Eval.calculateStack();

		tester.inputLine = "-";
		Eval.calculateStack();
		System.out.println("should print 3: " + tester.myStack.get(0));

		System.out.print("should print error +: ");
		tester.inputLine = "+";
		Eval.calculateStack();

		tester.inputLine = "1";
		Eval.calculateStack();

		tester.inputLine = "0";
		Eval.calculateStack();

		System.out.print("should print error /: ");
		tester.inputLine = "/";
		Eval.calculateStack();

		tester.inputLine = "clear";
		Eval.calculateStack();
		System.out.println("size should be 0: " + tester.myStack.size());

		System.out.print("should print error midi: ");
		tester.inputLine = "midi";
		Eval.calculateStack();
		





	}
}