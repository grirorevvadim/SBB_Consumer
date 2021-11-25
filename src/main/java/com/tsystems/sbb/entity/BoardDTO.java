package com.tsystems.sbb.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class BoardDTO implements Serializable {
    private String trainNumber;
    private String arrivalDateTime;
    private String station;
}
