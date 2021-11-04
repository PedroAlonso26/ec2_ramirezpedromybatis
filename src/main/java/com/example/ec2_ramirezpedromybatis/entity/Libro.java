/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ec2_ramirezpedromybatis.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author usuario
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Libro implements Serializable {
     private static final long serialVersionUID = 3754851399214200439L;
     private int idlibro;
     private String nombre;
     private int idautor;
     private int ideditorial;
}
