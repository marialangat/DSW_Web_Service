package org.dsw.web.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the "Issue" database table.
 * 
 */
@Entity
@Table(name="\"Issue\"")
public class Issue implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="\"IssueID\"")
	private Integer id;

	@Column(name="\"Comments\"")
	private String comments;

	@Column(name="\"CreatedBy\"")
	private Integer createdBy;

    @Temporal( TemporalType.DATE)
	@Column(name="\"DateCreated\"")
	private Date dateCreated;

    @Temporal( TemporalType.DATE)
	@Column(name="\"DateResolved\"")
	private Date dateResolved;

	@Column(name="\"IssueType\"")
	private Integer issueType;

	@Column(name="\"Resolved\"")
	private Boolean resolved;

	@Column(name="\"ResolvedBy\"")
	private Integer resolvedBy;

	@Column(name="\"WaterpointID\"")
	private Integer waterpointID;

    public Issue() {
    }

	public Integer getIssueID() {
		return this.id;
	}

	public void setIssueID(Integer issueID) {
		this.id = issueID;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Integer getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Date getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateResolved() {
		return this.dateResolved;
	}

	public void setDateResolved(Date dateResolved) {
		this.dateResolved = dateResolved;
	}

	public Integer getIssueType() {
		return this.issueType;
	}

	public void setIssueType(Integer issueType) {
		this.issueType = issueType;
	}

	public Boolean getResolved() {
		return this.resolved;
	}

	public void setResolved(Boolean resolved) {
		this.resolved = resolved;
	}

	public Integer getResolvedBy() {
		return this.resolvedBy;
	}

	public void setResolvedBy(Integer resolvedBy) {
		this.resolvedBy = resolvedBy;
	}

	public Integer getWaterpointID() {
		return this.waterpointID;
	}

	public void setWaterpointID(Integer waterpointID) {
		this.waterpointID = waterpointID;
	}

}