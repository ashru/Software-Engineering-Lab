package photob;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class addimage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	 ImageIcon icon;
	 ImageIcon image;
	 int mj=0;
	 private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addimage frame = new addimage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	 String str4;
	public addimage(ImageIcon[] images,String im[],int n,String ano[]) {
		setVisible(true);
		setTitle("Load new image");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 540, 454);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLoadNewImage = new JLabel("Load New Image");
		lblLoadNewImage.setFont(new Font("Sylfaen", Font.BOLD | Font.ITALIC, 16));
		lblLoadNewImage.setBounds(195, 2, 137, 56);
		contentPane.add(lblLoadNewImage);
		
		JLabel lblEnterImageName = new JLabel("Enter image name");
		lblEnterImageName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEnterImageName.setBounds(116, 69, 151, 27);
		contentPane.add(lblEnterImageName);
		
		textField = new JTextField();
		textField.setBounds(354, 72, 160, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnBrowseImage = new JButton("Browse Image");
		btnBrowseImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
		        try{
		            //prompt user to choose a file
		            JFileChooser fileChooser = new JFileChooser();
		            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Images", "jpg", "png", "gif", "bmp"));
		            int returnValue = fileChooser.showOpenDialog(null);
		            if (returnValue == JFileChooser.APPROVE_OPTION){
		                File file=fileChooser.getSelectedFile();
		                Image image1=ImageIO.read(file);
		                if(image1==null)
		                {JOptionPane.showMessageDialog(null,"Invalid File Selected","Invalid!",JOptionPane.PLAIN_MESSAGE);mj=0;}
		                image=new ImageIcon(file.getAbsolutePath());
		                 str4=file.getPath();
		                mj=1;
		               /*
		                float width=image.getWidth();
		                float height=image.getHeight();
		                
		                if(image.getHeight()>500 && (width/height)>1){
		                    Image thumb = image.getScaledInstance(-1, 620, Image.SCALE_SMOOTH);
		                    icon=new ImageIcon(thumb);
		                }
		                else if(image.getHeight() > 500 && (width / height) <= 1)
		                {
		                    Image thumb = image.getScaledInstance(470, -1, Image.SCALE_SMOOTH);
		                    icon=new ImageIcon(thumb);
		                }
		                else {icon = new ImageIcon(image);}
		                */
		                
		            }
		            
		        }catch(Exception e){JOptionPane.showMessageDialog(null,"Invalid File Selected","Invalid!",JOptionPane.PLAIN_MESSAGE);mj=0;}
		    
			}
		});
		btnBrowseImage.setBounds(55, 335, 156, 23);
		contentPane.add(btnBrowseImage);
		
		JButton btnLoadImage = new JButton("Load Image");
		btnLoadImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String str=textField.getText();
				String str1=textField_1.getText();
				
				int flag=0;
				if(str.length()==0)
					{JOptionPane.showMessageDialog(null,"Enter a title","Invalid!",JOptionPane.PLAIN_MESSAGE);
					return;}
				if(str.length()>20)
				{JOptionPane.showMessageDialog(null,"Title must be within 20 chars","Invalid!",JOptionPane.PLAIN_MESSAGE);
				return;}
				if(str1.length()>100)
				{JOptionPane.showMessageDialog(null,"Annotation  must be within 100 chars","Invalid!",JOptionPane.PLAIN_MESSAGE);
				return;}
				for(int i=0;i<n;++i)
				{
					if(im[i].compareTo(str)==0)
						flag=1;
				}
				if(flag==1)
				{JOptionPane.showMessageDialog(null,"Image with same name exists.Enter a different name","Invalid!",JOptionPane.PLAIN_MESSAGE);
				return;}
				if(mj!=1)
				{JOptionPane.showMessageDialog(null,"Choose an image","Invalid!",JOptionPane.PLAIN_MESSAGE);
				return;
					
				}
				im[n]=str;
				images[n]=image;
				ano[n]=str1;
				photoGUI.paths[n]=str4;
				photoGUI.incrementno();
				try {
					photoGUI.filewrite();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				setVisible(false);
				
					
			}
		});
		btnLoadImage.setBounds(322, 335, 156, 23);
		contentPane.add(btnLoadImage);
		
		textField_1 = new JTextField();
		textField_1.setBounds(354, 163, 170, 104);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblEnterAnnotation = new JLabel("Enter Annotation ");
		lblEnterAnnotation.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEnterAnnotation.setBounds(116, 208, 151, 14);
		contentPane.add(lblEnterAnnotation);
	}
}
