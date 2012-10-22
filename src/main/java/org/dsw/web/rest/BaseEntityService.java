package org.dsw.web.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;

public abstract class BaseEntityService<T> {

	@Inject
	private EntityManager entityManager;

	private Class<T> entityClass;

	public BaseEntityService() {
	}

	public BaseEntityService(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<T> getAll(@Context UriInfo uriInfo) {
		return getAll(uriInfo.getQueryParameters());
	}

	public List<T> getAll(MultivaluedMap<String, String> queryParameters) {
		final CriteriaBuilder criteriaBuilder = entityManager
				.getCriteriaBuilder();
		final CriteriaQuery<T> criteriaQuery = criteriaBuilder
				.createQuery(entityClass);
		Root<T> root = criteriaQuery.from(entityClass);
		Predicate[] predicates = extractPredicates(queryParameters,
				criteriaBuilder, root);
		criteriaQuery.select(criteriaQuery.getSelection()).where(predicates);
		criteriaQuery.orderBy(criteriaBuilder.asc(root.get("id")));
		TypedQuery<T> query = entityManager.createQuery(criteriaQuery);
		if (queryParameters.containsKey("first")) {
			Integer firstRecord = Integer.parseInt(queryParameters
					.getFirst("first")) - 1;
			query.setFirstResult(firstRecord);
		}
		if (queryParameters.containsKey("maxResults")) {
			Integer maxResults = Integer.parseInt(queryParameters
					.getFirst("maxResults"));
			query.setMaxResults(maxResults);
		}
		return query.getResultList();
	}

	protected Predicate[] extractPredicates(
			MultivaluedMap<String, String> queryParameters,
			CriteriaBuilder criteriaBuilder, Root<T> root) {
		return new Predicate[] {};
	}

	/**
	 * <p>
	 * A method for counting all entities of a given type
	 * </p>
	 * 
	 * @param uriInfo
	 *            application and request context information (see {@see
	 *            UriInfo} class information for more details)
	 * @return
	 */
	@GET
	@Path("/count")
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, Long> getCount(@Context UriInfo uriInfo) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> criteriaQuery = criteriaBuilder
				.createQuery(Long.class);
		Root<T> root = criteriaQuery.from(entityClass);
		criteriaQuery.select(criteriaBuilder.count(root));
		Predicate[] predicates = extractPredicates(
				uriInfo.getQueryParameters(), criteriaBuilder, root);
		criteriaQuery.where(predicates);
		Map<String, Long> result = new HashMap<String, Long>();
		result.put("count", entityManager.createQuery(criteriaQuery)
				.getSingleResult());
		return result;
	}

	/**
	 * <p>
	 * A method for retrieving individual entity instances.
	 * </p>
	 * 
	 * @param id
	 *            entity id
	 * @return
	 */
	@GET
	@Path("/{id:[0-9][0-9]*}")
	@Produces(MediaType.APPLICATION_JSON)
	public T getSingleInstance(@PathParam("id") Long id) {
		final CriteriaBuilder criteriaBuilder = entityManager
				.getCriteriaBuilder();
		final CriteriaQuery<T> criteriaQuery = criteriaBuilder
				.createQuery(entityClass);
		Root<T> root = criteriaQuery.from(entityClass);
		Predicate condition = criteriaBuilder.equal(root.get("id"), id);
		criteriaQuery.select(
				criteriaBuilder.createQuery(entityClass).getSelection()).where(
				condition);
		return entityManager.createQuery(criteriaQuery).getSingleResult();
	}

	

	@GET
	@Path("/check")
	@Produces(MediaType.APPLICATION_JSON)
	public String check() {

		return "hey";
	}

}
