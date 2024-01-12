package com.spring.henallux.firstSpringProject.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Date;

public class User implements UserDetails {
    @Size(min = 1, max = 50)
    private String username;

    @Size(max = 50)
    private String lastname;

    @Size(max = 50)
    private String firstname;

    private boolean isEmployee;

    private Date registrationDate;

    @Size(min = 1, max = 60)
    private String password;

    @Size(min = 1, max = 255)
    private String address;

    @Size(min = 1, max = 255)
    @Pattern(regexp = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$", message = "invalid email")
    private String email;

    @Size(min = 1, max = 20)
    @Pattern(regexp = "^[+]?[(]?[0-9]{3}[)]?[-\\s.]?[0-9]{3}[-\\s.]?[0-9]{4,6}$", message = "invalid phone number")
    private String phoneNumber;

    private String authorities;

    private boolean nonExpired;

    private boolean nonLocked;

    private boolean credentialsNonExpired;

    private boolean isEnabled;

    @Size(min = 1, max = 60)
    private String confirmPassword;

    public User(String username, String lastname, String firstname, boolean isEmployee, Date registrationDate, String password, String address, String email, String phoneNumber, String authorities, boolean nonExpired, boolean nonLocked, boolean credentialsNonExpired, boolean isEnabled, String confirmPassword) {
        setUsername(username);
        setLastname(lastname);
        setFirstname(firstname);
        setIsEmployee(isEmployee);
        setRegistrationDate(registrationDate);
        setPassword(password);
        setAddress(address);
        setEmail(email);
        setPhoneNumber(phoneNumber);
        setAuthorities(authorities);
        setNonExpired(nonExpired);
        setNonLocked(nonLocked);
        setCredentialsNonExpired(credentialsNonExpired);
        setIsEnabled(isEnabled);
        setConfirmPassword(confirmPassword);
    }

    public User () { }

    @Override
    public String getUsername() {
        return username;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public boolean isEmployee() {
        return isEmployee;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    @Override
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

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        if (authorities != null && !authorities.isEmpty()) {
            String[] authoritiesAsArray = authorities.split(",");

            for (String authority : authoritiesAsArray) {
                if (authority != null && !authority.isEmpty()) {
                    grantedAuthorities.add(new SimpleGrantedAuthority(authority));
                }
            }
        }

        return grantedAuthorities;
    }

    public String getAuthoritiesToString() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return nonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return nonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setLastname(String lastname) {
        if (!lastname.isEmpty()) {
            this.lastname = lastname;
        }
    }

    public void setFirstname(String firstname) {
        if (!firstname.isEmpty()) {
            this.firstname = firstname;
        }
    }

    public void setIsEmployee(boolean isEmployee) {
        this.isEmployee = isEmployee;
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

    public void setIsEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public void setUserDefaultValues() {
        setRegistrationDate(new Date());
        setIsEmployee(false);
        setAuthorities("ROLE_USER");
        setNonExpired(true);
        setNonLocked(true);
        setCredentialsNonExpired(true);
        setIsEnabled(true);
    }
}