package com.gzbook.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;

    private String email;

    private String password;

    private String gender;

    private String dateOfBirth;

    private String address;

    private String phoneNumber;

    private String avatar;

    private String coverPhoto;

    public User() {
    }

    public User(Long id, String userName, String email, String password, String gender, String dateOfBirth, String userAddress, String userPhoneNumber, String userAvatar, String userCoverPhoto) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.address = userAddress;
        this.phoneNumber = userPhoneNumber;
        this.avatar = userAvatar;
        this.coverPhoto = userCoverPhoto;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String userEmail) {
        this.email = userEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String userPassword) {
        this.password = userPassword;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String userAddress) {
        this.address = userAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String userPhoneNumber) {
        this.phoneNumber = userPhoneNumber;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String userAvatar) {
        this.avatar = userAvatar;
    }

    public String getCoverPhoto() {
        return coverPhoto;
    }

    public void setCoverPhoto(String userCoverPhoto) {
        this.coverPhoto = userCoverPhoto;
    }
}
