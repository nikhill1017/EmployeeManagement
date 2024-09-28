package com.example.EmployeeManagement.DAO;

import com.example.EmployeeManagement.Model.EmployeeModel;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface DAO<T> {
    List<T> list();
    void create(T t);
    Optional<T> get(int id);
    void update(T t,int id);
    void delete(int id);
}
