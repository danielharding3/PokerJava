//
///**
// * An object of type Hand represents a hand of cards.  The
// * cards belong to the class Card.  A hand is empty when it
// * is created, and any number of cards can be added to it.
// */
//
//import java.util.ArrayList;
//
//public class Hand {
//
//	private Card[] hand;   // The cards in the hand.
//	private int count; 
//
//	/**
//	 * Create a hand that is initially empty.
//	 */
//	public Hand() {
//		hand = new Card[5];
//		count = 0;
//	}
//
//	/**
//	 * Remove all cards from the hand, leaving it empty.
//	 */
//	public void clear() {
//		for(int i=0 ; i<hand.length; i++){ hand[i] = null; }
//		count = 0;
//	}
//
//	/**
//	 * Add a card to the hand.  It is added at the end of the current hand.
//	 * @param c the non-null card to be added.
//	 * @throws NullPointerException if the parameter c is null.
//	 */
//	public void addCard(Card c) {
//
//		for(int i=0 ; i<hand.length; i++){ 
//			if (hand[i] == null){
//				hand[i] = c;
//				count = count + 1;
//				break;
//			}
//		}
//
//
//	}
//
//	/**
//	 * Remove a card from the hand, if present.
//	 * @param c the card to be removed.  If c is null or if the card is not in 
//	 * the hand, then nothing is done.
//	 */
//	public void removeCard(Card c) {
//
//		for(int i=0 ; i<hand.length; i++){ 
//			if (hand[i].equals(c)){
//				hand[i] = null;
//				count = count-1;
//			}
//		}
//
//	}
//
//	/**
//	 * Remove the card in a specified position from the hand.
//	 * @param position the position of the card that is to be removed, where
//	 * positions are starting from zero.
//	 * @throws IllegalArgumentException if the position does not exist in
//	 * the hand, that is if the position is less than 0 or greater than
//	 * or equal to the number of cards in the hand.
//	 */
//	public void removeCard(int position) {
//		if (position < 0 || position >= hand.length)
//			throw new IllegalArgumentException("Position does not exist in hand: " + position);
//		hand[position] = null;
//		count--;
//	}	
//
//	/**
//	 * Returns the number of cards in the hand.
//	 */
//	public int getCardCount() {
//		return count;
//	}
//
//	/**
//	 * Gets the card in a specified position in the hand.  (Note that this card
//	 * is not removed from the hand!)
//	 * @param position the position of the card that is to be returned
//	 * @throws IllegalArgumentException if position does not exist in the hand
//	 */
//	public Card getCard(int position) {
//		if (position < 0 || position >= hand.length)
//			throw new IllegalArgumentException("Position does not exist in hand: "
//					+ position);
//		return hand[position];
//	}
//
//	/**
//	 * Sorts the cards in the hand so that cards of the same suit are
//	 * grouped together, and within a suit the cards are sorted by value.
//	 * Note that aces are considered to have the lowest value, 1.
//	 */
//	public void sortBySuit() {
//		int size = count;
//		int nonnull = 0;
//		int index = 0;
//
//		Card[] newHand = new Card[5];
//		while (size > 0) {
//			if (hand[nonnull] == null) { nonnull = nonnull+1; continue;}
//			int pos = nonnull;  // Position of minimal card.
//			Card c = hand[nonnull];  // Minimal card.
//
//			for (int i = nonnull+1; i < hand.length; i++) {
//				Card c1 = hand[i];
//				if (c1 != null){
//					if ( c1.getSuit() < c.getSuit() ||
//							(c1.getSuit() == c.getSuit() && c1.getValue() < c.getValue()) ) {
//						pos = i;
//						c = c1;
//					}
//				}
//			}
//			hand[pos] = null;
//			size = size - 1;
//			newHand[index++] = c;
//			nonnull = 0;
//		}
//		hand = newHand;
//	}
//
//	/**
//	 * Sorts the cards in the hand so that cards of the same value are
//	 * grouped together.  Cards with the same value are sorted by suit.
//	 * Note that aces are considered to have the lowest value, 1.
//	 */
//	public void sortByValue() {
//		int size = count;
//		int nonnull = 0;
//		int index = 0;
//
//		Card[] newHand = new Card[5];
//		while (size > 0) {
//			if (hand[nonnull] == null) { nonnull = nonnull+1; continue;}
//			int pos = nonnull;  // Position of minimal card.
//			Card c = hand[nonnull];  // Minimal card.
//
//			for (int i = nonnull+1; i < hand.length; i++) {
//
//				Card c1 = hand[i];
//				if (c1 != null){
//					if ( c1.getValue() < c.getValue() ||
//							(c1.getValue() == c.getValue() && c1.getSuit() < c.getSuit()) ) {
//						pos = i;
//						c = c1;
//					}
//				}
//			}
//			hand[pos] = null;
//			size = size - 1;
//			newHand[index++] = c;
//			nonnull = 0;
//		}
//		hand = newHand;
//	}
//
//	public void printHand(){
//
//		for(int i=0; i<hand.length; i++){
//			if (hand[i] != null){
//				System.out.println(hand[i]);
//			}
//		}
//		System.out.println();
//	}
//
//
//	/******************************** Implement your methods here ****************************************/
//
//	//Returns the number of pairs this hand contains
//	public int numPairs () {
//		sortByValue();
//		int counter = 0;
//
//		for (int i = 0; i < hand.length; i++) {
//
//			if (i == hand.length-1) {
//				break;
//			} else if (hand[i].getValue() == hand[i + 1].getValue()) {
//				counter++;
//				i++;
//			}
//		}
//		return counter;
//
//	}
//
//
//	//Returns true if this hand has 3 cards that are of the same value
//	public boolean hasTriplet() {
//		sortByValue();
//		boolean isTriplet = false;
//		for (int i = 0; i < hand.length; i++) {
//			if (i < 3) {
//				if (hand[i].getValue() == hand[i + 1].getValue() && hand[i + 1].getValue() == hand[i + 2].getValue()) {
//					isTriplet = true;
//					break;
//					//			} else {
//					//				isTriplet = false;
//				}
//			}
//		}
//		return isTriplet;
//	}
//	//Returns true if this hand has all cards that are of the same suit
//	public boolean hasFlush() {
//		sortBySuit();
//		boolean isFlush;
//		if (hand[0].getSuit() == hand[4].getSuit()) {
//			isFlush = true;
//		} else {
//			isFlush = false;
//		}
//		return isFlush;
//	}
//	//Returns true if this hand has 5 consecutive cards of any suit
//	public boolean hasStraight() {
//		sortByValue();
//		boolean isStraight;
//		if (hand[0].getValue() + 4 == hand[4].getValue() && hand[1].getValue() + 3 == hand[4].getValue() && 
//				hand[2].getValue() + 2 == hand[4].getValue() && hand[3].getValue() + 1 == hand[4].getValue()) {
//			isStraight = true;
//		} else {
//			isStraight = false;
//		}
//		return isStraight;
//	}
//	//Returns true if this hand has a triplet and a pair of different //values
//	public boolean hasFullHouse() {
//		sortByValue();
//		boolean isFullHouse;
//		if (hasTriplet() == true && numPairs() == 2) {
//			isFullHouse = true;
//		} else {
//			isFullHouse = false;
//		}
//		return isFullHouse;
//	}
//	//Returns true if this hand has 4 cards that are of the same value
//	public boolean hasFourOfAKind() {
//		sortByValue();
//		boolean isFourOfAKind;
//		if (hand[0].getValue() == hand[1].getValue() && hand[1].getValue() == hand[2].getValue()
//				&& hand[2].getValue() == hand[3].getValue()) {
//			isFourOfAKind = true;
//		} else if (hand[1].getValue() == hand[2].getValue() && hand[2].getValue() == hand[3].getValue()
//				&& hand[3].getValue() == hand[4].getValue()) {
//			isFourOfAKind = true;
//		} else {
//			isFourOfAKind = false;
//		}
//		return isFourOfAKind;
//	}
//	//Returns the card with the highest value in the hand. When there is
//	//more than one highest value card, you may return any one of them
//	public Card highestValue() {
//		sortByValue();
//		if (hand[0].getValue() == 1) {
//			return hand[0];
//		} else {
//			return hand[4];
//		}
//	}
//	//Returns the highest valued Card of any pair or triplet found, null if 
//	// none. When values are equal, you may return either
//	public Card highestDuplicate() {
//		sortByValue();
//
//		Card max = hand[0];
//		Card tripletMax = hand[0];
//		Card pairMax = hand[0];
//
//		if (hasTriplet() == true) {
//
//			if (hand[0].getValue() == hand[1].getValue() && hand[1].getValue() == hand[2].getValue()) {
//				tripletMax = hand[2];
//			} else if (hand[1].getValue() == hand[2].getValue() && hand[2].getValue() == hand[3].getValue()) {
//				tripletMax = hand[3];
//			} else if (hand[2].getValue() == hand[3].getValue() && hand[3].getValue() == hand[4].getValue()) {
//				tripletMax = hand[4];
//			}
//		} 
//
//		if (numPairs() > 0) {
//
//			if (numPairs() == 1) {
//				if (hand[0].getValue() == hand[1].getValue()) {
//					pairMax = hand[1];
//				} else if (hand[1].getValue() == hand[2].getValue()) {
//					pairMax = hand[2];
//				} else if (hand[2].getValue() == hand[3].getValue()) {
//					pairMax = hand[3];
//				} else if (hand[3].getValue() == hand[4].getValue()) {
//					pairMax = hand[4];
//				}
//
//			} else if (numPairs() == 2) {
//				if (hand[0].getValue() == hand[1].getValue() && hand[2].getValue() == hand[3].getValue()) {
//					pairMax = hand[3];
//				} else if (hand[1].getValue() == hand[2].getValue() && hand[3].getValue() == hand[4].getValue()) {
//					pairMax = hand[4];
//				}
//			}
//		}
//		if (tripletMax.getValue() >= pairMax.getValue()) {
//			max = tripletMax;
//		} else {
//			max = pairMax;
//		}
//
//		if (numPairs() == 0 && hasTriplet() == false) {
//			return null;
//		}
//		return max;
//	}
//
//	//Returns -1 if the instance hand loses to the parameter hand, 0 if 
//	//the hands are equal, and +1 if the instance hand wins over the 
//	//parameter hand. Hint: you might want to use some of the methods 
//	//above
//	public int compareTo(Hand h)  {
//
//
//		int result = 0;
//
//
//		if ((hasFlush() == true && hasStraight() == true) || (h.hasFlush() == true && h.hasStraight() == true)) {
//			//Royal Flush
//			if (hasFlush() == true && hasStraight() == true) {
//				if (h.hasFlush() ==  true && h.hasStraight() == true) {
//					sortByValue();
//					h.sortByValue();
//					if (hand[0].getValue() == 1 && hand[4].getValue() == 13) {
//						if (h.hand[0].getValue() == 1 && h.hand[4].getValue() == 13) {
//							result = 0;
//						} else {
//							result = +1;
//						}
//					} else if (h.hand[0].getValue() == 1 && h.hand[4].getValue() == 13) {
//						result = -1;
//					}
//				} else {
//					result = +1;
//				} 
//			} else if (h.hasFlush() == true && h.hasStraight() == true) {
//				result = -1;
//			}
//
//
//		} else if ((hasFlush() == true && hasStraight() == true) || (h.hasFlush() == true && h.hasStraight() == true)) {
//			//Straight Flush
//			if (hasFlush() == true && hasStraight() == true) {
//				if (h.hasFlush() == true && h.hasStraight() == true) {
//					sortByValue();
//					h.sortByValue();
//					if (hand[0].getValue() > h.hand[0].getValue()) {
//						result = +1;
//					} else if (hand[0].getValue() == h.hand[0].getValue()) {
//						result = 0;
//					} else if (hand[0].getValue() < h.hand[0].getValue()) {
//						result = -1;
//					}
//				} else {
//					result = +1;
//				}
//			} else if (h.hasFlush() == true && h.hasStraight() == true) {
//				result = -1;
//			}
//
//
//		} else if (hasFourOfAKind() == true || h.hasFourOfAKind() == true) {
//			//Four of a Kind
//			if (hasFourOfAKind() == true) {
//				if (h.hasFourOfAKind() == true) {
//					sortByValue();
//					h.sortByValue();
//					if (hand[0].getValue() == hand[1].getValue() && h.hand[0].getValue() == h.hand[1].getValue()) {
//						if (hand[0].getValue() > h.hand[0].getValue()) {
//							result = +1;
//						} else if (hand[0].getValue() == h.hand[0].getValue()) {
//							result = 0;
//						} else  if (hand[0].getValue() < h.hand[0].getValue()) {
//							result = -1;
//						}
//					} else if (hand[0].getValue() == hand[1].getValue() && h.hand[1].getValue() == h.hand[2].getValue()) {
//						if (hand[0].getValue() > h.hand[1].getValue()) {
//							result = +1;
//						} else if (hand[0].getValue() == h.hand[1].getValue()) {
//							result = 0;
//						} else if (hand[0].getValue() < h.hand[1].getValue()) {
//							result = -1;
//						}
//					} else if (hand[1].getValue() == hand[2].getValue() && h.hand[0].getValue() == h.hand[1].getValue()) {
//						if (hand[1].getValue() > h.hand[0].getValue()) {
//							result = +1;
//						} else if (hand[1].getValue() == h.hand[0].getValue()) {
//							result = 0;
//						} else if (hand[1].getValue() < h.hand[0].getValue()) {
//							result = -1;
//						}
//					} else if (hand[1].getValue() == hand[2].getValue() && h.hand[1].getValue() == h.hand[2].getValue()) {
//						if (hand[1].getValue() > h.hand[1].getValue()) {
//							result = +1;
//						} else if (hand[1].getValue() == h.hand[1].getValue()) {
//							result = 0;
//						} else if (hand[1].getValue() < h.hand[1].getValue()) {
//							result = -1;
//						}
//					}
//				} else {
//					result = +1;
//				}
//			} else if (h.hasFourOfAKind() == true) {
//				result = -1;
//			}
//
//
//		} else if (hasFullHouse() == true || h.hasFullHouse() == true) {
//			//Full House
//			if (hasFullHouse() == true) {
//				if (h.hasFullHouse() == true) {
//					sortByValue();
//					h.sortByValue();
//					if (hand[0].getValue() == 1 && h.hand[0].getValue() != 1) {
//						result = +1;
//					} else if (hand[0].getValue() != 1 && h.hand[0].getValue() == 1) {
//						result = -1;	
//					} else if (hand[0].getValue() == 1 && h.hand[0].getValue() == 1) {
//						result = 0;
//					}
//					if (hand[0].getValue() == hand[1].getValue() && hand[1].getValue() == hand[2].getValue()) {
//						if (h.hand[0].getValue() == h.hand[1].getValue() && h.hand[1].getValue() == h.hand[2].getValue()) {
//							if (hand[0].getValue() > h.hand[0].getValue()) {
//								result = +1;
//							} else if (hand[0].getValue() == h.hand[0].getValue()) {
//								result = 0;
//							} else if (hand[0].getValue() < h.hand[0].getValue()) {
//								result = -1;
//							}
//						} else if (hand[0].getValue() > h.highestDuplicate().getValue()) {
//							result = +1;
//						} else if (hand[0].getValue() == h.highestDuplicate().getValue()) {
//							result = 0;
//						} else if (hand[0].getValue() < h.highestDuplicate().getValue()) {
//							result = -1;
//						}
//					} else if (h.hand[0].getValue() == h.hand[1].getValue() && h.hand[1].getValue() == h.hand[2].getValue()) {
//						if (highestDuplicate().getValue() > h.hand[0].getValue()) {
//							result = +1;
//						} else if (highestDuplicate().getValue() == h.hand[0].getValue()) {
//							result = 0;
//						} else if (highestDuplicate().getValue() < h.hand[0].getValue()) {
//							result = -1;
//						}
//					} else {
//						if (highestDuplicate().getValue() > h.highestDuplicate().getValue()) {
//							result = +1;
//						} else if (highestDuplicate().getValue() == h.highestDuplicate().getValue()) {
//							result = 0;
//						} else if (highestDuplicate().getValue() < h.highestDuplicate().getValue()) {
//							result = -1;
//						}
//					}	
//				} else {
//					result = +1;
//				}
//			} else if (h.hasFullHouse()) {
//				result = -1;
//			}
//
//
//		} else if (hasFlush() == true || h.hasFlush() == true) {
//			//Flush
//			if (hasFlush() == true) {
//				if (h.hasFlush() == true) {
//					sortByValue();
//					h.sortByValue();
//					if (hand[0].getValue() == 1 && h.hand[0].getValue() != 1) {
//						result = +1;
//					} else if (hand[0].getValue() == 1 && h.hand[0].getValue() == 1) {
//						result = 0;
//					} else if (hand[0].getValue() != 1 && h.hand[0].getValue() == 1) {
//						result = -1;
//					} else if (hand[4].getValue() > h.hand[4].getValue()) {
//						result = +1;
//					} else if (hand[4].getValue() == h.hand[4].getValue()) {
//						result = 0;
//					} else if (hand[4].getValue() < h.hand[4].getValue()) {
//						result = -1;
//					}	
//				} else {
//					result = +1;
//				}	
//			} else if (h.hasFlush() == true) {
//				result = -1;
//			}
//
//
//		} else if (hasStraight() == true || h.hasStraight() == true) {
//			//Straight
//			if (hasStraight() == true) {
//				if (h.hasStraight() == true) {
//					sortByValue();
//					h.sortByValue();
//					if (hand[0].getValue() == 1 && h.hand[0].getValue() != 1) {
//						result = -1;
//					} else if (hand[0].getValue() == 1 && h.hand[0].getValue() == 1) {
//						result = 0;
//					} else if (hand[0].getValue() != 1 && h.hand[0].getValue() == 1) {
//						result = +1;
//
//					} else if (hand[0].getValue() > h.hand[0].getValue()) {
//						result = +1;
//					} else if (hand[0].getValue() == h.hand[0].getValue()) {
//						result = 0;
//					} else if (hand[0].getValue() < h.hand[0].getValue()) {
//						result = -1;
//					}			
//				} else {
//					result = +1;
//				}
//			} else if (h.hasStraight() == true) {
//				result = -1;
//			}
//
//
//		} else if (hasTriplet() == true || h.hasTriplet() == true) {
//			//Triplet
//			if (hasTriplet() == true) {
//				if (h.hasTriplet() == true) {
//					sortByValue();
//					h.sortByValue();
//					if (highestDuplicate().getValue() > h.highestDuplicate().getValue()) {
//						result = +1;
//					} else if (highestDuplicate().getValue() == h.highestDuplicate().getValue()) {
//						result = 0;
//					} else if (highestDuplicate().getValue() < h.highestDuplicate().getValue()) {
//						result = -1;
//					}	
//				} else {
//					result = +1;
//				}
//			} else if (h.hasTriplet() == true) {
//				result = -1;
//			}
//
//
//		} else if (numPairs() == 2 || h.numPairs() == 2) {
//			//Two Pairs
//			if (numPairs() == 2) {
//				if (h.numPairs() == 2) {
//					sortByValue();
//					h.sortByValue();
//					if (highestDuplicate().getValue() > h.highestDuplicate().getValue()) {
//						result = +1;
//					} else if (highestDuplicate().getValue() < h.highestDuplicate().getValue()) {
//						result = -1;
//					} else if (highestDuplicate().getValue() == h.highestDuplicate().getValue()) {
//						if (hand[2].getValue() == hand[3].getValue() && h.hand[2].getValue() == h.hand[3].getValue()) {
//							if (hand[0].getValue() > h.hand[0].getValue()) {
//								result = +1;
//							} else if (hand[0].getValue() == h.hand[0].getValue()) {
//								result = 0;
//							} else if (hand[0].getValue() < h.hand[0].getValue()) {
//								result = -1;
//							}
//						} else if (hand[2].getValue() == hand[3].getValue() && h.hand[2].getValue() != h.hand[3].getValue()) {
//							if (hand[0].getValue() > h.hand[4].getValue()) {
//								result = +1;
//							} else if (hand[0].getValue() == h.hand[4].getValue()) {
//								result = 0;
//							} else if (hand[0].getValue() < h.hand[4].getValue()) {
//								result = -1;
//							}
//						} else if (hand[2].getValue() != hand[3].getValue() && h.hand[2].getValue() != h.hand[3].getValue()) {
//							if (hand[4].getValue() > h.hand[4].getValue()) {
//								result = +1;
//							} else if (hand[4].getValue() == h.hand[4].getValue()) {
//								result = 0;
//							} else if (hand[4].getValue() < h.hand[4].getValue()) {
//								result = -1;
//							}
//						}
//					}
//				} else {
//					result = +1;
//				}
//			} else if (h.numPairs() == 2) {
//				result = -1;
//			}
//
//
//		} else if (numPairs() == 1 || h.numPairs() == 1) {
//			//One Pair
//			if (numPairs() == 1) {
//				if (h.numPairs() == 1) {
//					if (highestDuplicate().getValue() > h.highestDuplicate().getValue()) {
//						result = +1;
//					} else if (highestDuplicate().getValue() == h.highestDuplicate().getValue()) {
//						result = 0;
//					} else if (highestDuplicate().getValue() < h.highestDuplicate().getValue()) {
//						result = -1;
//					}
//				} else {
//					result = +1;
//				}
//			} else if (h.numPairs() == 1) {
//				result = -1;
//			}
//
//
//		} else {
//			//High Card
//			sortByValue();
//			h.sortByValue();
//			if (hand[4].getValue() > h.hand[4].getValue()) {
//				result = +1;
//			} else if (hand[4].getValue() < h.hand[4].getValue()) {
//				result = -1;
//			} else if (hand[4].getValue() == h.hand[4].getValue()) {
//				if (hand[3].getValue() > h.hand[3].getValue()) {
//					result = +1;
//				} else if (hand[3].getValue() < h.hand[3].getValue()) {
//					result = -1;
//				} else if (hand[3].getValue() == h.hand[3].getValue()) {
//					if (hand[2].getValue() > h.hand[2].getValue()) {
//						result = +1;
//					} else if (hand[2].getValue() < h.hand[2].getValue()) {
//						result = -1;
//					} else if (hand[2].getValue() == h.hand[1].getValue()) {
//						if (hand[1].getValue() > h.hand[4].getValue()) {
//							result = +1;
//						} else if (hand[1].getValue() < h.hand[1].getValue()) {
//							result = -1;
//						} else if (hand[1].getValue() == h.hand[1].getValue()) {
//							if (hand[0].getValue() > h.hand[0].getValue()) {
//								result = +1;
//							} else if (hand[0].getValue() < h.hand[0].getValue()) {
//								result = -1;
//							} else if (hand[0].getValue() == h.hand[0].getValue()) {
//								result = 0;
//							}
//						}
//					}
//				}
//			}
//		}
//		return result;
//	}
//}






