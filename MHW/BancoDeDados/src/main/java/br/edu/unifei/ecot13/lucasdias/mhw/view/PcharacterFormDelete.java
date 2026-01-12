package br.edu.unifei.ecot13.lucasdias.mhw.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.edu.unifei.ecot13.lucasdias.mhw.Palico;
import br.edu.unifei.ecot13.lucasdias.mhw.Pcharacter;

public class PcharacterFormDelete extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("mhwbdPU");
	EntityManager em = emf.createEntityManager();
	Pcharacter c = new Pcharacter();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PcharacterFormDelete frame = new PcharacterFormDelete();
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
	public PcharacterFormDelete() {
		setType(Type.UTILITY);
		setTitle("Delete Character");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 260, 112);
		//setBounds(100, 100, 260, 295);
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
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblName.setBounds(25, 73, 70, 20);
		contentPane.add(lblName);
		
		JLabel lblLevel = new JLabel("Level:");
		lblLevel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLevel.setBounds(25, 103, 70, 20);
		contentPane.add(lblLevel);
		
		JLabel lblPalico = new JLabel("Palico");
		lblPalico.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPalico.setBounds(10, 133, 111, 20);
		contentPane.add(lblPalico);
		
		JLabel lblPName = new JLabel("Name:");
		lblPName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPName.setBounds(25, 163, 70, 20);
		contentPane.add(lblPName);
		
		JLabel lblPColor = new JLabel("Color:");
		lblPColor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPColor.setBounds(25, 193, 70, 20);
		contentPane.add(lblPColor);
		
		JLabel lblCName = new JLabel("");
		lblCName.setBounds(120, 73, 114, 20);
		contentPane.add(lblCName);
		
		JLabel lblCLevel = new JLabel("");
		lblCLevel.setBounds(120, 103, 114, 20);
		contentPane.add(lblCLevel);
		
		JLabel lblPName_1 = new JLabel("");
		lblPName_1.setBounds(120, 163, 114, 20);
		contentPane.add(lblPName_1);
		
		JLabel lblPColor_1 = new JLabel("");
		lblPColor_1.setBounds(120, 193, 114, 20);
		contentPane.add(lblPColor_1);		
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				em.getTransaction().begin();
				if(c.getPalico()!=null) {
					em.remove(c.getPalico());
				}	
				em.remove(c);
				em.getTransaction().commit();
				setBounds(100, 100, 260, 112);
				JOptionPane.showMessageDialog(null, "Character DELETED");
			}
		});
		btnDelete.setBounds(16, 223, 89, 23);
		contentPane.add(btnDelete);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c = null;
				textField.setText("");
				setBounds(100, 100, 260, 112);
			}
		});
		btnCancel.setBounds(138, 223, 89, 23);
		contentPane.add(btnCancel);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c = em.find(Pcharacter.class, 
						textField.getText());
				if(c!=null) {
					setBounds(100, 100, 260, 295);
					lblCName.setText(c.getName());
					lblCLevel.setText(Integer.toString(c.getLevel()));
					Palico p = c.getPalico();
					String pname;
					String pcolor;
					if(p!=null) {
						pname = p.getName();
						pcolor = p.getColor();	
					}else {
						pname = "NONE";
						pcolor = "NONE";
					}
					lblPName_1.setText(pname);
					lblPColor_1.setText(pcolor);	
				}else {
					setBounds(100, 100, 260, 112);
					JOptionPane.showMessageDialog(null, "Character not found");
				}
				textField.setText("");
			}
		});
		btnSearch.setBounds(77, 40, 89, 23);
		contentPane.add(btnSearch);
	}
}
