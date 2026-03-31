package com.employemanage.dao;

import com.employemanage.model.Employe;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EmployeDao  {

    private JdbcTemplate jdbcTemplate;

    // Setter for JdbcTemplate (Spring will inject it)
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int saveEmploye(Employe e){
        String query = "INSERT INTO EMPLOYE(empId, empName, role, salary) VALUES (?,?,?,?)";
        return jdbcTemplate.update(query, e.getEmpName(), e.getEmpRole(), e.getEmpSalary());
    }

    public int updateEmploye(Employe e){
        String query = "UPDATE employe SET empName=?, role=?, salary=? WHERE empId=?";
        return jdbcTemplate.update(query, e.getEmpName(), e.getEmpRole(), e.getEmpSalary(), e.getEmpId());
    }

    public int deleteEmploye(int id) {
        String query = "DELETE FROM employe WHERE empId=?";
        return jdbcTemplate.update(query, id);
    }

    public List<Employe> getAllEmploye(){
        String query = "SELECT * FROM employe";
        return jdbcTemplate.query(query, new RowMapper<Employe>() {
            @Override
            public Employe mapRow(ResultSet rs, int rowNum) throws SQLException {
                Employe e = new Employe();
                e.setEmpId(rs.getInt("empId"));
                e.setEmpName(rs.getString("empName"));
                e.setEmpRole(rs.getString("role"));
                e.setEmpSalary(rs.getInt("salary"));
                return e;
            }
        });
    }

    public Employe getOneEmploye(int id) {
        String query = "SELECT * FROM employee WHERE empId = ?";

        return jdbcTemplate.queryForObject(
                query, new Object[]{id},
                (rs, rowNum) -> {
                    Employe emp = new Employe();
                    emp.setEmpId(rs.getInt("empId"));
                    emp.setEmpName(rs.getString("empName"));
                    emp.setEmpSalary(rs.getInt("empSalary"));
                    return emp;
                }
        );
    }
}
