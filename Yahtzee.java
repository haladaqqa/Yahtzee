
public class Yahtzee {                                     // this class represents the game where there are 5 rolled dice and the scoring is performed

	// private instance variable
	private Dice[] dice;
	
	// Constructor
	public Yahtzee() {
		this.dice = new Dice[5];                           // set the dice to a new array with  5 elements
		for (int i = 0; i < 5; i++) {
			dice[i] = new Dice();                          // create a new dice object
			dice[i].roll();                                // roll for random values
		}
	}
	
	// Constructor
	public Yahtzee (Dice[] dice) {
		this.dice = dice;                                  // assign dice 
		
	}
	
	// This method counts how many dice show each of the possible values from 1-6 and record all of them in an int array (determines how many of each number occur)
	
	public int[] getValueCount() {
		int[] countVar = new int [6];                     // array of 6 integers
		for (int i = 0; i < 5; i++) {                     // values in dice array
			countVar[this.dice[i].getValue() - 1] ++ ;
		}
		return countVar;	                              // Return this array with the 6 counters
		
	}
	
	// private helper method (get sum of all five values of the array)
	
	private int findSum() {
		// local variable
		int sumVal = 0;
		
		for (int i = 0; i < 5; i++) {
			sumVal += this.dice[i].getValue();           // add all the values of the dice
		}
		return sumVal;
	}
	
	// record all the possible scores for the dice of all 13 options and store them in an array
	
	public int[] getScoreOptions() {
		
		// local variables
		int[] scoreVal = new int [13];                   // an integer array with 13 elements
		int[] count = getValueCount();                   // an object determines how many of each number occur
		boolean doubleBool = false;
		boolean tripleBool = false;
		int counter = 0;                                 // initialise counter to zero
		int sum = this.findSum();                        // sum of all five dices
		
		for (int i = 0; i < 6; i++) {
			
			// Counts and gets the sum of the Aces(sum of dice showing 1), twos(sum of dice showing 2), threes(sum of dice showing 3), fours(sum of dice showing 4), fives(sum of dice showing 5) and sixes(sum of dice showing 6)
			scoreVal[i] = count[i] * (i+1);              // add all the values in scoreVal array (sum the specific subset of dice), set scoreVal at those same indexes to the count at that index 
		
			// Determine 3 of a kind (3 dice showing the same value) & part of Full House (3 dice of a value)
			if (count[i] >= 3) {                         // if the number occurred 3 times
				scoreVal[6] = sum;                       // at index 6, there will be the sum of the all five dices
				tripleBool = true;                       // Full House Description, set the boolean variable to true if a value showed 3 times
			}
			
			// Determine 4 of a kind (4 dice showing the same value)
			if (count[i] >= 4) {                         // if the number occurred 4 times
				scoreVal[7] = sum;                       // at index 7, there will be the sum of the all five dices
			}
			
			// Yahtzee (5 dice showing the same value)
			if (count[i] == 5) {                        // if the number occurred 5 times
				scoreVal[11] = 50;                      // fixed score of 50 at index 11
			}
			
			// part of Full House (2 dice of a value)
			if (count[i] == 2) {
				doubleBool = true;                     // set the boolean variable to true if a value showed 2 times
			}
			
			if (count[i] != 0) {                       // if the value current count value not a zero (there is no values that are occurring more than once)
				counter ++;	                           // increment the counter by 1
			} else {
				counter = 0;
			}
			
			
			// Small Straight (sequence of 4 dice with consecutive value)
			if (counter == 4) {
				scoreVal[9] = 30;                      // fixed score of 30 at index 9
			}
			
			// Large Straight (sequence of 5 dice with consecutive value)
			else if (counter == 5) {
				scoreVal[10] = 40;                    // fixed score of 40 at index 10
			}
			
		}
		
		//
		if (doubleBool && tripleBool) {
			scoreVal[8] = 25;                        // if doubleBool and tripleBool are both true then the fixed score will be 25 at index 8
		}
		
		// Chance (No pattern, happens all the time)
		scoreVal[12] = sum;                          // gets the sum of all 5 dice at index 12
		
		return scoreVal;                             // return an array with 13 elements
	}
	
	// Determine the maximum value from the array of possible scores, and the index at which the maximum is found
	
	public int[] score() {
		
		// local variables
		int[] getScore = getScoreOptions();
		int maxVal = 0;
		int indexVal = -1;
		
		for (int i = 0; i < 13; i++) {              // for every number in getScore we want to find the max value
			if (getScore[i] > maxVal) {
				maxVal = getScore[i];
				indexVal = i;                       // the index of the max value
			}
		}
		return new int[] {maxVal, indexVal};        // Return an int array containing 2 values: the maximum value and then the corresponding index of that value
	}
	
	
	// This method returns a string of the dice values in a specific format
	
	public String toString() {
		return "Dice: {" + dice[0].getValue() +", " + dice[1].getValue() + ", " + dice[2].getValue() + ", " + dice[3].getValue() + ", " + dice[4].getValue() + "}";
	}
	
	
	
	// (equals method) compares between two Yahtzee objects 
	
	public boolean equals(Yahtzee other) {
		boolean bool;                                                        // declare a boolean variable to keep track of true or false
		
		for (int i = 0; i < 5; i++) {                                        // iterate through every number in the first array
			bool = false;
			for (int j = 0; j < 5; j++) {                                    // iterate in the second array (other) within the first array
				if (this.dice[i].getValue() == other.dice[j].getValue()) {   // check if the number in the first array is not in the second array
					bool = true;
				}
			}
		    if (!bool) {
		    	return false;                                               // return false if the no. in the first array is not in the second array
		    }
		}
		return true;		
	}
	
}
