package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

public class KeyboardAvailability extends AppCompatActivity {

    private EditText playlistText;
    private Button createPlaylist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keyboard_availability);
        playlistText = (EditText) findViewById(R.id.editTextTextPersonName);
        createPlaylist = (Button) findViewById(R.id.button4);
        playlistText.addTextChangedListener(mTextWatcher);
    }

    TextWatcher mTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String playlistName = playlistText.getText().toString();
            if (playlistName.trim().length() != 0) createPlaylist.setEnabled(true);
            else createPlaylist.setEnabled(false);
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}