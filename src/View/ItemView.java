package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
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

import Connection.Checking;
import Connection.MySqlQueries;
import Controller.BrandController;
import Controller.ItemController;
import Controller.TypeController;
import Model.BrandModel;
import Model.ItemModel;
import Model.TypeModel;
import View.CustomerView.CustomTableCellRenderer;
import View.CustomerView.ImageTableCellRenderer;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ItemView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtItemName;
	private JComboBox cboTypeName;
	private JComboBox cboBrandName;
	private JTextField txtPrice;
	private JTextField txtRemark;
	private JButton btnSave;
	private JTextField txtShowllAll;
	private JButton btnClose;
	private JButton btnClear;
	private JButton btnDelete;
	private JButton btnUpdate;
	private JPanel panel_1;
	private JTable tblItem;
	private JLabel lblItemID;
	DefaultTableModel dtm = new DefaultTableModel();
	int r;
	String itemId=null;
	String path = "";
	private JLabel lblItemImg;
	private JLabel lblNewLabel_1_1_1_1_1_2;
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
					ItemView frame = new ItemView();
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
	public ItemView() {
		setTitle("ItemView");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 778, 686);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 192));
		panel.setForeground(new Color(128, 128, 128));
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(24, 0, 717, 287);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Item ID:");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		lblNewLabel_1.setBounds(30, 63, 65, 17);
		panel.add(lblNewLabel_1);
		
		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int centerX = (int) (screenDimension.getWidth() - getWidth()) / 2;
	    int centerY = (int) (screenDimension.getHeight() - getHeight()) / 2;
	    setLocation(centerX, centerY);
		
		lblItemID = new JLabel("");
		lblItemID.setForeground(new Color(255, 255, 255));
		lblItemID.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		lblItemID.setBounds(182, 63, 116, 17);
		panel.add(lblItemID);
		
		JLabel lblNewLabel_1_1 = new JLabel("Brand Name:");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(30, 94, 85, 17);
		panel.add(lblNewLabel_1_1);
		
		cboBrandName = new JComboBox();
		cboBrandName.setForeground(new Color(0, 0, 0));
		cboBrandName.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		cboBrandName.setBounds(177, 94, 116, 25);
		panel.add(cboBrandName);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Type Name:");
		lblNewLabel_1_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_1.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		lblNewLabel_1_1_1.setBounds(340, 94, 85, 17);
		panel.add(lblNewLabel_1_1_1);
		
		cboTypeName = new JComboBox();
		cboTypeName.setForeground(new Color(0, 0, 0));
		cboTypeName.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		cboTypeName.setBounds(433, 90, 116, 25);
		panel.add(cboTypeName);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Item Name:");
		lblNewLabel_1_1_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_1_1.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		lblNewLabel_1_1_1_1.setBounds(30, 137, 85, 17);
		panel.add(lblNewLabel_1_1_1_1);
		
		txtItemName = new JTextField();
		txtItemName.setBackground(new Color(192, 192, 192));
		txtItemName.setBounds(177, 133, 121, 23);
		panel.add(txtItemName);
		txtItemName.setColumns(10);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Current Price:");
		lblNewLabel_1_1_1_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_1_1_1.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		lblNewLabel_1_1_1_1_1.setBounds(30, 176, 91, 17);
		panel.add(lblNewLabel_1_1_1_1_1);
		
		txtPrice = new JTextField();
		txtPrice.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		txtPrice.setText("0");
		txtPrice.setBackground(new Color(192, 192, 192));
		txtPrice.setColumns(10);
		txtPrice.setBounds(177, 176, 121, 23);
		panel.add(txtPrice);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Remark:");
		lblNewLabel_1_1_1_1_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		lblNewLabel_1_1_1_1_1_1.setBounds(340, 137, 91, 17);
		panel.add(lblNewLabel_1_1_1_1_1_1);
		
		txtRemark = new JTextField();
		txtRemark.setBackground(new Color(192, 192, 192));
		txtRemark.setColumns(10);
		txtRemark.setBounds(433, 129, 121, 23);
		panel.add(txtRemark);
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(lblItemID.getText().trim().toString().equals("")) {
					JOptionPane.showMessageDialog(null, "There is a blank field!","Fail", JOptionPane.ERROR_MESSAGE);
					txtItemName.requestFocus(true);
					txtItemName.selectAll();
				}else if(cboBrandName.getSelectedIndex()<=0) {
					JOptionPane.showMessageDialog(null, "Please choose brand Name!","Fail", JOptionPane.ERROR_MESSAGE);
					cboBrandName.requestFocus(true);
				}else if(cboTypeName.getSelectedIndex()<=0) {
					JOptionPane.showMessageDialog(null, "Please choose type Name!","Fail", JOptionPane.ERROR_MESSAGE);
					cboTypeName.requestFocus(true);
				}else if(txtPrice.getText().trim().toString().equals("")) {
					JOptionPane.showMessageDialog(null, "Please type Price!","Fail", JOptionPane.ERROR_MESSAGE);
					txtItemName.requestFocus(true);
				}else if(txtRemark.getText().trim().toString().equals("")) {
					JOptionPane.showMessageDialog(null, "Please type remark!","Fail", JOptionPane.ERROR_MESSAGE);
					txtItemName.requestFocus(true);
				}else {
					BrandController bc = new BrandController();
					BrandModel bm = new BrandModel();
					bm.setName(cboBrandName.getSelectedItem().toString());
					String brandid = bc.searchBrandId(bm);
					
					TypeController tc = new TypeController();
					TypeModel tm = new TypeModel();
					tm.setName(cboTypeName.getSelectedItem().toString());
					String typeid = tc.searchTypeId(tm);
					
					ItemController ic = new ItemController();
					ItemModel im = new ItemModel();
					im.setItem_id(lblItemID.getText().toString());
					im.setBrand_id(brandid);
					im.setType_id(typeid);
					im.setItem_name(txtItemName.getText().toString());
					im.setPrice(Integer.parseInt(txtPrice.getText().toString()));
					im.setQty(0);
					im.setRemark(txtRemark.getText().toString());
					
					if(Checking.IsValidName(im.getItem_name())) {
						JOptionPane.showMessageDialog(null, "Invalid Name!","Fail", JOptionPane.ERROR_MESSAGE);
						txtItemName.requestFocus(true);
						txtItemName.selectAll();
					}else {
						int rs;
						try {
							rs = ic.insert(im,path);
							if(rs==1) {
								try {
									AutoID();
								} catch (ClassNotFoundException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								clear();
								showList();
								JOptionPane.showMessageDialog(null, "Save Successfully","Success", JOptionPane.INFORMATION_MESSAGE);
						}
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							JOptionPane.showMessageDialog(null, "Please Upload a photo","Upload", JOptionPane.INFORMATION_MESSAGE);

						}
						
					}
				}
			}
		});
		btnSave.setFont(new Font("Pyidaunsu", Font.PLAIN, 15));
		btnSave.setBounds(41, 227, 83, 33);
		panel.add(btnSave);
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(lblItemID.getText().trim().toString().equals("")) {
					JOptionPane.showMessageDialog(null, "There is a blank field!","Fail", JOptionPane.ERROR_MESSAGE);
					txtItemName.requestFocus(true);
					txtItemName.selectAll();
				}else if(cboBrandName.getSelectedIndex()<=0) {
					JOptionPane.showMessageDialog(null, "Please choose brand Name!","Fail", JOptionPane.ERROR_MESSAGE);
					cboBrandName.requestFocus(true);
				}else if(cboTypeName.getSelectedIndex()<=0) {
					JOptionPane.showMessageDialog(null, "Please choose type Name!","Fail", JOptionPane.ERROR_MESSAGE);
					cboTypeName.requestFocus(true);
				}else if(txtPrice.getText().trim().toString().equals("")) {
					JOptionPane.showMessageDialog(null, "Please type Price!","Fail", JOptionPane.ERROR_MESSAGE);
					txtItemName.requestFocus(true);
				}else if(txtRemark.getText().trim().toString().equals("")) {
					JOptionPane.showMessageDialog(null, "Please type remark!","Fail", JOptionPane.ERROR_MESSAGE);
					txtItemName.requestFocus(true);
				}else {
					BrandController bc = new BrandController();
					BrandModel bm = new BrandModel();
					bm.setName(cboBrandName.getSelectedItem().toString());
					String brandid = bc.searchBrandId(bm);
					
					TypeController tc = new TypeController();
					TypeModel tm = new TypeModel();
					tm.setName(cboTypeName.getSelectedItem().toString());
					String typeid = tc.searchTypeId(tm);
					
					ItemController ic = new ItemController();
					ItemModel im = new ItemModel();
					im.setItem_id(lblItemID.getText().toString());
					im.setBrand_id(brandid);
					im.setType_id(typeid);
					im.setItem_name(txtItemName.getText().toString());
					im.setPrice(Integer.parseInt(txtPrice.getText().toString()));
					im.setQty(0);
					im.setRemark(txtRemark.getText().toString());
					lblItemImg.setIcon(null);
					if(Checking.IsValidName(im.getItem_name())) {
						JOptionPane.showMessageDialog(null, "Invalid Name!","Fail", JOptionPane.ERROR_MESSAGE);
						txtItemName.requestFocus(true);
						txtItemName.selectAll();
					}else {
						int rs;
						try {
							rs = ic.update(im,path);
							if(rs==1) {
								try {
									
									AutoID();
									clear();
									showList();
									

								} catch (ClassNotFoundException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							JOptionPane.showMessageDialog(null, "Please Upload a photo","Upload", JOptionPane.INFORMATION_MESSAGE);
						}
						
					}
				}
				
			}
		});
		btnUpdate.setEnabled(false);
		btnUpdate.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		btnUpdate.setBounds(144, 229, 83, 33);
		panel.add(btnUpdate);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ItemModel im = new ItemModel();
				im.setItem_id(lblItemID.getText().toString());
				if(!im.getItem_id().isBlank()) {
					if(JOptionPane.showConfirmDialog(null,"Are you sure you want to delete?","Confrim",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION) {
						ItemController ic = new ItemController();
						int rs;
						try {
							rs = ic.delete(im,path);
							if(rs==1) {
								JOptionPane.showMessageDialog(null,"Delete Successfully","Successfully", JOptionPane.INFORMATION_MESSAGE);
								try {
									AutoID();
								} catch (ClassNotFoundException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								showList();
								clear();
							}else {
								JOptionPane.showMessageDialog(null,"Cannot delete the item because it is referenced by another record.");
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
		
			}
				}
			}
		);
		btnDelete.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		btnDelete.setEnabled(false);
		btnDelete.setBounds(250, 229, 83, 33);
		panel.add(btnDelete);
		
		btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
				try {
					AutoID();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnClear.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		btnClear.setBounds(385, 229, 83, 33);
		panel.add(btnClear);
		
		btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		btnClose.setBounds(476, 229, 83, 33);
		panel.add(btnClose);
		
		JLabel lblNewLabel = new JLabel("Item Entry And Item List");
		lblNewLabel.setBounds(250, 14, 258, 24);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Rockwell", Font.BOLD, 20));
		
		Border b = BorderFactory.createLineBorder(Color.white);
		lblItemImg = new JLabel("");
		lblItemImg.setBounds(562, 69, 116, 130);
		lblItemImg.setBorder(b);
		panel.add(lblItemImg);
		
		lblNewLabel_1_1_1_1_1_2 = new JLabel("Item Photo");
		lblNewLabel_1_1_1_1_1_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_1_1_1_2.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		lblNewLabel_1_1_1_1_1_2.setBounds(581, 52, 91, 17);
		panel.add(lblNewLabel_1_1_1_1_1_2);
		
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
						lblItemImg.setIcon(icon);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
			
		});
		btnUpload.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		btnUpload.setBounds(572, 213, 85, 33);
		panel.add(btnUpload);
		
		lblPhoto = new JLabel("");
		lblPhoto.setBounds(0, 0, 717, 636);
		panel.add(lblPhoto);
		
		JLabel lblNewLabel_1_2 = new JLabel("ItemName:");
		lblNewLabel_1_2.setFont(new Font("Pyidaungsu", Font.BOLD, 18));
		lblNewLabel_1_2.setBounds(333, 301, 98, 17);
		contentPane.add(lblNewLabel_1_2);
		
		txtShowllAll = new JTextField();
		txtShowllAll.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				showListOne();
			}
		});
		txtShowllAll.setBackground(new Color(192, 192, 192));
		txtShowllAll.setColumns(10);
		txtShowllAll.setBounds(427, 301, 161, 23);
		contentPane.add(txtShowllAll);
		
		JButton btnShowAll = new JButton("Show All");
		btnShowAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showList();
			}
		});
		btnShowAll.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		btnShowAll.setBounds(609, 301, 105, 33);
		contentPane.add(btnShowAll);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 348, 746, 295);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(8, 14, 730, 230);
		panel_1.add(scrollPane_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane_1.setViewportView(scrollPane);
		
		tblItem = new JTable();
		tblItem.setBackground(new Color(255, 255, 255));
		tblItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				r = tblItem.getSelectedRow();
				itemId = (String)tblItem.getValueAt(r, 1);
				String str = (String) tblItem.getValueAt(r, 2);
				String[] parts = str.split("/");
				String brandName = parts[0].trim();
				String typeName = parts[1].trim();
				String itemName = parts[2].trim();
				lblItemID.setText(itemId);
				cboBrandName.setSelectedItem(brandName);
				cboTypeName.setSelectedItem(typeName);
				txtItemName.setText(itemName);
				txtPrice.setText((String)tblItem.getValueAt(r, 3));
				txtRemark.setText((String)tblItem.getValueAt(r, 5));
				ImageIcon icon = (ImageIcon) tblItem.getValueAt(r, 0);
				lblItemImg.setIcon(icon);
				btnSave.setEnabled(false);
				btnUpdate.setEnabled(true);
				btnDelete.setEnabled(true);
				cboBrandName.requestFocus(true);
			}
		});
		scrollPane.setViewportView(tblItem);
		displayImg();
		try {
			AutoID();
			fillCombo();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		createTable();
		showList();
	}
	
	public void AutoID()throws ClassNotFoundException{
		lblItemID.setText(Connection.AutoID.getAutoID("item_id", "item", "IM-"));
	}
	
	public void fillCombo() {
		MySqlQueries.addCoboBox("brand","name",cboBrandName);
		MySqlQueries.addCoboBox("type","name",cboTypeName);
	}
	public void clear() {
		cboBrandName.setSelectedIndex(0);
		cboTypeName.setSelectedIndex(0);
		txtItemName.setText("");
		txtPrice.setText("0");
		txtRemark.setText("");
		lblItemImg.setIcon(null);
		btnSave.setEnabled(true);
		btnUpdate.setEnabled(false); 
		btnDelete.setEnabled(false);
		cboBrandName.requestFocus(true);
	}
	
	public void setColumnWidth(int index , int width,int height)
	{
	     DefaultTableColumnModel tcm = (DefaultTableColumnModel)tblItem.getColumnModel();
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
	public void createTable() {
		dtm.addColumn("Item Img");
		dtm.addColumn("Item ID");
		dtm.addColumn("Item name");
		dtm.addColumn("Current_price");
		dtm.addColumn("qty");
		dtm.addColumn("remark");
		tblItem.setModel(dtm);
		 setColumnWidth(0,80,150);
	     setColumnWidth(1,60,100);
	     setColumnWidth(2,60,100);
	     setColumnWidth(3,60,100);
	     setColumnWidth(4,60,100);
	     setColumnWidth(5,80,100);
	     tblItem.getColumnModel().getColumn(0).setCellRenderer(new ImageTableCellRenderer());
	}
	
	public void showList() {
		Object data[] = new Object[6];
		ItemController ic = new ItemController();
		try {
			List<ItemModel> list = ic.selectall();
			dtm.setRowCount(0);
			for(ItemModel im:list) {
				data[0] = im.getImg();
				data[1] = im.getItem_id();
				String itemname = im.getBrand_name() + " / " +im.getType_name() + " / " + im.getItem_name();
				data[2] = itemname;
				data[3] = String.valueOf(im.getPrice());
				data[4] = String.valueOf(im.getQty());
				data[5] = im.getRemark();
				dtm.addRow(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void showListOne() {
		Object data[] = new Object[6];
		ItemController ic = new ItemController();
		ItemModel m = new ItemModel();
		m.setItem_name(txtShowllAll.getText().toString().trim());
		List<ItemModel> list = ic.selectone(m,path);
		dtm.setRowCount(0);
		for(ItemModel im:list) {
			data[0] = im.getImg();
			data[1]=im.getItem_id();
			String itemname = im.getBrand_name() + " / " + im.getType_name() + " / " + im.getItem_name();
			data[2] = itemname;
			data[3] = String.valueOf(im.getPrice());
			data[4] = String.valueOf(im.getQty());
			data[5] = im.getRemark();
			dtm.addRow(data);
		}
	}
	public void displayImg() {
		ImageIcon imgIco = new ImageIcon(getClass().getResource("/My_Img/item.jpeg"));
		Image img = imgIco.getImage().getScaledInstance(lblPhoto.getWidth(), lblPhoto.getHeight(), Image.SCALE_SMOOTH);
		lblPhoto.setIcon(new ImageIcon(img));
	}
	
	
}
