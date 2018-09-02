package STCM;

import java.awt.BorderLayout;
import javax.swing.ButtonGroup;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.swing.AbstractButton;

import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.awt.Color;
public class GUIstcm extends JFrame {

	private JPanel contentPane;
	static int k;
	static int g;
	static int flow;static Course c[]=new Course[1000];
	public static  int withinYear(Date inputDate)//checks if date is within a year of today's date
    {
   GregorianCalendar calToday = new GregorianCalendar();
GregorianCalendar oneYearAgoTodayAtMidnight = new GregorianCalendar(calToday.get(Calendar.YEAR) - 1, calToday.get(Calendar.MONTH), calToday.get(Calendar.DATE));
   
    Date date1 = oneYearAgoTodayAtMidnight.getTime();

    if (date1.compareTo(inputDate)<=0)
             return 1;
    GregorianCalendar oneYearAgoTodayAtMidnight2 = new GregorianCalendar(calToday.get(Calendar.YEAR) - 2, calToday.get(Calendar.MONTH), calToday.get(Calendar.DATE));
    
    Date date2 = oneYearAgoTodayAtMidnight2.getTime();
    
    if (date2.compareTo(inputDate)<=0)
        return 2;
    
    GregorianCalendar oneYearAgoTodayAtMidnight3 = new GregorianCalendar(calToday.get(Calendar.YEAR) - 3, calToday.get(Calendar.MONTH), calToday.get(Calendar.DATE));
    
    Date date3 = oneYearAgoTodayAtMidnight3.getTime();
    
    if (date3.compareTo(inputDate)<=0)
        return 3;
    
    
    GregorianCalendar oneYearAgoTodayAtMidnight4 = new GregorianCalendar(calToday.get(Calendar.YEAR) - 4, calToday.get(Calendar.MONTH), calToday.get(Calendar.DATE));
    
    Date date4 = oneYearAgoTodayAtMidnight4.getTime();
    
    if (date4.compareTo(inputDate)<=0)
        return 4;
    GregorianCalendar oneYearAgoTodayAtMidnight5 = new GregorianCalendar(calToday.get(Calendar.YEAR) - 5, calToday.get(Calendar.MONTH), calToday.get(Calendar.DATE));
    
    Date date5 = oneYearAgoTodayAtMidnight5.getTime();
    if (date5.compareTo(inputDate)<=0)
        return 5;
            return -1;

        }
	static void writefile(Course c[],int no_of_courses)throws IOException//write the records to a text file
    {
        File f2 = new File("CourseManagement.txt");
                FileWriter writer2 = new FileWriter(f2);
                int i;
                int n1=no_of_courses;
                
                writer2.write(Integer.toString(no_of_courses)+System.getProperty( "line.separator" ));
                for(i=0;i<5;++i)
                writer2.write(Integer.toString(no_in_year[i])+System.getProperty( "line.separator" ));
                
                SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                df.setLenient(false);
                
                 
                for(i=0;i<n1;++i)
                {
                    
                    writer2.write(c[i].Course_name+System.getProperty( "line.separator" ));
                    writer2.write(Long.toString(c[i].Course_fees)+System.getProperty( "line.separator" ));
                    writer2.write(df.format(c[i].start_date)+System.getProperty( "line.separator" ));
                    writer2.write(Integer.toString(c[i].duration)+System.getProperty( "line.separator" ));
                    writer2.write(c[i].Co_ordinator.name+System.getProperty( "line.separator" ));
                    writer2.write(c[i].Co_ordinator.Department+System.getProperty( "line.separator" ));
                    writer2.write(c[i].Co_ordinator.address+System.getProperty( "line.separator" ));
                    writer2.write(c[i].Co_ordinator.email_id+System.getProperty( "line.separator" ));
                    writer2.write(c[i].Co_ordinator.mobile_no+System.getProperty( "line.separator" ));
                    writer2.write(Integer.toString(c[i].no_of_instructors)+System.getProperty( "line.separator" ));
                    writer2.write(Integer.toString(c[i].no_of_students)+System.getProperty( "line.separator" ));
                    int j;
                    for(j=0;j<c[i].no_of_instructors;++j)
                    {
                        writer2.write(c[i].instructors[j].name+System.getProperty( "line.separator" ));
                        writer2.write(c[i].instructors[j].Department+System.getProperty( "line.separator" ));
                        writer2.write(c[i].instructors[j].address+System.getProperty( "line.separator" ));
                        writer2.write(c[i].instructors[j].email_id+System.getProperty( "line.separator" ));
                        writer2.write(c[i].instructors[j].mobile_no+System.getProperty( "line.separator" ));
                    }
                    for(j=0;j<c[i].no_of_students;++j)
                    {
                        writer2.write(c[i].students[j].name+System.getProperty( "line.separator" ));
                        writer2.write(c[i].students[j].org_name+System.getProperty( "line.separator" ));
                        writer2.write(c[i].students[j].address+System.getProperty( "line.separator" ));
                        writer2.write(c[i].students[j].email_id+System.getProperty( "line.separator" ));
                        writer2.write(c[i].students[j].mobile_no+System.getProperty( "line.separator" ));
                    }
                }    
                writer2.flush();
                writer2.close();
    }
	static void writefile(Course c[],int no_of_courses,int no_in_year[])throws IOException//write the records to a text file
    {
        File f2 = new File("CourseManagement.txt");
                FileWriter writer2 = new FileWriter(f2);
                int i;
                int n1=no_of_courses;
                
                writer2.write(Integer.toString(no_of_courses)+System.getProperty( "line.separator" ));
                for(i=0;i<5;++i)
                writer2.write(Integer.toString(no_in_year[i])+System.getProperty( "line.separator" ));
                
                SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                df.setLenient(false);
                
                 
                for(i=0;i<n1;++i)
                {
                    
                    writer2.write(c[i].Course_name+System.getProperty( "line.separator" ));
                    writer2.write(Long.toString(c[i].Course_fees)+System.getProperty( "line.separator" ));
                    writer2.write(df.format(c[i].start_date)+System.getProperty( "line.separator" ));
                    writer2.write(Integer.toString(c[i].duration)+System.getProperty( "line.separator" ));
                    writer2.write(c[i].Co_ordinator.name+System.getProperty( "line.separator" ));
                    writer2.write(c[i].Co_ordinator.Department+System.getProperty( "line.separator" ));
                    writer2.write(c[i].Co_ordinator.address+System.getProperty( "line.separator" ));
                    writer2.write(c[i].Co_ordinator.email_id+System.getProperty( "line.separator" ));
                    writer2.write(c[i].Co_ordinator.mobile_no+System.getProperty( "line.separator" ));
                    writer2.write(Integer.toString(c[i].no_of_instructors)+System.getProperty( "line.separator" ));
                    writer2.write(Integer.toString(c[i].no_of_students)+System.getProperty( "line.separator" ));
                    int j;
                    for(j=0;j<c[i].no_of_instructors;++j)
                    {
                        writer2.write(c[i].instructors[j].name+System.getProperty( "line.separator" ));
                        writer2.write(c[i].instructors[j].Department+System.getProperty( "line.separator" ));
                        writer2.write(c[i].instructors[j].address+System.getProperty( "line.separator" ));
                        writer2.write(c[i].instructors[j].email_id+System.getProperty( "line.separator" ));
                        writer2.write(c[i].instructors[j].mobile_no+System.getProperty( "line.separator" ));
                    }
                    for(j=0;j<c[i].no_of_students;++j)
                    {
                        writer2.write(c[i].students[j].name+System.getProperty( "line.separator" ));
                        writer2.write(c[i].students[j].org_name+System.getProperty( "line.separator" ));
                        writer2.write(c[i].students[j].address+System.getProperty( "line.separator" ));
                        writer2.write(c[i].students[j].email_id+System.getProperty( "line.separator" ));
                        writer2.write(c[i].students[j].mobile_no+System.getProperty( "line.separator" ));
                    }
                }    
                writer2.flush();
                writer2.close();
    }
	public static int no_of_courses;
	public static int[] no_in_year;
	public static void increy(int p)
	{
		no_in_year[p]++;
	}
	public static void decrey(int p)
	{
		no_in_year[p]--;
	}
	
