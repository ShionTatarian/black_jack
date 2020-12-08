package com.choicely.blackjack.data.hand;

import android.util.Log;

import com.choicely.blackjack.data.BJShoe;
import com.choicely.blackjack.data.Card;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;

/**
 * Created by Tommy on 7.12.2020.
 */

public abstract class BJHand extends HandUI {

    private static final String TAG = "BJHand";
    private OnHandPlayedListener onHandPlayedListener;

    private final BJShoe shoe;

    protected final List<Card> cards = new ArrayList<>();

    protected boolean isActive;

    @Nullable
    private HandStatus status = null;

    public enum HandStatus {

        WIN, LOSS, DRAW

    }

    public BJHand(BJShoe shoe) {
        this.shoe = shoe;

        setStartingHand();
        onDataChanged();
    }

    protected abstract void setStartingHand();

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;

        onDataChanged();
    }

    public void addCard() {
        cards.add(shoe.getNextCard());

        onDataChanged();
    }

    @Nullable
    public HandStatus getStatus() {
        return status;
    }

    protected void setStatus(HandStatus status) {
        this.status = status;
    }

    protected void onHandFinished() {
        if (onHandPlayedListener != null) {
            onHandPlayedListener.onHandPlayed(this);
        }
    }

    public List<Card> getCards() {
        return cards;
    }

    public int getHandValue() {
        int totalValue = 0;
        for (Card c : cards) {
            totalValue += c.getBJValue();
        }

        return totalValue;
    }

    /**
     * This method should be called when ever anything changes in this hand.
     */
    public void onDataChanged() {
        if (handValueText != null) {
            Log.d(TAG, "handValue: " + getHandValue());
            handValueText.setText(String.valueOf(getHandValue()));
        }

    }

    public void setOnHandPlayerListener(OnHandPlayedListener listener) {
        this.onHandPlayedListener = listener;
    }

    public interface OnHandPlayedListener {

        void onHandPlayed(BJHand hand);

    }


}
