package com.epicodus.sharedchores.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.epicodus.sharedchores.R;

import java.security.acl.Group;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Guest on 7/8/16.
 */
//public class GroupListAdapter extends RecyclerView.Adapter<GroupListAdapter.GroupViewHolder> {
//
//
//    private ArrayList<Group> mGroups = new ArrayList<>();
//
//    private Context mContext;
//
//    public GroupListAdapter(Context context, ArrayList<Group> groups) {
//        mContext = context;
//        mGroups = groups;
//    }
//
//    @Override
//    public GroupListAdapter.GroupViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.group_list, parent, false);
//        GroupViewHolder viewHolder = new GroupViewHolder(view);
//        return viewHolder;
//    }
//
//    @Override
//    public void onBindViewHolder(GroupListAdapter.GroupViewHolder holder, int position) {
//        holder.bindGroup(mGroups.get(position));
//    }
//
//    @Override
//    public int getItemCount() {
//        return mGroups.size();
//    }
//
//    public class GroupViewHolder extends RecyclerView.ViewHolder {
//
//        @Bind(R.id.groupNameTextView) TextView mGroupNameTextView;
//
//
//        private Context mContext;
//
//        public GroupViewHolder(View itemView) {
//            super(itemView);
//            ButterKnife.bind(this, itemView);
//            mContext = itemView.getContext();
//        }
//
//        public void bindGroup(Group group) {
//            mGroupNameTextView.setText(group.getName());
//
//        }
//    }
//}

public class GroupListAdapter extends RecyclerView.Adapter<GroupListAdapter.GroupViewHolder> {

    private ArrayList<Group> mGroups;
    private Context mContext;

    public GroupListAdapter(Context context, ArrayList<Group> groups) {
        mGroups = groups;
        mContext = context;
    }

    private Context getContext() {
        return mContext;
    }

    public static class GroupViewHolder extends RecyclerView.ViewHolder {
        public TextView mGroupNameInputField;
        public Button mCreateGroupButton;

        public GroupViewHolder(View itemView) {
            super(itemView);

            mGroupNameInputField = (TextView) itemView.findViewById(R.id.groupNameInputField);
            mCreateGroupButton = (Button) itemView.findViewById(R.id.createGroupButton);
        }

    }

    public GroupListAdapter.GroupViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View view = inflater.inflate(R.layout.group_list, parent, false);

        // Return a new holder instance
        GroupViewHolder viewHolder = new GroupViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(GroupListAdapter.GroupViewHolder viewHolder, int position) {
        // Get the data model based on position
       Group group = mGroups.get(position);

        // Set item views based on your views and data model
        TextView textView = viewHolder.mGroupNameInputField;
        textView.setText(group.getName());
//        Button button = viewHolder.messageButton;
//        button.setText("Message");
    }
    @Override
    public int getItemCount() {
        return mGroups.size();
    }

}
