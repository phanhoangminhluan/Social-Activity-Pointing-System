package com.edu.fpt.saps.service;

import com.edu.fpt.saps.dto.EventStudentDTO;
import com.edu.fpt.saps.dto.PostEventStudentDTO;
import com.edu.fpt.saps.entity.EventStudent;
import com.edu.fpt.saps.entity.EventStudentId;
import com.edu.fpt.saps.helper.MyInterfaceServiceHelper;

public interface EventStudentService extends MyInterfaceServiceHelper<EventStudentId, PostEventStudentDTO> {

    EventStudentDTO addThenReturn(PostEventStudentDTO eventStudent) throws Exception;
}
