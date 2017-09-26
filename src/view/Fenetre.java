package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Etudiant;

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
	
	public Fenetre(){
		this.setTitle("Informations Etudiant");
		this.setSize(500, 350);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel pan1 = new JPanel();
		pan1.setLayout(new BorderLayout());
		labPrenom = new JLabel("Donnez votre Prénom : ");
		labPrenom.setForeground(Color.red);
		champPrenom = new JTextField(30);
		pan1.add(labPrenom,BorderLayout.WEST);
		pan1.add(champPrenom,BorderLayout.EAST);
		
		JPanel pan2 = new JPanel();
		pan2.setLayout(new BorderLayout());
		labNom = new JLabel("Donnez votre Nom : ");
		labNom.setForeground(Color.red);
		champNom = new JTextField(20);
		pan2.add(labNom,BorderLayout.WEST);
		pan2.add(champNom,BorderLayout.EAST);
		
		JPanel pan3 = new JPanel();
		pan3.setLayout(new BorderLayout());
		labAge = new JLabel("Entrez votre âge : ");
		labAge.setForeground(Color.red);
		champAge = new JTextField(10);
		pan3.add(labAge,BorderLayout.WEST);
		pan3.add(champAge,BorderLayout.EAST);
		
		JPanel top = new JPanel();
		top.setLayout(new BorderLayout());
		top.add(pan1,BorderLayout.NORTH);
		top.add(pan2,BorderLayout.CENTER);
		top.add(pan3,BorderLayout.SOUTH);
		
		JPanel pan4 = new JPanel();
		btnValider = new JButton("VALIDER");
		btnAnnuler = new JButton("ANNULER");
		btnValider.addActionListener(new Validation());
		btnAnnuler.addActionListener(new Annulation());
		pan4.add(btnValider);
		pan4.add(btnAnnuler);
		
		JPanel pan5 = new JPanel();
		pan5.setBorder(BorderFactory.createTitledBorder("AFFICHAGE"));
		pan5.setPreferredSize(new Dimension(200,100));
		labAffichage = new JLabel();
		labAffichage.setForeground(Color.blue);
		pan5.add(labAffichage);

		JPanel mypanel = new JPanel();
		mypanel.setLayout(new BorderLayout());
		mypanel.add(top,BorderLayout.NORTH);
		mypanel.add(pan4,BorderLayout.CENTER);
		mypanel.add(pan5,BorderLayout.SOUTH);
		
		this.setContentPane(mypanel);
		this.setVisible(true);
	}
	
	//classe interne gérant le fait de cliquer sur le bouton VALIDER
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
	
	//classe interne gérant le fait de cliquer sur le bouton ANNULER
	class Annulation implements ActionListener {
		public void actionPerformed(ActionEvent e){
			champPrenom.setText("");
			champNom.setText("");
			champAge.setText("");
			labAffichage.setText("");
		}
	}
}
