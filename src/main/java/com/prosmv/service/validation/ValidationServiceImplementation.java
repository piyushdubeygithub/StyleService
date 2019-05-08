package com.prosmv.service.validation;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prosmv.repositories.BrandRepository;
import com.prosmv.repositories.CategoryRepository;
import com.prosmv.repositories.CompanyRepository;
import com.prosmv.repositories.CustomerRepository;
import com.prosmv.repositories.DesignationRepository;
import com.prosmv.repositories.FactoryRepository;
import com.prosmv.repositories.GridSizeRepository;
import com.prosmv.repositories.RangeRepository;
import com.prosmv.repositories.UserRepository;
import com.prosmv.util.GenericUtils;

/**
 * This class is an implementation class of {@link ValidationService}.
 * 
 * @author piyush
 *
 */
@Service
public class ValidationServiceImplementation implements ValidationService {

	@Autowired
	private CompanyRepository companyRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private BrandRepository brandRepository;

	@Autowired
	private DesignationRepository designationRepository;

	@Autowired
	private FactoryRepository factoryRepository;

	@Autowired
	private GridSizeRepository gridSizeRepository;

	@Autowired
	private RangeRepository rangeRepository;

	@Autowired
	private CategoryRepository categoryRepository;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isCompanyAlreadyExist(Long companyId) {
		return Objects.isNull(companyRepository.findById(companyId)) ? false : true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isComapnyNameAlreadyExist(String companyName) {
		return Objects.isNull(companyRepository.findByName(companyName)) ? false : true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isUserAlreadyExist(Long userId) {
		return Objects.isNull(userRepository.findById(userId)) ? false : true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isUserNameAlreadyExist(String userName) {
		return Objects.isNull(userRepository.findByUsername(userName)) ? false : true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isCustomerAlreadyExist(Long customerId) {
		return Objects.isNull(customerRepository.findById(customerId)) ? false : true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isCustomerNameAlreadyExist(String customerName) {
		return Objects.isNull(customerRepository.findByName(customerName)) ? false : true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isBrandAlreadyExist(Long brandId) {
		return Objects.isNull(brandRepository.findById(brandId)) ? false : true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isBrandNameAlreadyExist(String brandName) {
		return Objects.isNull(brandRepository.findByName(brandName)) ? false : true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isDesignationAlreadyExist(Long designationId) {
		return Objects.isNull(designationRepository.findById(designationId)) ? false : true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isDesignationNameAlreadyExist(String designationName) {
		return Objects.isNull(designationRepository.findByDesignationname(designationName)) ? false : true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isFactoryAlreadyExist(Long factoryId) {
		return Objects.isNull(factoryRepository.findById(factoryId)) ? false : true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isFactoryNameAlreadyExist(String factoryName) {
		return Objects.isNull(factoryRepository.findByName(factoryName)) ? false : true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isCompanyEmailAlreadyExist(String email) {
		return Objects.isNull(companyRepository.findByEmail(email)) ? false : true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isFactoryMappedWithUser(Long factoryId) {
		try {
			System.out.println(GenericUtils.getLoggedInUser().getFactories().contains(factoryRepository.findById(factoryId)));
			return GenericUtils.getLoggedInUser().getFactories().contains(factoryRepository.findById(factoryId));
		} catch (NullPointerException nullPointerException) {
			nullPointerException.printStackTrace();
			return false;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isGridSizeExist(Long gridSizeId) {
		return Objects.isNull(gridSizeRepository.findById(gridSizeId)) ? false : true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isRangeNameAlreadyExist(Long factoryId, String rangeName) {
		return Objects.isNull(rangeRepository.findByNameAndFactoryId(rangeName, factoryId)) ? false : true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isCategoryNameAlreadyExist(Long factoryId, String categoryName) {
		return Objects.isNull(categoryRepository.findByNameAndFactoryId(categoryName,factoryId))?false:true;
	}

}
