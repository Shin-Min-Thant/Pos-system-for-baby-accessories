package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Controller.RegisterController;
import Model.RegisterModel;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class RegisterView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtPassword;
	private JButton btnLogin;
	private JPanel login;
	private JSeparator separator_1;
	private JButton btnEditBrand;
	private JButton btnEditType;
	private JButton btnEditItem;
	private JButton btnEditSupplier;
	private JButton btnEditPurchase;
	private JButton btnEditCustomer;
	private JButton btnEditSale;
	private JButton btnEditDeliver;
	private JButton btnEditOrder;
	private JButton btnEditDelivery;
	private JButton btnPurchaseDetailView;
	private JButton btnSaleDetailView;
	private JButton btnOrderDetailView;
	private JButton btnDeliveryDetailView;
	private JLabel sm_photo;
	private JLabel system_photo;
	private JLabel lblLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterView frame = new RegisterView();
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
	public RegisterView() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 593, 537);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		login = new JPanel();
		login.setBackground(new Color(250, 240, 230));
		login.setBorder(new LineBorder(new Color(0, 0, 0)));
		login.setBounds(291, 0, 285, 488);
		contentPane.add(login);
		login.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tekton Pro", Font.PLAIN, 20));
		lblNewLabel.setBounds(8, 168, 108, 17);
		login.add(lblNewLabel);
		
		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int centerX = (int) (screenDimension.getWidth() - getWidth()) / 2;
	    int centerY = (int) (screenDimension.getHeight() - getHeight()) / 2;
	    setLocation(centerX, centerY);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setFont(new Font("Tekton Pro", Font.PLAIN, 20));
		lblPassword.setBounds(8, 233, 108, 25);
		login.add(lblPassword);
		
		txtName = new JTextField();
		txtName.setBounds(124, 160, 149, 32);
		login.add(txtName);
		txtName.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(124, 229, 149, 32);
		login.add(txtPassword);
		
		btnLogin = new JButton("Log in");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterController rc = new RegisterController();
				RegisterModel rm = new RegisterModel();
				if(txtName.getText().trim().toString().equals("")||txtPassword.getText().trim().toString().equals("")) {
					JOptionPane.showMessageDialog(null, "There is a blank field!","Fail", JOptionPane.ERROR_MESSAGE);
				}else {
					rm.setName(txtName.getText().toString());
					rm.setPassword(txtPassword.getText().toString());
					try {
						if(rc.checkLogin(rm.getName(), rm.getPassword())) {
							JOptionPane.showMessageDialog(null, "Success Login","Success",JOptionPane.INFORMATION_MESSAGE);
							btnEditBrand.setEnabled(true);
							btnEditType.setEnabled(true);
							btnEditItem.setEnabled(true);
							btnEditSupplier.setEnabled(true);
							btnEditCustomer.setEnabled(true);
							btnEditPurchase.setEnabled(true);
							btnEditSale.setEnabled(true);
							btnEditOrder.setEnabled(true);
							btnEditDeliver.setEnabled(true);
							btnEditDelivery.setEnabled(true);
							btnPurchaseDetailView .setEnabled(true);
							btnSaleDetailView .setEnabled(true);
							btnOrderDetailView .setEnabled(true);
							btnDeliveryDetailView .setEnabled(true);
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
		btnLogin.setFont(new Font("Pyidaungsu", Font.BOLD, 18));
		btnLogin.setBounds(81, 318, 128, 40);
		btnLogin.setFocusable(false);
		login.add(btnLogin);
		
		system_photo = new JLabel("");
		system_photo.setBounds(0, 255, 285, 249);
		login.add(system_photo);
		
		JLabel lblNewLabel_1 = new JLabel("Our system is only for");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 20));
		lblNewLabel_1.setBounds(8, 14, 285, 35);
		login.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Admin User");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Segoe Script", Font.BOLD, 18));
		lblNewLabel_3.setBounds(71, 63, 138, 32);
		login.add(lblNewLabel_3);
		
		lblLogin = new JLabel("");
		lblLogin.setBounds(0, 0, 285, 488);
		login.add(lblLogin);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 230, 140));
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(0, 0, 283, 488);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Pos for Baby Accessories");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(20, 14, 238, 26);
		panel_1.add(lblNewLabel_2);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 0, 0));
		separator.setBounds(0, 44, 283, 2);
		panel_1.add(separator);
		
		separator_1 = new JSeparator();
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(0, 295, 291, 2);
		panel_1.add(separator_1);
		
		btnEditBrand = new JButton("Edit Brand");
		btnEditBrand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BrandView bv = new BrandView();
				bv.setVisible(true);
				bv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnEditBrand.setEnabled(false);
		btnEditBrand.setFocusable(false);
		btnEditBrand.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		btnEditBrand.setBounds(145, 67, 130, 32);
		panel_1.add(btnEditBrand);
		
		btnEditType = new JButton("Edit Type");
		btnEditType.setForeground(new Color(0, 0, 0));
		btnEditType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TypeView tv;
				try {
					tv = new TypeView();
					tv.setVisible(true);
					tv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnEditType.setEnabled(false);
		btnEditType.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		btnEditType.setBounds(10, 67, 129, 32);
		btnEditType.setFocusable(false);
		panel_1.add(btnEditType);
		
		btnEditItem = new JButton("Edit Item");
		btnEditItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ItemView iv = new ItemView();
				iv.setVisible(true);
				iv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnEditItem.setEnabled(false);
		btnEditItem.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		btnEditItem.setBounds(145, 113, 130, 32);
		btnEditItem.setFocusable(false);
		panel_1.add(btnEditItem);
		
		btnEditSupplier = new JButton("Edit Supplier");
		btnEditSupplier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SupplierView sv = new SupplierView();
				sv.setVisible(true);
				sv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnEditSupplier.setEnabled(false);
		btnEditSupplier.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		btnEditSupplier.setBounds(10, 113, 129, 32);
		btnEditSupplier.setFocusable(false);
		panel_1.add(btnEditSupplier);
		
		btnEditPurchase = new JButton("Edit Purchase");
		btnEditPurchase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PurchaseView pv = new PurchaseView();
				pv.setVisible(true);
				pv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnEditPurchase.setEnabled(false);
		btnEditPurchase.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		btnEditPurchase.setBounds(145, 157, 130, 32);
		panel_1.add(btnEditPurchase);
		
		btnEditCustomer = new JButton("Edit Customer");
		btnEditCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerView cv = new CustomerView();
				cv.setVisible(true);
				cv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnEditCustomer.setEnabled(false);
		btnEditCustomer.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		btnEditCustomer.setBounds(9, 159, 130, 32);
		btnEditCustomer.setFocusable(false);
		panel_1.add(btnEditCustomer);
		
		btnEditSale = new JButton("Edit Sale");
		btnEditSale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaleView sv = new SaleView();
				sv.setVisible(true);
				sv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnEditSale.setEnabled(false);
		btnEditSale.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		btnEditSale.setBounds(145, 203, 130, 32);
		btnEditSale.setFocusable(false);
		panel_1.add(btnEditSale);
		
		btnEditDeliver = new JButton("Edit Deliver");
		btnEditDeliver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeliverView dv = new DeliverView();
				dv.setVisible(true);
				dv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnEditDeliver.setEnabled(false);
		btnEditDeliver.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		btnEditDeliver.setBounds(9, 205, 130, 32);
		btnEditDeliver.setFocusable(false);
		panel_1.add(btnEditDeliver);
		
		btnEditOrder = new JButton("Edit Order");
		btnEditOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OrderView ov;
				try {
					ov = new OrderView();
					ov.setVisible(true);
					ov.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnEditOrder.setEnabled(false);
		btnEditOrder.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		btnEditOrder.setBounds(145, 249, 130, 32);
		btnEditOrder.setFocusable(false);
		panel_1.add(btnEditOrder);
		
		btnEditDelivery = new JButton("Edit Delivery");
		btnEditDelivery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeliveryView dv = new DeliveryView();
				dv.setVisible(true);
				dv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnEditDelivery.setEnabled(false);
		btnEditDelivery.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		btnEditDelivery.setBounds(9, 251, 130, 32);
		btnEditDelivery.setFocusable(false);
		panel_1.add(btnEditDelivery);
		
		btnPurchaseDetailView = new JButton("Purchase Detail View");
		btnPurchaseDetailView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PurchaseDetailView pdv = new PurchaseDetailView();
				pdv.setVisible(true);
				pdv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnPurchaseDetailView.setEnabled(false);
		btnPurchaseDetailView.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		btnPurchaseDetailView.setBounds(0, 311, 283, 32);
		panel_1.add(btnPurchaseDetailView);
		
		btnSaleDetailView = new JButton("Sale Detail View");
		btnSaleDetailView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaleDetailView sdv = new SaleDetailView();
				sdv.setVisible(true);
				sdv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnSaleDetailView.setEnabled(false);
		btnSaleDetailView.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		btnSaleDetailView.setBounds(0, 357, 283, 32);
		panel_1.add(btnSaleDetailView);
		
		btnOrderDetailView = new JButton("Order Detail View");
		btnOrderDetailView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OrderDetailView odv = new OrderDetailView();
				odv.setVisible(true);
				odv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnOrderDetailView.setEnabled(false);
		btnOrderDetailView.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		btnOrderDetailView.setBounds(0, 403, 283, 32);
		btnOrderDetailView.setFocusable(false);
		panel_1.add(btnOrderDetailView);
		
		btnDeliveryDetailView = new JButton("Delivery Detail View");
		btnDeliveryDetailView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeliveryDetailView dvd = new DeliveryDetailView();
				dvd.setVisible(true);
				dvd.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnDeliveryDetailView.setEnabled(false);
		btnDeliveryDetailView.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		btnDeliveryDetailView.setBounds(0, 449, 283, 32);
		btnDeliveryDetailView.setFocusable(false);
		panel_1.add(btnDeliveryDetailView);
		
		sm_photo = new JLabel("");
		sm_photo.setBounds(0, 0, 569, 501);
		panel_1.add(sm_photo);
		displayImg();
		displayImg1();
	}
	
	public void clear()
    {
 		txtName.setText("");
 		txtPassword.setText("");
 		txtName.requestFocus(true);
    }
	public void displayImg() {
		ImageIcon imgIco = new ImageIcon(getClass().getResource("/My_Img/register.jpeg"));
		Image img = imgIco.getImage().getScaledInstance(sm_photo.getWidth(), sm_photo.getHeight(), Image.SCALE_SMOOTH);
		sm_photo.setIcon(new ImageIcon(img));
	}
	
	public void displayImg1() {
		ImageIcon imgIco = new ImageIcon(getClass().getResource("/My_Img/register.jpeg"));
		Image img = imgIco.getImage().getScaledInstance(lblLogin.getWidth(), lblLogin.getHeight(), Image.SCALE_SMOOTH);
		lblLogin.setIcon(new ImageIcon(img));
	}
	
}
