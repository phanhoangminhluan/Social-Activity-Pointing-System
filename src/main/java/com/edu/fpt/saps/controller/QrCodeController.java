package com.edu.fpt.saps.controller;

import com.edu.fpt.saps.constant.WebSocketConstant;
import com.edu.fpt.saps.dto.EventStudentDTO;
import com.edu.fpt.saps.dto.UuidDTO;
import com.edu.fpt.saps.helper.CommonHelper;
import com.edu.fpt.saps.configuration.websocket.StompClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/qr")
public class QrCodeController {

    @Autowired
    private StompClient stompClient;

    @MessageMapping(WebSocketConstant.QR_CODE_METHOD)  // to request message APPLICATION_DESTINATION_PREFIX + MESSAGE_MAPPING_GENERATE_QR_CODE
    @SendTo(WebSocketConstant.QR_CODE_TOPIC) // to subscribe: SEND_TO_GENERATE_QR_CODE
    public UuidDTO generateQrCode(@RequestParam String email) {

        String date = CommonHelper.getCurrentDateTime();
        UuidDTO uuidDTO = UuidDTO.generateUUID();
        return uuidDTO;
    }

    @PostMapping("/student")
    public void registerNewStudent(EventStudentDTO eventStudentDTO){
        stompClient.sendMsg();
    }

}
