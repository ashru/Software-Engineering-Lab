package photob;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class photoGUI extends JFrame {

	private JPanel contentPane;
	static ImageIcon [] images=new ImageIcon[10];
	public static int no;
	static String names[]=new String[10];
	static String paths[]=new String[10];
	static String ann[]=new String[10];
	public static  void incrementno()
	{
		++no;
	}
	public static  void decrementno()
	{
		--no;
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					photoGUI frame = new photoGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public photoGUI() {
		setTitle("DIGITAL PHOTO ALBUM\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 648, 426);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDigitalPhotoAlbum = new JLabel("Digital Photo Album");
		lblDigitalPhotoAlbum.setForeground(new Color(102, 51, 51));
		lblDigitalPhotoAlbum.setBackground(new Color(102, 51, 51));
		lblDigitalPhotoAlbum.setFont(new Font("Jokerman", Font.BOLD | Font.ITALIC, 24));
		lblDigitalPhotoAlbum.setBounds(178, 27, 325, 56);
		contentPane.add(lblDigitalPhotoAlbum);
		
		JRadioButton rdbtnLoadNewPicture = new JRadioButton("Load new Picture");
		rdbtnLoadNewPicture.setBounds(218, 178, 164, 23);
		contentPane.add(rdbtnLoadNewPicture);
		
		JRadioButton rdbtnDisplayAllNames = new JRadioButton("Display all names of pictures");
		rdbtnDisplayAllNames.setBounds(218, 204, 236, 23);
		contentPane.add(rdbtnDisplayAllNames);
		JRadioButton rdbtnDeleteAPhoto = new JRadioButton("Delete a photo");
		rdbtnDeleteAPhoto.setBounds(218, 257, 109, 23);
		contentPane.add(rdbtnDeleteAPhoto);
		JRadioButton rdbtnDisplayImagesOne = new JRadioButton("Display images one by one");
		rdbtnDisplayImagesOne.setBounds(218, 230, 236, 23);
		contentPane.add(rdbtnDisplayImagesOne);
		ButtonGroup bg=new ButtonGroup();
		bg.add(rdbtnLoadNewPicture);
		rdbtnLoadNewPicture.setActionCommand(""+0);
		bg.add(rdbtnDisplayAllNames);
		rdbtnDisplayAllNames.setActionCommand(""+1);
		bg.add( rdbtnDisplayImagesOne);
		rdbtnDisplayImagesOne.setActionCommand(""+2);
		bg.add(rdbtnDeleteAPhoto);
		rdbtnDeleteAPhoto.setActionCommand(""+3);
		JRadioButton rdbtnExit = new JRadioButton("Exit");
		rdbtnExit.setBounds(218, 282, 109, 23);
		contentPane.add(rdbtnExit);
		bg.add( rdbtnExit);
		rdbtnExit.setActionCommand(""+4);
		rdbtnLoadNewPicture.setSelected(true);
		
		
		
		JButton btnDone = new JButton("Done");
		try{
			Scanner rd1 = new Scanner(new FileReader("PhotoAlbum.txt"));


int x=Integer.parseInt(rd1.nextLine());
rd1.close();
if(x!=0)
{



    Scanner rd = new Scanner(new FileReader("PhotoAlbum.txt"));
    String red=rd.nextLine();
    int j=0;
    for(int i=0;i<x;++i)
    {
    	paths[i]=rd.nextLine();
    	
    	
		
    	
    	try{
    		
    		
    		images[j]=new ImageIcon(paths[i]);
    		
    		names[j]=rd.nextLine();
    		
    				
    		
    		ann[j]=rd.nextLine();
    		++j;
    	}
    	
    	catch(Exception e){ }
    	
    	
    }
   
    no=j;
   

}  
			}catch(Exception e4){}
		
		
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int ch;
				ch=Integer.parseInt(bg.getSelection().getActionCommand());
				if(ch==0){
					addimage f;
					if(no==10)
						JOptionPane.showMessageDialog(null,"10 images present.Cannot add more images!","Invalid!",JOptionPane.PLAIN_MESSAGE);
					else
					f=new addimage(images,names,no,ann);
				}
				if(ch==1){
					DispnameI f;
					if(no==0)
						JOptionPane.showMessageDialog(null,"No images in album","Invalid!",JOptionPane.PLAIN_MESSAGE);
					else
					 f = new DispnameI(names,no,images,ann,1);
					
				}
				if(ch==2){
					ImageViewer1 f;
					if(no==0)
						JOptionPane.showMessageDialog(null,"No images in album","Invalid!",JOptionPane.PLAIN_MESSAGE);
					else
					f=new ImageViewer1(images,0,no,names,ann);
				}
				if(ch==3){
					DispnameI f;
					if(no==0)
						JOptionPane.showMessageDialog(null,"No images in album","Invalid!",JOptionPane.PLAIN_MESSAGE);
					else
					 f = new DispnameI(names,no,images,ann,2);
					
				}
				if(ch==4)
					setVisible(false);
				
				
			}
		});
		btnDone.setBounds(266, 328, 89, 23);
		contentPane.add(btnDone);
		
		
		
		
	}
	public static void filewrite()throws IOException
    {
        int i;
       File f2 = new File("PhotoAlbum.txt");
                FileWriter writer2 = new FileWriter(f2);
                writer2.write(Integer.toString(no)+System.getProperty( "line.separator" ));
                
               
        for(i=0;i<no;++i)
        {
                writer2.write(paths[i]+System.getProperty( "line.separator" ));
                writer2.write(names[i]+System.getProperty( "line.separator" ));
                writer2.write(ann[i]+System.getProperty( "line.separator" ));
                
                
        }
       
                writer2.flush();
                writer2.close();
                 
    }
}
