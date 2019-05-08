package com.prosmv.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prosmv.domain.Range;
import com.prosmv.dto.RangeDTO;

@Repository
public interface RangeRepository extends JpaRepository<Range, Serializable> {
	public Range findById(Long id);

	public List<Range> findByNameIgnoreCaseContainingAndFactoryId(String name, Long factoryId);

//	public Range findByNameAndFactory(String name, Factory factory);

	public List<RangeDTO> findByFactoryId(Long factoryId);

	public Range findByNameAndFactoryId(String rangeName, Long factoryId);

}
