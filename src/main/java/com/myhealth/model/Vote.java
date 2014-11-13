package com.myhealth.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "votes")
public class Vote implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  private long id;

  private long sourceAuthorId;

  private long targetId;

  private String tagetType;

  private int vote;

  private java.sql.Date voteDate;

  public Vote() {
  }

  public Vote(long id, long sourceAuthorId, long targetId, String tagetType, int vote, Date voteDate) {
    super();
    this.id = id;
    this.sourceAuthorId = sourceAuthorId;
    this.targetId = targetId;
    this.tagetType = tagetType;
    this.vote = vote;
    this.voteDate = voteDate;
  }

  public Vote(long sourceAuthorId, long targetId, String tagetType, int vote, Date voteDate) {
    super();
    this.sourceAuthorId = sourceAuthorId;
    this.targetId = targetId;
    this.tagetType = tagetType;
    this.vote = vote;
    this.voteDate = voteDate;
  }

  public Vote(long sourceAuthorId, long targetId, String tagetType, int vote) {
    super();
    this.sourceAuthorId = sourceAuthorId;
    this.targetId = targetId;
    this.tagetType = tagetType;
    this.vote = vote;
  }

  @Override
  public String toString() {
    return "Vote [id=" + id + ", sourceAuthorId=" + sourceAuthorId + ", targetId=" + targetId
        + ", tagetType=" + tagetType + ", vote=" + vote + ", voteDate=" + voteDate + "]";
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getSourceAuthorId() {
    return sourceAuthorId;
  }

  public void setSourceAuthorId(long sourceAuthorId) {
    this.sourceAuthorId = sourceAuthorId;
  }

  public long getTargetId() {
    return targetId;
  }

  public void setTargetId(long targetId) {
    this.targetId = targetId;
  }

  public String getTagetType() {
    return tagetType;
  }

  public void setTagetType(String tagetType) {
    this.tagetType = tagetType;
  }

  public int getVote() {
    return vote;
  }

  public void setVote(int vote) {
    this.vote = vote;
  }

  public java.sql.Date getVoteDate() {
    return voteDate;
  }

  public void setVoteDate(java.sql.Date voteDate) {
    this.voteDate = voteDate;
  }

}
