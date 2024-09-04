package org.example.emergencyroomstatus.service;

import org.assertj.core.api.Assertions;
import org.example.emergencyroomstatus.dto.response.EmergencyRoomResponseEntityDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmergencyRoomSearchServiceIntegrationTest {

    EmergencyRoomSearchService sut;
    RestTemplate restTemplate;
    EmergencyRoomUriBuilderService emergencyRoomUriBuilderService;

    @Autowired
    public EmergencyRoomSearchServiceIntegrationTest(EmergencyRoomSearchService sut, RestTemplate restTemplate, EmergencyRoomUriBuilderService emergencyRoomUriBuilderService) {
        this.sut = sut;
        this.restTemplate = restTemplate;
        this.emergencyRoomUriBuilderService = emergencyRoomUriBuilderService;
    }

    @DisplayName("주소를 넘겨주면 외부 api 호출 후 응급실 목록을 반환한다.")
    @Test
    void givenAddressInfo_whenExecutingExternalApi_thenReturnsEmergencyRoomsList() {
        // Given
        String sido = "성남시";
        String sigungu = "분당구";

        // When
        EmergencyRoomResponseEntityDto result = sut.getEmergencyRooms(sido, sigungu);

        // Then
        assertThat(result).isNotNull();
    }

}