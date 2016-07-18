package com.epicodus.sharedchores.ui;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
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
import com.epicodus.sharedchores.adapters.FirebaseGroupListViewHolder;
import com.epicodus.sharedchores.models.Group;
import com.epicodus.sharedchores.models.User;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CreateGroupActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private DatabaseReference mGroupReference;
    private FirebaseRecyclerAdapter mFirebaseAdapter;
    private Group mGroup;

    ArrayList<String> mGroups = new ArrayList<String>();

//    @Bind(R.id.bottomBar)
//    TextView mButtomBar;
    @Bind(R.id.createGroupHeader)
    TextView mCreateGroupHeader;
    @Bind(R.id.createGroupButton)
    Button mCreateGroupButton;
    @Bind(R.id.groupHeader)
    TextView mGroupHeader;
    @Bind(R.id.recyclerView)
    ListView mRecyclerView;
    @Bind(R.id.groupName)
    EditText mGroupName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_group);

        ButterKnife.bind(this);

        mAuth = FirebaseAuth.getInstance();
        createAuthStateListener();


//FONTS EVERYTHING
        Typeface boldieFont = Typeface.createFromAsset(getAssets(), "fonts/Boldie.ttf");
        mCreateGroupHeader.setTypeface(boldieFont);
        mCreateGroupButton.setTypeface(boldieFont);
        mGroupHeader.setTypeface(boldieFont);
// END OF FONTS


        mCreateGroupButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (v == mCreateGroupButton) {
                    createNewGroup();
                }
                }
            private void createNewGroup() {
                String group = mGroupName.getText().toString().trim();
            }
                            public void onComplete(@NonNull Task<AuthResult> task) {

                            }
                        });
    }

    private void createAuthStateListener() {

        mAuthListener = new FirebaseAuth.AuthStateListener() {

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                final FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                if (firebaseUser != null) {
                    Group group = new Group(firebaseUser.getDisplayName());
                    String uid = firebaseUser.getUid();
                    DatabaseReference ref = FirebaseDatabase
                            .getInstance()
                            .getReference(Constants.FIREBASE_CHILD_GROUPS)
                            .child(uid);
                    ref.setValue(group);

//
//                    Intent intent = new Intent(CreateGroupActivity.this, AddPeopleActivity.class);
//                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                    startActivity(intent);
//                    finish();
                }
            }

        };

    }
    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }
}

