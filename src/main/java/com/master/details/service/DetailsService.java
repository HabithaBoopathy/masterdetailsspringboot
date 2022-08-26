package com.master.details.service;

import com.master.details.model.Details;
import com.master.details.repository.DetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class DetailsService {
    @Autowired
    DetailsRepository detailsRepository;
    public List<Details> detailsList = new CopyOnWriteArrayList<>();
    public Details addDetails(Details details) {
        return detailsRepository.insert(details);
    }
    public List<Details> getDetails() {
        {
            return (List<Details>) detailsRepository.findAll();
        }
    }
    public Details getDetails(String no){
        Optional<Details> optional =detailsRepository.findById(no);
        if(optional.isPresent()){
            return optional.get();
        }else{
            return null;
        }
    }

    public String deleteDetails(String id){
        detailsRepository.deleteById(id);
        return "success";
    }


}
