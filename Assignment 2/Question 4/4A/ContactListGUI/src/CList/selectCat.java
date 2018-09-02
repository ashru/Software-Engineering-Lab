package CList;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
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

public class selectCat extends JFrame {

	private JPanel contentPane;

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
	public selectCat(FullContactList L,int act) {
		setVisible(true);
		setTitle("Choose a Category");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 102));
		contentPane.setBackground(new Color(255, 255, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JRadioButton rdbtnRelatives = new JRadioButton("Relatives                     ");
		GridBagConstraints gbc_rdbtnRelatives = new GridBagConstraints();
		gbc_rdbtnRelatives.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnRelatives.gridx = 2;
		gbc_rdbtnRelatives.gridy = 3;
		contentPane.add(rdbtnRelatives, gbc_rdbtnRelatives);
		
		JRadioButton rdbtnPersonalFriends = new JRadioButton("Personal Friends        ");
		GridBagConstraints gbc_rdbtnPersonalFriends = new GridBagConstraints();
		gbc_rdbtnPersonalFriends.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnPersonalFriends.gridx = 2;
		gbc_rdbtnPersonalFriends.gridy = 4;
		contentPane.add(rdbtnPersonalFriends, gbc_rdbtnPersonalFriends);
		
		JRadioButton rdbtnProfessionalFriends = new JRadioButton("Professional Friends ");
		GridBagConstraints gbc_rdbtnProfessionalFriends = new GridBagConstraints();
		gbc_rdbtnProfessionalFriends.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnProfessionalFriends.gridx = 2;
		gbc_rdbtnProfessionalFriends.gridy = 5;
		contentPane.add(rdbtnProfessionalFriends, gbc_rdbtnProfessionalFriends);
		
		JRadioButton rdbtnCasualAcquaintance = new JRadioButton("Casual Acquaintance");
		GridBagConstraints gbc_rdbtnCasualAcquaintance = new GridBagConstraints();
		gbc_rdbtnCasualAcquaintance.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnCasualAcquaintance.gridx = 2;
		gbc_rdbtnCasualAcquaintance.gridy = 6;
		contentPane.add(rdbtnCasualAcquaintance, gbc_rdbtnCasualAcquaintance);
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
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 7;
		contentPane.add(btnNewButton, gbc_btnNewButton);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try{
				
				String str=GUIclist.getSelectedButtonText(bg);
				
				if(act==1)
				{
					if(str.compareTo("Relatives                     ")==0)
					{
						
						CreateRel c=new CreateRel(L);
						c.setVisible(true);
						
						
					}
					else if(str.compareTo("Personal Friends        ")==0)
					{
						CreatePer c=new CreatePer(L);
						
						c.setVisible(true);
						
					}
					else if(str.compareTo("Professional Friends ")==0)
					{
						CreateProf c=new CreateProf(L);
						
						c.setVisible(true);
						
					}
					else if(str.compareTo("Casual Acquaintance")==0)
					{
						CreateCas c=new CreateCas(L);
						c.setVisible(true);
					}
						
						
						
					else
					{
						setVisible(false);
					}
					
					
					
					
				}
				if(act==2)
				{
					if(str.compareTo("Relatives                     ")==0)
					{
						
						DispContOP d=new DispContOP(L,2);
						
						
					}
					else if(str.compareTo("Personal Friends        ")==0)
					{
						DispContOP d=new DispContOP(L,3);
						
					}
					else if(str.compareTo("Professional Friends ")==0)
					{
						DispContOP d=new DispContOP(L,4);
						
					}
					else if(str.compareTo("Casual Acquaintance")==0)
					{
						DispContOP d=new DispContOP(L,5);
					}
						
						
						
					else
					{
						setVisible(false);
					}
					
					
					
					
				}
				setVisible(false);
				
				
				
				}catch(Exception e){e.printStackTrace();}
			}
		});
	}

}
