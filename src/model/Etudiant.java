package model;

public class Etudiant {

	private String prenom;
	private String nom;
	private int age;
	
	public Etudiant(String prenom,String nom,int age){
		this.prenom = prenom;
		this.nom = nom;
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getNom() {
		return nom;
	}
	
	@Override
	public String toString() {
		String var = "My name is "+this.prenom+" "+this.nom+" and i'm "+this.age+" years old";
		return var;
	}
}
