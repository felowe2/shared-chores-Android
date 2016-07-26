package com.epicodus.sharedchores.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v4.print.PrintHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.epicodus.sharedchores.Constants;
import com.epicodus.sharedchores.R;
import com.epicodus.sharedchores.models.Chore;
import com.epicodus.sharedchores.models.User;
import com.epicodus.sharedchores.ui.AssignChoreActivity;
import com.epicodus.sharedchores.ui.UserChoreDetailActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.parceler.Parcels;

public class FirebaseFriendListViewHolder extends RecyclerView.ViewHolder {

    private User mFriend;

    View mView;
    Context mContext;

    public FirebaseFriendListViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
    }

    public void bindFriend(final User friend) {
        //mFriend = friend;
        TextView friendName = (TextView) mView.findViewById(R.id.friendName);
        TextView friendEmail = (TextView) mView.findViewById(R.id.friendEmail);

        friendName.setText(friend.getName());
        friendEmail.setText(friend.getEmail());

        mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//
//                FirebaseUser firebaseFriend = FirebaseAuth.getInstance().getCurrentUser();
//                String uid = firebaseFriend.getUid();
//
//                DatabaseReference friendRef = FirebaseDatabase
//                        .getInstance()
//                        .getReference(Constants.FIREBASE_CHILD_FRIENDS)
//                        .child(uid);
//
//                DatabaseReference pushRef = friendRef.push();
//                String pushId = pushRef.getKey();
//                mFriend.setPushId(pushId);
//                pushRef.setValue(mFriend);

                Intent intent = new Intent(mContext, AssignChoreActivity.class);
                intent.putExtra("friend", Parcels.wrap(friend));

                mContext.startActivity(intent);
            }
        });
    }
}
