package com.myhealth.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myhealth.model.Answer;
import com.myhealth.model.Article;
import com.myhealth.model.DashboardElement;
import com.myhealth.model.Disease;
import com.myhealth.model.Doctor;
import com.myhealth.model.Drug;
import com.myhealth.model.HealthClub;
import com.myhealth.model.Hospital;
import com.myhealth.model.InsuranceCompany;
import com.myhealth.model.InsuranceCoverageDoctor;
import com.myhealth.model.InsuranceCoverageHospital;
import com.myhealth.model.Item;
import com.myhealth.model.MailMessage;
import com.myhealth.model.Nurse;
import com.myhealth.model.Nutritionist;
import com.myhealth.model.PersonalTrainer;
import com.myhealth.model.Post;
import com.myhealth.model.Topic;
import com.myhealth.model.User;

/**
 * The query class for the UI
 * 
 * @author nelson.okello
 * 
 */
@Service(value = "myHealthDAO")
public class MyHealthDAO {

  private @Autowired
  SessionFactory sessionFactory;

  private static final Logger LOGGER = Logger.getLogger(MyHealthDAO.class);

  public Set<MailMessage> getMailMessages(long recipientId, int read) {
    Session session = null;
    Set<MailMessage> msgs = new HashSet<MailMessage>();

    try {
      session = sessionFactory.openSession();
      Query q = session
          .createQuery("FROM MailMessage WHERE recipientId = :recipientId AND read = :read")
          .setLong("recipientId", recipientId).setInteger("read", read);
      msgs.addAll(q.list());

    } catch (Exception e) {
      LOGGER.error(String.format("Message: %s\nTrace: %s\n", e.getMessage(),
          ExceptionUtils.getStackTrace(e)));
    } finally {
      if (session != null) {
        try {
          session.close();
        } catch (Exception e) {
        }
      }
    }

    return msgs;
  }

  public Set<Answer> getAnswers(long postId, final int page, final int offset) throws Exception {
    Session session = null;
    Set<Answer> answers = new HashSet<Answer>();

    try {
      session = sessionFactory.openSession();
      Query q = session.createQuery("FROM Answer WHERE postId = :postId").setLong("postId", postId)
          .setMaxResults(offset);
      answers.addAll(q.list());

    } catch (Exception e) {
      LOGGER.error(String.format("Message: %s\nTrace: %sn", e.getMessage(),
          ExceptionUtils.getStackTrace(e)));
    } finally {
      if (session != null) {
        try {
          session.close();
        } catch (Exception e) {
        }
      }
    }

    return answers;

  }

  public Set<Post> getPosts(final int page, final int offset) throws Exception {
    Session session = null;
    Set<Post> posts = new HashSet<Post>();

    try {
      session = sessionFactory.openSession();
      Query q = session.createQuery("FROM Post").setMaxResults(offset);

      posts.addAll(q.list());

    } catch (Exception e) {
      LOGGER.error(String.format("Message: %s\nTrace: %s\n", e.getMessage(),
          ExceptionUtils.getStackTrace(e)));
    } finally {
      if (session != null) {
        try {
          session.close();
        } catch (Exception e) {
        }
      }
    }

    return posts;
  }

  public Set<Article> getArticles(final int page, final int offset) throws Exception {
    Session session = null;
    Set<Article> articles = new HashSet<Article>();

    try {
      session = sessionFactory.openSession();
      Query q = session.createQuery("FROM Article").setMaxResults(offset);

      List<Article> _articles = q.list();
      for (Article _article : _articles) {
        String tags = _article.getTagsString();
        if (tags != null) {
          _article.setTags(tags.split("#"));
        }

        articles.add(_article);
      }

    } catch (Exception e) {
      LOGGER.error(String.format("Message: %s\nTrace: %s\n", e.getMessage(),
          ExceptionUtils.getStackTrace(e)));
    } finally {
      if (session != null) {
        try {
          session.close();
        } catch (Exception e) {
        }
      }
    }

    return articles;
  }

