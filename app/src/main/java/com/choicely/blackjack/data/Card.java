package com.choicely.blackjack.data;

import androidx.annotation.IntRange;

/**
 * Created by Tommy on 7.12.2020.
 */

public class Card implements CardSuite, CardNumber, BlackJackValue, Comparable<Card> {

    @IntRange(from = 1, to = 14)
    private int number;
    private Suite suite;

    public Card(int number, Suite suite) {
        this.number = number;
        this.suite = suite;
    }

    @Override
    public int getBJValue() {
        int retVal;
        switch (number) {
            case 14:
                retVal = 1;
                break;
            case 11:
            case 12:
            case 13:
                retVal = 10;
                break;
            default:
                retVal = number;

        }
        return retVal;
    }

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public String getNumberValue() {
        String retVal;
        switch (number) {
            case 1:
            case 14:
                retVal = "A";
                break;
            case 11:
                retVal = "J";
                break;
            case 12:
                retVal = "Q";
                break;
            case 13:
                retVal = "K";
                break;
            default:
                retVal = String.valueOf(number);
                break;
        }
        return retVal;
    }

    @Override
    public Suite getSuite() {
        return suite;
    }

    private int getCompareValue() {
        int compVal = number;

        switch (suite) {
            case HEART:
                compVal += 400;
                break;
            case SPADE:
                compVal += 300;
                break;
            case DIAMOND:
                compVal += 200;
                break;
            case CLUB:
                compVal += 100;
                break;


        }

        return compVal;
    }

    @Override
    public int compareTo(Card c2) {
        return Integer.compare(getCompareValue(), c2.getCompareValue());
    }
}
