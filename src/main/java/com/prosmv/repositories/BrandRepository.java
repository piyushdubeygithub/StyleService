package com.prosmv.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.prosmv.domain.Brand;
import com.prosmv.domain.CustomerSupplier;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Serializable>{

	public Brand findByName(String brandName);
	public List<Brand> findByCustomer(CustomerSupplier customerSupplier);
	public Brand findById(Long id);

}
