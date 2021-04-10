package com.example.myntraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class Polls extends AppCompatActivity {

    Button pepsiBtn;
    Button cokeBtn,sendcomment;
    private static final String TAG = "Polls";

    TextView pepsiText;
    TextView cokeText;
    EditText comment;

    Context context=this;
    FirebaseStorage storage = FirebaseStorage.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_polls);

        cokeText = findViewById(R.id.tv_coke_count);

        pepsiText = findViewById(R.id.tv_pepsi_count);

        comment=findViewById(R.id.etcomment);
        cokeBtn = findViewById(R.id.btn_coke_vote);
        pepsiBtn = findViewById(R.id.btn_pepsi_vote);
        sendcomment = findViewById(R.id.btncomment);

        sendcomment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = comment.getText().toString();

//                FirebaseDatabase database = FirebaseDatabase.getInstance();
//                DatabaseReference myRef = database.getReference("message");
//
//                myRef.setValue(text);
//
//                myRef.addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(DataSnapshot dataSnapshot) {
//                        // This method is called once with the initial value and again
//                        // whenever data at this location is updated.
//                        String value = dataSnapshot.getValue(String.class);
//                        Log.d(TAG, "Value is: " + value);
//                    }
//
//                    @Override
//                    public void onCancelled(DatabaseError error) {
//                        // Failed to read value
//                        Log.w(TAG, "Failed to read value.", error.toException());
//                    }
//                });


//                // Create a Cloud Storage reference from the app
//                StorageReference storageRef = storage.getReference();
//
//                StorageReference mountainsRef = storageRef.child("drawable-v24\\dress.jpg");
//
//// Create a reference to 'images/mountains.jpg'
//                StorageReference mountainImagesRef = storageRef.child("images/drawable-v24\\dress.jpg");
//
//// While the file names are the same, the references point to different files
//                mountainsRef.getName().equals(mountainImagesRef.getName());    // true
//                mountainsRef.getPath().equals(mountainImagesRef.getPath());
//
//                // Create a reference with an initial file path and name
//                StorageReference pathReference = storageRef.child("images/drawable-v24\\dress.jpg");
//
//// Create a reference to a file from a Cloud Storage URI
//                StorageReference gsReference = storage.getReferenceFromUrl("gs://bucket/images/drawable-v24\\dress.jpg");

// Create a reference from an HTTPS URL
// Note that in the URL, characters are URL escaped!
                StorageReference httpsReference = storage.getReferenceFromUrl("https://firebasestorage.googleapis.com/b/bucket/o/images%20drawable-v24\\dress.jpg");

                Intent intent=new Intent(context, SeeComments.class);
                intent.putExtra("comment",text);
                startActivity(intent);
            }
        });
    }

    public void onCokeClicked(View v){
        String cokeCount = cokeText.getText().toString().trim();
        int count = Integer.parseInt(cokeCount);
        count++;
        cokeText.setText(String.valueOf(count));
    }

    public void onPepsiClicked(View v){
        String pepsiCount = pepsiText.getText().toString().trim();
        int count = Integer.parseInt(pepsiCount);
        count++;
        pepsiText.setText(String.valueOf(count));
    }



}