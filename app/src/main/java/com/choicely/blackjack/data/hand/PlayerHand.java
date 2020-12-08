package com.choicely.blackjack.data.hand;

import android.view.View;

import com.choicely.blackjack.data.BJShoe;

/**
 * Created by Tommy on 7.12.2020.
 */

public class PlayerHand extends BJHand {

    public PlayerHand(BJShoe shoe) {
        super(shoe);
    }

    @Override
    protected void setStartingHand() {
        // player has two cards in their hand at start
        addCard();
        addCard();
    }

    public void compareToDealerHand(BJHand hand) {
        // TODO: set end status
    }

    @Override
    public void setActive(boolean active) {
        super.setActive(active);

        if (active) {
            setButtonListeners();
        }
    }

    private void setButtonListeners() {
        if (hitButton == null || doubleButton == null || splitButton == null ||
                insuranceButton == null || standButton == null) {
            return;
        }

        hitButton.setOnClickListener(this::onHitButtonClick);
        doubleButton.setOnClickListener(this::onDoubleButtonClick);
        splitButton.setOnClickListener(this::onSplitButtonClick);
        insuranceButton.setOnClickListener(this::onInsuranceButtonClick);
        standButton.setOnClickListener(this::onStandButtonClick);

    }

    private void onDoubleButtonClick(View view) {

    }

    private void onSplitButtonClick(View view) {

    }

    private void onStandButtonClick(View view) {
        onHandFinished();
    }

    private void onInsuranceButtonClick(View view) {

    }

    private void onHitButtonClick(View view) {
        if (getHandValue() <= 21) {

        }
        addCard();
    }
}
