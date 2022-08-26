package com.master.details.repository;

import com.master.details.model.Details;
import com.master.details.model.Master;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface MasterRepository extends MongoRepository<Master,String> {
    @Query(value="{masterNo : ?0}")
    Master findByMasterNo(int no);

}
