/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.northwind.jpa.controller;
import com.northwind.jpa.entity.users;
import com.northwind.jpa.entity.response.ApiResponse;
import com.northwind.jpa.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author moham
 */
@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserService service;
    
    @GetMapping("")
    public ApiResponse getAll(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int pageSize) {
        Page<users> result = service.getByPage(page - 1, pageSize);
        return ApiResponse.ok(result);
    }
    
    @GetMapping("/{id}")
    public ApiResponse getByID(@PathVariable("id") String id) {
        users use = service.getById(id);
        if (use == null) {
            return ApiResponse.notFound();
        }
        return ApiResponse.ok(use);
    }
    
    @PostMapping("")
    public ApiResponse create(@RequestBody users use) {
        if (service.getById(use.getUserid()) != null) {
            return ApiResponse.conflict("Data conflict!");
        }
        service.create(use);
        return ApiResponse.created("Create data success!");
    }
    
    @PutMapping("")
    public ApiResponse update(@RequestBody users use) {
        if (service.getById(use.getUserid()) == null) {
            return ApiResponse.notFound("Data not found");
        }
        service.update(use);
        return ApiResponse.ok("Update data success!");
    }
    
    @DeleteMapping("/{id}")
    public ApiResponse delete(@PathVariable("id") String id) {
        if (service.getById(id) == null) {
            return ApiResponse.notFound("Data not found");
        }
        service.delete(id);
        return ApiResponse.ok("Delete data success!");
    }
    
}
