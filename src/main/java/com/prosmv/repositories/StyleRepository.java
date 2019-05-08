package com.prosmv.repositories;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.prosmv.domain.Factory;
import com.prosmv.domain.Style;

public interface StyleRepository extends JpaRepository<Style, Serializable>{

	public Style findByStyleNameAndFactory(String styleName, Factory factory);
	public Style findById(Long id);
	public List<Style> findByFactory(Factory factory);
	public List<Style> findByStyleNameIgnoreCaseContainingAndFactoryId(String name, Long factoryId);
}
