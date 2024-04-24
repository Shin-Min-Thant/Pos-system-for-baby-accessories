package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import Connection.AutoID;
import Connection.Checking;
import Connection.MySqlQueries;
import Connection.date;
import Controller.ItemController;
import Controller.Loss_ProfitController;
import Controller.PurchaseController;
import Controller.PurchaseDetailController;
import Controller.SupplierController;
import Model.ItemModel;
import Model.PurchaseDetailModel;
import Model.PurchaseModel;
import Model.SupplierModel;
import Model.loss_profitModel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;

public class PurchaseView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblSupplierID;
	private JLabel lblSupplierEmail;
	private JLabel lblSupplierAddress;
	private JLabel lblSupplierPhno;
	private JLabel lblPurchaseID;
	private JLabel lbldate;
	private JLabel lblItemID;
	private JLabel lblItemType;
	private JComboBox cmbItemName;
	private JButton btnAdd;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JTable tblPurchase;
	private JButton btnSave;
	private JButton btnClose;
	private JLabel lblTotalAmount;
	String strdataitem[] = new String[9];
	String strquery[] = new String[7];
	Vector vid = new Vector();
	Vector vamount = new Vector();
	DefaultTableModel dtm = new DefaultTableModel();
	private JTextField txtPrice;
	private JTextField txtQty;
	private JComboBox cmbSupplierName;
	private JLabel lblPhoto;
	private JLabel lblPhoto1;
	private JLabel lblPhoto2;
	private JScrollPane scrollPane_1;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PurchaseView frame = new PurchaseView();
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
	public PurchaseView() {
		setTitle("Purchase");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 639, 718);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
	     int centerX = (int) (screenDimension.getWidth() - getWidth()) / 2;
	       int centerY = (int) (screenDimension.getHeight() - getHeight()) / 2;
	       setLocation(centerX, centerY);
	       setResizable(false);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0,80));
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(8, 14, 609, 252);
		contentPane.add(panel);
		panel.setLayout(null);
		
		Border b = BorderFactory.createLineBorder(Color.white);
		
		JLabel lblNewLabel = new JLabel("Supplier Name:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		lblNewLabel.setBounds(21, 25, 119, 17);
		panel.add(lblNewLabel);
		
		JLabel lblSupplierId = new JLabel("Supplier ID:");
		lblSupplierId.setForeground(new Color(255, 255, 255));
		lblSupplierId.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		lblSupplierId.setBounds(21, 71, 119, 17);
		panel.add(lblSupplierId);
		
		
		
		JLabel lblNewLabel_1_1 = new JLabel("Supplier Address:");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(21, 119, 119, 17);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Supplier Email:");
		lblNewLabel_1_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_1.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(21, 167, 119, 17);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Supplier Phno:");
		lblNewLabel_1_1_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_1_1.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1.setBounds(21, 214, 119, 17);
		panel.add(lblNewLabel_1_1_1_1);
		
		cmbSupplierName = new JComboBox();
		cmbSupplierName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cmbSupplierName.getSelectedIndex()>0) {
					SupplierModel sm = new SupplierModel();
					SupplierController sc = new SupplierController();
					ArrayList<SupplierModel> list = new ArrayList<SupplierModel>();
					sm.setName(cmbSupplierName.getSelectedItem().toString());
					try {
						list =(ArrayList<SupplierModel>) sc.serachSupplierDetail(sm);
						for(SupplierModel s:list) {
							lblSupplierID.setText(s.getSupplier_id());
							lblSupplierAddress.setText(s.getAddress());
							lblSupplierEmail.setText(s.getEmail());
							lblSupplierPhno.setText(s.getName());
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			}
		});
		cmbSupplierName.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		cmbSupplierName.setBackground(new Color(192, 192, 192));
		cmbSupplierName.setBounds(171, 22, 156, 25);
		panel.add(cmbSupplierName);
		
		lblSupplierID = new JLabel("");
		lblSupplierID.setForeground(new Color(255, 255, 255));
		lblSupplierID.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		lblSupplierID.setBounds(171, 61, 156, 28);
		lblSupplierID.setBorder(b);
		panel.add(lblSupplierID);
		
		lblSupplierAddress = new JLabel("");
		lblSupplierAddress.setForeground(new Color(255, 255, 255));
		lblSupplierAddress.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		lblSupplierAddress.setBounds(171, 108, 156, 28);
		lblSupplierAddress.setBorder(b);
		panel.add(lblSupplierAddress);
		
		lblSupplierEmail = new JLabel("");
		lblSupplierEmail.setForeground(new Color(255, 255, 255));
		lblSupplierEmail.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		lblSupplierEmail.setBounds(171, 156, 156, 28);
		lblSupplierEmail.setBorder(b);
		panel.add(lblSupplierEmail);
		
		lblSupplierPhno = new JLabel("");
		lblSupplierPhno.setForeground(new Color(255, 255, 255));
		lblSupplierPhno.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		lblSupplierPhno.setBounds(171, 203, 156, 28);
		lblSupplierPhno.setBorder(b);
		panel.add(lblSupplierPhno);
		
		JLabel lblPurchaseId = new JLabel("Purchase ID:");
		lblPurchaseId.setForeground(new Color(255, 255, 255));
		lblPurchaseId.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		lblPurchaseId.setBounds(397, 25, 100, 17);
		panel.add(lblPurchaseId);
		
		lblPurchaseID = new JLabel("");
		lblPurchaseID.setForeground(new Color(255, 255, 255));
		lblPurchaseID.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		lblPurchaseID.setBounds(505, 19, 85, 23);
		panel.add(lblPurchaseID);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setForeground(new Color(255, 255, 255));
		lblDate.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		lblDate.setBounds(397, 61, 71, 17);
		panel.add(lblDate);
		
		lbldate = new JLabel("add");
		lbldate.setForeground(new Color(255, 255, 255));
		lbldate.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		lbldate.setBounds(505, 56, 85, 32);
		panel.add(lbldate);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 0,80));
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(8, 269, 609, 171);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblItemInfo = new JLabel("Item Info:");
		lblItemInfo.setForeground(new Color(255, 255, 255));
		lblItemInfo.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		lblItemInfo.setBounds(8, 14, 79, 17);
		panel_1.add(lblItemInfo);
		
		JLabel lblItemInfo_1 = new JLabel("Item Name:");
		lblItemInfo_1.setForeground(new Color(255, 255, 255));
		lblItemInfo_1.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		lblItemInfo_1.setBounds(28, 45, 79, 17);
		panel_1.add(lblItemInfo_1);
		
		JLabel lblItemInfo_1_1 = new JLabel("Item ID:");
		lblItemInfo_1_1.setForeground(new Color(255, 255, 255));
		lblItemInfo_1_1.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		lblItemInfo_1_1.setBounds(28, 92, 79, 17);
		panel_1.add(lblItemInfo_1_1);
		
		JLabel lblItemInfo_1_1_1 = new JLabel("Item Type:");
		lblItemInfo_1_1_1.setForeground(new Color(255, 255, 255));
		lblItemInfo_1_1_1.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		lblItemInfo_1_1_1.setBounds(28, 130, 79, 17);
		panel_1.add(lblItemInfo_1_1_1);
		
		cmbItemName = new JComboBox();
		cmbItemName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cmbItemName.getSelectedIndex()>0) {
					txtPrice.requestFocus(true);
					ItemModel im = new ItemModel();
					ItemController ic = new ItemController();
					im.setItem_name(cmbItemName.getSelectedItem().toString());
					try {
						strquery = MySqlQueries.getItemData(im);
						strdataitem[1] = strquery[0];
						strdataitem[2] = strquery[1];
						lblItemID.setText(strdataitem[1]);
						strdataitem[8] = (!strquery[6].equals(""))?strquery[6]:"-";
						strdataitem[6] = MySqlQueries.getBrandName(strquery[3]);
						strdataitem[7] = MySqlQueries.getTypeName(strquery[4]);
						lblItemType.setText(strdataitem[7]);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		cmbItemName.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		cmbItemName.setBackground(new Color(192, 192, 192));
		cmbItemName.setBounds(128, 42, 156, 25);
		panel_1.add(cmbItemName);
		
		lblItemID = new JLabel("");
		lblItemID.setForeground(new Color(255, 255, 255));
		lblItemID.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		lblItemID.setBounds(128, 81, 156, 28);
		lblItemID.setBorder(b);
		panel_1.add(lblItemID);
		
		lblItemType = new JLabel("");
		lblItemType.setForeground(new Color(255, 255, 255));
		lblItemType.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		lblItemType.setBounds(128, 123, 156, 28);
		lblItemType.setBorder(b);
		panel_1.add(lblItemType);
		
		JLabel lblItemInfo_1_2 = new JLabel("Price:");
		lblItemInfo_1_2.setForeground(new Color(255, 255, 255));
		lblItemInfo_1_2.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		lblItemInfo_1_2.setBounds(346, 45, 79, 17);
		panel_1.add(lblItemInfo_1_2);
		
		JLabel lblItemInfo_1_2_1 = new JLabel("Quantity");
		lblItemInfo_1_2_1.setForeground(new Color(255, 255, 255));
		lblItemInfo_1_2_1.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		lblItemInfo_1_2_1.setBounds(346, 92, 79, 17);
		panel_1.add(lblItemInfo_1_2_1);
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cmbItemName.getSelectedIndex()==0) {
					JOptionPane.showMessageDialog(null, "You must choose Item Name!");
					cmbItemName.requestFocus();
				}else if(!Checking.checktxtprice(txtPrice.getText())) {
					JOptionPane.showMessageDialog(null, "You must enter less than 1000000000");
					cmbItemName.requestFocus();
					txtPrice.selectAll();
				}else if(!Checking.checktxtquantity(txtQty.getText())) {
					JOptionPane.showMessageDialog(null, "You must enter less than 10000!");
					cmbItemName.requestFocus();
					txtQty.selectAll();
				}else if(Checking.IsContain(strdataitem[1], vid)) {
					JOptionPane.showMessageDialog(null, "The item you selected is already existed!");
					cmbItemName.requestFocus();
					clearItem();
					cmbItemName.setSelectedIndex(0);
				
				}else {
					itemaddmethod();
					lblTotalAmount.setText(Checking.Sumamount(vamount, 1) + "Kyats");
					clearItem();
					cmbItemName.setSelectedIndex(0);
				}
			}
		});
		btnAdd.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		btnAdd.setBounds(292, 126, 95, 25);
		panel_1.add(btnAdd);
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tblPurchase.getSelectedRow()<0) {
					JOptionPane.showMessageDialog(null, "Please select row to update");
				}else if(!Checking.checktxtprice(txtPrice.getText())){
					txtPrice.requestFocus();
					txtPrice.selectAll();
				}else if(!Checking.checktxtquantity(txtQty.getText())) {
					txtQty.requestFocus();
					txtQty.selectAll();
				}else {
					deleteRow();
					itemaddmethod();
					lblTotalAmount.setText(Checking.Sumamount(vamount, 1)+"Kyats");
					clearItem();
					cmbItemName.setSelectedIndex(0);
				}
			}
		});
		btnUpdate.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		btnUpdate.setBounds(395, 126, 95, 25);
		panel_1.add(btnUpdate);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tblPurchase.getSelectedRow()<0) {
					JOptionPane.showMessageDialog(null, "Please select row to delete");
				}else {
					deleteRow();
					clearItem();
					cmbItemName.setSelectedIndex(0);
					lblTotalAmount.setText(Checking.Sumamount(vamount, 1)+"Kyats");
					btnDelete.setEnabled(false);
					btnUpdate.setEnabled(false);
					btnAdd.setEnabled(true);
				}
			}
		});
		btnDelete.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		btnDelete.setBounds(498, 126, 95, 25);
		panel_1.add(btnDelete);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(8, 445, 609, 171);
		contentPane.add(scrollPane_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane_1.setViewportView(scrollPane);
		
		tblPurchase = new JTable();
		tblPurchase.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int r = tblPurchase.getSelectedRow();
				String collection = (String) tblPurchase.getValueAt(r, 2);
				String[] parts = collection.split("/");
				String itemName = parts[0];
				cmbItemName.setSelectedItem(itemName);
				txtPrice.setText(tblPurchase.getValueAt(r, 3).toString());
				txtQty.setText(tblPurchase.getValueAt(r, 4).toString());
				cmbItemName.setEnabled(false);
				btnAdd.setEnabled(false);
				btnUpdate.setEnabled(true);
				btnDelete.setEnabled(true);
			}
		});
		scrollPane.setViewportView(tblPurchase);
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cmbSupplierName.getSelectedIndex() == 0) {
					JOptionPane.showMessageDialog(null, "You must select a Supplier ID!");
					cmbSupplierName.requestFocus();
				}else if(vid.size()==0) {
					JOptionPane.showMessageDialog(null, "There is no item for Purchase!");
					cmbSupplierName.requestFocus();}
