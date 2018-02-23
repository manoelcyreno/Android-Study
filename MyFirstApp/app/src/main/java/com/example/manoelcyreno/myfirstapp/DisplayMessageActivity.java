package com.example.manoelcyreno.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String inputFieldText = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        String message = null;

        switch (inputFieldText.toLowerCase()) {
            case "catia":
                message = "This is my wife";
                break;
            case "manoel":
                message = "This is me";
                break;
            case "manoela":
                message = "This is my baby";
                break;
            case "carla":
                message = "This is my sister in law";
                break;
            case "diogo":
                message = "This is my brother in law";
                break;
            case "cintia":
                message = "This is my sister in law";
                break;
            case "larissa":
                message = "This is my niece";
                break;
            case "eduarda":
                message = "This is my niece";
                break;
            case "lea":
                message = "This is my mother in law";
                break;
            case "fatima":
                message = "This is my mother";
                break;
            case "vera":
                message = "This is fat aunt";
                break;
            case "papai":
                message = "This is grandpa";
                break;
            default:
                message = "This is someone or something";
        }

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView);
        textView.setText(message);

    }
}
