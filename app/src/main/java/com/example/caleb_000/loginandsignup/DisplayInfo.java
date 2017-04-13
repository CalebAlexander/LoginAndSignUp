package com.example.caleb_000.loginandsignup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class DisplayInfo extends AppCompatActivity {
    TextView D_nameTextView;
    TextView D_emailTextView;
    TextView D_usernameTextView;
    TextView D_passwordTextView;
    TextView D_showNameTextView;
    TextView D_showEmailTextView;
    TextView D_showUsernameTextView;
    TextView D_showPasswordTextView;

    DatabaseHelper dbHelper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_info);

        D_nameTextView = (TextView) findViewById(R.id.D_nameTextView);
        D_emailTextView = (TextView) findViewById(R.id.D_emailTextView);
        D_usernameTextView = (TextView) findViewById(R.id.D_usernameTextView);
        D_passwordTextView = (TextView) findViewById(R.id.D_passwordTextView);

        D_showNameTextView = (TextView) findViewById(R.id.D_showNameTextView);
        D_showEmailTextView = (TextView) findViewById(R.id.D_showEmailTextView);
        D_showUsernameTextView = (TextView) findViewById(R.id.D_showUsernameTextView);
        D_showPasswordTextView = (TextView) findViewById(R.id.D_showPasswordTextView);

        String username = "";
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                username = null;
            } else {
                username = extras.getString("username");
            }
        }

        String[] info = dbHelper.getInfo(username);

        D_showNameTextView.setText(info[0]);
        D_showEmailTextView.setText(info[1]);
        D_showUsernameTextView.setText(info[2]);
        D_showPasswordTextView.setText(info[3]);
    }
}
