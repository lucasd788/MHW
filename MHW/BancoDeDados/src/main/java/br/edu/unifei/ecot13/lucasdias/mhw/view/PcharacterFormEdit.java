package br.edu.unifei.ecot13.lucasdias.mhw.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.edu.unifei.ecot13.lucasdias.mhw.Armor;
import br.edu.unifei.ecot13.lucasdias.mhw.Charm;
import br.edu.unifei.ecot13.lucasdias.mhw.Equipment;
import br.edu.unifei.ecot13.lucasdias.mhw.Gadget;
import br.edu.unifei.ecot13.lucasdias.mhw.MeleeWpn;
import br.edu.unifei.ecot13.lucasdias.mhw.Palico;
import br.edu.unifei.ecot13.lucasdias.mhw.Pcharacter;
import javax.swing.JCheckBox;

public class PcharacterFormEdit extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("mhwbdPU");
	EntityManager em = emf.createEntityManager();
	private boolean en = false;
	Pcharacter c = new Pcharacter();
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PcharacterFormEdit frame = new PcharacterFormEdit();
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
	public PcharacterFormEdit() {
		setType(Type.UTILITY);
		setTitle("Edit Character");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 260, 112);
		//setBounds(100, 100, 260, 238);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
	
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCharacterName = new JLabel("Character name:");
		lblCharacterName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCharacterName.setBounds(10, 10, 111, 20);
		contentPane.add(lblCharacterName);
		
		textField = new JTextField();
		textField.setBounds(120, 10, 114, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"NONE", "BEGINNER", "INTERMEDIATE", "ADVANCED"}));
		comboBox.setBounds(57, 73, 130, 23);
		contentPane.add(comboBox);
		
		JLabel lblPalicoName = new JLabel("Palico name:");
		lblPalicoName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPalicoName.setBounds(10, 139, 111, 20);
		lblPalicoName.setEnabled(false);
		contentPane.add(lblPalicoName);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(120, 139, 114, 20);
		textField_1.setEnabled(false);
		contentPane.add(textField_1);
		
		JLabel lblPalicoColor = new JLabel("Palico Color:");
		lblPalicoColor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPalicoColor.setBounds(10, 169, 111, 20);
		lblPalicoColor.setEnabled(false);
		contentPane.add(lblPalicoColor);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(120, 169, 114, 20);
		textField_2.setEnabled(false);
		contentPane.add(textField_2);
		
		JCheckBox chckbxAddPalico = new JCheckBox("Create/Edit Palico");
		chckbxAddPalico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				en = !en;
				lblPalicoName.setEnabled(en);
				textField_1.setEnabled(en);
				lblPalicoColor.setEnabled(en);
				textField_2.setEnabled(en);
				textField_1.setText("");
				textField_2.setText("");
			}
		});
		chckbxAddPalico.setBounds(10, 106, 134, 23);
		contentPane.add(chckbxAddPalico);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				em.getTransaction().begin();
				if (en) {
					if(c.getPalico()!=null) {
						em.remove(c.getPalico());
					}
					Palico p = new Palico();
					String pname = textField_1.getText();
					String pcolor = textField_2.getText();
					if(!pname.isEmpty()) {
						p.setName(pname);
					}
					if(!pcolor.isEmpty()) {
						p.setColor(pcolor);				
					}
					p.setCharacter(c);
					c.setPalico(p);
					
					Gadget g = new Gadget();
					g.setRarity(9);
					g.setProficiency(15);
					p.setGadget(g);
					em.persist(g);
					
					Armor helmP = new Armor();
					helmP.setNameType("HELM PALICO");
					helmP.setDefense(56);
					helmP.setRarity(5);
					helmP.setUpgradeLv(3);
					
					Armor chestP = new Armor();
					chestP.setNameType("CHEST PALICO");
					chestP.setDefense(90);
					chestP.setRarity(9);
					chestP.setUpgradeLv(1);
					
					List<Equipment> equipmentsP = new ArrayList<>(2);
					equipmentsP.add(helmP);
					equipmentsP.add(chestP);
					p.setEquipments(equipmentsP);
					em.persist(helmP);
					em.persist(chestP);
					em.persist(p);
					
				}
				String selectedLevel = (String) comboBox.getSelectedItem();
				if (selectedLevel.equals("NONE")) {
					em.persist(c);
				} else if (selectedLevel.equals("BEGINNER")) {
		        	c.setLevel(5);
		        	em.remove(c.getWeapon());
		        	for(Equipment equipment: c.getEquipments()) {
		        		em.remove(equipment);
		    		}		        	
		        	
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
		        	em.remove(c.getWeapon());
		        	for(Equipment equipment: c.getEquipments()) {
		        		em.remove(equipment);
		    		}
		        	
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
		            em.remove(c.getWeapon());
		            for(Equipment equipment: c.getEquipments()) {
		        		em.remove(equipment);
		    		}
		            
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
				JOptionPane.showMessageDialog(null, "Character EDITED");
				setBounds(100, 100, 260, 112);
				em.getTransaction().commit();
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				chckbxAddPalico.setSelected(false);
			}
		});
		btnConfirm.setBounds(150, 106, 84, 23);
		contentPane.add(btnConfirm);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c = em.find(Pcharacter.class, 
						textField.getText());
				if(c!=null) {
					setBounds(100, 100, 260, 238);
				}else {
					setBounds(100, 100, 260, 112);
					textField.setText("");
					JOptionPane.showMessageDialog(null, "Character not found");
				}	
			}
		});
		btnSearch.setBounds(78, 40, 84, 23);
		contentPane.add(btnSearch);
	}

}
