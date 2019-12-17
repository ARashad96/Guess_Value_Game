package com.arashad96.androiddeveloperintermidatekit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class Guess_Value_Game extends AppCompatActivity {
    Button github;
    Button info;
    EditText value;
    Button guess;
    int random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_guess__value__game);

        value = findViewById(R.id.value);
        guess = findViewById(R.id.guess);
        random = getRandomNumberInRange();
        guess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Log.d("check", "" + random);
                if (value.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Enter some value", Toast.LENGTH_SHORT).show();
                } else if (Integer.valueOf(value.getText().toString()) == random) {
                    Toast.makeText(getApplicationContext(), "Right play again", Toast.LENGTH_SHORT).show();
                    random = getRandomNumberInRange();
                } else if (Integer.valueOf(value.getText().toString()) > random) {
                    Toast.makeText(getApplicationContext(), "Lower", Toast.LENGTH_SHORT).show();
                } else if (Integer.valueOf(value.getText().toString()) < random) {
                    Toast.makeText(getApplicationContext(), "Higher", Toast.LENGTH_SHORT).show();
                }
            }
        });
        github = findViewById(R.id.github);
        github.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/ARashad96/Numbering_Shapes_Detector"));
                startActivity(intent);
            }
        });
        info = findViewById(R.id.info);
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new android.app.AlertDialog.Builder(Guess_Value_Game.this)
                        .setIcon(R.drawable.profile)
                        .setTitle("App info")
                        .setMessage("This app is generating a random number and you have to guess if it is right or not using buttons, toast, textview, edittext, random and linearlayout.")
                        .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        })
                        .show();
            }
        });
    }

    private static int getRandomNumberInRange() {
        int min = 0;
        int max = 20;
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}