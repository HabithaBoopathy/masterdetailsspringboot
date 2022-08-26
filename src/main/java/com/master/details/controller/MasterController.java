package com.master.details.controller;

import com.master.details.model.Details;
import com.master.details.model.Master;
import com.master.details.repository.MasterRepository;
import com.master.details.service.MasterService;
import com.master.details.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.master.details.model.Master.SEQUENCE_NAME;

@RestController
@RequestMapping("masters")
@CrossOrigin(origins = "*")
public class MasterController {
    @Autowired
    private MasterService masterService;

    @Autowired
    MasterRepository masterRepository;
    @GetMapping
    public List<Master> getMaster() {
        return masterService.getMaster();
    }

    @PostMapping
    public Master addMaster(@RequestBody Master master) {

        master.setMasterNo(masterService.getSequenceNumber(SEQUENCE_NAME));
        return masterRepository.save(master);
    }
//    @PostMapping("/saveMaster")
//    public Master save(@RequestBody Master master){
//        //generate sequence
//        master.setMasterNo(service.getSequenceNumber(SEQUENCE_NAME));
//        return MasterRepository.save(master);
//    }


//    @GetMapping
//    public List<Master> getDetails(){return masterService.getDetails();
//    }
//
//    @PostMapping(value="/details")
//    public Boolean addDetails(@RequestBody Master master) {
//
//        try {
//            System.out.println("add works");
//            masterService.addDetails(master);
//            return true;
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        return false;
//    }
}
