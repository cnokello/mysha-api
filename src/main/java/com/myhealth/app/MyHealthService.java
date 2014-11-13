package com.myhealth.app;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
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
import com.myhealth.model.Vote;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * Web service endpoints
 * 
 * @author nelson.okello
 * 
 */
@Path("/")
public class MyHealthService {

  private static final Logger LOGGER = Logger.getLogger(MyHealthService.class);

  private @Autowired
  QueryService query;

  private @Autowired
  PersistenceService persistenceService;

  /**
   * Performs authentication
   * 
   * @param username
   *          Username to authenticate
   * @param password
   *          Password to authenticate
   * @param imei
   *          IMEI to authenticate
   * @return
   */
  @Produces({ "application/x-javascript", MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
  @Path("/login")
  @GET
  public Response login(@QueryParam("username") final String username,
      @QueryParam("password") final String password, @QueryParam("imei") final String imei,
      @QueryParam("format") final String format, @QueryParam("callback") final String callback) {
    Map<String, Object> resp = new HashMap<String, Object>();

    System.out.println("Authentication request received\n\n");
    Map<String, Object> userDetails = query.login(username, password, imei);

    if (userDetails.size() > 0) {
      resp.put("code", 200);
      resp.put("message", "Login successful");
    } else {
      resp.put("code", 201);
      resp.put("message", "Login unsuccessful");
    }

    resp.put("user", userDetails);

    return response(resp, format, callback);
  }

  @Produces({ "application/x-javascript", MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
  @Path("/logout")
  @GET
  public Response logout(@QueryParam("accessToken") final String accessToken,
      @QueryParam("format") final String format, @QueryParam("callback") final String callback) {

    Map<String, Object> resp = new HashMap<String, Object>();
    resp.put("code", 200);
    resp.put("message", "Login successful");

    return response(resp, format, callback);
  }

  /**
   * Creates a new user account
   * 
   * @param username
   * @return
   */
  @Produces({ "application/x-javascript", MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
  @Consumes({ "application/javascript", "application/x-www-form-urlencoded" })
  @Path("/createAccount")
  @POST
  public Response createAccount(@FormParam("username") final String username,
      @FormParam("otherNames") final String otherNames, @FormParam("email") final String email,
      @FormParam("mobile") final String mobile, @FormParam("imei") final String imei,
      @FormParam("surname") final String surname, @FormParam("password") final String password,
      @FormParam("password1") final String password1,
      @FormParam("socialNetworkToken") final String socialNetworkToken,
      @FormParam("socialNetworkSecret") final String socialNetworkSecret,
      @FormParam("socialNetwork") final String socialNetwork,
      @QueryParam("format") final String format, @QueryParam("callback") final String callback) {

    LOGGER.info("Account creation request received");

    User u = new User(surname, otherNames, username, password, password1, email, mobile, imei,
        socialNetworkToken, socialNetworkSecret, socialNetwork);

    // TODO: Call validation service here

    // TODO: Call persistence service here
    Map<String, Object> resp = new HashMap<String, Object>();
    resp.put("userId", u.getId());
    if (persistenceService.createUser(u) == true) {
      resp.put("code", 200);
      resp.put("message", "User creation successful");
    } else {
      resp.put("code", 201);
      resp.put("message", "User creation failed");
    }

    return response(resp, format, callback);
  }

  @Produces({ "application/x-javascript", MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
  @Consumes({ "application/javascript", "application/x-www-form-urlencoded" })
  @Path("/mails")
  @GET
  public Response mails(@QueryParam("format") final String format,
      @QueryParam("callback") final String callback,
      @QueryParam("recipientId") final Long recipientId, @QueryParam("read") final Integer read,
      @QueryParam("accessToken") final String accessToken) {

    Map<String, Object> resp = new HashMap<String, Object>();
    Set<MailMessage> msgs = query.getMailMessages(recipientId, read);

    resp.put("code", 200);
    resp.put("message", "Processing successful");
    resp.put("messages", msgs);

    return response(resp, format, callback);
  }

  @Produces({ "application/x-javascript", MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
  @Consumes({ "application/javascript", "application/x-www-form-urlencoded" })
  @Path("/posts")
  @GET
  public Response posts(@QueryParam("format") final String format,
      @QueryParam("callback") final String callback,
      @QueryParam("accessToken") final String accessToken) {

    Map<String, Object> resp = new HashMap<String, Object>();
    Set<Post> posts = query.getPosts(1, 50);

    resp.put("code", 200);
    resp.put("message", "Processing successful");
    resp.put("posts", posts);

    return response(resp, format, callback);
  }

  @Produces({ "application/x-javascript", MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
  @Consumes({ "application/javascript", "application/x-www-form-urlencoded" })
  @Path("/createPost")
  @GET
  public Response createPost(@QueryParam("format") final String format,
      @QueryParam("callback") final String callback,
      @QueryParam("accessToken") final String accessToken, @QueryParam("userId") final Long userId,
      @QueryParam("userFullName") final String userFullName,
      @QueryParam("postType") final String postType, @QueryParam("postText") final String postText) {

    Map<String, Object> resp = new HashMap<String, Object>();
    Post p = new Post(userId, userFullName, postText, postType);
    persistenceService.createPost(p);

    resp.put("code", 200);
    resp.put("message", "Processing successful");

    return response(resp, format, callback);
  }

  @Produces({ "application/x-javascript", MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
  @Consumes({ "application/javascript", "application/x-www-form-urlencoded" })
  @Path("/vote")
  @GET
  public Response vote(@QueryParam("format") final String format,
      @QueryParam("callback") final String callback,
      @QueryParam("accessToken") final String accessToken, @QueryParam("userId") final Long userId,
      @QueryParam("targetId") final Long targetId,
      @QueryParam("targetType") final String targetType, @QueryParam("vote") final Integer vote) {

    Map<String, Object> resp = new HashMap<String, Object>();
    Vote v = new Vote(userId, targetId, targetType, vote);
    persistenceService.createVote(v);

    resp.put("code", 200);
    resp.put("message", "Processing successful");

    return response(resp, format, callback);
  }

  @Produces({ "application/x-javascript", MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
  @Consumes({ "application/javascript", "application/x-www-form-urlencoded" })
  @Path("/createPostAnswer")
  @GET
  public Response createPostAnswer(@QueryParam("format") final String format,
      @QueryParam("callback") final String callback,
      @QueryParam("accessToken") final String accessToken, @QueryParam("userId") final Long userId,
      @QueryParam("userFullName") final String userFullName,
      @QueryParam("answer") final String answer, @QueryParam("parentPostId") final Long parentPostId) {

    Map<String, Object> resp = new HashMap<String, Object>();
    Answer a = new Answer(parentPostId, answer, userId);
    persistenceService.createPostAnswer(a);

    resp.put("code", 200);
    resp.put("message", "Processing successful");

    return response(resp, format, callback);
  }

  @Produces({ "application/x-javascript", MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
  @Consumes({ "application/javascript", "application/x-www-form-urlencoded" })
  @Path("/articles")
  @GET
  public Response articles(@QueryParam("format") final String format,
      @QueryParam("callback") final String callback,
      @QueryParam("accessToken") final String accessToken, @QueryParam("postId") final Long postId) {

    Map<String, Object> resp = new HashMap<String, Object>();
    Set<Article> articles = new HashSet<Article>();
    if (postId != null) {
      articles = query.getArticles(1, 50);
    } else {
      articles = query.getArticles(1, 50);
    }

    resp.put("code", 200);
    resp.put("message", "Processing successful");
    resp.put("articles", articles);

    return response(resp, format, callback);
  }

  @Produces({ "application/x-javascript", MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
  @Consumes({ "application/javascript", "application/x-www-form-urlencoded" })
  @Path("/personalTrainers")
  @GET
  public Response personalTrainers(@QueryParam("format") final String format,
      @QueryParam("callback") final String callback,
      @QueryParam("accessToken") final String accessToken) {

    Map<String, Object> resp = new HashMap<String, Object>();
    Set<PersonalTrainer> personalTrainers = query.getPersonalTrainers(1, 50);

    resp.put("code", 200);
    resp.put("message", "Processing successful");
    resp.put("personalTrainers", personalTrainers);

    return response(resp, format, callback);
  }

  @Produces({ "application/x-javascript", MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
  @Consumes({ "application/javascript", "application/x-www-form-urlencoded" })
  @Path("/diseases")
  @GET
  public Response diseases(@QueryParam("format") final String format,
      @QueryParam("callback") final String callback,
      @QueryParam("accessToken") final String accessToken) {

    Map<String, Object> resp = new HashMap<String, Object>();
    Set<Disease> diseases = query.getDiseases(1, 50);

    resp.put("code", 200);
    resp.put("message", "Processing successful");
    resp.put("diseases", diseases);

    return response(resp, format, callback);
  }

  @Produces({ "application/x-javascript", MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
  @Consumes({ "application/javascript", "application/x-www-form-urlencoded" })
  @Path("/drugs")
  @GET
  public Response drugs(@QueryParam("format") final String format,
      @QueryParam("callback") final String callback,
      @QueryParam("accessToken") final String accessToken) {

    Map<String, Object> resp = new HashMap<String, Object>();
    Set<Drug> drugs = query.getDrugs(1, 50);

    resp.put("code", 200);
    resp.put("message", "Processing successful");
    resp.put("drugs", drugs);

    return response(resp, format, callback);
  }

  @Produces({ "application/x-javascript", MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
  @Consumes({ "application/javascript", "application/x-www-form-urlencoded" })
  @Path("/insuranceCoverageDoctors")
  @GET
  public Response insuranceCoverageDoctors(@QueryParam("format") final String format,
      @QueryParam("callback") final String callback,
      @QueryParam("accessToken") final String accessToken) {

    Map<String, Object> resp = new HashMap<String, Object>();
    Set<InsuranceCoverageDoctor> doctors = query.getInsuranceCoverageDoctors(1, 50);

    resp.put("code", 200);
    resp.put("message", "Processing successful");
    resp.put("coverageDoctors", doctors);

    return response(resp, format, callback);
  }

  @Produces({ "application/x-javascript", MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
  @Consumes({ "application/javascript", "application/x-www-form-urlencoded" })
  @Path("/insuranceCoverageHospitals")
  @GET
  public Response insuranceCoverageHospitals(@QueryParam("format") final String format,
      @QueryParam("callback") final String callback,
      @QueryParam("accessToken") final String accessToken) {

    Map<String, Object> resp = new HashMap<String, Object>();
    Set<InsuranceCoverageHospital> companies = query.getInsuranceCoverageHospitals(1, 50);

    resp.put("code", 200);
    resp.put("message", "Processing successful");
    resp.put("coverageHospitals", companies);

    return response(resp, format, callback);
  }

  @Produces({ "application/x-javascript", MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
  @Consumes({ "application/javascript", "application/x-www-form-urlencoded" })
  @Path("/insuranceCompanies")
  @GET
  public Response insuranceCompanies(@QueryParam("format") final String format,
      @QueryParam("callback") final String callback,
      @QueryParam("accessToken") final String accessToken) {

    Map<String, Object> resp = new HashMap<String, Object>();
    Set<InsuranceCompany> companies = query.getInsuranceCompanies(1, 50);

    resp.put("code", 200);
    resp.put("message", "Processing successful");
    resp.put("insuranceCompanies", companies);

    return response(resp, format, callback);
  }

  @Produces({ "application/x-javascript", MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
  @Consumes({ "application/javascript", "application/x-www-form-urlencoded" })
  @Path("/healthClubs")
  @GET
  public Response healthClubs(@QueryParam("format") final String format,
      @QueryParam("callback") final String callback,
      @QueryParam("accessToken") final String accessToken) {

    Map<String, Object> resp = new HashMap<String, Object>();
    Set<HealthClub> clubs = query.getHealthClubs(1, 50);

    resp.put("code", 200);
    resp.put("message", "Processing successful");
    resp.put("healthClubs", clubs);

    return response(resp, format, callback);
  }

  @Produces({ "application/x-javascript", MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
  @Consumes({ "application/javascript", "application/x-www-form-urlencoded" })
  @Path("/hospitals")
  @GET
  public Response hospitals(@QueryParam("format") final String format,
      @QueryParam("callback") final String callback,
      @QueryParam("accessToken") final String accessToken) {

    Map<String, Object> resp = new HashMap<String, Object>();
    Set<Hospital> hospitals = query.getHospitals(1, 50);

    resp.put("code", 200);
    resp.put("message", "Processing successful");
    resp.put("hospitals", hospitals);

    return response(resp, format, callback);
  }

  @Produces({ "application/x-javascript", MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
  @Consumes({ "application/javascript", "application/x-www-form-urlencoded" })
  @Path("/nutritionists")
  @GET
  public Response nutritionists(@QueryParam("format") final String format,
      @QueryParam("callback") final String callback,
      @QueryParam("accessToken") final String accessToken) {

    Map<String, Object> resp = new HashMap<String, Object>();
    Set<Nutritionist> nutritionists = query.getNutritionists(1, 50);

    resp.put("code", 200);
    resp.put("message", "Processing successful");
    resp.put("nutritionists", nutritionists);

    return response(resp, format, callback);
  }

  @Produces({ "application/x-javascript", MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
  @Consumes({ "application/javascript", "application/x-www-form-urlencoded" })
  @Path("/nurses")
  @GET
  public Response nurses(@QueryParam("format") final String format,
      @QueryParam("callback") final String callback,
      @QueryParam("accessToken") final String accessToken) {

    Map<String, Object> resp = new HashMap<String, Object>();
    Set<Nurse> nurses = query.getNurses(1, 50);

    resp.put("code", 200);
    resp.put("message", "Processing successful");
    resp.put("nurses", nurses);

    return response(resp, format, callback);
  }

  @Produces({ "application/x-javascript", MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
  @Consumes({ "application/javascript", "application/x-www-form-urlencoded" })
  @Path("/doctors")
  @GET
  public Response doctors(@QueryParam("format") final String format,
      @QueryParam("callback") final String callback,
      @QueryParam("accessToken") final String accessToken) {
    Map<String, Object> resp = new HashMap<String, Object>();
    Set<Doctor> doctors = query.getDoctors(1, 50);

    resp.put("code", 200);
    resp.put("message", "Processing successful");
    resp.put("doctors", doctors);

    return response(resp, format, callback);
  }

  @Produces({ "application/x-javascript", MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
  @Consumes({ "application/javascript", "application/x-www-form-urlencoded" })
  @Path("/answers")
  @GET
  public Response answers(@QueryParam("format") final String format,
      @QueryParam("callback") final String callback,
      @QueryParam("accessToken") final String accessToken, @QueryParam("postId") final Long postId) {
    Map<String, Object> resp = new HashMap<String, Object>();
    Set<Answer> answers = query.getAnswers(postId, 1, 50);

    resp.put("code", 200);
    resp.put("message", "Processing successful");
    resp.put("answers", answers);

    return response(resp, format, callback);
  }

  /**
   * 
   * @return Returns the main menu elements of the app
   */
  @Produces({ "application/x-javascript", MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
  @Path("/dashboard")
  @GET
  public Response dashboard(@QueryParam("format") final String format,
      @QueryParam("callback") final String callback) {
    LOGGER.info("Dashboard request received");
    Set<DashboardElement> dashboard = query.dashboard();
    Map<String, Object> resp = new HashMap<String, Object>();
    resp.put("code", 200);
    resp.put("message", "Processing successful");
    resp.put("dashboard", dashboard);

    return response(resp, format, callback);
  }

  /**
   * Retrieves topics
   * 
   * @return Returns topics
   */
  @Produces({ "application/x-javascript", MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
  @Path("/topics")
  @GET
  public Response topics(@QueryParam("format") final String format,
      @QueryParam("callback") final String callback) {
    LOGGER.info("Topics request received");
    Set<Topic> topics = query.topics();
    Map<String, Object> resp = new HashMap<String, Object>();
    resp.put("code", 200);
    resp.put("message", "Processing successfula");
    resp.put("topics", topics);

    return response(resp, format, callback);
  }

  /**
   * Retrieves item of the specific type specified topic id
   * 
   * @param topicId
   * @return
   */
  @Produces({ "application/x-javascript", MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
  @Path("/items/{itemType}/{topicId}")
  @GET
  public Response items(@PathParam("itemType") final String itemType,
      @PathParam("topicId") final long topicId, @PathParam("page") final int page,
      @PathParam("offset") final int offset, @QueryParam("format") final String format,
      @QueryParam("callback") final String callback) {

    LOGGER.info("Items request received");
    Set<Item> items = query.items(itemType, topicId, page, offset);
    Map<String, Object> resp = new HashMap<String, Object>();
    resp.put("code", 200);
    resp.put("message", "Processing successful");
    resp.put("items", items);

    return response(resp, format, callback);
  }

  @Produces({ "application/x-javascript", MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
  @Path("/diseases/{keywords}")
  @GET
  public Response searchDisease() {
    return Response.status(Status.OK).type("application/json").entity(new Gson().toJson(success()))
        .build();
  }

  @Produces({ "application/x-javascript", MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
  @Path("/diseases/{diseaseId}/symptoms")
  @GET
  public Response getDiseaseSymptoms() {
    return Response.status(Status.OK).type("application/json").entity(new Gson().toJson(success()))
        .build();
  }

  @Produces({ "application/x-javascript", MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
  @Path("/drugs/{keywords}")
  @GET
  public Response searchDrug() {
    return Response.status(Status.OK).type("application/json").entity(new Gson().toJson(success()))
        .build();
  }

  @Produces({ "application/x-javascript", MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
  @Path("/drugs/{drugId}/sideEffects")
  @GET
  public Response getDrugSideEffects() {
    return Response.status(Status.OK).type("application/json").entity(new Gson().toJson(success()))
        .build();
  }

  /**
   * A success message to send to a client when a request has been processed successfully
   * 
   * @return
   */
  public Map<String, Object> success() {
    Map<String, Object> success = new HashMap<String, Object>();
    success.put("code", 200);
    success.put("message", "Processing successful");

    return success;
  }

  /**
   * A failure message to send when a request processing failed
   * 
   * @return
   */
  public Map<String, Object> failure() {
    Map<String, Object> failure = new HashMap<String, Object>();
    failure.put("code", 201);
    failure.put("message", "Processing failed");

    return failure;
  }

  public Response response(Map<String, Object> resp, String format, String callback) {
    Response response = null;
    if (format != null && format.equals("xml")) {
      XStream xStream = new XStream(new DomDriver());
      xStream.alias("account", java.util.Map.class);

      if (callback != null) {
        response = Response.status(Status.OK).type("application/x-javascript")
            .entity(xStream.toXML(resp)).build();
      } else {
        response = Response.status(Status.OK).type("application/xml").entity(xStream.toXML(resp))
            .build();
      }

    } else {
      if (callback != null) {
        response = Response.status(Status.OK).type("application/x-javascript")
            .entity(new Gson().toJson(resp)).build();
      } else {
        response = Response.status(Status.OK).type("application/json")
            .entity(new Gson().toJson(resp)).build();
      }
    }

    return response;
  }
}
