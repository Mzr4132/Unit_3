package com.example.friendsr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.util.Log;




import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Building an array and adding class Friend objects to them
        ArrayList<Friend> friends = new ArrayList<>();
        friends.add(new Friend("arya", "Hi I am Arya", getResources().getIdentifier("arya", "drawable", getPackageName())));
        friends.add(new Friend("cersei", "Hello this is my bio", getResources().getIdentifier("cersei", "drawable", getPackageName())));
        friends.add(new Friend("daenerys", "Hi I am Daenerys!!", getResources().getIdentifier("daenerys", "drawable", getPackageName())));
        friends.add(new Friend("jaime", "Hi I am Jaime", getResources().getIdentifier("jaime", "drawable", getPackageName())));
        friends.add(new Friend("jon", "Hello, this is my profile", getResources().getIdentifier("jon", "drawable", getPackageName())));
        friends.add(new Friend("jorah", "Insert unique message here ;)", getResources().getIdentifier("jorah", "drawable", getPackageName())));
        friends.add(new Friend("margaery", "Hi I am Margaery pleased to meet u", getResources().getIdentifier("margaery", "drawable", getPackageName())));
        friends.add(new Friend("melisandre", "Melisandre is here", getResources().getIdentifier("melisandre", "drawable", getPackageName())));
        friends.add(new Friend("sansa", "Sansa has arrived", getResources().getIdentifier("sansa", "drawable", getPackageName())));
        friends.add(new Friend("tyrion", "On creation biographies are added", getResources().getIdentifier("tyrion", "drawable", getPackageName())));
        FriendsAdapter adapter = new FriendsAdapter(this, R.layout.grid_item , friends);
        GridView grid = (GridView) findViewById(R.id.viewframe1);
        grid.setOnItemClickListener(new Griditemclicklistener());

        grid.setAdapter(adapter);
        //findViewById(R.id.viewframe1).setAdapter(adapter);

    }

    private class Griditemclicklistener implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Friend clickedFriend = (Friend) parent.getItemAtPosition(position);
            String kliklog = clickedFriend.getName();
            Log.d("Ayyy", kliklog);
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("clicked_friend", clickedFriend);
            startActivity(intent);

        }
    }

}

