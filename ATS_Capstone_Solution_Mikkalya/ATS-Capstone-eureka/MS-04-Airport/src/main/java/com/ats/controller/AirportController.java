package com.ats.controller;

import com.ats.entity.Airport;
import com.ats.model.AirportDTO;
import com.ats.repository.AirportRepository;
import com.ats.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api")
public class AirportController {
    private final AirportRepository airportRepository;
    private final AirportService airportService;
    @Autowired
    public AirportController(AirportRepository airportRepository,AirportService airportService){
        this.airportRepository=airportRepository;
        this.airportService=airportService;
    }
    @GetMapping("airport")
    public List<Airport> getAllAirport(){
        return airportRepository.findAll();
    }
    @GetMapping("/airport/{apId}")
    public AirportDTO getAirportDetails(@PathVariable(value = "apId") String airportId){
        try{
            Airport airportDetails=airportRepository.findById(airportId).get();
            return new AirportDTO(airportDetails.getId(),airportDetails.getAirportName(),airportDetails.getCity(),airportDetails.getCountry(),airportDetails.getCountryCode());
        }
        catch(NoSuchElementException noSuchElementException){
            return null;
        }
    }
    @PostMapping("/airport")
    public String insertAirportDetails(@RequestBody AirportDTO airportInfo){
        if(airportInfo.getAirportName()==null||airportInfo.getCity()==null||airportInfo.getCountry()==null||airportInfo.getAirportName().isEmpty()||airportInfo.getCity().isEmpty()||airportInfo.getCountry().isEmpty()||airportInfo.getCountryCode()==null||airportInfo.getCountryCode().isEmpty()){
            return "Please provide the required details";
        }
        try{
            Airport airportData=airportRepository.findByAirportName(airportInfo.getAirportName());
            if(airportData!=null) return "Airport Details already exists";
            else{
                String airportId=airportService.generateId();
                Airport airportDetails=new Airport(airportId,airportInfo.getAirportName(),airportInfo.getCity(),airportInfo.getCountry(),airportInfo.getCountryCode());
                airportRepository.save(airportDetails);
                return "Airport Details inserted successfully";
            }
        }
        catch(NoSuchElementException noSuchElementException){
            return null;
        }
    }
    @DeleteMapping("/airport/{apId}")
    public String deleteAirportDetails(@PathVariable(value = "apId") String airportId){
        try{
            Airport airportDetailsToBeDeleted=airportRepository.findById(airportId).get();
            airportRepository.delete(airportDetailsToBeDeleted);
            return "Airport Details deleted successfully";
        }
        catch(NoSuchElementException noSuchElementException){
            return "Airport Details is not available";
        }
    }
    @PutMapping("/airport")
    public String updateAirportDetails(@RequestBody AirportDTO airportInfo){
        try{
            Airport airportDetailsToBeUpdated=airportRepository.findById(airportInfo.getId()).get();
            if(airportInfo.getAirportName()!=null&&!airportInfo.getAirportName().isEmpty())airportDetailsToBeUpdated.setAirportName(airportInfo.getAirportName());
            if(airportInfo.getCity()!=null&&!airportInfo.getCity().isEmpty())airportDetailsToBeUpdated.setCity(airportInfo.getCity());
            if(airportInfo.getCountry()!=null&&!airportInfo.getCountry().isEmpty())airportDetailsToBeUpdated.setCountry(airportInfo.getCountry());
            if(airportInfo.getCountryCode()!=null&&!airportInfo.getCountryCode().isEmpty())airportDetailsToBeUpdated.setCountryCode(airportInfo.getCountryCode());
            airportRepository.save(airportDetailsToBeUpdated);
            return "Airport Details updated successfully";
        }
        catch(NoSuchElementException noSuchElementException){
            return "Airport Details not updated for the provided Airport Id";
        }
    }
}