/**
 * An object of type Hand represents a hand of cards.  The
 * cards belong to the class Card.  A hand is empty when it
 * is created, and any number of cards can be added to it.
 */

import java.util.ArrayList;

public class Hand {

   private Card[] hand;   // The cards in the hand.
   private int count; 
   
   /**
    * Create a hand that is initially empty.
    */
   public Hand() {
      hand = new Card[5];
	  count = 0;
   }
   
   /**
    * Remove all cards from the hand, leaving it empty.
    */
   public void clear() {
      for(int i=0 ; i<hand.length; i++){ hand[i] = null; }
	  count = 0;
   }
   
   /**
    * Add a card to the hand.  It is added at the end of the current hand.
    * @param c the non-null card to be added.
    * @throws NullPointerException if the parameter c is null.
    */
   public void addCard(Card c) {
      
	  for(int i=0 ; i<hand.length; i++){ 
		if (hand[i] == null){
			hand[i] = c;
			count = count + 1;
			break;
		}
	 }

	  
   }
   
   /**
    * Remove a card from the hand, if present.
    * @param c the card to be removed.  If c is null or if the card is not in 
    * the hand, then nothing is done.
    */
   public void removeCard(Card c) {

  for(int i=0 ; i<hand.length; i++){ 
    if (hand[i]!=null && hand[i].equals(c)){
      hand[i] = null;
      count = count-1;
    }
  }

   }
   
