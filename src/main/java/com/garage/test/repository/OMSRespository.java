package com.garage.test.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.garage.test.model.Customers;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface OMSRespository extends JpaRepository<Customers , UUID>{

	@Query(value = "select ordercount from customer where uuid = :uuid" , nativeQuery = true)
	Long getordercount(@Param("uuid") UUID uuid);

	
	@Query(value = "select * from customer where name = :name" , nativeQuery = true)
	Customers getCustomer(@Param("name") String name);


	@Modifying
	@Query(value = "update customer set ordercount = :ordercount , "
			+ "category = :category where name = :name" , nativeQuery = true)
	void updateOrderCategory(@Param("ordercount")long ordercount,@Param("category") String category , @Param("name") String name);


	@Modifying(clearAutomatically = true)
	@Query(value = "update customer set ordercount = :ordercount where name = :name" , nativeQuery = true)
	void updateOrderCount(@Param("ordercount") long ordercount , @Param("name") String name);

}
