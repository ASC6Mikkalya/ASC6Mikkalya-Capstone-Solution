package com.ats.controller;

import com.ats.entity.Plane;
import com.ats.model.PlaneDTO;
import com.ats.repository.PlaneRepository;
import com.ats.service.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api")
public class PlaneController {
    private final PlaneRepository planeRepository;
    private final PlaneService planeService;
    @Autowired
    public PlaneController(PlaneRepository planeRepository,PlaneService planeService){
        this.planeRepository=planeRepository;
        this.planeService=planeService;
    }
    @GetMapping("/plane")
    public List<PlaneDTO> getAllPlane(){
        return planeService.getAllPlane();
    }
    @GetMapping("/plane/{plId}")
    public PlaneDTO getPlaneDetails(@PathVariable(value = "plId") String planeId){
        try{
            Plane planeDetails=planeRepository.findById(planeId).get();
            return new PlaneDTO(planeDetails.getId(),planeDetails.getModel(),planeDetails.getManufacturer(),planeDetails.getImage(),planeDetails.getSeatingCapacity());
        }
        catch(NoSuchElementException noSuchElementException){
            return null;
        }
    }
    @PostMapping("/plane")
    public String insertPlaneDetails(@RequestBody PlaneDTO planeInfo){
        if(planeInfo.getModel()==null||planeInfo.getManufacturer()==null||planeInfo.getSeatingCapacity()<=0||planeInfo.getModel().isEmpty()||planeInfo.getManufacturer().isEmpty()){
            return "Please provide the required details";
        }
        String planeId=planeService.generateId();
        Plane planeDetails=new Plane(planeId,planeInfo.getModel(),planeInfo.getManufacturer(),planeInfo.getImage(),planeInfo.getSeatingCapacity());
        planeRepository.save(planeDetails);
        return "Plane Details inserted successfully";
    }
    @DeleteMapping("/plane/{plId}")
    public String deletePlaneDetails(@PathVariable(value = "plId") String planeId){
        try{
            Plane planeDetailsToBeDeleted=planeRepository.findById(planeId).get();
            planeRepository.delete(planeDetailsToBeDeleted);
            return "Plane Details deleted successfully";
        }
        catch(NoSuchElementException noSuchElementException){
            return "Plane Details is not available";
        }
    }
    @PutMapping("/plane")
    public String updatePlaneDetails(@RequestBody PlaneDTO planeInfo){
        try{
            Plane planeDetailsToBeUpdated=planeRepository.findById(planeInfo.getId()).get();
            if(planeInfo.getModel()!=null&&!planeInfo.getModel().isEmpty()) planeDetailsToBeUpdated.setModel(planeInfo.getModel());
            if(planeInfo.getManufacturer()!=null&&!planeInfo.getManufacturer().isEmpty())planeDetailsToBeUpdated.setManufacturer(planeInfo.getManufacturer());
            if(planeInfo.getImage()!=null&&!planeInfo.getImage().isEmpty())planeDetailsToBeUpdated.setImage(planeInfo.getImage());
            if(planeInfo.getSeatingCapacity()>0){
                planeDetailsToBeUpdated.setSeatingCapacity(planeInfo.getSeatingCapacity());
            }
            planeRepository.save(planeDetailsToBeUpdated);
            return "Plane Details updated successfully";
        }
        catch(NoSuchElementException noSuchElementException){
            return "Plane Details not updated for the provided Plane Id";
        }
    }
}
