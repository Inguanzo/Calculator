
public class Eval{

	public static void calculateStack(){
		String set = "*/+-";
		String currentLine = InputHelper.inputLine;
		char currentChar = '0';
		String myString1 = "";
		String myString2 = "";
		int b = 0;
		int a = 0;
		int c = 0;
		String instrument = "";
		String note = "";
		String duration = "";
		boolean check = true;
		if(currentLine.contains("*") || currentLine.contains("/") || currentLine.contains("+")  || currentLine.contains("-") ){
			currentChar = currentLine.charAt(0);
			if(InputHelper.myStack.size() > 1){
				b = Integer.parseInt(InputHelper.myStack.pop());
				a = Integer.parseInt(InputHelper.myStack.pop());
				check = false;
			}
		} 

		if(currentLine.equals("pop")) {
			currentChar = 'p';
		}
		if(currentLine.equals("clear")) {
			currentChar = 'c';
		}
		if(currentLine.equals("midi")) {
			currentChar = 'm';
			int stackLen = InputHelper.myStack.size();
			if(stackLen > 2){
				instrument = InputHelper.myStack.get(stackLen - 1);
				note = InputHelper.myStack.get(stackLen - 2);
				duration = InputHelper.myStack.get(stackLen - 3);
				check = false;
			} else {
				check = true;
			}
		}
		if(currentLine.equals("quit")) {
			currentChar = 'q';
		}

		switch(currentChar){
			case '/':
				if(check){
					System.out.println("Error! The stack must have at least two numbers for " + currentChar+ " to work...");
					break;
				} 
				if(b == 0){
					System.out.println("Error! / by zero.");
					myString1 = String.valueOf(a);
					InputHelper.myStack.push(myString1);

					myString1 = String.valueOf(b);
					InputHelper.myStack.push(myString1);
				
					break;
				} 
				c = a/b;
				myString1 = String.valueOf(c);
				InputHelper.myStack.push(myString1);
				break;
			case '*':
				if(check){
					System.out.println("Error! The stack must have at least two numbers for " + currentChar+ " to work...");
					break;
				}
				c = a * b;
				myString1 = String.valueOf(c);
				InputHelper.myStack.push(myString1);
				break;
			case '+':
				if(check){
					System.out.println("Error! The stack must have at least two numbers for " + currentChar+ " to work...");
					break;
				}
				c = a + b;
				myString1 = String.valueOf(c);
				InputHelper.myStack.push(myString1);
				break;
			case '-':
				if(check){
					System.out.println("Error! The stack must have at least two numbers for " + currentChar+ " to work...");
					break;
				}
				c = a - b;
				myString1 = String.valueOf(c);
				InputHelper.myStack.push(myString1);
				break;
			case 'p':
				InputHelper.myStack.pop();	
				break;
			case 'c':
				while(!InputHelper.myStack.empty()){
					InputHelper.myStack.pop();
				}
				break;
			case 'm':
				if(check){
					System.out.println("Error! The stack must have at least 3 numbers for midi to play...");
				} else {
					if(Integer.parseInt(duration) > 127 || Integer.parseInt(duration) < 0){ 
						System.out.println("Error! The number " + duration + "is outside of the valid MIDI data range...");
					} else if(Integer.parseInt(note) > 127 || Integer.parseInt(note) < 0){
						System.out.println("Error! The number " + note + "is outside of the valid MIDI data range...");
					} else if(Integer.parseInt(instrument) > 127 || Integer.parseInt(instrument) < 0){
						System.out.println("Error! The number " + instrument + " is outside of the valid MIDI data range...");
					} else {
						System.out.println("Playing MIDI sound: Duration=" + duration + ", Note=" + note + ", Instrument=" + instrument +"...");
					}
				}

				break;
			case 'q':
				System.exit(0);
				break;
			default:
				try {
					int d = Integer.parseInt(currentLine);
					InputHelper.myStack.push(currentLine);
				}  
				catch(NumberFormatException nfe) {
					System.out.println("Error! " + currentLine + " is not a number or operator (+, -, /, *, pop, clear, midi, quit)");
				}
				break;
		}


	}
}