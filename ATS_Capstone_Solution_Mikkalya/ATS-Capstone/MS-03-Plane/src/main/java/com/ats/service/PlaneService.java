package com.ats.service;

import com.ats.model.PlaneDTO;

import java.util.List;

public interface PlaneService {
    String generateId();
    List<PlaneDTO> getAllPlane();
}
