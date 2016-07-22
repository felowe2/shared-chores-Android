package com.epicodus.sharedchores.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.epicodus.sharedchores.R;
import com.epicodus.sharedchores.models.Chore;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Guest on 7/22/16.
 */
public class ChoreListAdapter extends RecyclerView.Adapter<ChoreListAdapter.ChoreViewHolder> {

    private ArrayList<Chore> mChores = new ArrayList<>();
    private Context mContext;

    public ChoreListAdapter(Context context, ArrayList<Chore> chores) {
        mContext = context;
        mChores = chores;
    }

    @Override
    public ChoreListAdapter.ChoreViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chore_list, parent, false);
        ChoreViewHolder viewHolder = new ChoreViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ChoreListAdapter.ChoreViewHolder holder, int position) {
        holder.bindChore(mChores.get(position));

    }

    @Override
    public int getItemCount() {
        return mChores.size();
    }

    public class ChoreViewHolder extends RecyclerView.ViewHolder{
        @Bind(R.id.choreTitle) TextView mChoreTitle;
        @Bind(R.id.choreDueDate) TextView mChoreDueDate;

        private Context mContext;

        public ChoreViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindChore(Chore chore) {
            mChoreTitle.setText(chore.getTitle());
            mChoreDueDate.setText(chore.getDueDate());
        }
    }
}
