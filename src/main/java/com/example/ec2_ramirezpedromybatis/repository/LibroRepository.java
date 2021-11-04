/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ec2_ramirezpedromybatis.repository;

import com.example.ec2_ramirezpedromybatis.entity.Libro;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 *
 * @author usuario
 */
@Mapper
public interface LibroRepository {
   @Select("select l.idlibro, l.nombre,concat(a.apellido) as autor, e.nombree editorial from libro as l\n" +
"inner join autor as a on l.idautor = a.idautor\n" +
"inner join editorial as e on l.ideditorial=e.ideditorial")
    public List<Map<String,Object>> findAll();
    
    @Select("select * from libro where idlibro=#{id}")
    public Libro readLibro(int id);

    @Delete("DELETE FROM libro WHERE idlibro = #{id}")
    public int deleteById(int id);
    
    @Insert("INSERT INTO libro(nombre, idautor,ideditorial) VALUES (#{nombre}, #{idautor}, #{ideditorial})")
    public int insert(Libro libro);
    //UPDATE `bdejemplo`.`producto` SET `nombre` = 'www', `precio` = '5', `idcategoria` = '2' WHERE (`idproducto` = '19');
    @Update("Update libro set nombre=#{nombre}, idautor=#{idautor}, ideditorial=#{ideditorial} where idlibro=#{idlibro}")
    public int update(Libro libro);
} 

