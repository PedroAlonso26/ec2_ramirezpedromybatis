/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ec2_ramirezpedromybatis.repository;

import com.example.ec2_ramirezpedromybatis.entity.Autor;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 *
 * @author usuario
 */
@Mapper
public interface AutorRepository {
    @Select("select * from autor")
    public List<Autor> findAll();
}
