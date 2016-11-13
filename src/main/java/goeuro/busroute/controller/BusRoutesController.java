package goeuro.busroute.controller;

import goeuro.busroute.model.DirectRouteInfo;
import goeuro.busroute.service.BusRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by alexandra on 11/13/16.
 */
@RestController
public class BusRoutesController {


    @Autowired
    BusRouteService busRouteService;

    @RequestMapping(value = "/api/direct", method = RequestMethod.GET,  produces = "application/json")
    @ResponseBody
    public DirectRouteInfo existDirectRouteBetweenStations (@RequestParam("dep_sid") int departureStation, @RequestParam("arr_sid") int arrivalStation)
    {
        return busRouteService.existDirectRoute(departureStation, arrivalStation);
    }
}




