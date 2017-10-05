package model;

public class Etudiant {

	private String prenom;
	private String nom;
	private int age;
	private Formation formation;
	
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
	
	public Formation getFormation(){
		return formation;
	}
	
	public void setFormation(Formation formation){
		this.formation = formation;
	}
	
	@Override
	public String toString() {
		String var ="PRENOM = "+this.prenom+" NOM = "+this.nom+" AGE = "+this.age;
		return var;
	}
}
