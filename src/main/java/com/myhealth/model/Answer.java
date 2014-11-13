package com.myhealth.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "answers")
public class Answer implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  private long id;

  private long postId;

  private String answerText;

  private long authorId;

  private java.sql.Date publicationDate;

  public Answer() {
  }

  public Answer(long id, long postId, String answerText, long authorId, Date publicationDate) {
    super();
    this.id = id;
    this.postId = postId;
    this.answerText = answerText;
    this.authorId = authorId;
    this.publicationDate = publicationDate;
  }

  public Answer(long postId, String answerText, long authorId, Date publicationDate) {
    super();
    this.postId = postId;
    this.answerText = answerText;
    this.authorId = authorId;
    this.publicationDate = publicationDate;
  }

  public Answer(long postId, String answerText, long authorId) {
    super();
    this.postId = postId;
    this.answerText = answerText;
    this.authorId = authorId;
  }

  @Override
  public String toString() {
    return "Answer [id=" + id + ", postId=" + postId + ", answerText=" + answerText + ", authorId="
        + authorId + ", publicationDate=" + publicationDate + "]";
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getPostId() {
    return postId;
  }

  public void setPostId(long postId) {
    this.postId = postId;
  }

  public String getAnswerText() {
    return answerText;
  }

  public void setAnswerText(String answerText) {
    this.answerText = answerText;
  }

  public long getAuthorId() {
    return authorId;
  }

  public void setAuthorId(long authorId) {
    this.authorId = authorId;
  }

  public java.sql.Date getPublicationDate() {
    return publicationDate;
  }

  public void setPublicationDate(java.sql.Date publicationDate) {
    this.publicationDate = publicationDate;
  }
}
