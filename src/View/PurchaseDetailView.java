package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.mysql.jdbc.Connection;

import Controller.PurchaseDetailController;
import Model.PurchaseDetailModel;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;

public class PurchaseDetailView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tblPurchaseList;
	DefaultTableModel dtm = new DefaultTableModel();
	private JTextField txtShowAll;
	private JButton btnNewButton;
	private JTextField txtTotal;
	private JLabel lblPhoto;
    private PurchaseDetailController pdc;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PurchaseDetailView frame = new PurchaseDetailView();
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
	public PurchaseDetailView() {
		
		setTitle("Purchase List");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 674, 520);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(43, 56, 574, 359);
		contentPane.add(scrollPane);
		
		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int centerX = (int) (screenDimension.getWidth() - getWidth()) / 2;
	    int centerY = (int) (screenDimension.getHeight() - getHeight()) / 2;
	    setLocation(centerX, centerY);
		
		tblPurchaseList = new JTable();
		tblPurchaseList.setBackground(new Color(255, 228, 196));
		tblPurchaseList.getTableHeader().setBackground(Color.blue);
		tblPurchaseList.getTableHeader().setForeground(Color.white);
		scrollPane.setViewportView(tblPurchaseList);
		
		JLabel lblNewLabel = new JLabel("ItemName:");
		lblNewLabel.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		lblNewLabel.setBounds(347, 25, 80, 17);
		contentPane.add(lblNewLabel);
		
		txtShowAll = new JTextField();
		txtShowAll.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				showListOne();
			}
		});
		txtShowAll.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		txtShowAll.setBounds(435, 23, 115, 23);
		contentPane.add(txtShowAll);
		txtShowAll.setColumns(10);
		
		btnNewButton = new JButton("Show All");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showList();
			}
		});
		btnNewButton.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		btnNewButton.setBounds(558, 21, 94, 25);
		contentPane.add(btnNewButton);
		
		JLabel lblPurchaseDetail = new JLabel("Purchase Detail");
		lblPurchaseDetail.setFont(new Font("Pyidaungsu", Font.BOLD, 17));
		lblPurchaseDetail.setBounds(33, 26, 153, 17);
		contentPane.add(lblPurchaseDetail);
		
		txtTotal = new JTextField();
		txtTotal.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		txtTotal.setColumns(10);
		txtTotal.setBounds(502, 429, 115, 23);
		contentPane.add(txtTotal);
		
		JLabel lblTotalprice = new JLabel("TotalPrice:");
		lblTotalprice.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		lblTotalprice.setBounds(407, 434, 80, 17);
		contentPane.add(lblTotalprice);
		
		lblPhoto = new JLabel("");
		lblPhoto.setBounds(0, 0, 660, 483);
		contentPane.add(lblPhoto);
		displayImg();
		createTable();
		showList();
	}
	
	public void setColumnWidth(int index , int width)
	{
	     DefaultTableColumnModel tcm = (DefaultTableColumnModel)tblPurchaseList.getColumnModel();
	     TableColumn tc = tcm.getColumn(index);
	     tc.setPreferredWidth(width);
    }
    public void createTable()
	{
	     dtm.addColumn("Purchase Id");
	     dtm.addColumn("Item Name");
	     dtm.addColumn("Purchase_price"); 
	     dtm.addColumn("Purchase_qty");
	     
	     tblPurchaseList.setModel(dtm);
	     setColumnWidth(0,60);
	     setColumnWidth(1,60);
	     setColumnWidth(2,60);
	     setColumnWidth(3,60);
	    
	     
    }
    public void showList(){
    	String data[] = new String[4];
    	PurchaseDetailController pdc = new PurchaseDetailController();
    	try {
			List<PurchaseDetailModel> list = pdc.showAll();
			dtm.setRowCount(0);
			for(PurchaseDetailModel pdm:list) {
				data[0] = pdm.getPurchase_id();
				data[1] = pdm.getItem_name();
				data[2] = pdm.getPurchase_price()+"";
				data[3] = pdm.getPurchase_qty()+"";
				dtm.addRow(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void showListOne(){
    	String data[] = new String[4];
    	PurchaseDetailController pdc = new PurchaseDetailController();
    	PurchaseDetailModel p = new PurchaseDetailModel();
    	p.setItem_name(txtShowAll.getText().toString().trim());
    	try {
			List<PurchaseDetailModel> list = pdc.showOne(p);
			dtm.setRowCount(0);
			for(PurchaseDetailModel pdm:list) {
				data[0] = pdm.getPurchase_id();
				data[1] = pdm.getItem_name();
				data[2] = pdm.getPurchase_price()+"";
				data[3] = pdm.getPurchase_qty()+"";
				dtm.addRow(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void displayImg() {
 		ImageIcon imgIco = new ImageIcon(getClass().getResource("/My_Img/purchase.jpeg"));
 		Image img = imgIco.getImage().getScaledInstance(lblPhoto.getWidth(), lblPhoto.getHeight(), Image.SCALE_SMOOTH);
		lblPhoto.setIcon(new ImageIcon(img));
 	}
}
