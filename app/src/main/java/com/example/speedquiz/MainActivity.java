package com.example.speedquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    // Get elements
    private MaterialButton BT_new_player;
    private EditText ET_player1_name;
    private TextInputLayout ET_player1_name_layout;
    private EditText ET_player2_name;
    private TextInputLayout ET_player2_name_layout;
    private MaterialButton BT_start_new_game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BT_new_player = findViewById(R.id.main_button_new_player);
        ET_player1_name = findViewById(R.id.main_et_player1_name);
        ET_player1_name_layout = findViewById(R.id.main_et_player1_name_layout);
        ET_player2_name = findViewById(R.id.main_et_player2_name);
        ET_player2_name_layout = findViewById(R.id.main_et_player2_name_layout);
        BT_start_new_game = findViewById(R.id.main_button_start_mew_game);
    }

    @Override
    protected void onStart() {
        super.onStart();

        BT_new_player.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ET_player1_name_layout.getVisibility() == View.INVISIBLE) {
                    ET_player1_name_layout.setVisibility(View.VISIBLE);
                } else {
                    ET_player2_name_layout.setVisibility(View.VISIBLE);
                    BT_start_new_game.setVisibility(View.VISIBLE);
                }
            }
        });

        ET_player1_name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                BT_start_new_game.setEnabled(!s.toString().isEmpty() && !ET_player2_name.getText().toString().isEmpty());
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        ET_player2_name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                BT_start_new_game.setEnabled(!s.toString().isEmpty() && !ET_player1_name.getText().toString().isEmpty());
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        BT_start_new_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent GameActivity = new Intent(MainActivity.this, GameActivity.class);
                GameActivity.putExtra("player1_name", ET_player1_name.getText().toString());
                GameActivity.putExtra("player2_name", ET_player2_name.getText().toString());
                startActivity(GameActivity);
            }
        });
    }
}