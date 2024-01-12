package com.spring.henallux.firstSpringProject.dataAccess.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="USER")
public class UserEntity {

    //region variables
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name="username")
    private String username;

    @Column(name="lastname")
    private String lastname;

    @Column(name="firstname")
    private String firstname;

    @Column(name="isemployee")
    private boolean isEmployee;

    @Column(name="registrationdate")
    private Date registrationDate;

    @Column(name="password")
    private String password;

    @Column(name="address")
    private String address;

    @Column(name="email")
    private String email;

    @Column(name="phonenumber")
    private String phoneNumber;

    @Column(name="authorities")
    private String authorities;

    @Column(name="nonexpired")
    private boolean nonExpired;

    @Column(name="nonlocked")
    private boolean nonLocked;

    @Column(name="credentialsnonexpired")
    private boolean credentialsNonExpired;

    @Column(name = "isenabled", columnDefinition = "boolean default true")
    private boolean isEnabled;

    @Transient
    private String confirmPassword;
    //endregion


    public UserEntity(Integer id, String username, String lastname, String firstname, boolean isEmployee, Date registrationDate, String password, String address, String email, String phoneNumber, String authorities, boolean nonExpired, boolean nonLocked, boolean credentialsNonExpired, boolean isEnabled, String confirmPassword) {
        this.id = id;
        this.username = username;
        this.lastname = lastname;
        this.firstname = firstname;
        this.isEmployee = isEmployee;
        this.registrationDate = registrationDate;
        this.password = password;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.authorities = authorities;
        this.nonExpired = nonExpired;
        this.nonLocked = nonLocked;
        this.credentialsNonExpired = credentialsNonExpired;
        this.isEnabled = isEnabled;
        this.confirmPassword = confirmPassword;
    }

    public UserEntity() {
    }

    //region getters
    public Integer getId(){
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public boolean getIsEmployee() {
        return isEmployee;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAuthorities() {
        return authorities;
    }

    public boolean getNonExpired() {
        return nonExpired;
    }

    public boolean getNonLocked() {
        return nonLocked;
    }

    public boolean getCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public boolean getIsEnabled() {
        return isEnabled;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }
    //endregion

    //region setters

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setEmployee(boolean employee) {
        isEmployee = employee;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    public void setNonExpired(boolean nonExpired) {
        this.nonExpired = nonExpired;
    }

    public void setNonLocked(boolean nonLocked) {
        this.nonLocked = nonLocked;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
//endregion
}