   /**
    * Remove the card in a specified position from the hand.
    * @param position the position of the card that is to be removed, where
    * positions are starting from zero.
    * @throws IllegalArgumentException if the position does not exist in
    * the hand, that is if the position is less than 0 or greater than
    * or equal to the number of cards in the hand.
    */
   public void removeCard(int position) {
      if (position < 0 || position >= hand.length)
         throw new IllegalArgumentException("Position does not exist in hand: "
               + position);
      hand[position] = null;
      count --;
   }
   /**
    * Returns the number of cards in the hand.
    */
   public int getCardCount() {
      return count;
   }
   
   /**
    * Gets the card in a specified position in the hand.  (Note that this card
    * is not removed from the hand!)
    * @param position the position of the card that is to be returned
    * @throws IllegalArgumentException if position does not exist in the hand
    */
   public Card getCard(int position) {
      if (position < 0 || position >= hand.length)
         throw new IllegalArgumentException("Position does not exist in hand: "
               + position);
       return hand[position];
   }
   
   /**
    * Sorts the cards in the hand so that cards of the same suit are
    * grouped together, and within a suit the cards are sorted by value.
    * Note that aces are considered to have the lowest value, 1.
    */
   public void sortBySuit() {
	  int size = count;
	  int nonnull = 0;
	  int index = 0;
	  
      Card[] newHand = new Card[5];
      while (size > 0) {
		 if (hand[nonnull] == null) { nonnull = nonnull+1; continue;}
         int pos = nonnull;  // Position of minimal card.
         Card c = hand[nonnull];  // Minimal card.
		 
         for (int i = nonnull+1; i < hand.length; i++) {
            Card c1 = hand[i];
			if (c1 != null){
				if ( c1.getSuit() < c.getSuit() ||
						(c1.getSuit() == c.getSuit() && c1.getValue() < c.getValue()) ) {
					pos = i;
					c = c1;
				}
			}
         }
         hand[pos] = null;
		 size = size - 1;
         newHand[index++] = c;
		 nonnull = 0;
      }
      hand = newHand;
   }
   
