package com.amgen.getResponse.utility;

import javax.annotation.Resource;
import javax.persistence.Query;
import java.util.*;
import org.hibernate.Session;
import org.junit.Test;

import com.amgen.getResponse.entity.userProfileManagement.User;


public class HibernateRepositoryTest {

//  @Autowired
//  private JdbcTemplate jdbcTemplate;
//
//  @Autowired
//  private HibernatePBEStringEncryptor hibernateStringEncryptor;
//
//  @Resource
//  @Qualifier("transactionalHibernateRepository")
//  private Repository repository;
//
//  @Before
//  public void cleanDatabase() {
//    jdbcTemplate.execute("delete from employee");
//  }
	
	  private Repository repository;
	  Session session;
	  
  @Test
  public void testSsnEncryption() {

    User user = new User();
    user.setUserName("emp1");
    user.setFirstName("Johnny McDoe");
    user.setFax(123-456-7890);

  
    Query q = (Query) session.createQuery("Select * from user");
    List listResult = ((org.hibernate.Query) q).list();
    //repository.store(user);
    System.out.println(listResult);
  
//    String encSsn = jdbcTemplate.queryForObject(
//        "select ssn from employee where identifier = '"
//            + employee.getIdentifier() + "'", String.class);
//
//    assertNotNull(encSsn);
//    assertFalse(employee.getSsn().equals(encSsn));
//    assertEquals(employee.getSsn(), hibernateStringEncryptor
//        .decrypt(encSsn));
//  }

//  @Test
//  public void testSsnDecryption() {
//
//    jdbcTemplate
//        .execute("insert into employee (identifier, name, ssn) values ('emp1', 'Johnny McDoe', '"
//            + hibernateStringEncryptor.encrypt("123-456-7890")
//            + "')");
//
//    Employee employee = (Employee) repository.retrieve(Employee.class, "emp1");
//
//    assertEquals("emp1", employee.getIdentifier());
//    assertEquals("Johnny McDoe", employee.getName());
//    assertEquals("123-456-7890", employee.getSsn());
  }
}