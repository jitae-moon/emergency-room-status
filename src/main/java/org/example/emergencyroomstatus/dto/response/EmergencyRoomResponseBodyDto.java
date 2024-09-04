package org.example.emergencyroomstatus.dto.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.emergencyroomstatus.dto.EmergencyRoomDto;

@ToString
@Setter
@Getter
public class EmergencyRoomResponseBodyDto{

        @JacksonXmlElementWrapper(localName = "items")
        @JacksonXmlProperty(localName = "item")
        EmergencyRoomDto[] emergencyRoomDto;

}
