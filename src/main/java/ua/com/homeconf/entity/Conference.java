package ua.com.homeconf.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Conference {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String venue;
	private int scale;
	
	@ManyToMany
	@JoinTable(name="conference_sponsor",
	joinColumns=@JoinColumn(name="id_conference"),
	inverseJoinColumns=@JoinColumn(name="id_sponsor"))
	private List<Sponsor>sponsors;
	
	@ManyToMany
	@JoinTable(name="conference_company",
	joinColumns=@JoinColumn(name="id_conference"),
	inverseJoinColumns=@JoinColumn(name="id_company"))
	private List<Company>companies;
	
	@ManyToMany
	@JoinTable(name="conference_delegate",
	joinColumns=@JoinColumn(name="id_conference"),
	inverseJoinColumns=@JoinColumn(name="id_delegate"))
	private List<Delegate>delegates;
	
	@ManyToMany
	@JoinTable(name="conference_employee",
	joinColumns=@JoinColumn(name="id_conference"),
	inverseJoinColumns=@JoinColumn(name="id_employee"))
	private List<Employees>employees;
	
}
