package com.master.details.controller;

import com.master.details.model.Details;
import com.master.details.model.Red;
import com.master.details.service.DetailsService;
import com.master.details.service.RedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("red")
@CrossOrigin(origins = "*")
public class RedController {
    @Autowired
    private RedService redService;

    @GetMapping
    public List<Red> getRed(){return redService.getRed();
    }

    @PostMapping
    public Boolean addRed(@RequestBody Red red) {

        try {
            System.out.println("add works");
            redService.addRed(red);
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
}
