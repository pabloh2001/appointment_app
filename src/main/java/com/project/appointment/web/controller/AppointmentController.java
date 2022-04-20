package com.project.appointment.web.controller;

import com.project.appointment.domain.dto.Appointment;
import com.project.appointment.domain.service.AppointmentService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    private final Log LOGGER = LogFactory.getLog(AppointmentController.class);

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping("/")
    public ResponseEntity<List<Appointment>> getAppointments(){
        return new ResponseEntity<>(appointmentService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Appointment> save(@RequestBody Appointment appointment){
        return new ResponseEntity<>(appointmentService.save(appointment), HttpStatus.CREATED);
    }
}
