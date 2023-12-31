package com.prowings.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.prowings.entity.Student;
import com.prowings.entity.Subjects;

@Repository
public class StudentSubjectDaoImpl implements StudentSubjectDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean saveStudent(Student std) {
		boolean result = false;

		try {
			Session session = sessionFactory.openSession();
			Transaction txn = session.beginTransaction();

			session.save(std);

			txn.commit();
			session.close();
			result = true;
		} catch (Exception e) {

			System.out.println("Error While Saving !!!" + e.getMessage());
		}
		return result;

	}

	@Override
	public List<Student> getStudents() {

		List<Student> listStd = null;

		try {
			Session session = sessionFactory.openSession();
			Transaction txn = session.beginTransaction();

			Query<Student> query = session.createQuery("from Student");
//			Query<Student> query = session.createQuery("from Student s order by s.name");
//			Query<Student> query = session.createQuery("from Student s order by s.name desc");
//			Query<Student> query = session.createQuery("from Student s order by s.name asc");
			listStd = query.getResultList();

			txn.commit();
			session.close();

		} catch (HibernateException e) {
			System.out.println("Error while getting !!" + e.getMessage());

		}
		return listStd;
	}

	@Override
	public Student getStudent(int id) {

		Student std = null;
		try {
			Session session = sessionFactory.openSession();
			Transaction txn = session.beginTransaction();

			std = session.get(Student.class, id);
			txn.commit();
			session.close();

		} catch (HibernateException e) {
			System.out.println("Error while getting !!" + e.getMessage());

		}

		return std;

	}

	@Override
	public Subjects getStudentSubject(int id) {

		Subjects sub = null;
		try {
			Session session = sessionFactory.openSession();
			Transaction txn = session.beginTransaction();

			sub = session.get(Subjects.class, id);
			txn.commit();
			session.close();

		} catch (HibernateException e) {
			System.out.println("Error while getting !!" + e.getMessage());

		}

		return sub;

	}

	@Override
	public List<Subjects> getSubjects() {
		List<Subjects> listSub = null;

		try {
			Session session = sessionFactory.openSession();
			Transaction txn = session.beginTransaction();

			Query<Subjects> query = session.createQuery("from Subjects");
			listSub = query.getResultList();

			txn.commit();
			session.close();

		} catch (HibernateException e) {
			System.out.println("Error while getting !!" + e.getMessage());

		}
		return listSub;

	}

	@Override
	public List<Subjects> getStudentSubjectByID(int id) {
		
		Student std = null;
		List<Subjects> subLList = null;
		
		try {
			Session session = sessionFactory.openSession();
			Transaction txn = session.beginTransaction();

			std = session.get(Student.class, id);
			
			txn.commit();
			session.close();

		} catch (HibernateException e) {
			System.out.println("Error while getting !!" + e.getMessage());

		}
		
		return std.getSubjects();
	}

	@Override
	public List<Student> getStudentsPagination(Integer firstResult, Integer maxResult) {
		
		List<Student> students = new ArrayList<>();
		int paginatedCount =0;
		
		Session session = sessionFactory.openSession();
		try {
			Query query = session.createQuery("From Student");
			query.setFirstResult(firstResult);
			query.setMaxResults(maxResult);
			students = query.list();
			
			if(students != null)
				paginatedCount = students.size();
				System.out.println("Total Result : "+paginatedCount);
				for(Student std : students) {
					System.out.println("Retrieved Students using Query :"+std);
				}
		} 
		catch (HibernateException e)
		{
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return students;
	}

		
		@Override
		public Student updateStudent(Student std) {
			
			Session session = sessionFactory.openSession();
			Transaction tx = null;
			Student retrievedStd = null;
			try {

				tx = session.beginTransaction();
				//get existing std
				retrievedStd =  session.get(Student.class, std.getId());
				
				if(retrievedStd != null)
				{
					System.out.println("found existing student.. Updating it!!");
					retrievedStd.setRoll(std.getRoll());
					retrievedStd.setName(std.getName());
//					retrievedStd.setSubjects(std.getSubjects());
					session.update(retrievedStd);
					System.out.println("Updated successfully!!");
				}
				else
				{
					System.out.println("Since student was not present - creating it!!");
					session.save(std);
				}
				tx.commit();

			} catch (HibernateException ex) {
				System.out.println("Unable to update student : "+ ex.getMessage());
			}

			return retrievedStd;
		
	}
		@Override
		public boolean deleteStudent(int id) {
			
			Session session = sessionFactory.openSession();
			Transaction tx = null;
			Student retrievedStd = null;
			boolean res = false;
			try {

				tx = session.beginTransaction();
				retrievedStd =  session.get(Student.class, id);
				
				if(retrievedStd != null)
				{
					session.delete(retrievedStd);
					res = true;
				}
				tx.commit();

			} catch (HibernateException ex) {
				System.out.println("Unable to delete student : "+ ex.getMessage());
			}

			return res;
		}

}
