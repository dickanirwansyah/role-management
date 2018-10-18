/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arms.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.arms.app.entity.Request;

/**
 *
 * @author bariskreatif
 */
public interface RequestRepository extends CrudRepository<Request, Long>{
    
}
