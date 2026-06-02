package miu.rahul.Lab6;

import java.time.LocalDate;

public class Patient
{
    private String FirstName;
    private String LastName;
    private LocalDate DOB;
    private String ContactNumber;
    private String Email;
    private String MailingAddress;


    public Patient(String firstName, String lastName, LocalDate DOB, String contactNumber, String email, String mailingAddress) {
        FirstName = firstName;
        LastName = lastName;
        this.DOB = DOB;
        ContactNumber = contactNumber;
        Email = email;
        MailingAddress = mailingAddress;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public LocalDate getDOB() {
        return DOB;
    }

    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }

    public String getContactNumber() {
        return ContactNumber;
    }

    public void setContactNumber(String contactNumber) {
        ContactNumber = contactNumber;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getMailingAddress() {
        return MailingAddress;
    }

    public void setMailingAddress(String mailingAddress) {
        MailingAddress = mailingAddress;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", DOB=" + DOB +
                ", ContactNumber='" + ContactNumber + '\'' +
                ", Email='" + Email + '\'' +
                ", MailingAddress='" + MailingAddress + '\'' +
                '}';
    }
}
