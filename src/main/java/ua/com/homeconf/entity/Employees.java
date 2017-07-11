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
public class Employees {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String jobTitle;
	private int money;
	
	@ManyToMany
	@JoinTable(name="conference_employee",
	joinColumns=@JoinColumn(name="id_employee"),
	inverseJoinColumns=@JoinColumn(name="id_conference"))
	private List<Conference>conferences;
	
	@ManyToMany
	@JoinTable(name="company_employee",
	joinColumns=@JoinColumn(name="id_employee"),
	inverseJoinColumns=@JoinColumn(name="id_company"))
	
	
	private List<Company>companies;
	
	public Employees() {
		
	}
	
	public Employees(String name, String jobTitle, int money) {
		super();
		this.name = name;
		this.jobTitle = jobTitle;
		this.money = money;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public List<Conference> getConferences() {
		return conferences;
	}
	public void setConferences(List<Conference> conferences) {
		this.conferences = conferences;
	}
	public List<Company> getCompanies() {
		return companies;
	}
	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}
	@Override
	public String toString() {
		return "Employees [id=" + id + ", name=" + name + ", jobTitle=" + jobTitle + ", money=" + money
				+ ", conferences=" + conferences + ", companies=" + companies + "]";
	}
	
	
}
