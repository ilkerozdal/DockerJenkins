package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Etudiant;
import model.Formation;

public class Fenetre extends JFrame{

	private JLabel labPrenom;
	private JLabel labNom;
	private JLabel labAge;
	
	private JTextField champPrenom;
	private JTextField champNom;
	private JTextField champAge;
	
	private JButton btnValider;
	private JButton btnAnnuler;
	
	private JLabel labAffichage;
	private JLabel labFormation;
	private JComboBox jcb1;
	
	public Fenetre(){
		this.setTitle("Informations Etudiant");
		this.setSize(500, 350);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel pan1 = new JPanel();
		pan1.setLayout(new BorderLayout());
		labPrenom = new JLabel("Donnez votre Prnom : ");
		champPrenom = new JTextField(30);
		pan1.add(labPrenom,BorderLayout.WEST);
		pan1.add(champPrenom,BorderLayout.EAST);
		
		JPanel pan2 = new JPanel();
		pan2.setLayout(new BorderLayout());
		labNom = new JLabel("Donnez votre Nom : ");
		champNom = new JTextField(20);
		pan2.add(labNom,BorderLayout.WEST);
		pan2.add(champNom,BorderLayout.EAST);
		
		JPanel pan3 = new JPanel();
		pan3.setLayout(new BorderLayout());
		labAge = new JLabel("Entrez votre ge : ");
		champAge = new JTextField(10);
		pan3.add(labAge,BorderLayout.WEST);
		pan3.add(champAge,BorderLayout.EAST);
		
		JPanel pan4 = new JPanel();
		pan4.setLayout(new BorderLayout());
		labFormation = new JLabel("Choisissez votre Formation : ");
		jcb1 = new JComboBox();
		jcb1.addItem("");
		for(Formation form : Formation.values()){
			jcb1.addItem(form);
		}
		pan4.add(labFormation,BorderLayout.WEST);
		pan4.add(jcb1, BorderLayout.EAST);
		
		JPanel top = new JPanel();
		top.setLayout(new GridLayout(4,1));
		top.add(pan1);
		top.add(pan2);
		top.add(pan3);
		top.add(pan4);
		
		JPanel pan5 = new JPanel();
		btnValider = new JButton("VALIDER");
		btnAnnuler = new JButton("ANNULER");
		btnValider.addActionListener(new Validation());
		btnAnnuler.addActionListener(new Annulation());
		pan5.add(btnValider);
		pan5.add(btnAnnuler);
		
		JPanel pan6 = new JPanel();
		pan6.setBorder(BorderFactory.createTitledBorder("AFFICHAGE"));
		pan6.setPreferredSize(new Dimension(200,100));
		labAffichage = new JLabel();
		labAffichage.setForeground(Color.blue);
		pan6.add(labAffichage);

		JPanel mypanel = new JPanel();
		mypanel.setLayout(new BorderLayout());
		mypanel.add(top,BorderLayout.NORTH);
		mypanel.add(pan5,BorderLayout.CENTER);
		mypanel.add(pan6,BorderLayout.SOUTH);
		
		this.setContentPane(mypanel);
		this.setVisible(true);
	}
	
	//classe interne g�rant le fait de cliquer sur le bouton VALIDER
	class Validation implements ActionListener {
		public void actionPerformed(ActionEvent e){
			if(!champPrenom.getText().equals("") && 
					!champNom.getText().equals("") && 
					!champAge.getText().equals(""))
			{
				String prenomSaisi = champPrenom.getText();
				String nomSaisi = champNom.getText();
				int ageSaisi = Integer.valueOf(champAge.getText());
				Etudiant etud = new Etudiant(prenomSaisi,nomSaisi,ageSaisi);
				labAffichage.setText(etud.toString());
			}else{
				JOptionPane jop1=new JOptionPane();
				jop1.showMessageDialog(null, "Vous devez remplir tous les champs.","ERREUR",JOptionPane.WARNING_MESSAGE);

			}
			
		}
	}
	
	//classe interne g�rant le fait de cliquer sur le bouton ANNULER
	class Annulation implements ActionListener {
		public void actionPerformed(ActionEvent e){
			champPrenom.setText("");
			champNom.setText("");
			champAge.setText("");
			labAffichage.setText("");
		}
	}
}
