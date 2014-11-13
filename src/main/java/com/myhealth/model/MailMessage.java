package com.myhealth.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mail_message")
public class MailMessage implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  private long id;

  private long senderId;

  private long recipientId;

  private String senderName;

  private String subject;

  private String message;

  private String sentAt;

  private int read;

  private String attachmentPath;

  MailMessage() {
  }

  public MailMessage(long id, long senderId, long recipientId, String senderName, String subject,
      String message, String sentAt, int read, String attachmentPath) {
    super();
    this.id = id;
    this.senderId = senderId;
    this.recipientId = recipientId;
    this.senderName = senderName;
    this.subject = subject;
    this.message = message;
    this.sentAt = sentAt;
    this.read = read;
    this.attachmentPath = attachmentPath;
  }

  @Override
  public String toString() {
    return "MailMessage [id=" + id + ", senderId=" + senderId + ", recipientId=" + recipientId
        + ", senderName=" + senderName + ", subject=" + subject + ", message=" + message
        + ", sentAt=" + sentAt + ", read=" + read + ", attachmentPath=" + attachmentPath + "]";
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getSenderId() {
    return senderId;
  }

  public void setSenderId(long senderId) {
    this.senderId = senderId;
  }

  public long getRecipientId() {
    return recipientId;
  }

  public void setRecipientId(long recipientId) {
    this.recipientId = recipientId;
  }

  public String getSenderName() {
    return senderName;
  }

  public void setSenderName(String senderName) {
    this.senderName = senderName;
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public int getRead() {
    return read;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getSentAt() {
    return sentAt;
  }

  public void setSentAt(String sentAt) {
    this.sentAt = sentAt;
  }

  public int isRead() {
    return read;
  }

  public void setRead(int read) {
    this.read = read;
  }

  public String getAttachmentPath() {
    return attachmentPath;
  }

  public void setAttachmentPath(String attachmentPath) {
    this.attachmentPath = attachmentPath;
  }

}
