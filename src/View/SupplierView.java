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

import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import Connection.AutoID;
import Connection.Checking;
import Controller.BrandController;
import Controller.SupplierController;
import Controller.TypeController;
import Model.BrandModel;
import Model.SupplierModel;
import Model.TypeModel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
public class SupplierView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblSupplierID;
	private JTextField txtName;
	private JTextField txtAddress;
	private JTextField txtPhone;
	private JTextField txtEmail;
	private JButton btnSave;
	private JButton btnClear;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnClose;
	private JTable tblSupplier;
	private JTextField txtShowllAll;
	private JButton btnShowAll;
	DefaultTableModel dtm = new DefaultTableModel();
	int r;
	String supplierID = null;
	private JLabel lblPhoto;
	private JLabel lblNewLabel_1_1_1_1_2;
	String path = "";
	private JLabel lblBG;
	private JScrollPane scrollPane_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SupplierView frame = new SupplierView();
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
	public SupplierView() {
		setTitle("Supplier View");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 880, 673);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(8, 0, 851, 270);
		panel.setBackground(new Color(187, 187, 134));
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Supplier ID:");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		lblNewLabel_1.setBounds(24, 23, 89, 17);
		panel.add(lblNewLabel_1);
		
		Border b = BorderFactory.createLineBorder(Color.white);
		lblSupplierID = new JLabel("dddd");
		lblSupplierID.setForeground(new Color(255, 255, 255));
		lblSupplierID.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		lblSupplierID.setBounds(170, 18, 119, 26);
		panel.add(lblSupplierID);
		
		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int centerX = (int) (screenDimension.getWidth() - getWidth()) / 2;
	    int centerY = (int) (screenDimension.getHeight() - getHeight()) / 2;
	    setLocation(centerX, centerY);
		
		JLabel lblNewLabel_1_1 = new JLabel("Supplier Name:");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(24, 59, 111, 26);
		panel.add(lblNewLabel_1_1);
		
		txtName = new JTextField();
		txtName.setBounds(143, 58, 141, 32);
		panel.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Supplier Address:");
		lblNewLabel_1_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_1.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		lblNewLabel_1_1_1.setBounds(292, 118, 125, 17);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Supplier Phone:");
		lblNewLabel_1_1_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_1_1.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		lblNewLabel_1_1_1_1.setBounds(292, 64, 111, 17);
		panel.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Supplier Email:");
		lblNewLabel_1_1_1_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_1_1_1.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		lblNewLabel_1_1_1_1_1.setBounds(24, 118, 111, 17);
		panel.add(lblNewLabel_1_1_1_1_1);
		
		txtAddress = new JTextField();
		txtAddress.setColumns(10);
		txtAddress.setBounds(411, 111, 141, 32);
		panel.add(txtAddress);
		
		txtPhone = new JTextField();
		txtPhone.setColumns(10);
		txtPhone.setBounds(411, 58, 141, 32);
		panel.add(txtPhone);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(143, 112, 141, 32);
		panel.add(txtEmail);
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SupplierModel sm = new SupplierModel();
				SupplierController sc = new SupplierController();
				if(lblSupplierID.getText().trim().toString().equals("")||txtName.getText().trim().toString().equals("") ||
						txtAddress.getText().trim().toString().equals("")||txtPhone.getText().trim().toString().equals("")||txtAddress.getText().trim().toString().equals("")) {
					JOptionPane.showMessageDialog(null, "There is a blank field!","Fail", JOptionPane.ERROR_MESSAGE);
					txtName.requestFocus(true);
					txtName.selectAll();
				}else {
					sm.setSupplier_id(lblSupplierID.getText().toString());
					sm.setName(txtName.getText().toString());
					sm.setAddress(txtAddress.getText().toString());
					sm.setEmail(txtEmail.getText().toString());
					sm.setPhone(txtPhone.getText().toString());
					lblPhoto.setIcon(null);
					if(Checking.IsValidName(sm.getName()) || Checking.IsValidName(sm.getAddress()) || Checking.IsValidName(sm.getEmail()) ||
							Checking.IsValidName(sm.getPhone())
							||(!Checking.IsAllDigit(sm.getName())) || (!Checking.IsAllDigit(sm.getAddress()))
							||(!Checking.IsAllDigit(sm.getEmail()))
							) {
						JOptionPane.showMessageDialog(null, "Invlaid related field","Invlaid", JOptionPane.ERROR_MESSAGE);
						txtName.requestFocus(true);
						txtName.selectAll();
					}else if(!Checking.IsEmailformat(sm.getEmail())) {
						JOptionPane.showMessageDialog(null, "Email Format Error","Invlaid", JOptionPane.ERROR_MESSAGE);
						txtName.requestFocus(true);
						txtName.selectAll();
						}
					else if(!Checking.isPhoneNo(sm.getPhone())) {
						JOptionPane.showMessageDialog(null, "Phone_number Format Error","Invlaid", JOptionPane.ERROR_MESSAGE);
						txtName.requestFocus(true);
						txtName.selectAll();
					}
					else {
						try {
								int rs;
								try {
									rs = sc.insert(sm,path);
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
								
								
							
						} catch (HeadlessException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}
		});
		btnSave.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		btnSave.setBounds(42, 184, 89, 32);
		panel.add(btnSave);
		
		btnUpdate = new JButton("Update");
		btnUpdate.setEnabled(false);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SupplierModel sm = new SupplierModel();
				SupplierController sc = new SupplierController();
				if(lblSupplierID.getText().trim().toString().equals("")||txtName.getText().trim().toString().equals("") ||
						txtAddress.getText().trim().toString().equals("")||txtPhone.getText().trim().toString().equals("")||txtAddress.getText().trim().toString().equals("")) {
					JOptionPane.showMessageDialog(null, "There is a blank field!","Fail", JOptionPane.ERROR_MESSAGE);
					txtName.requestFocus(true);
					txtName.selectAll();
				}else {
					sm.setSupplier_id(lblSupplierID.getText().toString());
					sm.setName(txtName.getText().toString());
					sm.setAddress(txtAddress.getText().toString());
					sm.setEmail(txtEmail.getText().toString());
					sm.setPhone(txtPhone.getText().toString());
					lblPhoto.setIcon(null);
					if(Checking.IsValidName(sm.getName()) ) {
						JOptionPane.showMessageDialog(null, "Invlaid name field","Invlaid", JOptionPane.ERROR_MESSAGE);
						txtName.requestFocus(true);
						txtName.selectAll();
					}else if(Checking.IsValidName(sm.getAddress())) {
						JOptionPane.showMessageDialog(null, "Invlaid address field","Invlaid", JOptionPane.ERROR_MESSAGE);
						txtName.requestFocus(true);
						txtName.selectAll();
					}else if(Checking.IsValidName(sm.getEmail())) {
						JOptionPane.showMessageDialog(null, "Invlaid email field","Invlaid", JOptionPane.ERROR_MESSAGE);
						txtName.requestFocus(true);
						txtName.selectAll();
					}else if(Checking.IsValidName(sm.getPhone())) {
						JOptionPane.showMessageDialog(null, "Invlaid phone field","Invlaid", JOptionPane.ERROR_MESSAGE);
						txtName.requestFocus(true);
						txtName.selectAll();
					}else if(!Checking.IsAllDigit(sm.getName())) {
						JOptionPane.showMessageDialog(null, "Name have all digit","Invlaid", JOptionPane.ERROR_MESSAGE);
						txtName.requestFocus(true);
						txtName.selectAll();
					}else if(!Checking.IsAllDigit(sm.getAddress())){
						JOptionPane.showMessageDialog(null, "Address have all digit","Invlaid", JOptionPane.ERROR_MESSAGE);
						txtName.requestFocus(true);
						txtName.selectAll();
					}else if(!Checking.IsEmailformat(sm.getEmail())) {
						JOptionPane.showMessageDialog(null, "Email Format Error","Invlaid", JOptionPane.ERROR_MESSAGE);
						txtName.requestFocus(true);
						txtName.selectAll();
						}
					else if(!Checking.isPhoneNo(sm.getPhone())) {
						JOptionPane.showMessageDialog(null, "Phone_number Format Error","Invlaid", JOptionPane.ERROR_MESSAGE);
						txtName.requestFocus(true);
						txtName.selectAll();
					}
					else {
						try {
								int rs;
								try {
									rs = sc.update(sm,path);
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
		btnUpdate.setBounds(170, 184, 89, 32);
		panel.add(btnUpdate);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SupplierModel sm = new SupplierModel();
				sm.setSupplier_id(supplierID);
				if(!sm.getSupplier_id().isBlank()) {
					if(JOptionPane.showConfirmDialog(null,"Are you sure you want to delete?","Confrim",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION) {
						SupplierController sc = new SupplierController();
						int rs = sc.delete(sm,path);
						if(rs==1) {
							
							JOptionPane.showMessageDialog(null,"Delete Successfully","Successfully", JOptionPane.INFORMATION_MESSAGE);
                           
							AutoID();
							showList();
							clear();
							
						}else {
							System.out.println(rs);
							JOptionPane.showMessageDialog(null,"Delete fails");
						}
					}
		
			}
			}
		});
		btnDelete.setEnabled(false);
		btnDelete.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		btnDelete.setBounds(292, 184, 89, 32);
		panel.add(btnDelete);
		
		btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
				AutoID();
			}
		});
		btnClear.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		btnClear.setBounds(446, 184, 89, 32);
		panel.add(btnClear);
		
		btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		btnClose.setBounds(543, 184, 89, 32);
		panel.add(btnClose);
		
		lblPhoto = new JLabel("");
		lblPhoto.setBounds(679, 41, 141, 129);
		lblPhoto.setBorder(b);
		panel.add(lblPhoto);
		
		lblNewLabel_1_1_1_1_2 = new JLabel("Supplier Photo:");
		lblNewLabel_1_1_1_1_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_1_1_2.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		lblNewLabel_1_1_1_1_2.setBounds(560, 98, 111, 17);
		panel.add(lblNewLabel_1_1_1_1_2);
		
		JButton btnUpload = new JButton("UPload");
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
		btnUpload.setBounds(710, 184, 89, 32);
		panel.add(btnUpload);
		
		JLabel lblNewLabel = new JLabel("Supplier Entry And Supplier List");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(307, 13, 286, 32);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Rockwell", Font.BOLD, 18));
		
		lblBG = new JLabel("");
		lblBG.setBounds(0, 0, 861, 631);
		panel.add(lblBG);
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(245, 245, 220));
		panel_1.setBounds(8, 332, 851, 304);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(8, 14, 835, 276);
		panel_1.add(scrollPane_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane_1.setViewportView(scrollPane);
		
		tblSupplier = new JTable();
		tblSupplier.setBackground(new Color(255, 255, 255));
		tblSupplier.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				r = tblSupplier.getSelectedRow();
				supplierID = (String)tblSupplier.getValueAt(r, 1);
				lblSupplierID.setText(supplierID);
				txtName.setText((String)tblSupplier.getValueAt(r, 2));
				txtAddress.setText((String)tblSupplier.getValueAt(r, 3));
				txtPhone.setText((String)tblSupplier.getValueAt(r, 4));
				txtEmail.setText((String)tblSupplier.getValueAt(r, 5));
				ImageIcon icon = (ImageIcon) tblSupplier.getValueAt(r, 0);
				lblPhoto.setIcon(icon);
				btnSave.setEnabled(false);
				btnUpdate.setEnabled(true);
				btnDelete.setEnabled(true);
				txtName.requestFocus();
				txtName.selectAll();
				System.out.println(supplierID);
			}
			
		});
		
		scrollPane.setViewportView(tblSupplier);
		
		JLabel lblNewLabel_1_2 = new JLabel("Supplier Name:");
		lblNewLabel_1_2.setBounds(409, 290, 116, 17);
		lblNewLabel_1_2.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		contentPane.add(lblNewLabel_1_2);
		
		txtShowllAll = new JTextField();
		txtShowllAll.setBounds(544, 284, 141, 32);
		txtShowllAll.addKeyListener(new KeyAdapter() {
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
		txtShowllAll.setColumns(10);
		contentPane.add(txtShowllAll);
		
		btnShowAll = new JButton("Show All");
		btnShowAll.setBounds(693, 284, 89, 32);
		btnShowAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showList();
			}
		});
		btnShowAll.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		contentPane.add(btnShowAll);
		displayImg();
		AutoID();
		createTable();
		showList();
	}
	public void AutoID() {
		try {
			lblSupplierID.setText(AutoID.getAutoID("supplier_id", "supplier", "SU-"));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void setColumnWidth(int index , int width,int height)
	{
	     DefaultTableColumnModel tcm = (DefaultTableColumnModel)tblSupplier.getColumnModel();
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
    	dtm.addColumn("Supplier Photo");
	     dtm.addColumn("Supplier ID");
	     dtm.addColumn("Name");
	     dtm.addColumn("Address"); 
	     dtm.addColumn("Phone");
	     dtm.addColumn("Email");
	     tblSupplier.setModel(dtm);
	     setColumnWidth(0,80,100);
	     setColumnWidth(1,60,100);
	     setColumnWidth(2,60,100);
	     setColumnWidth(3,60,100);
	     setColumnWidth(4,60,100);
	     setColumnWidth(5,80,100);
	     tblSupplier.getColumnModel().getColumn(0).setCellRenderer(new ImageTableCellRenderer());
	     
    }
    
	
	public void clear()
	    {
	    	btnSave.setEnabled(true);
			btnUpdate.setEnabled(false);
			btnDelete.setEnabled(false);
	 		txtName.setText("");
	 		txtAddress.setText("");
	 		txtPhone.setText("");
	 		txtEmail.setText("");
	 		lblPhoto.setIcon(null);
	 		txtName.requestFocus(true);
	    }
	public void showList() {
		Object data[] = new Object[6];
		SupplierController sc = new SupplierController();
		try {
			List<SupplierModel> list = sc.selectall();
			dtm.setRowCount(0);
			for(SupplierModel sp:list) {
				data[0] = sp.getImg();
				data[1] = sp.getSupplier_id();
				data[2] = sp.getName();
				data[3] = sp.getAddress();
				data[4] = sp.getPhone();
				data[5] = sp.getEmail();
				dtm.addRow(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public void showListOne() throws SQLException{
		Object data[] = new Object[6];
		SupplierController sc = new SupplierController();
		SupplierModel s = new SupplierModel();
		s.setName(txtShowllAll.getText().toString().trim());
		List<SupplierModel> list = sc.selectone(s,path);
		dtm.setRowCount(0);
		for(SupplierModel sp:list) {
			data[0] = sp.getImg();
			data[1] = sp.getSupplier_id();
			data[2] = sp.getName();
			data[3] = sp.getAddress();
			data[4] = sp.getPhone();
			data[5] = sp.getEmail();
			dtm.addRow(data);
		}
	}
	
	public void displayImg() {
		ImageIcon imgIco = new ImageIcon(getClass().getResource("/My_Img/supplier.jpeg"));
		Image img = imgIco.getImage().getScaledInstance(lblBG.getWidth(), lblBG.getHeight(), Image.SCALE_SMOOTH);
		lblBG.setIcon(new ImageIcon(img));
	}
}
