//package com.epicodus.sharedchores.ui;
//
//import android.content.Intent;
//import android.graphics.Typeface;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.ListView;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.epicodus.sharedchores.Constants;
//import com.epicodus.sharedchores.R;
//import com.epicodus.sharedchores.models.Group;
//import com.epicodus.sharedchores.models.User;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//
//import org.parceler.Parcels;
//
//import java.util.ArrayList;
//
//import butterknife.Bind;
//import butterknife.ButterKnife;
//
//public class AddPeopleActivity extends AppCompatActivity implements View.OnClickListener {
//    ArrayList<String> listOfPeopleAddedToGroup = new ArrayList<String>();
//    private Group group;
//
//    @Bind(R.id.addPeopleHeader)
//    TextView mAddPeopleHeader;
//    @Bind(R.id.addPersonNameInputField)
//    EditText mAddPersonNameInputField;
//    @Bind(R.id.addPersonButton)
//    Button mAddPersonButton;
//    @Bind(R.id.peopleAddedHeader)
//    TextView mPeopleAddedHeader;
//    @Bind(R.id.peopleAddedListView)
//    ListView mPeopleAddedListView;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_add_people);
//        ButterKnife.bind(this);
//
//
//        group = Parcels.unwrap(getIntent().getParcelableExtra("group"));
//        String groupName = group.getName();
//        mAddPeopleHeader.setText("Add people to " + groupName + "'s group");
//
//
////FONTS EVERYTHING
////        Typeface boldieFont = Typeface.createFromAsset(getAssets(), "fonts/Boldie.ttf");
////        mAddPeopleHeader.setTypeface(boldieFont);
////        mAddPersonButton.setTypeface(boldieFont);
////        mPeopleAddedHeader.setTypeface(boldieFont);
//// END OF FONTS
//
//
//        mAddPersonButton.setOnClickListener(this);
//    }
//
//
//    @Override
//    public void onClick(View v) {
//        if (v == mAddPersonButton) {
//            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//            String uid = user.getUid();
//            DatabaseReference restaurantRef = FirebaseDatabase
//                    .getInstance()
//                    .getReference(Constants.FIREBASE_CHILD_GROUPS)
//                    .child(uid);
//
//            addMemberToGroup();
//
//        }
//    }
//
//    private void addMemberToGroup() {
//
//        String member = mAddPersonNameInputField.getText().toString();
//        User memberName = new User(member, ????)
//                        DatabaseReference groupRef = FirebaseDatabase
//                        .getInstance()
//                        .getReference(Constants.FIREBASE_CHILD_GROUPS)
//
//            private void createNewGroup() {
//                String groupName = mGroupNameEditText.getText().toString();
//                Group newGroup = new Group(groupName);
//                DatabaseReference groupRef = FirebaseDatabase
//                        .getInstance()
//                        .getReference(Constants.FIREBASE_CHILD_GROUPS)
//                        .push();
//                String pushId = groupRef.getKey();
//                newGroup.setPushId(pushId);
//                groupRef.setValue(newGroup);

//    }
//}

//                if (listOfPeopleAddedToGroup.contains(personNameInput)) {
//                    Toast.makeText(getBaseContext(), "This person has already been added", Toast.LENGTH_LONG).show();
//                } else if (personNameInput == null || personNameInput.trim().equals(" ")) {
//                    Toast.makeText(getBaseContext(), "Input field is empty", Toast.LENGTH_LONG).show();
//                } else {
//                    listOfPeopleAddedToGroup.add(personNameInput);
//
//                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(AddPeopleActivity.this, android.R.layout.simple_list_item_1, listOfPeopleAddedToGroup);
//                    mPeopleAddedListView.setAdapter(adapter);
//                }
//            }
//
//        });
//
//        mPeopleAddedListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Intent intent = new Intent(AddPeopleActivity.this, AssignChoreActivity.class);
//                startActivity(intent);
//            }
//        });
//
//    }
//}

