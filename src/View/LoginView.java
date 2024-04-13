package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.RegisterController;
import Model.RegisterModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.border.LineBorder;

public class LoginView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtName;
	private JPasswordField txtPassword;
	private JButton btnLogin;
	private JButton btnExit;
	private JLabel lblPhoto;
	private JCheckBox cbShowPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frame = new LoginView();
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
	public LoginView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 448, 402);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(0, 0, 0,80));
		panel.setBounds(77, 14, 286, 312);
		contentPane.add(panel);
		panel.setLayout(null);
		
		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int centerX = (int) (screenDimension.getWidth() - getWidth()) / 2;
	    int centerY = (int) (screenDimension.getHeight() - getHeight()) / 2;
	    setLocation(centerX, centerY);
		
		JLabel lblNewLabel = new JLabel("Our System is only for Admin User");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(10, 14, 264, 36);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		
		JLabel lblNewLabel_1 = new JLabel("Login Application");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(84, 48, 124, 36);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		
		JLabel lblNewLabel_2 = new JLabel("Username:");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(20, 103, 88, 36);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		
		JLabel lblNewLabel_2_1 = new JLabel("Password:");
		lblNewLabel_2_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_1.setBounds(20, 167, 88, 36);
		panel.add(lblNewLabel_2_1);
		lblNewLabel_2_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		
		txtName = new JTextField();
		txtName.setBounds(112, 107, 139, 29);
		panel.add(txtName);
		txtName.setColumns(10);
		
		btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		btnExit.setBounds(36, 262, 83, 25);
		panel.add(btnExit);
		
		btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterController rc = new RegisterController();
				RegisterModel rm = new RegisterModel();
				if(txtName.getText().trim().toString().equals("")) {
					JOptionPane.showMessageDialog(null, "Username is blank!","Fail", JOptionPane.ERROR_MESSAGE);
				}else if(txtPassword.getText().trim().toString().equals("")) {
					JOptionPane.showMessageDialog(null, "Password is blank!","Fail", JOptionPane.ERROR_MESSAGE);

				}
				else {
					rm.setName(txtName.getText().toString());
					rm.setPassword(txtPassword.getText().toString());
					try {
						if(rc.checkLogin(rm.getName(), rm.getPassword())) {
							JOptionPane.showMessageDialog(null, "Success Login","Success",JOptionPane.INFORMATION_MESSAGE);
							clear();
							 setVisible(false);
							DashboardView dv = new DashboardView();
							dv.setVisible(true);
						}else {
							JOptionPane.showMessageDialog(null, "Fail Login","Fail",JOptionPane.ERROR_MESSAGE );
                            clear();						}
					} catch (HeadlessException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnLogin.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		btnLogin.setBounds(191, 262, 83, 25);
		panel.add(btnLogin);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(116, 167, 135, 33);
		panel.add(txtPassword);
		
		cbShowPassword = new JCheckBox("Show Password");
		cbShowPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cbShowPassword.isSelected()) {
					txtPassword.setEchoChar((char)0);
				}else {
					txtPassword.setEchoChar('*');
				}
			}
		});
		cbShowPassword.setFont(new Font("Segoe UI Black", Font.PLAIN, 10));
		cbShowPassword.setBounds(167, 210, 107, 25);
		panel.add(cbShowPassword);
		
		lblPhoto = new JLabel("");
		lblPhoto.setBounds(0, 0, 434, 365);
		contentPane.add(lblPhoto);
		displayImg();
	}
	
	public void clear()
    {
 		txtName.setText("");
 		txtPassword.setText("");
 		txtName.requestFocus(true);
    }
	public void displayImg() {
		ImageIcon imgIco = new ImageIcon(getClass().getResource("/My_Img/register.jpeg"));
		Image img = imgIco.getImage().getScaledInstance(lblPhoto.getWidth(), lblPhoto.getHeight(), Image.SCALE_SMOOTH);
		lblPhoto.setIcon(new ImageIcon(img));
	}
}
