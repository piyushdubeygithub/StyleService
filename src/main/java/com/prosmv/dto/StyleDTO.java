package com.prosmv.dto;

import java.io.Serializable;
import com.prosmv.domain.Brand;
import com.prosmv.domain.CustomerSupplier;
import com.prosmv.domain.Factory;
import com.prosmv.domain.Style;
import com.prosmv.enums.Seasons;

public class StyleDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6289967632916140097L;
	private Long id;
    private String name;
    private String description;
    private Seasons season;
    private CustomerSupplierDTO customer;
    private FactoryDTO factory;
    private BrandDTO brand;
    private String category;
    private int sellPrice;
    private String styleNotes;
    private String merchantname;
    
    public StyleDTO(Style style) {
    	if(style != null) {
    		this.id = style.getId();
    		this.name = style.getStyleName();
    		this.description = style.getDescription();
    		this.brand = new BrandDTO(style.getBrand());
    		this.customer = new CustomerSupplierDTO(style.getCustomerSupplier());
    		this.season = style.getSeason();
    		this.sellPrice = style.getSellPrice();
    		this.factory = new FactoryDTO(style.getFactory());
    		this.merchantname = style.getMerchantname();
    		this.styleNotes = style.getStyleNotes();
    	}
    }
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public CustomerSupplierDTO getCustomer() {
		return customer;
	}
	
	public Seasons getSeason() {
		return season;
	}

	public void setSeason(Seasons season) {
		this.season = season;
	}

	public void setCustomer(CustomerSupplierDTO customer) {
		this.customer = customer;
	}
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getSellPrice() {
		return sellPrice;
	}
	public void setSellPrice(int sellPrice) {
		this.sellPrice = sellPrice;
	}
	public String getStyleNotes() {
		return styleNotes;
	}
	public void setStyleNotes(String styleNotes) {
		this.styleNotes = styleNotes;
	}
	public String getMerchantname() {
		return merchantname;
	}
	public void setMerchantname(String merchantname) {
		this.merchantname = merchantname;
	}
	/**
	 * @return the factory
	 */
	public FactoryDTO getFactory() {
		return factory;
	}

	/**
	 * @param factory the factory to set
	 */
	public void setFactory(FactoryDTO factory) {
		this.factory = factory;
	}

	/**
	 * @return the brand
	 */
	public BrandDTO getBrand() {
		return brand;
	}

	/**
	 * @param brand the brand to set
	 */
	public void setBrand(BrandDTO brand) {
		this.brand = brand;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "StyleDTO [id=" + id + ", name=" + name + ", description=" + description + ", season=" + season
				+ ", customer=" + customer + ", factory=" + factory + ", brand=" + brand + ", category=" + category
				+ ", sellPrice=" + sellPrice + ", styleNotes=" + styleNotes + ", merchantname=" + merchantname + "]";
	}
    
    
}
