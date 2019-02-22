package com.example.friendsr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Intent intent = getIntent();
        Friend retrievedFriend = (Friend) intent.getSerializableExtra("clicked_friend");


        //We call the ID and then we getresources and drawable to get the picture
        ImageView image = findViewById(R.id.imageViewprofile);
        image.setImageDrawable(getResources().getDrawable(retrievedFriend.getDrawableId()));

        // Similarly we do this for name and bio but with an easier construction
        // personname does get re-used for setting up the ratingbar and innerclassratings
        String name = retrievedFriend.getName();
        TextView personname = (TextView) findViewById(R.id.textView6);
        personname.setText(retrievedFriend.getName());
        TextView extratext = (TextView) findViewById(R.id.textView7);
        extratext.setText(retrievedFriend.getBio());

        // sets up a rating bar
        RatingBar ratings = findViewById(R.id.ratingBar);
        ratings.setRating(retrievedFriend.getRating());
        ratings.setOnRatingBarChangeListener(new innerclassratings());
        SharedPreferences prefs = getSharedPreferences("settings", MODE_PRIVATE);
        float actualrating = prefs.getFloat(personname.getText().toString(), 0);

        if (actualrating > 0) {
            ratings.setRating(actualrating);
        }else {

        }      // String aStoredString = prefs.getString(..., ...);

    }
    private class innerclassratings implements RatingBar.OnRatingBarChangeListener {
        @Override
        public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
            TextView personname = (TextView) findViewById(R.id.textView6);
            SharedPreferences prefs = getSharedPreferences("settings", MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putFloat(personname.getText().toString(), rating);
            editor.apply();
        }
    }
}
