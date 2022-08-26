package com.master.details.repository;

import com.master.details.model.Details;
import com.master.details.model.Master;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface DetailsRepository extends MongoRepository<Details,String> {
    @Query(value="{serialNo : ?0}")
    Details findBySerialNo(int no);
}
