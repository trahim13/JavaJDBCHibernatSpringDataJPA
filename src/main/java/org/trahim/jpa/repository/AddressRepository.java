package org.trahim.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.trahim.jpa.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
}
