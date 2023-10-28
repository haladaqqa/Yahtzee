
public class Dice {                                  // This class represents a single six-sided dice
	
	// private instance variable
	private int value;
	
	// Constructor
	public Dice () {
		this.value = -1;
	}
	
	// Secondary Constructor
	public Dice (int value) {    
		this.value = value;                           // initialise value to the given argument
	}
	
	public void roll() {                              // generate a number between 1 and 6 (inclusive), set the value to that number
		value = RandomNumber.getRandomNumber(1, 6);	
	}
	
	public int getValue() {                           // returns dice value
		return value;
	}

}
