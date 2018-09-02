package CList;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class DisplayContacts extends JPanel {

	
	static ButtonGroup bg=new ButtonGroup();

	public DisplayContacts(FullContactList L,int f,JPanel p) {
		setBackground(new Color(204, 255, 102));
		setForeground(new Color(255, 0, 0));
		
		int i;
		
		
		
		
		setBounds(100,100,439,298);
		
		
		setLayout(null);
		JLabel lbl1=new JLabel("Choose your option");
		lbl1.setFont(new Font("Segoe UI Semilight",Font.PLAIN,12 ));
		lbl1.setBounds(10, 11, 414, 23);
		add(lbl1);
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(56, 223, 89, 23);
		add(btnBack);
		if(f==1){
		for(i=0;i<L.tot;++i)
		{
			JRadioButton b;
			if(i<L.rel)
			
			{b=new JRadioButton(L.r[i].name);}
			else if(i<L.per+L.rel)
				b=new JRadioButton(L.p[i-L.rel].name);
			else if(i<L.per+L.rel+L.prof)
				b=new JRadioButton(L.f[i-L.per-L.rel].name);
			else
				b=new JRadioButton(L.c[i-L.per-L.rel-L.prof].name);
			
			b.setActionCommand(""+i);
			
			if(i==0)
			{
				b.setSelected(true);
			}
			b.setBounds(10,34+24*i,418,23);
			add(b);
			bg.add(b);
			
		}}
		if(f==2)
		{
			for(i=0;i<L.rel;++i)
			{
				JRadioButton b;
				b=new JRadioButton(L.r[i].name);
				
				
				b.setActionCommand(""+i);
				
				if(i==0)
				{
					b.setSelected(true);
				}
				b.setBounds(10,34+24*i,418,23);
				add(b);
				bg.add(b);
				
			}	
		}
		if(f==3)
		{
			for(i=0;i<L.per;++i)
			{
				JRadioButton b;
				b=new JRadioButton(L.p[i].name);
				
				
				b.setActionCommand(""+i);
				
				if(i==0)
				{
					b.setSelected(true);
				}
				b.setBounds(10,34+24*i,418,23);
				add(b);
				bg.add(b);
				
			}	
		}
		if(f==4)
		{
			for(i=0;i<L.prof;++i)
			{
				JRadioButton b;
				b=new JRadioButton(L.f[i].name);
				
				
				b.setActionCommand(""+i);
				
				if(i==0)
				{
					b.setSelected(true);
				}
				b.setBounds(10,34+24*i,418,23);
				add(b);
				bg.add(b);
				
			}	
		}
		if(f==5)
		{
			for(i=0;i<L.cas;++i)
			{
				JRadioButton b;
				b=new JRadioButton(L.c[i].name);
				
				
				b.setActionCommand(""+i);
				
				if(i==0)
				{
					b.setSelected(true);
				}
				b.setBounds(10,34+24*i,418,23);
				add(b);
				bg.add(b);
				
			}	
		}
		/*for(i=L.rel;i<L.per+L.rel;++i)
		{
			JRadioButton b=new JRadioButton(L.p[i].name);
			b.setActionCommand(""+i);
			if(i==0)
			{
				b.setSelected(true);
			}
			b.setBounds(10,34+24*i,418,23);
			frame.getContentPane().add(b);
			bg.add(b);
		}
		for(i=L.per+L.rel;i<L.prof+L.per+L.rel;++i)
		{
			
			JRadioButton b=new JRadioButton(L.f[i].name);
			b.setActionCommand(""+i);
			if(i==0)
			{
				b.setSelected(true);
			}
			b.setBounds(10,34+24*i,418,23);
			frame.getContentPane().add(b);
			bg.add(b);
		}
		for(i=L.prof+L.per+L.rel;i<L.tot;++i)
		{
			
			JRadioButton b=new JRadioButton(L.c[i].name);
			b.setActionCommand(""+i);
			if(i==0)
			{
				b.setSelected(true);
			}
			b.setBounds(10,34+24*i,418,23);
			frame.getContentPane().add(b);
			bg.add(b);
		}*/
		JButton bn=new JButton("Next");
		bn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
				
				int ch;
				ch=Integer.parseInt(bg.getSelection().getActionCommand());
				String str;
				if(ch<L.rel)
				 {
					str=L.r[ch].getdetails();
				 
            	JOptionPane.showMessageDialog(null,str,"Details",JOptionPane.PLAIN_MESSAGE);
				 }
				else if(ch<L.rel+L.per)
				 {
					str=L.p[ch-L.rel].getdetails();
				 
           	JOptionPane.showMessageDialog(null,str,"Details",JOptionPane.PLAIN_MESSAGE);
				 }
				else if(ch<L.rel+L.per+L.prof)
				 {
					str=L.f[ch-L.rel-L.per].getdetails();
				 
          	JOptionPane.showMessageDialog(null,str,"Details",JOptionPane.PLAIN_MESSAGE);
				 }
				else 
				 {
					str=L.c[ch-L.rel-L.per-L.prof].getdetails();
				 
          	JOptionPane.showMessageDialog(null,str,"Details",JOptionPane.PLAIN_MESSAGE);
				 }
				
				/*if(f==1)
				{
				String s;
				
				DisplayCourseDetail d1=new DisplayCourseDetail(c[ch]);
				frame.setVisible(false);
				}
				if(f==2)
				{
					String str=c[ch].Course_name;
					 for(int d=ch;d<GUIstcm.no_of_courses-1;++d)
		        		 c[d]=c[d+1];
		        	 JOptionPane.showMessageDialog(null,"Course :"+str+" deleted","Deleted",JOptionPane.PLAIN_MESSAGE);
		        	 GUIstcm.no_of_courses--;
				}
				if(f==3)
				{
					DisplayStuOp d=new DisplayStuOp(c,ch,f);
				}
				if(f==4)
					{EnterPart frame = new EnterPart(c,ch);
				//frame.setVisible(true);
				frame.setTitle("Enter Participant details");
					}
				if(f==5)
				{
					DisplayallPart frame=new DisplayallPart(c[ch]);
				}
				if(f==6)
				{
					ModifyCourse m=new ModifyCourse(c,ch);
				}
				if(f==7)
				{
					DisplayStuOp d=new DisplayStuOp(c,ch,f);
				}
				if(f==8)
				{
					enterFac frame = new enterFac(c,ch);
					
					frame.setTitle("Enter Faculty details");
				}
				if(f==9)
				{
					DisplayFacOp d=new DisplayFacOp(c,ch,f);
				}
				if(f==10)
				{
					DisplayFacOp d=new DisplayFacOp(c,ch,f);
					
				}
				*/
			}
				
		});
		bn.setFont(new Font("Segoe UI Semilight",Font.PLAIN,12 ));
		bn.setBounds(286,222,89,23);
		add(bn);
		JButton bn2=new JButton("Next");
		bn2.setFont(new Font("Segoe UI Semilight",Font.PLAIN,12 ));
		bn2.setBounds(600,427,89,23);
		add(bn2);
		
		
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				p.setVisible(true);
			}
		});
		
		
		
		}
	}


