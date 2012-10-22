package org.dsw.web.rest;

import javax.ejb.Stateless;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.dsw.web.model.Waterpoint;

/**
 * JAX-RS Example
 * 
 * This class produces a RESTful service to read the contents of the waterpoints
 * table.
 */
@Path("/waterpoints")
@Stateless
public class WaterpointResourceRESTService extends
		BaseEntityService<Waterpoint> {

	public WaterpointResourceRESTService() {
		super(Waterpoint.class);
	}

	@GET
	@Path("/{id:[0-9][0-9]*}")
	@Produces(MediaType.APPLICATION_JSON)
	public Waterpoint getSingleInstance(@PathParam("id") String id) {
		final CriteriaBuilder criteriaBuilder = getEntityManager()
				.getCriteriaBuilder();
		final CriteriaQuery<Waterpoint> criteriaQuery = criteriaBuilder
				.createQuery(Waterpoint.class);
		Root<Waterpoint> root = criteriaQuery.from(Waterpoint.class);
		Predicate condition = criteriaBuilder.equal(root.get("id"), id);
		criteriaQuery.select(
				criteriaBuilder.createQuery(Waterpoint.class).getSelection())
				.where(condition);
		return getEntityManager().createQuery(criteriaQuery).getSingleResult();
	}

	/*
	 * @PUT
	 * 
	 * @Path("/put")
	 * 
	 * @Consumes(MediaType.APPLICATION_JSON) public Response create(Waterpoint
	 * waterpoint) { try { String result = "Waterpoint created : " +
	 * waterpoint.getWaterpointID(); getEntityManager().persist(waterpoint);
	 * 
	 * return Response.status(201).entity(result).build(); } catch (Exception e)
	 * { // Finally, handle unexpected exceptions Map<String, Object> errors =
	 * new HashMap<String, Object>(); errors.put("errors",
	 * Collections.singletonList(e.getMessage())); // A WebApplicationException
	 * can wrap a response // Throwing the exception causes an automatic
	 * rollback throw new WebApplicationException(Response
	 * .status(Response.Status.BAD_REQUEST).entity(errors).build()); }
	 * 
	 * }
	 * 
	 * @POST
	 * 
	 * @Path("/post")
	 * 
	 * @Consumes(MediaType.APPLICATION_JSON) public Response update(Waterpoint
	 * waterpoint) { try { String result = "Waterpoint created : " +
	 * waterpoint.getWaterpointID(); getEntityManager().merge(waterpoint);
	 * 
	 * return Response.status(201).entity(result).build(); } catch (Exception e)
	 * { // Finally, handle unexpected exceptions Map<String, Object> errors =
	 * new HashMap<String, Object>(); errors.put("errors",
	 * Collections.singletonList(e.getMessage())); // A WebApplicationException
	 * can wrap a response // Throwing the exception causes an automatic
	 * rollback throw new WebApplicationException(Response
	 * .status(Response.Status.BAD_REQUEST).entity(errors).build()); }
	 * 
	 * }
	 */

}
