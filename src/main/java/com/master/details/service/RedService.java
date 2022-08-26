package com.master.details.service;

import com.master.details.model.Red;
import com.master.details.repository.RedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
@Service
public class RedService {
    @Autowired
    RedRepository redRepository;
    public List<Red> redList = new CopyOnWriteArrayList<>();
    public Red addRed(Red red) {
        return redRepository.insert(red);
    }
    public List<Red> getRed() {
        {
            return (List<Red>) redRepository.findAll();
        }
    }
    public Red getRed(String no){
        Optional<Red> optional =redRepository.findById(no);
        if(optional.isPresent()){
            return optional.get();
        }else{
            return null;
        }
    }
}
