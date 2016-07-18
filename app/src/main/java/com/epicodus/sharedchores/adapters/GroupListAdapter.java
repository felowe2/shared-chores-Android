package com.epicodus.sharedchores.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.epicodus.sharedchores.R;

import java.security.acl.Group;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class GroupListAdapter extends RecyclerView.Adapter<GroupListAdapter.GroupViewHolder> {

    private ArrayList<Group> mGroups;
    private Context mContext;

    public GroupListAdapter(Context context, ArrayList<Group> groups) {
        mGroups = groups;
        mContext = context;
    }


    public GroupListAdapter.GroupViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.group_list, parent, false);
        GroupViewHolder viewHolder = new GroupViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(GroupListAdapter.GroupViewHolder holder, int position) {
        holder.bindGroup(mGroups.get(position));
    }

    @Override
    public int getItemCount() {
        return mGroups.size();
    }


    public class GroupViewHolder extends RecyclerView.ViewHolder{
        @Bind(R.id.groupNameEditText) TextView mGroupName;

        private Context mContext;

        public GroupViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindGroup(Group group) {
            mGroupName.setText(group.getName());

        }
    }

}
