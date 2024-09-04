package org.example.emergencyroomstatus.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.emergencyroomstatus.dto.response.EmergencyRoomResponseEntityDto;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class EmergencyRoomSearchService {

    private final RestTemplate restTemplate;
    private final EmergencyRoomUriBuilderService emergencyRoomUriBuilderService;

    public EmergencyRoomResponseEntityDto getEmergencyRooms(String sido, String sigungu) {
        log.info("EmergencyRoomSearchService :: getEmergencyRooms :: sido = {}, sigungu = {}", sido, sigungu);

        URI uri = emergencyRoomUriBuilderService.buildUri(sido, sigungu);
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_XML));

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        return restTemplate.exchange(uri, HttpMethod.GET, requestEntity, EmergencyRoomResponseEntityDto.class).getBody();
    }

}
