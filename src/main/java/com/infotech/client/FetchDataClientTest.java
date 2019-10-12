package com.infotech.client;

import org.hibernate.Session;

import com.infotech.entities.Employee;
import com.infotech.entities.Person;
import com.infotech.entities.Student;
import com.infotech.util.HibernateUtil;

/**
 * @author Pasha Sadi
 * Remember the golden rule: readable code is often faster code. 
 * Produce readable code first and only change it if it proves to be too slow.
 */
public class FetchDataClientTest {
	

	public static void main(String[] args) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()) 
		{
			//super class entity
			Person person = session.get(Person.class, 2);			
			if(person != null && !(person instanceof Student) && !(person instanceof Employee))
			{
				System.out.println("Data is person type");
				System.out.println(person);
			}else if(person instanceof Employee)
			{
				Employee employee = (Employee) person;
				System.out.println("Data is employee type");
				System.out.println(employee);
			}else if(person instanceof Student)
			{
				Student student = (Student) person;
				System.out.println("Data is student type");
				System.out.println(student);
				
			}else {
				System.out.println("Person Not Found In Database!!!");
			}				
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
/*
<property name="hibernate.hbm2ddl.auto">update</property>
Hibernate: 
    select
        person0_.id as id2_0_0_,
        person0_.gender as gender3_0_0_,
        person0_.name as name4_0_0_,
        person0_.bonus as bonus5_0_0_,
        person0_.dep_name as dep_name6_0_0_,
        person0_.date_of_joining as date_of_joining7_0_0_,
        person0_.email as email8_0_0_,
        person0_.salary as salary9_0_0_,
        person0_.fee as fee10_0_0_,
        person0_.school_name as school_name11_0_0_,
        person0_.section_name as section_name12_0_0_,
        person0_.record_type as record_type1_0_0_ 
    from
        person_table person0_ 
    where
        person0_.id=?
Data is employee type
Employee [salary=3500.29, doj=1922-02-22 00:00:00.0, depName=IT, bonus=123.456, email=pasha.sn@gmail.com, toString()=Person [id=2, name=Pasha Sadi, gender=Male]]

*/