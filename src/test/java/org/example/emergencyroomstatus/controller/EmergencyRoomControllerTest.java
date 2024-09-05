package org.example.emergencyroomstatus.controller;

import org.example.emergencyroomstatus.dto.response.EmergencyRoomResponseBodyDto;
import org.example.emergencyroomstatus.dto.response.EmergencyRoomResponseEntityDto;
import org.example.emergencyroomstatus.service.EmergencyRoomSearchService;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
class EmergencyRoomControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    EmergencyRoomSearchService emergencyRoomSearchService;

    @Test
    void givenAddressInfo_whenSearchingEmergencyRooms_thenReturnsEmergencyRoomsList() throws Exception {
        // Given
        String sido = "성남시";
        String sigungu = "분당구";
        given(emergencyRoomSearchService.getEmergencyRooms(anyString(), anyString()))
                .willReturn(EmergencyRoomResponseEntityDto.builder().emergencyRoomResponseBodyDto(EmergencyRoomResponseBodyDto.builder().build()).build());

        // When
        mvc.perform(MockMvcRequestBuilders.get("/emergency-rooms")
                .queryParam("sido", sido)
                .queryParam("sigungu", sigungu))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                .andExpect(view().name("emergency-rooms/index"));

        // Then
        then(emergencyRoomSearchService).should().getEmergencyRooms(anyString(), anyString());
    }

}
