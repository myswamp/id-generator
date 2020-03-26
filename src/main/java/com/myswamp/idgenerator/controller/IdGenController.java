package com.myswamp.idgenerator.controller;

import com.myswamp.idgenerator.dto.IdBatch;
import com.myswamp.idgenerator.service.IdService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/id")
public class IdGenController {

    @Autowired
    private IdService idService;

    public IdBatch getIdsByBusinessTag(@RequestParam String businessTag) {
        
        return idService.getIdBatchByBusinessTag(businessTag);
    }



}