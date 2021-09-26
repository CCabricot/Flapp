package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ScoreActivity extends AppCompatActivity {
    //RecyclerView recyclerView;
    TextView textView;
    String[] scoreList;
    FirebaseFirestore db;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);



        //recyclerView = findViewById(R.id.recyclerviewScore);
        //recyclerView.setHasFixedSize(true);
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));
        textView = findViewById(R.id.textView);

        db = FirebaseFirestore.getInstance();
        DocumentReference compte = db.collection("flapp").document("compte");
        textView.setText("score");
        compte.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                String score = documentSnapshot.getString("id");
                textView.setText(score);
                //scoreList = documentSnapshot.get("score");
                //textView.setText(scoreList[0]);

            }
        });

    }

}
