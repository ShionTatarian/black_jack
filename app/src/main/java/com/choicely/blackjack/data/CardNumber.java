package com.choicely.blackjack.data;

import androidx.annotation.StringDef;

/**
 * Created by Tommy on 7.12.2020.
 */

public interface CardNumber {

    int getNumber();

    @StringDef(value = {"A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3", "2"})
    @interface CardNumberValue {
    }

    @CardNumberValue
    String getNumberValue();

}
