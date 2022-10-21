package com.clientApirest.cliente.clienteservice;


import ch.qos.logback.core.net.server.Client;
import com.clientApirest.cliente.clienteRepository.ClienteRepository;
import com.clientApirest.cliente.model.Cliente;
import com.clientApirest.cliente.model.Response;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteServicio {
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente create(Cliente newClient) {

        return this.clienteRepository.save(newClient);
    }

    public List<Cliente> findAll() {

        return this.clienteRepository.findAll();
    }

    public Cliente update(Cliente cliente, Long id) {
        Optional<Cliente> clientDB = this.clienteRepository.findById(id);
        if (clientDB.isPresent()) {
            Cliente c = clientDB.get();
            c.setApellido(cliente.getApellido());
            c.setNombre(cliente.getNombre());
            c.setFecha_nacimiento(cliente.getFecha_nacimiento());
            c.setEdad(cliente.getEdad());
            return this.clienteRepository.save(c);
        } else {
            return null;

        }

    }

    public Response ClienteEdad(Long id) {
        Cliente ClienteBD = this.clienteRepository.findById(id).orElseThrow();
       return Response.builder()
                .age((int) edadCalculo(ClienteBD.getFecha_nacimiento()))
                .nombre(ClienteBD.getNombre())
                .apellido(ClienteBD.getApellido())
                .build();
    }

    private int edadCalculo (LocalDate fechanacimientoCliente){
        LocalDate fecha = LocalDate.now();
        Integer edad = 0;
        Period period = Period.between(fechanacimientoCliente, fecha);
        edad = period.getYears();
        return edad;
    }
}
