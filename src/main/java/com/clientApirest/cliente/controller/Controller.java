package com.clientApirest.cliente.controller;

import com.clientApirest.cliente.clienteservice.ClienteServicio;
import com.clientApirest.cliente.model.Cliente;
import com.clientApirest.cliente.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "api/client")
@RestController
public class Controller {

    @Autowired
    private ClienteServicio clientService;
    @PostMapping("/")
    public ResponseEntity<Cliente> create (@RequestBody Cliente cliente) {
        return new ResponseEntity<>(this.clientService.create(cliente), HttpStatus.OK);
    }

   //* @GetMapping("/")
  ///  public ResponseEntity<List<Cliente>> findAll() {
   ///     return new ResponseEntity<>(this.clientService.findAll(), HttpStatus.OK);////
   // }///

    @GetMapping("/")
    public ResponseEntity<Response> returnaredad(@RequestParam Long id) {
        return new ResponseEntity<>(this.clientService.ClienteEdad(id), HttpStatus.OK);
    }

}