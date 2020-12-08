package com.choicely.blackjack.data;

import com.choicely.blackjack.data.CardSuite.Suite;

import java.util.Collections;
import java.util.Stack;

/**
 * Created by Tommy on 7.12.2020.
 */

public class Deck {

    private final Stack<Card> cardStack = new Stack<>();

    public Deck() {
        for (Suite suite : Suite.values()) {
            for (int i = 2; i <= 14; i++) {
                cardStack.add(new Card(i, suite));
            }
        }
    }

    public Card getNextCard() {
        return cardStack.pop();
    }

    public void shuffle() {
        Collections.shuffle(cardStack);
    }

    public int getCardsLeft() {
        return cardStack.size();
    }

    public Stack<Card> getAllCards() {
        return cardStack;
    }

}
