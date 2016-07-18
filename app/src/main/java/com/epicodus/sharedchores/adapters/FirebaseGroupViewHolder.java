package com.epicodus.sharedchores.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.epicodus.sharedchores.Constants;
import com.epicodus.sharedchores.R;
import com.epicodus.sharedchores.models.Group;
import com.epicodus.sharedchores.ui.AddPeopleActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.parceler.Parcels;

import java.util.ArrayList;

/**
 * Created by flowe on 7/17/16.
 */
public class FirebaseGroupViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    View mView;
    Context mContext;

    public FirebaseGroupViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
        itemView.setOnClickListener(this);

    }

    public void bindGroup(Group group) {

     TextView groupName = (TextView) mView.findViewById(R.id.groupNameEditText);


        groupName.setText(group.getName());

//    mView.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//            Intent.addExtra(group);
//        }
//    });
}

    @Override
    public void onClick(View view) {

        final ArrayList<Group> groups = new ArrayList<>();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_GROUPS);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    groups.add(snapshot.getValue(Group.class));
                }

                int itemPosition = getLayoutPosition();


                Intent intent = new Intent(mContext, AddPeopleActivity.class);
                intent.putExtra("position", itemPosition + "");
                intent.putExtra("groups", Parcels.wrap(groups));

                mContext.startActivity(intent);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }
}



