package com.hallbookingmanagement.beans;

import org.springframework.stereotype.Component;

@Component
public class 	WebContactDetails {
    private String email;
    private String phone;
    private String whatsapp;
    private String websiteLink;
    private String address;
    private String locationLink;

    // Constructor
    public WebContactDetails() {
    }

    public WebContactDetails(String email, String phone, String whatsapp, String websiteLink, String address, String locationLink) {
        this.email = email;
        this.phone = phone;
        this.whatsapp = whatsapp;
        this.websiteLink = websiteLink;
        this.address = address;
        this.locationLink = locationLink;
    }

    // Getters and Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }

    public String getWebsiteLink() {
        return websiteLink;
    }

    public void setWebsiteLink(String websiteLink) {
        this.websiteLink = websiteLink;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocationLink() {
        return locationLink;
    }

    public void setLocationLink(String locationLink) {
        this.locationLink = locationLink;
    }

    @Override
    public String toString() {
        return "WebContactDetails{" +
                "email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", whatsapp='" + whatsapp + '\'' +
                ", websiteLink='" + websiteLink + '\'' +
                ", address='" + address + '\'' +
                ", locationLink='" + locationLink + '\'' +
                '}';
    }
}
