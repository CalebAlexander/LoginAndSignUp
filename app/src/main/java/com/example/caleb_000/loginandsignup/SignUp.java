package com.example.caleb_000.loginandsignup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    DatabaseHelper dbHelper = new DatabaseHelper(this);

    EditText nameEditText;
    EditText emailEditText;
    EditText S_usernameEditText;
    EditText S_passwordEditText;
    EditText confirmEditText;
    Button signUpButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        nameEditText = (EditText) findViewById(R.id.nameEditText);
        emailEditText = (EditText) findViewById(R.id.emailEditText);
        S_usernameEditText = (EditText) findViewById(R.id.S_usernameEditText);
        S_passwordEditText = (EditText) findViewById(R.id.S_passwordEditText);
        confirmEditText = (EditText) findViewById(R.id.confirmEditText);
        signUpButton2 = (Button) findViewById(R.id.signUpButton2);
    }

    public void onSignUpClick(View view) {
        String name = nameEditText.getText().toString();
        String email = emailEditText.getText().toString();
        String username = S_usernameEditText.getText().toString();
        String password = S_passwordEditText.getText().toString();
        String confirm = confirmEditText.getText().toString();
//hey babbberoniiiiii
        if (name.equals("")) {
            //popup msg
            Toast NoName = Toast.makeText(SignUp.this, "Please Enter a Name", Toast.LENGTH_SHORT);
            NoName.show();
        } else if (email.equals("")) {
            //popup msg
            Toast NoEmail = Toast.makeText(SignUp.this, "Please Enter an Email", Toast.LENGTH_SHORT);
            NoEmail.show();
        } else if (username.equals("")) {
            //popup msg
            Toast NoUsername = Toast.makeText(SignUp.this, "Please Enter a Username", Toast.LENGTH_SHORT);
            NoUsername.show();
        } else if (password.equals("")) {
            //popup msg
            Toast NoPassword = Toast.makeText(SignUp.this, "Please Enter a Password", Toast.LENGTH_SHORT);
            NoPassword.show();
        } else if (confirm.equals("")) {
            //popup msg
            Toast NoConfirm = Toast.makeText(SignUp.this, "Please Confirm Password", Toast.LENGTH_SHORT);
            NoConfirm.show();
        } else if (!password.equals(confirm)) {
            //popup msg
            Toast mismatch = Toast.makeText(SignUp.this, "Passwords don't match!", Toast.LENGTH_SHORT);
            mismatch.show();
        } else {
            // insert details in the database
            Contact c = new Contact();
            c.setName(name);
            c.setEmail(email);
            c.setUsername(username);
            c.setPassword(password);

            dbHelper.insertContact(c);

            //popup msg
            Toast success = Toast.makeText(SignUp.this, "Successfully Signed Up", Toast.LENGTH_SHORT);
            success.show();
        }
    }
}
