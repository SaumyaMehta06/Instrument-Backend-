package com.vnaazleen.instrumentDelight.repository;

import com.vnaazleen.instrumentDelight.model.RoleModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<RoleModel, String> {

}

