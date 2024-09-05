package org.example.emergencyroomstatus.dto.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.emergencyroomstatus.dto.EmergencyRoomDto;

import java.util.List;

@ToString
@Setter
@Getter
public class EmergencyRoomResponseBodyDto{

        @JacksonXmlElementWrapper(localName = "items")
        @JacksonXmlProperty(localName = "item")
        List<EmergencyRoomDto>emergencyRoomDtos;

        public EmergencyRoomResponseBodyDto() { }

        @Builder
        public EmergencyRoomResponseBodyDto(List<EmergencyRoomDto> emergencyRoomDtos) {
                this.emergencyRoomDtos = emergencyRoomDtos;
        }

}
