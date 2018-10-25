public class Player{

	//declare your fields here
	private Hand a;
	private double balance;

	//initialize your fields in the constructor
	public Player(double balance){
		this.balance = balance;
		a = new Hand();
	}

	public void deal(Card c){
		a.addCard(c);
	}

	//Returns an array of Cards that the Player wishes to discard.
	//The game engine will call deal() on this player for each card
	//that exists in the return value. MS2 Instructions: Print the hand to
	//the terminal using System.out.println and ask the user which cards 
	//they would like to discard. The user will first the number of cards they
	//wish to discard, followed by the indices, one at a time, of
	//the card(s) they would like to discard, 
	//Return an array with the appropriate Card objects
	//that have been discarded, and remove the Card objects from this
	//player's hand. Use IO.readInt() for all inputs. In cases of error
	//re-ask the user for input.
	//
	// Example call to discard():
	//
	// This is your hand:
	// 0: Ace of Hearts
	// 1: 2 of Diamonds
	// 2: 5 of Hearts
	// 3: Jack of Spades
	// 4: Ace of Clubs
	// How many cards would you like to discard?
	// 2
	// 1
	// 2
	//
	// The resultant array will contain the 2 of Diamonds and the 5 of hearts in that order
	// This player's hand will now only have 3 cards

	public Card[] discard(){

		System.out.println("This is your hand: ");
		for (int i = 0; i < 5; i++) {
			System.out.println(i + " : " + a.getCard(i));
		}


		System.out.println("How many cards would you like to discard? ");
		int numCards = IO.readInt();
		
		while (numCards > 5 || numCards < 0) {
			IO.reportBadInput();
			System.out.println("You can't discard more than 5 cards, enter again: ");
			numCards = IO.readInt();
		}


		Card removedCards[] = new Card[numCards];

		System.out.println("Which cards would you like to discard? Enter the location of each card: ");

		for (int i = 0; i < numCards; i++) {
			int posOfCards = IO.readInt();
			
			while (posOfCards > 4 || posOfCards < 0) {
				IO.reportBadInput();
				System.out.println("Not a correct location, enter again: ");
				posOfCards = IO.readInt();
			}
			
			while (a.getCard(posOfCards) == null) {
				IO.reportBadInput();
				System.out.println("Invalid location, enter again: ");
				posOfCards = IO.readInt();
			}

			
			
			removedCards[i] = a.getCard(posOfCards);
			a.removeCard(posOfCards);

			
		}
		return removedCards;
		
//		int numCards = 5;
//		Card[] removedCards = new Card[numCards];
//		
//		if (a.hasFlush() == true || a.hasStraight() == true || a.hasFourOfAKind() == true || a.hasFullHouse() == true 
//				|| a.hasTriplet() == true || a.numPairs() > 0) {
//			
//			numCards = 0;
//			
//			
//		} 
//		
//		if (numCards == 5) {
//			
//			removedCards[0] = a.getCard(0);
//			removedCards[1] = a.getCard(1);
//			removedCards[2] = a.getCard(2);
//			removedCards[3] = a.getCard(3);
//			removedCards[4] = a.getCard(4);
//
//			a.removeCard(0);
//			a.removeCard(1);
//			a.removeCard(2);
//			a.removeCard(3);
//			a.removeCard(4);
//
//		}
//		
//		return removedCards;	
//		
//	}
		
		
		
		
		
		
		
		
		
//		
//		int numCards = 5;
//		Card[] removedCards = new Card[numCards];
//
//		if (a.hasFlush() == true || a.hasStraight() == true || a.hasFourOfAKind() == true || a.hasFullHouse() == true 
//				|| a.hasTriplet() == true || a.numPairs() > 0) {
//
////			if (a.hasFlush() == true && a.hasStraight() == true) {
////				numCards = 0;
////			} else
////			if (a.hasFourOfAKind() == true) {
////				numCards = 0;
////			} else
////			if (a.hasFullHouse() == true) {
////				numCards = 0;
////			} else
////			if (a.hasFlush() == true) {
////				numCards = 0;
////			} else
////			if (a.hasStraight() == true) {
////				numCards = 0;
////			} else
////			if (a.hasTriplet() == true) {
////				numCards = 0;
////			} else
////			if (a.numPairs() == 2) {
////				numCards = 0;
////			} else {
//////			{ (a.numPairs() == 1) {
////				numCards = 0;
////				} 
////			} else {
////			
////			numCards = 5;
//
//			numCards = 0;
//			System.out.println("DISCARD TEST");
////			return removedCards;
//		
//		} else if (numCards == 5) {
//						
//			removedCards[0] = a.getCard(0);
//			removedCards[1] = a.getCard(1);
//			removedCards[2] = a.getCard(2);
//			removedCards[3] = a.getCard(3);
//			removedCards[4] = a.getCard(4);
//			
//			a.removeCard(0);
//			a.removeCard(1);
//			a.removeCard(2);
//			a.removeCard(3);
//			a.removeCard(4);
//			
//			System.out.println("TESTING DISCARD");
////			return removedCards;
//		}
//		System.out.println("DISCARD");
//		return removedCards;
}

	//Returns the amount that this player would like to wager, returns
	//-1.0 to fold hand. Any non zero wager should immediately be deducted
	//from this player's balance. This player's balance can never be below
	// 0 at any time. This player's wager must be >= to the parameter min
	// MS2 Instructions: Show the user the minimum bet via the terminal 
	//(System.out.println), and ask the user for their wager. Use
	//IO.readDouble() for input. In cases of error re-ask the user for 
	//input.
	// 
	// Example call to wager()
	//
	// How much do you want to wager?
	// 200
	//
	// This will result in this player's balance reduced by 200

	public double wager(double min){		


		System.out.println("Minimum bet: " + min);

		System.out.println("How much would you like to wager? Enter -1.0 to fold: ");
		double wagerAmount = IO.readDouble();

		while (balance - wagerAmount < 0) {
			IO.reportBadInput();
			System.out.print("Cannot wager more than balance, enter new wager amount: ");
			wagerAmount = IO.readDouble();
		}


		while (wagerAmount < min && wagerAmount != -1.0) {
			IO.reportBadInput();
			System.out.println("You must wager at least the minimum amount of " + min + ", enter new wager amount: ");
			wagerAmount = IO.readDouble();
		}

		if (wagerAmount == -1.0) {
			System.out.println("You have folded.");
			return -1.0;

		} else {

			balance -= wagerAmount;
			return wagerAmount;
		}
	}
		//min = 10;
		
		
//		double wagerAmount = -1.0;
//		
////		if (a.hasFlush() == true || a.hasStraight() == true || a.hasFourOfAKind() == true || a.hasFullHouse() == true 
////				|| a.hasTriplet() == true || a.numPairs() > 0) {
//
//			
//			if (a.numPairs() == 1) {
//				wagerAmount = .3 * balance;
//			}
//			if (a.numPairs() == 2) {
//				wagerAmount = .4 * balance;
//			}
//			if (a.hasTriplet() == true) {
//				wagerAmount = .5 * balance;
//			}
//			if (a.hasStraight() == true) {
//				wagerAmount = .6 * balance;
//			}
//			if (a.hasFlush() == true) {
//				wagerAmount = .7 * balance;
//			}
//			if (a.hasFullHouse() == true) {
//				wagerAmount = .8 * balance;
//			}
//			if (a.hasFourOfAKind() == true) {
//				wagerAmount = .9 * balance;
//			}
//			if (a.hasFlush() == true && a.hasStraight() == true) {
//				wagerAmount = balance;
//			} 
//			
//			balance -= wagerAmount;
//			
//		
//		if (min == 0) {
//			wagerAmount = balance / 10;
//			min = balance / 10;
//		}
//		
//		if (min > balance) {
//			wagerAmount = -1.0;
//		}
//			
//		return wagerAmount;
//	}

	//Returns this player's hand
	public Hand showHand(){
		return a;
	}

	//Returns this player's current balance
	public double getBalance(){
		return balance;
	}

	//Increase player's balance by the amount specified in the parameter,
	//then reset player's hand in preparation for next round. Amount will
	//be 0 if player has lost hand
	public void winnings(double amount){
		balance += amount;
		for (int i = 0; i < 5; i++) {
			a.removeCard(i);
		}
	}

}