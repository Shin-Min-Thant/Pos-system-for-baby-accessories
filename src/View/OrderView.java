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

import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import Connection.AutoID;
import Connection.Checking;
import Connection.MySqlQueries;
import Connection.date;
import Controller.CustomerController;
import Controller.ItemController;
import Controller.OrderController;
import Controller.OrderDetailController;
import Controller.SaleController;
import Controller.SaleDetailController;
import Model.CustomerModel;
import Model.ItemModel;
import Model.OrderDetailModel;
import Model.OrderModel;
import Model.SaleDetailModel;
import Model.SaleModel;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OrderView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtQty;
	private JTable tblOrder;
	private JComboBox cboCustomerID;
	private JLabel lblAddress;
	private JLabel lblEmail;
	private JLabel lbldate;
	private JLabel lblCustomerName;
	private JLabel lblPhone;
	private JComboBox cboItemID;
	private JLabel lbItemName;
	private JLabel lblItemtype;
	private JLabel lblInstockQuantity;
	private JLabel lblPrice;
	private JButton btnAdd;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnSave;
	private JButton btnClose;
	private JLabel lblTotalAmount;
	DefaultTableModel dtm = new DefaultTableModel();
	private JLabel lblOrderID;
	 String strdataitem[] = new String[12];
	    String strquery[] = new String[7];
	    Vector vid = new Vector();
	    Vector vamount = new Vector();
	    private JLabel lblPhoto;
	    private JLabel Number;
	    private JLabel lblNumber;
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
					OrderView frame = new OrderView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ClassNotFoundException 
	 */
	public OrderView() throws ClassNotFoundException {
		setTitle("Order View");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 709, 762);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBounds(26, 0, 643, 725);
		contentPane.add(contentPane_1);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(new Color(0, 0, 0,80));
		panel.setBounds(8, 14, 627, 184);
		contentPane_1.add(panel);
		
		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int centerX = (int) (screenDimension.getWidth() - getWidth()) / 2;
	    int centerY = (int) (screenDimension.getHeight() - getHeight()) / 2;
	    setLocation(centerX, centerY);
		
		JLabel lblNewLabel = new JLabel("Order ID:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Rockwell", Font.BOLD, 15));
		lblNewLabel.setBounds(21, 25, 119, 17);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1_1 = new JLabel("Customer ID:");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Rockwell", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(21, 67, 119, 17);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Address");
		lblNewLabel_1_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_1.setFont(new Font("Rockwell", Font.BOLD, 15));
		lblNewLabel_1_1_1.setBounds(21, 111, 119, 17);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Email");
		lblNewLabel_1_1_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_1_1.setFont(new Font("Rockwell", Font.BOLD, 15));
		lblNewLabel_1_1_1_1.setBounds(21, 154, 119, 17);
		panel.add(lblNewLabel_1_1_1_1);
		
		Border b = BorderFactory.createLineBorder(Color.white);
		
		lblOrderID = new JLabel("");
		lblOrderID.setForeground(new Color(255, 255, 255));
		lblOrderID.setFont(new Font("Rockwell", Font.BOLD, 15));
		lblOrderID.setBounds(148, 19, 156, 28);
		lblOrderID.setBorder(b);
		panel.add(lblOrderID);
		
		lblAddress = new JLabel("");
		lblAddress.setForeground(new Color(255, 255, 255));
		lblAddress.setFont(new Font("Rockwell", Font.BOLD, 15));
		lblAddress.setBounds(148, 101, 156, 28);
		lblAddress.setBorder(b);
		panel.add(lblAddress);
		
		lbldate = new JLabel("");
		lbldate.setForeground(new Color(255, 255, 255));
		lbldate.setFont(new Font("Rockwell", Font.BOLD, 15));
		lbldate.setBounds(460, 19, 156, 28);
		lbldate.setBorder(b);
		panel.add(lbldate);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setForeground(new Color(255, 255, 255));
		lblDate.setFont(new Font("Rockwell", Font.BOLD, 15));
		lblDate.setBounds(330, 25, 71, 17);
		panel.add(lblDate);
		
		lblEmail = new JLabel("");
		lblEmail.setForeground(new Color(255, 255, 255));
		lblEmail.setFont(new Font("Rockwell", Font.BOLD, 15));
		lblEmail.setBounds(148, 143, 156, 28);
		lblEmail.setBorder(b);
		panel.add(lblEmail);
		
		cboCustomerID = new JComboBox();
		cboCustomerID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cboCustomerID.getSelectedIndex()>0) {
					CustomerModel cm = new CustomerModel();
					CustomerController cc = new CustomerController();
					ArrayList<CustomerModel> list = new ArrayList<CustomerModel> ();
					cm.setCustomer_id(cboCustomerID.getSelectedItem().toString());
					try {
						list =(ArrayList<CustomerModel>) cc.searchCustomerDetail(cm);
						for(CustomerModel c:list) {
							lblCustomerName.setText(c.getName());
							lblAddress.setText(c.getAddress());
							lblEmail.setText(c.getEmail());
							lblPhone.setText(c.getPhone());
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		cboCustomerID.setBounds(148, 64, 156, 25);
		panel.add(cboCustomerID);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Customer Name:");
		lblNewLabel_1_1_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_2.setFont(new Font("Rockwell", Font.BOLD, 15));
		lblNewLabel_1_1_2.setBounds(330, 67, 136, 17);
		panel.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("Phone no:");
		lblNewLabel_1_1_2_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_2_1.setFont(new Font("Rockwell", Font.BOLD, 15));
		lblNewLabel_1_1_2_1.setBounds(330, 122, 119, 17);
		panel.add(lblNewLabel_1_1_2_1);
		
		lblCustomerName = new JLabel("");
		lblCustomerName.setForeground(new Color(255, 255, 255));
		lblCustomerName.setFont(new Font("Rockwell", Font.BOLD, 15));
		lblCustomerName.setBounds(460, 61, 156, 28);
		lblCustomerName.setBorder(b);
		panel.add(lblCustomerName);
		
		lblPhone = new JLabel("");
		lblPhone.setForeground(new Color(255, 255, 255));
		lblPhone.setFont(new Font("Rockwell", Font.BOLD, 15));
		lblPhone.setBounds(460, 111, 156, 28);
		lblPhone.setBorder(b);
		panel.add(lblPhone);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBackground(new Color(0, 0, 0,80));
		panel_1.setBounds(8, 199, 627, 278);
		contentPane_1.add(panel_1);
		
		JLabel lblItemInfo = new JLabel("Item Info:");
		lblItemInfo.setForeground(new Color(255, 255, 255));
		lblItemInfo.setFont(new Font("Rockwell", Font.BOLD, 15));
		lblItemInfo.setBounds(8, 12, 79, 17);
		panel_1.add(lblItemInfo);
		
		JLabel lblItemInfo_1 = new JLabel("Item Name:");
		lblItemInfo_1.setForeground(new Color(255, 255, 255));
		lblItemInfo_1.setFont(new Font("Rockwell", Font.BOLD, 15));
		lblItemInfo_1.setBounds(8, 135, 100, 17);
		panel_1.add(lblItemInfo_1);
		
		JLabel lblItemInfo_1_1 = new JLabel("Item ID:");
		lblItemInfo_1_1.setForeground(new Color(255, 255, 255));
		lblItemInfo_1_1.setFont(new Font("Rockwell", Font.BOLD, 15));
		lblItemInfo_1_1.setBounds(161, 78, 79, 17);
		panel_1.add(lblItemInfo_1_1);
		
		JLabel lblItemInfo_1_1_1 = new JLabel("Item Type:");
		lblItemInfo_1_1_1.setForeground(new Color(255, 255, 255));
		lblItemInfo_1_1_1.setFont(new Font("Rockwell", Font.BOLD, 15));
		lblItemInfo_1_1_1.setBounds(8, 186, 95, 17);
		panel_1.add(lblItemInfo_1_1_1);
		
		cboItemID = new JComboBox();
		cboItemID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cboItemID.getSelectedIndex()>0) {
					lblPrice.requestFocus(true);
					ItemModel im = new ItemModel();
					ItemController ic = new ItemController();
					im.setItem_id(cboItemID.getSelectedItem().toString());
					try {
						int randomNumber = generateRandomNumber(1000, 9999);
						strquery = MySqlQueries.getItemData1(im);
						strdataitem[1] = strquery[0];  //id
						strdataitem[2] = strquery[1];  //name
						lbItemName.setText(strdataitem[2]);
						strdataitem[3] = strquery[2]; //price
						lblPrice.setText(strdataitem[3]);
						strdataitem[9] = strquery[5]; //qty
						lblInstockQuantity.setText(strdataitem[9]);
						strdataitem[9] = (!strquery[6].equals("")) ? strquery[6]:"-"; //remark
						strdataitem[7]=MySqlQueries.getBrandName(strquery[3]); //branid
						strdataitem[8]=MySqlQueries.getTypeName(strquery[4]);  //tyepid
						lblItemtype.setText(strdataitem[8]);
				        lblNumber.setText(Integer.toString(randomNumber));
					}catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		cboItemID.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		cboItemID.setBackground(Color.LIGHT_GRAY);
		cboItemID.setBounds(243, 76, 156, 25);
		panel_1.add(cboItemID);
		
		lblItemtype = new JLabel("");
		lblItemtype.setForeground(new Color(255, 255, 255));
		lblItemtype.setFont(new Font("Rockwell", Font.BOLD, 15));
		lblItemtype.setBounds(138, 175, 156, 28);
		lblItemtype.setBorder(b);
		panel_1.add(lblItemtype);
		
		JLabel lblItemInfo_1_2 = new JLabel("Price:");
		lblItemInfo_1_2.setForeground(new Color(255, 255, 255));
		lblItemInfo_1_2.setFont(new Font("Rockwell", Font.BOLD, 15));
		lblItemInfo_1_2.setBounds(316, 124, 79, 17);
		panel_1.add(lblItemInfo_1_2);
		
		JLabel lblItemInfo_1_2_1 = new JLabel("Order Quantity:");
		lblItemInfo_1_2_1.setForeground(new Color(255, 255, 255));
		lblItemInfo_1_2_1.setFont(new Font("Rockwell", Font.BOLD, 15));
		lblItemInfo_1_2_1.setBounds(302, 165, 125, 17);
		panel_1.add(lblItemInfo_1_2_1);
		
		btnAdd = new JButton("Order");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cboItemID.getSelectedIndex()==0) {
					JOptionPane.showMessageDialog(null, "You must choose Item ID!");
					cboItemID.requestFocus();
				}else if(!Checking.checktxtquantity(txtQty.getText())) {
					JOptionPane.showMessageDialog(null, "You must enter less than 10000!");
					cboItemID.requestFocus();
					txtQty.selectAll();
				}else if(Checking.IsContain(strdataitem[1], vid)) {
					JOptionPane.showMessageDialog(null, "The item you selected is already existed!");
					cboItemID.requestFocus();
					clearItem();
					cboItemID.setSelectedIndex(0);
				}else if(Integer.parseInt(txtQty.getText())>Integer.parseInt(lblInstockQuantity.getText())) {
					JOptionPane.showMessageDialog(null, "Your qty is more than instock qty");
					cboItemID.requestFocus();
					clearItem();
					cboItemID.setSelectedIndex(0);
				}
				else {
					itemAddMethod();
					lblTotalAmount.setText(Checking.Sumamount(vamount, 1) + "Kyats");
					clearItem();
					cboItemID.setSelectedIndex(0);
				}
			}
		});
		btnAdd.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		btnAdd.setBounds(304, 243, 95, 25);
		panel_1.add(btnAdd);
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tblOrder.getSelectedRow()<0) {
					JOptionPane.showMessageDialog(null, "Please select row to update");
				}else if(!Checking.checktxtquantity(txtQty.getText())) {
					txtQty.requestFocus();
					txtQty.selectAll();
				}else if(Integer.parseInt(txtQty.getText())>Integer.parseInt(lblInstockQuantity.getText())) {
					JOptionPane.showMessageDialog(null, "Your qty is more than instock qty");
					cboItemID.requestFocus();
					clearItem();
					cboItemID.setSelectedIndex(0);
				}else {
					deleteRow();
					itemAddMethod();
					lblTotalAmount.setText(Checking.Sumamount(vamount, 1)+"Kyats");
					clearItem();
					btnUpdate.setEnabled(false);
					btnDelete.setEnabled(false);
					btnAdd.setEnabled(true);
					cboItemID.setEnabled(true);
					cboItemID.setSelectedIndex(0);
				}
			}
		});
		btnUpdate.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		btnUpdate.setEnabled(false);
		btnUpdate.setBounds(407, 243, 95, 25);
		panel_1.add(btnUpdate);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tblOrder.getSelectedRow()<0) {
					JOptionPane.showMessageDialog(null, "Please select row to delete");
				}else {
					deleteRow();
					clearItem();
					cboItemID.setSelectedIndex(0);
					lblTotalAmount.setText(Checking.Sumamount(vamount, 1)+"Kyats");
					btnDelete.setEnabled(false);
					btnUpdate.setEnabled(false);
					btnAdd.setEnabled(true);
					cboItemID.setEnabled(true);
				}
			}
		});
		btnDelete.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		btnDelete.setEnabled(false);
		btnDelete.setBounds(510, 243, 95, 25);
		panel_1.add(btnDelete);
		
		txtQty = new JTextField();
		txtQty.setBounds(449, 161, 156, 32);
		panel_1.add(txtQty);
		
		lbItemName = new JLabel("");
		lbItemName.setForeground(new Color(255, 255, 255));
		lbItemName.setFont(new Font("Rockwell", Font.BOLD, 15));
		lbItemName.setBounds(138, 124, 156, 28);
		lbItemName.setBorder(b);
		panel_1.add(lbItemName);
		
		JLabel lblItemInfo_1_1_1_1 = new JLabel("Instock Quantity:");
		lblItemInfo_1_1_1_1.setForeground(new Color(255, 255, 255));
		lblItemInfo_1_1_1_1.setFont(new Font("Rockwell", Font.BOLD, 15));
		lblItemInfo_1_1_1_1.setBounds(8, 233, 141, 17);
		panel_1.add(lblItemInfo_1_1_1_1);
		
		lblInstockQuantity = new JLabel("");
		lblInstockQuantity.setForeground(new Color(255, 255, 255));
		lblInstockQuantity.setFont(new Font("Rockwell", Font.BOLD, 15));
		lblInstockQuantity.setBounds(140, 222, 156, 28);
		lblInstockQuantity.setBorder(b);
		panel_1.add(lblInstockQuantity);
		
		lblPrice = new JLabel("");
		lblPrice.setForeground(new Color(255, 255, 255));
		lblPrice.setFont(new Font("Rockwell", Font.BOLD, 15));
		lblPrice.setBounds(449, 112, 156, 28);
		lblPrice.setBorder(b);
		panel_1.add(lblPrice);
		
		JLabel lblNewLabel_1 = new JLabel("Buy 3 get 1");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Rockwell", Font.BOLD, 17));
		lblNewLabel_1.setBounds(293, 35, 106, 25);
		panel_1.add(lblNewLabel_1);
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cboCustomerID.getSelectedIndex() == 0) {
					JOptionPane.showMessageDialog(null, "You must select a Item ID!");
					cboCustomerID.requestFocus();
				}else if(vid.size()==0) {
					JOptionPane.showMessageDialog(null, "There is no item for Order!");
					cboCustomerID.requestFocus();
				}else {
					if(JOptionPane.showConfirmDialog(null, "Are you sure to Save?","Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION) {
						int save =0;
						OrderController sc = new OrderController();
						OrderModel sm = new OrderModel();
						sm.setOrder_id(lblOrderID.getText().toString());
						sm.setCustomer_id(cboCustomerID.getSelectedItem().toString());
						sm.setOrder_date(lbldate.getText().toString());
						save = sc.insert(sm);
						if(save==1) {
							for(int i=0; i<vid.size(); i++) {
								OrderDetailController odc = new OrderDetailController();
								OrderDetailModel odm = new OrderDetailModel();
								odm.setOrder_id(lblOrderID.getText().toString());
								odm.setItem_id((String)tblOrder.getValueAt(i, 1));
								odm.setOrder_price(Integer.parseInt((String)tblOrder.getValueAt(i, 3)));
								odm.setOrder_qty(Integer.parseInt((String)tblOrder.getValueAt(i, 4)));
								odm.setUnique((String)tblOrder.getValueAt(i, 5));
								save = odc.insert(odm);
								
								ItemModel im = new ItemModel();
								ItemController ic = new ItemController();
								im.setItem_id((String)tblOrder.getValueAt(i, 1));
								try {
									String data[] = MySqlQueries.getItemData1(im);
									String nowqty = data[5];
									int totalqty = Integer.parseInt(nowqty)-odm.getOrder_qty();
									im.setQty(totalqty);
									int save2 = ic.update2(im);
								} catch (SQLException e1) {
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
		btnSave.setBounds(33, 676, 95, 35);
		contentPane_1.add(btnSave);
		
		btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
			
		});
		btnClose.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		btnClose.setBounds(169, 675, 95, 36);
		contentPane_1.add(btnClose);
		
		JLabel lblItemInfo_1_3 = new JLabel("Total Amount:");
		lblItemInfo_1_3.setForeground(new Color(255, 255, 255));
		lblItemInfo_1_3.setFont(new Font("Rockwell", Font.BOLD, 15));
		lblItemInfo_1_3.setBounds(290, 694, 113, 17);
		contentPane_1.add(lblItemInfo_1_3);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(8, 491, 627, 171);
		contentPane_1.add(scrollPane_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane_1.setViewportView(scrollPane);
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int r = tblOrder.getSelectedRow();
				String collection = (String)tblOrder.getValueAt(r, 2);
				String[] parts = collection.split("/");
				String itemName = parts[0];
				String itemType = parts[1];
				cboItemID.setSelectedItem(tblOrder.getValueAt(r, 1));
				lbItemName.setText(itemName);
				lblItemtype.setText(itemType);
				lblPrice.setText(tblOrder.getValueAt(r, 3).toString());
				txtQty.setText(tblOrder.getValueAt(r, 4).toString());
				lblNumber.setText(tblOrder.getValueAt(r, 5).toString());
				cboItemID.setEnabled(false);
				btnAdd.setEnabled(false);
				btnUpdate.setEnabled(true);
				btnDelete.setEnabled(true);
			}
		});
		
		tblOrder = new JTable();
		scrollPane.setViewportView(tblOrder);
		createTable();
		PurAutoID();
		date d = new date();
		lbldate.setText(d.getMySQLDateFormat());
		MySqlQueries.addCoboBox("customer", "customer_id", cboCustomerID);
		
		lblPhoto2 = new JLabel("");
		lblPhoto2.setBounds(0, 0, 627, 705);
		panel.add(lblPhoto2);
		MySqlQueries.addCoboBox("item", "item_id", cboItemID);
		
		JLabel lblNewLabel_2 = new JLabel("Our Thingyan Pomotion is ");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Rockwell", Font.BOLD, 18));
		lblNewLabel_2.setBounds(221, 8, 271, 25);
		panel_1.add(lblNewLabel_2);
		
		Number = new JLabel("Unique Number:");
		Number.setForeground(Color.WHITE);
		Number.setFont(new Font("Rockwell", Font.BOLD, 15));
		Number.setBounds(302, 212, 141, 17);
		panel_1.add(Number);
		
		lblNumber = new JLabel("");
		lblNumber.setForeground(Color.WHITE);
		lblNumber.setFont(new Font("Rockwell", Font.BOLD, 15));
		lblNumber.setBounds(449, 207, 156, 28);
		lblNumber.setBorder(b);
		panel_1.add(lblNumber);
		
		lblPhoto1 = new JLabel("");
		lblPhoto1.setBounds(0, 0, 627, 278);
		panel_1.add(lblPhoto1);
		
		lblTotalAmount = new JLabel("0 Kyat");
		lblTotalAmount.setForeground(new Color(255, 255, 255));
		lblTotalAmount.setFont(new Font("Rockwell", Font.BOLD, 15));
		lblTotalAmount.setBounds(442, 690, 154, 24);
		contentPane_1.add(lblTotalAmount);
		
		lblPhoto = new JLabel("");
		lblPhoto.setBounds(-19, 0, 676, 725);
		contentPane_1.add(lblPhoto);
		displayImg();
		displayImg1();
		displayImg2();
	}
	
	public void setColumnWidth(int index,int width) {
		DefaultTableColumnModel tcm = (DefaultTableColumnModel)tblOrder.getColumnModel();
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
		dtm.addColumn("Unique Nuber");
		tblOrder.setModel(dtm);
		setColumnWidth(0,60);
		setColumnWidth(1,60);
		setColumnWidth(2,100);
		setColumnWidth(3,50);
		setColumnWidth(4,60);
		setColumnWidth(4,80);
		setColumnWidth(5,80);
	}
	
    public void PurAutoID() throws ClassNotFoundException {
    	lblOrderID.setText(AutoID.getAutoID("order_id", "pos_baby.order","OD-"));
    }
    
	public void clearItem() {
		lbItemName.setText("");
		lblItemtype.setText("");
		lblPrice.setText("");
		txtQty.setText("");
		lblInstockQuantity.setText("");
		cboItemID.setSelectedIndex(0);
	}
	
	public void clearAll() {
		cboCustomerID.setSelectedIndex(0);
		lblCustomerName.setText("");
		lblAddress.setText("");
		lblEmail.setText("");
		lblPhone.setText("");
		
		lbItemName.setText("");
		lblItemtype.setText("");
		lblPrice.setText("");
		txtQty.setText("");
		lblInstockQuantity.setText("");
		lblTotalAmount.setText("");
		cboItemID.setSelectedIndex(0);
		
		dtm.setRowCount(0);
		lblTotalAmount.setText("0Kyat");
	}
	
	public void itemAddMethod() {
		strdataitem[0] = String.valueOf(vid.size()+1);
		vid.addElement(strdataitem[1]);
		strdataitem[2]+="/"+strdataitem[7]+"/"+strdataitem[8]+"/"+strdataitem[9];
		String qtyText = txtQty.getText().trim();
		if(!qtyText.isEmpty()) {
			int qty = Integer.parseInt(txtQty.getText().toString());
			int totalQty = qty;
			if(qty>=3) {
				int freeitem = qty/3;
				totalQty += freeitem;
			}
			strdataitem[4] = totalQty + "";
		}
		strdataitem[11]=txtQty.getText();
		Long amount = Integer.parseInt(strdataitem[11])*Long.parseLong(strdataitem[3]);
		strdataitem[5] = String.valueOf(amount);
		vamount.addElement(strdataitem[5]);
		strdataitem[6] = lblNumber.getText();
		dtm.addRow(strdataitem);
		tblOrder.setModel(dtm);
		cboItemID.requestFocus();
	}
	public void deleteRow() {
		int i = tblOrder.getSelectedRow();
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
	public void displayImg() {
		ImageIcon imgIco = new ImageIcon(getClass().getResource("/My_Img/sale2.jpeg"));
		Image img = imgIco.getImage().getScaledInstance(lblPhoto.getWidth(), lblPhoto.getHeight(), Image.SCALE_SMOOTH);
		lblPhoto.setIcon(new ImageIcon(img));
	}
	public void displayImg1() {
		ImageIcon imgIco = new ImageIcon(getClass().getResource("/My_Img/sale2.jpeg"));
		Image img = imgIco.getImage().getScaledInstance(lblPhoto1.getWidth(), lblPhoto1.getHeight(), Image.SCALE_SMOOTH);
		lblPhoto1.setIcon(new ImageIcon(img));
	}
	public void displayImg2() {
		ImageIcon imgIco = new ImageIcon(getClass().getResource("/My_Img/sale2.jpeg"));
		Image img = imgIco.getImage().getScaledInstance(lblPhoto2.getWidth(), lblPhoto2.getHeight(), Image.SCALE_SMOOTH);
		lblPhoto2.setIcon(new ImageIcon(img));
	}
	 public static int generateRandomNumber(int minValue, int maxValue) {
	        return (int) (Math.random() * (maxValue - minValue + 1)) + minValue;
	   }
}
