package org.example.emergencyroomstatus.dto.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class EmergencyRoomResponseHeaderDto {

        @JacksonXmlProperty(localName = "resultCode")
        String resultCode;

        @JacksonXmlProperty(localName = "resultMsg")
        String resultMessage;

        public EmergencyRoomResponseHeaderDto() { }

        @Builder
        public EmergencyRoomResponseHeaderDto(String resultCode, String resultMessage) {
                this.resultCode = resultCode;
                this.resultMessage = resultMessage;
        }

}
