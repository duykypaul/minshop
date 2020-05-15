package com.duykypaul.core.common;

import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface GenericDao<ID extends Serializable, T> {
    List<T> findAll();
}
