package photob;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ImageViewer1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	

	/**
	 * Create the frame.
	 */
	public ImageViewer1(ImageIcon[] images,int ind,int tot,String im[],String an[]) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		ImageIcon image=images[ind];
		setTitle(im[ind]);
		setVisible(true);
		setBounds(0, 0, 1500, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("", image, JLabel.CENTER);
		label.setBounds(10, 44, 1200, 600);
		contentPane.add(label);
		
		JButton btnNextImage = new JButton("Next Image");
		btnNextImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ImageViewer1 frame = new ImageViewer1(images,(ind+1)%tot,tot,im,an);
				frame.setVisible(true);
				dispose();
			}
		});
		btnNextImage.setBounds(1249, 283, 125, 23);
		contentPane.add(btnNextImage);
		
		JButton btnPreviousImage = new JButton("Previous Image");
		btnPreviousImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					ImageViewer1 frame = new ImageViewer1(images,(tot+ind-1)%tot,tot,im,an);
					frame.setVisible(true);
					dispose();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnPreviousImage.setBounds(1249, 346, 125, 23);
		contentPane.add(btnPreviousImage);
		
		JLabel lblTitle = new JLabel("Title:"+im[ind]);
		lblTitle.setBounds(31, 11, 547, 14);
		contentPane.add(lblTitle);
		
		JTextPane txtpnAnnotation = new JTextPane();
		txtpnAnnotation.setText("Annotation:"+an[ind]);
		txtpnAnnotation.setBounds(10, 650, 804, 120);
		contentPane.add(txtpnAnnotation);
		 txtpnAnnotation.setEditable(false);
		 
	}
}
