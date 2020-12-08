package com.choicely.blackjack.data;

import androidx.annotation.IntRange;

/**
 * Created by Tommy on 7.12.2020.
 */

public interface BlackJackValue {

    @IntRange(from = 1, to = 10)
    int getBJValue();

}
