package com.tsystems.sbb.controller;

import com.tsystems.sbb.entity.BoardDTO;
import com.tsystems.sbb.entity.StationDTO;
import com.tsystems.sbb.service.MyListener;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    @GetMapping("/home")
    public ModelAndView startPage() {
        var modelAndView = new ModelAndView();
        modelAndView.addObject("station", new StationDTO());
        modelAndView.setViewName("home");
        return modelAndView;
    }

    @GetMapping("/board")
    public ModelAndView generateBoard(@ModelAttribute(name = "station") StationDTO station) {
        var listByStation = filterBoardByStation(station.getStationName());
        var modelAndView = new ModelAndView();
        modelAndView.setViewName("board");
        modelAndView.addObject("board", listByStation);
        return modelAndView;
    }

    private List<BoardDTO> filterBoardByStation(String stationName) {
        var allSchedules = MyListener.boards;
        List<BoardDTO> filtered = new ArrayList<>();
        for (BoardDTO b : allSchedules) {
            if (b.getStation().equals(stationName)) filtered.add(b);
        }
        return filtered;
    }
}
