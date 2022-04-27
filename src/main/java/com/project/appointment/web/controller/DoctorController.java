package com.project.appointment.web.controller;

import com.project.appointment.domain.dto.Doctor;
import com.project.appointment.domain.dto.Patient;
import com.project.appointment.domain.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping("/")
    public ResponseEntity<List<Doctor>> getAll(){
        return new ResponseEntity<>(doctorService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{doctorId}")
    public ResponseEntity<Doctor> getDoctor(@PathVariable("doctorId") String doctorId){
        return doctorService.getById(doctorId)
                .map(doctor -> new ResponseEntity<>(doctor, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/")
    public ResponseEntity<Doctor> save(@RequestBody Doctor doctor){
        return new ResponseEntity<>(doctorService.saveDoctor(doctor), HttpStatus.CREATED);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<Doctor> update(@PathVariable("id") String doctorId, @RequestBody Map<String, Object> fields){
        Doctor doctor = doctorService.getById(doctorId).get();

        fields.forEach((k, v) -> {
            Field field = ReflectionUtils.findField(Doctor.class, k);
            field.setAccessible(true);
            ReflectionUtils.setField(field, doctor, v);
        });
        return new ResponseEntity<>(doctorService.saveDoctor(doctor), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") String doctorId){
        return doctorService.delete(doctorId) ? new ResponseEntity(HttpStatus.OK) : new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