   /**
    * Sorts the cards in the hand so that cards of the same value are
    * grouped together.  Cards with the same value are sorted by suit.
    * Note that aces are considered to have the lowest value, 1.
    */
   public void sortByValue() {
	  int size = count;
	  int nonnull = 0;
	  int index = 0;
	  
      Card[] newHand = new Card[5];
      while (size > 0) {
		 if (hand[nonnull] == null) { nonnull = nonnull+1; continue;}
         int pos = nonnull;  // Position of minimal card.
         Card c = hand[nonnull];  // Minimal card.
		 
         for (int i = nonnull+1; i < hand.length; i++) {
            
			Card c1 = hand[i];
            if (c1 != null){
				if ( c1.getValue() < c.getValue() ||
						(c1.getValue() == c.getValue() && c1.getSuit() < c.getSuit()) ) {
					pos = i;
					c = c1;
				}
			}
         }
         hand[pos] = null;
		 size = size - 1;
         newHand[index++] = c;
		 nonnull = 0;
      }
      hand = newHand;
   }
   
   public void printHand(){
	   
	   for(int i=0; i<hand.length; i++){
		   if (hand[i] != null){
			   System.out.println(hand[i]);
		   }
	   }
	   System.out.println();
   }
 //Returns the number of pairs this hand contains(Works)
   public int numPairs() {
	sortByValue();
	   int count = 0;
	   for(int i = 0; i < 5 ; i++) {
		if (i + 1 == 5) {
			break;
		}
		else if (hand[i].getValue() == hand[i+1].getValue()) {
			   count++;
		   		i++; 
		   
		   }
	   }
	   return count;
	   
   }

