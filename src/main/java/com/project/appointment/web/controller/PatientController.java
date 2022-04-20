package com.project.appointment.web.controller;

import com.project.appointment.domain.dto.Patient;
import com.project.appointment.domain.service.PatientService;
import com.project.appointment.utils.validators.InvalidDataException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
@RequestMapping("/patients")
public class PatientController {
    private final Log LOGGER = LogFactory.getLog(PatientController.class);
    @Autowired
    private PatientService patientService;

    @GetMapping("/")
    public ResponseEntity<List<Patient>> getPatients(){
        return patientService.getAll().isEmpty() ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(patientService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{patientId}")
    public ResponseEntity<Patient> getPatient(@PathVariable("patientId") String patientId){
        return patientService.getById(patientId)
                .map(patient -> new ResponseEntity<>(patient,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/type-id/{typeId}")
    public ResponseEntity<List<Patient>> patientsByTypeId(@PathVariable("typeId") String typeId){
        return patientService.getPatientsTypeId(typeId)
                .filter(patients -> !patients.isEmpty())
                .map(patients -> new ResponseEntity<>(patients, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/")
    public ResponseEntity<Patient> save(@Valid @RequestBody Patient patient, BindingResult result){
        LOGGER.info(result.hasErrors());
        if (result.hasErrors()){
            throw new InvalidDataException(result);
        }
        return new ResponseEntity<>(patientService.savePatient(patient), HttpStatus.CREATED);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<Patient> update(@PathVariable("id") String patientId, @RequestBody Map<String, Object> fields){
        Patient patient = patientService.getById(patientId).get();
        fields.forEach((k, v) -> {
            Field field = ReflectionUtils.findField(Patient.class, k);
            field.setAccessible(true);
            ReflectionUtils.setField(field, patient, v);
        });
        return new ResponseEntity<>(patientService.savePatient(patient), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{patientId}")
    public ResponseEntity delete(@PathVariable("patientId")  String patientId){
        return patientService.deletePatient(patientId) ? new ResponseEntity(HttpStatus.OK) : new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
