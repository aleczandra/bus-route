package goeuro.busroute.model;

/**
 * Created by alexandra on 11/13/16.
 */
public class DirectRouteInfo {

    private int departureStation;
    private int arrivalStation;
    private boolean existDirectRoute;

    public DirectRouteInfo(int departureStation, int arrivalStation, boolean b) {
        this.departureStation = departureStation;
        this.arrivalStation = arrivalStation;
        this.existDirectRoute = b;
    }

    public boolean isExistDirectRoute() {
        return existDirectRoute;
    }

    public void setExistDirectRoute(boolean existDirectRoute) {
        this.existDirectRoute = existDirectRoute;
    }

    public int getDepartureStation() {
        return departureStation;
    }

    public void setDepartureStation(int departureStation) {
        this.departureStation = departureStation;
    }

    public int getArrivalStation() {
        return arrivalStation;
    }

    public void setArrivalStation(int arrivalStation) {
        this.arrivalStation = arrivalStation;
    }





}
