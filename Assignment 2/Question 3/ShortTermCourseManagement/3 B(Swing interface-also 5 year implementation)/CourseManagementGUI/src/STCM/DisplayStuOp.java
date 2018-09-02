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

public class DisplayStuOp extends JFrame {

	private JFrame frame;
	static ButtonGroup bg=new ButtonGroup();

	public DisplayStuOp(Course c[],int n,int f) {
		int i;
		frame=new JFrame("All Students for the course");
		frame.getContentPane().setFont(new Font("Segoe UI Semilight",Font.PLAIN,12 ));
		frame.setVisible(true);
		frame.setBounds(100,100,450,500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JLabel lbl1=new JLabel("Choose your option");
		lbl1.setFont(new Font("Segoe UI Semilight",Font.PLAIN,12 ));
		lbl1.setBounds(10, 11, 414, 23);
		for(i=0;i<c[n].no_of_students;++i)
		{
			JRadioButton b=new JRadioButton(c[n].students[i].name);
			b.setActionCommand(""+i);
			if(i==0)
			{
				b.setSelected(true);
			}
			b.setBounds(10,34+24*i,418,23);
			frame.getContentPane().add(b);
			bg.add(b);
		}
		JButton bn=new JButton("Next");
		bn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
				setVisible(false);
				int ch;
				ch=Integer.parseInt(bg.getSelection().getActionCommand());
				if(f==3)
				{
					String str2=c[n].students[ch].name;
					for(int g=ch;g<c[n].no_of_students-1;++g)
				    	  c[n].students[g]=c[n].students[g+1];
					JOptionPane.showMessageDialog(null,"Student :"+str2+" deleted from course "+c[n].Course_name,"Deleted",JOptionPane.PLAIN_MESSAGE);
		        	 c[n].no_of_students--;
				}
				if(f==7)
				{
					ModifyPart m=new ModifyPart(c,n,ch);
				}
				if(f==5)
				{
					DisplayallPart p=new DisplayallPart(c[ch]);
				}
				
			}
				
		});
		bn.setFont(new Font("Segoe UI Semilight",Font.PLAIN,12 ));
		bn.setBounds(335,427,89,23);
		frame.getContentPane().add(bn);
		}
	}


