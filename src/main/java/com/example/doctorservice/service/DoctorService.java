package com.example.doctorservice.service;

import com.example.doctorservice.dto.DoctorResponse;
import com.example.doctorservice.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<DoctorResponse> findAll() {
        return doctorRepository.findAll().stream()
                .map(d -> new DoctorResponse(d.getId(), d.getName(), d.getSpecialization()))
                .toList();
    }
}
