package com.edu.fpt.saps.controller;

import com.edu.fpt.saps.constant.WebSocketConstant;
import com.edu.fpt.saps.dto.EventStudentDTO;
import com.edu.fpt.saps.dto.UuidDTO;
import com.edu.fpt.saps.utility.StompClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/qr")
public class QrCodeController {

    @Autowired
    private StompClient stompClient;

    @MessageMapping(WebSocketConstant.MESSAGE_MAPPING_GENERATE_QR_CODE)  // to request message APPLICATION_DESTINATION_PREFIX + MESSAGE_MAPPING_GENERATE_QR_CODE
    @SendTo(WebSocketConstant.QR_CODE_SUBSCRIPTION) // to subscribe: SEND_TO_GENERATE_QR_CODE
    public UuidDTO generateQrCode(@RequestParam String email) {

        System.out.println(email);
        // return uuid to client
        UuidDTO uuidDTO = UuidDTO.generateUUID();
        System.out.println(uuidDTO.getUuid());
        return uuidDTO;
    }

    @PostMapping("/student")
    public void registerNewStudent(EventStudentDTO eventStudentDTO) throws IOException, ExecutionException, InterruptedException {
        stompClient.sendMsg();
//        return ResponseDTO.generateResponseObject(
//                ResponseConstant.SUCCESS,
//                ResponseConstant.RUN_SUCCESSFULLY,
//                ResponseConstant.EMPTY_BODY,
//                HttpStatus.CREATED
//        );
        return;
    }

}
