package org.simform;

import org.simform.studentDao.StudentDao;
import org.simform.studentEntity.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


public class Main {
  public static void main(String[] args) {
    /**
     * used for xml file
     */
//    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("BeanXML file/bean.xml");

    /**
     * used for Configuration class
     */
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(StudentConfig.class);
    StudentDao studentDao = applicationContext.getBean("studentdao" , StudentDao.class);
    /**
     * INSERT operation
     */
//    Student student = new Student();
//    student.setId(105);
//    student.setName("Yash Shah");
//    studentDao.insert(student);
//    System.out.println("Student Added Successfully.");

    /**
     * DELETE operation
     */

//    int deleteId = studentDao.delete(102);
//    System.out.println("Delete Id from DataBase.");

    /**
     * UPDATE operation
     */

//    Student student = new Student();
//    student.setId(102);
//    student.setName("Parth Solanki");
//    int update = studentDao.update(student); //update name "Parth Solanki" from "Mihir Parmar" where id=102
//    System.out.println("Updated Row : " + update);


    /**
     * Select From Database
     * Single Data Fetch From Database
     */

//    Student fetchStudent = studentDao.fetchSingle(102);
//    System.out.println("Fetch Student : " + fetchStudent);


    /**
     * Fetch Data From Database
     * Multiple Data Fetch From Database
     */

    List<Student> studentList = studentDao.fetchAll();
    for (Student studentData:
         studentList) {
      System.out.println(studentData);
    }

  }
}