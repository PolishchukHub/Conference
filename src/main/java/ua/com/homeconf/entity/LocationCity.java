package ua.com.homeconf.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class LocationCity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String city;
	
	@ManyToOne
	private LocationCountry country;
	@ManyToMany
	@JoinTable(name="company_city",
	joinColumns=@JoinColumn(name="id_city"),
	inverseJoinColumns=@JoinColumn(name="id_company"))
	private List<Company>companies;
}
