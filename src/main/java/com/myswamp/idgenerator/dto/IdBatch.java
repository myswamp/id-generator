package com.myswamp.idgenerator.dto;

import lombok.Data;

@Data
public class IdBatch {
    private long start;
    private int step;
    private String businessTag;
}