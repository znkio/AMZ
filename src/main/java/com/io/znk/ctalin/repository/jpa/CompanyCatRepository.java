/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.io.znk.ctalin.repository.jpa;

import com.io.znk.ctalin.model.jpa.CompanyCat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CompanyCatRepository extends JpaRepository<CompanyCat, String> {

}
