package com.example.myapplication;


import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Score implements Comparable<Score> {

    public String name;
    public String score;


    public Score(String name, String score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    @Override
    public int compareTo(Score s) {
        return getScore().compareTo(s.getScore());
    }


    public static ArrayList<Score> createScoresList() {
        FirebaseFirestore db;
        ArrayList<Score> scoreList = new ArrayList<Score>();

        db = FirebaseFirestore.getInstance();

        db.collection("flapp").get()
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                })
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {

                        ArrayList<String> score = new ArrayList<String>();
                        List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();

                        for (DocumentSnapshot d : list) {
                            score = (ArrayList)d.get("score");

                            for(int i=0; i<score.size();i++){
                                Score s =new Score(d.getId(),score.get(i));
                                scoreList.add(s);

                            }
                        }
                        Collections.sort(scoreList);
                        Collections.reverse(scoreList);
                    }

                } );


        return scoreList;
    }


}