package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import Controller.OrderDetailController;
import Controller.SaleDetailController;
import Model.OrderDetailModel;
import Model.SaleDetailModel;

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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class OrderDetailView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtShowAll;
	private JTable tblOrder;
	DefaultTableModel dtm = new DefaultTableModel();
	private JLabel lblPhoto;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderDetailView frame = new OrderDetailView();
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
	public OrderDetailView() {
		setTitle("Order Detail View");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 682, 529);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBackground(Color.LIGHT_GRAY);
		contentPane_1.setBounds(0, 0, 666, 493);
		contentPane.add(contentPane_1);
		
		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int centerX = (int) (screenDimension.getWidth() - getWidth()) / 2;
	    int centerY = (int) (screenDimension.getHeight() - getHeight()) / 2;
	    setLocation(centerX, centerY);
		
		JLabel lblNewLabel = new JLabel("ItemName:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		lblNewLabel.setBounds(347, 25, 80, 17);
		contentPane_1.add(lblNewLabel);
		
		txtShowAll = new JTextField();
		txtShowAll.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				showListOne();
			}
		});
		txtShowAll.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		txtShowAll.setColumns(10);
		txtShowAll.setBounds(435, 23, 115, 23);
		contentPane_1.add(txtShowAll);
		
		JButton btnShowAll = new JButton("Show All");
		btnShowAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showList();
			}
		});
		btnShowAll.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		btnShowAll.setBounds(558, 21, 94, 25);
		contentPane_1.add(btnShowAll);
		
		JLabel lblOrderDetail = new JLabel("Order Detail");
		lblOrderDetail.setForeground(new Color(255, 255, 255));
		lblOrderDetail.setFont(new Font("Rockwell", Font.BOLD, 17));
		lblOrderDetail.setBounds(33, 26, 153, 17);
		contentPane_1.add(lblOrderDetail);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(29, 75, 607, 404);
		contentPane_1.add(scrollPane_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane_1.setViewportView(scrollPane);
		
		tblOrder = new JTable();
		tblOrder.setBackground(new Color(255, 128, 128));
		tblOrder.getTableHeader().setBackground(Color.blue);
		tblOrder.getTableHeader().setForeground(Color.white);
		scrollPane.setViewportView(tblOrder);
		
		lblPhoto = new JLabel("");
		lblPhoto.setBounds(0, 0, 666, 493);
		contentPane_1.add(lblPhoto);
		displayImg();
		createTable();
		showList();
	}
	
	public void setColumnWidth(int index , int width)
	{
	     DefaultTableColumnModel tcm = (DefaultTableColumnModel)tblOrder.getColumnModel();
	     TableColumn tc = tcm.getColumn(index);
	     tc.setPreferredWidth(width);
    }
    public void createTable()
	{
	     dtm.addColumn("Order Id");
	     dtm.addColumn("Item Name");
	     dtm.addColumn("Order_price"); 
	     dtm.addColumn("Order_qty");
	     dtm.addColumn("Status");
	     tblOrder.setModel(dtm);
	     setColumnWidth(0,60);
	     setColumnWidth(1,60);
	     setColumnWidth(2,60);
	     setColumnWidth(3,60);
	     setColumnWidth(3,60);
	     
    }
    public void showList(){
    	String data[] = new String[5];
    	OrderDetailController pdc = new OrderDetailController();
    	try {
			List<OrderDetailModel> list = pdc.showAll();
			dtm.setRowCount(0);
			for(OrderDetailModel sm:list) {
				data[0] = sm.getOrder_id();
				data[1] = sm.getItem_name();
				data[2] = sm.getOrder_price()+"";
				data[3] = sm.getOrder_qty()+"";
				data[4] = sm.getStatus();
				dtm.addRow(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void showListOne(){
    	String data[] = new String[5];
    	OrderDetailController sc = new OrderDetailController();
    	OrderDetailModel s = new OrderDetailModel();
    	s.setItem_name(txtShowAll.getText().toString().trim());
    	try {
			List<OrderDetailModel> list = sc.showOne(s);
			dtm.setRowCount(0);
			for(OrderDetailModel sm:list) {
				data[0] = sm.getOrder_id();
				data[1] = sm.getItem_name();
				data[2] = sm.getOrder_price()+"";
				data[3] = sm.getOrder_qty()+"";
				data[4] = sm.getStatus();
				dtm.addRow(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public void displayImg() {
  		ImageIcon imgIco = new ImageIcon(getClass().getResource("/My_Img/order.jpeg"));
  		Image img = imgIco.getImage().getScaledInstance(lblPhoto.getWidth(), lblPhoto.getHeight(), Image.SCALE_SMOOTH);
  		lblPhoto.setIcon(new ImageIcon(img));
  	}
}
