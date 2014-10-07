package com.myhealth.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "health_clubs")
public class HealthClub implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  private long id;

  private String name;

  private String location;

  private String description;

  private float lon;

  private float lat;

  private String email;

  private String website;

  private String telephone;

  public HealthClub() {
  }

  public HealthClub(long id, String name, String location, String description, float lon,
      float lat, String email, String website) {
    super();
    this.id = id;
    this.name = name;
    this.location = location;
    this.description = description;
    this.lon = lon;
    this.lat = lat;
    this.email = email;
    this.website = website;
  }

  @Override
  public String toString() {
    return "HealthClub [id=" + id + ", name=" + name + ", location=" + location + ", description="
        + description + ", lon=" + lon + ", lat=" + lat + ", email=" + email + ", website="
        + website + "]";
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
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

  public float getLon() {
    return lon;
  }

  public void setLon(float lon) {
    this.lon = lon;
  }

  public float getLat() {
    return lat;
  }

  public void setLat(float lat) {
    this.lat = lat;
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
