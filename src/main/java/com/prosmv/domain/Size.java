package com.prosmv.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;

@Entity
public class Size implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8349951022139876302L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String sizeValue;
	private String sizeDescription;
	@CreationTimestamp
	private Timestamp createdDate;
	@UpdateTimestamp
	private Timestamp updatedDate;
	private Timestamp deletedDate;
	@CreatedBy
	private User createdBy;
	private User updatedBy;
	private Character deleted;
	private Character active;
	@ManyToOne
	private GridSize gridSize;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getSizeValue() {
		return sizeValue;
	}
	public void setSizeValue(String sizeValue) {
		this.sizeValue = sizeValue;
	}
	public String getSizeDescription() {
		return sizeDescription;
	}
	public void setSizeDescription(String sizeDescription) {
		this.sizeDescription = sizeDescription;
	}
	public Timestamp getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}
	public Timestamp getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}
	public Timestamp getDeletedDate() {
		return deletedDate;
	}
	public void setDeletedDate(Timestamp deletedDate) {
		this.deletedDate = deletedDate;
	}
	public User getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}
	public User getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(User updatedBy) {
		this.updatedBy = updatedBy;
	}
	public Character getDeleted() {
		return deleted;
	}
	public void setDeleted(Character deleted) {
		this.deleted = deleted;
	}
	public Character getActive() {
		return active;
	}
	public void setActive(Character active) {
		this.active = active;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public GridSize getGridSize() {
		return gridSize;
	}
	public void setGridSize(GridSize gridSize) {
		this.gridSize = gridSize;
	}
	@Override
	public String toString() {
		return "Size [id=" + id + ", sizeValue=" + sizeValue + ", sizeDescription=" + sizeDescription + ", createdDate="
				+ createdDate + ", updatedDate=" + updatedDate + ", deletedDate=" + deletedDate + ", createdBy="
				+ createdBy + ", updatedBy=" + updatedBy + ", deleted=" + deleted + ", active=" + active + ", gridSize="
				+ gridSize + "]";
	}
	
}
