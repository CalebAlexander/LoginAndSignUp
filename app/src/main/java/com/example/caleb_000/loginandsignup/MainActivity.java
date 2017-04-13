package com.example.caleb_000.loginandsignup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button signUpButton;
    Button logInButton;

    EditText L_usernameEditText;
    EditText L_passwordEditText;

    DatabaseHelper dbHelper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signUpButton = (Button) findViewById(R.id.signUpButton);
        logInButton = (Button) findViewById(R.id.logInButton);

        L_usernameEditText = (EditText) findViewById(R.id.L_usernameEditText);
        L_passwordEditText = (EditText) findViewById(R.id.L_passwordEditText);
    }

    public void onSignUp1Click(View view) {
        Intent intent = new Intent(this, SignUp.class);
        startActivity(intent);
    }
    public void onLogInClick(View view) {
        String username = L_usernameEditText.getText().toString();
        String password = L_passwordEditText.getText().toString();

        Toast test = Toast.makeText(MainActivity.this, password, Toast.LENGTH_SHORT);
        test.show();

        String foundPassword = dbHelper.searchPassword(username);
        // if passwords match, open new display
        if (foundPassword.equals(password)) {
            Intent intent = new Intent(this, DisplayInfo.class);
            intent.putExtra("username", username);
            startActivity(intent);
        } else {
            //show message that credentials are invalid
            //popup msg
            Toast incorrectLogIn = Toast.makeText(MainActivity.this, "Incorrect Username or Password", Toast.LENGTH_SHORT);
            incorrectLogIn.show();
        }
    }
}
