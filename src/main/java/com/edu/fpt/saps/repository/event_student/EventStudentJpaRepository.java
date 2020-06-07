package com.edu.fpt.saps.repository.event_student;

import com.edu.fpt.saps.entity.EventStudent;
import com.edu.fpt.saps.entity.EventStudentId;
import com.edu.fpt.saps.helper.MyJpaRepositoryHelper;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface EventStudentJpaRepository extends MyJpaRepositoryHelper<EventStudent, EventStudentId> {

    EventStudent findByToken(String token);
}
