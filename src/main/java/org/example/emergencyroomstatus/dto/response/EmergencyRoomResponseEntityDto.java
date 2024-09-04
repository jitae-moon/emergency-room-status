package org.example.emergencyroomstatus.dto.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
@JacksonXmlRootElement(localName = "response")
public class EmergencyRoomResponseEntityDto{

        @JacksonXmlProperty(localName = "header")
        EmergencyRoomResponseHeaderDto emergencyRoomResponseHeaderDto;

        @JacksonXmlProperty(localName = "body")
        EmergencyRoomResponseBodyDto emergencyRoomResponseBodyDto;

}
