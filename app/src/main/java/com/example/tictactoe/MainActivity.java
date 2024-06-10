package com.example.tictactoe;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TicTacT ticgame;

    Button buttonRestart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        ticgame = new TicTacT();

        buttonRestart = findViewById(R.id.buttonnew);
        buttonRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(getIntent());
                overridePendingTransition(0,0);
            }
        });

    }

    public void buttonClick(View v) {
        Button button = (Button) v;
        int buttonId = v.getId();
        String buttonIdString = getResources().getResourceEntryName(buttonId).replace("button", "");
        int line = Character.getNumericValue(buttonIdString.charAt(0)) - 1;
        int column = Character.getNumericValue(buttonIdString.charAt(1)) - 1;
        button.setText(String.valueOf(ticgame.getCurrentPlayer()));
        ticgame.getBoard()[line][column] = ticgame.getCurrentPlayer();
        if (ticgame.checkWin()) {
            Toast.makeText((Context) this, "Laimėjo žaidėjas " + ticgame.getCurrentPlayer() + " !", Toast.LENGTH_SHORT).show();
            return;
        }
        if (ticgame.isBoardFull()) {
            Toast.makeText((Context) this, "Žaidimas baigtas.Lygiosios", Toast.LENGTH_SHORT).show();
            return;
        }
        v.setEnabled(false);
        button.setTextColor(Color.WHITE);
        ticgame.switchPlayer();
    }


}