package photob;



import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JRadioButton;



import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.Color;

public class DispnameI extends JFrame {

	
	private JFrame frame;
	static ButtonGroup bg=new ButtonGroup();

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DispnameI frame = new DispnameI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 */
	public DispnameI(String names[],int n,ImageIcon[] images,String an[],int fl) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Names of all images");
		frame=new JFrame("All Images");
		frame.getContentPane().setBackground(new Color(204, 255, 204));
		frame.getContentPane().setFont(new Font("Segoe UI Semilight",Font.PLAIN,12 ));
		frame.setVisible(true);
		frame.setBounds(100,100,450,1000);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JLabel lbl1=new JLabel("Choose your option");
		lbl1.setFont(new Font("Segoe UI Semilight",Font.PLAIN,12 ));
		lbl1.setBounds(10, 11, 414, 23);
		for(int i=0;i<n;++i)
		{
			JRadioButton b1=new JRadioButton(names[i]);
			b1.setActionCommand(""+i);
			if(i==0)
			{
				b1.setSelected(true);
			}
			b1.setBounds(10,34+24*i,418,23);
			frame.getContentPane().add(b1);
			bg.add(b1);
		}
		JButton bn=new JButton("Next");
		bn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
				frame.setVisible(false);
				int ch;
				ch=Integer.parseInt(bg.getSelection().getActionCommand());
				ImageViewer1 f;
				if(fl==1)
				 f=new ImageViewer1(images,ch,n,names,an);
				else{
					for(int i=ch;i<photoGUI.no-1;++i)
					{
						photoGUI.paths[i]=photoGUI.paths[i+1];
						photoGUI.images[i]=photoGUI.images[i+1];
						photoGUI.names[i]=photoGUI.names[i+1];
						photoGUI.ann[i]=photoGUI.ann[i+1];
						
					}
					photoGUI.decrementno();
					JOptionPane.showMessageDialog(null,"Image deleted!","Deletion Successful",JOptionPane.PLAIN_MESSAGE);
					
					try {
						photoGUI.filewrite();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
				
		});
		bn.setFont(new Font("Segoe UI Semilight",Font.PLAIN,12 ));
		bn.setBounds(335,686,89,23);
		frame.getContentPane().add(bn);
		
	}

}
