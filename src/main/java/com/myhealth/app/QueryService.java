package com.myhealth.app;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myhealth.dao.MyHealthDAO;
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
import com.myhealth.model.UserAccess;

/**
 * The query model
 * 
 * @author nelson.okello
 * 
 */
@Service(value = "queryService")
public class QueryService {

  private static final Logger LOGGER = Logger.getLogger(QueryService.class);

  private @Autowired
  MyHealthDAO myHealthDAO;

  public Set<MailMessage> getMailMessages(long recipientId, int read) {
    return myHealthDAO.getMailMessages(recipientId, read);
  }

  public Set<Answer> getAnswers(final long postId, final int page, final int offset) {
    Set<Answer> answers = new HashSet<Answer>();
    try {
      answers = myHealthDAO.getAnswers(postId, page, offset);
    } catch (Exception e) {
      LOGGER.error(String.format("Message: %s\nTrace: %s\n", e.getMessage(),
          ExceptionUtils.getStackTrace(e)));
    }

    return answers;
  }

  public Set<Post> getPosts(final int page, final int offset) {
    Set<Post> posts = new HashSet<Post>();
    try {
      posts = myHealthDAO.getPosts(page, offset);
    } catch (Exception e) {
      LOGGER.error(String.format("Message: %s\nTrace: %s\n", e.getMessage(),
          ExceptionUtils.getStackTrace(e)));
    }

    return posts;
  }

  public Set<Article> getArticles(final int page, final int offset) {
    Set<Article> articles = new HashSet<Article>();
    try {
      articles = myHealthDAO.getArticles(page, offset);
    } catch (Exception e) {
      LOGGER.error(String.format("Message: %s\nTrace: %s\n", e.getMessage(),
          ExceptionUtils.getStackTrace(e)));
    }

    return articles;
  }

  public Set<Disease> getDiseases(final int page, final int offset) {
    Set<Disease> diseases = new HashSet<Disease>();
    try {
      diseases = myHealthDAO.getDiseases(page, offset);
    } catch (Exception e) {
      LOGGER.error(String.format("Message: %s\nTrace: %s\n", e.getMessage(),
          ExceptionUtils.getStackTrace(e)));
    }

    return diseases;
  }

  public Set<Drug> getDrugs(final int page, final int offset) {
    Set<Drug> drugs = new HashSet<Drug>();
    try {
      drugs = myHealthDAO.getDrugs(page, offset);
    } catch (Exception e) {
      LOGGER.error(String.format("Message: %s\nTrace: %s\n", e.getMessage(),
          ExceptionUtils.getStackTrace(e)));
    }

    return drugs;
  }

  public Set<InsuranceCoverageDoctor> getInsuranceCoverageDoctors(final int page, final int offset) {
    Set<InsuranceCoverageDoctor> doctors = new HashSet<InsuranceCoverageDoctor>();
    try {
      doctors = myHealthDAO.getInsuranceCoverageDoctors(page, offset);
    } catch (Exception e) {
      LOGGER.error(String.format("Message: %s\nTrace: %s\n", e.getMessage(),
          ExceptionUtils.getStackTrace(e)));
    }

    return doctors;
  }

  public Set<InsuranceCoverageHospital> getInsuranceCoverageHospitals(final int page,
      final int offset) {
    Set<InsuranceCoverageHospital> hospitals = new HashSet<InsuranceCoverageHospital>();
    try {
      hospitals = myHealthDAO.getInsuranceCoverageHospitals(page, offset);
    } catch (Exception e) {
      LOGGER.error(String.format("Message: %s\nTrace: %s\n", e.getMessage(),
          ExceptionUtils.getStackTrace(e)));
    }

    return hospitals;
  }

  public Set<InsuranceCompany> getInsuranceCompanies(final int page, final int offset) {
    Set<InsuranceCompany> companies = new HashSet<InsuranceCompany>();
    try {
      companies = myHealthDAO.getInsuranceCompanies(page, offset);
    } catch (Exception e) {
      LOGGER.error(String.format("Message: %s\nTrace: %s\n", e.getMessage(),
          ExceptionUtils.getStackTrace(e)));
    }

    return companies;
  }

