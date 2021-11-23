package com.tsystems.sbb.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class StationDTO implements Serializable {
    private static final long serialVersionID = 22145433353252L;
    private Long id;

    private String stationName;

    private RootDTO root;

    private int index;

    @Override
    public String toString() {
        return "StationDTO{" +
                "stationName='" + stationName + '\'' +
                '}';
    }
}
