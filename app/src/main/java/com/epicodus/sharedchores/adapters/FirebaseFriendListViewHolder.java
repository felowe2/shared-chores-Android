package com.epicodus.sharedchores.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.epicodus.sharedchores.R;
import com.epicodus.sharedchores.models.Chore;
import com.epicodus.sharedchores.models.User;
import com.epicodus.sharedchores.ui.AssignChoreActivity;
import com.epicodus.sharedchores.ui.UserChoreDetailActivity;

import org.parceler.Parcels;

public class FirebaseFriendListViewHolder extends RecyclerView.ViewHolder {

    View mView;
    Context mContext;

    public FirebaseFriendListViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
    }

    public void bindFriend(final User friend) {
        TextView friendName = (TextView) mView.findViewById(R.id.friendName);
        TextView friendEmail = (TextView) mView.findViewById(R.id.friendEmail);

        friendName.setText(friend.getName());
        friendEmail.setText(friend.getEmail());

        mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(mContext, AssignChoreActivity.class);
                intent.putExtra("friend", Parcels.wrap(friend));

                mContext.startActivity(intent);
            }
        });
    }
}
