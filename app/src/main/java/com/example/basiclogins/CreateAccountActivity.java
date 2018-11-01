package com.example.basiclogins;

import android.content.Intent;
import android.renderscript.ScriptIntrinsicYuvToRGB;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateAccountActivity extends AppCompatActivity {

    private EditText name;
    private EditText username;
    private EditText password;
    private EditText confirmpassword;
    private EditText email;
    private Button buttonCreateAccount;

    public static final String EXTRA_NAME_INFO = "nameinfo";
    public static final String EXTRA_USER_INFO = "logininfo";
    public static final String EXTRA_PW_INFO = "pwinfo";
    public static final String EXTRA_CPW_INFO = "cpwinfo";
    public static final String EXTRA_EMAIL_INFO = "emailinfo";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        wireWidgets();

        buttonCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CreateAccountActivity.this, "hi", Toast.LENGTH_SHORT).show();
                String user = username.getText().toString();
                String filledname = name.getText().toString();
                String pw = password.getText().toString();
                String cpw = confirmpassword.getText().toString();
                String emailinfo = email.getText().toString();

                if (pw == cpw) {
                    Intent loginPage = new Intent(CreateAccountActivity.this, LoginActivity.class);
                    loginPage.putExtra(EXTRA_USER_INFO, user);
                    loginPage.putExtra(EXTRA_NAME_INFO, filledname);
                    loginPage.putExtra(EXTRA_PW_INFO, pw);
                    loginPage.putExtra(EXTRA_CPW_INFO, cpw);
                    loginPage.putExtra(EXTRA_EMAIL_INFO, emailinfo);

                    setResult(1234, loginPage);
                }
            }
        });

    }


    private void wireWidgets() {
        name = findViewById(R.id.editText_createaccount_name);
        username = findViewById(R.id.editText_createaccount_username);
        username.setText(getIntent().getStringExtra(LoginActivity.EXTRA_SENT_MESSAGE));
        password = findViewById(R.id.editText_createaccount_pw);
        confirmpassword = findViewById(R.id.editText_createaccount_confirmpw);
        email = findViewById(R.id.editText_createaccount_email);
        buttonCreateAccount = findViewById(R.id.button_createaccount_createacc);
    }
}
