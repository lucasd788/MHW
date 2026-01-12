package br.edu.unifei.ecot13.lucasdias.mhw.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.edu.unifei.ecot13.lucasdias.mhw.Armor;
import br.edu.unifei.ecot13.lucasdias.mhw.Charm;
import br.edu.unifei.ecot13.lucasdias.mhw.Equipment;
import br.edu.unifei.ecot13.lucasdias.mhw.MeleeWpn;
import br.edu.unifei.ecot13.lucasdias.mhw.Pcharacter;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;

public class PcharacterFormCreate extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("mhwbdPU");
	EntityManager em = emf.createEntityManager();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PcharacterFormCreate frame = new PcharacterFormCreate();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PcharacterFormCreate() {
		setType(Type.UTILITY);
		setTitle("Create Character");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 260, 112);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Character name:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 10, 111, 20);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(120, 10, 114, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"BEGINNER", "INTERMEDIATE", "ADVANCED"}));
		comboBox.setBounds(10, 40, 130, 23);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Confirm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				em.getTransaction().begin();
				Pcharacter c = new Pcharacter();
				c.setName(textField.getText());
			    c.setHealth(100);
			    String selectedLevel = (String) comboBox.getSelectedItem();
		        if (selectedLevel.equals("BEGINNER")) {
		        	c.setLevel(5);
		        	MeleeWpn mw = new MeleeWpn();
		        	mw.setDamage(10);
			        mw.setSharpness(1);
			        mw.setAffinity(0);
			        mw.setElement("NONE");
			        mw.setRarity(1);
			        mw.setDamageType("CUT DAMAGE");
			        c.setWeapon(mw);
	
			        Armor helm = new Armor();
			        helm.setNameType("HELM");
			        helm.setDefense(5);
			        helm.setRarity(1);
			        helm.setUpgradeLv(1);
			          
			        Armor chest = new Armor();
			        chest.setNameType("CHEST");
			        chest.setDefense(10);
			        chest.setRarity(1);
			        chest.setUpgradeLv(1);
	
			        Armor arms = new Armor();
			        arms.setNameType("ARMS");
			        arms.setDefense(10);
			        arms.setRarity(1);
			        arms.setUpgradeLv(1);
	
			        Armor waist = new Armor();
					waist.setNameType("WAIST");
			        waist.setDefense(10);
			        waist.setRarity(1);
			        waist.setUpgradeLv(1);
	
			        Armor legs = new Armor();
					legs.setNameType("LEGS");
			        legs.setDefense(10);
			        legs.setRarity(1);
			        legs.setUpgradeLv(1);
	
			        Charm charm = new Charm();
					charm.setNameType("CHARM");
			        charm.setSkills("NONE");
			        charm.setRarity(1);
			        charm.setUpgradeLv(1);
	
			        List<Equipment> equipments = new ArrayList<>(6);
			        
			        equipments.add(helm);
			        equipments.add(chest);
			        equipments.add(arms);
			        equipments.add(waist);
			        equipments.add(legs);
			        equipments.add(charm);
			        c.setEquipments(equipments);
			        em.persist(mw);
			        em.persist(helm);
			        em.persist(chest);
			        em.persist(arms);
			        em.persist(waist);
			        em.persist(legs);
			        em.persist(charm);
			        em.persist(c);
		           
		        } else if (selectedLevel.equals("INTERMEDIATE")) {
		        	c.setLevel(100);
		        	MeleeWpn mw = new MeleeWpn();
		            mw.setDamage(50);
		            mw.setSharpness(5);
		            mw.setAffinity(0);
		            mw.setElement("NONE");
		            mw.setRarity(3);
		            mw.setDamageType("CUT DAMAGE");
		            c.setWeapon(mw);

		            Armor helm = new Armor();
		            helm.setNameType("HELM");
		            helm.setDefense(20);
		            helm.setRarity(3);
		            helm.setUpgradeLv(1);
		             
		            Armor chest = new Armor();
			        chest.setNameType("CHEST");
		            chest.setDefense(40);
		            chest.setRarity(3);
		            chest.setUpgradeLv(1);
		            
		            Armor arms = new Armor();
			        arms.setNameType("ARMS");
		            arms.setDefense(40);
		            arms.setRarity(3);
		            arms.setUpgradeLv(1);

		            Armor waist = new Armor();
					waist.setNameType("WAIST");
		            waist.setDefense(40);
		            waist.setRarity(3);
		            waist.setUpgradeLv(1);

		            Armor legs = new Armor();
					legs.setNameType("LEGS");
		            legs.setDefense(40);
		            legs.setRarity(3);
		            legs.setUpgradeLv(1);

		            Charm charm = new Charm();
					charm.setNameType("CHARM");
		            charm.setSkills("DEFENSE BOOST");
		            charm.setRarity(3);
		            charm.setUpgradeLv(1);

		            List<Equipment> equipments = new ArrayList<>(6);
		            equipments.add(helm);
		            equipments.add(chest);
		            equipments.add(arms);
		            equipments.add(waist);
		            equipments.add(legs);
		            equipments.add(charm);
		            c.setEquipments(equipments);
		            em.persist(mw);
					em.persist(helm);
					em.persist(chest);
					em.persist(arms);
					em.persist(waist);
					em.persist(legs);
					em.persist(charm);
					em.persist(c);
			           
		        } else if (selectedLevel.equals("ADVANCED")) {
		            c.setLevel(500);
		        	MeleeWpn mw = new MeleeWpn();
		            mw.setDamage(252);
		            mw.setSharpness(12);
		            mw.setAffinity(50);
		            mw.setElement("DRAGON");
		            mw.setRarity(11);
		            mw.setDamageType("CUT DAMAGE");
		            c.setWeapon(mw);

		            Armor helm = new Armor();
		            helm.setNameType("HELM");
		            helm.setDefense(80);
		            helm.setRarity(10);
		            helm.setUpgradeLv(2);
		             
		            Armor chest = new Armor();
			        chest.setNameType("CHEST");
		            chest.setDefense(90);
		            chest.setRarity(10);
		            chest.setUpgradeLv(2);
		            
		            Armor arms = new Armor();
			        arms.setNameType("ARMS");
		            arms.setDefense(90);
		            arms.setRarity(10);
		            arms.setUpgradeLv(2);

		            Armor waist = new Armor();
					waist.setNameType("WAIST");
		            waist.setDefense(90);
		            waist.setRarity(10);
		            waist.setUpgradeLv(2);

		            Armor legs = new Armor();
					legs.setNameType("LEGS");
		            legs.setDefense(90);
		            legs.setRarity(10);
		            legs.setUpgradeLv(2);

		            Charm charm = new Charm();
					charm.setNameType("CHARM");
		            charm.setSkills("ATTACK BOOST");
		    		charm.setRarity(11);
		    		charm.setUpgradeLv(4);

		            List<Equipment> equipments = new ArrayList<>(6);
		            equipments.add(helm);
		            equipments.add(chest);
		            equipments.add(arms);
		            equipments.add(waist);
		            equipments.add(legs);
		            equipments.add(charm);
		            c.setEquipments(equipments);
		            em.persist(mw);
					em.persist(helm);
					em.persist(chest);
					em.persist(arms);
					em.persist(waist);
					em.persist(legs);
					em.persist(charm);
					em.persist(c);
		        }
		        textField.setText("");
		        JOptionPane.showMessageDialog(null, "Character CREATED");
				em.getTransaction().commit();
				textField.setText("");
			}
		});
		btnNewButton.setBounds(150, 40, 84, 23);
		contentPane.add(btnNewButton);
	}
}