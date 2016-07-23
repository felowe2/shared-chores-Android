package com.epicodus.sharedchores.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.epicodus.sharedchores.R;
import com.epicodus.sharedchores.models.Chore;
import com.epicodus.sharedchores.models.User;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class FriendListAdapter extends RecyclerView.Adapter<FriendListAdapter.FriendViewHolder> {

        private ArrayList<User> mFriends = new ArrayList<>();
        private Context mContext;

        public FriendListAdapter(Context context, ArrayList<User> friends) {
            mContext = context;
            mFriends = friends;
        }

        @Override
        public FriendListAdapter.FriendViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.friend_list, parent, false);
            FriendViewHolder viewHolder = new FriendViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(FriendListAdapter.FriendViewHolder holder, int position) {
            holder.bindFriend(mFriends.get(position));

        }

        @Override
        public int getItemCount() {
            return mFriends.size();
        }

        public class FriendViewHolder extends RecyclerView.ViewHolder{
            @Bind(R.id.friendName) TextView mFriendName;
            @Bind(R.id.friendEmail) TextView mFriendEmail;

            private Context mContext;

            public FriendViewHolder(View itemView) {
                super(itemView);
                ButterKnife.bind(this, itemView);
                mContext = itemView.getContext();
            }

            public void bindFriend(User friend) {
                mFriendName.setText(friend.getName());
                mFriendEmail.setText(friend.getEmail());
            }

        }
    }

