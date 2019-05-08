package com.prosmv.repositories;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.prosmv.domain.Order;

public interface OrderRepository extends JpaRepository<Order, Serializable>{

}
