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
import Controller.BrandController;
import Controller.DeliverController;
import Controller.DeliveryController;
import Controller.DeliveryDetailController;
import Controller.ItemController;
import Controller.Loss_ProfitController;
import Controller.OrderController;
import Controller.OrderDetailController;
import Model.BrandModel;
import Model.DeliverModel;
import Model.DeliveryDetailModel;
import Model.DeliveryModel;
import Model.ItemModel;
import Model.OrderDetailModel;
import Model.OrderModel;
import Model.loss_profitModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;

public class DeliveryView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tblDelivery;
	private JComboBox<String> cboDeliverID;
	private JLabel lblAddress;
	private JLabel lblEmail;
	private JLabel lblDeliverName;
	private JLabel lblPhone;
	private JLabel lblCapacity;
	private JLabel lblDeliveryID;
	private JComboBox<String> cboOrderID;
	private JButton btnAdd;
	private JButton btnDelete;
	private JLabel lbItemName;
	private JLabel lblQty;
	private JLabel lblOrderAddress;
	private JButton btnSave;
	private JButton btnClose;
	private JLabel lblTotalAmount;
	DefaultTableModel dtm = new DefaultTableModel();
	Vector<String> vid = new Vector<String>();
	Vector<String> vamount = new Vector<String>();
	Vector vqty = new Vector();
	String strdataitem[] = new String[10];
	
	int r = 0;
	String OrderID = null;
	List<OrderDetailModel> list = new ArrayList<OrderDetailModel>();
	private JLabel lblTotal_Qty;
	private JLabel lblPhoto;
	private JScrollPane scrollPane_1;
	private JLabel lblItemInfo_2;
	private JLabel lblOrderID;
	private JLabel lblPhoto2;
	private JLabel lblFees;
	private JLabel lblPhoto1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeliveryView frame = new DeliveryView();
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
	public DeliveryView() {
		setTitle("Delivery View");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 662, 737);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBounds(0, 0, 643, 698);
		contentPane.add(contentPane_1);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(new Color(0, 0, 0,80));
		panel.setBounds(8, 14, 627, 252);
		contentPane_1.add(panel);
		
		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int centerX = (int) (screenDimension.getWidth() - getWidth()) / 2;
	    int centerY = (int) (screenDimension.getHeight() - getHeight()) / 2;
	    setLocation(centerX, centerY);

		JLabel lblNewLabel = new JLabel("Delivery ID:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		lblNewLabel.setBounds(21, 25, 119, 17);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1_1 = new JLabel("Deliver ID:");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(8, 75, 119, 17);
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

		lblDeliveryID = new JLabel("S-00000002");
		lblDeliveryID.setForeground(new Color(255, 255, 255));
		lblDeliveryID.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		lblDeliveryID.setBounds(148, 19, 156, 28);
		panel.add(lblDeliveryID);

		Border b = BorderFactory.createLineBorder(Color.white);

		lblAddress = new JLabel("");
		lblAddress.setForeground(new Color(255, 255, 255));
		lblAddress.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		lblAddress.setBounds(148, 119, 156, 28);
		lblAddress.setBorder(b);
		panel.add(lblAddress);

		JLabel lbldate = new JLabel("2024-04-07");
		lbldate.setForeground(new Color(255, 255, 255));
		lbldate.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		lbldate.setBounds(460, 19, 156, 28);
		panel.add(lbldate);

		JLabel lblDate = new JLabel("Date:");
		lblDate.setForeground(new Color(255, 255, 255));
		lblDate.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		lblDate.setBounds(347, 25, 71, 17);
		panel.add(lblDate);

		lblEmail = new JLabel("");
		lblEmail.setForeground(new Color(255, 255, 255));
		lblEmail.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		lblEmail.setBounds(148, 173, 156, 28);
		lblEmail.setBorder(b);
		panel.add(lblEmail);

		cboDeliverID = new JComboBox<String>();
		cboDeliverID.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		cboDeliverID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cboDeliverID.getSelectedIndex() > 0) {
					DeliverModel cm = new DeliverModel();
					DeliverController cc = new DeliverController();
					ArrayList<DeliverModel> list = new ArrayList<DeliverModel>();
					cm.setDeliver_id(cboDeliverID.getSelectedItem().toString());
					try {
						list = (ArrayList<DeliverModel>) cc.serachDeliverDetail(cm);
						for (DeliverModel c : list) {
							lblDeliverName.setText(c.getName());
							lblAddress.setText(c.getAddress());
							lblEmail.setText(c.getEmail());
							lblPhone.setText(c.getPhone());
							lblCapacity.setText(String.valueOf(c.getDeliver_capacity()));
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					;
				}
			}
		});
		cboDeliverID.setBounds(148, 71, 156, 25);
		panel.add(cboDeliverID);

		JLabel lblNewLabel_1_1_2 = new JLabel("Deliver Name:");
		lblNewLabel_1_1_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_2.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		lblNewLabel_1_1_2.setBounds(347, 74, 103, 17);
		panel.add(lblNewLabel_1_1_2);

		JLabel lblNewLabel_1_1_2_1 = new JLabel("Phone no:");
		lblNewLabel_1_1_2_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_2_1.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		lblNewLabel_1_1_2_1.setBounds(347, 131, 119, 17);
		panel.add(lblNewLabel_1_1_2_1);

		lblDeliverName = new JLabel("");
		lblDeliverName.setForeground(new Color(255, 255, 255));
		lblDeliverName.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		lblDeliverName.setBounds(460, 68, 156, 28);
		lblDeliverName.setBorder(b);
		panel.add(lblDeliverName);

		lblPhone = new JLabel("");
		lblPhone.setForeground(new Color(255, 255, 255));
		lblPhone.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		lblPhone.setBounds(460, 130, 156, 28);
		lblPhone.setBorder(b);
		panel.add(lblPhone);

		JLabel lblNewLabel_1_1_2_1_1 = new JLabel("Deliver Capacity:");
		lblNewLabel_1_1_2_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_2_1_1.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		lblNewLabel_1_1_2_1_1.setBounds(347, 196, 119, 17);
		panel.add(lblNewLabel_1_1_2_1_1);

		lblCapacity = new JLabel("");
		lblCapacity.setForeground(new Color(255, 255, 255));
		lblCapacity.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		lblCapacity.setBounds(460, 185, 156, 28);
		lblCapacity.setBorder(b);
		panel.add(lblCapacity);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBackground(new Color(0, 0, 0,80));
		panel_1.setBounds(8, 269, 627, 191);
		contentPane_1.add(panel_1);

		JLabel lblItemInfo = new JLabel("Order Info:");
		lblItemInfo.setBackground(new Color(0, 0, 205));
		lblItemInfo.setForeground(new Color(255, 255, 255));
		lblItemInfo.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		lblItemInfo.setBounds(8, 14, 79, 17);
		panel_1.add(lblItemInfo);

		JLabel lblItemInfo_1 = new JLabel("Order_Item Name:");
		lblItemInfo_1.setForeground(new Color(255, 255, 255));
		lblItemInfo_1.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		lblItemInfo_1.setBounds(8, 62, 122, 17);
		panel_1.add(lblItemInfo_1);

		JLabel lblItemInfo_1_1 = new JLabel("Order Unique Number:");
		lblItemInfo_1_1.setForeground(new Color(255, 255, 255));
		lblItemInfo_1_1.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		lblItemInfo_1_1.setBounds(133, 14, 146, 17);
		panel_1.add(lblItemInfo_1_1);

		cboOrderID = new JComboBox<String>();
		cboOrderID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cboOrderID.getSelectedIndex() > 0) {
					OrderDetailModel cm = new OrderDetailModel();
					OrderDetailController cc = new OrderDetailController();
					ArrayList<OrderDetailModel> list = new ArrayList<OrderDetailModel>();
					cm.setUnique(Integer.parseInt((String)cboOrderID.getSelectedItem()));
					try {
						list = (ArrayList<OrderDetailModel>) cc.searhOrderDetail(cm);
						for (OrderDetailModel c : list) {
							lblOrderID.setText(c.getOrder_id());
							lbItemName.setText(String.valueOf(c.getItem_name()));
							lblOrderAddress.setText(String.valueOf(c.getAddress()));
							lblQty.setText(String.valueOf(c.getOrder_qty()));
							lblFees.setText("1500");
						}

					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					;
				}
			}
		});
		cboOrderID.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		cboOrderID.setBackground(Color.LIGHT_GRAY);
		cboOrderID.setBounds(304, 10, 156, 25);
		panel_1.add(cboOrderID);

		JLabel lblItemInfo_1_2 = new JLabel("Order Address:");
		lblItemInfo_1_2.setForeground(new Color(255, 255, 255));
		lblItemInfo_1_2.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		lblItemInfo_1_2.setBounds(326, 121, 113, 17);
		panel_1.add(lblItemInfo_1_2);

		btnAdd = new JButton("Delivery");
		btnAdd.addActionListener(new ActionListener() {
//			String qty = lblQty.getText().trim();
			public void actionPerformed(ActionEvent e) {
				System.out.println(cboOrderID.getSelectedIndex());
				if (cboOrderID.getSelectedIndex() == 0) {
					JOptionPane.showMessageDialog(null, "You must choose Order Item ID!");
					cboOrderID.requestFocus();
				} else if (Checking.IsContain(strdataitem[1], vid)) {
					JOptionPane.showMessageDialog(null, "The order you selected is already existed!");
					cboOrderID.requestFocus();
					clearItem();
					cboOrderID.setSelectedIndex(0);
				
				}else if (Integer.parseInt(lblQty.getText().trim()) <= 0) {
					JOptionPane.showMessageDialog(null, "Order Process is completed");
					cboOrderID.requestFocus();
					clearItem();
					cboOrderID.setSelectedIndex(0);

				}else {
					itemAddMethod();
					lblTotalAmount.setText(Checking.Sumamount(vamount, 1) + "Kyats");
					lblTotal_Qty.setText(Checking.Sumamount(vqty, 1));
					clearItem();
					cboOrderID.setSelectedIndex(0);
				}
			}
		});
		btnAdd.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		btnAdd.setBounds(344, 152, 95, 25);
		panel_1.add(btnAdd);

		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tblDelivery.getSelectedRow() < 0) {
					JOptionPane.showMessageDialog(null, "Please select row to delete");
				} else {
					deleteRow();
					clearItem();
					cboOrderID.setSelectedIndex(0);
					lblTotalAmount.setText(Checking.Sumamount(vamount, 1) + "Kyats");
					lblTotal_Qty.setText(Checking.Sumamount(vqty, 1));
					btnDelete.setEnabled(false);
					btnAdd.setEnabled(true);
					btnSave.setEnabled(true);
					cboOrderID.setEnabled(true);
				}
			}
		});
		btnDelete.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		btnDelete.setEnabled(false);
		btnDelete.setBounds(503, 152, 95, 25);
		panel_1.add(btnDelete);

		lbItemName = new JLabel("");
		lbItemName.setForeground(new Color(255, 255, 255));
		lbItemName.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		lbItemName.setBounds(150, 51, 156, 28);
		lbItemName.setBorder(b);
		panel_1.add(lbItemName);

		JLabel lblItemInfo_1_1_1_1 = new JLabel("Order Quantity:");
		lblItemInfo_1_1_1_1.setForeground(new Color(255, 255, 255));
		lblItemInfo_1_1_1_1.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		lblItemInfo_1_1_1_1.setBounds(8, 108, 122, 17);
		panel_1.add(lblItemInfo_1_1_1_1);

		lblQty = new JLabel("");
		lblQty.setForeground(new Color(255, 255, 255));
		lblQty.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		lblQty.setBounds(150, 108, 156, 28);
		lblQty.setBorder(b);
		panel_1.add(lblQty);

		lblOrderAddress = new JLabel("");
		lblOrderAddress.setForeground(new Color(255, 255, 255));
		lblOrderAddress.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		lblOrderAddress.setBounds(430, 110, 156, 28);
		lblOrderAddress.setBorder(b);
		panel_1.add(lblOrderAddress);

		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cboDeliverID.getSelectedIndex() == 0) {
					JOptionPane.showMessageDialog(null, "You must select a Order ID!");
					cboDeliverID.requestFocus();
				} else if (vid.size() == 0) {
					JOptionPane.showMessageDialog(null, "There is no item for Order!");
					cboDeliverID.requestFocus();

				}else if (!lblTotal_Qty.getText().isEmpty() && !lblCapacity.getText().isEmpty()
						&& Integer.parseInt(lblTotal_Qty.getText()) > 0 && Integer.parseInt(lblCapacity.getText()) > 0
						&& Integer.parseInt(lblTotal_Qty.getText()) > Integer.parseInt(lblCapacity.getText())) {
					JOptionPane.showMessageDialog(null, "Your qty is more than capacity qty");
					cboOrderID.requestFocus();
					cboOrderID.setSelectedIndex(0);
				}
			
				else {
					if (JOptionPane.showConfirmDialog(null, "Are you sure to Save?", "Confirm",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
						int save = 0;
						DeliveryController sc = new DeliveryController();
						DeliveryModel sm = new DeliveryModel();
						sm.setDelivery_id(lblDeliveryID.getText().toString());
						sm.setDeliver_id(cboDeliverID.getSelectedItem().toString());
						sm.setDelivery_date(lbldate.getText().toString());
						save = sc.insert(sm);
						if (save == 1) {
							
							for (int i = 0; i < vid.size(); i++) {
								DeliveryDetailController odc = new DeliveryDetailController();
								DeliveryDetailModel odm = new DeliveryDetailModel();
								odm.setDelivery_id(lblDeliveryID.getText().toString());
								odm.setOrder_id((String) tblDelivery.getValueAt(i, 1));
								odm.setAddress(tblDelivery.getValueAt(i, 3).toString());
								odm.setDelivery_qty(Integer.parseInt((String) tblDelivery.getValueAt(i, 4)));
								odm.setDelive_fees((String)tblDelivery.getValueAt(i, 6));
								save = odc.insert(odm);
								
								OrderDetailController oc = new OrderDetailController();
								OrderDetailModel om = new OrderDetailModel();
								
								om.setUnique(Integer.parseInt((String)tblDelivery.getValueAt(i, 5)));
								try {
									String data[] = MySqlQueries.getItemData2(om);
									String nowqty = data[3];
									int orderqty = Integer.parseInt(nowqty)-Integer.parseInt(nowqty);
									om.setOrder_qty(orderqty);
									int saQty = om.getOrder_qty();
									if(saQty==0) {
										String comStatus = "Deliverd";
										om.setStatus(comStatus);
									}else {
										om.getStatus();
									}
									int save2 = oc.update2(om);
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								
								
								Loss_ProfitController pfc = new Loss_ProfitController();
								loss_profitModel plm = new loss_profitModel();
								plm.setTotal_delivery(lblTotalAmount.getText());
								try {
									save = pfc.insertDelivery(plm);
								} catch (FileNotFoundException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								
							}
						}
						if (save == 1) {
							JOptionPane.showMessageDialog(null, "All records are successfully saved!");
							try {
								PurAutoID();
								clearAll();
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						} else {
							JOptionPane.showMessageDialog(null, "All records are fail saved!");
						}
					}
				}
			}
		});
		btnSave.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		btnSave.setBounds(35, 658, 95, 35);
		contentPane_1.add(btnSave);

		btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		btnClose.setBounds(178, 657, 95, 36);
		contentPane_1.add(btnClose);

		JLabel lblItemInfo_1_3 = new JLabel("Total Deli Fees:");
		lblItemInfo_1_3.setForeground(new Color(255, 255, 255));
		lblItemInfo_1_3.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		lblItemInfo_1_3.setBounds(281, 667, 110, 17);
		contentPane_1.add(lblItemInfo_1_3);

		lblTotalAmount = new JLabel("0 Kyat");
		lblTotalAmount.setForeground(new Color(255, 255, 255));
		lblTotalAmount.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		lblTotalAmount.setBounds(399, 661, 83, 28);
		contentPane_1.add(lblTotalAmount);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(8, 474, 627, 175);
		contentPane_1.add(scrollPane_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane_1.setViewportView(scrollPane);

		tblDelivery = new JTable();
		tblDelivery.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				r = tblDelivery.getSelectedRow();
				cboOrderID.setSelectedItem(tblDelivery.getValueAt(r, 1));
				lbItemName.setText((String) tblDelivery.getValueAt(r, 2));
				lblOrderAddress.setText((String) tblDelivery.getValueAt(r, 3));
				lblQty.setText((String) tblDelivery.getValueAt(r, 4));
				btnAdd.setEnabled(false);
				btnSave.setEnabled(false);
				btnDelete.setEnabled(true);
				cboOrderID.setEnabled(false);
			}
		});
		scrollPane.setViewportView(tblDelivery);
		createTable();
		try {
			PurAutoID();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		date d = new date();
		lbldate.setText(d.getMySQLDateFormat());
		MySqlQueries.addCoboBox("deliver", "deliver_id", cboDeliverID);
		
		lblPhoto2 = new JLabel("");
		lblPhoto2.setBounds(0, 0, 627, 238);
		panel.add(lblPhoto2);
		MySqlQueries.addComboBox1("order_detail", "unique", cboOrderID);
		
		lblItemInfo_2 = new JLabel("Order ID:");
		lblItemInfo_2.setForeground(Color.WHITE);
		lblItemInfo_2.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		lblItemInfo_2.setBounds(8, 156, 72, 17);
		panel_1.add(lblItemInfo_2);
		
		lblOrderID = new JLabel("");
		lblOrderID.setForeground(Color.WHITE);
		lblOrderID.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		lblOrderID.setBounds(150, 152, 156, 28);
		lblOrderID.setBorder(b);
		panel_1.add(lblOrderID);
		
		JLabel lblItemInfo_1_2_1 = new JLabel("Deli Fees:");
		lblItemInfo_1_2_1.setForeground(Color.WHITE);
		lblItemInfo_1_2_1.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		lblItemInfo_1_2_1.setBounds(326, 62, 76, 17);
		panel_1.add(lblItemInfo_1_2_1);
		
		lblFees = new JLabel("");
		lblFees.setForeground(Color.WHITE);
		lblFees.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		lblFees.setBounds(430, 49, 156, 28);
		lblFees.setBorder(b);
		panel_1.add(lblFees);
		
		lblPhoto1 = new JLabel("");
		lblPhoto1.setBounds(0, 0, 627, 191);
		panel_1.add(lblPhoto1);

		JLabel lblItemInfo_1_3_1 = new JLabel("Total Qty:");
		lblItemInfo_1_3_1.setForeground(new Color(255, 255, 255));
		lblItemInfo_1_3_1.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		lblItemInfo_1_3_1.setBounds(490, 667, 69, 17);
		contentPane_1.add(lblItemInfo_1_3_1);

		lblTotal_Qty = new JLabel("");
		lblTotal_Qty.setForeground(new Color(255, 255, 255));
		lblTotal_Qty.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		lblTotal_Qty.setBounds(566, 661, 69, 28);
		contentPane_1.add(lblTotal_Qty);
		
		lblPhoto = new JLabel("");
		lblPhoto.setBounds(8, 14, 627, 684);
		contentPane_1.add(lblPhoto);
		displayImg();
		displayImg1();
		displayImg2();
	}

	public void PurAutoID() throws ClassNotFoundException {
		lblDeliveryID.setText(AutoID.getAutoID("delivery_id", "delivery", "DV-"));
	}

	public void setColumnWidth(int index, int width) {
		DefaultTableColumnModel tcm = (DefaultTableColumnModel) tblDelivery.getColumnModel();
		TableColumn tc = tcm.getColumn(index);
		tc.setPreferredWidth(width);
	}

	public void createTable() {
		dtm.addColumn("No");
		dtm.addColumn("Order ID");
		dtm.addColumn("Order_Item Name");
		dtm.addColumn("Address");
		dtm.addColumn("Qty");
		dtm.addColumn("unique");
		dtm.addColumn("delive fees");
		tblDelivery.setModel(dtm);
		setColumnWidth(0, 60);
		setColumnWidth(1, 60);
		setColumnWidth(2, 100);
		setColumnWidth(3, 50);
		setColumnWidth(4, 60);
		setColumnWidth(4, 80);
		setColumnWidth(4, 80);
		setColumnWidth(4, 80);
	}
	
	public void itemAddMethod() {
		
		strdataitem[0] = String.valueOf(vid.size()+1);
		strdataitem[1] = lblOrderID.getText();
		vid.addElement(strdataitem[1]);
		strdataitem[2] = lbItemName.getText();
		strdataitem[3] = lblOrderAddress.getText();
		strdataitem[4] = lblQty.getText();
		strdataitem[5] =(String)cboOrderID.getSelectedItem();
		strdataitem[6] = lblFees.getText();
		vamount.addElement(strdataitem[6]);
		vqty.addElement(strdataitem[4]);
		System.out.println(vqty);
		dtm.addRow(strdataitem);
		cboOrderID.requestFocus();
	}
	

	public void clearItem() {
		lbItemName.setText("");
		lblOrderAddress.setText("");
		lblQty.setText("");
        lblOrderID.setText("");
		cboOrderID.setSelectedIndex(0);
		lblFees.setText("");
	}

	public void deleteRow() {
		int i = tblDelivery.getSelectedRow();
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
		cboDeliverID.setSelectedIndex(0);
		lblDeliverName.setText("");
		lblAddress.setText("");
		lblEmail.setText("");
		lblPhone.setText("");
        lblCapacity.setText("");
		lbItemName.setText("");
		lblOrderAddress.setText("");
		lblTotal_Qty.setText("");
		lblTotalAmount.setText("");
		lblFees.setText("");
		cboOrderID.setSelectedIndex(0);

		dtm.setRowCount(0);
		lblTotalAmount.setText("0Kyat");
	}
	public void displayImg() {
		ImageIcon imgIco = new ImageIcon(getClass().getResource("/My_Img/delivery1.jpeg"));
		Image img = imgIco.getImage().getScaledInstance(lblPhoto.getWidth(), lblPhoto.getHeight(), Image.SCALE_SMOOTH);
		lblPhoto.setIcon(new ImageIcon(img));
	}
	public void displayImg1() {
		ImageIcon imgIco = new ImageIcon(getClass().getResource("/My_Img/delivery1.jpeg"));
		Image img = imgIco.getImage().getScaledInstance(lblPhoto1.getWidth(), lblPhoto1.getHeight(), Image.SCALE_SMOOTH);
		lblPhoto1.setIcon(new ImageIcon(img));
	}
	public void displayImg2() {
		ImageIcon imgIco = new ImageIcon(getClass().getResource("/My_Img/delivery1.jpeg"));
		Image img = imgIco.getImage().getScaledInstance(lblPhoto2.getWidth(), lblPhoto2.getHeight(), Image.SCALE_SMOOTH);
		lblPhoto2.setIcon(new ImageIcon(img));
	}
}
