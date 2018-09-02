package STCM;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ModifyCourse extends JFrame {

	public JPanel contentPane;
	public JTextField textField;
	public JTextField textField_1;
	public JTextField textField_2;
	public JTextField textField_3;
	public JTextField textField_4;
	public JTextField textField_5;
	public JLabel lblNoOfStudents;
	
	String s1;Date d1;long fees;Faculty ins[] = new Faculty[5];Participant par[]=new Participant[5];int dur;

	/**
	 * Launch the application.
	 */
	
	

	/**
	 * Create the frame.
	 */
	Faculty cc;int nins=0,npar=0,i;
	
		
	
	public ModifyCourse(Course c[],int n) {
		this.setVisible(true);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	      df.setLenient(false);
		setBounds(100, 100, 546, 273);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Name");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 2;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		textField = new JTextField(c[n].Course_name);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 3;
		gbc_textField.gridy = 2;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Fees");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 3;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		
		textField_1 = new JTextField(Long.toString(c[n].Course_fees));
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 3;
		gbc_textField_1.gridy = 3;
		contentPane.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Start Date");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 4;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		textField_2 = new JTextField(df.format(c[n].start_date));
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 3;
		gbc_textField_2.gridy = 4;
		contentPane.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Duration");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 5;
		contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		textField_3 = new JTextField(Integer.toString(c[n].duration));
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 0);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 3;
		gbc_textField_3.gridy = 5;
		contentPane.add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		
		/*JLabel lblNewLabel_4 = new JLabel("No of instructors");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 6;
		contentPane.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		textField_4 = new JTextField();
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 0, 5, 0);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 3;
		gbc_textField_4.gridy = 6;
		contentPane.add(textField_4, gbc_textField_4);
		textField_4.setColumns(10);
		
		lblNoOfStudents = new JLabel("No of Students");
		GridBagConstraints gbc_lblNoOfStudents = new GridBagConstraints();
		gbc_lblNoOfStudents.insets = new Insets(0, 0, 5, 5);
		gbc_lblNoOfStudents.gridx = 1;
		gbc_lblNoOfStudents.gridy = 7;
		contentPane.add(lblNoOfStudents, gbc_lblNoOfStudents);
		
		textField_5 = new JTextField();
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.insets = new Insets(0, 0, 5, 0);
		gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5.gridx = 3;
		gbc_textField_5.gridy = 7;
		contentPane.add(textField_5, gbc_textField_5);
		textField_5.setColumns(10);
		*/
		
		
		JButton btnNewButton = new JButton("Done");		
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 10;
		contentPane.add(btnNewButton, gbc_btnNewButton);
		
	      btnNewButton.addMouseListener(new MouseAdapter() {
				@Override
				
				public void mouseClicked(MouseEvent arg0) {
					      
				      
					
				      
				      
				      int flag=1;
				      
				      c[n].Course_name=textField.getText();
				      fees=0;
				      
				      
				      try{c[n].Course_fees=Long.parseLong(textField_1.getText());
				      }
				      catch(Exception e){flag=0;JOptionPane.showMessageDialog(null,"Fees must be a long integer","Input Error",JOptionPane.PLAIN_MESSAGE);
				      dispose();
				      }
				      
				       
				      d1=new Date();
				      
				      
				          try
				          {
				              c[n].start_date=(Date)df.parse(textField_2.getText());
				              
				          }
				          catch(ParseException e) 
				          {
				              flag=0;JOptionPane.showMessageDialog(null,"Invalid Date","Input Error",JOptionPane.PLAIN_MESSAGE);
				              dispose();
				          }
				          
				          
				      
				          
				          

				     
				      
				      
				      
				      dur=0;
				      
				      
				      
				      try{c[n].duration=Integer.parseInt(textField_3.getText());if(dur>14 || dur<0){JOptionPane.showMessageDialog(null,"Please type in a valid, real number","Input Error",JOptionPane.PLAIN_MESSAGE);flag=0;}
				      }
				      catch(Exception e){flag=0;JOptionPane.showMessageDialog(null,"Invalid duration","Input Error",JOptionPane.PLAIN_MESSAGE);dispose();}
				      
				      
				      try{GUIstcm.writefile(c, n);
				       }catch(Exception e){}
				      
				      setVisible(false);
				      
				     
				      /*nins=0;npar=0;
				     
				      try{nins=Integer.parseInt(textField_4.getText());if(nins>5 || nins<0){flag=0;}
				      }
				      catch(Exception e){flag=0;JOptionPane.showMessageDialog(null,"No of instructors must be between 0 and 5","Input Error",JOptionPane.PLAIN_MESSAGE);}
				      

				      
				      
				      
				      
				      try{npar=Integer.parseInt(textField_5.getText());if(npar>5 || npar<0){flag=0;}
				      }
				      catch(Exception e){flag=0;JOptionPane.showMessageDialog(null,"No of participants must be between 0 and 5","Input Error",JOptionPane.PLAIN_MESSAGE);}
				      
				      setVisible(false);
						c[n]=new Course(s1,d1,fees,dur,0,0,cc,ins,par);
					  	
				      
				      
				      if(flag==1)
				      {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								EnterCC frame = new EnterCC(c,n);
								frame.setVisible(true);
								frame.setTitle("Enter Course Co-ordinator details");
								
								
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
					
					
					
					for(i=0;i<nins;++i)
					{
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									enterFac frame = new enterFac(c,n);
									frame.setVisible(true);
									frame.setTitle("Enter Faculty details");
									
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
					}
					for(i=0;i<npar;++i)
					{
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									EnterPart frame = new EnterPart(c,n);
									frame.setVisible(true);
									frame.setTitle("Enter Participant details");
									
											} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
					}
					
					
					
					
				}
				   */   
				      
				}
	      }
			);
	      
	      
	      
	      
	      
	      
	          
	          
	      
	      
			
	
	}

	public static  boolean withinYear(Date inputDate)
	  {
	 GregorianCalendar calToday = new GregorianCalendar();
	GregorianCalendar oneYearAgoTodayAtMidnight = new GregorianCalendar(calToday.get(Calendar.YEAR) - 1, calToday.get(Calendar.MONTH), calToday.get(Calendar.DATE));
	  boolean result=false;
	  Date date1 = oneYearAgoTodayAtMidnight.getTime();

	  if (date1.compareTo(inputDate)<=0)
	           return true;
	          return result;
	  }
	
	
	

	}


