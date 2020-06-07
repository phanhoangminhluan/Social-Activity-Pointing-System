package com.edu.fpt.saps.helper;

import com.edu.fpt.saps.constant.ExceptionConstant;
import org.hibernate.Session;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@NoRepositoryBean
public interface MyJpaRepositoryHelper<E, ID extends Serializable>
        extends CrudRepository<E, ID> {

    @Override
    Iterable<E> findAll();

    @Override
    Optional<E> findById(ID id);

    default E getById(ID id) throws Exception {
        Optional<E> entityOptional = findById(id);
        E  entity = entityOptional.orElse(null);

        if (entity == null) throw new Exception(ExceptionConstant.NO_OBJECT_FOUND);

        return entity;
    }

    default List<E> getAll() throws Exception {

        List list =  StreamSupport
                .stream(findAll().spliterator(), false)
                .collect(Collectors.toList());
        if (list == null || list.size() == 0) {
            throw new Exception(ExceptionConstant.NO_OBJECTS_FOUND);
        }
        return list;
    }

    @Transactional
    default void add(Session session, E entity) throws Exception {
        try {
            session.save(entity);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(ExceptionConstant.ERROR_WHEN_ADDED);
        }
    }

    @Transactional
    default void update(Session session, E entity) throws Exception {
        try {
            session.update(entity);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(ExceptionConstant.ERROR_WHEN_UPDATE);
        }
    }

}
