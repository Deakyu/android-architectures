package com.example.mvpdemo.presenter;

import com.example.mvpdemo.model.User;
import com.example.mvpdemo.view.ILoginView;

public class LoginPresenter implements ILoginPresenter {

    ILoginView loginView;

    public LoginPresenter(ILoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void onLogin(String email, String password) {
        User user = new User(email, password);
        int loginCode = user.isValidData();

        switch (loginCode) {
            case 0:
                loginView.onLoginError("Email must not be empty");
                break;
            case 1:
                loginView.onLoginError("You must enter valid email");
                break;
            case 2:
                loginView.onLoginError("Password length must be greater than 5");
                break;
            case -1:
                loginView.onLoginSuccess("Login Success!");
                break;
        }
    }

}
