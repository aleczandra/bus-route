package goeuro.busroute.service;

import java.util.List;
import java.util.function.Predicate;

import com.fasterxml.jackson.annotation.JacksonInject;
import goeuro.busroute.model.BusRoute;
import goeuro.busroute.model.DirectRouteInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by alexandra on 11/13/16.
 */
@Component
public class BusRouteService {

    @Autowired
    BusRoutesDataProvider busRoutesDataProvider;

    public DirectRouteInfo existDirectRoute (int departureStation, int arrivalStation) {

        List<BusRoute> busRoutes = busRoutesDataProvider.getBusRoutes();
        if (busRoutes == null) {
            return new DirectRouteInfo(departureStation, arrivalStation, false);
        }

        Predicate<BusRoute> bothRoutesExistCondition = e -> e.getStations().contains(departureStation) && e.getStations().contains(arrivalStation);

        boolean bothRoutesExist = busRoutes.stream().anyMatch(bothRoutesExistCondition);
        if (bothRoutesExist) {
            return new DirectRouteInfo(departureStation, arrivalStation, true);
        }

        return new DirectRouteInfo(departureStation, arrivalStation, false);

    }

}
