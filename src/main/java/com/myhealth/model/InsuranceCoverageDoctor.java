package com.myhealth.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "insurance_coverage_doctor")
public class InsuranceCoverageDoctor implements Serializable {

  private static final long serialVersionUID = 1L;

  private long insuranceCompanyId;

  @Id
  private long id;

  private String doctorFullName;

  private String specialty;

  private String description;

  private String location;

  private String institution;

  private String email;

  private String website;

  private String telephone;

  public InsuranceCoverageDoctor(long insuranceCompanyId, long id, String doctorFullName,
      String specialty, String description, String location, String institution, String email,
      String website, String telephone) {
    super();
    this.insuranceCompanyId = insuranceCompanyId;
    this.id = id;
    this.doctorFullName = doctorFullName;
    this.specialty = specialty;
    this.description = description;
    this.location = location;
    this.institution = institution;
    this.email = email;
    this.website = website;
    this.telephone = telephone;
  }

  @Override
  public String toString() {
    return "InsuranceCoverageDoctor [insuranceCompanyId=" + insuranceCompanyId + ", id=" + id
        + ", doctorFullName=" + doctorFullName + ", specialty=" + specialty + ", description="
        + description + ", location=" + location + ", institution=" + institution + ", email="
        + email + ", website=" + website + ", telephone=" + telephone + "]";
  }

  public InsuranceCoverageDoctor() {
  }

  public long getInsuranceCompanyId() {
    return insuranceCompanyId;
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

  public String getDoctorFullName() {
    return doctorFullName;
  }

  public void setDoctorFullName(String doctorFullName) {
    this.doctorFullName = doctorFullName;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getInstitution() {
    return institution;
  }

  public void setInstitution(String institution) {
    this.institution = institution;
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

  public String getSpecialty() {
    return specialty;
  }

  public void setSpecialty(String specialty) {
    this.specialty = specialty;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
