package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.StudentDaoImpl;
import com.spring.jdbc.entities.Student;

/**
 * Author
 * Mayuresh Madhavi
 */
public class SpringJdbc 
{
    public static void main( String[] args )
    {
        System.out.println( "My program started" );
//     //spring jdbc > jdbcTemplate
//        ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
//        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate",JdbcTemplate.class);
//        
//        //insert query
//        String query = "insert into student(id,name,city) values(?,?,?)";
//        
//        //fire query
//        int result = jdbcTemplate.update(query,3,"Manish","Mumbai");
//        System.out.println("number of records inserted.." + result);
        
 //       ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml"); > commenting as using configuration class jdbc config
        ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
        StudentDaoImpl studentDaoImpl = context.getBean("StudentDaoImpl",StudentDaoImpl.class);
        ((AbstractApplicationContext) context).close();
        //insert
//        Student student = new Student();
//        student.setId(4);
//        student.setName("Rahul");
//        student.setCity("Mumbai");
//        int result = studentDaoImpl.insert(student);
//        System.out.println("Student added "+result);
        
        //update
//        Student student1 = new Student();
//        student1.setId(3);
//        student1.setName("harshal");
//        student1.setCity("navi mumbai");
//        int result1 = studentDaoImpl.update(student1);
//        System.out.println("Student change "+result1);
        
        //delete
//        int result2 = studentDaoImpl.delete(3);
//        System.out.println("Student change "+result2);
        
       // fetch single data
        Student student = studentDaoImpl.getStudent(1);
        System.out.println("fetch student is" +student);
        
        //fetch all data
        List<Student> students = studentDaoImpl.getAllStudents();
        for(Student s:students) {
        	System.out.println(s);
        }
    }
}
