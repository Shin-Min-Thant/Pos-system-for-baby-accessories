package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import Connection.AutoID;
import Connection.Checking;
import Controller.CustomerController;
import Model.CustomerModel;
import View.SupplierView.CustomTableCellRenderer;
import View.SupplierView.ImageTableCellRenderer;

import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JSpinner;

public class CustomerView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCustomerName;
	private JTextField txtCustomerAddress;
	private JTextField txtCustomerPhone;
	private JTextField txtCustomerEmail;
	private JTextField txtShowAll;
	private JTable tblCustomer;
	DefaultTableModel dtm = new DefaultTableModel();
	private JLabel lblCustomerID;
	private JButton btnSave;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnClear;
	private JButton btnClose;
	private JButton btnShowAll;
	int r;
	String Customer_id=null;
	private JLabel lblCustomerImg;
	private JLabel lblPhoto;
	private JLabel lblNewLabel_1_1_1_2;
	String path = "";
	private JScrollPane scrollPane_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerView frame = new CustomerView();
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
	public CustomerView() {
		setTitle("Customer View");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 954, 616);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBounds(8, 14, 932, 280);
		contentPane.add(contentPane_1);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(224, 255, 255));
		panel.setBounds(0, 14, 924, 223);
		contentPane_1.add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("Customer ID:");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		lblNewLabel_1.setBounds(29, 37, 89, 17);
		panel.add(lblNewLabel_1);
		
		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int centerX = (int) (screenDimension.getWidth() - getWidth()) / 2;
	    int centerY = (int) (screenDimension.getHeight() - getHeight()) / 2;
	    setLocation(centerX, centerY);
		
		lblCustomerID = new JLabel("");
		lblCustomerID.setForeground(new Color(255, 255, 255));
		lblCustomerID.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		lblCustomerID.setBounds(162, 33, 119, 26);
		panel.add(lblCustomerID);
		
		JLabel lblNewLabel_1_1 = new JLabel("Custome Name:");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(29, 68, 111, 17);
		panel.add(lblNewLabel_1_1);
		
		txtCustomerName = new JTextField();
		txtCustomerName.setColumns(10);
		txtCustomerName.setBounds(162, 61, 141, 32);
		panel.add(txtCustomerName);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Customer Address:");
		lblNewLabel_1_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_1.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		lblNewLabel_1_1_1.setBounds(29, 123, 125, 17);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Customer Phone:");
		lblNewLabel_1_1_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_1_1.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		lblNewLabel_1_1_1_1.setBounds(341, 68, 111, 17);
		panel.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Customer Email:");
		lblNewLabel_1_1_1_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_1_1_1.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		lblNewLabel_1_1_1_1_1.setBounds(341, 123, 111, 17);
		panel.add(lblNewLabel_1_1_1_1_1);
		
		txtCustomerAddress = new JTextField();
		txtCustomerAddress.setColumns(10);
		txtCustomerAddress.setBounds(162, 117, 141, 32);
		panel.add(txtCustomerAddress);
		
		txtCustomerPhone = new JTextField();
		txtCustomerPhone.setColumns(10);
		txtCustomerPhone.setBounds(460, 62, 141, 32);
		panel.add(txtCustomerPhone);
		
		txtCustomerEmail = new JTextField();
		txtCustomerEmail.setColumns(10);
		txtCustomerEmail.setBounds(460, 117, 141, 32);
		panel.add(txtCustomerEmail);
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerModel cm = new CustomerModel();
				CustomerController cc = new CustomerController();
				if(lblCustomerID.getText().trim().toString().equals("")||txtCustomerName.getText().trim().toString().equals("") ||
						txtCustomerAddress.getText().trim().toString().equals("")||txtCustomerPhone.getText().trim().toString().equals("")||txtCustomerEmail.getText().trim().toString().equals("")) {
					JOptionPane.showMessageDialog(null, "There is a blank field!","Fail", JOptionPane.ERROR_MESSAGE);
					txtShowAll.requestFocus(true);
					txtShowAll.selectAll();
				}else {
					cm.setCustomer_id(lblCustomerID.getText().toString());
					cm.setName(txtCustomerName.getText().toString());
					cm.setAddress(txtCustomerAddress.getText().toString());
					cm.setEmail(txtCustomerEmail.getText().toString());
					cm.setPhone(txtCustomerPhone.getText().toString());
					lblPhoto.setIcon(null);
					if(Checking.IsValidName(cm.getName()) || Checking.IsValidName(cm.getAddress()) || Checking.IsValidName(cm.getEmail()) ||
							Checking.IsValidName(cm.getPhone())
							||(!Checking.IsAllDigit(cm.getName())) || (!Checking.IsAllDigit(cm.getAddress()))
							||(!Checking.IsAllDigit(cm.getEmail()))
							) {
						JOptionPane.showMessageDialog(null, "Invlaid related field","Invlaid", JOptionPane.ERROR_MESSAGE);
						txtShowAll.requestFocus(true);
						txtShowAll.selectAll();
					}else if(!Checking.IsEmailformat(cm.getEmail())) {
						JOptionPane.showMessageDialog(null, "Email Format Error","Invlaid", JOptionPane.ERROR_MESSAGE);
						txtShowAll.requestFocus(true);
						txtShowAll.selectAll();
						}
					else if(!Checking.isPhoneNo(cm.getPhone())) {
						JOptionPane.showMessageDialog(null, "Phone_number Format Error","Invlaid", JOptionPane.ERROR_MESSAGE);
						txtShowAll.requestFocus(true);
						txtShowAll.selectAll();
					}
					else {
						try {
							if(cc.isduplicate(cm)) {
								JOptionPane.showMessageDialog(null, "There is a same brand name!","Fail", JOptionPane.ERROR_MESSAGE);	
								txtCustomerName.requestFocus(true);
								txtCustomerName.selectAll();
							}else {
								int rs;
								try {
									rs = cc.insert(cm,path);
									if(rs==1) {
										JOptionPane.showMessageDialog(null, "Save Successfully","Successfully", JOptionPane.INFORMATION_MESSAGE);
										AutoID();
										showList();
										clear();
									}
								} catch (FileNotFoundException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								
								
							}
						} catch (HeadlessException | SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}
		});
		btnSave.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		btnSave.setBounds(83, 171, 89, 32);
		panel.add(btnSave);
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerModel cm = new CustomerModel();
				CustomerController cc = new CustomerController();
				if(lblCustomerID.getText().trim().toString().equals("")||txtCustomerName.getText().trim().toString().equals("") ||
						txtCustomerAddress.getText().trim().toString().equals("")||txtCustomerPhone.getText().trim().toString().equals("")||txtCustomerAddress.getText().trim().toString().equals("")) {
					JOptionPane.showMessageDialog(null, "There is a blank field!","Fail", JOptionPane.ERROR_MESSAGE);
					txtCustomerName.requestFocus(true);
					txtCustomerName.selectAll();
				}else {
					cm.setCustomer_id(lblCustomerID.getText().toString());
					cm.setName(txtCustomerName.getText().toString());
					cm.setAddress(txtCustomerAddress.getText().toString());
					cm.setEmail(txtCustomerEmail.getText().toString());
					cm.setPhone(txtCustomerPhone.getText().toString());
					lblPhoto.setIcon(null);
					if(Checking.IsValidName(cm.getName()) ) {
						JOptionPane.showMessageDialog(null, "Invlaid name field","Invlaid", JOptionPane.ERROR_MESSAGE);
						txtCustomerName.requestFocus(true);
						txtCustomerName.selectAll();
					}else if(Checking.IsValidName(cm.getAddress())) {
						JOptionPane.showMessageDialog(null, "Invlaid address field","Invlaid", JOptionPane.ERROR_MESSAGE);
						txtCustomerName.requestFocus(true);
						txtCustomerName.selectAll();
					}else if(Checking.IsValidName(cm.getEmail())) {
						JOptionPane.showMessageDialog(null, "Invlaid email field","Invlaid", JOptionPane.ERROR_MESSAGE);
						txtCustomerName.requestFocus(true);
						txtCustomerName.selectAll();
					}else if(Checking.IsValidName(cm.getPhone())) {
						JOptionPane.showMessageDialog(null, "Invlaid phone field","Invlaid", JOptionPane.ERROR_MESSAGE);
						txtCustomerName.requestFocus(true);
						txtCustomerName.selectAll();
					}else if(!Checking.IsAllDigit(cm.getName())) {
						JOptionPane.showMessageDialog(null, "Name have all digit","Invlaid", JOptionPane.ERROR_MESSAGE);
						txtCustomerName.requestFocus(true);
						txtCustomerName.selectAll();
					}else if(!Checking.IsAllDigit(cm.getAddress())){
						JOptionPane.showMessageDialog(null, "Address have all digit","Invlaid", JOptionPane.ERROR_MESSAGE);
						txtCustomerName.requestFocus(true);
						txtCustomerName.selectAll();
					}else if(!Checking.IsEmailformat(cm.getEmail())) {
						JOptionPane.showMessageDialog(null, "Email Format Error","Invlaid", JOptionPane.ERROR_MESSAGE);
						txtCustomerName.requestFocus(true);
						txtCustomerName.selectAll();
						}
					else if(!Checking.isPhoneNo(cm.getPhone())) {
						JOptionPane.showMessageDialog(null, "Phone_number Format Error","Invlaid", JOptionPane.ERROR_MESSAGE);
						txtCustomerName.requestFocus(true);
						txtCustomerName.selectAll();
					}
					else {
						try {
								int rs;
								try {
									rs = cc.update(cm,path);
									if(rs==1) {
										JOptionPane.showMessageDialog(null, "Update Successfully","Successfully", JOptionPane.INFORMATION_MESSAGE);
										AutoID();
										clear();
										showList();
									}
								} catch (FileNotFoundException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								
								
							
						} catch (HeadlessException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}
		});
		btnUpdate.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		btnUpdate.setEnabled(false);
		btnUpdate.setBounds(372, 171, 89, 32);
		panel.add(btnUpdate);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        CustomerModel cm = new CustomerModel();
		        cm.setCustomer_id(Customer_id);
		        if (!cm.getCustomer_id().isBlank()) {
		            if (JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
		                CustomerController cc = new CustomerController();
		                int rs = cc.delete(cm, path);
						if (rs == 1) {
						    JOptionPane.showMessageDialog(null, "Delete Successfully", "Successfully", JOptionPane.INFORMATION_MESSAGE);
						    AutoID();
						    showList();
						    clear();
						} else {
						    System.out.println(rs);
						    JOptionPane.showMessageDialog(null, "Delete fails");
						}
		            }
		        }
		    }
		});

		btnDelete.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		btnDelete.setEnabled(false);
		btnDelete.setBounds(226, 171, 89, 32);
		panel.add(btnDelete);
		
		btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
				lblCustomerID.requestFocus(true);			}
		});
		btnClear.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		btnClear.setBounds(497, 171, 89, 32);
		panel.add(btnClear);
		
		btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		btnClose.setBounds(620, 171, 89, 32);
		panel.add(btnClose);
		
		JLabel lblNewLabel = new JLabel("Customer Entry And Customer List");
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setBounds(319, 14, 327, 31);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Rockwell Condensed", Font.BOLD, 20));
		Border b = BorderFactory.createLineBorder(Color.white);
		lblPhoto = new JLabel("");
		lblPhoto.setBackground(new Color(255, 255, 0));
		lblPhoto.setForeground(new Color(255, 255, 0));
		lblPhoto.setBounds(761, 14, 141, 145);
		lblPhoto.setBorder(b);
		panel.add(lblPhoto);
		
		lblNewLabel_1_1_1_2 = new JLabel("Customer Photo:");
		lblNewLabel_1_1_1_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_1_2.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		lblNewLabel_1_1_1_2.setBounds(620, 91, 111, 17);
		panel.add(lblNewLabel_1_1_1_2);
		
		JButton btnUpload = new JButton("Upload");
		btnUpload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.showOpenDialog(null);
				File f = chooser.getSelectedFile();
				if(f!=null) {
					path = f.getAbsolutePath();
					try {
						BufferedImage bi = ImageIO.read(new File(path));
						Image img = bi.getScaledInstance(140, 172, Image.SCALE_SMOOTH);
						ImageIcon icon = new ImageIcon(img);
						lblPhoto.setIcon(icon);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnUpload.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		btnUpload.setBounds(771, 171, 89, 32);
		panel.add(btnUpload);
		
		lblCustomerImg = new JLabel("");
		lblCustomerImg.setBounds(0, -65, 924, 288);
		panel.add(lblCustomerImg);
		lblCustomerImg.setForeground(new Color(0, 0, 255));
		
		JLabel lblNewLabel_1_2 = new JLabel("Customer Name:");
		lblNewLabel_1_2.setBounds(436, 251, 127, 24);
		contentPane_1.add(lblNewLabel_1_2);
		lblNewLabel_1_2.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		
		txtShowAll = new JTextField();
		txtShowAll.setBounds(571, 251, 141, 32);
		contentPane_1.add(txtShowAll);
		txtShowAll.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				try {
					showListOne();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		txtShowAll.setColumns(10);
		
		btnShowAll = new JButton("Show All");
		btnShowAll.setBounds(762, 251, 89, 32);
		contentPane_1.add(btnShowAll);
		btnShowAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showList();
			}
		});
		btnShowAll.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(8, 299, 924, 265);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(8, 14, 908, 237);
		panel_1.add(scrollPane_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane_1.setViewportView(scrollPane);
		
		tblCustomer = new JTable();
		tblCustomer.setBackground(new Color(224, 255, 255));
		tblCustomer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				r = tblCustomer.getSelectedRow();
				Customer_id = (String)tblCustomer.getValueAt(r, 1);
				System.out.println(Customer_id);
				lblCustomerID.setText(Customer_id);
				txtCustomerName.setText((String)tblCustomer.getValueAt(r, 2));
				txtCustomerAddress.setText((String)tblCustomer.getValueAt(r, 3));
				txtCustomerPhone.setText((String)tblCustomer.getValueAt(r, 4));
				txtCustomerEmail.setText((String)tblCustomer.getValueAt(r, 5));
				ImageIcon icon = (ImageIcon) tblCustomer.getValueAt(r, 0);
				lblPhoto.setIcon(icon);
				btnSave.setEnabled(false);
				btnUpdate.setEnabled(true);
				btnDelete.setEnabled(true);
				txtCustomerName.requestFocus();
				txtCustomerName.selectAll();
			}
		});
		scrollPane.setViewportView(tblCustomer);
		displayImg();
		AutoID();
		createTable();
		showList();
	}
	public void AutoID() {
		try {
			lblCustomerID.setText(AutoID.getAutoID("customer_id", "customer", "CU-"));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void setColumnWidth(int index , int width,int height)
	{
	     DefaultTableColumnModel tcm = (DefaultTableColumnModel)tblCustomer.getColumnModel();
	     TableColumn tc = tcm.getColumn(index);
	     tc.setPreferredWidth(width);
	     tc.setCellRenderer(new CustomTableCellRenderer(height));
    }
	
//	set height by self
	class CustomTableCellRenderer extends DefaultTableCellRenderer {
	    private int height;

	    public CustomTableCellRenderer(int height) {
	        this.height = height;
	    }

	    @Override
	    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
	        Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
	        table.setRowHeight(row, height);
	        return cellComponent;
	    }
	}
//	set to show image in table
	public class ImageTableCellRenderer extends DefaultTableCellRenderer {
	    @Override
	    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
	        JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
	        
	        // Set the icon with proper scaling to fit the row height
	        if (value instanceof ImageIcon) {
	            ImageIcon icon = (ImageIcon) value;
	            Image img = icon.getImage();
	            int iconWidth = img.getWidth(null);
	            int iconHeight = img.getHeight(null);
	            int rowHeight = table.getRowHeight(row);
	            
	            if (iconHeight > rowHeight) {
	                double scaleFactor = (double) rowHeight / iconHeight;
	                int scaledWidth = (int) (iconWidth * scaleFactor);
	                img = img.getScaledInstance(scaledWidth, rowHeight, Image.SCALE_SMOOTH);
	                icon = new ImageIcon(img);
	            }
	            
	            label.setIcon(icon);
	            label.setHorizontalAlignment(JLabel.CENTER);
	            label.setVerticalAlignment(JLabel.CENTER);
	            label.setText("");
	        }
	        
	        return label;
	    }
	}
    public void createTable()
	{
    	 dtm.addColumn("Customer Photo");
	     dtm.addColumn("Customer ID");
	     dtm.addColumn("Name");
	     dtm.addColumn("Address"); 
	     dtm.addColumn("Phone");
	     dtm.addColumn("Email");
	     tblCustomer.setModel(dtm);
	     setColumnWidth(0,80,100);
	     setColumnWidth(1,60,100);
	     setColumnWidth(2,60,100);
	     setColumnWidth(3,60,100);
	     setColumnWidth(4,60,100);
	     setColumnWidth(5,80,100);
	     tblCustomer.getColumnModel().getColumn(0).setCellRenderer(new ImageTableCellRenderer());
    }

	public void clear()
	    {
	    	btnSave.setEnabled(true);
			btnUpdate.setEnabled(false);
			btnDelete.setEnabled(false);
	 		txtCustomerName.setText("");
	 		txtCustomerAddress.setText("");
	 		txtCustomerPhone.setText("");
	 		txtCustomerEmail.setText("");
	 		lblPhoto.setIcon(null);
	 		txtShowAll.requestFocus(true);
	    }
	
	public void showList() {
		Object data[] = new Object[6];
		CustomerController cc = new CustomerController();
		try {
			List<CustomerModel> list = cc.selectall();
			dtm.setRowCount(0);
			for(CustomerModel cm:list) {
				data[0] = cm.getImg();
				data[1] = cm.getCustomer_id();
				data[2] = cm.getName();
				data[3] = cm.getAddress();
				data[4] = cm.getPhone();
				data[5] = cm.getEmail();
				dtm.addRow(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void showListOne() throws SQLException{
		Object data[] = new Object[6];
		CustomerController cc = new CustomerController();
		CustomerModel cm = new CustomerModel();
		cm.setName(txtShowAll.getText().toString().trim());
		List<CustomerModel> list = cc.selectone(cm,path);
		dtm.setRowCount(0);
		for(CustomerModel c:list) {
			data[0] = c.getImg();
			data[1] = c.getCustomer_id();
			data[2] = c.getName();
			data[3] = c.getAddress();
			data[4] = c.getPhone();
			data[5] = c.getEmail();
			dtm.addRow(data);
		}
	}
	
	public void displayImg() {
		ImageIcon imgIco = new ImageIcon(getClass().getResource("/My_Img/customer.jpeg"));
		Image img = imgIco.getImage().getScaledInstance(lblCustomerImg.getWidth(), lblCustomerImg.getHeight(), Image.SCALE_SMOOTH);
		lblCustomerImg.setIcon(new ImageIcon(img));
	}
}
