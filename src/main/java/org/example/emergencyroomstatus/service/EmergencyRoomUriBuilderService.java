package org.example.emergencyroomstatus.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class EmergencyRoomUriBuilderService {

    public URI buildUri(String httpUrl, MultiValueMap<String, String> queryParameters) {
        return UriComponentsBuilder.fromHttpUrl(httpUrl)
                .queryParams(queryParameters)
                .encode().build().toUri();
    }

}
