package org.dsw.web.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "IssueType" database table.
 * 
 */
@Entity
@Table(name="\"IssueType\"")
public class IssueType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="\"IssueTypeID\"")
	private Integer issueTypeID;

	@Column(name="\"IssueDesc\"")
	private String issueDesc;

    public IssueType() {
    }

	public Integer getIssueTypeID() {
		return this.issueTypeID;
	}

	public void setIssueTypeID(Integer issueTypeID) {
		this.issueTypeID = issueTypeID;
	}

	public String getIssueDesc() {
		return this.issueDesc;
	}

	public void setIssueDesc(String issueDesc) {
		this.issueDesc = issueDesc;
	}

}