	static int getcurcourse()
	{
		//System.out.println(no_in_year[0]+no_in_year[1]+no_in_year[2]+no_in_year[3]+no_in_year[4]);
		return no_in_year[0]+no_in_year[1]+no_in_year[2]+no_in_year[3]+no_in_year[4];
	}
	
	public static void main(String[] args)throws IOException {
		int ch,i;
		  no_of_courses=0;
		  no_in_year=new int[5];
		  for(i=0;i<5;++i)no_in_year[i]=0;
	      
	      Date td=new Date();
	      SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	      df.setLenient(false);
	      int flag=1;
	      File f = new File("CourseManagement.txt");
	      
	      if(!f.exists() && !f.isDirectory())
	      {
	          f.createNewFile();
	          FileWriter writer =new FileWriter(f); 
	    
	          writer.write("0"); 
	          writer.flush();
	          writer.close();
	      }
	      try{
				Scanner rd1 = new Scanner(new FileReader("CourseManagement.txt"));
			      int x;
			      try{
			       x=Integer.parseInt(rd1.nextLine());}
			      catch(Exception e)
			      {x=0;}
			      rd1.close();
			      if(x!=0)
			      {
			          
			          
			          
			  		
			         
			          
			              Scanner rd = new Scanner(new FileReader("CourseManagement.txt"));
			              no_of_courses=Integer.parseInt(rd.nextLine());
			              for(int h=0;h<5;++h)
			            	  no_in_year[h]=Integer.parseInt(rd.nextLine());
			              int n3=no_of_courses,o;flag=0;
			              for(i=0,o=0;i<n3;++i)
			              {
			                   flag=1;
			                  String name=rd.nextLine();
			                  
			                  Long fs=Long.parseLong(rd.nextLine());
			                  Date  star=new Date();
			                  
			                  try{
			                  star=(Date)df.parse(rd.nextLine());}
			                  catch(Exception e){}
			                  int du=Integer.parseInt(rd.nextLine());
			                  String ncc=rd.nextLine();
			                  String ccd=rd.nextLine();
			                  String cca=rd.nextLine();
			                  String cce=rd.nextLine();
			                  long ccn=Long.parseLong(rd.nextLine());
			                  int n1=Integer.parseInt(rd.nextLine());
			                  int n2=Integer.parseInt(rd.nextLine());
			                  int j;
			                  Faculty f1[]=new Faculty[5];
			                  Faculty fc;
			                  Participant s[]=new Participant[5];
			                  fc=new Faculty(ccd,ncc,cca,cce,ccn,true);
			                  for(j=0;j<n1;++j)
			                  {
			                      ncc=rd.nextLine();
			                      ccd=rd.nextLine();
			                      cca=rd.nextLine();
			                      cce=rd.nextLine();
			                      ccn=Long.parseLong(rd.nextLine());
			                      f1[j]=new Faculty(ccd,ncc,cca,cce,ccn,false);
			                  }
			                  for(j=0;j<n2;++j)
			                  {
			                      ncc=rd.nextLine();
			                      ccd=rd.nextLine();
			                      cca=rd.nextLine();
			                      cce=rd.nextLine();
			                      ccn=Long.parseLong(rd.nextLine());
			                      s[j]=new Participant(ccd,ncc,cca,cce,ccn);
			                  }
			                  if(flag!=0){c[o]=new Course(name,star,fs,du,n1,n2,fc,f1,s);++o;}
			                  
			                      
			                  
			                  
			                  
			              }
			              
			          
			          
			      
			          
			      }
			      
				}catch(Exception e4){}
				
	      
	      
	      
	      
	      
	     
		
				try {
					GUIstcm frame = new GUIstcm();
					frame.setTitle("SHORT TERM COURSE MANAGEMENT");
					frame.setVisible(true);

					
					
					JLabel lblNewLabel = new JLabel("Select your Option");
					GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
					gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
					gbc_lblNewLabel.gridx = 4;
					gbc_lblNewLabel.gridy = 2;
					frame.contentPane.add(lblNewLabel, gbc_lblNewLabel);
					
					JRadioButton radioButton = new JRadioButton("Create new course");
					
					GridBagConstraints gbc_radioButton = new GridBagConstraints();
					gbc_radioButton.insets = new Insets(0, 0, 5, 5);
					gbc_radioButton.gridx = 3;
					gbc_radioButton.gridy = 9;
					frame.contentPane.add(radioButton, gbc_radioButton);
					
					JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Display all courses(within 5 years)");
					
					GridBagConstraints gbc_rdbtnNewRadioButton_3 = new GridBagConstraints();
					gbc_rdbtnNewRadioButton_3.insets = new Insets(0, 0, 5, 5);
					gbc_rdbtnNewRadioButton_3.gridx = 5;
					gbc_rdbtnNewRadioButton_3.gridy = 9;
					frame.contentPane.add(rdbtnNewRadioButton_3, gbc_rdbtnNewRadioButton_3);
					
					JRadioButton rdbtnNewRadioButton = new JRadioButton("Create new participants for a course");
					
					GridBagConstraints gbc_rdbtnNewRadioButton = new GridBagConstraints();
					gbc_rdbtnNewRadioButton.insets = new Insets(0, 0, 5, 5);
					gbc_rdbtnNewRadioButton.gridx = 3;
					gbc_rdbtnNewRadioButton.gridy = 10;
					frame.contentPane.add(rdbtnNewRadioButton, gbc_rdbtnNewRadioButton);
					
					JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("Display all participants registered for a course");
					
					GridBagConstraints gbc_rdbtnNewRadioButton_4 = new GridBagConstraints();
					gbc_rdbtnNewRadioButton_4.insets = new Insets(0, 0, 5, 5);
					gbc_rdbtnNewRadioButton_4.gridx = 5;
					gbc_rdbtnNewRadioButton_4.gridy = 10;
					frame.contentPane.add(rdbtnNewRadioButton_4, gbc_rdbtnNewRadioButton_4);
					
					JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Delete a course");
					
					GridBagConstraints gbc_rdbtnNewRadioButton_1 = new GridBagConstraints();
					gbc_rdbtnNewRadioButton_1.insets = new Insets(0, 0, 5, 5);
					gbc_rdbtnNewRadioButton_1.gridx = 3;
					gbc_rdbtnNewRadioButton_1.gridy = 11;
					frame.contentPane.add(rdbtnNewRadioButton_1, gbc_rdbtnNewRadioButton_1);
					
					JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("alter details of a course");
					
					GridBagConstraints gbc_rdbtnNewRadioButton_5 = new GridBagConstraints();
					gbc_rdbtnNewRadioButton_5.insets = new Insets(0, 0, 5, 5);
					gbc_rdbtnNewRadioButton_5.gridx = 5;
					gbc_rdbtnNewRadioButton_5.gridy = 11;
					frame.contentPane.add(rdbtnNewRadioButton_5, gbc_rdbtnNewRadioButton_5);
					
					JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("delete a Faculty");
					
					GridBagConstraints gbc_rdbtnNewRadioButton_2 = new GridBagConstraints();
					gbc_rdbtnNewRadioButton_2.insets = new Insets(0, 0, 5, 5);
					gbc_rdbtnNewRadioButton_2.gridx = 3;
					gbc_rdbtnNewRadioButton_2.gridy = 12;
					frame.contentPane.add(rdbtnNewRadioButton_2, gbc_rdbtnNewRadioButton_2);
					
					JRadioButton rdbtnNewRadioButton_6 = new JRadioButton("alter details of a Faculty");
					
					GridBagConstraints gbc_rdbtnNewRadioButton_6 = new GridBagConstraints();
					gbc_rdbtnNewRadioButton_6.insets = new Insets(0, 0, 5, 5);
					gbc_rdbtnNewRadioButton_6.gridx = 5;
					gbc_rdbtnNewRadioButton_6.gridy = 12;
					frame.contentPane.add(rdbtnNewRadioButton_6, gbc_rdbtnNewRadioButton_6);
					
					JRadioButton rdbtnNewRadioButton_7 = new JRadioButton("delete a participant");
					
					GridBagConstraints gbc_rdbtnNewRadioButton_7 = new GridBagConstraints();
					gbc_rdbtnNewRadioButton_7.insets = new Insets(0, 0, 5, 5);
					gbc_rdbtnNewRadioButton_7.gridx = 3;
					gbc_rdbtnNewRadioButton_7.gridy = 13;
					frame.contentPane.add(rdbtnNewRadioButton_7, gbc_rdbtnNewRadioButton_7);
					
					JRadioButton rdbtnNewRadioButton_8 = new JRadioButton("alter details of a participant");
					
					GridBagConstraints gbc_rdbtnNewRadioButton_8 = new GridBagConstraints();
					gbc_rdbtnNewRadioButton_8.insets = new Insets(0, 0, 5, 5);
					gbc_rdbtnNewRadioButton_8.gridx = 5;
					gbc_rdbtnNewRadioButton_8.gridy = 13;
					frame.contentPane.add(rdbtnNewRadioButton_8, gbc_rdbtnNewRadioButton_8);
					
					JRadioButton rdbtnNewRadioButton_9 = new JRadioButton("create new instructors for a course");
					
					
					GridBagConstraints gbc_rdbtnNewRadioButton_9 = new GridBagConstraints();
					gbc_rdbtnNewRadioButton_9.insets = new Insets(0, 0, 5, 5);
					gbc_rdbtnNewRadioButton_9.gridx = 3;
					gbc_rdbtnNewRadioButton_9.gridy = 14;
					frame.contentPane.add(rdbtnNewRadioButton_9, gbc_rdbtnNewRadioButton_9);
					JRadioButton rdbtnExit = new JRadioButton("Exit");
					GridBagConstraints gbc_rdbtnExit = new GridBagConstraints();
					gbc_rdbtnExit.insets = new Insets(0, 0, 5, 5);
					gbc_rdbtnExit.gridx = 5;
					gbc_rdbtnExit.gridy = 14;
					frame.contentPane.add(rdbtnExit, gbc_rdbtnExit);
					ButtonGroup bG = new ButtonGroup();
					bG.add(radioButton);
					bG.add(rdbtnNewRadioButton);		
					bG.add(rdbtnNewRadioButton_1);
					bG.add(rdbtnNewRadioButton_2);
					bG.add(rdbtnNewRadioButton_3);
					bG.add(rdbtnNewRadioButton_4);
					bG.add(rdbtnNewRadioButton_5);
					bG.add(rdbtnNewRadioButton_6);
					bG.add(rdbtnNewRadioButton_7);
					bG.add(rdbtnNewRadioButton_8);
					bG.add(rdbtnNewRadioButton_9);
					bG.add(rdbtnExit);
					JButton btnRet = new JButton("Delete old Records");
					GridBagConstraints gbc_btnRet = new GridBagConstraints();
					gbc_btnRet.insets = new Insets(0, 0, 0, 5);
					gbc_btnRet.gridx = 4;
					gbc_btnRet.gridy = 0;
					frame.contentPane.add(btnRet, gbc_btnRet);
					btnRet.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent arg0) {
							FileWriter writer;
							try {
								
								no_of_courses=0;
								writer = new FileWriter("CourseManagement.txt");
								writer.write("0"); 
						          writer.flush();
						          writer.close();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} 
						    
					          
							
						}});
					JButton btnEnter = new JButton("Done");
					GridBagConstraints gbc_btnEnter = new GridBagConstraints();
					gbc_btnEnter.insets = new Insets(0, 0, 0, 5);
					gbc_btnEnter.gridx = 4;
					gbc_btnEnter.gridy = 15;
					frame.contentPane.add(btnEnter, gbc_btnEnter);
					btnEnter.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent arg0) {
							try{
							flowcheck();
							String str=getSelectedButtonText(bG);
							if(str.compareTo("Create new course")==0)
							{
								 
								flow=1;
								writefile(c,no_of_courses,no_in_year);
										try {
											EnterC frame= new EnterC(c,no_of_courses,no_in_year);	
												//frame.setVisible(true);
											
											
										} catch (Exception e) {
											e.printStackTrace();
										}
										
										
									
								
								
								
							}
							else if(str.compareTo("Display all courses(within 5 years)")==0)
							{
								
								flow=2;
								writefile(c,no_of_courses,no_in_year);
										
									
											try {
												DisplayCourseOp frame;
											    if(getcurcourse()==0)
											    {
											    	JOptionPane.showMessageDialog(null,"There are currently no courses in 5 years","Invalid",JOptionPane.PLAIN_MESSAGE);
											    }
											    else
												frame=new DisplayCourseOp(c,no_of_courses,1);
												
											} catch (Exception e) {
												e.printStackTrace();
											}
										
								
								
							}
							else if(str.compareTo("Delete a course")==0)
							 {
								flow=3; k=-1;
							      String[] data = new String[no_of_courses];
							      writefile(c,no_of_courses,no_in_year);
							      DisplayCourseOp frame;
								    if(getcurcourse()==0)
								    {
								    	JOptionPane.showMessageDialog(null,"There are currently no courses in 5 years","Invalid",JOptionPane.PLAIN_MESSAGE);
								    }
								    else
							       frame=new DisplayCourseOp(c,no_of_courses,2);
							   }
							else if(str.compareTo("Create new participants for a course")==0)
							{
								flowcheck();
								writefile(c,no_of_courses,no_in_year);
								flow=4;int k=-1;
								DisplayCourseOp frame;
							    if(getcurcourse()==0)
							    {
							    	JOptionPane.showMessageDialog(null,"There are currently no courses in 5 years","Invalid",JOptionPane.PLAIN_MESSAGE);
							    }
							    else
							      
								 frame=new DisplayCourseOp(c,no_of_courses,4);
							   
								
							
							}
							
							
							else if(str.compareTo("Display all participants registered for a course")==0)
							{
								writefile(c,no_of_courses,no_in_year);
								flowcheck();
								flow=4;int k=-1;
								int ch;
							
								DisplayCourseOp frame;
							    if(getcurcourse()==0)
							    {
							    	JOptionPane.showMessageDialog(null,"There are currently no courses in 5 years","Invalid",JOptionPane.PLAIN_MESSAGE);
							    }
							    else
								 frame=new DisplayCourseOp(c,no_of_courses,5);
							}
							else if(str.compareTo("delete a participant")==0)
							{
								writefile(c,no_of_courses,no_in_year);
								flowcheck();
								flow=4;int k=-1;
								int ch;
							
								DisplayCourseOp frame;
							    if(getcurcourse()==0)
							    {
							    	JOptionPane.showMessageDialog(null,"There are currently no courses in 5 years","Invalid",JOptionPane.PLAIN_MESSAGE);
							    }
							    else
								 frame=new DisplayCourseOp(c,no_of_courses,3);
							}
							else if(str.compareTo("alter details of a course")==0)
							{
								flow=6; k=-1;
								writefile(c,no_of_courses,no_in_year);
								DisplayCourseOp frame;
							    if(getcurcourse()==0)
							    {
							    	JOptionPane.showMessageDialog(null,"There are currently no courses in 5 years","Invalid",JOptionPane.PLAIN_MESSAGE);
							    }
							    else
								 frame=new DisplayCourseOp(c,no_of_courses,6);
								
							}
							else if(str.compareTo("alter details of a participant")==0)
							{
								flowcheck();
								writefile(c,no_of_courses,no_in_year);
								flow=5;int k=-1;
								DisplayCourseOp frame;
							    if(getcurcourse()==0)
							    {
							    	JOptionPane.showMessageDialog(null,"There are currently no courses in 5 years","Invalid",JOptionPane.PLAIN_MESSAGE);
							    }
							    else
								 frame=new DisplayCourseOp(c,no_of_courses,7);
							}
							else if(str.compareTo("create new instructors for a course")==0)
							{
								writefile(c,no_of_courses,no_in_year);
								flowcheck();
								flow=8;int k=-1;
								DisplayCourseOp frame;
							    if(getcurcourse()==0)
							    {
							    	JOptionPane.showMessageDialog(null,"There are currently no courses in 5 years","Invalid",JOptionPane.PLAIN_MESSAGE);
							    }
							    else 
								 frame=new DisplayCourseOp(c,no_of_courses,8);
							   
								
							
							}
							else if(str.compareTo("delete a Faculty")==0)
							{
								writefile(c,no_of_courses,no_in_year);
								flowcheck();
								flow=5;int k=-1;
								DisplayCourseOp frame;
							    if(getcurcourse()==0)
							    {
							    	JOptionPane.showMessageDialog(null,"There are currently no courses in 5 years","Invalid",JOptionPane.PLAIN_MESSAGE);
							    }
							    else 
								 frame=new DisplayCourseOp(c,no_of_courses,9);
							}
							else if(str.compareTo("alter details of a Faculty")==0)
							{
								flowcheck();
								writefile(c,no_of_courses,no_in_year);
								flow=10;int k=-1;
								DisplayCourseOp frame;
							    if(getcurcourse()==0)
							    {
							    	JOptionPane.showMessageDialog(null,"There are currently no courses in 5 years","Invalid",JOptionPane.PLAIN_MESSAGE);
							    }
							    else
								 frame=new DisplayCourseOp(c,no_of_courses,10);
								
							}
							else
							{
								flowcheck();
								writefile(c,no_of_courses,no_in_year);
								frame.dispose();
							}
							
							
							
						}
							catch(Exception e){frame.dispose();}
						}
					});
					
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
			
	}

	/**
	 * Create the frame.
	 */
	public static String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }
        return null;
        }
	public GUIstcm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0,1000, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(173, 216, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel_1 = new JLabel("Short Term Course Management");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		gbc_lblNewLabel_1.insets = new Insets(0, 0,5,5);
		gbc_lblNewLabel_1.gridx = 4;
		gbc_lblNewLabel_1.gridy = -2;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		
		
		
		
		
		
	}
	static void flowcheck()throws IOException
	{
		writefile(c,no_of_courses,no_in_year);
		
		
	}

}
