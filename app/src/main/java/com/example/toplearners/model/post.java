package com.example.toplearners.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class post {

        @SerializedName("firstName")
        @Expose
        private String firstName;
        @SerializedName("lastName")
        @Expose
        private String lastName;
        @SerializedName("emailAdress")
        @Expose
        private String emailAdress;
        @SerializedName("gitlink")
        @Expose
        private String gitLink;

    public post(String firstName, String lastName, String emailAdress, String gitLink) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAdress = emailAdress;
        this.gitLink = gitLink;
    }

    public post() {

    }

    @Override
    public String toString() {
        return "post{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailAdress='" + emailAdress + '\'' +
                ", gitLink='" + gitLink + '\'' +
                '}';
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

    public String getEmailAdress() {
        return emailAdress;
    }

    public void setEmailAdress(String emailAdress) {
        this.emailAdress = emailAdress;
    }

    public String getGitLink() {
        return gitLink;
    }

    public void setGitLink(String gitLink) {
        this.gitLink = gitLink;
    }
}
