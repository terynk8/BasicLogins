package com.example.basiclogins;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText editTextusername;
    private EditText editTextpassword;
    private Button login;
    private TextView createAccount;

    public static final String EXTRA_SENT_MESSAGE = "username";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        wireWidgets();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "Under Construction", Toast.LENGTH_SHORT).show();
            }
        });

        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //when createAccount textView is clicked, goes to Create Account page
                Intent createAccountPage = new Intent(LoginActivity.this, CreateAccountActivity.class);

                //get the text from the editText
                String username = editTextusername.getText().toString();

                //package the text into the intent
                createAccountPage.putExtra(EXTRA_SENT_MESSAGE, username);

                //start the new activity
                startActivityForResult(createAccountPage, 1234);
            }
        });
    }

    private void wireWidgets() {
        editTextusername = findViewById(R.id.editText_login_username);
        editTextusername.setText(getIntent().getStringExtra(CreateAccountActivity.EXTRA_USER_INFO));
        editTextpassword = findViewById(R.id.editText_login_pw);
        login = findViewById(R.id.button_login_login);
        createAccount = findViewById(R.id.textView_login_createacc);
    }
}
