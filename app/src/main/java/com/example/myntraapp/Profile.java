package com.example.myntraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Profile extends AppCompatActivity {
Button seecomments,sendcomments;
Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        seecomments= (Button)findViewById(R.id.btnseecomments);
        sendcomments=(Button)findViewById(R.id.btnsendcomments);
        setContentView(R.layout.activity_profile);

        seecomments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, SeeComments.class);
                startActivity(intent);
            }
        });

        sendcomments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, Polls.class);
                startActivity(intent);
            }
        });
    }
}