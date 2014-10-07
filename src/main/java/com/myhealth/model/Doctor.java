package com.myhealth.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "doctors")
public class Doctor implements Serializable {

  @Id
  private long id;

  private String fullName;

  private String specialty;

  private String institution;

  private String location;

  private String description;

  public Doctor() {
  }

  public Doctor(long id, String fullName, String specialty, String institution, String location,
      String description) {
    super();
    this.id = id;
    this.fullName = fullName;
    this.specialty = specialty;
    this.institution = institution;
    this.location = location;
    this.description = description;
  }

  @Override
  public String toString() {
    return "Doctor [id=" + id + ", fullName=" + fullName + ", specialty=" + specialty
        + ", institution=" + institution + ", location=" + location + ", description="
        + description + "]";
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

  public String getSpecialty() {
    return specialty;
  }

  public void setSpecialty(String specialty) {
    this.specialty = specialty;
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

}
