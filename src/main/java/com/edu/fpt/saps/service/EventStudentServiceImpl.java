package com.edu.fpt.saps.service;

import com.edu.fpt.saps.constant.ExceptionConstant;
import com.edu.fpt.saps.dto.EventStudentDTO;
import com.edu.fpt.saps.dto.PostEventStudentDTO;
import com.edu.fpt.saps.entity.EventStudent;
import com.edu.fpt.saps.entity.EventStudentId;
import com.edu.fpt.saps.helper.CommonHelper;
import com.edu.fpt.saps.helper.MyAbstractService;
import com.edu.fpt.saps.mapper.EventStudentMapping;
import com.edu.fpt.saps.repository.event_student.EventStudentRepository;
import org.hibernate.exception.ConstraintViolationException;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventStudentServiceImpl extends MyAbstractService<EventStudent, EventStudentId, PostEventStudentDTO> implements EventStudentService {

    @Autowired
    private EventStudentRepository eventStudentRepository;

    private EventStudentMapping eventStudentMapping = Mappers.getMapper(EventStudentMapping.class);


    @Override
    protected void inject() {
        this.repository = eventStudentRepository;
        this.mappingHandler = eventStudentMapping;
    }

    public EventStudentDTO addThenReturn(PostEventStudentDTO dto) throws Exception {

        if (dto == null) return null;

        EventStudent eventStudent = eventStudentMapping.toEntity(dto);
        eventStudent.setCheckinDate(CommonHelper.getCurrentDateTime());

        if (eventStudentRepository.findByToken(eventStudent.getToken()) != null) {
            throw new Exception("This code has been registered. Please generate the new one !");
        }

        try {
            eventStudentRepository.add(getSession(), eventStudent);
        } catch (Exception e) {
            ConstraintViolationException constraintViolationException = (ConstraintViolationException) e.getCause();
            if (constraintViolationException != null) {
                throw new Exception("The current email has been registered for this event!. ");
            }
            throw new Exception(ExceptionConstant.ERROR_WHEN_ADDED);
        }

        return EventStudentDTO.builder()
                .email(dto.getEmail())
                .checkinDate(eventStudent.getCheckinDate())
                .token(dto.getToken())
                .build();
    }
}
