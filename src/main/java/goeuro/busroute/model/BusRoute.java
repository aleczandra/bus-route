package goeuro.busroute.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexandra on 11/13/16.
 */
public class BusRoute {


    private Integer id;
    private List<Integer> stations = new ArrayList<>();

    public List<Integer> getStations() {
        return stations;
    }

    public void setStations(List<Integer> stations) {
        this.stations = stations;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Id:" + id + " Stations:");
        stations.forEach(s -> sb.append(s + " "));
        return sb.toString();
    }
}
