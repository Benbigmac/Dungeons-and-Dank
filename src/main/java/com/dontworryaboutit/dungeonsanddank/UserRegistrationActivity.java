package com.dontworryaboutit.dungeonsanddank;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UserRegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registration);

        Button mConfirmButton = (Button) findViewById(R.id.confirm);
        mConfirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: add functionality to check if valid email available for input.
                startActivity(new Intent(UserRegistrationActivity.this, LoginActivity.class));
            }
        });

        Button mCancelButton = (Button) findViewById(R.id.Cancel);
        mCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserRegistrationActivity.this, LoginActivity.class));
            }
        });
    }
}
