package com.choicely.blackjack.data.hand;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.choicely.blackjack.R;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Tommy on 7.12.2020.
 */

public class HandUI {

    @Nullable
    protected Button hitButton;
    @Nullable
    protected Button standButton;
    @Nullable
    protected Button insuranceButton;
    @Nullable
    protected Button doubleButton;
    @Nullable
    protected Button splitButton;

    protected TextView handValueText;
    protected RecyclerView cardRecycler;
    private View splitLayout;

    public void findButtonsFromView(View v) {
        hitButton = v.findViewById(R.id.bj_hit_button);
        standButton = v.findViewById(R.id.bj_stand_button);
        insuranceButton = v.findViewById(R.id.bj_insurance_button);
        doubleButton = v.findViewById(R.id.bj_double_button);
        splitButton = v.findViewById(R.id.bj_split_button);
    }

    public void findHandSpecificViewsFromView(View v) {
        handValueText = v.findViewById(R.id.bj_hand_size_text);
        cardRecycler = v.findViewById(R.id.bj_hand_card_recycler);
    }

    public void setSplitLayout(View v) {
        splitLayout = v;
    }

}
