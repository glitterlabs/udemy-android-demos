package com.glitterlabs.home.whatsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    pBoolean loginModeActive = false;

    public void redirectIfLoggedIn() {

        if (ParseUser.getCurrentUser() != null) {

            Intent intent = new Intent(getApplicationContext(), UserListActivity.class);
            startActivity(intent);

        }

    }

    public void toggleLoginMode(View view) {

        Button loginSignupButton = (Button) findViewById(R.id.loginSignupButton);

        TextView toggleLoginModeTextView = (TextView) findViewById(R.id.toggleLoginModeTextView);

        if (loginModeActive) {

            loginModeActive = false;
            loginSignupButton.setText("Sign Up");
            toggleLoginModeTextView.setText("Or, log in");


        } else {

            loginModeActive = true;
            loginSignupButton.setText("Log In");
            toggleLoginModeTextView.setText("Or, sign up");

        }

    }

    public void signupLogin(View view) {

        EditText usernameEditText = (EditText) findViewById(R.id.usernameEditText);

        EditText passwordEditText = (EditText) findViewById(R.id.passwordEditText);

        if (loginModeActive) {

            ParseUser.logInInBackground(usernameEditText.getText().toString(), passwordEditText.getText().toString(), new LogInCallback() {
                @Override
                public void done(ParseUser user, ParseException e) {

                    if (e == null) {

                        Log.i("Info", "user logged in");

                        redirectIfLoggedIn();

                    } else {

                        String message = e.getMessage();

                        if (message.toLowerCase().contains("java")) {

                            message = e.getMessage().substring(e.getMessage().indexOf(" "));

                        }

                        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();

                    }

                }
            });


        } else {

            ParseUser user = new ParseUser();

            user.setUsername(usernameEditText.getText().toString());

            user.setPassword(passwordEditText.getText().toString());

            user.signUpInBackground(new SignUpCallback() {
                @Override
                public void done(ParseException e) {

                    if (e == null) {

                        Log.i("Info", "user signed up");

                        redirectIfLoggedIn();

                    } else {

                        String message = e.getMessage();

                        if (message.toLowerCase().contains("java")) {

                            message = e.getMessage().substring(e.getMessage().indexOf(" "));

                        }

                        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                    }

                }
            });

        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Whatsapp Login");

        redirectIfLoggedIn();

        ParseAnalytics.trackAppOpenedInBackground(getIntent());
    }

}