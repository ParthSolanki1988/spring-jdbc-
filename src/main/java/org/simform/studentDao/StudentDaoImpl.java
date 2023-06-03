package org.simform.studentDao;

import org.simform.studentEntity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("studentdao")
public class StudentDaoImpl implements StudentDao{
  @Autowired
  private JdbcTemplate jdbcTemplate;

  public JdbcTemplate getJdbcTemplate() {
    return jdbcTemplate;
  }

  public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public void insert(Student student) {
    //insert Query
    String query = "Insert into student(id,name) values(?,?)";
    this.jdbcTemplate.update(query,student.getId(),student.getName());

  }

  @Override
  public int delete(int studentId) {
    //delete row
    String deleteQuery = "Delete from student where id=?";
    int deleteId = this.jdbcTemplate.update(deleteQuery,studentId);
    return deleteId;
  }

  @Override
  public int update(Student student) {
    String updateQuery = "Update student set name=? where id=?";
    int updatedRow = this.jdbcTemplate.update(updateQuery,student.getName(),student.getId());
    return updatedRow;
  }

  @Override
  public Student fetchSingle(int studentId) {
    String fetch = "select * from student where id=?";
    RowMapper<Student> rowMapper = new RowMapperImpl();
    Student student = this.jdbcTemplate.queryForObject(fetch,rowMapper,studentId);
    return student;
  }

  @Override
  public List<Student> fetchAll() {
    String fetchAllData = "select * from student";
    List<Student> studentList = this.jdbcTemplate.query(fetchAllData,new RowMapperImpl());
    return studentList;
  }
}