  public Set<Disease> getDiseases(final int page, final int offset) throws Exception {
    Session session = null;
    Set<Disease> diseases = new HashSet<Disease>();

    try {
      session = sessionFactory.openSession();
      Query q = session.createQuery("FROM Disease").setMaxResults(offset);
      diseases.addAll(q.list());

    } catch (Exception e) {
      LOGGER.error(String.format("Message: %s\nTrace: %s\n", e.getMessage(),
          ExceptionUtils.getStackTrace(e)));
    } finally {
      if (session != null) {
        try {
          session.close();
        } catch (Exception e) {
        }
      }
    }

    return diseases;
  }

  public Set<Drug> getDrugs(final int page, final int offset) throws Exception {
    Session session = null;
    Set<Drug> drugs = new HashSet<Drug>();

    try {
      session = sessionFactory.openSession();
      Query q = session.createQuery("FROM Drug").setMaxResults(offset);
      drugs.addAll(q.list());

    } catch (Exception e) {
      LOGGER.error(String.format("Message: %s\nTrace: %s\n", e.getMessage(),
          ExceptionUtils.getStackTrace(e)));
    } finally {
      if (session != null) {
        try {
          session.close();
        } catch (Exception e) {
        }
      }
    }

    return drugs;
  }

  public Set<InsuranceCoverageDoctor> getInsuranceCoverageDoctors(final int page, final int offset)
      throws Exception {
    Session session = null;
    Set<InsuranceCoverageDoctor> doctors = new HashSet<InsuranceCoverageDoctor>();

    try {
      session = sessionFactory.openSession();
      Query q = session.createQuery("FROM InsuranceCoverageDoctor").setMaxResults(offset);
      doctors.addAll(q.list());

    } catch (Exception e) {
      LOGGER.error(String.format("Message: %s\nTrace: %s\n", e.getMessage(),
          ExceptionUtils.getStackTrace(e)));
    } finally {
      if (session != null) {
        try {
          session.close();
        } catch (Exception e) {
        }
      }
    }

    return doctors;
  }

  public Set<InsuranceCoverageHospital> getInsuranceCoverageHospitals(final int page,
      final int offset) throws Exception {

    Session session = null;
    Set<InsuranceCoverageHospital> hospitals = new HashSet<InsuranceCoverageHospital>();

    try {
      session = sessionFactory.openSession();
      Query q = session.createQuery("FROM InsuranceCoverageHospital").setMaxResults(offset);
      hospitals.addAll(q.list());

    } catch (Exception e) {
      LOGGER.error(String.format("Message: %s\nTrace: %s\n", e.getMessage(),
          ExceptionUtils.getStackTrace(e)));
    } finally {
      if (session != null) {
        try {
          session.close();
        } catch (Exception e) {
        }
      }
    }

    return hospitals;
  }

  /**
   * 
   * @param page
   * @param offset
   * @return
   * @throws Exception
   */
  public Set<InsuranceCompany> getInsuranceCompanies(final int page, final int offset)
      throws Exception {
    Session session = null;
    Set<InsuranceCompany> companies = new HashSet<InsuranceCompany>();

    try {
      session = sessionFactory.openSession();
      Query q = session.createQuery("FROM InsuranceCompany").setMaxResults(offset);
      companies.addAll(q.list());

    } catch (Exception e) {
      LOGGER.error(String.format("Message: %s\nTrace: %s\n", e.getMessage(),
          ExceptionUtils.getStackTrace(e)));
    } finally {
      if (session != null) {
        try {
          session.close();
        } catch (Exception e) {
        }
      }
    }

    return companies;
  }

  /**
   * 
   * @param page
   * @param offset
   * @return
   * @throws Exception
   */
  public Set<HealthClub> getHealthClubs(final int page, final int offset) throws Exception {
    Session session = null;
    Set<HealthClub> clubs = new HashSet<HealthClub>();

    try {
      session = sessionFactory.openSession();
      Query q = session.createQuery("FROM HealthClub").setMaxResults(offset);
      clubs.addAll(q.list());

    } catch (Exception e) {
      LOGGER.error(String.format("Message: %s\nTrace: %s\n", e.getMessage(),
          ExceptionUtils.getStackTrace(e)));
    } finally {
      if (session != null) {
        try {
          session.close();
        } catch (Exception e) {
        }
      }
    }

    return clubs;
  }

