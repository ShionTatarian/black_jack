package com.choicely.blackjack;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.choicely.blackjack.data.BJShoe;
import com.choicely.blackjack.data.hand.BJHand;
import com.choicely.blackjack.data.hand.BJHand.OnHandPlayedListener;
import com.choicely.blackjack.data.hand.DealerHand;
import com.choicely.blackjack.data.hand.PlayerHand;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private BJShoe shoe;

    private Stack<BJHand> handStack = new Stack<>();
    private List<PlayerHand> currentAndCompletedPlayerHands = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.black_jack_game_layout);

        shoe = new BJShoe(2);
    }

    public void onNewGameClick(View view) {
        Log.d(TAG, "onNewGameClick");

        DealerHand dealerHand = new DealerHand(shoe);
        dealerHand.findHandSpecificViewsFromView(findViewById(R.id.bj_dealers_hand_layout));
        dealerHand.onDataChanged();
        handStack.add(dealerHand);

        PlayerHand playerMainHand = new PlayerHand(shoe);
        playerMainHand.findButtonsFromView(findViewById(R.id.bj_players_hand_layout));
        playerMainHand.findHandSpecificViewsFromView(findViewById(R.id.bj_hand_1_layout));
        playerMainHand.setSplitLayout(findViewById(R.id.bj_hand_2_layout));
        playerMainHand.setOnHandPlayerListener(onHandPlayedListener);
        playerMainHand.onDataChanged();
        handStack.add(playerMainHand);

        activateNextHand();
    }

    private OnHandPlayedListener onHandPlayedListener = hand -> {
        if (hand instanceof DealerHand) {
            // game is over
            handleResult((DealerHand) hand);
        } else {
            activateNextHand();
        }

    };

    private void handleResult(DealerHand dealerHand) {
        for (PlayerHand playerHand : currentAndCompletedPlayerHands) {
            playerHand.compareToDealerHand(dealerHand);
        }
    }

    private void activateNextHand() {
        BJHand nextHand = handStack.pop();
        if (nextHand instanceof PlayerHand) {
            currentAndCompletedPlayerHands.add((PlayerHand) nextHand);
        }
        nextHand.setActive(true);
    }

    private void updateContent() {

    }


}