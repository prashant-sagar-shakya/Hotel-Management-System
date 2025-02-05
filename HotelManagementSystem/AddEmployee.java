package HotelManagementSystem;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class AddEmployee extends JFrame implements ActionListener {

	JTextField t1, t2, t3, t4, t5, t6;
	JRadioButton r1, r2;
	@SuppressWarnings("rawtypes")
	JComboBox c1; // Keep the combo box for department
	JButton b1;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	AddEmployee() {
		setBounds(380, 200, 790, 500);

		JLabel name = new JLabel("NAME");
		name.setFont(new Font("Tahoma", Font.PLAIN, 17));
		name.setBounds(60, 70, 120, 30);
		add(name);

		t1 = new JTextField();
		t1.setBounds(180, 70, 150, 30);
		add(t1);

		JLabel age = new JLabel("AGE");
		age.setFont(new Font("Tahoma", Font.PLAIN, 17));
		age.setBounds(60, 110, 120, 30);
		add(age);

		t2 = new JTextField();
		t2.setBounds(180, 110, 150, 30);
		add(t2);

		JLabel gender = new JLabel("GENDER");
		gender.setFont(new Font("Tahoma", Font.PLAIN, 17));
		gender.setBounds(60, 150, 120, 30);
		add(gender);

		r1 = new JRadioButton("Male");
		r1.setFont(new Font("Tohoma", Font.PLAIN, 13));
		r1.setBounds(177, 150, 70, 30);
		r1.setBackground(Color.white);
		add(r1);

		r2 = new JRadioButton("Female");
		r2.setFont(new Font("Tohoma", Font.PLAIN, 13));
		r2.setBounds(250, 150, 70, 30);
		r2.setBackground(Color.white);
		add(r2);

		JLabel department = new JLabel("DEPARTMENT");
		department.setFont(new Font("Tahoma", Font.PLAIN, 17));
		department.setBounds(60, 190, 120, 30);
		add(department);

		String str[] = {"Select", "Front Desk Clerks", "Porters", "Housekeeping", "Kitchen Staff", "Room Service",
				"Waiter/Waitress", "Manager", "Accountant", "Chef"};
		c1 = new JComboBox(str);
		c1.setBounds(180, 190, 150, 30);
		c1.setBackground(Color.white);
		add(c1);

		JLabel salary = new JLabel("SALARY");
		salary.setFont(new Font("Tahoma", Font.PLAIN, 17));
		salary.setBounds(60, 230, 120, 30);
		add(salary);

		t3 = new JTextField();
		t3.setBounds(180, 230, 150, 30);
		add(t3);

		JLabel phone = new JLabel("PHONE");
		phone.setFont(new Font("Tahoma", Font.PLAIN, 17));
		phone.setBounds(60, 270, 120, 30);
		add(phone);

		t4 = new JTextField();
		t4.setBounds(180, 270, 150, 30);
		add(t4);

		JLabel aadhar = new JLabel("AADHAR");
		aadhar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		aadhar.setBounds(60, 310, 120, 30);
		add(aadhar);

		t5 = new JTextField();
		t5.setBounds(180, 310, 150, 30);
		add(t5);

		JLabel email = new JLabel("EMAIL");
		email.setFont(new Font("Tahoma", Font.PLAIN, 17));
		email.setBounds(60, 350, 120, 30);
		add(email);

		t6 = new JTextField();
		t6.setBounds(180, 350, 150, 30);
		add(t6);

		b1 = new JButton("Submit");
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b1.setBounds(120, 400, 130, 30);
		b1.addActionListener(this);
		add(b1);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("HotelManagementSystem/icons/hiring.png"));
		Image i2 = i1.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l1 = new JLabel(i3);
		l1.setBounds(170, 50, 700, 500);
		add(l1);

		JLabel l2 = new JLabel("ADD EMPLOYEE DETAILS");
		l2.setForeground(Color.blue);
		l2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		l2.setBounds(250, 15, 300, 30);
		add(l2);

		getContentPane().setBackground(Color.white);
		setLayout(null);
		setVisible(true);
	}

	@SuppressWarnings("unused")
	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource() == b1) {

			String name = t1.getText();
			String age = t2.getText();
			String salary = t3.getText();
			String phone = t4.getText();
			String aadhar = t5.getText();
			String email = t6.getText();
			String gender = null;
			String department = (String) c1.getSelectedItem();

			// Check if all fields are filled
			if (name.isEmpty() && age.isEmpty() && salary.isEmpty() && phone.isEmpty() && aadhar.isEmpty() &&
					email.isEmpty() && gender == null && department.equals("Select")) {
				JOptionPane.showMessageDialog(null, "Please fill all fields.");
				return;
			}

			if (r1.isSelected()) {
				gender = "Male";
			} else if (r2.isSelected()) {
				gender = "Female";
			}

			conn c = new conn();

			try (PreparedStatement ps = c.c.prepareStatement("INSERT INTO employee (name, age, gender, department, salary, phone, aadhar, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?)")) { // Changed SQL Query
				ps.setString(1, name);
				ps.setString(2, age);
				ps.setString(3, gender);
				ps.setString(4, department);
				ps.setString(5, salary);
				ps.setString(6, phone);
				ps.setString(7, aadhar);
				ps.setString(8, email);

				ps.executeUpdate();
				JOptionPane.showMessageDialog(null, "New Employee Added");
				SwingUtilities.invokeLater(() -> new Reception().setVisible(true));
				this.setVisible(false);

			} catch (SQLException e) {
				System.out.println("Error adding employee: " + e.getMessage());
				JOptionPane.showMessageDialog(null, "Error adding employee. Please try again.");
			}
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new AddEmployee());
	}
}