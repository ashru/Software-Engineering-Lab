package CList;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Scanner;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import java.awt.Color;



public class GUIclist extends JFrame {
	static final int MAX=1000;

	private JPanel contentPane;
	public static int tot,rel,per,prof,cas;
	static relatives r[]=new relatives[MAX];
	static personalFriends p[]=new personalFriends[MAX];
	static professionalFriends f[]=new professionalFriends[MAX];
	static casualAq c[]=new casualAq[MAX];
	static FullContactList L;
	
	
	/**
	 * Launch the application.
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
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIclist frame = new GUIclist();
					frame.setVisible(true);
					
						frame.setTitle("CONTACT LIST");
						frame.setVisible(true);
						 DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
					        df.setLenient(false);

						
						
						JLabel lblNewLabel = new JLabel("Select your Option");
						GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
						gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
						gbc_lblNewLabel.gridx = 4;
						gbc_lblNewLabel.gridy = 2;
						frame.contentPane.add(lblNewLabel, gbc_lblNewLabel);
						
						JRadioButton radioButton = new JRadioButton("Create new Contact");
						
						GridBagConstraints gbc_radioButton = new GridBagConstraints();
						gbc_radioButton.insets = new Insets(0, 0, 5, 5);
						gbc_radioButton.gridx = 3;
						gbc_radioButton.gridy = 9;
						frame.contentPane.add(radioButton, gbc_radioButton);
						
						JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Display all Contacts");
						
						GridBagConstraints gbc_rdbtnNewRadioButton_3 = new GridBagConstraints();
						gbc_rdbtnNewRadioButton_3.insets = new Insets(0, 0, 5, 5);
						gbc_rdbtnNewRadioButton_3.gridx = 5;
						gbc_rdbtnNewRadioButton_3.gridy = 9;
						frame.contentPane.add(rdbtnNewRadioButton_3, gbc_rdbtnNewRadioButton_3);
						
						JRadioButton rdbtnNewRadioButton = new JRadioButton("Search for a contact");
						
						GridBagConstraints gbc_rdbtnNewRadioButton = new GridBagConstraints();
						gbc_rdbtnNewRadioButton.insets = new Insets(0, 0, 5, 5);
						gbc_rdbtnNewRadioButton.gridx = 3;
						gbc_rdbtnNewRadioButton.gridy = 10;
						frame.contentPane.add(rdbtnNewRadioButton, gbc_rdbtnNewRadioButton);
						
						JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("Display contacts of a paticular category");
						
						GridBagConstraints gbc_rdbtnNewRadioButton_4 = new GridBagConstraints();
						gbc_rdbtnNewRadioButton_4.insets = new Insets(0, 0, 5, 5);
						gbc_rdbtnNewRadioButton_4.gridx = 5;
						gbc_rdbtnNewRadioButton_4.gridy = 10;
						frame.contentPane.add(rdbtnNewRadioButton_4, gbc_rdbtnNewRadioButton_4);
						
						JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Delete a Contact");
						
						GridBagConstraints gbc_rdbtnNewRadioButton_1 = new GridBagConstraints();
						gbc_rdbtnNewRadioButton_1.insets = new Insets(0, 0, 5, 5);
						gbc_rdbtnNewRadioButton_1.gridx = 3;
						gbc_rdbtnNewRadioButton_1.gridy = 11;
						frame.contentPane.add(rdbtnNewRadioButton_1, gbc_rdbtnNewRadioButton_1);
						
						JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("Exit");
						
						GridBagConstraints gbc_rdbtnNewRadioButton_5 = new GridBagConstraints();
						gbc_rdbtnNewRadioButton_5.insets = new Insets(0, 0, 5, 5);
						gbc_rdbtnNewRadioButton_5.gridx = 5;
						gbc_rdbtnNewRadioButton_5.gridy = 11;
						frame.contentPane.add(rdbtnNewRadioButton_5, gbc_rdbtnNewRadioButton_5);
						
						
						ButtonGroup bG = new ButtonGroup();
						bG.add(radioButton);
						bG.add(rdbtnNewRadioButton);		
						bG.add(rdbtnNewRadioButton_1);
						
						bG.add(rdbtnNewRadioButton_3);
						bG.add(rdbtnNewRadioButton_4);
						
						bG.add(rdbtnNewRadioButton_5);
						JButton btnRet = new JButton("Delete old Records");
						GridBagConstraints gbc_btnRet = new GridBagConstraints();
						gbc_btnRet.insets = new Insets(0, 0, 0, 5);
						gbc_btnRet.gridx = 4;
						gbc_btnRet.gridy = 0;
						frame.contentPane.add(btnRet, gbc_btnRet);
						L=new FullContactList();
						try{
							Scanner rd1 = new Scanner(new FileReader("ContactList.txt"));
    

    int x=Integer.parseInt(rd1.nextLine());
    rd1.close();
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
							}catch(Exception e4){}
						btnRet.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent arg0) {
								L.tot=0;
								L.rel=0;
								L.cas=0;
								L.prof=0;
								L.per=0;
								FileWriter writer;
								try {
									writer = new FileWriter("ContactList.txt");
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
								
								String str=getSelectedButtonText(bG);
								if(str.compareTo("Create new Contact")==0)
								{
									EventQueue.invokeLater(new Runnable() {
										public void run() {
											try {
												selectCat frame = new selectCat(L,1);
												frame.setVisible(true);
											} catch (Exception e) {
												e.printStackTrace();
											}
										}
									});
									
								}
								else if(str.compareTo("Search for a contact")==0)
								{
									searchCon s=new searchCon(L);
									
									
								}
								else if(str.compareTo("Delete a Contact")==0)
								{
									
									Deletecon d=new Deletecon(L);
									
								}
								else if(str.compareTo("Display all Contacts")==0)
								{
									DispContOP d=new DispContOP(L,1);
									
									
								}
								else if(str.compareTo("Display contacts of a paticular category")==0)
								{
									selectCat frame = new selectCat(L,2);
									
								}
								else
								{
									
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
		});
	}

	/**
	 * Create the frame.
	 */
	public GUIclist() {
		setTitle("CONTACT LIST\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 752, 296);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 204, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		
		
		
		
	}
	public static String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }
        return null;
        }


}