  /**
   * 
   * @param page
   * @param offset
   * @return
   * @throws Exception
   */
  public Set<Hospital> getHospitals(final int page, final int offset) throws Exception {
    Session session = null;
    Set<Hospital> hospitals = new HashSet<Hospital>();

    try {
      session = sessionFactory.openSession();
      Query q = session.createQuery("FROM Hospital").setMaxResults(offset);
      hospitals.addAll(q.list());

    } catch (Exception e) {
      LOGGER.error(String.format("Message: %s\nTrace: %s\n", e.getMessage(),
          ExceptionUtils.getStackTrace(e)));
    } finally {
      if (session != null) {
        try {
          session.close();
        } catch (Exception e) {
        }
      }
    }

    return hospitals;
  }

  /**
   * 
   * @param page
   * @param offset
   * @return
   * @throws Exception
   */
  public Set<Nutritionist> getNutritionists(final int page, final int offset) throws Exception {
    Session session = null;
    Set<Nutritionist> nutritionists = new HashSet<Nutritionist>();

    try {
      session = sessionFactory.openSession();
      Query q = session.createQuery("FROM Nutritionist").setMaxResults(offset);
      nutritionists.addAll(q.list());

    } catch (Exception e) {
      LOGGER.error(String.format("Message: %s\nTrace: %s\n", e.getMessage(),
          ExceptionUtils.getStackTrace(e)));
    } finally {
      if (session != null) {
        try {
          session.close();
        } catch (Exception e) {
        }
      }
    }

    return nutritionists;
  }

  /**
   * 
   * @param page
   * @param offset
   * @return
   * @throws Exception
   */
  public Set<PersonalTrainer> getPersonalTrainers(final int page, final int offset)
      throws Exception {
    Session session = null;
    Set<PersonalTrainer> personalTrainers = new HashSet<PersonalTrainer>();

    try {
      session = sessionFactory.openSession();
      Query q = session.createQuery("FROM PersonalTrainer").setMaxResults(offset);
      personalTrainers.addAll(q.list());

    } catch (Exception e) {
      LOGGER.error(String.format("Message: %s\nTrace: %s\n", e.getMessage(),
          ExceptionUtils.getStackTrace(e)));
    } finally {
      if (session != null) {
        try {
          session.close();
        } catch (Exception e) {
        }
      }
    }

    return personalTrainers;
  }

  /**
   * 
   * @param page
   * @param offset
   * @return
   * @throws Exception
   */
  public Set<Nurse> getNurses(final int page, final int offset) throws Exception {
    Session session = null;
    Set<Nurse> nurses = new HashSet<Nurse>();
    try {
      session = sessionFactory.openSession();
      Query q = session.createQuery("FROM Nurse").setMaxResults(offset);
      nurses.addAll(q.list());

    } catch (Exception e) {
      LOGGER.error(String.format("Message: %s\nTrace: %s\n", e.getMessage(),
          ExceptionUtils.getStackTrace(e)));
    } finally {
      if (session != null) {
        try {
          session.close();
        } catch (Exception e) {
        }
      }
    }

    return nurses;
  }

  public Set<Doctor> getDoctors(final int page, final int offset) throws Exception {
    Session session = null;
    Set<Doctor> doctors = new HashSet<Doctor>();
    try {
      session = sessionFactory.openSession();
      Query q = session.createQuery("FROM Doctor").setMaxResults(offset);
      doctors.addAll(q.list());

    } catch (Exception e) {
      LOGGER.error(String.format("Message: %s\nTrace: %s\n", e.getMessage(),
          ExceptionUtils.getStackTrace(e)));
    } finally {
      if (session != null) {
        try {
          session.close();
        } catch (Exception e) {
        }
      }
    }

    return doctors;
  }

  /**
   * Retrieves user by username
   * 
   * @param username
   *          Specified username
   * @return Returns the matched user
   * @throws Exception
   */
  public User getUserByUsername(final String username) throws Exception {
    Session session = null;
    User u = new User();

    try {
      session = sessionFactory.openSession();
      Query q = session.createQuery("FROM User WHERE username = :username")
          .setString("username", username).setFetchSize(1);
      List l = q.list();
      if (l != null && l.size() > 0) {
        u = (User) l.get(0);
      }

    } catch (Exception e) {
      LOGGER.error(String.format("Message: %s\nTrace: %s\n", e.getMessage(),
          ExceptionUtils.getStackTrace(e)));

    } finally {
      if (session != null) {
        try {
          session.close();
        } catch (Exception e) {
        }
      }
    }

    return u;
  }

