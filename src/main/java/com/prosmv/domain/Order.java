package com.prosmv.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "AppOrders")
public class Order implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4096073856804651568L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Character active;
	private Character deleted;
	@CreationTimestamp
	private Timestamp createdAt;
	@UpdateTimestamp
	private Timestamp updatedAt;
	@OneToOne
	private User createdBy;
	@OneToOne
	private User updatedBy;
	@OneToOne
	private Style style;
	private String orderNumber;
	private Long bundleQuantity;
	private String destination;
	private Timestamp orderDate;
	private Timestamp fileHandOverDate;
    // to do with next module
	private Timestamp exFactoryDate;
	private Timestamp deliveryDate;
	private Timestamp shipmentDate;
	private String poNumber;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Character getActive() {
		return active;
	}
	public void setActive(Character active) {
		this.active = active;
	}
	public Character getDeleted() {
		return deleted;
	}
	public void setDeleted(Character deleted) {
		this.deleted = deleted;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	public Timestamp getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
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
	public Style getStyle() {
		return style;
	}
	public void setStyle(Style style) {
		this.style = style;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public Long getBundleQuantity() {
		return bundleQuantity;
	}
	public void setBundleQuantity(Long bundleQuantity) {
		this.bundleQuantity = bundleQuantity;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public Timestamp getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}
	public Timestamp getFileHandOverDate() {
		return fileHandOverDate;
	}
	public void setFileHandOverDate(Timestamp fileHandOverDate) {
		this.fileHandOverDate = fileHandOverDate;
	}
	public Timestamp getExFactoryDate() {
		return exFactoryDate;
	}
	public void setExFactoryDate(Timestamp exFactoryDate) {
		this.exFactoryDate = exFactoryDate;
	}
	public Timestamp getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(Timestamp deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public Timestamp getShipmentDate() {
		return shipmentDate;
	}
	public void setShipmentDate(Timestamp shipmentDate) {
		this.shipmentDate = shipmentDate;
	}
	public String getPoNumber() {
		return poNumber;
	}
	public void setPoNumber(String poNumber) {
		this.poNumber = poNumber;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
}
