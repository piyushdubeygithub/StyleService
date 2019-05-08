package com.prosmv.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prosmv.domain.Brand;
import com.prosmv.domain.CustomerSupplier;
import com.prosmv.domain.Factory;
import com.prosmv.domain.Style;
import com.prosmv.domain.User;
import com.prosmv.dto.BrandDTO;
import com.prosmv.dto.CustomerDTO;
import com.prosmv.dto.FactoryDTO;
import com.prosmv.dto.StyleDTO;
import com.prosmv.form.CustomerForm;
import com.prosmv.repositories.BrandRepository;
import com.prosmv.repositories.CompanyRepository;
import com.prosmv.repositories.CustomerRepository;
import com.prosmv.repositories.FactoryRepository;
import com.prosmv.util.GenericUtils;

/**
 * This service class is used for accessing all the services related to
 * {@link CustomerSupplier}
 * 
 * @author piyush
 *
 */
@Service
public class CustomerService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private FactoryRepository factoryRepository;

	@Autowired
	private CompanyRepository companyRepository;

	@Autowired
	private BrandRepository brandRepository;

	public String saveCustomer(CustomerForm customerForm) {
		String response = null;
		if (!isCustomerExists(customerForm)) {
			CustomerSupplier customerSupplier = getCustomerSupplier(customerForm);
			if (customerSupplier == null) {
				response = "factory is required";
			} else {
				customerRepository.save(customerSupplier);
				response = "customer created successfully";
			}
		} else {
			response = "customer already exists";
		}
        System.out.println(response);
		return response;
	}

	private CustomerSupplier getCustomerSupplier(CustomerForm customerForm) {
		CustomerSupplier customerSupplier = new CustomerSupplier();
		customerSupplier.setName(customerForm.getCustomerName());
		Factory factory = null;
		if (customerForm.getFactoryId() != null) {
			factory = factoryRepository.findById(customerForm.getFactoryId());
			customerSupplier.setFactory(factory);
		}
		if (factory == null) {
			return null;
		}
		if (customerForm.getAddress() != null) {
			customerSupplier.setAddress(customerForm.getAddress());
		}
		if (customerForm.getCustomerType() != null) {
			customerSupplier.setCustomerType(customerForm.getCustomerType());
		}
		if (customerForm.getEmail() != null) {
			customerSupplier.setEmail(customerForm.getEmail());
		}
		if (customerForm.getMobileNumber() != null) {
			customerSupplier.setMobileNumber(customerForm.getMobileNumber());
		}
		if(customerSupplier.getName() != null) {
			customerSupplier.setName(customerForm.getName());
		}
		customerSupplier.setActive(true);
		customerSupplier.setDeleted(false);
		return customerSupplier;
	}

	private boolean isCustomerExists(CustomerForm customerForm) {
		boolean customerExists = false;
		Factory factory = factoryRepository.findById(customerForm.getFactoryId());
		CustomerSupplier customerSupplier = customerRepository.findByNameAndFactory(customerForm.getCustomerName(),
				factory);
		if (customerSupplier != null) {
			customerExists = true;
		}
		return customerExists;
	}

	public String updateCustomer(Long customerId, CustomerForm customerForm) {
		String response = null;
		CustomerSupplier oldCustomer = customerRepository.findById(customerId);
		if (oldCustomer != null) {
			CustomerSupplier customer = getCustomerSupplier(customerForm);
			if (customer != null) {
				customer.setId(oldCustomer.getId());
				customerRepository.save(customer);
				response = "customer is updated";
			} else {
				response = "company is required";
			}
		} else {
			response = "customer not found";
		}
		return response;
	}

	/**
	 * This service is used to add {@link Brand}
	 * 
	 * @param customerId
	 *            id of {@link CustomerSupplier}
	 * @param brandName
	 *            name of new {@link Brand}
	 */
	@Transactional(rollbackFor = Exception.class)
	public void addBrand(Long customerId, String brandName) {
		CustomerSupplier customerSupplier = customerRepository.findById(customerId);
		List<Brand> brands = customerSupplier.getBrands();
		Brand brand = new Brand();
		brand.setName(brandName);
		brand.setCustomer(customerSupplier);
		brand.setCreatedBy(GenericUtils.getLoggedInUser());
		brand.setUpdatedBy(GenericUtils.getLoggedInUser());
		brand = brandRepository.save(brand);
		brands.add(brand);
		customerSupplier.setBrands(brands);
		customerRepository.save(customerSupplier);
	}

	/**
	 * This service is used to de activate {@link CustomerSupplier}
	 * 
	 * @param customerId
	 *            id of {@link CustomerSupplier}
	 */
	@Transactional(rollbackFor = Exception.class)
	public void deActivateCustomer(Long customerId) {
		CustomerSupplier customerSupplier = getCustomerByCustomerId(customerId);
		customerSupplier.setActive(false);
		customerRepository.save(customerSupplier);
	}

	/**
	 * This service is used to activate {@link CustomerSupplier}
	 * 
	 * @param customerId
	 *            is of {@link CustomerSupplier}
	 */
	@Transactional(rollbackFor = Exception.class)
	public void activateCustomer(Long customerId) {
		CustomerSupplier customerSupplier = getCustomerByCustomerId(customerId);
		customerSupplier.setActive(true);
		customerRepository.save(customerSupplier);
	}

	/**
	 * This service is used to get all {@link Brand}
	 * 
	 * @param customerId
	 *            id of {@link CustomerSupplier}
	 * @return {@link List} of {@link BrandDTO}
	 */
	public List<BrandDTO> getAllBrands(Long customerId) {
		CustomerSupplier customerSupplier = getCustomerByCustomerId(customerId);
		List<BrandDTO> validBrands = new ArrayList<>();
		if (customerSupplier != null) {
			List<Brand> brands = brandRepository.findByCustomer(customerSupplier);
			for (Brand brand : brands) {
				if (!brand.isDeleted()) {
					validBrands.add(new BrandDTO(brand));
				}
			}
		}
		return validBrands;
	}

	/**
	 * This service is used to delete {@link Brand}
	 * 
	 * @param brandId
	 *            id of {@link Brand}
	 */
	@Transactional(rollbackFor = Exception.class)
	public void deleteBrand(Long brandId) {
		Brand brand = getBrandByBrandId(brandId);
		brand.setDeleted(true);
		brandRepository.save(brand);
	}

	/**
	 * This service is used to get {@link Brand} by brand id
	 * 
	 * @param brandId
	 *            id of {@link Brand}
	 * @return {@link Brand}
	 */
	public Brand getBrandByBrandId(Long brandId) {
		return brandRepository.findById(brandId);
	}

	/**
	 * This service is used to get {@link CustomerSupplier} by customer id.
	 * 
	 * @param customerId
	 *            id of {@link CustomerSupplier}
	 * @return {@link CustomerSupplier}
	 */
	public CustomerSupplier getCustomerByCustomerId(Long customerId) {
		return customerRepository.findById(customerId);
	}

	public List<CustomerSupplier> getCustomersByFactoryId(Long factoryId) {
		factoryRepository.findById(factoryId);
		return customerRepository.findByFactory(factoryRepository.findById(factoryId));
	}

	public List<CustomerDTO> getcustomers(Long factoryId) {
		List<CustomerSupplier> customers = getCustomersByFactoryId(factoryId);
		List<CustomerDTO> validCustomers = new ArrayList<>();
		for (CustomerSupplier customer : customers) {
			if (!customer.isDeleted()) {
				validCustomers.add(new CustomerDTO(customer));
			}
		}
		return validCustomers;
	}

	public List<CustomerDTO> getUsercustomers() {
		User user = GenericUtils.getLoggedInUser();
		List<CustomerDTO> customerList = new ArrayList<>();
		List<CustomerSupplier> customers = new ArrayList<>();
		if (!user.getFactories().isEmpty()) {
			for (Factory factory : user.getFactories()) {
				List<CustomerSupplier> tempCustomers = customerRepository.findByFactory(factory);
				if (!tempCustomers.isEmpty()) {
					customers.addAll(tempCustomers);
				}
			}
		}
			for (CustomerSupplier customer : customers) {
				if(!customer.isDeleted()) {
					CustomerDTO customerDTO = new CustomerDTO(customer);
					List<Brand> brands = brandRepository.findByCustomer(customer);
					customerDTO.setBrandCount(brands.size());
					customerList.add(customerDTO);
				}
			}
		return customerList;
	}

	public List<FactoryDTO> getUserFactories() {
		User user = GenericUtils.getLoggedInUser();
		List<FactoryDTO> factoryList = new ArrayList<>();
		if (!user.getFactories().isEmpty()) {
			for (Factory factory : user.getFactories()) {
				if(!factory.isDeleted()&&factory.isActive()) {
					factoryList.add(new FactoryDTO(factory.getId(), factory.getName(), factory.isActive()));
				}
			}
		}
		return factoryList;
	}

	public void deleteCustomer(Long customerId) {
		CustomerSupplier customer = getCustomerByCustomerId(customerId);
		customer.setDeleted(true);
		customerRepository.save(customer);		
	}


	public List<CustomerDTO> getAutoCompleteCustomer(String customerName, Long factoryId) {
		List<CustomerSupplier> customers = customerRepository.findByNameIgnoreCaseContainingAndFactoryId(customerName, factoryId);
		List<CustomerDTO> customerList = new ArrayList<>();
		for (CustomerSupplier customer : customers) {
			customerList.add(new CustomerDTO(customer));
		}
		return customerList;
	}


}
