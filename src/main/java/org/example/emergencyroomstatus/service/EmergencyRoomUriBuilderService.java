package org.example.emergencyroomstatus.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class EmergencyRoomUriBuilderService {

    private static final String HTTP_URL = "http://apis.data.go.kr/B552657/ErmctInfoInqireService/getEgytListInfoInqire";

    @Value("${open.api.key}")
    private String serviceKey;

    public URI buildUri(String sido, String sigungu) {
        return UriComponentsBuilder.fromHttpUrl(HTTP_URL)
                .queryParam("serviceKey", serviceKey)
                .queryParam("Q0", sido)
                .queryParam("Q1", sigungu)
                .encode().build().toUri();
    }

}
