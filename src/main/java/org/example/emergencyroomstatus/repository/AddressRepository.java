package org.example.emergencyroomstatus.repository;

import org.example.emergencyroomstatus.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
