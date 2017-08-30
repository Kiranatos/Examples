package junk.prometeus.two;

//package com.tasks3.carddeck;

public class Deck {   
    
    private boolean randomize = false;
    
    private Card[] mainDeck = new Card[] {
        new Card(Rank.SIX,      Suit.SPADES),
        new Card(Rank.SEVEN,    Suit.SPADES),
        new Card(Rank.EIGHT,    Suit.SPADES),
        new Card(Rank.NINE,     Suit.SPADES),
        new Card(Rank.TEN,      Suit.SPADES),
        new Card(Rank.JACK,     Suit.SPADES),
        new Card(Rank.QUEEN,    Suit.SPADES),
        new Card(Rank.KING,     Suit.SPADES),
        new Card(Rank.ACE,      Suit.SPADES),
        
        new Card(Rank.SIX,      Suit.CLUBS),
        new Card(Rank.SEVEN,    Suit.CLUBS),
        new Card(Rank.EIGHT,    Suit.CLUBS),
        new Card(Rank.NINE,     Suit.CLUBS),
        new Card(Rank.TEN,      Suit.CLUBS),
        new Card(Rank.JACK,     Suit.CLUBS),
        new Card(Rank.QUEEN,    Suit.CLUBS),
        new Card(Rank.KING,     Suit.CLUBS),
        new Card(Rank.ACE,      Suit.CLUBS),
        
        new Card(Rank.SIX,      Suit.DIAMONDS),
        new Card(Rank.SEVEN,    Suit.DIAMONDS),
        new Card(Rank.EIGHT,    Suit.DIAMONDS),
        new Card(Rank.NINE,     Suit.DIAMONDS),
        new Card(Rank.TEN,      Suit.DIAMONDS),
        new Card(Rank.JACK,     Suit.DIAMONDS),
        new Card(Rank.QUEEN,    Suit.DIAMONDS),
        new Card(Rank.KING,     Suit.DIAMONDS),
        new Card(Rank.ACE,      Suit.DIAMONDS),
        
        new Card(Rank.SIX,      Suit.HEARTS),
        new Card(Rank.SEVEN,    Suit.HEARTS),
        new Card(Rank.EIGHT,    Suit.HEARTS),
        new Card(Rank.NINE,     Suit.HEARTS),
        new Card(Rank.TEN,      Suit.HEARTS),
        new Card(Rank.JACK,     Suit.HEARTS),
        new Card(Rank.QUEEN,    Suit.HEARTS),
        new Card(Rank.KING,     Suit.HEARTS),
        new Card(Rank.ACE,      Suit.HEARTS),
    };    
    

	//Перемішує колоду у випадковому порядку
	public void shuffle() {
            randomize = true;
	}
	
	/*
	 * Впорядкування колоди за мастями та значеннями
	 * Порядок сотрування:
	 * 		Спочатку всі карти з мастю SPADES потім CLUBS, DIAMONDS, HEARTS
	 * 		для кожної масті порядок наступний: 6, 7, 8, 9, 10, Jack, Queen, King, Ace
	 * Наприклад
	 * 		SPADES  6
	 *		SPADES  7
	 *		SPADES  8
	 *		SPADES  9
	 *		SPADES  10
	 *		SPADES  Jack
	 *		SPADES  Queen
	 *		SPADES  King
	 *		SPADES  Ace
	 * І так далі для CLUBS, DIAMONDS, HEARTS	
	 */
	public void order(){
            randomize = false;            
	}
	
	//Повертає true у випадку коли в колоді ще доступні карти
	public boolean hasNext() {                        
            for (int i=0; i < mainDeck.length; i++) {
                if ( mainDeck[i]!=null ) return true;
            }            
            return false;
	}

	//"Виймає" одну карту з колоди, коли буде видано всі 36 карт повертає null  
	public Card drawOne() {           
            
            if (!hasNext()) return null;
            
            if (!randomize) {
                for (int i=0; i < mainDeck.length; i++) {
                    if ( mainDeck[i] != null ) {
                        Card c = mainDeck[i];
                        mainDeck[i] = null;
                        return c;
                    }
                }                            
            } else {        
                int p = (int)(Math.random()* mainDeck.length);
                while (mainDeck[p]==null){
                    //System.out.print(" [" + p + "] ");
                    p = (int)(Math.random()* mainDeck.length);
                }
                
                
                Card c = mainDeck[p];
                mainDeck[p] = null;
                return c;               
            }
            
            return null; 
	}
}  
      