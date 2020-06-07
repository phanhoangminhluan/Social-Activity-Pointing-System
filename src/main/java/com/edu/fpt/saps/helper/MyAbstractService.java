package com.edu.fpt.saps.helper;

import com.edu.fpt.saps.mapper.BaseMapping;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.List;

public abstract class MyAbstractService<E, ID extends Serializable, D> extends MyAbstractSession implements MyInterfaceServiceHelper<ID, D> {

    protected MyJpaRepositoryHelper<E, ID> repository;

    protected BaseMapping<E, D> mappingHandler;

    /**
     * Please inject repository and mappingHandler
     */
    @PostConstruct
    protected abstract void inject();

    public List<D> getAll() throws Exception {

        List<E> entites = repository.getAll();

        return  mappingHandler.toDtos(entites);
}

    public D getById(ID id) throws Exception {
        E entity = repository.getById(id);
        return mappingHandler.toDto(entity);
    }

    public boolean add(D dto) throws Exception {
        boolean isSuccess = false;
        E entity = mappingHandler.toEntity(dto);
        repository.add(getSession(), entity);
        return true;
    }

    public boolean update(D dto) throws Exception {
        E entity = mappingHandler.toEntity(dto);
        repository.update(getSession(), entity);
        return true;
    }

    public D deleteById(ID id) throws Exception {
        try {
            E entity = repository.getById(id);

            repository.deleteById(id);
            return mappingHandler.toDto(entity);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
