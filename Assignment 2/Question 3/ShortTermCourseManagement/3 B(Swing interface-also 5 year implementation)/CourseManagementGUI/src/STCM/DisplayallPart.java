package STCM;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class DisplayallPart extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplayallPart frame = new DisplayallPart();
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
	public DisplayallPart(Course c) {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 926, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
this.setVisible(true);
		
		String p[][]=new String[5][5];
		for(int i=0;i<5;++i){
			
			if(i>c.no_of_students-1)
			{
				for(int j=0;j<5;++j)
					p[j][i]="";
			}
			else{
				p[0][i]=c.students[i].name;
				p[1][i]=c.students[i].address;
				p[2][i]=c.students[i].org_name;
				p[3][i]=Long.toString(c.students[i].mobile_no);
				p[4][i]=c.students[i].email_id;
			}
			
			}
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(85, 78, 118, 14);
		contentPane.add(lblName);
		
		JLabel lblNewLabel = new JLabel(p[0][0]);
		lblNewLabel.setBounds(85, 103, 157, 14);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel(p[0][1]);
		label.setBounds(85, 128, 157, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel(p[0][2]);
		label_1.setBounds(85, 153, 157, 14);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel(p[0][3]);
		label_2.setBounds(85, 178, 157, 14);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel(p[0][4]);
		label_3.setBounds(85, 203, 157, 14);
		contentPane.add(label_3);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(282, 78, 157, 14);
		contentPane.add(lblAddress);
		
		JLabel label_4 = new JLabel(p[1][0]);
		label_4.setBounds(282, 103, 157, 14);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel(p[1][1]);
		label_5.setBounds(282, 128, 157, 14);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel(p[1][2]);
		label_6.setBounds(282, 153, 157, 14);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel(p[1][3]);
		label_7.setBounds(282, 178, 157, 14);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel(p[1][4]);
		label_8.setBounds(282, 203, 157, 14);
		contentPane.add(label_8);
		
		JLabel lblDepartment = new JLabel("Organization Name");
		lblDepartment.setBounds(449, 78, 118, 14);
		contentPane.add(lblDepartment);
		
		JLabel label_9 = new JLabel(p[2][0]);
		label_9.setBounds(449, 103, 118, 14);
		contentPane.add(label_9);
		
		JLabel label_10 = new JLabel(p[2][1]);
		label_10.setBounds(449, 128, 118, 14);
		contentPane.add(label_10);
		
		JLabel label_11 = new JLabel(p[2][2]);
		label_11.setBounds(449, 153, 118, 14);
		contentPane.add(label_11);
		
		JLabel label_12 = new JLabel(p[2][3]);
		label_12.setBounds(449, 178, 118, 14);
		contentPane.add(label_12);
		
		JLabel label_13 = new JLabel(p[2][4]);
		label_13.setBounds(449, 203, 118, 14);
		contentPane.add(label_13);
		
		JLabel lblMobileNo = new JLabel("Mobile No");
		lblMobileNo.setBounds(602, 78, 104, 14);
		contentPane.add(lblMobileNo);
		
		JLabel label_14 = new JLabel(p[3][0]);
		label_14.setBounds(602, 103, 104, 14);
		contentPane.add(label_14);
		
		JLabel label_15 = new JLabel(p[3][1]);
		label_15.setBounds(602, 128, 104, 14);
		contentPane.add(label_15);
		
		JLabel label_16 = new JLabel(p[3][2]);
		label_16.setBounds(602, 153, 104, 14);
		contentPane.add(label_16);
		
		JLabel label_17 = new JLabel(p[3][3]);
		label_17.setBounds(602, 178, 104, 14);
		contentPane.add(label_17);
		
		JLabel label_18 = new JLabel(p[3][4]);
		label_18.setBounds(602, 203, 104, 14);
		contentPane.add(label_18);
		
		JLabel lblEmailId = new JLabel("Email id");
		lblEmailId.setBounds(738, 78, 104, 14);
		contentPane.add(lblEmailId);
		
		JLabel label_19 = new JLabel(p[4][0]);
		label_19.setBounds(738, 103, 104, 14);
		contentPane.add(label_19);
		
		JLabel label_20 = new JLabel(p[4][1]);
		label_20.setBounds(738, 128, 104, 14);
		contentPane.add(label_20);
		
		JLabel label_21 = new JLabel(p[4][2]);
		label_21.setBounds(738, 153, 104, 14);
		contentPane.add(label_21);
		
		JLabel label_22 = new JLabel(p[4][3]);
		label_22.setBounds(738, 178, 104, 14);
		contentPane.add(label_22);
		
		JLabel label_23 = new JLabel(p[4][4]);
		label_23.setBounds(738, 203, 104, 14);
		contentPane.add(label_23);
	}

}
