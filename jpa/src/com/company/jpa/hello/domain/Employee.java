package com.company.jpa.hello.domain;

import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * Entity标签代表这是一个JPA要管理的类（实体类） Entity标签的name属性代表类的简写名称，如果不写，默认为类名 Table标签代表对应的表名
 * 
 * @author yonghui
 *
 */
@Entity
@Table(name = "employee")
@Cacheable//需要二级缓存
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE,region="Hibernate.EMPLOYEE")
public class Employee {

	/**
	 * 表名id字段时Employee对象的OID-->
	 * <id name="id" access="field"> 注意：默认情况下，id标签打在什么地方，其他的属性标签就打在什么地方
	 * GeneratedValue代表字段的值生成策略，一般情况需要配置一个strategy（生成策略） GenerationType.AUTO:-->
	 * <generator class="native"> GenerationType.IDENTITY:-->
	 * <generator class="identity"> GenerationType.TABLE:-->
	 * <generator class="TableGenerator">
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	/**
	 * JPA里面，默认情况下，所有属性都是需要持久化的； 不需要保存的告诉JPA即可 使用column表情-->property.column
	 */
	@Column(name = "username")
	private String name;
	private Integer age;
	/**
	 * Temporal这个表情专门用来处理日期； DATE-->type="date" TIME-->type="time"
	 * timestamp-->timestamp/不写（datetime）
	 */
	@Temporal(TemporalType.DATE)
	private Date hiredate;

	@Version
	private Integer version;

	public Employee() {
		super();
	}

	public Employee(String name, Integer age, Date hiredate) {
		super();
		this.name = name;
		this.age = age;
		this.hiredate = hiredate;
	}


	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	// 表名id字段时Employee对象的OID--> <id name="id">
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", hiredate=" + hiredate + "]";
	}

}
