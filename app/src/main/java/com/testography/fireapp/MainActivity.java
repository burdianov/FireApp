package com.testography.fireapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.Firebase;

public class MainActivity extends AppCompatActivity {

    private EditText mKeyValue;
    private EditText mValueField;
    private Button mAddBtn;
    private Firebase mRootRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRootRef = new Firebase("https://fireapp-38767.firebaseio.com/Users");

        mKeyValue = (EditText) findViewById(R.id.keyValue);
        mValueField = (EditText) findViewById(R.id.valueField);
        mAddBtn = (Button) findViewById(R.id.addBtn);

        mAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String key = mKeyValue.getText().toString();
                String value = mValueField.getText().toString();

                Firebase childRef = mRootRef.child(key);
                childRef.setValue(value);
//                childRef.push().setValue(value);
            }
        });
    }
}
