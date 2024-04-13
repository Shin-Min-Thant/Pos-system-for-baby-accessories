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
import java.sql.SQLException;
import java.util.List;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import Connection.AutoID;
import Connection.Checking;
import Controller.DeliverController;
import Model.DeliverModel;
import View.CustomerView.CustomTableCellRenderer;
import View.CustomerView.ImageTableCellRenderer;

import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DeliverView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtAddress;
	private JTextField txtPhone;
	private JTextField txtEmail;
	private JTextField txtShowAll;
	private JTable tblDeliver;
	private JButton btnSave;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnClear;
	private JButton btnClose;
	private JButton btnShowAll;
	private JLabel lblDeliverID;
	DefaultTableModel dtm = new DefaultTableModel();
	int r;
	String deliverID = null;
	private JTextField txtCapacity;
	String path = "";
	private JLabel lblDeliverImg;
	private JLabel lblNewLabel_1_1_1_2;
	private JButton btnUpload;
	private JLabel lblPhoto;
	private JScrollPane scrollPane_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeliverView frame = new DeliverView();
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
	public DeliverView() {
		setTitle("Deliver View");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 925, 644);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(187, 187, 134));
		panel.setBounds(8, 14, 885, 286);
		contentPane.add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("Deliver ID:");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		lblNewLabel_1.setBounds(29, 37, 89, 17);
		panel.add(lblNewLabel_1);
		
		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int centerX = (int) (screenDimension.getWidth() - getWidth()) / 2;
	    int centerY = (int) (screenDimension.getHeight() - getHeight()) / 2;
	    setLocation(centerX, centerY);
		
		JLabel lblNewLabel_1_1 = new JLabel("Deliver Name:");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(29, 74, 111, 17);
		panel.add(lblNewLabel_1_1);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(162, 68, 141, 32);
		panel.add(txtName);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Deliver Address:");
		lblNewLabel_1_1_1 .setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_1 .setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		lblNewLabel_1_1_1.setBounds(326, 74, 111, 17);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Deliver Phone:");
		lblNewLabel_1_1_1_1 .setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_1_1 .setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		lblNewLabel_1_1_1_1.setBounds(638, 74, 93, 17);
		panel.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Deliver Email:");
		lblNewLabel_1_1_1_1_1 .setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_1_1_1 .setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		lblNewLabel_1_1_1_1_1.setBounds(29, 131, 111, 17);
		panel.add(lblNewLabel_1_1_1_1_1);
		
		txtAddress = new JTextField();
		txtAddress.setColumns(10);
		txtAddress.setBounds(466, 68, 141, 32);
		panel.add(txtAddress);
		
		txtPhone = new JTextField();
		txtPhone.setColumns(10);
		txtPhone.setBounds(733, 68, 141, 32);
		panel.add(txtPhone);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(162, 125, 141, 32);
		panel.add(txtEmail);
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeliverModel sm = new DeliverModel();
				DeliverController sc = new DeliverController();
				if(lblDeliverID.getText().trim().toString().equals("")||txtName.getText().trim().toString().equals("") ||
						txtAddress.getText().trim().toString().equals("")||txtPhone.getText().trim().toString().equals("")||
						txtAddress.getText().trim().toString().equals("") || txtCapacity.getText().trim().toString().equals("")) {
					JOptionPane.showMessageDialog(null, "There is a blank field!","Fail", JOptionPane.ERROR_MESSAGE);
					txtName.requestFocus(true);
					txtName.selectAll();
				}else {
					sm.setDeliver_id(lblDeliverID.getText().toString());
					sm.setName(txtName.getText().toString());
					sm.setAddress(txtAddress.getText().toString());
					sm.setEmail(txtEmail.getText().toString());
					sm.setPhone(txtPhone.getText().toString());
					sm.setDeliver_capacity(Integer.parseInt(txtCapacity.getText().toString()));
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
							if(sc.isduplicate(sm)) {
								JOptionPane.showMessageDialog(null, "There is a same brand name!","Fail", JOptionPane.ERROR_MESSAGE);	
								txtName.requestFocus(true);
								txtName.selectAll();
							}else {
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
		btnSave.setBounds(123, 238, 89, 32);
		panel.add(btnSave);
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeliverModel sm = new DeliverModel();
				DeliverController sc = new DeliverController();
				if(lblDeliverID.getText().trim().toString().equals("")||txtName.getText().trim().toString().equals("") ||
						txtAddress.getText().trim().toString().equals("")||txtPhone.getText().trim().toString().equals("")||
						txtAddress.getText().trim().toString().equals("") || txtCapacity.getText().trim().toString().equals("")) {
					JOptionPane.showMessageDialog(null, "There is a blank field!","Fail", JOptionPane.ERROR_MESSAGE);
					txtName.requestFocus(true);
					txtName.selectAll();
				}else {
					sm.setDeliver_id(lblDeliverID.getText().toString());
					sm.setName(txtName.getText().toString());
					sm.setAddress(txtAddress.getText().toString());
					sm.setEmail(txtEmail.getText().toString());
					sm.setPhone(txtPhone.getText().toString());
					sm.setDeliver_capacity(Integer.parseInt(txtCapacity.getText().toString()));
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
									rs = sc.update(sm,path);
									if(rs==1) {
										JOptionPane.showMessageDialog(null, "Update Successfully","Successfully", JOptionPane.INFORMATION_MESSAGE);
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
		btnUpdate.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		btnUpdate.setEnabled(false);
		btnUpdate.setBounds(277, 238, 89, 32);
		panel.add(btnUpdate);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeliverModel sm = new DeliverModel();
				sm.setDeliver_id(deliverID);
				if(!sm.getDeliver_id().isBlank()) {
					if(JOptionPane.showConfirmDialog(null,"Are you sure you want to delete?","Confrim",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION) {
						DeliverController sc = new DeliverController();
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
		btnDelete.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		btnDelete.setEnabled(false);
		btnDelete.setBounds(423, 238, 89, 32);
		panel.add(btnDelete);
		
		btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
				AutoID();
			}
		});
		btnClear.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		btnClear.setBounds(579, 238, 89, 32);
		panel.add(btnClear);
		
		btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		btnClose.setBounds(713, 238, 89, 32);
		panel.add(btnClose);
		
		lblDeliverID = new JLabel("");
		lblDeliverID .setForeground(new Color(255, 255, 255));
		lblDeliverID .setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		lblDeliverID.setBounds(162, 29, 141, 25);
		panel.add(lblDeliverID);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Deliver Capacity:");
		lblNewLabel_1_1_1_1_1_1 .setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_1_1_1_1 .setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		lblNewLabel_1_1_1_1_1_1.setBounds(326, 131, 111, 17);
		panel.add(lblNewLabel_1_1_1_1_1_1);
		
		txtCapacity = new JTextField();
		txtCapacity.setColumns(10);
		txtCapacity.setBounds(466, 125, 141, 32);
		panel.add(txtCapacity);
		
		JLabel lblNewLabel = new JLabel("Deliver Entry And Deliver List");
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(343, 14, 311, 31);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Rockwell", Font.BOLD, 20));
		
		Border b = BorderFactory.createLineBorder(Color.black);
		lblDeliverImg = new JLabel("");
		lblDeliverImg.setBounds(763, 114, 111, 110);
		lblDeliverImg.setBorder(b);
		panel.add(lblDeliverImg);
		
		lblNewLabel_1_1_1_2 = new JLabel("Deliver Photo:");
		lblNewLabel_1_1_1_2 .setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_1_2 .setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		lblNewLabel_1_1_1_2.setBounds(651, 132, 93, 17);
		panel.add(lblNewLabel_1_1_1_2);
		
		btnUpload = new JButton("Upload");
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
						lblDeliverImg.setIcon(icon);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnUpload.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		btnUpload.setBounds(666, 163, 89, 32);
		panel.add(btnUpload);
		
		lblPhoto = new JLabel("");
		lblPhoto.setBounds(0, 0, 885, 286);
		panel.add(lblPhoto);
		
		JLabel lblNewLabel_1_2 = new JLabel("Deliver ID:");
		lblNewLabel_1_2 .setForeground(new Color(255, 255, 255));
		lblNewLabel_1_2 .setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(428, 320, 89, 17);
		contentPane.add(lblNewLabel_1_2);
		
		txtShowAll = new JTextField();
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
		txtShowAll.setBounds(526, 314, 141, 32);
		contentPane.add(txtShowAll);
		
		btnShowAll = new JButton("Show All");
		btnShowAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showList();
			}
		});
		btnShowAll.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		btnShowAll.setBounds(683, 314, 89, 32);
		contentPane.add(btnShowAll);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(19, 353, 874, 240);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(8, 14, 858, 212);
		panel_1.add(scrollPane_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane_1.setViewportView(scrollPane);
		
		tblDeliver = new JTable();
		tblDeliver.setBackground(new Color(128, 255, 255));
		tblDeliver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				r = tblDeliver.getSelectedRow();
				deliverID = (String)tblDeliver.getValueAt(r, 1);
				lblDeliverID.setText(deliverID);
				txtName.setText((String)tblDeliver.getValueAt(r, 2));
				txtAddress.setText((String)tblDeliver.getValueAt(r, 3));
				txtPhone.setText((String)tblDeliver.getValueAt(r, 4));
				txtEmail.setText((String)tblDeliver.getValueAt(r, 5));
				txtCapacity.setText((String)tblDeliver.getValueAt(r, 6));
				ImageIcon icon = (ImageIcon) tblDeliver.getValueAt(r, 0);
				lblDeliverImg.setIcon(icon);
				btnSave.setEnabled(false);
				btnUpdate.setEnabled(true);
				btnDelete.setEnabled(true);
				txtName.requestFocus();
				txtName.selectAll();
				System.out.println(deliverID);
			}
			
		});
		scrollPane.setViewportView(tblDeliver);
		displayImg();
		AutoID();
		createTable();
		showList();
	}
	
	
	public void AutoID() {
		try {
			lblDeliverID.setText(AutoID.getAutoID("deliver_id", "deliver", "DE-"));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void setColumnWidth(int index , int width,int height)
	{
	     DefaultTableColumnModel tcm = (DefaultTableColumnModel)tblDeliver.getColumnModel();
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
    	dtm.addColumn("Deliver Photo");
	     dtm.addColumn("Deliver ID");
	     dtm.addColumn("Name");
	     dtm.addColumn("Address"); 
	     dtm.addColumn("Phone");
	     dtm.addColumn("Email");
	     dtm.addColumn("Deliver_capacity");
	     tblDeliver.setModel(dtm);
	     setColumnWidth(0,80,100);
	     setColumnWidth(1,60,100);
	     setColumnWidth(2,60,100);
	     setColumnWidth(3,60,100);
	     setColumnWidth(4,60,100);
	     setColumnWidth(5,80,100);
	     tblDeliver.getColumnModel().getColumn(0).setCellRenderer(new ImageTableCellRenderer());
	     
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
	 		txtCapacity.setText("");
	 		txtName.requestFocus(true);
	    }
	public void showList() {
		Object data[] = new Object[7];
		DeliverController dc = new DeliverController();
		try {
			List<DeliverModel> list = dc.selectall();
			dtm.setRowCount(0);
			for(DeliverModel dm:list) {
				data[0] = dm.getImg();
				data[1] = dm.getDeliver_id();
				data[2] = dm.getName();
				data[3] = dm.getAddress();
				data[4] = dm.getPhone();
				data[5] = dm.getEmail();
				data[6] = dm.getDeliver_capacity()+"";
				dtm.addRow(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public void showListOne() throws SQLException{
		Object data[] = new Object[7];
		DeliverController dc = new DeliverController();
		DeliverModel d = new DeliverModel();
		d.setName(txtShowAll.getText().toString().trim());
		List<DeliverModel> list = dc.selectone(d,path);
		dtm.setRowCount(0);
		for(DeliverModel dm:list) {
			data[0] = dm.getImg();
			data[1] = dm.getDeliver_id();
			data[2] = dm.getName();
			data[3] = dm.getAddress();
			data[4] = dm.getPhone();
			data[5] = dm.getEmail();
			data[6] = dm.getDeliver_capacity()+"";
			dtm.addRow(data);
		}
		tblDeliver.setModel(dtm);
	}
	public void displayImg() {
		ImageIcon imgIco = new ImageIcon(getClass().getResource("/My_Img/deliver.jpeg"));
		Image img = imgIco.getImage().getScaledInstance(lblPhoto.getWidth(), lblPhoto.getHeight(), Image.SCALE_SMOOTH);
		lblPhoto.setIcon(new ImageIcon(img));
	}
}
