package com.master.details.service;

import com.master.details.model.DbSequence;
import com.master.details.model.Master;
import com.master.details.repository.MasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

import static com.master.details.model.Master.SEQUENCE_NAME;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

@Service
public class MasterService {
@Autowired
    MasterRepository masterRepository;
//    @Autowired
//    private SequenceGeneratorService service;
    @Autowired
MasterService masterService;
@Autowired
private MongoOperations mongoOperations;

    public List<Master> masterList = new CopyOnWriteArrayList<>();
//    public Master addMaster(Master master) {
//        return masterRepository.insert(master);
//    }
    @GetMapping
        public List<Master> getMaster() {
            {
                return (List<Master>) masterRepository.findAll();
            }
        }
        public Master getMaster(String no){
            Optional<Master> optional =masterRepository.findById(no);
            if(optional.isPresent()){
                return optional.get();
            }else{
                return null;
            }
        }

    public int getSequenceNumber(String sequenceName) {
        //get sequence no
        Query query = new Query(Criteria.where("id").is(sequenceName));
        //update the sequence no
        Update update = new Update().inc("seq", 1);
        //modify in document
        DbSequence counter = mongoOperations
                .findAndModify(query,
                        update, options().returnNew(true).upsert(true),
                        DbSequence.class);

        return !Objects.isNull(counter) ? counter.getSeq() : 1;
    }

    public Master save(Master master) {

        master.setMasterNo(masterService.getSequenceNumber(SEQUENCE_NAME));
        return masterRepository.save(master);

    }
//    public List<Master> detailsList = new CopyOnWriteArrayList<>();
//    public Master addDetails(Master master) {
//        return masterRepository.insert(master);
//    }
//    public List<Master> getDetails() {
//        {
//            return (List<Master>) masterRepository.findAll();
//        }
//    }
//    public Master getDetails(String id){
//        Optional<Master> optional =masterRepository.findById(id);
//        if(optional.isPresent()){
//            return optional.get();
//        }else{
//            return null;
//        }
//    }
    }