   //Returns true if this hand has 3 cards that are of the same value(Works)
   public boolean hasTriplet() {
	   sortByValue();
	   if (hand[0].getValue() == hand[2].getValue()||hand[2].getValue() == hand[4].getValue() || hand[1].getValue() == hand[3].getValue()) {
		   return true;
	   }else {
		   return false;
	   }
   }
    
   //Returns true if this hand has all cards that are of the same suit(Works)
   public boolean hasFlush() {
	   sortBySuit();
	   if (hand[0].getSuit() == hand[4].getSuit()) {
		   return true;
	   }else {
		   return false;
	   }
   }

   //Returns true if this hand has 5 consecutive cards of any suit(Works)
   public boolean hasStraight() {
	sortByValue();
	if (hand[0].getValue() == 1 && hand[1].getValue() == 10 && hand[2].getValue() == 11 && hand[3].getValue() == 12 && hand[4].getValue() == 13 ){
		
		return true;
	}else if (hand[0].getValue() + 4 == hand[4].getValue() && 
	hand[1].getValue() + 3 == hand[4].getValue() && hand[2].getValue() + 2 == hand[4].getValue() &&
	hand[3].getValue() + 1 == hand[4].getValue() )
	   {
		   return true;
	   }else {
		   return false;
	   }
   }
    
