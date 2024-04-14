package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.text.JTextComponent;

import Connection.AutoID;
import Connection.Checking;
import Controller.BrandController;
import Model.BrandModel;

import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class BrandView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtBrandName;
	private JButton btnSave;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnClear;
	private JButton btnClose;
	private JTextField txtShowAll;
	private JButton btnShowAll;
	private JLabel lblBrandID;
	private JTable tblBrand;

	DefaultTableModel dtm = new DefaultTableModel();
	private JScrollPane scrollPane;
	String brandID=null;
	int r;
	private JLabel lblPhoto;
	private JScrollPane scrollPane_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BrandView frame = new BrandView();
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
	public BrandView() {
		setTitle("Brand View");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 655, 447);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(44, 132, 148));
		panel.setBounds(0, 0, 632, 189);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Brand ID:");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		lblNewLabel_1.setBounds(24, 70, 65, 17);
		panel.add(lblNewLabel_1);
		
		lblBrandID = new JLabel("");
		lblBrandID.setForeground(new Color(255, 255, 255));
		lblBrandID.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		lblBrandID.setBounds(154, 70, 101, 17);
		panel.add(lblBrandID);
		
		JLabel lblNewLabel_1_1 = new JLabel("Brand Name:");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(22, 119, 97, 17);
		panel.add(lblNewLabel_1_1);
		
		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int centerX = (int) (screenDimension.getWidth() - getWidth()) / 2;
	    int centerY = (int) (screenDimension.getHeight() - getHeight()) / 2;
	    setLocation(centerX, centerY);
	    
		txtBrandName = new JTextField();
		txtBrandName.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		txtBrandName.setBounds(147, 115, 108, 23);
		panel.add(txtBrandName);
		txtBrandName.setColumns(10);
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BrandModel bm = new BrandModel();
				BrandController bc = new BrandController();
				if(lblBrandID.getText().trim().equals("") || txtBrandName.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null,"There is a blank field!","Fail", JOptionPane.ERROR_MESSAGE);
					txtBrandName.requestFocus();
					txtBrandName.selectAll();
				}else {
					bm.setBrand_id(lblBrandID.getText().toString());
					bm.setName(txtBrandName.getText().toString());
					if(Checking.IsValidName(bm.getName()) || (!Checking.IsAllDigit(bm.getName()))) {
						JOptionPane.showMessageDialog(null,"Invalid Name","Invalid", JOptionPane.ERROR_MESSAGE);
						txtBrandName.requestFocus();
						txtBrandName.selectAll();
					}else {
						try {
							if(bc.isduplicate(bm)) {
								JOptionPane.showMessageDialog(null, "There is a same brand name!","Fail", JOptionPane.ERROR_MESSAGE);	
								txtBrandName.requestFocus(true);
								txtBrandName.selectAll();
							}else {
								int rs = bc.update(bm);
								System.out.println(rs);
								if(rs==1) {
									JOptionPane.showMessageDialog(null,"Update Successfully","Successfully", JOptionPane.INFORMATION_MESSAGE);
									AutoID();
									clear();
								} else {
									JOptionPane.showMessageDialog(null,"Update fails");

								}
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}
		});
		btnUpdate.setEnabled(false);
		btnUpdate.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		btnUpdate.setBounds(408, 61, 87, 35);
		panel.add(btnUpdate);
		
		btnDelete = new JButton("Delete");
		btnDelete.setEnabled(false);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BrandModel bm = new BrandModel();
				bm.setBrand_id(lblBrandID.getText().toString());
				if(!bm.getBrand_id().isBlank()) {
					if(JOptionPane.showConfirmDialog(null,"Are you sure you want to delete?","Confrim",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION) {
						BrandController bc = new BrandController();
						int rs;
						try {
							rs = bc.delete(bm);
							if(rs==1) {
								
								try {
									JOptionPane.showMessageDialog(null,"Delete Successfully","Successfully", JOptionPane.INFORMATION_MESSAGE);

									AutoID();
									showList();
									clear();
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}else {
								JOptionPane.showMessageDialog(null,"Delete fails");
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
		
			}}
		});
		btnDelete.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		btnDelete.setBounds(537, 61, 87, 35);
		panel.add(btnDelete);
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BrandModel bm = new BrandModel();
				BrandController bc = new BrandController();
				if(lblBrandID.getText().trim().equals("") || txtBrandName.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null,"There is a blank field!","Fail", JOptionPane.ERROR_MESSAGE);
					txtBrandName.requestFocus();
					txtBrandName.selectAll();
				}else {
					bm.setBrand_id(lblBrandID.getText().toString());
					bm.setName(txtBrandName.getText().toString());
					if(Checking.IsValidName(bm.getName()) || (!Checking.IsAllDigit(bm.getName()))) {
						JOptionPane.showMessageDialog(null,"Invalid Name","Invalid", JOptionPane.ERROR_MESSAGE);
						txtBrandName.requestFocus();
						txtBrandName.selectAll();
					}else {
						try {
							if(bc.isduplicate(bm)) {
								JOptionPane.showMessageDialog(null, "There is a same brand name!","Fail", JOptionPane.ERROR_MESSAGE);	
								txtBrandName.requestFocus(true);
								txtBrandName.selectAll();
							}else {
								int rs = bc.insert(bm);
								if(rs==1) {
									JOptionPane.showMessageDialog(null,"Save Successfully","Successfully", JOptionPane.INFORMATION_MESSAGE);
									AutoID();
									showList();
									clear();
								}
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}
		});
		btnSave.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		btnSave.setBounds(282, 61, 87, 35);
		panel.add(btnSave);
		
		btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
				AutoID();
			}
		});
		btnClear.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		btnClear.setBounds(329, 129, 87, 35);
		panel.add(btnClear);
		
		btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		btnClose.setBounds(479, 129, 87, 35);
		panel.add(btnClose);
		
		JLabel lblNewLabel = new JLabel("Brand Entry And Brand List");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(174, 14, 303, 24);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Rockwell", Font.BOLD, 20));
		
		lblPhoto = new JLabel("");
		lblPhoto.setBounds(0, 0, 632, 189);
		panel.add(lblPhoto);
		
		JLabel lblNewLabel_3 = new JLabel("Brand Name:");
		lblNewLabel_3.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(262, 203, 85, 17);
		contentPane.add(lblNewLabel_3);
		
		txtShowAll = new JTextField();
		txtShowAll.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				try {
					showListone();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		txtShowAll.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		txtShowAll.setBounds(355, 203, 121, 23);
		contentPane.add(txtShowAll);
		txtShowAll.setColumns(10);
		
		btnShowAll = new JButton("Show All");
		btnShowAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					showList();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnShowAll.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		btnShowAll.setBounds(500, 194, 98, 35);
		contentPane.add(btnShowAll);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(0, 236, 632, 174);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(8, 14, 616, 146);
		panel_1.add(scrollPane_1);
		
		scrollPane = new JScrollPane();
		scrollPane_1.setViewportView(scrollPane);
		
		tblBrand = new JTable();
		tblBrand.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				r=tblBrand.getSelectedRow();
				brandID =(String) tblBrand.getValueAt(r, 0);
				lblBrandID.setText(brandID);
				txtBrandName.setText((String)tblBrand.getValueAt(r, 1));
				btnSave.setEnabled(false);
				btnUpdate.setEnabled(true);
				btnDelete.setEnabled(true);
				txtBrandName.requestFocus();
				txtBrandName.selectAll();
//				System.out.println(brandID);
			}
		});
		scrollPane.setViewportView(tblBrand);
		tblBrand.setBackground(new Color(0, 206, 209));
		tblBrand.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		displayImg();
		AutoID();
		createTable();
		try {
			showList();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void AutoID(){
		try {
			lblBrandID.setText(AutoID.getAutoID("brand_id", "brand","BR-"));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setColoumnWidth(int index,int width) {
		DefaultTableColumnModel tcm = (DefaultTableColumnModel)tblBrand.getColumnModel();
		TableColumn tc = tcm.getColumn(index);
		tc.setPreferredWidth(width);
	}
	
	public void createTable() {
		dtm.addColumn("Brand ID");
		dtm.addColumn("Brand Name");
		tblBrand.setModel(dtm);
		setColoumnWidth(0,30);
		setColoumnWidth(1,60);
	}
	
	public void showList() throws SQLException{
		String data[] = new String[2];
		BrandController bc = new BrandController();
		List<BrandModel> list = bc.selectall();
		dtm.setRowCount(0);
		for(BrandModel bm:list) {
			data[0] = bm.getBrand_id();
			data[1] = bm.getName();
			dtm.addRow(data);
		}
	}
	
	public void showListone() throws SQLException{
		String data[]= new String[2];
		BrandModel b = new BrandModel();
		b.setName(txtShowAll.getText().toString().trim());
		BrandController bc = new BrandController();
		List<BrandModel> list = bc.selectone(b);
		dtm.setRowCount(0);
		for(BrandModel bm:list) {
			data[0]=bm.getBrand_id();
			data[1]=bm.getName();
			dtm.addRow(data);
		}
	}
	
	public void clear() {
		btnSave.setEnabled(true);
		btnUpdate.setEnabled(false);
		btnDelete.setEnabled(false);
		txtBrandName.setText("");
		txtBrandName.requestFocus(true);
	}
	public void displayImg() {
		ImageIcon imgIco = new ImageIcon(getClass().getResource("/My_Img/brand.jpeg"));
		Image img = imgIco.getImage().getScaledInstance(lblPhoto.getWidth(), lblPhoto.getHeight(), Image.SCALE_SMOOTH);
		lblPhoto.setIcon(new ImageIcon(img));
	}

	
}
