package com.edu.fpt.saps.mapper;

import com.edu.fpt.saps.dto.PostEventStudentDTO;
import com.edu.fpt.saps.entity.EventStudent;
import com.edu.fpt.saps.entity.EventStudentId;
import com.edu.fpt.saps.helper.MappingHelper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper
public abstract class EventStudentMapping extends MappingHelper implements BaseMapping<EventStudent, PostEventStudentDTO>{


    @Override
    public EventStudent toEntity(PostEventStudentDTO dto) {
        return EventStudent.builder()
                .eventStudentId(EventStudentId.builder()
                    .email(dto.getEmail())
                    .eventId(dto.getEventId())
                    .build())
                .token(dto.getToken())
                .build();

    }

    @Override
    public PostEventStudentDTO toDto(EventStudent entity) {
        return PostEventStudentDTO.builder()
                .email(entity.getEventStudentId().getEmail())
                .eventId(entity.getEventStudentId().getEventId())
                .build();
    }

    @Override
    public abstract List<EventStudent> toEntities(List<PostEventStudentDTO> dtos);

    @Override
    public abstract List<PostEventStudentDTO> toDtos(List<EventStudent> entities);
}
