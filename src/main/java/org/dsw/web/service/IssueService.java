package org.dsw.web.service;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.dsw.web.model.Issue;

// The @Stateless annotation eliminates the need for manual transaction demarcation
@Stateless
public class IssueService {

   @Inject
   private Logger log;

   @Inject
   private EntityManager em;

   @Inject
   private Event<Issue> issueEventSrc;

   public void addIssue(Issue issue) throws Exception {
      log.info("Adding issue " + issue.getIssueID());
      em.persist(issue);
      issueEventSrc.fire(issue);
      
   }
   
   public List<Issue> getIssue(int issueID) throws Exception{
	   log.info("Retrieving issue id:" + issueID);
	   @SuppressWarnings("unchecked")
	final List<Issue> results =
               em.createQuery(
               "select e from Waterpoint e where e.waterpointId = " + issueID).getResultList();
       return results;
   }
   
}
