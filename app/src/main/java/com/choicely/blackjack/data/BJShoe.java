package com.choicely.blackjack.data;

import java.util.Collections;
import java.util.Stack;

/**
 * Created by Tommy on 7.12.2020.
 */

public class BJShoe {

    private final int deckCount;
    private final Stack<Card> cardStack = new Stack<>();


    public BJShoe(int deckCount) {
        this.deckCount = deckCount;
        reset();
    }

    public Card getNextCard() {
        return cardStack.pop();
    }

    public void reset() {
        for (int i = 0; i < deckCount; i++) {
            cardStack.addAll(new Deck().getAllCards());
        }
        shuffle();
    }

    public void shuffle() {
        Collections.shuffle(cardStack);
    }

    public int getCardsLeft() {
        return cardStack.size();
    }

}
