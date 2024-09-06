package org.example.emergencyroomstatus.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.emergencyroomstatus.dto.EmergencyRoomDto;
import org.example.emergencyroomstatus.dto.response.EmergencyRoomResponseEntityDto;
import org.example.emergencyroomstatus.service.EmergencyRoomSearchService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/emergency-rooms")
@Controller
public class EmergencyRoomController {

    private final EmergencyRoomSearchService emergencyRoomSearchService;

    @GetMapping
    public String getEmergencyRooms(
            @RequestParam String sido,
            @RequestParam String sigungu,
            Model model
    ) {
        log.info("EmergencyRoomController :: getEmergencyRooms :: sido = {}, sigungu = {}", sido, sigungu);

        // Daum API에서 넘겨준 시군구를 공공데이터포털로 요청할 시 반환 개수가 0개인 경우가 있어서 시군구 맨 앞부분만 파싱해서 요청함
        String parsedSigungu = sigungu.split(" ")[0];

        List<EmergencyRoomDto> emergencyRooms = emergencyRoomSearchService.getEmergencyRooms(sido, parsedSigungu);

        model.addAttribute("emergencyRooms", emergencyRooms);

        return "emergency-rooms/index";
    }

    @GetMapping("/{id}")
    public String getEmergencyRoom(@PathVariable String id, Model model) {
        log.info("EmergencyRoomController :: getEmergencyRoom :: id = {}", id);

        EmergencyRoomDto emergencyRoom = emergencyRoomSearchService.getEmergencyRoom(id);
        model.addAttribute("emergencyRoom", emergencyRoom);

        return "emergency-rooms/detail";
    }

}
