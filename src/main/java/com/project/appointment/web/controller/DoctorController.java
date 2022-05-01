package com.project.appointment.web.controller;

import com.project.appointment.domain.dto.Doctor;
import com.project.appointment.domain.dto.Patient;
import com.project.appointment.domain.service.DoctorService;
import com.project.appointment.utils.HandlerExceptions.InvalidDataException;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping("/")
    @ApiOperation("Retorna todo los doctores")
    public ResponseEntity<List<Doctor>> getAll(){
        return new ResponseEntity<>(doctorService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{doctorId}")
    @ApiOperation("Retorna un doctor con id en especifico")
    public ResponseEntity<Doctor> getDoctor(@PathVariable("doctorId") String doctorId){
        return doctorService.getById(doctorId)
                .map(doctor -> new ResponseEntity<>(doctor, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/")
    @ApiOperation("Registra un doctor")
    public ResponseEntity<Doctor> save(@Valid @RequestBody Doctor doctor, BindingResult result){
        if (result.hasErrors()){
            throw new InvalidDataException(result);
        }
        return new ResponseEntity<>(doctorService.saveDoctor(doctor), HttpStatus.CREATED);
    }

    @PatchMapping("/update/{id}")
    @ApiOperation("Actualiza un doctor, de momento este endpoint no esta completamente funcional")
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
    @ApiOperation("Elimina un doctor por medio de su id")
    public ResponseEntity delete(@PathVariable("id") String doctorId){
        return doctorService.delete(doctorId) ? new ResponseEntity(HttpStatus.OK) : new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
