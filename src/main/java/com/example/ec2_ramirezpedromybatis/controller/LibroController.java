/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ec2_ramirezpedromybatis.controller;

import com.example.ec2_ramirezpedromybatis.entity.Autor;
import com.example.ec2_ramirezpedromybatis.entity.Libro;
import com.example.ec2_ramirezpedromybatis.repository.AutorRepository;
import com.example.ec2_ramirezpedromybatis.repository.EditorialRepository;
import com.example.ec2_ramirezpedromybatis.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author usuario
 */
@Controller
public class LibroController {
    
    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private EditorialRepository editorialRepository;

    

    @RequestMapping("/libs")
    public String libs(Model model) {
        model.addAttribute("libs", libroRepository.findAll());
        return "libs";
    }

    @RequestMapping("/create")
    public String createauto(Model model) {
        model.addAttribute("autos", autorRepository.findAll());
        model.addAttribute("edits", editorialRepository.findAll());
        return "addLibro";
    }

    @RequestMapping("/libroadd")
    public String guardarlibro(@RequestParam String nombre, @RequestParam int idautor, @RequestParam int ideditorial, Model model) {
        Libro lib = new Libro();
        lib.setNombre(nombre);
        lib.setIdautor(idautor);
        lib.setIdeditorial(ideditorial);
        libroRepository.insert(lib);
        return "redirect:/libs";
    }

    @RequestMapping("/dellibro/{id}")
    public String deletelibro(@PathVariable(value = "id") int id) {

        libroRepository.deleteById(id);
        return "redirect:/libs";
    }

    @RequestMapping("/editlibro/{id}")
    public String edit(@PathVariable(value = "id") int id, Model model) {
        model.addAttribute("lib", libroRepository.readLibro(id));
        model.addAttribute("autos", autorRepository.findAll());
        model.addAttribute("edits", editorialRepository.findAll());

        return "editlibro";
    }

    @RequestMapping("/update")
    public String update(@RequestParam int id, @RequestParam String nombre,
            @RequestParam int idautor, @RequestParam int ideditorial) {
        System.out.println(id + "/" + nombre + "/" + idautor + "/" + ideditorial);
        Libro lib = libroRepository.readLibro(id);
        lib.setNombre(nombre);
        lib.setIdautor(idautor);
        lib.setIdeditorial(ideditorial);
        libroRepository.update(lib);
        return "redirect:/libs";
    }
}
