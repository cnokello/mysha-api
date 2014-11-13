package com.myhealth.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "posts")
public class Post implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  private long id;

  private long authorId;

  private String authorName;

  private String postText;

  private String postType; // asked a question, shared an idea, shared a link, shared a file

  private java.sql.Date publicationDate;

  public Post() {
  }

  public Post(long id, long authorId, String authorName, String postText, String postType,
      Date publicationDate) {
    super();
    this.id = id;
    this.authorId = authorId;
    this.authorName = authorName;
    this.postText = postText;
    this.postType = postType;
    this.publicationDate = publicationDate;
  }

  public Post(long authorId, String authorName, String postText, String postType,
      Date publicationDate) {
    super();
    this.authorId = authorId;
    this.authorName = authorName;
    this.postText = postText;
    this.postType = postType;
    this.publicationDate = publicationDate;
  }

  public Post(long authorId, String authorName, String postText, String postType) {
    super();
    this.authorId = authorId;
    this.authorName = authorName;
    this.postText = postText;
    this.postType = postType;
  }

  @Override
  public String toString() {
    return "Post [id=" + id + ", authorId=" + authorId + ", authorName=" + authorName
        + ", postText=" + postText + ", postType=" + postType + ", publicationDate="
        + publicationDate + "]";
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getAuthorId() {
    return authorId;
  }

  public void setAuthorId(long authorId) {
    this.authorId = authorId;
  }

  public String getAuthorName() {
    return authorName;
  }

  public void setAuthorName(String authorName) {
    this.authorName = authorName;
  }

  public String getPostText() {
    return postText;
  }

  public void setPostText(String postText) {
    this.postText = postText;
  }

  public String getPostType() {
    return postType;
  }

  public void setPostType(String postType) {
    this.postType = postType;
  }

  public java.sql.Date getPublicationDate() {
    return publicationDate;
  }

  public void setPublicationDate(java.sql.Date publicationDate) {
    this.publicationDate = publicationDate;
  }

}
