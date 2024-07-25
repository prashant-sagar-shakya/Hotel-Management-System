package HotelManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class AddRooms extends JFrame implements ActionListener {

	JTextField t1, t2;
	@SuppressWarnings("rawtypes")
	JComboBox c1, c2, c3;
	JButton b1, b2;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	AddRooms() {
		setBounds(400, 200, 750, 500);

		JLabel l1 = new JLabel("Add Rooms");
		l1.setFont(new Font("Tohoma", Font.BOLD, 21));
		l1.setBackground(Color.red);
		l1.setOpaque(true);
		l1.setBounds(480, 15, 120, 30);
		add(l1);

		JLabel room = new JLabel("Room Number");
		room.setFont(new Font("Tohoma", Font.BOLD, 14));
		room.setBounds(420, 80, 120, 30);
		add(room);

		t1 = new JTextField();
		t1.setBounds(560, 80, 110, 30);
		add(t1);

		JLabel available = new JLabel("Availability");
		available.setFont(new Font("Tohoma", Font.BOLD, 14));
		available.setBounds(420, 120, 120, 30);
		add(available);

		c1 = new JComboBox(new String[]{"Available", "Occupied"});
		c1.setBackground(Color.WHITE);
		c1.setBounds(560, 120, 110, 30);
		add(c1);

		JLabel status = new JLabel("Cleaning Status");
		status.setFont(new Font("Tohoma", Font.BOLD, 14));
		status.setBounds(420, 160, 120, 30);
		add(status);

		c2 = new JComboBox(new String[]{"Clean", "Dirty"});
		c2.setBackground(Color.WHITE);
		c2.setBounds(560, 160, 110, 30);
		add(c2);

		JLabel price = new JLabel("Price");
		price.setFont(new Font("Tohoma", Font.BOLD, 14));
		price.setBounds(420, 200, 120, 30);
		add(price);

		t2 = new JTextField();
		t2.setBounds(560, 200, 110, 30);
		add(t2);

		JLabel bedtype = new JLabel("Bed Type");
		bedtype.setFont(new Font("Tohoma", Font.BOLD, 14));
		bedtype.setBounds(420, 240, 120, 30);
		add(bedtype);

		c3 = new JComboBox(new String[]{"Single", "Double"});
		c3.setBackground(Color.WHITE);
		c3.setBounds(560, 240, 110, 30);
		add(c3);

		b1 = new JButton("Add Rooms");
		b1.setBounds(423, 300, 100, 30);
		b1.addActionListener(this);
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		add(b1);

		b2 = new JButton("Cancel");
		b2.setBounds(565, 300, 100, 30);
		b2.addActionListener(this);
		b2.setBackground(Color.black);
		b2.setForeground(Color.white);
		add(b2);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("HotelManagementSystem/icons/room.jpg"));
		JLabel l2 = new JLabel(i1);
		l2.setBounds(0, 0, 750, 500);
		add(l2);

		getContentPane().setBackground(Color.white);

		setLayout(null);
		setVisible(true);
	}

	@SuppressWarnings("resource")
	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource() == b1) {

			String roomNumber = t1.getText();
			String availability = (String) c1.getSelectedItem();
			String status = (String) c2.getSelectedItem();
			String price = t2.getText();
			String bedType = (String) c3.getSelectedItem();

			if (roomNumber.isEmpty() || availability.isEmpty() || status.isEmpty() || price.isEmpty() || bedType.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Please fill all fields.");
				return;
			}

			conn c = new conn();

			try (PreparedStatement ps = c.c.prepareStatement("INSERT INTO room (room_number, availability, status, price, bed_type) VALUES (?, ?, ?, ?, ?)")) {
				ps.setString(1, roomNumber);
				ps.setString(2, availability);
				ps.setString(3, status);
				ps.setString(4, price);
				ps.setString(5, bedType);

				ps.executeUpdate();

				JOptionPane.showMessageDialog(null, "New Room Added");
				SwingUtilities.invokeLater(() -> new Reception().setVisible(true));
				this.setVisible(false);

			} catch (SQLException e) {
				System.out.println("Error adding room: " + e.getMessage());
				JOptionPane.showMessageDialog(null, "Error adding room. Please try again.");
			}
		} else if (ae.getSource() == b2) {
			this.setVisible(false);
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new AddRooms());
	}
}