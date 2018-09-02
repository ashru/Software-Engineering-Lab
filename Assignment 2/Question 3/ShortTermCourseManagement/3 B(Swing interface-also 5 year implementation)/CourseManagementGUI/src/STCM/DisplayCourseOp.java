package STCM;

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

public class DisplayCourseOp extends JFrame {

	private JFrame frame;
	static ButtonGroup bg=new ButtonGroup();

	public DisplayCourseOp(Course c[],int n,int f) {
		int i;
		frame=new JFrame("All Courses");
		frame.getContentPane().setFont(new Font("Segoe UI Semilight",Font.PLAIN,12 ));
		frame.setVisible(true);
		frame.setBounds(100,100,450,500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JLabel lbl1=new JLabel("Choose your option");
		lbl1.setFont(new Font("Segoe UI Semilight",Font.PLAIN,12 ));
		lbl1.setBounds(10, 11, 414, 23);
		int j;
		for(i=0,j=0;i<n;++i)
		{
			if(GUIstcm.withinYear(c[i].start_date)==-1)
			{
				continue;
			}
			JRadioButton b=new JRadioButton(c[i].Course_name);
			b.setActionCommand(""+i);
			if(i==0)
			{
				b.setSelected(true);
			}
			
			b.setBounds(10,34+24*j,418,23);
			frame.getContentPane().add(b);
			bg.add(b);
			++j;
		}
		JButton bn=new JButton("Next");
		bn.addMouseListener(new MouseAdapter() {
			@Override
			
			public void mouseClicked(MouseEvent arg0)
			{
				setVisible(false);
				int ch;
				ch=Integer.parseInt(bg.getSelection().getActionCommand());
				if(f==1)
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
		        	 
		        	 int g8=GUIstcm.withinYear(c[ch].start_date);
		        	 if(g8!=-1)
		        	 {
		        		 GUIstcm.decrey(g8);
		        	 }
				}
				if(f==3)
				{
					DisplayStuOp d;
				    if(c[ch].no_of_students==0)
				    {
				    	JOptionPane.showMessageDialog(null,"There are currently no students in this course","Invalid",JOptionPane.PLAIN_MESSAGE);
				    }
				    else
					d=new DisplayStuOp(c,ch,f);
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
					DisplayStuOp d;
				    if(c[ch].no_of_students==0)
				    {
				    	JOptionPane.showMessageDialog(null,"There are currently no students in this course","Invalid",JOptionPane.PLAIN_MESSAGE);
				    }
				    else
					d=new DisplayStuOp(c,ch,f);
				}
				if(f==8)
				{
					
					enterFac frame = new enterFac(c,ch);
					
					frame.setTitle("Enter Faculty details");
				}
				if(f==9)
				{
					DisplayFacOp d;
				    if(c[ch].no_of_instructors==0)
				    {
				    	JOptionPane.showMessageDialog(null,"There are currently no students in this course","Invalid",JOptionPane.PLAIN_MESSAGE);
				    }
				    else
					 d=new DisplayFacOp(c,ch,f);
				}
				if(f==10)
				{
					DisplayFacOp d;
				    if(c[ch].no_of_instructors==0)
				    {
				    	JOptionPane.showMessageDialog(null,"There are currently no students in this course","Invalid",JOptionPane.PLAIN_MESSAGE);
				    }
				    else
					 d=new DisplayFacOp(c,ch,f);
					
				}
			}
				
		});
		bn.setFont(new Font("Segoe UI Semilight",Font.PLAIN,12 ));
		bn.setBounds(335,427,89,23);
		frame.getContentPane().add(bn);
		}
	}