//				}else if(lblQty.){
//					
//				}
				else {
					if(JOptionPane.showConfirmDialog(null, "Are you sure to Save?","Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION) {
						int save =0;
						PurchaseController pc = new PurchaseController();
						PurchaseModel pm = new PurchaseModel();
						pm.setPurchase_id(lblPurchaseID.getText().toString());
						pm.setSupplier_id(lblSupplierID.getText().toString());
						pm.setPurchase_date(lbldate.getText().toString());
						save = pc.insert(pm);
						if(save==1) {
							for(int i=0; i<vid.size(); i++) {
								PurchaseDetailController pdc = new PurchaseDetailController();
								PurchaseDetailModel pdm = new PurchaseDetailModel();
								pdm.setPurchase_id(lblPurchaseID.getText().toString());
								pdm.setItem_id((String)tblPurchase.getValueAt(i, 1));
								pdm.setPurchase_qty(Integer.parseInt((String)tblPurchase.getValueAt(i, 4)));
								pdm.setPurchase_price(Integer.parseInt((String)tblPurchase.getValueAt(i, 3)));
								save = pdc.insert(pdm);
								
								ItemModel im = new ItemModel();
								ItemController ic = new ItemController();
								im.setItem_id((String)tblPurchase.getValueAt(i, 1));
								try {
									String data[] = MySqlQueries.getItemData1(im);
									String nowqty = data[5];
									int totalqty = Integer.parseInt(nowqty)+pdm.getPurchase_qty();
									int price = 0;
									price = (int)(pdm.getPurchase_price()+(pdm.getPurchase_price()*0.1));
									im.setQty(totalqty);
									im.setPrice(price);
									int save2 = ic.update1(im);
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								
								Loss_ProfitController pfc = new Loss_ProfitController();
								loss_profitModel plm = new loss_profitModel();
								plm.setTotal_purchase(lblTotalAmount.getText());
								
								try {
									save = pfc.insertPurchase(plm);
								} catch (FileNotFoundException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								
								
							}
						}
						if(save==1) {
							JOptionPane.showMessageDialog(null, "All records are successfully saved!");
							try {
								PurAutoID();
								clearAll();
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}else {
							JOptionPane.showMessageDialog(null, "All records are fail saved!");
						}
					}
				}
			}
		});
		btnSave.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		btnSave.setBounds(35, 631, 95, 35);
		contentPane.add(btnSave);
		
		btnClose = new JButton("Close");
		btnClose.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		btnClose.setBounds(177, 630, 95, 36);
		contentPane.add(btnClose);
		
		JLabel lblItemInfo_1_3 = new JLabel("Total Amount:");
		lblItemInfo_1_3.setForeground(new Color(255, 255, 255));
		lblItemInfo_1_3.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		lblItemInfo_1_3.setBounds(304, 650, 95, 17);
		contentPane.add(lblItemInfo_1_3);
		
		lblTotalAmount = new JLabel("");
		lblTotalAmount.setForeground(new Color(255, 255, 255));
		lblTotalAmount.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		lblTotalAmount.setBounds(408, 638, 156, 28);
		lblTotalAmount.setBorder(b);
		contentPane.add(lblTotalAmount);
		
		createTable();
		try {
			PurAutoID();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		lblTotalAmount.setText("0 Kyat");
		btnUpdate.setEnabled(false);
		btnDelete.setEnabled(false);
		
		date d = new date();
		lbldate.setText(d.getMySQLDateFormat());
		MySqlQueries.addCoboBox("supplier", "name", cmbSupplierName);
		
		lblPhoto2 = new JLabel("New label");
		lblPhoto2.setBounds(0, 0, 609, 238);
		panel.add(lblPhoto2);
		MySqlQueries.addCoboBox("item", "item_name", cmbItemName);
		
		txtPrice = new JTextField();
		txtPrice.setBounds(421, 43, 156, 23);
		panel_1.add(txtPrice);
		txtPrice.setColumns(10);
		
		txtQty = new JTextField();
		txtQty.setColumns(10);
		txtQty.setBounds(421, 86, 156, 23);
		panel_1.add(txtQty);
		
		lblPhoto1 = new JLabel("");
		lblPhoto1.setBounds(0, 0, 609, 171);
		panel_1.add(lblPhoto1);
		
		lblPhoto = new JLabel("");
		lblPhoto.setBounds(8, 14, 609, 667);
		contentPane.add(lblPhoto);
		displayImg();
		displayImg1();
		displayImg2();
	}
	
	public void setColumnWidth(int index,int width) {
		DefaultTableColumnModel tcm = (DefaultTableColumnModel)tblPurchase.getColumnModel();
		TableColumn tc = tcm.getColumn(index);
		tc.setPreferredWidth(width);
	}
	
	public void createTable() {
		dtm.addColumn("No");
		dtm.addColumn("Item ID");
		dtm.addColumn("Item Detail");
		dtm.addColumn("Price");
		dtm.addColumn("Qty");
		dtm.addColumn("Amount");
		tblPurchase.setModel(dtm);
		setColumnWidth(0,60);
		setColumnWidth(1,60);
		setColumnWidth(2,100);
		setColumnWidth(3,50);
		setColumnWidth(4,60);
		setColumnWidth(4,80);
	}
	public void PurAutoID() throws ClassNotFoundException{
		lblPurchaseID.setText(String.valueOf(AutoID.getAutoID("purchase_id", "purchase", "P-")));
	}
	
	public void clearItem() {
		lblItemID.setText("");
		lblItemType.setText("");
		txtPrice.setText("");
		txtQty.setText("");
		cmbItemName.setSelectedIndex(0);
	}
	
	public void itemaddmethod() {
		strdataitem[0] = String.valueOf(vid.size()+1);
		vid.addElement(strdataitem[1]);
		strdataitem[2]+="/"+strdataitem[6]+"/"+strdataitem[7]+"/"+strdataitem[8];
		strdataitem[3]=txtPrice.getText();
		strdataitem[4]=txtQty.getText();
		Long amount = Integer.parseInt(strdataitem[4])*Long.parseLong(strdataitem[3]);
		strdataitem[5] = String.valueOf(amount);
		vamount.addElement(strdataitem[5]);
		dtm.addRow(strdataitem);
		tblPurchase.setModel(dtm);
		cmbItemName.requestFocus();
	}
	public void deleteRow() {
		int i = tblPurchase.getSelectedRow();
		vamount.remove(i);
		if(!vid.lastElement().equals(vid.get(i))) {
			vid.remove(i);
			dtm.removeRow(i);
			for(int j=0; j<vid.size()-i; j++) {
				dtm.setValueAt(i+j+1, i+j, 0);
			}
		}else {
			vid.remove(i);
			dtm.removeRow(i);
		}
	}
	
	public void clearAll() {
		cmbSupplierName.setSelectedIndex(0);
		lblSupplierID.setText("");
		lblSupplierAddress.setText("");
		lblSupplierEmail.setText("");
		lblSupplierPhno.setText("");
		
		lblItemID.setText("");
		lblItemType.setText("");
		txtPrice.setText("");
		txtQty.setText("");
		cmbItemName.setSelectedIndex(0);
		
		dtm.setRowCount(0);
		lblTotalAmount.setText("0Kyat");
	}
	public void displayImg() {
		ImageIcon imgIco = new ImageIcon(getClass().getResource("/My_Img/sale1.jpeg"));
		Image img = imgIco.getImage().getScaledInstance(lblPhoto.getWidth(), lblPhoto.getHeight(), Image.SCALE_SMOOTH);
		lblPhoto.setIcon(new ImageIcon(img));
	}
	public void displayImg1() {
		ImageIcon imgIco = new ImageIcon(getClass().getResource("/My_Img/sale1.jpeg"));
		Image img = imgIco.getImage().getScaledInstance(lblPhoto1.getWidth(), lblPhoto1.getHeight(), Image.SCALE_SMOOTH);
		lblPhoto1.setIcon(new ImageIcon(img));
	}
	public void displayImg2() {
		ImageIcon imgIco = new ImageIcon(getClass().getResource("/My_Img/sale1.jpeg"));
		Image img = imgIco.getImage().getScaledInstance(lblPhoto2.getWidth(), lblPhoto2.getHeight(), Image.SCALE_SMOOTH);
		lblPhoto2.setIcon(new ImageIcon(img));
	}
}
