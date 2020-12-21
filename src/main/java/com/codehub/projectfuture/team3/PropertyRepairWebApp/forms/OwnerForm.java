package com.codehub.projectfuture.team3.PropertyRepairWebApp.forms;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class OwnerForm {
    private static final String AFM_PATTERN = "[0-9]{9}";
    private static final String TELEPHONE_PATTERN = "^(\\+\\d{2})?[0-9]{10}";
    private static final String EMAIL_PATTERN = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,}$";

    @Pattern(regexp = AFM_PATTERN, message = "{createOwner.afm.pattern.invalid}")
    private String afm;
    private String firstName;
    private String lastName;
    private String address;
    @Pattern(regexp = TELEPHONE_PATTERN, message = "{createOwner.telephone.pattern.invalid}")
    private String telephoneNumber;
    @Pattern(regexp = EMAIL_PATTERN, message = "{createOwner.email.pattern.invalid}")
    private String email;
    @NotEmpty(message = "{register.not.null}")
    private String userRole;

    public String getAfm() {
        return afm;
    }

    public void setAfm(String afm) {
        this.afm = afm;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}
