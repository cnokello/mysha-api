package com.myhealth.app;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myhealth.model.Answer;
import com.myhealth.model.Post;
import com.myhealth.model.User;
import com.myhealth.model.Vote;
import com.myhealth.util.GeneralUtils;

/**
 * The update model
 * 
 * @author nelson.okello
 * 
 */
@Service(value = "persistenceService")
public class PersistenceService {

  private static final Logger LOGGER = Logger.getLogger(PersistenceService.class);

  private @Autowired
  KafkaProducerService kafkaProducer;

  private @Autowired
  GeneralUtils generalUtils;

  private static final Long ID_LOWER = 1000000l;

  private static final Long ID_UPPER = 100000000l;

  public boolean createVote(Vote v) {
    v.setVoteDate(new java.sql.Date(new java.util.Date().getTime()));
    v.setId(generalUtils.generateRandomLongNum(ID_LOWER, ID_UPPER));
    LOGGER.info(v.toString());

    return true;
  }

  public boolean createPost(Post p) {
    p.setPublicationDate(new java.sql.Date(new java.util.Date().getTime()));
    p.setId(generalUtils.generateRandomLongNum(ID_LOWER, ID_UPPER));
    LOGGER.info(p.toString());

    return true;
  }

  public boolean createPostAnswer(Answer a) {
    a.setPublicationDate(new java.sql.Date(new java.util.Date().getTime()));
    a.setId(generalUtils.generateRandomLongNum(ID_LOWER, ID_UPPER));
    LOGGER.info(a.toString());

    return true;
  }

  public boolean createUser(final User u) {
    Map<String, String> createUserEvent = new HashMap<String, String>();
    createUserEvent.put("topic", "ACCOUNT");
    createUserEvent.put("action", "CREATE");
    createUserEvent.put("content", u.toEventString());

    return true; // kafkaProducer.send(String.valueOf(u.getId()), createUserEvent);
  }

  public boolean createSocialNetworkAccount(final User u) {
    Map<String, String> createUserEvent = new HashMap<String, String>();
    createUserEvent.put("topic", "ACCOUNT");
    createUserEvent.put("action", "CREATE_FB");
    createUserEvent.put("content", u.toEventString());

    return true; // kafkaProducer.send(String.valueOf(u.getId()), createUserEvent);
  }

}
