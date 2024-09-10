package org.example.emergencyroomstatus.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.util.LinkedMultiValueMap;

import java.net.URI;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@Disabled("serviceKey 정보 보호 차원")
@DisplayName("URL 생성 테스트")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = EmergencyRoomUriBuilderService.class, properties = "/application.yaml")
class EmergencyRoomUriBuilderServiceTest {

    @Autowired
    EmergencyRoomUriBuilderService sut;

    String serviceKey;


    @DisplayName("주소1(시도), 주소2(시군구)가 주어졌을 때 해당 매개변수를 받아 URL을 생성한다.")
    @Test
    void givenTwoAddresses_whenBuildingUrl_returnsUrlWithParams() {
        // Given
        LinkedMultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        queryParams.add("Q0", "성남시");
        queryParams.add("Q1", "분당구");
        String httpUrl = "http://apis.data.go.kr/B552657/ErmctInfoInqireService/getEgytListInfoInqire";

        // When
        URI uri = sut.buildUri(httpUrl, queryParams);

        // Then
        assertThat(URLDecoder.decode(uri.toString(), StandardCharsets.UTF_8)).isEqualTo(
                new StringBuilder()
                        .append(httpUrl)
                        .append("?serviceKey=")
                        .append(serviceKey)
                        .append("&Q0=")
                        .append(queryParams.get("Q0"))
                        .append("&Q1=")
                        .append(queryParams.get("Q1"))
                        .toString()
        );
    }

}
