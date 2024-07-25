package HotelManagementSystem;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Login extends JFrame implements ActionListener {

	JLabel l1, l2;
	JTextField t1;
	JPasswordField t2;
	JButton b1, b2;

	Login() {

		setBounds(480, 250, 600, 270);

		l1 = new JLabel("Username");
		l1.setBounds(40, 50, 100, 30);
		add(l1);

		l2 = new JLabel("Password");
		l2.setBounds(40, 90, 100, 30);
		add(l2);

		t1 = new JTextField();
		t1.setBounds(160, 50, 100, 30);
		add(t1);

		t2 = new JPasswordField();
		t2.setBounds(160, 90, 100, 30);
		add(t2);

		b1 = new JButton("Login");
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b1.setBounds(60, 140, 80, 30);
		b1.addActionListener(this);
		add(b1);

		b2 = new JButton("Cancel");
		b2.setBackground(Color.black);
		b2.setForeground(Color.white);
		b2.setBounds(160, 140, 80, 30);
		b2.addActionListener(this);
		add(b2);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("HotelManagementSystem/icons/admin.png"));
		Image i2 = i1.getImage().getScaledInstance(190, 190, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l3 = new JLabel(i3);
		l3.setBounds(370, 35, 150, 150);
		add(l3);

		getContentPane().setBackground(Color.white);
		setLayout(null);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == b1) {

			String username = t1.getText();
			char[] pwd = t2.getPassword();
			String password = new String(pwd);

			if (username.isEmpty() || password.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Please enter both username and password.");
				return;
			}

			try (conn c = new conn();
				 PreparedStatement ps = c.c.prepareStatement("SELECT * FROM login WHERE username = ? AND password = ?")) {
				ps.setString(1, username);
				ps.setString(2, password);
				ResultSet rs = ps.executeQuery();

				if (rs.next()) {
					SwingUtilities.invokeLater(() -> new Dashboard().setVisible(true));
					this.setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null, "Invalid Username or Password");
					this.setVisible(false);
				}

			} catch (Exception e) {
				System.out.println("Error during login: " + e.getMessage());
				JOptionPane.showMessageDialog(null, "Error during login. Please try again.");
			}
		} else if (ae.getSource() == b2) {
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new Login());
	}
}