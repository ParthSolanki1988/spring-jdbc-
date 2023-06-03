package org.simform;

import org.simform.studentDao.StudentDao;
import org.simform.studentDao.StudentDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = {"org.simform.studentDao"}) //used for scan @component annotation which in this package
public class StudentConfig {

  /**
   * It's look like bean.xml
   * When we create StudentConfig class , we don't need to create xml file
   */

  @Bean("ds")
  public DataSource getDataSource(){
    DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
    driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
    driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/mydatabase");
    driverManagerDataSource.setUsername("root");
    driverManagerDataSource.setPassword("Parth@1988");
    return driverManagerDataSource;
  }

  @Bean("jdbcTempt")
  public JdbcTemplate jdbcTemplate(){
    JdbcTemplate jdbcTemplate = new JdbcTemplate();
    jdbcTemplate.setDataSource(getDataSource());
    return jdbcTemplate;
  }

  /**
   * When We write @Component on StudentDaoImpl class
   * we do't need to write Bean in config class(here)
   */
//  @Bean("studentdao")
//  public StudentDao studentDao(){
//    StudentDaoImpl studentDao = new StudentDaoImpl();
//    studentDao.setJdbcTemplate(jdbcTemplate());
//    return studentDao;
//  }

}
