package com.myhealth.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "insurance_coverage_hospital")
public class InsuranceCoverageHospital implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  private long id;

  private long insuranceCompanyId;

  private String hospitalName;

  private String location;

  private float lon;

  private float lat;

  private String email;

  private String website;

  private String telephone;

  public InsuranceCoverageHospital() {
  }

  public long getInsuranceCompanyId() {
    return insuranceCompanyId;
  }

  public InsuranceCoverageHospital(long id, long insuranceCompanyId, String hospitalName,
      String location, float lon, float lat, String email, String website, String telephone) {
    super();
    this.id = id;
    this.insuranceCompanyId = insuranceCompanyId;
    this.hospitalName = hospitalName;
    this.location = location;
    this.lon = lon;
    this.lat = lat;
    this.email = email;
    this.website = website;
    this.telephone = telephone;
  }

  @Override
  public String toString() {
    return "InsuranceCoverageHospital [id=" + id + ", insuranceCompanyId=" + insuranceCompanyId
        + ", hospitalName=" + hospitalName + ", location=" + location + ", lon=" + lon + ", lat="
        + lat + ", email=" + email + ", website=" + website + ", telephone=" + telephone + "]";
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public void setInsuranceCompanyId(long insuranceCompanyId) {
    this.insuranceCompanyId = insuranceCompanyId;
  }

  public String getHospitalName() {
    return hospitalName;
  }

  public void setHospitalName(String hospitalName) {
    this.hospitalName = hospitalName;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
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
