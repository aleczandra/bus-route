package goeuro.busroute.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import goeuro.busroute.model.BusRoute;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * Created by alexandra on 11/13/16.
 */
@Component
public class BusRoutesDataProvider implements ApplicationRunner{

    private List<BusRoute> busRoutes = new ArrayList<>();
    private int noOfRoutes = 0;
    private String ROUTES_FILE_PATH = "";//"/home/alexandra/exercism/busroute/src/main/resources/example.txt";

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //TODO: how to run this from IDE so that it populates the dataFile list
        List<String> dataFile = args.getOptionValues("dataFile");
        if (dataFile == null) {
            String[] sourceArgs = args.getSourceArgs();
            if (sourceArgs != null && sourceArgs.length > 0)
            ROUTES_FILE_PATH = sourceArgs[0].split("=")[1];
        }
        if (dataFile != null && dataFile.size() > 0) {
            ROUTES_FILE_PATH = dataFile.get(0);
        }
        busRoutes = readBusRoutesFromFile();
        busRoutes.forEach(bs -> System.out.println(bs));
    }

    public List<BusRoute> readBusRoutesFromFile () {

        //TODO: this can be done better with streams
        try {
                List<String> lines = Files.readAllLines(Paths.get(ROUTES_FILE_PATH));
                noOfRoutes = Integer.valueOf(lines.get(0));
                lines.remove(0);
                return lines.stream().map(s -> s.split(" ")).map(a -> {
                    BusRoute br = new BusRoute();
                    br.setId(Integer.valueOf(a[0]));
                    for (int i = 1; i < a.length; i++)
                        br.getStations().add(Integer.valueOf(a[i]));
                    return br;
                }).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getNoOfRoutes() {
        return noOfRoutes;
    }

    public List<BusRoute> getBusRoutes() {
        return busRoutes;
    }
}
