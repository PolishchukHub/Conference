package ua.com.homeconf.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Delegate {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String nameCompany;
	private String jobtitle;
	
	@ManyToMany
	@JoinTable(name="conference_delegate",
	joinColumns=@JoinColumn(name="id_delegate"),
	inverseJoinColumns=@JoinColumn(name="id_conference"))
	private List<Conference>conferences;
}
