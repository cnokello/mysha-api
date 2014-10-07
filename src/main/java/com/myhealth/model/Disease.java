package com.myhealth.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "diseases")
public class Disease implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  private long id;

  private String name;

  private String category;

  private String description;

  public Disease() {
  }

  public Disease(long id, String name, String category, String description) {
    super();
    this.id = id;
    this.name = name;
    this.category = category;
    this.description = description;
  }

  @Override
  public String toString() {
    return "Disease [id=" + id + ", name=" + name + ", category=" + category + ", description="
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

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

}
