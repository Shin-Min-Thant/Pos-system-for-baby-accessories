package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
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
import Controller.Loss_ProfitController;
import Controller.SaleController;
import Controller.SaleDetailController;
import Model.CustomerModel;
import Model.ItemModel;
import Model.SaleDetailModel;
import Model.SaleModel;
import Model.loss_profitModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;


public class SaleView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtQty;
	private JLabel lblNewLabel;
	private JLabel lblAddress;
	private JLabel lblEmail;
	private JLabel lbldate;
	private JLabel lblCustomerName;
	private JLabel lblPhone;
	private JLabel lbItemName;
	private JLabel lblItemtype;
	private JLabel lblInstockQuantity;
	private JLabel lblPrice;
	private JButton btnAdd;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JComboBox cboItemID;
	private JComboBox cboCustomerID;
	private JTable tblSale;
	DefaultTableModel dtm = new DefaultTableModel();
	private JLabel lblSaleID;
    String strdataitem[] = new String[10];
    String strquery[] = new String[7];
    Vector vid = new Vector();
    Vector vamount = new Vector();
    private JLabel lblTotalAmount;
    private JLabel lblPurchasePhoto;
    private JLabel lblPurchaseImg;
    private JLabel lblPhoto2;
    private JScrollPane scrollPane_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SaleView frame = new SaleView();
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
	public SaleView() {
		setTitle("Sale View");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 689, 749);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBounds(8, 14, 643, 698);
		contentPane.add(contentPane_1);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(new Color(0, 0, 0,80));
		panel.setBounds(8, 14, 627, 252);
		contentPane_1.add(panel);
		
		lblNewLabel = new JLabel("Sale ID:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		lblNewLabel.setBounds(21, 25, 119, 17);
		panel.add(lblNewLabel);
		
		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int centerX = (int) (screenDimension.getWidth() - getWidth()) / 2;
	    int centerY = (int) (screenDimension.getHeight() - getHeight()) / 2;
	    setLocation(centerX, centerY);
		
		JLabel lblNewLabel_1_1 = new JLabel("Customer ID:");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(21, 74, 119, 17);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Address");
		lblNewLabel_1_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_1.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		lblNewLabel_1_1_1.setBounds(21, 130, 119, 17);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Email");
		lblNewLabel_1_1_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_1_1.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		lblNewLabel_1_1_1_1.setBounds(21, 184, 119, 17);
		panel.add(lblNewLabel_1_1_1_1);
		
		Border b = BorderFactory.createLineBorder(Color.white);
		
		lblSaleID = new JLabel("");
		lblSaleID.setForeground(new Color(255, 255, 255));
		lblSaleID.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		lblSaleID.setBounds(148, 19, 156, 28);
		lblSaleID.setBorder(b);
		panel.add(lblSaleID);
		
		lblAddress = new JLabel("");
		lblAddress.setForeground(new Color(255, 255, 255));
		lblAddress.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		lblAddress.setBounds(148, 119, 156, 28);
		lblAddress.setBorder(b);
		panel.add(lblAddress);
		
		lbldate = new JLabel("");
		lbldate.setForeground(new Color(255, 255, 255));
		lbldate.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		lbldate.setBounds(460, 19, 156, 28);
		lbldate.setBorder(b);
		panel.add(lbldate);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setForeground(new Color(255, 255, 255));
		lblDate.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		lblDate.setBounds(347, 25, 71, 17);
		panel.add(lblDate);
		
		lblEmail = new JLabel("");
		lblEmail.setForeground(new Color(255, 255, 255));
		lblEmail.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		lblEmail.setBounds(148, 173, 156, 28);
		lblEmail.setBorder(b);
		panel.add(lblEmail);
		
		cboCustomerID = new JComboBox();
		cboCustomerID.setForeground(new Color(0, 0, 0));
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
		cboCustomerID.setBounds(148, 71, 156, 25);
		panel.add(cboCustomerID);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Customer Name:");
		lblNewLabel_1_1_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_2.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		lblNewLabel_1_1_2.setBounds(347, 74, 119, 17);
		panel.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("Phone no:");
		lblNewLabel_1_1_2_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_2_1.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		lblNewLabel_1_1_2_1.setBounds(347, 131, 119, 17);
		panel.add(lblNewLabel_1_1_2_1);
		
		lblCustomerName = new JLabel("");
		lblCustomerName.setForeground(new Color(255, 255, 255));
		lblCustomerName.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		lblCustomerName.setBounds(460, 68, 156, 28);
		lblCustomerName.setBorder(b);
		panel.add(lblCustomerName);
		
		lblPhone = new JLabel("");
		lblPhone.setForeground(new Color(255, 255, 255));
		lblPhone.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		lblPhone.setBounds(460, 130, 156, 28);
		lblPhone.setBorder(b);
		panel.add(lblPhone);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBackground(new Color(0, 0, 0,80));
		panel_1.setBounds(8, 269, 627, 191);
		contentPane_1.add(panel_1);
		
		JLabel lblItemInfo = new JLabel("Item Info:");
		lblItemInfo.setForeground(new Color(255, 255, 255));
		lblItemInfo.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		lblItemInfo.setBounds(8, 14, 79, 17);
		panel_1.add(lblItemInfo);
		
		JLabel lblItemInfo_1 = new JLabel("Item Name:");
		lblItemInfo_1.setForeground(new Color(255, 255, 255));
		lblItemInfo_1.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		lblItemInfo_1.setBounds(8, 62, 79, 17);
		panel_1.add(lblItemInfo_1);
		
		JLabel lblItemInfo_1_1 = new JLabel("Item ID:");
		lblItemInfo_1_1.setForeground(new Color(255, 255, 255));
		lblItemInfo_1_1.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		lblItemInfo_1_1.setBounds(217, 14, 79, 17);
		panel_1.add(lblItemInfo_1_1);
		
		JLabel lblItemInfo_1_1_1 = new JLabel("Item Type:");
		lblItemInfo_1_1_1.setForeground(new Color(255, 255, 255));
		lblItemInfo_1_1_1.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		lblItemInfo_1_1_1.setBounds(8, 109, 79, 17);
		panel_1.add(lblItemInfo_1_1_1);
		
		cboItemID = new JComboBox();
		cboItemID.setForeground(new Color(0, 0, 0));
		cboItemID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cboItemID.getSelectedIndex()>0) {
					lblPrice.requestFocus(true);
					ItemModel im = new ItemModel();
					im.setItem_id(cboItemID.getSelectedItem().toString());
					try {
						strquery = MySqlQueries.getItemData1(im);
						strdataitem[1] = strquery[0];  //id
						strdataitem[2] = strquery[1];  //name
						lbItemName.setText(strdataitem[2]);
						strdataitem[3] = strquery[2]; //price
						lblPrice.setText(strdataitem[3]);
						strdataitem[9] = strquery[5]; //qty
						lblInstockQuantity.setText(strdataitem[9]);
						strdataitem[8] = (!strquery[6].equals("")) ? strquery[6]:"-"; //remark
						strdataitem[6]=MySqlQueries.getBrandName(strquery[3]); //branid
						strdataitem[7]=MySqlQueries.getTypeName(strquery[4]);  //tyepid
						lblItemtype.setText(strdataitem[7]);
					}catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		cboItemID.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		cboItemID.setBackground(Color.LIGHT_GRAY);
		cboItemID.setBounds(304, 10, 156, 25);
		panel_1.add(cboItemID);
		
		lblItemtype = new JLabel("");
		lblItemtype.setBackground(new Color(0, 0, 0));
		lblItemtype.setForeground(new Color(255, 255, 255));
		lblItemtype.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		lblItemtype.setBounds(128, 98, 156, 28);
		lblItemtype.setBorder(b);
		panel_1.add(lblItemtype);
		
		JLabel lblItemInfo_1_2 = new JLabel("Price:");
		lblItemInfo_1_2.setForeground(new Color(255, 255, 255));
		lblItemInfo_1_2.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		lblItemInfo_1_2.setBounds(330, 62, 79, 17);
		panel_1.add(lblItemInfo_1_2);
		
		JLabel lblItemInfo_1_2_1 = new JLabel("Sale Quantity:");
		lblItemInfo_1_2_1.setForeground(new Color(255, 255, 255));
		lblItemInfo_1_2_1.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		lblItemInfo_1_2_1.setBounds(330, 105, 95, 17);
		panel_1.add(lblItemInfo_1_2_1);
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cboItemID.getSelectedIndex()==0) {
					JOptionPane.showMessageDialog(null, "You must choose Item Name!");
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
		btnAdd.setBounds(314, 152, 95, 25);
		panel_1.add(btnAdd);
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tblSale.getSelectedRow()<0) {
					JOptionPane.showMessageDialog(null, "Please select row to update");
				}else if(!Checking.checktxtquantity(txtQty.getText())) {
					txtQty.requestFocus();
					txtQty.selectAll();
				}
				else {
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
		btnUpdate.setBounds(421, 152, 95, 25);
		panel_1.add(btnUpdate);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tblSale.getSelectedRow()<0) {
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
		btnDelete.setBounds(524, 152, 95, 25);
		panel_1.add(btnDelete);
		
		txtQty = new JTextField();
		txtQty.setForeground(new Color(0, 0, 0));
		txtQty.setColumns(10);
		txtQty.setBounds(433, 103, 156, 23);
		panel_1.add(txtQty);
		
		lbItemName = new JLabel("");
		lbItemName.setBackground(new Color(0, 0, 0));
		lbItemName.setForeground(new Color(255, 255, 255));
		lbItemName.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		lbItemName.setBounds(128, 51, 156, 28);
		lbItemName.setBorder(b);
		panel_1.add(lbItemName);
		
		JLabel lblItemInfo_1_1_1_1 = new JLabel("Instock Quantity:");
		lblItemInfo_1_1_1_1.setForeground(new Color(255, 255, 255));
		lblItemInfo_1_1_1_1.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		lblItemInfo_1_1_1_1.setBounds(8, 156, 122, 17);
		panel_1.add(lblItemInfo_1_1_1_1);
		
		lblInstockQuantity = new JLabel("");
		lblInstockQuantity.setBackground(new Color(0, 0, 0));
		lblInstockQuantity.setForeground(new Color(255, 255, 255));
		lblInstockQuantity.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		lblInstockQuantity.setBounds(128, 149, 156, 28);
		lblInstockQuantity.setBorder(b);
		panel_1.add(lblInstockQuantity);
		
		lblPrice = new JLabel("");
		lblPrice.setBackground(new Color(0, 0, 0));
		lblPrice.setForeground(new Color(255, 255, 255));
		lblPrice.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		lblPrice.setBounds(430, 51, 156, 28);
		lblPrice.setBorder(b);
		panel_1.add(lblPrice);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cboCustomerID.getSelectedIndex() == 0) {
					JOptionPane.showMessageDialog(null, "You must select a Supplier ID!");
					cboCustomerID.requestFocus();
				}else if(vid.size()==0) {
					JOptionPane.showMessageDialog(null, "There is no item for Purchase!");
					cboCustomerID.requestFocus();
				}else {
					if(JOptionPane.showConfirmDialog(null, "Are you sure to Save?","Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION) {
						int save =0;
						SaleController sc = new SaleController();
						SaleModel sm = new SaleModel();
						sm.setSale_id(lblSaleID.getText().toString());
						sm.setCustomer_id(cboCustomerID.getSelectedItem().toString());
						sm.setSale_date(lbldate.getText().toString());
						save = sc.insert(sm);
						if(save==1) {
							for(int i=0; i<vid.size(); i++) {
								SaleDetailController sdc = new SaleDetailController();
								SaleDetailModel sdm = new SaleDetailModel();
								sdm.setSale_id(lblSaleID.getText().toString());
								sdm.setItem_id((String)tblSale.getValueAt(i, 1));
								sdm.setSale_price(Integer.parseInt((String)tblSale.getValueAt(i, 3)));
								sdm.setSale_qty(Integer.parseInt((String)tblSale.getValueAt(i, 4)));
								save = sdc.insert(sdm);
								
								ItemModel im = new ItemModel();
								ItemController ic = new ItemController();
								im.setItem_id((String)tblSale.getValueAt(i, 1));
								try {
									String data[] = MySqlQueries.getItemData1(im);
									String nowqty = data[5];
									int totalqty = Integer.parseInt(nowqty)-sdm.getSale_qty();
									im.setQty(totalqty);
									int save2 = ic.update2(im);
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								
								Loss_ProfitController pfc = new Loss_ProfitController();
								loss_profitModel plm = new loss_profitModel();
								plm.setTotal_sale(lblTotalAmount.getText());
								
								try {
									save = pfc.insertSale(plm);
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
		btnSave.setBounds(35, 658, 95, 35);
		contentPane_1.add(btnSave);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		btnClose.setBounds(178, 657, 95, 36);
		contentPane_1.add(btnClose);
		
		JLabel lblItemInfo_1_3 = new JLabel("Total Amount:");
		lblItemInfo_1_3.setForeground(new Color(255, 255, 255));
		lblItemInfo_1_3.setFont(new Font("Pyidaungsu", Font.BOLD | Font.ITALIC, 15));
		lblItemInfo_1_3.setBounds(318, 667, 95, 17);
		contentPane_1.add(lblItemInfo_1_3);
		
		lblTotalAmount = new JLabel("0 Kyat");
		lblTotalAmount.setForeground(new Color(255, 255, 255));
		lblTotalAmount.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		lblTotalAmount.setBounds(441, 661, 156, 28);
		contentPane_1.add(lblTotalAmount);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(8, 474, 627, 171);
		contentPane_1.add(scrollPane_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane_1.setViewportView(scrollPane);
		
		tblSale = new JTable();
		tblSale.setBackground(new Color(255, 255, 255));
		tblSale.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int r = tblSale.getSelectedRow();
				String collection = (String)tblSale.getValueAt(r, 2);
				String[] parts = collection.split("/");
				String itemName = parts[0];
				String itemType = parts[1];
				cboItemID.setSelectedItem(tblSale.getValueAt(r, 1));
				lbItemName.setText(itemName);
				lblItemtype.setText(itemType);
				lblPrice.setText(tblSale.getValueAt(r, 3).toString());
				txtQty.setText(tblSale.getValueAt(r, 4).toString());
				cboItemID.setEnabled(false);
				btnAdd.setEnabled(false);
				btnUpdate.setEnabled(true);
				btnDelete.setEnabled(true);
			}
		});
		scrollPane.setViewportView(tblSale);
		createTable();
		try {
			PurAutoID();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		date d = new date();
		lbldate.setText(d.getMySQLDateFormat());
		MySqlQueries.addCoboBox("customer", "customer_id", cboCustomerID);
		
		lblPhoto2 = new JLabel("");
		lblPhoto2.setBounds(0, -18, 639, 256);
		panel.add(lblPhoto2);
		MySqlQueries.addCoboBox("item", "item_id", cboItemID);
		
		lblPurchaseImg = new JLabel("New label");
		lblPurchaseImg.setBounds(0, 0, 627, 191);
		panel_1.add(lblPurchaseImg);
		
		lblPurchasePhoto = new JLabel("");
		lblPurchasePhoto.setBounds(0, -15, 673, 727);
		contentPane_1.add(lblPurchasePhoto);
		displayImg();
		displayImg1();
		displayImg2();
	}
	
	public void setColumnWidth(int index,int width) {
		DefaultTableColumnModel tcm = (DefaultTableColumnModel)tblSale.getColumnModel();
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
		tblSale.setModel(dtm);
		setColumnWidth(0,60);
		setColumnWidth(1,60);
		setColumnWidth(2,100);
		setColumnWidth(3,50);
		setColumnWidth(4,60);
		setColumnWidth(4,80);
	}
	
	public void PurAutoID() throws ClassNotFoundException {
		lblSaleID.setText(AutoID.getAutoID("sale_id", "sale", "S-"));
	}
	
	public void itemAddMethod() {
		strdataitem[0] = String.valueOf(vid.size()+1);
		vid.addElement(strdataitem[1]);
		strdataitem[2]+="/"+strdataitem[6]+"/"+strdataitem[7]+"/"+strdataitem[8];
		strdataitem[4]=txtQty.getText();
		Long amount = Integer.parseInt(strdataitem[4])*Long.parseLong(strdataitem[3]);
		strdataitem[5] = String.valueOf(amount);
		vamount.addElement(strdataitem[5]);
		dtm.addRow(strdataitem);
		tblSale.setModel(dtm);
		cboItemID.requestFocus();
	}
	
	public void deleteRow() {
		int i = tblSale.getSelectedRow();
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
		cboItemID.setSelectedIndex(0);
		
		dtm.setRowCount(0);
		lblTotalAmount.setText("0Kyat");
	}
	
	public void displayImg() {
		ImageIcon imgIco = new ImageIcon(getClass().getResource("/My_Img/purchase1.jpeg"));
		Image img = imgIco.getImage().getScaledInstance(lblPurchasePhoto.getWidth(), lblPurchasePhoto.getHeight(), Image.SCALE_SMOOTH);
		lblPurchasePhoto.setIcon(new ImageIcon(img));
	}
	public void displayImg1() {
		ImageIcon imgIco = new ImageIcon(getClass().getResource("/My_Img/purchase1.jpeg"));
		Image img = imgIco.getImage().getScaledInstance(lblPurchaseImg.getWidth(), lblPurchaseImg.getHeight(), Image.SCALE_SMOOTH);
		lblPurchaseImg.setIcon(new ImageIcon(img));
	}
	public void displayImg2() {
		ImageIcon imgIco = new ImageIcon(getClass().getResource("/My_Img/purchase1.jpeg"));
		Image img = imgIco.getImage().getScaledInstance(lblPhoto2.getWidth(), lblPhoto2.getHeight(), Image.SCALE_SMOOTH);
		lblPhoto2.setIcon(new ImageIcon(img));
	}

}
