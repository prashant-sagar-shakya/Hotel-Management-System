package HotelManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

public class Dashboard extends JFrame implements ActionListener {

	JMenuBar mb;
	JMenu m1, m2;
	JMenuItem i1, i2, i3, i4;

	Dashboard() {
		setBounds(0, 0, 1920, 1080);

		mb = new JMenuBar();
		add(mb);
		mb.setForeground(Color.cyan);

		m1 = new JMenu("HOTEL MANAGEMENT");
		mb.add(m1);
		m1.setForeground(Color.red);

		m2 = new JMenu("ADMIN");
		mb.add(m2);
		m2.setForeground(Color.blue);

		i1 = new JMenuItem("RECEPTION");
		m1.add(i1);
		i1.addActionListener(this);

		i2 = new JMenuItem("ADD EMPLOYEES");
		m2.add(i2);
		i2.addActionListener(this);

		i3 = new JMenuItem("ADD ROOMS");
		m2.add(i3);
		i3.addActionListener(this);

		i4 = new JMenuItem("ADD DRIVERS");
		m2.add(i4);
		i4.addActionListener(this);

		mb.setBounds(0, 0, 1920, 40);

		ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("HotelManagementSystem/icons/reception.jpg"));
		Image scaledIcon = icon.getImage().getScaledInstance(1560, 1080, Image.SCALE_DEFAULT);
		ImageIcon scaledImageIcon = new ImageIcon(scaledIcon);
		JLabel l1 = new JLabel(scaledImageIcon);
		l1.setBounds(-200, 0, 1920, 1080);
		add(l1);

		JLabel l2 = new JLabel("WELCOME");
		l2.setBounds(815, 100, 320, 75);
		l2.setFont(new Font("Tahoma", Font.BOLD, 60));
		l2.setBackground(Color.red);
		l2.setOpaque(true);
		l2.setForeground(Color.black);
		l1.add(l2);

		setLayout(null);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {

		if (ae.getActionCommand().equals("RECEPTION")) {
			SwingUtilities.invokeLater(() -> new Reception().setVisible(true));
		} else if (ae.getActionCommand().equals("ADD EMPLOYEES")) {
			SwingUtilities.invokeLater(() -> new AddEmployee().setVisible(true));
		} else if (ae.getActionCommand().equals("ADD ROOMS")) {
			SwingUtilities.invokeLater(() -> new AddRooms().setVisible(true));
		} else if (ae.getActionCommand().equals("ADD DRIVERS")) {
			SwingUtilities.invokeLater(() -> new AddDrivers().setVisible(true));
		}

		this.setVisible(false); // Close the dashboard after opening the new window
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new Dashboard());
	}
}