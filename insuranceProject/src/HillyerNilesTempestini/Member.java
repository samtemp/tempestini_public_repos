package HillyerNilesTempestini;

import java.io.*;

@SuppressWarnings("serial")
public class Member implements Serializable{
	private String firstName;
	private String lastName;
	private int age;
	private int height;
	private int weight;
	private int bpSyst;
	private int bpDias;	
	private char cancer; 
	private char diabeties;
	private char alzheimers;
	
	Member()
	{
		this.firstName = "";
		this.lastName = "";
		this.age = 0;
		this.weight = 0;
		this.height = 0;
		this.bpSyst = 0;
		this.bpDias = 0; 
		this.cancer = ' ';
		this.diabeties = ' ';
		this.alzheimers = ' ';
	}
	Member(String fn, String ln, int ag, int wt, int ht, int bps, int bpd, char cnc, char dia, char alz)
	{
		setFirstName(fn);
		setLastName(ln);
		setAge(ag);
		setWeight(wt);
		setHeight(ht);
		setBpSyst(bps);
		setBpDias(bpd);
		setCancer(cnc);
		setDiabeties(dia);
		setAlzheimers(alz);
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getBpSyst() {
		return bpSyst;
	}
	public void setBpSyst(int bpSyst) {
		this.bpSyst = bpSyst;
	}
	public int getBpDias() {
		return bpDias;
	}
	public void setBpDias(int bpDias) {
		this.bpDias = bpDias;
	}
	public char getCancer() {
		return cancer;
	}
	public void setCancer(char cancer) {
		this.cancer = cancer;
	}
	public char getDiabeties() {
		return diabeties;
	}
	public void setDiabeties(char diabeties) {
		this.diabeties = diabeties;
	}
	public char getAlzheimers() {
		return alzheimers;
	}
	public void setAlzheimers(char alzheimers) {
		this.alzheimers = alzheimers;
	}
	
	
	@Override 
	public String toString()
	{
		String rm = this.lastName + ", " + this.firstName
				+ "\nAge\t\t" + this.age 
				+ "\nHeight\t\t" + this.height
				+ "\nWeight\t\t" + this.weight
				+ "\nBP Syst\t\t" + this.bpSyst
				+ "\nBP Dias\t\t" + this.bpDias
				+ "\nCancer\t\t" + this.cancer
				+ "\nDiabeties\t" + this.diabeties
				+ "\nAlzheimers\t" + this.alzheimers;
		return rm;
	}
}
