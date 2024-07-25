package HotelManagementSystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class AddCustomer extends JFrame implements ActionListener {

	JTextField t1, t2, t3, t4, t5;
	JButton b1, b2;
	@SuppressWarnings("rawtypes")
	JComboBox c1;
	Choice c2;
	JRadioButton r1, r2;

	@SuppressWarnings({ "rawtypes", "unchecked", "resource" })
	AddCustomer() {
		setBounds(400, 200, 700, 500);

		JLabel l1 = new JLabel("NEW CUSTOMER FORM");
		l1.setBounds(100, 20, 300, 30);
		l1.setForeground(Color.blue);
		l1.setFont(new Font("Tohoma", Font.BOLD, 20));
		add(l1);

		JLabel l2 = new JLabel("ID Type");
		l2.setBounds(30, 60, 100, 30);
		add(l2);

		c1 = new JComboBox(new String[]{"Aadhar Card", "Pan Card", "Passport", "Driving Licence", "Voter ID Card"});
		c1.setBackground(Color.white);
		c1.setBounds(200, 60, 150, 30);
		add(c1);

		JLabel l3 = new JLabel("Number");
		l3.setBounds(30, 100, 100, 30);
		add(l3);

		t1 = new JTextField();
		t1.setBounds(200, 100, 150, 30);
		add(t1);

		JLabel l4 = new JLabel("Name");
		l4.setBounds(30, 140, 100, 30);
		add(l4);

		t2 = new JTextField();
		t2.setBounds(200, 140, 150, 30);
		add(t2);

		JLabel l5 = new JLabel("Gender");
		l5.setBounds(30, 180, 100, 30);
		add(l5);

		r1 = new JRadioButton("Male");
		r1.setBackground(Color.white);
		r1.setBounds(200, 180, 80, 30);
		add(r1);

		r2 = new JRadioButton("Female");
		r2.setBackground(Color.white);
		r2.setBounds(280, 180, 100, 30);
		add(r2);

		JLabel l6 = new JLabel("Country");
		l6.setBounds(30, 220, 100, 30);
		add(l6);

		t3 = new JTextField();
		t3.setBounds(200, 220, 150, 30);
		add(t3);

		JLabel l7 = new JLabel("Room no");
		l7.setBounds(30, 260, 100, 30);
		add(l7);

		c2 = new Choice();
		try {
			conn c = new conn();
			String str = "select * from room";
			ResultSet rs = c.s.executeQuery(str);

			while (rs.next()) {
				c2.add(rs.getString("room_number"));
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		c2.setBounds(200, 260, 150, 40);
		add(c2);

		JLabel l8 = new JLabel("Checked In");
		l8.setBounds(30, 300, 100, 30);
		add(l8);

		t4 = new JTextField();
		t4.setBounds(200, 300, 150, 30);
		add(t4);

		JLabel l9 = new JLabel("Deposit");
		l9.setBounds(30, 340, 100, 30);
		add(l9);

		t5 = new JTextField();
		t5.setBounds(200, 340, 150, 30);
		add(t5);

		b1 = new JButton("Add Customer");
		b1.setForeground(Color.white);
		b1.setBackground(Color.black);
		b1.setBounds(30, 400, 130, 30);
		b1.addActionListener(this);
		add(b1);

		b2 = new JButton("Cancel");
		b2.setForeground(Color.white);
		b2.setBackground(Color.black);
		b2.setBounds(210, 400, 130, 30);
		b2.addActionListener(this);
		add(b2);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("HotelManagementSystem/icons/customer.png"));
		Image i2 = i1.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel li = new JLabel(i3);
		li.setBounds(330, 30, 400, 400);
		add(li);

		getContentPane().setBackground(Color.white);

		setLayout(null);
		setVisible(true);
	}


	@SuppressWarnings("resource")
	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource() == b1) {

			String idType = (String) c1.getSelectedItem();
			String idNumber = t1.getText();
			String name = t2.getText();
			String gender = null;

			if (r1.isSelected()) {
				gender = "Male";
			} else if (r2.isSelected()) {
				gender = "Female";
			}

			String country = t3.getText();
			String room = c2.getSelectedItem();
			String status = t4.getText();
			String deposit = t5.getText();

			if (idType.isEmpty() || idNumber.isEmpty() || name.isEmpty() || gender == null || country.isEmpty() || room.isEmpty() || status.isEmpty() || deposit.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Please fill all fields.");
				return;
			}

			try {
				conn c = new conn();

				// Use PreparedStatement to prevent SQL injection
				String str = "INSERT INTO customer (id_type, id_number, name, gender, country, room, status, deposit) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
				java.sql.PreparedStatement ps = c.c.prepareStatement(str);
				ps.setString(1, idType);
				ps.setString(2, idNumber);
				ps.setString(3, name);
				ps.setString(4, gender);
				ps.setString(5, country);
				ps.setString(6, room);
				ps.setString(7, status);
				ps.setString(8, deposit);

				ps.executeUpdate();

				// Update room availability
				String str2 = "UPDATE room SET availability = 'Occupied' WHERE room_number = ?";
				ps = c.c.prepareStatement(str2);
				ps.setString(1, room);
				ps.executeUpdate();

				JOptionPane.showMessageDialog(null, "New Customer Added");
				SwingUtilities.invokeLater(() -> new Reception().setVisible(true));
				this.setVisible(false);

			} catch (SQLException e) {
				System.out.println("Error adding customer: " + e.getMessage());
				JOptionPane.showMessageDialog(null, "Error adding customer. Please try again.");
			}
		} else if (ae.getSource() == b2) {
			SwingUtilities.invokeLater(() -> new Reception().setVisible(true));
			this.setVisible(false);
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new AddCustomer());
	}
}