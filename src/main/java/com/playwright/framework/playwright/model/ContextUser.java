package com.playwright.framework.playwright.model;

import com.playwright.framework.service.util.ExtendedFakerService;

public class ContextUser {
    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String phone;
    private String ssn;
    private String username;
    private String password;

    public ContextUser(final ExtendedFakerService fakerService) {;
        this.setFirstName(fakerService.name().firstName());
        this.setLastName(fakerService.name().lastName());
        this.setStreet(fakerService.address().streetAddress());
        this.setCity(fakerService.address().city());
        this.setState(fakerService.address().state());
        this.setZipCode(fakerService.address().zipCode());
        this.setPhone(fakerService.phoneNumber().phoneNumber());
        this.setSsn(fakerService.generateSsn());

        this.setUsername(fakerService.name().username());
        this.setPassword(fakerService.generatePassword());
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(final String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(final String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(final String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(final String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(final String phone) {
        this.phone = phone;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(final String ssn) {
        this.ssn = ssn;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "ContextUser{" +
               "firstName='" + firstName + '\'' +
               ", lastName='" + lastName + '\'' +
               ", street='" + street + '\'' +
               ", city='" + city + '\'' +
               ", state='" + state + '\'' +
               ", zipCode='" + zipCode + '\'' +
               ", phone='" + phone + '\'' +
               ", ssn='" + ssn + '\'' +
               ", username='" + username + '\'' +
               ", password='" + password + '\'' +
               '}';
    }
}