package com.myhealth.model;

import java.util.UUID;

import javax.persistence.Id;

public class UserAccess {

  @Id
  private long id;

  private long userId;

  private long created;

  private String token;

  private String tokenSecret;

  private int enabled;

  public UserAccess() {
  }

  public UserAccess(long userId) {
    this.userId = userId;
    this.created = new java.util.Date().getTime();
    this.token = UUID.randomUUID().toString();
    this.tokenSecret = UUID.randomUUID().toString();
    this.enabled = 1;
  }

  public UserAccess(long id, long userId, long created, String token, String tokenSecret,
      int enabled) {
    super();
    this.id = id;
    this.userId = userId;
    this.created = created;
    this.token = token;
    this.tokenSecret = tokenSecret;
    this.enabled = enabled;
  }

  @Override
  public String toString() {
    return "UserAccess [id=" + id + ", userId=" + userId + ", created=" + created + ", token="
        + token + ", tokenSecret=" + tokenSecret + ", enabled=" + enabled + "]";
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }

  public long getCreated() {
    return created;
  }

  public void setCreated(long created) {
    this.created = created;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public String getTokenSecret() {
    return tokenSecret;
  }

  public void setTokenSecret(String tokenSecret) {
    this.tokenSecret = tokenSecret;
  }

  public int getEnabled() {
    return enabled;
  }

  public void setEnabled(int enabled) {
    this.enabled = enabled;
  }

}
