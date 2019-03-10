package com.example.androidlabs;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    private EditText email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.editText4);
        SharedPreferences sharedPrefs = getSharedPreferences("myPrefs", MODE_PRIVATE);
        String email = sharedPrefs.getString("myPrefs", "");

    }

    public void onClick(View view) {
        Intent intent = new Intent(this, ProfileActivity.class);
        final EditText email = findViewById(R.id.editText4);
        String emailText = email.getText().toString();
        intent.putExtra("email_Text", emailText);

        startActivity(intent);
    }

            @Override
    public void onPause() {
        super.onPause();
                SharedPreferences sharedPrefs =
                        getSharedPreferences("myPrefs", MODE_PRIVATE);
                SharedPreferences.Editor  editor = sharedPrefs.edit();
                editor.putString("email", email.getText().toString());
                editor.apply();
    }

}
