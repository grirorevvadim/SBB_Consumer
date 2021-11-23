package com.tsystems.sbb.entity;

import com.tsystems.sbb.entity.util.TrainType;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class TrainDTO implements Serializable {
    private static final long serialVersionID = 21234346111252L;
    private Long id;

    private Integer allSeatsNumber;

    private String departureName;

    private String arrivalName;

    private String departureDate;
    private String arrivalDate;

    private String trainNumber;
    private TrainType trainType;

    private Integer sectionPrice;
    private List<ScheduleDTO> scheduleList;
    private RootDTO root;
}
