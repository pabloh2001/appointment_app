package com.project.appointment.web.controller;

import com.project.appointment.domain.dto.Appointment;
import com.project.appointment.domain.service.AppointmentService;
import com.project.appointment.utils.HandlerExceptions.InvalidDataException;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    private final Log LOGGER = LogFactory.getLog(AppointmentController.class);

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping("/")
    @ApiOperation("Retorna todas las citas")
    public ResponseEntity<List<Appointment>> getAppointments(){
        return new ResponseEntity<>(appointmentService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    @ApiOperation("Retorna una cita con id en especifico")
    public ResponseEntity<Appointment> getAppointment(@PathVariable("id") String appointmentId){
        return appointmentService.getAppointment(appointmentId)
                .map(appointment -> new ResponseEntity<>(appointment, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/doctor/{doctorId}")
    @ApiOperation("Retorna las citas asociadas a un doctor")
    public ResponseEntity<List<Appointment>> getAppointmentsByDoctor(@PathVariable("doctorId") String doctorId){
        return appointmentService.getByDoctor(doctorId)
                .filter(appointments -> !appointments.isEmpty())
                .map(appointments -> new ResponseEntity<>(appointments, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/patient/{patientId}")
    @ApiOperation("Retorna las citas asociadas a un paciente")
    public ResponseEntity<List<Appointment>> getAppointmentsByPatient(@PathVariable("patientId") String patientId){
        return appointmentService.getByPatient(patientId)
                .filter(appointments -> !appointments.isEmpty())
                .map(appointments -> new ResponseEntity<>(appointments, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/")
    @ApiOperation("Registra una cita")
    public ResponseEntity<Appointment> save(@Valid @RequestBody Appointment appointment, BindingResult result){
        if (result.hasErrors()){
            throw new InvalidDataException(result);
        }
        return new ResponseEntity<>(appointmentService.save(appointment), HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    @ApiOperation("Elimina una cita por medio de su id")
    public ResponseEntity delete(@PathVariable("id") String appointmentId){
        return appointmentService.delete(appointmentId) ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
