package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.Collections;

public class ScoreActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.helloworld.MESSAGE";

    ArrayList<Score> scoreList;
    EditText editText;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        // Lookup the recyclerview in activity layout
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        editText = findViewById(R.id.editText);


        // Initialize contacts
        scoreList = Score.createScoresList();
        // Create adapter passing in the sample user data
        ScoreAdaptater adapter = new ScoreAdaptater(scoreList);
        // Attach the adapter to the recyclerview to populate items
        recyclerView.setAdapter(adapter);
        // Set layout manager to position the items
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // That's all!

    }
    public void sendMessage(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, ScoreActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }
}


