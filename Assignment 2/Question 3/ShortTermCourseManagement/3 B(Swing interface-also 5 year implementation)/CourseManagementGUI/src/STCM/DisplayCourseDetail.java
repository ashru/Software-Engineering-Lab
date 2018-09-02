package STCM;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class DisplayCourseDetail extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplayCourseDetail frame = new DisplayCourseDetail();
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
	public DisplayCourseDetail(Course c) {
		this.setVisible(true);
		
		String p[][]=new String[5][5];
		String s[][]=new String[5][5];
		for(int i=0;i<5;++i){
			if(i>c.no_of_instructors-1)
			{
				for(int j=0;j<5;++j)
					s[j][i]="";
			}
			else{
				s[0][i]=c.instructors[i].name;
				s[1][i]=c.instructors[i].address;
				s[2][i]=c.instructors[i].Department;
				s[3][i]=Long.toString(c.instructors[i].mobile_no);
				s[4][i]=c.instructors[i].email_id;
			}
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
		
		
		DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
		df.setLenient(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1222, 468);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCourseName = new JLabel("Course Name");
		lblCourseName.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 11));
		lblCourseName.setBounds(22, 11, 105, 14);
		contentPane.add(lblCourseName);
		
		JLabel lblNewLabel = new JLabel(c.Course_name);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel.setBounds(123, 11, 184, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblCourseFees = new JLabel("Course Fees");
		lblCourseFees.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 11));
		lblCourseFees.setBounds(22, 41, 75, 14);
		contentPane.add(lblCourseFees);
		
		JLabel lblNewLabel_1 = new JLabel(Long.toString(c.Course_fees));
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel_1.setBounds(123, 41, 120, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblStartDate = new JLabel("Start Date");
		lblStartDate.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 11));
		lblStartDate.setBounds(22, 70, 87, 14);
		contentPane.add(lblStartDate);
		
		JLabel lblNewLabel_2 = new JLabel(df.format(c.start_date));
		lblNewLabel_2.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel_2.setBounds(123, 70, 99, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblDuration = new JLabel("Duration");
		lblDuration.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 11));
		lblDuration.setBounds(22, 95, 75, 14);
		contentPane.add(lblDuration);
		
		JLabel lblNewLabel_3 = new JLabel(Integer.toString(c.duration));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel_3.setBounds(122, 95, 87, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblCouseCordinator = new JLabel("Couse Cordinator");
		lblCouseCordinator.setBounds(354, 11, 244, 14);
		contentPane.add(lblCouseCordinator);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(354, 31, 46, 14);
		contentPane.add(lblName);
		
		JLabel label = new JLabel("Address");
		label.setBounds(354, 56, 60, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Department");
		label_1.setBounds(354, 81, 75, 14);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Phone No.");
		label_2.setBounds(354, 106, 75, 14);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Email Id");
		label_3.setBounds(354, 132, 46, 14);
		contentPane.add(label_3);
		
		JLabel lblNewLabel_4 = new JLabel(c.Co_ordinator.name);
		lblNewLabel_4.setBounds(457, 31, 230, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel label_4 = new JLabel(c.Co_ordinator.address);
		label_4.setBounds(457, 56, 230, 14);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel(c.Co_ordinator.Department);
		label_5.setBounds(457, 81, 230, 14);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel(Long.toString(c.Co_ordinator.mobile_no));
		label_6.setBounds(457, 106, 230, 14);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel(c.Co_ordinator.email_id);
		label_7.setBounds(457, 132, 230, 14);
		contentPane.add(label_7);
		
		JLabel lblListOfStudents = new JLabel("LIST OF STUDENTS");
		lblListOfStudents.setBounds(160, 217, 174, 14);
		contentPane.add(lblListOfStudents);
		
		JLabel lblName_1 = new JLabel("Name");
		lblName_1.setBounds(78, 252, 46, 14);
		contentPane.add(lblName_1);
		
		JLabel label_8 = new JLabel("Address");
		label_8.setBounds(172, 252, 86, 14);
		contentPane.add(label_8);
		
		JLabel label_9 = new JLabel("Org. name");
		label_9.setBounds(248, 252, 86, 14);
		contentPane.add(label_9);
		
		JLabel label_10 = new JLabel("Mobile no");
		label_10.setBounds(326, 252, 86, 14);
		contentPane.add(label_10);
		
		JLabel label_11 = new JLabel("Email id");
		label_11.setBounds(423, 252, 86, 14);
		contentPane.add(label_11);
		
		JLabel lblNewLabel_6 = new JLabel(p[0][0]);
		lblNewLabel_6.setBounds(78, 277, 87, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel label_16 = new JLabel(p[0][1]);
		label_16.setBounds(78, 308, 87, 14);
		contentPane.add(label_16);
		
		JLabel label_17 = new JLabel(p[0][2]);
		label_17.setBounds(78, 333, 87, 14);
		contentPane.add(label_17);
		
		JLabel label_18 = new JLabel(p[0][3]);
		label_18.setBounds(78, 358, 87, 14);
		contentPane.add(label_18);
		
		JLabel label_19 = new JLabel(p[0][4]);
		label_19.setBounds(78, 383, 87, 14);
		contentPane.add(label_19);
		
		JLabel label_20 = new JLabel(p[1][0]);
		label_20.setBounds(172, 277, 87, 14);
		contentPane.add(label_20);
		
		JLabel label_21 = new JLabel(p[1][1]);
		label_21.setBounds(172, 308, 87, 14);
		contentPane.add(label_21);
		
		JLabel label_22 = new JLabel(p[1][2]);
		label_22.setBounds(173, 333, 87, 14);
		contentPane.add(label_22);
		
		JLabel label_23 = new JLabel(p[1][3]);
		label_23.setBounds(172, 358, 87, 14);
		contentPane.add(label_23);
		
		JLabel label_24 = new JLabel(p[1][4]);
		label_24.setBounds(173, 383, 87, 14);
		contentPane.add(label_24);
		
		JLabel label_25 = new JLabel(p[2][0]);
		label_25.setBounds(248, 277, 87, 14);
		contentPane.add(label_25);
		
		JLabel label_26 = new JLabel(p[2][1]);
		label_26.setBounds(248, 308, 87, 14);
		contentPane.add(label_26);
		
		JLabel label_27 = new JLabel(p[2][2]);
		label_27.setBounds(248, 333, 87, 14);
		contentPane.add(label_27);
		
		JLabel label_28 = new JLabel(p[2][3]);
		label_28.setBounds(248, 358, 87, 14);
		contentPane.add(label_28);
		
		JLabel label_29 = new JLabel(p[2][4]);
		label_29.setBounds(248, 383, 87, 14);
		contentPane.add(label_29);
		
		JLabel label_30 = new JLabel(p[3][0]);
		label_30.setBounds(326, 277, 87, 14);
		contentPane.add(label_30);
		
		JLabel label_31 = new JLabel(p[3][1]);
		label_31.setBounds(326, 308, 87, 14);
		contentPane.add(label_31);
		
		JLabel label_32 = new JLabel(p[3][2]);
		label_32.setBounds(326, 333, 87, 14);
		contentPane.add(label_32);
		
		JLabel label_33 = new JLabel(p[3][3]);
		label_33.setBounds(326, 358, 87, 14);
		contentPane.add(label_33);
		
		JLabel label_34 = new JLabel(p[3][4]);
		label_34.setBounds(326, 383, 87, 14);
		contentPane.add(label_34);
		
		JLabel label_35 = new JLabel(p[4][0]);
		label_35.setBounds(423, 277, 87, 14);
		contentPane.add(label_35);
		
		JLabel label_36 = new JLabel(p[4][1]);
		label_36.setBounds(423, 308, 87, 14);
		contentPane.add(label_36);
		
		JLabel label_37 = new JLabel(p[4][2]);
		label_37.setBounds(423, 333, 87, 14);
		contentPane.add(label_37);
		
		JLabel label_38 = new JLabel(p[4][3]);
		label_38.setBounds(423, 358, 87, 14);
		contentPane.add(label_38);
		
		JLabel label_39 = new JLabel(p[4][4]);
		label_39.setBounds(423, 383, 87, 14);
		contentPane.add(label_39);
		
		JLabel label_40 = new JLabel("LIST OF INSTRUCTORS");
		label_40.setBounds(730, 217, 174, 14);
		contentPane.add(label_40);
		
		JLabel label_42 = new JLabel("Name");
		label_42.setBounds(677, 252, 46, 14);
		contentPane.add(label_42);
		
		JLabel label_43 = new JLabel("Address");
		label_43.setBounds(771, 252, 86, 14);
		contentPane.add(label_43);
		
		JLabel label_44 = new JLabel("Department");
		label_44.setBounds(847, 252, 86, 14);
		contentPane.add(label_44);
		
		JLabel label_45 = new JLabel("Mobile no");
		label_45.setBounds(925, 252, 86, 14);
		contentPane.add(label_45);
		
		JLabel label_46 = new JLabel("Email id");
		label_46.setBounds(1021, 252, 86, 14);
		contentPane.add(label_46);
		
		JLabel label_47 = new JLabel(s[4][0]);
		label_47.setBounds(1022, 277, 87, 14);
		contentPane.add(label_47);
		
		JLabel label_48 = new JLabel(s[4][1]);
		label_48.setBounds(1022, 308, 87, 14);
		contentPane.add(label_48);
		
		JLabel label_49 = new JLabel(s[4][2]);
		label_49.setBounds(1022, 333, 87, 14);
		contentPane.add(label_49);
		
		JLabel label_50 = new JLabel(s[4][3]);
		label_50.setBounds(1022, 358, 87, 14);
		contentPane.add(label_50);
		
		JLabel label_51 = new JLabel(s[4][4]);
		label_51.setBounds(1022, 383, 87, 14);
		contentPane.add(label_51);
		
		JLabel label_52 = new JLabel(s[3][4]);
		label_52.setBounds(925, 383, 87, 14);
		contentPane.add(label_52);
		
		JLabel label_53 = new JLabel(s[3][3]);
		label_53.setBounds(925, 358, 87, 14);
		contentPane.add(label_53);
		
		JLabel label_54 = new JLabel(s[3][2]);
		label_54.setBounds(925, 333, 87, 14);
		contentPane.add(label_54);
		
		JLabel label_55 = new JLabel(s[3][1]);
		label_55.setBounds(925, 308, 87, 14);
		contentPane.add(label_55);
		
		JLabel label_56 = new JLabel(s[3][0]);
		label_56.setBounds(925, 277, 87, 14);
		contentPane.add(label_56);
		
		JLabel label_57 = new JLabel(s[2][0]);
		label_57.setBounds(847, 277, 87, 14);
		contentPane.add(label_57);
		
		JLabel label_58 = new JLabel(s[2][1]);
		label_58.setBounds(847, 308, 87, 14);
		contentPane.add(label_58);
		
		JLabel label_59 = new JLabel(s[2][2]);
		label_59.setBounds(847, 333, 87, 14);
		contentPane.add(label_59);
		
		JLabel label_60 = new JLabel(s[2][3]);
		label_60.setBounds(847, 358, 87, 14);
		contentPane.add(label_60);
		
		JLabel label_61 = new JLabel(s[2][4]);
		label_61.setBounds(772, 383, 87, 14);
		contentPane.add(label_61);
		
		JLabel label_62 = new JLabel(s[1][4]);
		label_62.setBounds(847, 383, 87, 14);
		contentPane.add(label_62);
		
		JLabel label_63 = new JLabel(s[1][3]);
		label_63.setBounds(771, 358, 87, 14);
		contentPane.add(label_63);
		
		JLabel label_64 = new JLabel(s[1][2]);
		label_64.setBounds(772, 333, 87, 14);
		contentPane.add(label_64);
		
		JLabel label_65 = new JLabel(s[1][1]);
		label_65.setBounds(771, 308, 87, 14);
		contentPane.add(label_65);
		
		JLabel label_66 = new JLabel(s[1][0]);
		label_66.setBounds(771, 277, 87, 14);
		contentPane.add(label_66);
		
		JLabel label_67 = new JLabel(s[0][0]);
		label_67.setBounds(677, 277, 87, 14);
		contentPane.add(label_67);
		
		JLabel label_68 = new JLabel(s[0][1]);
		label_68.setBounds(677, 308, 87, 14);
		contentPane.add(label_68);
		
		JLabel label_69 = new JLabel(s[0][2]);
		label_69.setBounds(677, 333, 87, 14);
		contentPane.add(label_69);
		
		JLabel label_70 = new JLabel(s[0][3]);
		label_70.setBounds(677, 358, 87, 14);
		contentPane.add(label_70);
		
		JLabel label_71 = new JLabel(s[0][4]);
		label_71.setBounds(677, 383, 87, 14);
		contentPane.add(label_71);
	}
}
