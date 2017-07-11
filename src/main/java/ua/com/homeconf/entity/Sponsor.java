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

import org.w3c.dom.stylesheets.LinkStyle;

@Entity
public class Sponsor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String company;
	private int money;
	
	@ManyToMany
	@JoinTable(name="conference_sponsor",
	joinColumns=@JoinColumn(name="id_sponsor"),
	inverseJoinColumns=@JoinColumn(name="id_conference"))
	private List<Conference>conferences;
	
}
