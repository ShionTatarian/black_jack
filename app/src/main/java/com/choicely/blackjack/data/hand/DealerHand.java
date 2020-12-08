package com.choicely.blackjack.data.hand;

import android.util.Log;

import com.choicely.blackjack.data.BJShoe;

import java.util.logging.Handler;

/**
 * Created by Tommy on 7.12.2020.
 */

public class DealerHand extends BJHand {

    private static final String TAG = "DealerHand";

    public DealerHand(BJShoe shoe) {
        super(shoe);
    }

    @Override
    protected void setStartingHand() {
        // dealer has one cards in their hand at start
        addCard();
    }

    @Override
    public void setActive(boolean active) {
        super.setActive(active);

        if (active) {
            play();
        }
    }

    private void play() {
        Log.d(TAG, "Dealer playing, from hand value: " + getHandValue());
        if (getHandValue() < 17) {
            addCard();
            handValueText.postDelayed(this::play, 1000);
        } else {
            Log.d(TAG, "Dealer has finished");
            onHandFinished();
        }

    }
}
