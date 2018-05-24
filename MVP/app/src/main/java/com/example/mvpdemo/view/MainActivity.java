package com.example.mvpdemo.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mvpdemo.R;
import com.example.mvpdemo.presenter.ILoginPresenter;
import com.example.mvpdemo.presenter.LoginPresenter;
import com.example.mvpdemo.view.ILoginView;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity implements ILoginView {

    EditText email, password;
    Button loginBtn;

    ILoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        loginBtn = findViewById(R.id.login_button);

        loginPresenter = new LoginPresenter(this);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPresenter.onLogin(email.getText().toString(), password.getText().toString());
            }
        });
    }

    @Override
    public void onLoginError(String msg) {
        Toasty.error(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginSuccess(String msg) {
        Toasty.success(this, msg, Toast.LENGTH_SHORT).show();
    }
}
