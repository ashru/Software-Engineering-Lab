package CList;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JApplet;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ContactListApplet2 extends JApplet {
	static FullContactList L;
	static DisplayContacts d;
	static selectCat1 frame;
	static selectCat1 frame2;
	static Deletecon1 d2;
	static searchCon1 s;
	public static JPanel panel;
	/**
	 * Create the applet.
	 */
	static void Filewriter(FullContactList L)throws IOException
    {
        DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
        df.setLenient(false);
        int i;
       File f2 = new File("ContactList.txt");
                FileWriter writer2 = new FileWriter(f2);
                writer2.write(Integer.toString(L.tot)+System.getProperty( "line.separator" ));
                writer2.write(Integer.toString(L.rel)+System.getProperty( "line.separator" ));
                writer2.write(Integer.toString(L.per)+System.getProperty( "line.separator" ));
                writer2.write(Integer.toString(L.prof)+System.getProperty( "line.separator" ));
                writer2.write(Integer.toString(L.cas)+System.getProperty( "line.separator" ));
                
               
        for(i=0;i<L.rel;++i)
        {
                writer2.write(L.r[i].getname()+System.getProperty( "line.separator" ));
                writer2.write(L.r[i].getemail()+System.getProperty( "line.separator" ));
                writer2.write(Long.toString(L.r[i].getmob())+System.getProperty( "line.separator" ));
                writer2.write(df.format(L.r[i].getbd())+System.getProperty( "line.separator" ));
                writer2.write(df.format(L.r[i].getd())+System.getProperty( "line.separator" ));
                
        }
        for(i=0;i<L.per;++i)
        {
                
                writer2.write(L.p[i].getname()+System.getProperty( "line.separator" ));
                writer2.write(L.p[i].getemail()+System.getProperty( "line.separator" ));
                writer2.write(Long.toString(L.p[i].getmob())+System.getProperty( "line.separator" ));
                writer2.write(L.p[i].getcon()+System.getProperty( "line.separator" ));
                writer2.write(L.p[i].getevent()+System.getProperty( "line.separator" ));
                writer2.write(df.format(L.p[i].getdate())+System.getProperty( "line.separator" ));
                
        }
        for(i=0;i<L.prof;++i)
        {
                
                writer2.write(L.f[i].getname()+System.getProperty( "line.separator" ));
                writer2.write(L.f[i].getemail()+System.getProperty( "line.separator" ));
                writer2.write(Long.toString(L.f[i].getmob())+System.getProperty( "line.separator" ));
                writer2.write(L.f[i].getscpi()+System.getProperty( "line.separator" ));
                
        }
        for(i=0;i<L.cas;++i)
        {
                
                writer2.write(L.c[i].getname()+System.getProperty( "line.separator" ));
                writer2.write(L.c[i].getemail()+System.getProperty( "line.separator" ));
                writer2.write(Long.toString(L.c[i].getmob())+System.getProperty( "line.separator" ));
                writer2.write(df.format(L.c[i].getwhen())+System.getProperty( "line.separator" ));
                writer2.write(L.c[i].getwhere()+System.getProperty( "line.separator" ));
                writer2.write(L.c[i].getcir()+System.getProperty( "line.separator" ));
                writer2.write(L.c[i].getinfo()+System.getProperty( "line.separator" ));
                         
       }
                
                writer2.flush();
                writer2.close();
                 
    }
	public ContactListApplet2() throws IOException {
File f1 = new File("ContactList.txt");
        
        /*if(!f1.exists() && !f1.isDirectory())
        {
            f1.createNewFile();
            FileWriter writer =new FileWriter(f1); 
      
            writer.write("0"); 
            writer.flush();
            writer.close();
        }
		*/
		JLayeredPane layeredPane=new JLayeredPane();
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 255, 255));
		panel.setForeground(new Color(0, 0, 0));
		getContentPane().add(layeredPane, BorderLayout.CENTER);
		layeredPane.add(panel,0);
		panel.setBounds(0, 0, 450, 300);
		panel.setVisible(true);
		L=new FullContactList();
		
		panel.setLayout(null);
		/*
		 
		  */
		
			 DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
		        df.setLenient(false);
		        int x;
			try{
				Scanner rd1;
				try{
				rd1 = new Scanner(new FileReader("ContactList.txt"));
				x=Integer.parseInt(rd1.nextLine());

				rd1.close();}
				catch(FileNotFoundException e)
				{
					x=0;
				}


 
if(x!=0)
{
	 


    
        Scanner rd = new Scanner(new FileReader("ContactList.txt"));
        
        L.tot=Integer.parseInt(rd.nextLine());
        L.rel=Integer.parseInt(rd.nextLine());
        L.per=Integer.parseInt(rd.nextLine());
        L.prof=Integer.parseInt(rd.nextLine());
        L.cas=Integer.parseInt(rd.nextLine());
        int i;
for(i=0;i<L.rel;++i)
{

String n=rd.nextLine();
String em=rd.nextLine();
long m=0;
m=Long.parseLong(rd.nextLine());
Date d=new Date();
d=df.parse(rd.nextLine());
Date d1=new Date();
d1=df.parse(rd.nextLine());
L.r[i]=new relatives(d,d1,n,em,m);

}
for(i=0;i<L.per;++i)
{

String n=rd.nextLine();
String em=rd.nextLine();
long m=0;Date d=new Date();
m=Long.parseLong(rd.nextLine());
String c1=rd.nextLine();
String e1=rd.nextLine();
d=df.parse(rd.nextLine());
L.p[i]=new personalFriends(c1,e1,d,n,em,m);
}
for(i=0;i<L.prof;++i)
{

String n=rd.nextLine();
String em=rd.nextLine();
long m=0;
m=Long.parseLong(rd.nextLine());
String c1=rd.nextLine();
L.f[i]=new professionalFriends(c1,n,em,m);
}
for(i=0;i<L.cas;++i)
{

String n=rd.nextLine();
String em=rd.nextLine();
long m=0;
m=Long.parseLong(rd.nextLine());
Date d=new Date();
d=df.parse(rd.nextLine());
String w=rd.nextLine();
String cir=rd.nextLine();
String in=rd.nextLine();
L.c[i]=new casualAq(w,cir,in,d,n,em,m);         
}

}  
				}catch(Exception e4){e4.printStackTrace();}
		
		JButton btnNewButton = new JButton("Choose");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setFont(new Font("Sylfaen", Font.ITALIC, 11));
		btnNewButton.setBounds(185, 228, 89, 23);
		panel.add(btnNewButton);
		
		JRadioButton rdbtnCreateNewContact = new JRadioButton("Create new contact");
		rdbtnCreateNewContact.setBounds(24, 120, 174, 23);
		panel.add(rdbtnCreateNewContact);
		
		JRadioButton rdbtnDisplayLlContacts = new JRadioButton("Display all contacts");
		rdbtnDisplayLlContacts.setBounds(291, 120, 153, 23);
		panel.add(rdbtnDisplayLlContacts);
		
		JRadioButton rdbtnDisplayContactsCategoriwise = new JRadioButton("Display contacts categorywise");
		rdbtnDisplayContactsCategoriwise.setBounds(24, 156, 237, 23);
		panel.add(rdbtnDisplayContactsCategoriwise);
		
		JRadioButton rdbtnSearchForA = new JRadioButton("Search for a contact");
		rdbtnSearchForA.setBounds(291, 156, 153, 23);
		panel.add(rdbtnSearchForA);
		
		JRadioButton rdbtnDeleteAContact = new JRadioButton("Delete a contact");
		rdbtnDeleteAContact.setBounds(24, 195, 204, 23);
		panel.add(rdbtnDeleteAContact);
		
		JRadioButton rdbtnExit = new JRadioButton("Delete existing record");
		rdbtnExit.setBounds(291, 195, 153, 23);
		panel.add(rdbtnExit);
		
		JLabel lblContactListApplet = new JLabel("Contact List Applet");
		lblContactListApplet.setForeground(new Color(102, 0, 204));
		lblContactListApplet.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		lblContactListApplet.setBounds(135, 11, 177, 58);
		panel.add(lblContactListApplet);
		ButtonGroup bG = new ButtonGroup();
		bG.add(rdbtnCreateNewContact);
		bG.add(rdbtnSearchForA);		
		bG.add(rdbtnDeleteAContact);
		
		bG.add(rdbtnExit);
		bG.add( rdbtnDisplayContactsCategoriwise);
		
		bG.add( rdbtnDisplayLlContacts);
		
		
		
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try{
				
					String str=getSelectedButtonText(bG);
					if(str.compareTo("Create new contact")==0)
					{
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									frame = new selectCat1(L,1,layeredPane,panel);
									layeredPane.add(frame,1);
									panel.setVisible(false);
									frame.setVisible(true);
									frame.setBounds(0, 0, 450, 300);
									
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
						
					}
					else if(str.compareTo("Search for a contact")==0)
					{
						
						s=new searchCon1(L,panel);
						layeredPane.add(s,1);
						panel.setVisible(false);
						s.setVisible(true);
						s.setBounds(0, 0, 450, 300);
						
						
					}
					else if(str.compareTo("Delete a contact")==0)
					{
						d2=new Deletecon1(L,panel);
						layeredPane.add(d2,1);
						panel.setVisible(false);
						d2.setVisible(true);
						d2.setBounds(0, 0, 450, 300);
						
					}
					else if(str.compareTo("Display all contacts")==0)
					{
						if(L.tot==0)
						{
							JOptionPane.showMessageDialog(null,"There are no contacts to display!","No contacts",JOptionPane.PLAIN_MESSAGE);
						}
						else{
						d=new DisplayContacts(L,1,panel);
						layeredPane.add(d,1);
						panel.setVisible(false);
						d.setVisible(true);
						d.setBounds(0, 0, 450, 300);
						}
						/*d=new DisplayContacts1(layeredPane);
						layeredPane.add(d,1);
						panel.setVisible(false);
						d.setVisible(true);
						d.setBounds(0, 0, 450, 300);*/
						
					}
					else if(str.compareTo("Display contacts categorywise")==0)
					{
						frame2 = new selectCat1(L,2,layeredPane,panel);
						layeredPane.add(frame2,1);
						panel.setVisible(false);
						frame2.setVisible(true);
						frame2.setBounds(0, 0, 450, 300);
					}
					else if(str.compareTo("Delete existing record")==0)
					{
						FileWriter writer;
						try {
							L.tot=0;
							L.per=0;
							L.rel=0;
							L.cas=0;
							L.prof=0;
							writer = new FileWriter("ContactList.txt");
							writer.write("0"); 
					          writer.flush();
					          writer.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} 
					}
					
					
					}
				catch(Exception e){}
				}
			


	
	
});
	
	

	}
	public static  String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }
        return null;
	}
}
