package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import Controller.DeliveryDetailController;
import Controller.OrderDetailController;
import Model.DeliveryDetailModel;
import Model.OrderDetailModel;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DeliveryDetailView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtName;
	private JButton btnShowAll;
	DefaultTableModel dtm = new DefaultTableModel();
	private JTable tblDelivery;
	private JLabel lblPhoto;
	private JScrollPane scrollPane_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeliveryDetailView frame = new DeliveryDetailView();
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
	public DeliveryDetailView() {
		setTitle("Delivery Detail View");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 690, 534);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int centerX = (int) (screenDimension.getWidth() - getWidth()) / 2;
	    int centerY = (int) (screenDimension.getHeight() - getHeight()) / 2;
	    setLocation(centerX, centerY);
		
	    JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBackground(Color.LIGHT_GRAY);
		contentPane_1.setBounds(8, 0, 666, 493);
		contentPane.add(contentPane_1);
		
		JLabel lblOrderitemname = new JLabel("Order_ItemName:");
		lblOrderitemname.setForeground(new Color(255, 255, 255));
		lblOrderitemname.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		lblOrderitemname.setBounds(294, 27, 133, 17);
		contentPane_1.add(lblOrderitemname);
		
		txtName = new JTextField();
		txtName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				showListOne();
			}
		});
		txtName.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		txtName.setColumns(10);
		txtName.setBounds(435, 23, 115, 23);
		contentPane_1.add(txtName);
		
		btnShowAll = new JButton("Show All");
		btnShowAll.setFocusable(false);
		btnShowAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showList();
			}
		});
		btnShowAll.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		btnShowAll.setBounds(558, 21, 94, 25);
		contentPane_1.add(btnShowAll);
		
		JLabel lblDeliveryDetail = new JLabel("Delivery Detail");
		lblDeliveryDetail.setForeground(new Color(255, 255, 255));
		lblDeliveryDetail.setFont(new Font("Rockwell", Font.BOLD, 18));
		lblDeliveryDetail.setBounds(33, 26, 153, 17);
		contentPane_1.add(lblDeliveryDetail);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(33, 66, 590, 402);
		contentPane_1.add(scrollPane_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane_1.setViewportView(scrollPane);
		
		tblDelivery = new JTable();
		tblDelivery.setBackground(new Color(64, 128, 128));
		tblDelivery.getTableHeader().setBackground(Color.blue);
		tblDelivery.getTableHeader().setForeground(Color.white);
		scrollPane.setViewportView(tblDelivery);
		
		lblPhoto = new JLabel("");
		lblPhoto.setBounds(0, 0, 666, 493);
		contentPane_1.add(lblPhoto);
		displayImg();
		createTable();
		showList();
	}
	public void setColumnWidth(int index , int width)
	{
	     DefaultTableColumnModel tcm = (DefaultTableColumnModel)tblDelivery.getColumnModel();
	     TableColumn tc = tcm.getColumn(index);
	     tc.setPreferredWidth(width);
    }
    public void createTable()
	{
	     dtm.addColumn("Delivery Id");
	     dtm.addColumn("Order Item Name");
	     dtm.addColumn("Delivery_price"); 
	     dtm.addColumn("Delivery_qty");
	     
	     tblDelivery.setModel(dtm);
	     setColumnWidth(0,60);
	     setColumnWidth(1,60);
	     setColumnWidth(2,60);
	     setColumnWidth(3,60);
	    
	     
    }
    public void showList(){
    	String data[] = new String[4];
    	DeliveryDetailController pdc = new DeliveryDetailController();
    	try {
			List<DeliveryDetailModel> list = pdc.showAll();
			dtm.setRowCount(0);
			for(DeliveryDetailModel sm:list) {
				data[0] = sm.getDelivery_id();
				data[1] = sm.getItem_name();
				data[2] = sm.getDelive_fees()+"";
				data[3] = sm.getDelivery_qty()+"";
				dtm.addRow(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void showListOne(){
    	String data[] = new String[4];
    	DeliveryDetailController sc = new DeliveryDetailController();
    	DeliveryDetailModel s = new DeliveryDetailModel();
    	s.setItem_name(txtName.getText().toString().trim());
    	try {
			List<DeliveryDetailModel> list = sc.showOne(s);
			dtm.setRowCount(0);
			for(DeliveryDetailModel sm:list) {
				data[0] = sm.getDelivery_id();
				data[1] = sm.getItem_name();
				data[2] = sm.getDelivery_price()+"";
				data[3] = sm.getDelivery_qty()+"";
				dtm.addRow(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void displayImg() {
 		ImageIcon imgIco = new ImageIcon(getClass().getResource("/My_Img/delivery.jpeg"));
 		Image img = imgIco.getImage().getScaledInstance(lblPhoto.getWidth(), lblPhoto.getHeight(), Image.SCALE_SMOOTH);
 		lblPhoto.setIcon(new ImageIcon(img));
 	}
}
