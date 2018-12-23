package com.conpany.hibernate.day03.extend.test;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import com.conpany.hibernate.day03.extend.domain.Book;
import com.conpany.hibernate.day03.extend.domain.Cloth;
import com.conpany.hibernate.day03.extend.domain.Product;
import com.conpany.hibernate.util.HibernateUtil;

public class OneTableTest {
	@Before
	public void testSave() throws Exception {
		Product p = new Product();
		p.setName("p");
		
		Book b = new Book();
		b.setName("b");
		b.setIsbn("isbn");
		b.setAuthor("author");
		
		Cloth c = new Cloth();
		c.setName("c");
		c.setColor("color");
		
		Session session = HibernateUtil.getInstance().openSession();
		session.beginTransaction();
		
		session.save(p);
		session.save(b);
		session.save(c);
		
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	public void testGet() throws Exception {
		Session session = HibernateUtil.getInstance().openSession();
		session.beginTransaction();
		
		Cloth cloth = (Cloth) session.get(Cloth.class, 3L);
		System.out.println(cloth);
		
		session.getTransaction().commit();
		session.close();
	}

	@Test
	public void testGet2() throws Exception {
		Session session = HibernateUtil.getInstance().openSession();
		session.beginTransaction();
		
		Book book= (Book) session.get(Product.class, 2L);
		System.out.println(book);
		
		session.getTransaction().commit();
		session.close();
	}
}
