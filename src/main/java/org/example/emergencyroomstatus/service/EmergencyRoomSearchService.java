package org.example.emergencyroomstatus.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.emergencyroomstatus.dto.EmergencyRoomDto;
import org.example.emergencyroomstatus.dto.response.EmergencyRoomResponseEntityDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class EmergencyRoomSearchService {

    private final RestTemplate restTemplate;
    private final EmergencyRoomUriBuilderService emergencyRoomUriBuilderService;

    private final static String locationUrl = "http://apis.data.go.kr/B552657/ErmctInfoInqireService/getEgytListInfoInqire"; // 응급의료기관 목록정보 조회
    private final static String emergencyDetailHttpUrl = "http://apis.data.go.kr/B552657/ErmctInfoInqireService/getEgytBassInfoInqire"; // 응급의료기관 기본정보 조회

    @Value("${open.api.key}")
    private String serviceKey;

    public List<EmergencyRoomDto> getEmergencyRooms(String sido, String sigungu) {
        log.info("EmergencyRoomSearchService :: getEmergencyRooms :: sido = {}, sigungu = {}", sido, sigungu);

        MultiValueMap<String, String> queryParameters = new LinkedMultiValueMap<>();
        queryParameters.add("serviceKey", serviceKey);
        queryParameters.add("Q0", sido);
        queryParameters.add("Q1", sigungu);

        URI uri = emergencyRoomUriBuilderService.buildUri(locationUrl, queryParameters);
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_XML));

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        EmergencyRoomResponseEntityDto responseEntityDto = restTemplate.exchange(uri, HttpMethod.GET, requestEntity, EmergencyRoomResponseEntityDto.class).getBody();

        List<EmergencyRoomDto> emergencyRoomDtos = responseEntityDto.getEmergencyRoomResponseBodyDto().getEmergencyRoomDtos();

        return emergencyRoomDtos;
    }

    public EmergencyRoomDto getEmergencyRoom(String emergencyRoomId) {
        log.info("EmergencyRoomSearchService :: getEmergencyRoom :: emergencyRoomId = {}", emergencyRoomId);
        MultiValueMap<String, String> queryParameters = new LinkedMultiValueMap<>();
        queryParameters.add("serviceKey", serviceKey);
        queryParameters.add("HPID", emergencyRoomId);

        URI uri = emergencyRoomUriBuilderService.buildUri(emergencyDetailHttpUrl, queryParameters);

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_XML));
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        EmergencyRoomResponseEntityDto responseEntityDto = restTemplate.exchange(uri, HttpMethod.GET, requestEntity, EmergencyRoomResponseEntityDto.class).getBody();

        EmergencyRoomDto emergencyRoomDto = responseEntityDto.getEmergencyRoomResponseBodyDto().getEmergencyRoomDtos().get(0);

        return emergencyRoomDto;
    }


}
