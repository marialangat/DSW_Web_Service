package org.dsw.web.rest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.dsw.web.model.Issue;

/**
 * JAX-RS Example
 * 
 * This class produces a RESTful service to read the contents of the issues
 * table.
 */
@Path("/issues")
@Stateless
public class IssueResourceRESTService extends BaseEntityService<Issue> {

	public IssueResourceRESTService() {
		super(Issue.class);
	}

	@PUT
	@Path("/put")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(Issue issue) {
		try {
			String result = "Issue created : " + issue.getIssueID();
			getEntityManager().persist(issue);

			return Response.status(201).entity(result).build();
		} catch (Exception e) {
			// Finally, handle unexpected exceptions
			Map<String, Object> errors = new HashMap<String, Object>();
			errors.put("errors", Collections.singletonList(e.getMessage()));
			// A WebApplicationException can wrap a response
			// Throwing the exception causes an automatic rollback
			throw new WebApplicationException(Response
					.status(Response.Status.BAD_REQUEST).entity(errors).build());
		}

	}

	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(Issue issue) {
		try {
			String result = "Issue created : " + issue.getIssueID();
			getEntityManager().merge(issue);

			return Response.status(201).entity(result).build();
		} catch (Exception e) {
			// Finally, handle unexpected exceptions
			Map<String, Object> errors = new HashMap<String, Object>();
			errors.put("errors", Collections.singletonList(e.getMessage()));
			// A WebApplicationException can wrap a response
			// Throwing the exception causes an automatic rollback
			throw new WebApplicationException(Response
					.status(Response.Status.BAD_REQUEST).entity(errors).build());
		}

	}

	@Override
	protected Predicate[] extractPredicates(
			MultivaluedMap<String, String> queryParameters,
			CriteriaBuilder criteriaBuilder, Root<Issue> root) {
		List<Predicate> predicates = new ArrayList<Predicate>();

		if (queryParameters.containsKey("issueType")) {

			String issueType = queryParameters.getFirst("issueType");

			predicates.add(criteriaBuilder.equal(root.get("issueType"),
					issueType));
		}
		if (queryParameters.containsKey("waterpointID")) {

			String waterpointID = queryParameters.getFirst("waterpointID");

			predicates.add(criteriaBuilder.equal(root.get("waterpointID"),
					waterpointID));
		}

		return predicates.toArray(new Predicate[] {});

	}

}
