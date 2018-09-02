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
import java.awt.Color;
import java.awt.Font;

public class searchCon extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblSearchForA;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public searchCon(FullContactList L) {
		setVisible(true);
		setTitle("Search for a contact");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 204, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(237, 67, 187, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblEnterName = new JLabel("Enter Name");
		lblEnterName.setBounds(67, 69, 86, 17);
		contentPane.add(lblEnterName);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String s=textField.getText();
				int t1=-1,t2=-1,t3=-1,t4=-1;
				if(L.rel>0)
	                t1=searchrel(s,L.r,L.rel,1);
	                if(L.per>0)
	                t2=searchper(s,L.p,L.per,1);
	                if(L.prof>0)
	                t3=searchprof(s,L.f,L.prof,1);
	                if(L.cas>0)
	                t4=searchcas(s,L.c,L.cas,1);
	                if(t1==-1 && t2==-1 && t3==-1 && t4==-1)
	                	JOptionPane.showMessageDialog(null,"Contact does not exist in the list","Acquaintance Not Found",JOptionPane.PLAIN_MESSAGE);			}
		});
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSearch.setBounds(169, 170, 89, 23);
		contentPane.add(btnSearch);
		
		lblSearchForA = new JLabel("Search For a Contact");
		lblSearchForA.setForeground(new Color(204, 0, 153));
		lblSearchForA.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD | Font.ITALIC, 16));
		lblSearchForA.setBounds(112, 11, 221, 45);
		contentPane.add(lblSearchForA);
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
                	JOptionPane.showMessageDialog(null,str,"Found in Relatives:Details",JOptionPane.PLAIN_MESSAGE);
                	
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
                	JOptionPane.showMessageDialog(null,str,"Found in Personal Friends:Details",JOptionPane.PLAIN_MESSAGE);
                	
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
                	JOptionPane.showMessageDialog(null,str,"Found in Professional Friends:Details",JOptionPane.PLAIN_MESSAGE);
                	
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
                	JOptionPane.showMessageDialog(null,str,"Found in Casual Acquaintances:Details",JOptionPane.PLAIN_MESSAGE);
                	
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
