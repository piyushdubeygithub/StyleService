package com.prosmv.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.prosmv.domain.Category;
import com.prosmv.domain.Factory;
import com.prosmv.dto.CategoryDTO;

public interface CategoryRepository extends JpaRepository<Category, Serializable>{

	public Category findById(Long id);
	public Category findByNameAndFactory(String name, Factory factory);
	public List<Category> findByNameIgnoreCaseContainingAndFactoryId(String name, Long factoryId);
	public List<CategoryDTO> findByFactoryId(Long factoryId);
	public Category findByNameAndFactoryId(String categoryName, Long factoryId);
}
