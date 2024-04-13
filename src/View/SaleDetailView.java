package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import Controller.SaleDetailController;
import Model.SaleDetailModel;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SaleDetailView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtItemName;
	private JTable tblSale;
	private JButton btnShowAll;
	DefaultTableModel dtm = new DefaultTableModel();
	private JLabel lblPhoto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SaleDetailView frame = new SaleDetailView();
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
	public SaleDetailView() {
		setTitle("Sale Detail");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 684, 543);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBackground(Color.LIGHT_GRAY);
		contentPane_1.setBounds(8, 14, 666, 493);
		contentPane.add(contentPane_1);
		
		JLabel lblNewLabel = new JLabel("ItemName:");
		lblNewLabel.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		lblNewLabel.setBounds(347, 25, 80, 17);
		contentPane_1.add(lblNewLabel);
		
		txtItemName = new JTextField();
		txtItemName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				showListOne();
			}
		});
		txtItemName.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		txtItemName.setColumns(10);
		txtItemName.setBounds(435, 23, 115, 23);
		contentPane_1.add(txtItemName);
		
		btnShowAll = new JButton("Show All");
		btnShowAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showList();
			}
		});
		btnShowAll.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		btnShowAll.setBounds(558, 21, 94, 25);
		contentPane_1.add(btnShowAll);
		
		JLabel lblPurchaseDetail = new JLabel("Sale Detail");
		lblPurchaseDetail.setFont(new Font("Pyidaungsu", Font.BOLD, 17));
		lblPurchaseDetail.setBounds(33, 26, 153, 17);
		contentPane_1.add(lblPurchaseDetail);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 56, 619, 402);
		scrollPane.getViewport().setBackground(new Color(0, 0, 0, 0));
		contentPane_1.add(scrollPane);
		
		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int centerX = (int) (screenDimension.getWidth() - getWidth()) / 2;
	    int centerY = (int) (screenDimension.getHeight() - getHeight()) / 2;
	    setLocation(centerX, centerY);
		
		tblSale = new JTable();
		tblSale.setForeground(new Color(255, 255, 255));
		scrollPane.setViewportView(tblSale);
		tblSale.setBackground(new Color(123, 104, 238));
		tblSale.getTableHeader().setBackground(Color.blue);
		tblSale.getTableHeader().setForeground(Color.white);
//		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		lblPhoto = new JLabel("");
		lblPhoto.setBounds(0, -15, 658, 508);
		contentPane_1.add(lblPhoto);
		displayImg();
		createTable();
		showList();
	}
	
	public void setColumnWidth(int index , int width)
	{
	     DefaultTableColumnModel tcm = (DefaultTableColumnModel)tblSale.getColumnModel();
	     TableColumn tc = tcm.getColumn(index);
	     tc.setPreferredWidth(width);
    }
    public void createTable()
	{
	     dtm.addColumn("Sale Id");
	     dtm.addColumn("Item Name");
	     dtm.addColumn("Sale_price"); 
	     dtm.addColumn("Sale_qty");
	     
	     tblSale.setModel(dtm);
	     setColumnWidth(0,60);
	     setColumnWidth(1,60);
	     setColumnWidth(2,60);
	     setColumnWidth(3,60);
	    
	     
    }
   
    public void showList(){
    	String data[] = new String[4];
    	SaleDetailController pdc = new SaleDetailController();
    	try {
			List<SaleDetailModel> list = pdc.showAll();
			dtm.setRowCount(0);
			for(SaleDetailModel sm:list) {
				data[0] = sm.getSale_id();
				data[1] = sm.getItem_name();
				data[2] = sm.getSale_price()+"";
				data[3] = sm.getSale_qty()+"";
				dtm.addRow(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void showListOne(){
    	String data[] = new String[4];
    	SaleDetailController sc = new SaleDetailController();
    	SaleDetailModel s = new SaleDetailModel();
    	s.setItem_name(txtItemName.getText().toString().trim());
    	try {
			List<SaleDetailModel> list = sc.showOne(s);
			dtm.setRowCount(0);
			for(SaleDetailModel sm:list) {
				data[0] = sm.getSale_id();
				data[1] = sm.getItem_name();
				data[2] = sm.getSale_price()+"";
				data[3] = sm.getSale_qty()+"";
				dtm.addRow(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public void displayImg() {
		ImageIcon imgIco = new ImageIcon(getClass().getResource("/My_Img/sale.jpeg"));
		Image img = imgIco.getImage().getScaledInstance(lblPhoto.getWidth(), lblPhoto.getHeight(), Image.SCALE_SMOOTH);
		lblPhoto.setIcon(new ImageIcon(img));
	}
}
