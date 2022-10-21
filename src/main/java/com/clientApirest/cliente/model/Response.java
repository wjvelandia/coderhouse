package com.clientApirest.cliente.model;


import lombok.Builder;
import lombok.Data;

import javax.persistence.Id;

@Data
@Builder
public class Response {
    public Long id;
    public Integer age;
    public String nombre;
    public String apellido;
}

