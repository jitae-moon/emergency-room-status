package org.example.emergencyroomstatus.repository;

import org.example.emergencyroomstatus.domain.EmergencyRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmergencyRoomRepository extends JpaRepository<EmergencyRoom, Long> {
}
