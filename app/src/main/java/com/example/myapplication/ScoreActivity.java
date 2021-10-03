package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;

import android.widget.LinearLayout;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class ScoreActivity extends AppCompatActivity {

    ArrayList<Score> scoreList;
    FirebaseFirestore db;
    LinearLayout scoreLayout;

    protected void onCreate(Bundle savedInstanceState) {
        // ...
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        // Lookup the recyclerview in activity layout
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        // Initialize contacts
        scoreList = Score.createScoresList();
        // Create adapter passing in the sample user data
        ScoreAdaptater adapter = new ScoreAdaptater(scoreList);
        // Attach the adapter to the recyclerview to populate items
        recyclerView.setAdapter(adapter);
        // Set layout manager to position the items
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // That's all!

        /*
        //recyclerView = findViewById(R.id.recyclerview);
        scoreLayout = findViewById(R.id.scoreLayout);
        scoreRow = findViewById(R.id.scoreRow);
        db = FirebaseFirestore.getInstance();
        DocumentReference compte = db.collection("flapp").document("compte");


        compte.get().addOnSuccessListener(new OnSuccessListener <DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

                // Recuperer les data de la liste "score" de firestore
                scoreList = (ArrayList) documentSnapshot.get("score");

                //Ordre decroissant
                Collections.sort(scoreList);
                Collections.reverse(scoreList);

                for(int i=0;i<10;i++) {

                    text.setText(i);

                    LayoutInflater inflater = getLayoutInflater();
                    View myLayout = inflater.inflate(R.layout.score_row,scoreLayout,false);


                    scoreLayout.addView(myLayout);
                }


            }
        });
        */


    }
}


