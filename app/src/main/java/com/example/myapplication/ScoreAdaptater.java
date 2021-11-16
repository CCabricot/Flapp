package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class ScoreAdaptater  extends
            RecyclerView.Adapter<ScoreAdaptater.ViewHolder> {
        // Store a member variable for the contacts
        private List<Score> scores;
        private List<Score> scoreListFull;


        public ScoreAdaptater(List<Score> scores) {
            this.scores = scores ;
            this.scoreListFull=new ArrayList<>(scores);
        }

        // Provide a direct reference to each of the views within a data item
        // Used to cache the views within the item layout for fast access
        public class ViewHolder extends RecyclerView.ViewHolder {
            // Your holder should contain a member variable
            // for any view that will be set as you render a row
            public TextView nameTextView;
            public TextView scoreTextView;

            // We also create a constructor that accepts the entire item row
            // and does the view lookups to find each subview
            public ViewHolder(View itemView) {
                // Stores the itemView in a public final member variable that can be used
                // to access the context from any ViewHolder instance.
                super(itemView);

                nameTextView = itemView.findViewById(R.id.textView);
                scoreTextView = itemView.findViewById(R.id.textView2);
            }

        }
        @Override
        public ScoreAdaptater.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Context context = parent.getContext();
            LayoutInflater inflater = LayoutInflater.from(context);

            // Inflate the custom layout
            View scoreView = inflater.inflate(R.layout.score_row, parent, false);

            // Return a new holder instance
            ScoreAdaptater.ViewHolder viewHolder = new ScoreAdaptater.ViewHolder(scoreView);
            return viewHolder;
        }

        // Involves populating data into the item through holder
        @Override
        public void onBindViewHolder(ScoreAdaptater.ViewHolder holder, int position) {
            // Get the data model based on position
            Score scorePosition = scores.get(position);

            // Set item views based on your views and data model
            TextView textView = holder.nameTextView;
            textView.setText(scorePosition.getName());

            TextView textView2 = holder.scoreTextView;
            textView2.setText(scorePosition.getScore());


        }

        // Returns the total count of items in the list
        @Override
        public int getItemCount() {
            return scores.size();
        }

        public void filterList(ArrayList<Score> filteredList) {
            scores = filteredList;
            notifyDataSetChanged();
        }

}

