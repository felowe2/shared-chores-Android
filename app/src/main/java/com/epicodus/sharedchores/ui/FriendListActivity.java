package com.epicodus.sharedchores.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.epicodus.sharedchores.Constants;
import com.epicodus.sharedchores.R;
import com.epicodus.sharedchores.adapters.FirebaseChoreListViewHolder;
import com.epicodus.sharedchores.adapters.FirebaseFriendListViewHolder;
import com.epicodus.sharedchores.models.Chore;
import com.epicodus.sharedchores.models.User;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class FriendListActivity extends AppCompatActivity {

//    ArrayList<String> friendList = new ArrayList<String>();

    private DatabaseReference mFriendReference;
    private FirebaseRecyclerAdapter mFirebaseAdapter;

    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;
    @Bind(R.id.friendListHeader) TextView mFriendListHeader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_list);
        ButterKnife.bind(this);


        mFriendReference = FirebaseDatabase
                .getInstance()
                .getReference(Constants.FIREBASE_CHILD_FRIENDS);

        setUpFirebaseAdapter();
    }

    private void setUpFirebaseAdapter() {
        mFirebaseAdapter = new FirebaseRecyclerAdapter<User, FirebaseFriendListViewHolder>
                (User.class, R.layout.friend_list, FirebaseFriendListViewHolder.class,
                        mFriendReference) {

            @Override
            protected void populateViewHolder(FirebaseFriendListViewHolder viewHolder, User model, int position) {
                viewHolder.bindFriend(model);
            }
        };
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mFirebaseAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mFirebaseAdapter.cleanup();
    }
}