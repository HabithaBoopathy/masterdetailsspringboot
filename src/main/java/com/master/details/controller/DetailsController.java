package com.master.details.controller;

import com.master.details.model.Details;
import com.master.details.service.DetailsService;
import com.master.details.service.MasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("details")
@CrossOrigin(origins = "*")
public class DetailsController {
    @Autowired
    private DetailsService detailsService;

    @GetMapping
    public List<Details> getDetails(){return detailsService.getDetails();
    }

    @PostMapping
    public Boolean addDetails(@RequestBody Details details) {

        try {
            System.out.println("add works");
            detailsService.addDetails(details);
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    @DeleteMapping(value = "/{serialNo}")
    public Boolean deleteDetails(@PathVariable("serialNo") String serialNo) {
        try {
            detailsService.deleteDetails(serialNo);
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
}
