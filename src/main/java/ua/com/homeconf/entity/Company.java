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
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String address;
	private int money;
	
	@ManyToMany
	@JoinTable(name="company_employee",
	joinColumns=@JoinColumn(name="id_company"),
	inverseJoinColumns=@JoinColumn(name="id_employee"))
	private List<Employees>employees;
	
	@ManyToMany
	@JoinTable(name = "company_conference",joinColumns = @JoinColumn(name = "id_company"),inverseJoinColumns = @JoinColumn(name = "id_conference"))
	private List<Conference>conferences;
	
	@ManyToMany
	@JoinTable(name="company_city",
	joinColumns=@JoinColumn(name="id_company"),
	inverseJoinColumns=@JoinColumn(name="id_city"))
	private List<LocationCity>cities;
	
	@OneToMany(mappedBy = "company")
	private List<Income>incomes;
	
	public Company(){
		
	}
	public Company(String name, String address, int money) {
		super();
		this.name = name;
		this.address = address;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public List<Employees> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employees> employees) {
		this.employees = employees;
	}
	public List<Conference> getConferences() {
		return conferences;
	}
	public void setConferences(List<Conference> conferences) {
		this.conferences = conferences;
	}
	public List<LocationCity> getCities() {
		return cities;
	}
	public void setCities(List<LocationCity> cities) {
		this.cities = cities;
	}
	public List<Income> getIncomes() {
		return incomes;
	}
	public void setIncomes(List<Income> incomes) {
		this.incomes = incomes;
	}
	@Override
	public String toString() {
		return "Company [name=" + name + ", address=" + address + ", money=" + money + "]";
	}

	
}
