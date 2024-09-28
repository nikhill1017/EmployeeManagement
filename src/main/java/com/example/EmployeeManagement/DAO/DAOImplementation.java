package com.example.EmployeeManagement.DAO;

import com.example.EmployeeManagement.Model.EmployeeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Component
public class DAOImplementation implements DAO<EmployeeModel>{

    @Autowired
    JdbcTemplate jdbcTemplate;

    RowMapper<EmployeeModel> rowMapper=(rs,rowNum) ->{
        EmployeeModel model=new EmployeeModel();
        model.setEmployee_id(rs.getInt("employee_id"));
        model.setEmployee_name(rs.getString("employee_name"));
        model.setEmployee_email(rs.getString("employee_email"));
        model.setSalary(rs.getInt("employee_salary"));
        return model;
    };

    @Override
    public List<EmployeeModel> list() {
        String SQL="Select * from employee";
        return jdbcTemplate.query(SQL,rowMapper);
    }

    @Override
    public void create(EmployeeModel model) {
        String sql="insert into employee(employee_id,employee_name,employee_email,employee_salary) values(?,?,?,?)";
        int insert = jdbcTemplate.update(sql,model.getEmployee_id(),model.getEmployee_name(),model.getEmployee_email(),model.getSalary());
        if(insert==1){
            System.out.println("Inserted Succesfully");
        }
    }

    @Override
    public Optional<EmployeeModel> get(int id) {
        String sql="select * from employee where employee_id=?";
        EmployeeModel model=null;
        try{
            model=jdbcTemplate.queryForObject(sql,new Object[]{id},rowMapper);
        }catch (DataAccessException ex){
            System.out.println("employee does not exist "+ex);
        }
        return Optional.ofNullable(model);
    }

    @Override
    public void update(EmployeeModel model, int id) {
        String sql="update employee set employee_name=?,employee_email=?,employee_salary=? where employee_id=?";
        int update=jdbcTemplate.update(sql,model.getEmployee_name(),model.getEmployee_email(),model.getSalary(),id);
        if(update==1){
            System.out.println("Updated");
        }
    }

    @Override
    public void delete(int id) {
        String sql="delete from employee where employee_id=?";
        jdbcTemplate.update(sql,id);
    }
}
