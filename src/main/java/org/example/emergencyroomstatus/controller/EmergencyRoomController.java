package org.example.emergencyroomstatus.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.emergencyroomstatus.service.EmergencyRoomSearchService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

        emergencyRoomSearchService.getEmergencyRooms(sido, sigungu);

        return "emergency-rooms";
    }

}
