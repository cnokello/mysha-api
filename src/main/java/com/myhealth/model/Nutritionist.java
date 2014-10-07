package com.myhealth.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "nutritionists")
public class Nutritionist implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  private long id;

  private String fullName;

  private String institution;

  private String location;

  private String description;

  public Nutritionist() {
  }

  public Nutritionist(long id, String fullName, String institution, String location,
      String description) {
    super();
    this.id = id;
    this.fullName = fullName;
    this.institution = institution;
    this.location = location;
    this.description = description;
  }

  @Override
  public String toString() {
    return "Nutritionist [id=" + id + ", fullName=" + fullName + ", institution=" + institution
        + ", location=" + location + ", description=" + description + "]";
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
}