  public Set<HealthClub> getHealthClubs(final int page, final int offset) {
    Set<HealthClub> clubs = new HashSet<HealthClub>();
    try {
      clubs = myHealthDAO.getHealthClubs(page, offset);
    } catch (Exception e) {
      LOGGER.error(String.format("Message: %s\nTrace: %s\n", e.getMessage(),
          ExceptionUtils.getStackTrace(e)));
    }

    return clubs;
  }

  public Set<Hospital> getHospitals(final int page, final int offset) {
    Set<Hospital> hospitals = new HashSet<Hospital>();
    try {
      hospitals = myHealthDAO.getHospitals(page, offset);
    } catch (Exception e) {
      LOGGER.error(String.format("Message: %s\nTrace: %s\n", e.getMessage(),
          ExceptionUtils.getStackTrace(e)));
    }

    return hospitals;
  }

  public Set<Nutritionist> getNutritionists(final int page, final int offset) {
    Set<Nutritionist> nutritionists = new HashSet<Nutritionist>();
    try {
      nutritionists = myHealthDAO.getNutritionists(page, offset);
    } catch (Exception e) {
      LOGGER.error(String.format("Message: %s\nTrace: %s\n", e.getMessage(),
          ExceptionUtils.getStackTrace(e)));
    }

    return nutritionists;
  }

  public Set<PersonalTrainer> getPersonalTrainers(final int page, final int offset) {
    Set<PersonalTrainer> personalTrainers = new HashSet<PersonalTrainer>();
    try {
      personalTrainers = myHealthDAO.getPersonalTrainers(page, offset);
    } catch (Exception e) {
      LOGGER.error(String.format("Message: %s\nTrace: %s\n", e.getMessage(),
          ExceptionUtils.getStackTrace(e)));
    }

    return personalTrainers;
  }

  /**
   * 
   * @param page
   * @param offset
   * @return
   */
  public Set<Nurse> getNurses(final int page, final int offset) {
    Set<Nurse> nurses = new HashSet<Nurse>();
    try {
      nurses = myHealthDAO.getNurses(page, offset);
    } catch (Exception e) {
      LOGGER.error(String.format("Message: %s\nTrace: %s\n", e.getMessage(),
          ExceptionUtils.getStackTrace(e)));
    }

    return nurses;
  }

  /**
   * 
   * @param page
   * @param offset
   * @return
   */
  public Set<Doctor> getDoctors(final int page, final int offset) {
    Set<Doctor> doctors = new HashSet<Doctor>();
    try {
      doctors = myHealthDAO.getDoctors(page, offset);

    } catch (Exception e) {
      LOGGER.error(String.format("Message: %s\nTrace: %s\n", e.getMessage(),
          ExceptionUtils.getStackTrace(e)));
    }

    return doctors;
  }

  /**
   * Performs authentication
   * 
   * @return Returns the logged on user
   */
  public Map<String, Object> login(final String username, final String password, final String imei) {
    User u = null;
    Map<String, Object> userDetails = new HashMap<String, Object>();

    try {
      u = myHealthDAO.getUserByUsername(username);
      if (u.getId() > 0) {
        userDetails.put("details", u);
        UserAccess access = new UserAccess(u.getId());
        userDetails.put("access", access);

      }

    } catch (Exception e) {
    }

    return userDetails;
  }

  /**
   * Retrieves dashboard elements
   * 
   * @return Returns dashboard elements
   */
  public Set<DashboardElement> dashboard() {
    Set<DashboardElement> ds = new HashSet<DashboardElement>();
    try {
      ds = myHealthDAO.getDashboard();
    } catch (Exception e) {
    }

    return ds;
  }

  /**
   * Retrieves topics
   * 
   * @return Returns a list of topics
   */
  public Set<Topic> topics() {
    Set<Topic> topics = new HashSet<Topic>();
    try {
      topics = myHealthDAO.getTopics();
    } catch (Exception e) {
    }

    return topics;
  }

  /**
   * Retrieves items
   * 
   * @param itemType
   *          Type of items to retrieve
   * @param topicId
   *          Topics whose items are to be retrieved
   * @param page
   *          Page to retrieve
   * @param offset
   *          The number of items per page
   * @return Returns items
   */
  public Set<Item> items(String itemType, long topicId, int page, int offset) {
    Set<Item> items = new HashSet<Item>();
    try {
      items = myHealthDAO.getItems(topicId, itemType);
    } catch (Exception e) {
    }

    return items;
  }
}