   //Returns true if this hand has a triplet and a pair of different //values(works)
   public boolean hasFullHouse() {
	   boolean x = false;
	   sortByValue();
	   if (hand[0].getValue() == hand[2].getValue()||hand[2].getValue() == hand[4].getValue()) {
		  if(hand[0].getValue() == hand[2].getValue()) {
			  if (hand[3].getValue() == hand[4].getValue()) {
				  x = true;
			  }
		  }else if (hand[2].getValue() == hand[4].getValue()) {
			  if (hand[0].getValue() == hand[1].getValue()) {
			  	x = true;
			  }
		  }
		   
   }else {
	   x = false;
   }return x;
   }
   //Returns true if this hand has 4 cards that are of the same value(Works)
   public boolean hasFourOfAKind() {
	sortByValue() ; 
			if (hand[0].getValue() == hand[3].getValue() || hand[1].getValue() == hand[4].getValue()) {
				return true;
			}else {
				return false;
			}
   }
    
   //Returns the card with the highest value in the hand. When there is
   //more than one highest value card, you may return any one of them(Works)
   public Card highestValue() {
	   sortByValue();
	   if (hand[0].getValue() == 1) {
		   return hand[0];
	   }else {
		  return hand[4];
	  }
	  }
   
    
   //Returns the highest valued Card of any pair or triplet found, null if
   // none. When values are equal, you may return either(working)
   public Card highestDuplicate() {
	 if(numPairs() > 0) {
		 if (hand[0].getValue() == 1 && hand[0].getValue() == hand[1].getValue()) {
			 return hand[0];
		 }else {
			 for(int i = 4; i > 0 ; i--) {
				 if (hand[i].getValue() == hand[i-1].getValue()) {
					 return hand[i];
				 }
			 }
		 }
	 }else {
		 return null;
	 }
	return null;
   }
   
   
   //Returns -1 if the instance hand loses to the parameter hand, 0 if //the hands are equal, and +1 if the instance hand wins over the //parameter hand. Hint: you might want to use some of the methods //above
   public int compareTo(Hand h) {
	  int playerH= 0;
	  int playerHand = 0;
	  int x = 20;
	  
	  //h values
	  for (int i = 0; i < 1; i++) {
	  if (h.numPairs() == 1) {
		  playerH = 1400 + h.highestDuplicate().getValue();
	  }
	  if(h.numPairs() == 2) {
		  playerH = 100 + h.highestDuplicate().getValue();
	  }
	 if (h.hasTriplet() == true) {
		  playerH = 1600 + (h.highestDuplicate()).getValue();
	  }
	 if (h.hasStraight() == true) {
		  playerH = 1700 + (h.highestValue()).getValue();
	  }
	  if (h.hasFlush() == true) {
		  playerH = 1800 + (h.highestValue()).getValue();
	  }
	  if (h.hasFullHouse() == true) {
		  playerH = 1900 + (h.highestDuplicate()).getValue();
	  }
	   if (h.hasFourOfAKind() == true) {
		  playerH = 2000 + (h.highestDuplicate()).getValue();
	  }
	   if (h.hasFlush() == true && h.hasStraight() == true) {
		  playerH = 2100 + (h.highestValue()).getValue();
	  }
	   if (h.hasFourOfAKind() == false && h.hasFullHouse() == false && h.hasFlush() == false
			  && h.hasStraight() == false && h.hasTriplet() == false && h.numPairs() == 0 ) {
		  playerH = (h.highestValue()).getValue();
	  }	  
	  
	  //hand values
	  for (int j = 0; j < 1; j++) {
		  if (numPairs() == 1) {
			  playerHand = 1400 + highestDuplicate().getValue();
		  }
		  if(numPairs() == 2) {
			  playerHand = 1500 + highestDuplicate().getValue();
		  }
		  if (hasTriplet() == true) {
			  playerHand = 1600 + (highestDuplicate()).getValue();
		  }
		  if (hasStraight() == true) {
			  playerHand = 1700 + (highestValue()).getValue();
		  }
		 if (hasFlush() == true) {
			  playerHand = 1800 + (highestValue()).getValue();
		  }
		 if (hasFullHouse() == true) {
			  playerHand = 1900 + (highestDuplicate()).getValue();
		  }
		  if (hasFourOfAKind() == true) {
			  playerHand = 2000 + (highestDuplicate()).getValue();
		  }
		  if (hasFlush() == true && hasStraight() == true) {
			  playerHand = 2100 + (h.highestValue()).getValue();
		  }
		  if (hasFourOfAKind() == false && hasFullHouse() == false && hasFlush() == false
				  && hasStraight() == false && hasTriplet() == false && numPairs() == 0 ) {
			  playerHand = (highestValue()).getValue();
		  }	  
	  }
	  
	  
	  
	  
//This accounts for the aces
	  if ((highestValue()).getValue() == 1) {
		  playerHand += 13;
	  
	  }if (h.numPairs() > 0 && h.highestDuplicate().getValue() == 1) {
		  playerHand += 14;
	  }
	  
	  if ((hasTriplet() == true && (highestDuplicate()).getValue()== 1)) {
	  	  playerHand += 14;
  }
	  
	  if ((h.highestValue()).getValue() == 1) {
			  playerH += 13;
		  }
	  if (h.numPairs() > 0 && h.highestDuplicate().getValue() == 1) {
		  	playerH += 14;
	  }
	  
	  if ((h.hasTriplet() == true && (h.highestDuplicate()).getValue()== 1) ) {
		  	  playerH += 14;
	  }
	  
	 
	  
		  //comparing of hands
	  if (playerH > playerHand) {
		  x = -1;
	  }else if (playerHand > playerH) {
		  x = 1;
	  }else if ( playerHand == playerH) {
		  x = 0;
	  }
	  }
	return x;
	
	
	
	  
   }
   
}
