package com.myhealth.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "personal_trainers")
public class PersonalTrainer implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  private long id;

  private String fullName;

  private String institution;

  private String location;

  private String description;

  private String email;

  private String website;

  private String telephone;

  public PersonalTrainer() {
  }

  @Override
  public String toString() {
    return "PersonalTrainer [id=" + id + ", fullName=" + fullName + ", institution=" + institution
        + ", location=" + location + ", description=" + description + ", email=" + email
        + ", website=" + website + ", telephone=" + telephone + "]";
  }

  public PersonalTrainer(long id, String fullName, String institution, String location,
      String description, String email, String website, String telephone) {
    super();
    this.id = id;
    this.fullName = fullName;
    this.institution = institution;
    this.location = location;
    this.description = description;
    this.email = email;
    this.website = website;
    this.telephone = telephone;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public String getInstitution() {
    return institution;
  }

  public void setInstitution(String institution) {
    this.institution = institution;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getWebsite() {
    return website;
  }

  public void setWebsite(String website) {
    this.website = website;
  }

  public String getTelephone() {
    return telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }
}
