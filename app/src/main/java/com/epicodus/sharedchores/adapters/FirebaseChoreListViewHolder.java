package com.epicodus.sharedchores.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.epicodus.sharedchores.R;
import com.epicodus.sharedchores.models.Chore;
import com.epicodus.sharedchores.ui.UserChoreDetailActivity;

import org.parceler.Parcels;

public class FirebaseChoreListViewHolder extends RecyclerView.ViewHolder{

    View mView;
    Context mContext;

    public FirebaseChoreListViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
    }

    public void bindChore(final Chore chore) {
        TextView choreTitle = (TextView) mView.findViewById(R.id.choreTitle);
        TextView choreDueDate = (TextView) mView.findViewById(R.id.choreDueDate);

        choreTitle.setText(chore.getTitle());
        choreDueDate.setText("due: " + chore.getDueDate());

        mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(mContext, UserChoreDetailActivity.class);
                intent.putExtra("chore", Parcels.wrap(chore));

                mContext.startActivity(intent);
            }
        });
    }

}
