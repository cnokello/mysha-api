package com.myhealth.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "drugs")
public class Drug implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  private long id;

  private String name;

  private String category;

  private String description;

  public Drug() {
  }

  public Drug(long id, String name, String category, String description) {
    super();
    this.id = id;
    this.name = name;
    this.category = category;
    this.description = description;
  }

  @Override
  public String toString() {
    return "Drug [id=" + id + ", name=" + name + ", category=" + category + ", description="
        + description + "]";
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

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

}
