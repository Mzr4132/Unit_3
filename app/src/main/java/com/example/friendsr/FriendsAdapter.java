package com.example.friendsr;
import android.view.LayoutInflater;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.support.annotation.Nullable;
import android.support.annotation.NonNull;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;


public class FriendsAdapter extends ArrayAdapter<Friend> {
    private ArrayList<Friend> friends;
    public FriendsAdapter(Context context, int resource, ArrayList<Friend> objects) {
        super(context, resource, objects);
        friends = objects;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //return super.getView(position, convertView, parent);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.grid_item, parent, false);
        }
        Friend friend = friends.get(position);
        TextView text = convertView.findViewById(R.id.texframe1);
        ImageView image = convertView.findViewById(R.id.viewframe2);

        // set text and image
        text.setText(friend.getName());
        image.setImageResource(friend.getDrawableId());
        return convertView;
    }
}
