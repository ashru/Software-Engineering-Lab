package CList;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JRadioButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class selectCat1 extends JPanel {

	

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					selectCat frame = new selectCat();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public selectCat1(FullContactList L,int act,JLayeredPane lp,JPanel panel) {
		setBackground(new Color(51, 204, 204));
		
		
		//setVisible(true);
		
		setBounds(100, 100, 450, 300);
		
		setBorder(new EmptyBorder(5, 5, 5, 5));
		//setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gbl_contentPane);
		
		JRadioButton rdbtnRelatives = new JRadioButton("Relatives                     ");
		GridBagConstraints gbc_rdbtnRelatives = new GridBagConstraints();
		gbc_rdbtnRelatives.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnRelatives.gridx = 2;
		gbc_rdbtnRelatives.gridy = 3;
		add(rdbtnRelatives, gbc_rdbtnRelatives);
		
		JRadioButton rdbtnPersonalFriends = new JRadioButton("Personal Friends        ");
		GridBagConstraints gbc_rdbtnPersonalFriends = new GridBagConstraints();
		gbc_rdbtnPersonalFriends.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnPersonalFriends.gridx = 2;
		gbc_rdbtnPersonalFriends.gridy = 4;
		add(rdbtnPersonalFriends, gbc_rdbtnPersonalFriends);
		
		JRadioButton rdbtnProfessionalFriends = new JRadioButton("Professional Friends ");
		GridBagConstraints gbc_rdbtnProfessionalFriends = new GridBagConstraints();
		gbc_rdbtnProfessionalFriends.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnProfessionalFriends.gridx = 2;
		gbc_rdbtnProfessionalFriends.gridy = 5;
		add(rdbtnProfessionalFriends, gbc_rdbtnProfessionalFriends);
		
		JRadioButton rdbtnCasualAcquaintance = new JRadioButton("Casual Acquaintance");
		GridBagConstraints gbc_rdbtnCasualAcquaintance = new GridBagConstraints();
		gbc_rdbtnCasualAcquaintance.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnCasualAcquaintance.gridx = 2;
		gbc_rdbtnCasualAcquaintance.gridy = 6;
		add(rdbtnCasualAcquaintance, gbc_rdbtnCasualAcquaintance);
		ButtonGroup bg=new ButtonGroup();
		bg.add(rdbtnRelatives);
		bg.add(rdbtnPersonalFriends);
		bg.add(rdbtnProfessionalFriends);
		bg.add(rdbtnCasualAcquaintance);
		
		JButton btnNewButton = new JButton("Done");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 7;
		add(btnNewButton, gbc_btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				panel.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.gridx = 5;
		gbc_btnBack.gridy = 7;
		add(btnBack, gbc_btnBack);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try{
				
				String str=ContactListApplet2.getSelectedButtonText(bg);
				if(str==null)
				{
					setVisible(false);
					panel.setVisible(true);
				}
				
				
				if(act==1)
				{
					if(str.compareTo("Relatives                     ")==0)
					{
						
						CreateRel1 c=new CreateRel1(L,lp,panel);
						setVisible(false);
						lp.add(c,2);
						
						c.setVisible(true);
						c.setBounds(0, 0, 450, 300);
						
						
						
					}
					else if(str.compareTo("Personal Friends        ")==0)
					{
						CreatePer1 c=new CreatePer1(L,lp,panel);
						setVisible(false);
						lp.add(c,2);
						
						c.setVisible(true);
						c.setBounds(0, 0, 450, 300);
						
						
						
					}
					else if(str.compareTo("Professional Friends ")==0)
					{
						CreateProf1 c=new CreateProf1(L,lp,panel);
						setVisible(false);
						lp.add(c,2);
						
						c.setVisible(true);
						c.setBounds(0, 0, 450, 300);
						
						
					}
					else if(str.compareTo("Casual Acquaintance")==0)
					{
						CreateCas1 c=new CreateCas1(L,lp,panel);
						setVisible(false);
						lp.add(c,2);
						
						c.setVisible(true);
						c.setBounds(0, 0, 450, 300);
						
					}
						
						
						
					else
					{
						setVisible(false);
						panel.setVisible(true);
					}
					
					
					
					
				}
				if(act==2)
				{
					if(str.compareTo("Relatives                     ")==0)
					{

						if(L.rel==0)
						{
							JOptionPane.showMessageDialog(null,"There are no contacts to display!","No contacts",JOptionPane.PLAIN_MESSAGE);
						}
						else{
						DisplayContacts d=new DisplayContacts(L,2,panel);
						setVisible(false);
						lp.add(d,2);
						
						d.setVisible(true);
						d.setBounds(0, 0, 450, 300);
						}
					
						
						
					}
					else if(str.compareTo("Personal Friends        ")==0)
					{

						if(L.per==0)
						{
							JOptionPane.showMessageDialog(null,"There are no contacts to display!","No contacts",JOptionPane.PLAIN_MESSAGE);
						}
						else{
							DisplayContacts d=new DisplayContacts(L,3,panel);
						setVisible(false);
lp.add(d,2);
						
						d.setVisible(true);
						d.setBounds(0, 0, 450, 300);
						}
					}
					else if(str.compareTo("Professional Friends ")==0)
					{

						if(L.prof==0)
						{
							JOptionPane.showMessageDialog(null,"There are no contacts to display!","No contacts",JOptionPane.PLAIN_MESSAGE);
						}
						else{
							DisplayContacts d=new DisplayContacts(L,4,panel);
						setVisible(false);
						lp.add(d,2);
						
						d.setVisible(true);
						d.setBounds(0, 0, 450, 300);
						}
						
					}
					else if(str.compareTo("Casual Acquaintance")==0)
					{

						if(L.cas==0)
						{
							JOptionPane.showMessageDialog(null,"There are no contacts to display!","No contacts",JOptionPane.PLAIN_MESSAGE);
						}
						else{
							DisplayContacts d=new DisplayContacts(L,5,panel);
						setVisible(false);
lp.add(d,2);
						
						d.setVisible(true);
						d.setBounds(0, 0, 450, 300);
					}
					}
						
						
						
					else
					{
						setVisible(false);
					}
					
					
					
					
				}
				
				
				
				
				}catch(Exception e){e.printStackTrace();}
			}
		});
	}

}
