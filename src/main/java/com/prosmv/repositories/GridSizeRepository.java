package com.prosmv.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prosmv.domain.Factory;
import com.prosmv.domain.GridSize;
import com.prosmv.dto.GridSizeDTO;

@Repository
public interface GridSizeRepository extends JpaRepository<GridSize, Serializable> {

	public GridSize findById(Long id);

	public GridSize findByGridValueAndFactory(String gridValue, Factory factory);

	public List<GridSize> findByGridValueIgnoreCaseContainingAndFactoryId(String gridValue, Long factoryId);

	public List<GridSizeDTO> findByFactoryId(Long factoryId);

}
