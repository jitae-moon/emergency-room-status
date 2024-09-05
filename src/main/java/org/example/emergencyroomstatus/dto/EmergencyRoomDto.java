package org.example.emergencyroomstatus.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class EmergencyRoomDto {

        @JacksonXmlProperty(localName = "dutyName")
        private String name;

        @JacksonXmlProperty(localName = "dutyAddr")
        private String address;

        @JacksonXmlProperty(localName = "wgs84Lat")
        private String latitude;

        @JacksonXmlProperty(localName = "wgs84Lon")
        private String longitude;

        public EmergencyRoomDto() { }

        @Builder
        public EmergencyRoomDto(String name, String address, String latitude, String longitude) {
                this.name = name;
                this.address = address;
                this.latitude = latitude;
                this.longitude = longitude;
        }

}

