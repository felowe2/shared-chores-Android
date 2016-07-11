package com.epicodus.sharedchores;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AssignChoreActivity extends AppCompatActivity {

    @Bind(R.id.assignChoreHeader) TextView mAssignShoreChoreHeader;
    @Bind(R.id.choreDoerInputField) EditText mChoreDoerInputField;
    @Bind(R.id.choreDescriptionInputField) EditText mChoreDescriptionInputField;
    @Bind(R.id.choreDueDateInputField) EditText mChoreDueDateInputField;
    @Bind(R.id.addChoreButton) Button mAddChoreButton;
    @Bind(R.id.choreSummaryHeader) TextView mChoreHeader;
    @Bind(R.id.choreDoerTextView) TextView mChoreDoerTextView;
    @Bind(R.id.choreDescriptionTextView) TextView mChoreDescriptionTextView;
    @Bind(R.id.choreDueDateTextView) TextView mChoreDueDateTextView;
    @Bind(R.id.assignChoreButton) Button mAssignChoreButton;

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


        mAddChoreButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String choreDoerInput = mChoreDoerInputField.getText().toString();
//                Intent intent = new Intent(AssignChoreActivity.this, SuccessPageActivity.class);
//                intent.putExtra("doer_name", choreDoerInput);

                String choreDescriptionInput = mChoreDescriptionInputField.getText().toString();
                String choreDueDateInput = mChoreDueDateInputField.getText().toString();

                userChore.add(choreDoerInput);
                userChore.add(choreDescriptionInput);
                userChore.add(choreDueDateInput);

//                mChoreDoerTextView.setText(choreDoerInput);
                mChoreDescriptionTextView.setText(choreDescriptionInput);
                mChoreDueDateTextView.setText(choreDueDateInput);

            }
        });

//        mAssignChoreButton.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                if (v == mAssignChoreButton) {
//                    Intent goToSuccessPage = new Intent(AssignChoreActivity.this, SuccessPageActivity.class);
//                    startActivity(goToSuccessPage);
//                }
//            }
//        });
    }
}