package com.myhealth.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "articles")
public class Article implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  private long id;

  private String topic;

  private String shortDescription;

  private String longDescription;

  private String tagsString;

  @Transient
  private String[] tags;

  private java.sql.Date publicationDate;

  private String author;

  public Article() {
  }

  public Article(long id, String topic, String shortDescription, String longDescription,
      String tagsString, String[] tags, Date publicationDate, String author) {
    super();
    this.id = id;
    this.topic = topic;
    this.shortDescription = shortDescription;
    this.longDescription = longDescription;
    this.tagsString = tagsString;
    this.tags = tags;
    this.publicationDate = publicationDate;
    this.author = author;
  }

  @Override
  public String toString() {
    return "Article [id=" + id + ", topic=" + topic + ", shortDescription=" + shortDescription
        + ", longDescription=" + longDescription + ", tagsString=" + tagsString + ", tags=" + tags
        + ", publicationDate=" + publicationDate + ", author=" + author + "]";
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getTopic() {
    return topic;
  }

  public void setTopic(String topic) {
    this.topic = topic;
  }

  public String getShortDescription() {
    return shortDescription;
  }

  public void setShortDescription(String shortDescription) {
    this.shortDescription = shortDescription;
  }

  public String getLongDescription() {
    return longDescription;
  }

  public void setLongDescription(String longDescription) {
    this.longDescription = longDescription;
  }

  public String getTagsString() {
    return tagsString;
  }

  public void setTagsString(String tagsString) {
    this.tagsString = tagsString;
  }

  public String[] getTags() {
    return tagsString.split("#");
  }

  public void setTags(String[] tags) {
    this.tags = tagsString.split("#");
  }

  public java.sql.Date getPublicationDate() {
    return publicationDate;
  }

  public void setPublicationDate(java.sql.Date publicationDate) {
    this.publicationDate = publicationDate;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

}
