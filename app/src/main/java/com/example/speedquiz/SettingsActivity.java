package com.example.speedquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.slider.Slider;

public class SettingsActivity extends AppCompatActivity {
    Slider slider_question_speed;
    EditText ET_questions_number;
    MaterialButton BT_ok;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        slider_question_speed = findViewById(R.id.settings_slider_questions_speed);
        ET_questions_number = findViewById(R.id.settings_questions_number);
        BT_ok = findViewById(R.id.settings_button_ok);
    }

    @Override
    protected void onStart() {
        super.onStart();

        ET_questions_number.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().isEmpty()) {
                    BT_ok.setEnabled(true);
                } else {
                    BT_ok.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        BT_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        slider_question_speed.getValue(); // Get the value of the slider
    }
}