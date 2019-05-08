package com.prosmv.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.prosmv.domain.GridSize;
import com.prosmv.domain.Size;
import com.prosmv.dto.SizeDTO;

@Repository
public interface SizeRepository extends JpaRepository<Size, Serializable> {

	public Size findById(Long id);

	public Size findBySizeValueAndGridSize(String sizeValue, GridSize gridSize);

	public List<SizeDTO> findByGridSizeId(Long gridSizeId);
}
