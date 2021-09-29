package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ScoreActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    TextView textView;
    ArrayList<String> scoreList = new ArrayList<String>();
    FirebaseFirestore db;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        recyclerView = findViewById(R.id.recyclerview);

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

                textView.setText((String)scoreList.get(0));
                //recyclerView.a;



            }
        });

    }

}