  /**
   * Retrieves dashboard elements
   * 
   * @return Returns dashboard elements
   * @throws Exception
   */
  public Set<DashboardElement> getDashboard() throws Exception {
    Session session = null;
    Set<DashboardElement> d = new HashSet<DashboardElement>();
    try {
      session = sessionFactory.openSession();
      Query q = session.createQuery("From DashboardElement");
      d.addAll(q.list());

    } catch (Exception e) {
      LOGGER.error(String.format("Message: %s\nTrace: %s\n", e.getMessage(),
          ExceptionUtils.getStackTrace(e)));

    } finally {
      if (session != null) {
        try {
          session.close();
        } catch (Exception e) {
        }
      }
    }

    return d;
  }

  /**
   * Retrieves topics
   * 
   * @return Returns a set of topics
   * @throws Exception
   */
  public Set<Topic> getTopics() throws Exception {
    Session session = null;
    Set<Topic> topics = new HashSet<Topic>();

    try {
      session = sessionFactory.openSession();
      Query q = session.createQuery("FROM Topic");
      topics.addAll(q.list());

    } catch (Exception e) {
      LOGGER.error(String.format("Message: %s\nTrace: %s\n", e.getMessage(),
          ExceptionUtils.getStackTrace(e)));

    } finally {
      if (session != null) {
        try {
          session.close();
        } catch (Exception e) {
        }
      }
    }

    return topics;
  }

  /**
   * Retrieves items for the specified topic
   * 
   * @param topicId
   *          Topic whose items are to be retrieved
   * @return Returns items under the specified topic
   * @throws Exception
   */
  public Set<Item> getItems(final long topicId) throws Exception {
    Session session = null;
    Set<Item> items = new HashSet<Item>();

    try {
      session = sessionFactory.openSession();
      Query q = session.createQuery("FROM Item WHERE topicId = :topicId").setLong("topicId",
          topicId);
      items.addAll(q.list());

    } catch (Exception e) {
      LOGGER.error(String.format("Message: %s\nTrace: %s\n", e.getMessage(),
          ExceptionUtils.getStackTrace(e)));

    } finally {
      if (session != null) {
        try {
          session.close();
        } catch (Exception e) {
        }
      }
    }

    return items;
  }

  /**
   * Retrieves items of a specified type
   * 
   * @param itemType
   *          The type of items to retrieve
   * @return Returns items of the specified type
   * @throws Exception
   */
  public Set<Item> getItems(final String itemType) throws Exception {
    Session session = null;
    Set<Item> items = new HashSet<Item>();

    try {
      session = sessionFactory.openSession();
      Query q = session.createQuery("FROM Item WHERE itemType = :itemType").setString("itemType",
          itemType);
      items.addAll(q.list());

    } catch (Exception e) {
      LOGGER.error(String.format("Message: %s\nTrace: %s\n", e.getMessage(),
          ExceptionUtils.getStackTrace(e)));

    } finally {
      if (session != null) {
        try {
          session.close();
        } catch (Exception e) {
        }
      }
    }

    return items;

  }

  /**
   * Retrieves items for a specified topic and type
   * 
   * @param topicId
   *          The topic whose items are to be retrieved
   * @param itemType
   *          The type of items to retrieve
   * @return Returns items with the specified topic and of the specified type
   * @throws Exception
   */
  public Set<Item> getItems(final long topicId, final String itemType) throws Exception {
    Session session = null;
    Set<Item> items = new HashSet<Item>();

    try {
      session = sessionFactory.openSession();
      Query q = session.createQuery("FROM Item WHERE topicId = :topicId AND itemType = :itemType")
          .setLong("topicId", topicId).setString("itemType", itemType);
      items.addAll(q.list());

    } catch (Exception e) {
      LOGGER.error(String.format("Message: %s\nTrace: %s\n", e.getMessage(),
          ExceptionUtils.getStackTrace(e)));

    } finally {
      if (session != null) {
        session.close();
      }
    }

    return items;
  }
}
