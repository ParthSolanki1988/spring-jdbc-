package org.simform.studentDao;

import org.simform.studentEntity.Student;

import java.util.List;

public interface StudentDao {
  public void insert(Student student);

  public int delete(int studentId);

  public int update(Student student);

  public Student fetchSingle(int studentId);

  public List<Student> fetchAll();
}
