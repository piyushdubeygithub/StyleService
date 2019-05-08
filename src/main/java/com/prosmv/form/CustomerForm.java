package com.prosmv.form;

import javax.validation.constraints.NotEmpty;

import org.springframework.lang.NonNull;

public class CustomerForm {

	@NonNull
	@NotEmpty
	private String name;
	private String address;
	private String mobileNumber;
	private String email;
	private String customerType;
	@NonNull
	@NotEmpty
	private Long factoryId;

	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return name;
	}

	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.name = customerName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public Long getFactoryId() {
		return factoryId;
	}

	public void setFactoryId(Long factoryId) {
		this.factoryId = factoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "CustomerForm [customerName=" + name + ", address=" + address + ", mobileNumber=" + mobileNumber
				+ ", email=" + email + ", customerType=" + customerType + ", factoryId=" + factoryId + "]";
	}

}
