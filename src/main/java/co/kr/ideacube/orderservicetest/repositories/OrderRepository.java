package co.kr.ideacube.orderservicetest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import co.kr.ideacube.orderservicetest.models.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
    
}