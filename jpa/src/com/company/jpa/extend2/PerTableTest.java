package com.company.jpa.extend2;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Test;

import com.company.jpa.hello.util.JPAUtil;

public class PerTableTest {
	@Test
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
		
		EntityManager em = JPAUtil.getInstance().entityManager();
		em.getTransaction().begin();
		
		em.persist(p);
		em.persist(b);
		em.persist(c);
		
		em.getTransaction().commit();
		em.close();
	}
	
	@Test
	public void testGet() throws Exception {
		EntityManager em = JPAUtil.getInstance().entityManager();
		em.getTransaction().begin();
		
		Cloth cloth = em.find(Cloth.class, 3L);
		System.out.println(cloth);
		
		em.getTransaction().commit();
		em.close();
	}

	@Test
	public void testGet2() throws Exception {
		EntityManager em = JPAUtil.getInstance().entityManager();
		em.getTransaction().begin();
		
		Book book= (Book) em.find(Product.class, 2L);
		System.out.println(book);
		
		em.getTransaction().commit();
		em.close();
	}
}
