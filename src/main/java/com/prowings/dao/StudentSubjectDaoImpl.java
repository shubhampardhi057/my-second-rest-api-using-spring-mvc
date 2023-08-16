package com.prowings.dao;

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

}
