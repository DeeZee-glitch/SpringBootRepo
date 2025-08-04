package com.example.DemoZain.dto.zain;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UserDataDTO {
    @NotBlank(message="username cannot be blank")
    @Size(min=2, message="username must have at least 2 letters")
    private String username;

    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "Invalid email format")
    private String email;

    @Pattern(regexp = "^[0-9]{10,15}$", message = "Invalid mobile number format")
    private String mobile;

    public UserDataDTO() {
    }
    public UserDataDTO(String username, String email, String mobile) {
        this.username = username;
        this.email = email;
        this.mobile = mobile;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUsername() {
        return username;
    }

}
