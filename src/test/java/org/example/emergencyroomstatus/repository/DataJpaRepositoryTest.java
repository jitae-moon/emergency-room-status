package org.example.emergencyroomstatus.repository;

import org.example.emergencyroomstatus.config.JpaConfig;
import org.example.emergencyroomstatus.config.MapperConfig;
import org.example.emergencyroomstatus.domain.Address;
import org.example.emergencyroomstatus.domain.EmergencyRoom;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.Transactional;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("DataJpa관련 Auditing, CRUD 테스트")
@Transactional
@Import(value = {JpaConfig.class, MapperConfig.class})
@DataJpaTest
class DataJpaRepositoryTest {

    AddressRepository addressRepository;
    EmergencyRoomRepository emergencyRoomRepository;

    @Autowired
    public DataJpaRepositoryTest(AddressRepository addressRepository, EmergencyRoomRepository emergencyRoomRepository) {
        this.addressRepository = addressRepository;
        this.emergencyRoomRepository = emergencyRoomRepository;
    }

    @DisplayName("Auditing Field 테스트 :: @CreatedDate 동작 여부 확인")
    @Test
    void givenAddress_whenSavingAddress_thenSavesCreatedDate() {
        // Given
        Address expected = createAddress();

        // When & Then
        addressRepository.save(expected);
        Address actual = addressRepository.findById(1L).orElseThrow();
        assertThat(actual.getCreatedDate()).isNotNull();
    }

    @DisplayName("[AuditingFields 테스트] :: @CreatedDate가 생성되면 테스트 시작 전 시간보다 이후인지 확인")
    @Test
    void givenFixedClock_whenSavingAddress_thenEnsuresCreatedDateIsAfterFixedClock() {
        // Given
        Clock clock = Clock.fixed(Instant.now(), ZoneId.systemDefault());
        LocalDateTime now = LocalDateTime.now(clock);
        Address expected = createAddress();

        // When
        Address actual = addressRepository.save(expected);

        // Then
        assertThat(actual.getCreatedDate()).isAfter(now.minusSeconds(1));
        assertThat(actual.getCreatedDate()).isBefore(now.plusMinutes(1));
    }

    private EmergencyRoom createEmergencyRoom() {
        return EmergencyRoom.builder()
                .hospitalId("12341234")
                .address("경기도 성남시")
                .latitude("33")
                .longitude("127")
                .category("CATEGORY")
                .mainContact("031-733-7230")
                .directContact("031-734-7230")
                .build();
    }

    private Address createAddress() {
        return Address.builder()
                .sido("경기도")
                .sigungu("성남시")
                .build();
    }

}
