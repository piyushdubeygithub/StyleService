package com.prosmv.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;

import com.prosmv.enums.Seasons;

@Entity
public class Style implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4403529185061865052L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String styleName;
	private String description;
	private Seasons season;
	@OneToOne
	private GridSize sizeGrid;
	@OneToOne
	private Range range;
	@OneToOne
	private CustomerSupplier customerSupplier;
	@ManyToOne
	private Factory factory;
	@OneToOne
	private Brand brand;
	@OneToOne
	private Category category;
	private int sellPrice;
	private String styleNotes;
	private String merchantname;
	private boolean deleted;
	private boolean active;
	@CreationTimestamp
	private Timestamp startDate;
	@UpdateTimestamp
	private Timestamp updatedDate;
	@UpdateTimestamp
	private Timestamp deletedDate;
	private String needleMin;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private User user;
	@CreatedBy
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private User createdBy;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private User updatedBy;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the styleName
	 */
	public String getStyleName() {
		return styleName;
	}

	/**
	 * @param styleName the styleName to set
	 */
	public void setStyleName(String styleName) {
		this.styleName = styleName;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the season
	 */
	public Seasons getSeason() {
		return season;
	}

	/**
	 * @param season the season to set
	 */
	public void setSeason(Seasons season) {
		this.season = season;
	}

	/**
	 * @return the sizeGrid
	 */
	public GridSize getSizeGrid() {
		return sizeGrid;
	}

	/**
	 * @param sizeGrid the sizeGrid to set
	 */
	public void setSizeGrid(GridSize sizeGrid) {
		this.sizeGrid = sizeGrid;
	}

	/**
	 * @return the range
	 */
	public Range getRange() {
		return range;
	}

	/**
	 * @param range the range to set
	 */
	public void setRange(Range range) {
		this.range = range;
	}

	/**
	 * @return the customerSupplier
	 */
	public CustomerSupplier getCustomerSupplier() {
		return customerSupplier;
	}

	/**
	 * @param customerSupplier the customerSupplier to set
	 */
	public void setCustomerSupplier(CustomerSupplier customerSupplier) {
		this.customerSupplier = customerSupplier;
	}

	/**
	 * @return the factory
	 */
	public Factory getFactory() {
		return factory;
	}

	/**
	 * @param factory the factory to set
	 */
	public void setFactory(Factory factory) {
		this.factory = factory;
	}

	/**
	 * @return the brand
	 */
	public Brand getBrand() {
		return brand;
	}

	/**
	 * @param brand the brand to set
	 */
	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	/**
	 * @return the category
	 */
	public Category getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(Category category) {
		this.category = category;
	}

	/**
	 * @return the sellPrice
	 */
	public int getSellPrice() {
		return sellPrice;
	}

	/**
	 * @param sellPrice the sellPrice to set
	 */
	public void setSellPrice(int sellPrice) {
		this.sellPrice = sellPrice;
	}

	/**
	 * @return the styleNotes
	 */
	public String getStyleNotes() {
		return styleNotes;
	}

	/**
	 * @param styleNotes the styleNotes to set
	 */
	public void setStyleNotes(String styleNotes) {
		this.styleNotes = styleNotes;
	}

	/**
	 * @return the merchantname
	 */
	public String getMerchantname() {
		return merchantname;
	}

	/**
	 * @param merchantname the merchantname to set
	 */
	public void setMerchantname(String merchantname) {
		this.merchantname = merchantname;
	}

	/**
	 * @return the deleted
	 */
	public boolean isDeleted() {
		return deleted;
	}

	/**
	 * @param deleted the deleted to set
	 */
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	/**
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * @return the startDate
	 */
	public Timestamp getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the updatedDate
	 */
	public Timestamp getUpdatedDate() {
		return updatedDate;
	}

	/**
	 * @param updatedDate the updatedDate to set
	 */
	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}

	/**
	 * @return the deletedDate
	 */
	public Timestamp getDeletedDate() {
		return deletedDate;
	}

	/**
	 * @param deletedDate the deletedDate to set
	 */
	public void setDeletedDate(Timestamp deletedDate) {
		this.deletedDate = deletedDate;
	}

	/**
	 * @return the needleMin
	 */
	public String getNeedleMin() {
		return needleMin;
	}

	/**
	 * @param needleMin the needleMin to set
	 */
	public void setNeedleMin(String needleMin) {
		this.needleMin = needleMin;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the createdBy
	 */
	public User getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the updatedBy
	 */
	public User getUpdatedBy() {
		return updatedBy;
	}

	/**
	 * @param updatedBy the updatedBy to set
	 */
	public void setUpdatedBy(User updatedBy) {
		this.updatedBy = updatedBy;
	}

	/**
	 * 
	 */
	public Style() {
		super();
	}

	/**
	 * @param styleName
	 * @param description
	 * @param season
	 * @param sizeGrid
	 * @param range
	 * @param customerSupplier
	 * @param factory
	 * @param brand
	 * @param category
	 * @param sellPrice
	 * @param styleNotes
	 * @param merchantname
	 * @param deleted
	 * @param active
	 * @param startDate
	 * @param updatedDate
	 * @param deletedDate
	 * @param needleMin
	 * @param user
	 * @param createdBy
	 * @param updatedBy
	 */
	public Style(String styleName, String description, Seasons season, GridSize sizeGrid, Range range,
			CustomerSupplier customerSupplier, Factory factory, Brand brand, Category category, int sellPrice,
			String styleNotes, String merchantname, boolean deleted, boolean active, Timestamp startDate,
			Timestamp updatedDate, Timestamp deletedDate, String needleMin, User user, User createdBy, User updatedBy) {
		super();
		this.styleName = styleName;
		this.description = description;
		this.season = season;
		this.sizeGrid = sizeGrid;
		this.range = range;
		this.customerSupplier = customerSupplier;
		this.factory = factory;
		this.brand = brand;
		this.category = category;
		this.sellPrice = sellPrice;
		this.styleNotes = styleNotes;
		this.merchantname = merchantname;
		this.deleted = deleted;
		this.active = active;
		this.startDate = startDate;
		this.updatedDate = updatedDate;
		this.deletedDate = deletedDate;
		this.needleMin = needleMin;
		this.user = user;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
	}

	@Override
	public String toString() {
		return "Style [id=" + id + ", styleName=" + styleName + ", description=" + description + ", season=" + season
				+ ", sizeGrid=" + sizeGrid + ", range=" + range + ", customerSupplier=" + customerSupplier
				+ ", factory=" + factory + ", brand=" + brand + ", category=" + category + ", sellPrice=" + sellPrice
				+ ", styleNotes=" + styleNotes + ", merchantname=" + merchantname + ", deleted=" + deleted + ", active="
				+ active + ", startDate=" + startDate + ", updatedDate=" + updatedDate + ", deletedDate=" + deletedDate
				+ ", needleMin=" + needleMin + ", user=" + user + ", createdBy=" + createdBy + ", updatedBy="
				+ updatedBy + "]";
	}

}
