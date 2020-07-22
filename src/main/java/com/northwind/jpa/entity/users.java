/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.northwind.jpa.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;

/**
 *
 * @author moham
 */

@Entity
@Table(name = "users")
public class users implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid")
    private Integer userid;
    
    @Column(name = "name")
    private String name;
    @Max(40)
            
    @Column(name = "title")
    private String title;
    
    @Column(name = "birthdate")
    private Date birthdate;
    
    @Column(name = "hiredate")
    private Date hiredate;
    
    @Column(name = "position")
    private String position;
    @Max(30)
    @Column(name = "email")
    private String email;
    @Max(30)
    @Column(name = "password")
    private String password;
    @Max(60)
    
    public users() {        
    }
  public users(Integer userid, String name, String title, Date birthdate, Date hiredate, String position, String email, String password) {
        this.userid = userid;
        this.name = name;
        this.title = title;
        this.birthdate = birthdate;
        this.hiredate = hiredate;
        this.position = position;
        this.email = email;
        this.password = password;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}