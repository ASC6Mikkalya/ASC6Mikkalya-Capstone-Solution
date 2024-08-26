package com.ats.service;

import com.ats.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirportServiceImpl implements AirportService{
    private final AirportRepository airportRepository;
    @Autowired
    public AirportServiceImpl(AirportRepository airportRepository){
        this.airportRepository=airportRepository;
    }
    @Override
    public String generateId() {
        String airportId = airportRepository.findTopId();
        if (airportId == null || airportId.isEmpty()) {
            airportId = "AP0000";
        }
        String id="AP";
        int num=Integer.parseInt(airportId.substring(2,6));
        num++;
        String digit=Integer.toString(num);
        switch(4-digit.length()){
            case 1:
                id+="0";
                break;
            case 2:
                id+="00";
                break;
            case 3:
                id+="000";
                break;
            default:
                break;
        }
        id+=digit;
        return id;
    }
}
