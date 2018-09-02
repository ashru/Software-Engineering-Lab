package CList;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.JButton;

public class CreatePer extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JLabel lblNotableEvents;
	private JTextField textField_5;
	
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public CreatePer(FullContactList L) {
		setTitle("Create new personal friend");
		DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
	    df.setLenient(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblName = new JLabel("Name");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.EAST;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 1;
		gbc_lblName.gridy = 1;
		contentPane.add(lblName, gbc_lblName);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 1;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblMobileNumber = new JLabel("Mobile number");
		GridBagConstraints gbc_lblMobileNumber = new GridBagConstraints();
		gbc_lblMobileNumber.anchor = GridBagConstraints.EAST;
		gbc_lblMobileNumber.insets = new Insets(0, 0, 5, 5);
		gbc_lblMobileNumber.gridx = 1;
		gbc_lblMobileNumber.gridy = 2;
		contentPane.add(lblMobileNumber, gbc_lblMobileNumber);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 2;
		contentPane.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JLabel lblEmailId = new JLabel("Email  id");
		GridBagConstraints gbc_lblEmailId = new GridBagConstraints();
		gbc_lblEmailId.anchor = GridBagConstraints.EAST;
		gbc_lblEmailId.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmailId.gridx = 1;
		gbc_lblEmailId.gridy = 3;
		contentPane.add(lblEmailId, gbc_lblEmailId);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 2;
		gbc_textField_2.gridy = 3;
		contentPane.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		JLabel lblBirthday = new JLabel("Date of Acquaintance");
		GridBagConstraints gbc_lblBirthday = new GridBagConstraints();
		gbc_lblBirthday.anchor = GridBagConstraints.EAST;
		gbc_lblBirthday.insets = new Insets(0, 0, 5, 5);
		gbc_lblBirthday.gridx = 1;
		gbc_lblBirthday.gridy = 4;
		contentPane.add(lblBirthday, gbc_lblBirthday);
		
		textField_3 = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 0);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 2;
		gbc_textField_3.gridy = 4;
		contentPane.add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		
		JLabel lblDateOfLast = new JLabel("Context of Acquaintance");
		GridBagConstraints gbc_lblDateOfLast = new GridBagConstraints();
		gbc_lblDateOfLast.anchor = GridBagConstraints.EAST;
		gbc_lblDateOfLast.insets = new Insets(0, 0, 5, 5);
		gbc_lblDateOfLast.gridx = 1;
		gbc_lblDateOfLast.gridy = 5;
		contentPane.add(lblDateOfLast, gbc_lblDateOfLast);
		
		textField_4 = new JTextField();
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 0, 5, 0);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 2;
		gbc_textField_4.gridy = 5;
		contentPane.add(textField_4, gbc_textField_4);
		textField_4.setColumns(10);
		
		lblNotableEvents = new JLabel("Notable Events");
		GridBagConstraints gbc_lblNotableEvents = new GridBagConstraints();
		gbc_lblNotableEvents.anchor = GridBagConstraints.EAST;
		gbc_lblNotableEvents.insets = new Insets(0, 0, 5, 5);
		gbc_lblNotableEvents.gridx = 1;
		gbc_lblNotableEvents.gridy = 6;
		contentPane.add(lblNotableEvents, gbc_lblNotableEvents);
		
		textField_5 = new JTextField();
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.insets = new Insets(0, 0, 5, 0);
		gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5.gridx = 2;
		gbc_textField_5.gridy = 6;
		contentPane.add(textField_5, gbc_textField_5);
		textField_5.setColumns(10);
		
		JButton btnDone = new JButton("Done");
		GridBagConstraints gbc_btnDone = new GridBagConstraints();
		gbc_btnDone.fill = GridBagConstraints.VERTICAL;
		gbc_btnDone.insets = new Insets(0, 0, 0, 5);
		gbc_btnDone.gridx = 1;
		gbc_btnDone.gridy = 7;
		contentPane.add(btnDone, gbc_btnDone);
		btnDone .addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int flag=1;
			      
			      String s1=textField.getText();String s2="",s3="";
			      long mob=0;
			      try{
			       mob=Long.parseLong(textField_1.getText());
			      }
			      catch(Exception e)
			      {flag=0;JOptionPane.showMessageDialog(null,"Invalid mobile no","Input Error",JOptionPane.PLAIN_MESSAGE);dispose();}
			      
			      String em=textField_2.getText();
			      
			      Date d1 = new Date();
			      try{
			      d1=df.parse(textField_3.getText());
			      }catch(Exception e){flag=0;JOptionPane.showMessageDialog(null,"Invalid Date","Input Error",JOptionPane.PLAIN_MESSAGE);dispose();}
			      Date d2 =new Date();
			      try{
			      s2=textField_4.getText();
			      if(s2.length()>100)
			      {flag=0;JOptionPane.showMessageDialog(null,"Must be less than 100 chars long","Input Error",JOptionPane.PLAIN_MESSAGE);dispose();}
			      }catch(Exception e){flag=0;JOptionPane.showMessageDialog(null,"Invalid ","Input Error",JOptionPane.PLAIN_MESSAGE);dispose();}
			      try{
				      s3=textField_5.getText();
				      if(s3.length()>100)
				      {flag=0;JOptionPane.showMessageDialog(null,"Must be less than 100 chars long","Input Error",JOptionPane.PLAIN_MESSAGE);dispose();}
				      }catch(Exception e){flag=0;JOptionPane.showMessageDialog(null,"Invalid ","Input Error",JOptionPane.PLAIN_MESSAGE);dispose();}
			      if(FullContactList.match(s1,L)==1)
			      {flag=0;JOptionPane.showMessageDialog(null,"Duplicate name.Enter different name!","Input Error",JOptionPane.PLAIN_MESSAGE);}
			if(flag==1)
			{
				personalFriends c1=new personalFriends(s2,s3,d1,s1,em,mob);
				int i;
				for(i=L.per;i>0;--i)
				{
					if((c1.name).compareTo(L.p[i-1].name)<0)
						L.p[i]=L.p[i-1];
					else break;
						
				}
				L.p[i]=c1;
				L.per++;
				L.tot++;
				try {
					GUIclist.Filewriter(L);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				GUIclist.Filewriter(L);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			setVisible(false);
			}
			

});
	}
}
