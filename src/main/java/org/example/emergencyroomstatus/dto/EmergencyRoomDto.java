package org.example.emergencyroomstatus.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmergencyRoomDto {

        @JacksonXmlProperty(localName = "hpid")
        private String id;

        @JacksonXmlProperty(localName = "dutyName")
        private String name;

        @JacksonXmlProperty(localName = "dutyAddr")
        private String address;

        @JacksonXmlProperty(localName = "wgs84Lat")
        private String latitude;

        @JacksonXmlProperty(localName = "wgs84Lon")
        private String longitude;

        @JacksonXmlProperty(localName = "dutyEmclsName")
        private String category;

        // 대표 전화
        @JacksonXmlProperty(localName = "dutyTel1")
        private String mainContact;

        // 응급실 전화
        @JacksonXmlProperty(localName = "dutyTel3")
        private String directContact;

        public EmergencyRoomDto() { }

        @Builder
        public EmergencyRoomDto(String id, String name, String address, String latitude, String longitude, String category) {
                this.name = name;
                this.address = address;
                this.latitude = latitude;
                this.longitude = longitude;
                this.category = category;
        }

}

