package com.gzbook.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;

    private String userEmail;

    private String userPassword;

    private String gender;

    private String dateOfBirth;

    private String userAddress;

    private String userPhoneNumber;

    private String userAvatar;

    private String userCoverPhoto;

    public User() {
    }

    public User(Long id, String userName, String userEmail, String userPassword, String gender, String dateOfBirth, String userAddress, String userPhoneNumber, String userAvatar, String userCoverPhoto) {
        this.id = id;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.userAddress = userAddress;
        this.userPhoneNumber = userPhoneNumber;
        this.userAvatar = userAvatar;
        this.userCoverPhoto = userCoverPhoto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public String getUserCoverPhoto() {
        return userCoverPhoto;
    }

    public void setUserCoverPhoto(String userCoverPhoto) {
        this.userCoverPhoto = userCoverPhoto;
    }
}
