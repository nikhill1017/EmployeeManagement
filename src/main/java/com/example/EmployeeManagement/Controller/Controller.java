package com.example.EmployeeManagement.Controller;

import com.example.EmployeeManagement.DAO.DAOImplementation;
import com.example.EmployeeManagement.Model.EmployeeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class Controller {
    @Autowired
    private DAOImplementation dao;

    @GetMapping("/allemployees")
    public ResponseEntity<List<EmployeeModel>> getall(){
        List<EmployeeModel> list=dao.list();
        return ResponseEntity.of(Optional.of(list));
    }
    @PostMapping("/insertemployee")
    public void insert(@RequestBody EmployeeModel model){
        dao.create(model);
    }
    @GetMapping("/searchemployee/{id}")
    public ResponseEntity<EmployeeModel> FindById(@PathVariable int id){
        Optional<EmployeeModel> model=dao.get(id);
        return ResponseEntity.of(model);
    }
    @PutMapping("/update/{id}")
    public void update(@RequestBody EmployeeModel model,@PathVariable int id){
        dao.update(model, id);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        dao.delete(id);
    }
}
