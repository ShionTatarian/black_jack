package com.choicely.blackjack.data;

/**
 * Created by Tommy on 7.12.2020.
 */

public interface CardSuite {

    public enum Suite {

        HEART, CLUB, SPADE, DIAMOND;

    }

    Suite getSuite();

}
