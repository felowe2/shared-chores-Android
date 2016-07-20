package com.epicodus.sharedchores.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.epicodus.sharedchores.Constants;
import com.epicodus.sharedchores.R;
import com.epicodus.sharedchores.models.Chore;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AssignChoreActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth mAuth;
    private DatabaseReference mDatabaseReference;
    private FirebaseRecyclerAdapter mFirebaseAdapter;
   private Chore chore;
    View mView;
    Context mContext;

    @Bind(R.id.createChoreHeader)
    TextView mCreateChoreHeader;
    @Bind(R.id.choreTitleEditText)
    EditText mChoreTitleEditText;
    @Bind(R.id.choreDoerEditText)
    EditText mChoreDoerEditText;
    @Bind(R.id.choreDescriptionEditText)
    EditText mChoreDescriptionEditText;
    @Bind(R.id.choreDueDateEditText)
    EditText mChoreDueDateEditText;
    @Bind(R.id.createChoreButton)
    Button mCreateChoreButton;
//    @Bind(R.id.choreSummaryHeader) TextView mChoreHeader;
//    @Bind(R.id.choreDoerTextView) TextView mChoreDoerTextView;
//    @Bind(R.id.choreDescriptionTextView) TextView mChoreDescriptionTextView;
//    @Bind(R.id.choreDueDateTextView) TextView mChoreDueDateTextView;
//    @Bind(R.id.assignChoreButton) Button mAssignChoreButton;

    ArrayList<String> userChore = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assign_chore);

        ButterKnife.bind(this);


//FONTS EVERYTHING

        Typeface boldieFont = Typeface.createFromAsset(getAssets(), "fonts/Boldie.ttf");
//        mCreateChoreHeader.setTypeface(boldieFont);
//        mCreateChoreButton.setTypeface(boldieFont);
//        mChoreHeader.setTypeface(boldieFont);
// END OF FONTS

        mAuth = FirebaseAuth.getInstance();
        mDatabaseReference = FirebaseDatabase
                .getInstance()
                .getReference(Constants.FIREBASE_CHILD_CHORES);
        mDatabaseReference.addValueEventListener(choreListener);


        mCreateChoreButton.setOnClickListener(this);
    }

    ValueEventListener choreListener = new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                chore = snapshot.getValue(Chore.class);

            }
//            mGroupNameTextView.setText(group.getName());

        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }

    };

    @Override
    public void onClick(View view) {
        if (view == mCreateChoreButton) {
            createNewChore();

        }
//        if (view == mGroupNameTextView) {
//            Intent intent = new Intent(CreateGroupActivity.this, AddPeopleActivity.class);
//            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//            intent.putExtra("group", Parcels.wrap(group));
//            startActivity(intent);
//            finish();
//
////            Intent intent = new Intent(CreateGroupActivity.this, AddPeopleActivity.class);
////           intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
////           intent.putExtra("groupName", group.getName());
////           startActivity(intent);
////            finish();
//        }
    }

    private void createNewChore() {
        String title = mChoreTitleEditText.getText().toString();
        String description = mChoreDescriptionEditText.getText().toString();
        String doer = mChoreDoerEditText.getText().toString();
        String dueDate = mChoreDueDateEditText.getText().toString();


        Chore newChore = new Chore(title, description, doer, dueDate);
        DatabaseReference choreRef = FirebaseDatabase
                .getInstance()
                .getReference(Constants.FIREBASE_CHILD_CHORES)
                .push();
        String pushId = choreRef.getKey();
        newChore.setPushId(pushId);
        choreRef.setValue(newChore);
    }
}
//