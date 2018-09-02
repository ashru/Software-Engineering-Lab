package CList;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class Deletecon1 extends JPanel {

	private JTextField textField;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public Deletecon1(FullContactList L,JPanel p) {
		//setVisible(true);
	
		setBounds(100, 100, 450, 300);
		
		setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(233, 42, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblEnterName = new JLabel("Enter Name");
		lblEnterName.setBounds(67, 45, 86, 17);
		add(lblEnterName);
		
		JButton btnSearch = new JButton("Delete");
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);
				p.setVisible(true);
				String s=textField.getText();
				int t1=-1,t2=-1,t3=-1,t4=-1;
				if(L.rel>0)
	                t1=searchrel(s,L.r,L.rel,0);
	                if(L.per>0)
	                t2=searchper(s,L.p,L.per,0);
	                if(L.prof>0)
	                t3=searchprof(s,L.f,L.prof,0);
	                if(L.cas>0)
	                t4=searchcas(s,L.c,L.cas,0);
	                if(t1!=-1)
	                {
	                    deleterel(L.r,L.rel,t1);
	                    --L.tot;
	                    --L.rel;
	                    try {
	                    	ContactListApplet2.Filewriter(L);
	            		} catch (IOException e) {
	            			// TODO Auto-generated catch block
	            			e.printStackTrace();
	            		}
	                }
	                
	                if(t2!=-1)
	                {
	                    deleteper(L.p,L.per,t2);
	                    --L.tot;
	                    --L.per;
	                    try {
	                    	ContactListApplet2.Filewriter(L);
	            		} catch (IOException e) {
	            			// TODO Auto-generated catch block
	            			e.printStackTrace();
	            		}
	                }
	               
	                if(t3!=-1)
	                {
	                    deleteprof(L.f,L.prof,t3);
	                    --L.prof;--L.tot;
	                    try {
	                    	ContactListApplet2.Filewriter(L);
	            		} catch (IOException e) {
	            			// TODO Auto-generated catch block
	            			e.printStackTrace();
	            		}
	                }
	                
	                if(t4!=-1)
	                {
	                    deletecas(L.c,L.cas,t4);
	                    --L.cas;
	                    --L.tot;
	                    try {
	                    	ContactListApplet2.Filewriter(L);
	            		} catch (IOException e) {
	            			// TODO Auto-generated catch block
	            			e.printStackTrace();
	            		}
	                }
	                if(t1==-1 && t2==-1 && t3==-1 && t4==-1)
	                	JOptionPane.showMessageDialog(null,"Contact does not exist in the list","Acquaintance Not Found",JOptionPane.PLAIN_MESSAGE);
	                else
	                	JOptionPane.showMessageDialog(null,"Contact "+s+" Deleted","Deletion Sucessful",JOptionPane.PLAIN_MESSAGE);
	                try {
	                	ContactListApplet2.Filewriter(L);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	                }
		});
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSearch.setBounds(169, 170, 89, 23);
		add(btnSearch);
		
	}
	static int searchrel(String n,relatives r[],int i,int x)
    {
        int l=0;int h=i-1;
        while(h>=l)
        {
            int m=(h+l)/2;
            if(r[m].getname().equals(n)==true)
            {
            	if(x==1)
                {
                	String str=r[m].getdetails();
                	JOptionPane.showMessageDialog(null,str,"Acquaintance Found in Relatives:Details",JOptionPane.PLAIN_MESSAGE);
                	
                }
                return m;
            }
            if(n.compareTo(r[m].getname())<0)
            {
                h=m-1;
            }
            else
                l=m+1;
            
        }
        return -1;
        
    }
    static int searchper(String n,personalFriends r[],int i,int x)
    {
        int l=0;int h=i-1;
        while(h>=l)
        {
            int m=(h+l)/2;
            if(r[m].getname().equals(n)==true)
            {
            	if(x==1)
                {
                	String str=r[m].getdetails();
                	JOptionPane.showMessageDialog(null,str,"Acquaintance Found i Personal Friends:Details",JOptionPane.PLAIN_MESSAGE);
                	
                }
                return m;
            }
            if(n.compareTo(r[m].getname())<0)
            {
                h=m-1;
            }
            else
                l=m+1;
            
        }
        return -1;
        
    }
    static int searchprof(String n,professionalFriends r[],int i,int x)
    {
        int l=0;int h=i-1;
        while(h>=l)
        {
            int m=(h+l)/2;
            
            if(r[m].getname().equals(n)==true)
            {
            	if(x==1)
                {
                	String str=r[m].getdetails();
                	JOptionPane.showMessageDialog(null,str,"Acquaintance Found in Professional Friends:Details",JOptionPane.PLAIN_MESSAGE);
                	
                }
                return m;
            }
            if(n.compareTo(r[m].getname())<0)
            {
                h=m-1;
            }
            else
                l=m+1;
            
        }
        return -1;
        
    }
    static int searchcas(String n,casualAq r[],int i,int x)
    {
        int l=0;int h=i-1;
        while(h>=l)
        {
            int m=(h+l)/2;
            if(r[m].getname().equals(n)==true)
            {
                if(x==1)
                {
                	String str=r[m].getdetails();
                	JOptionPane.showMessageDialog(null,str,"Acquaintance Found in Casual Acquaintances:Details",JOptionPane.PLAIN_MESSAGE);
                	
                }
                return m;
            }
            if(n.compareTo(r[m].getname())<0)
            {
                h=m-1;
            }
            else
                l=m+1;
            
        }
        return -1;
        
    }
    static void deleterel(relatives r[],int n,int ind)
    {
        int i;
        for(i=ind;i<n-1;++i)
            r[i]=r[i+1];
        
    }
    static void deleteper(personalFriends r[],int n,int ind)
    {
        int i;
        for(i=ind;i<n-1;++i)
            r[i]=r[i+1];
    }
    static void deleteprof(professionalFriends r[],int n,int ind)
    {
        int i;
        for(i=ind;i<n-1;++i)
            r[i]=r[i+1];
    }
    static void deletecas(casualAq r[],int n,int ind)
    {
        int i;
        for(i=ind;i<n-1;++i)
            r[i]=r[i+1];
    }
}
