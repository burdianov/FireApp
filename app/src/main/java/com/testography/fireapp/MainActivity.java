package com.testography.fireapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private Firebase mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRef = new Firebase("https://fireapp-38767.firebaseio.com/");

        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Map<String, String> map = dataSnapshot.getValue(Map.class);
                String name = map.get("Name");
                String age = map.get("Age");
                String profession = map.get("Profession");

                Log.v("E_VALUE", "Name: " + name);
                Log.v("E_VALUE", "Age: " + age);
                Log.v("E_VALUE", "Profession: " + profession);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }
}
