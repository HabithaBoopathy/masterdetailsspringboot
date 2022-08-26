package com.master.details.repository;

import com.master.details.model.Master;
import com.master.details.model.Red;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface RedRepository extends MongoRepository<Red,String> {
    @Query(value="{masterNo : ?0}")
    Master findByMasterNo(int no);
}
