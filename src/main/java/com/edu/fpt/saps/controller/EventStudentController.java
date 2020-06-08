package com.edu.fpt.saps.controller;

import com.edu.fpt.saps.constant.ResponseConstant;
import com.edu.fpt.saps.constant.WebSocketConstant;
import com.edu.fpt.saps.dto.EventStudentDTO;
import com.edu.fpt.saps.dto.PostEventStudentDTO;
import com.edu.fpt.saps.helper.ResponseHelper;
import com.edu.fpt.saps.dto.UuidDTO;
import com.edu.fpt.saps.configuration.websocket.StompClient;
import com.edu.fpt.saps.service.EventStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/qr")
public class EventStudentController {

    @Autowired
    private StompClient stompClient;

    @Autowired
    private EventStudentService eventStudentService;


    @MessageMapping(WebSocketConstant.QR_CODE_METHOD)  // to request message APPLICATION_DESTINATION_PREFIX + MESSAGE_MAPPING_GENERATE_QR_CODE
    @SendTo(WebSocketConstant.QR_CODE_TOPIC) // to subscribe: SEND_TO_GENERATE_QR_CODE
    public UuidDTO generateQrCode() {

        UuidDTO uuidDTO = UuidDTO.generateUUID();
        return uuidDTO;
    }

    @GetMapping("")
    @ResponseBody
    public UuidDTO generateUuid() {
        UuidDTO uuidDTO = UuidDTO.generateUUID();
        return uuidDTO;
    }

    @PostMapping("/student")
    public ResponseEntity registerNewStudent(@RequestBody PostEventStudentDTO postEventStudentDTO) throws Exception {

        EventStudentDTO eventStudentDTO = eventStudentService.addThenReturn(postEventStudentDTO);;
        stompClient.generateNewQrCode();

        return eventStudentDTO != null

                ? ResponseHelper.builder()
                .isSuccess(true).body(eventStudentDTO)
                .messages(ResponseConstant.RUN_SUCCESSFULLY)
                .status(HttpStatus.OK)
                .build().toResponseEntity()

                : ResponseHelper.builder()
                .isSuccess(false).body(ResponseConstant.EMPTY_BODY)
                .messages(ResponseConstant.RUN_UNSUCCESSFULLY)
                .status(HttpStatus.BAD_REQUEST)
                .build().toResponseEntity();
    }



}
