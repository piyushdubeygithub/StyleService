package com.prosmv.repositories;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.prosmv.domain.CustomerSupplier;
import com.prosmv.domain.Factory;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerSupplier, Serializable>{

	public CustomerSupplier findByName(String customerName);
	public CustomerSupplier findByNameAndFactory(String customerName, Factory factory);
	public CustomerSupplier findById(Long id);
	public List<CustomerSupplier> findByFactory(Factory factory);
	public List<CustomerSupplier> findByNameIgnoreCaseContainingAndFactoryId(String name, Long factoryId);

}
