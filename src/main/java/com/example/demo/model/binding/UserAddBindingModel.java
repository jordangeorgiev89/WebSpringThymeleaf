package com.example.demo.model.binding;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

public class UserAddBindingModel {

    private String username;
    private String password;
    private String confirmPassword;
    private String email;
    private String git;

    public UserAddBindingModel() {
    }

    @Length(min = 2, max = 10, message = "min 2, max 10")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    @Length(min = 2, max = 10, message = "min 2, max 10")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @Email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Pattern(regexp = "https:\\/\\/github\\.com\\/.+\\/.+", message = "Please, enter a valid email!")
    public String getGit() {
        return git;
    }

    public void setGit(String git) {
        this.git = git;
    }
}
