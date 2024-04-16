package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import Connection.AutoID;
import Connection.Checking;
import Controller.BrandController;
import Controller.TypeController;
import Model.BrandModel;
import Model.TypeModel;

import javax.swing.JTextField;
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

public class TypeView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton btnSave;
	private JTextField txtTypeName;
	private JButton btnUpdate;
	private JPanel contentPane;
	private JButton btnClear;
	private JButton btnDelete;
	private JScrollPane scrollPane;
	private JTextField txtShowllAll;
	private JButton btnShowAll;
	private JLabel lblTypeID;
	private JTable tblType;
	DefaultTableModel dtm = new DefaultTableModel(); 
	int r=0;
	String typeID=null;
	private JLabel lblPhoto;
	private JScrollPane scrollPane_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TypeView frame = new TypeView();
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
	public TypeView() throws ClassNotFoundException {
		setTitle("Type View");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 687, 453);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(8, 14, 657, 191);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Type ID:");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		lblNewLabel_1.setBounds(28, 56, 57, 28);
		panel.add(lblNewLabel_1);
		
		lblTypeID = new JLabel("");
		lblTypeID.setForeground(new Color(255, 255, 255));
		lblTypeID.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		lblTypeID.setBounds(174, 60, 135, 21);
		panel.add(lblTypeID);
		
		JLabel lblNewLabel_1_1 = new JLabel("Type Name:");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(31, 98, 78, 28);
		panel.add(lblNewLabel_1_1);
		
		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int centerX = (int) (screenDimension.getWidth() - getWidth()) / 2;
	    int centerY = (int) (screenDimension.getHeight() - getHeight()) / 2;
	    setLocation(centerX, centerY);
		
		txtTypeName = new JTextField();
		txtTypeName.setBackground(new Color(255, 255, 255));
		txtTypeName.setForeground(new Color(0, 0, 0));
		txtTypeName.setBounds(174, 96, 138, 35);
		panel.add(txtTypeName);
		txtTypeName.setColumns(10);
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TypeController tc = new TypeController();
				TypeModel tm = new TypeModel();
				if(lblTypeID.getText().toString().equals("")||txtTypeName.getText().toString().equals("")) {
					JOptionPane.showMessageDialog(null,"This is a blank field","Fail", JOptionPane.ERROR_MESSAGE);
					txtTypeName.requestFocus(true);
					txtTypeName.selectAll();
				}else {
					tm.setType_id(lblTypeID.getText().toString());
					tm.setName(txtTypeName.getText().toString());
					if(Checking.IsValidName(tm.getName()) || (!Checking.IsAllDigit(tm.getName()))) {
						JOptionPane.showMessageDialog(null,"Invalid Name","Invalid", JOptionPane.ERROR_MESSAGE);
						txtTypeName.requestFocus(true);
						txtTypeName.selectAll();
					}else {
						try {
							if(tc.isduplicate(tm)) {
								JOptionPane.showMessageDialog(null,"There is a same type name","Fail", JOptionPane.ERROR_MESSAGE);
								txtTypeName.requestFocus(true);
								txtTypeName.selectAll();
							}else {
								int rs = tc.insert(tm);
								if(rs==1) {
									JOptionPane.showMessageDialog(null,"Save Successfully","Successfully", JOptionPane.INFORMATION_MESSAGE);
									try {
										AutoID();
										showList();
									} catch (ClassNotFoundException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
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
		btnSave.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		btnSave.setBounds(330, 95, 93, 35);
		panel.add(btnSave);
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TypeController tc = new TypeController();
				TypeModel tm = new TypeModel();
				if(lblTypeID.getText().toString().equals("")||txtTypeName.getText().toString().equals("")) {
					JOptionPane.showMessageDialog(null,"This is a blank field","Fail", JOptionPane.ERROR_MESSAGE);
					txtTypeName.requestFocus(true);
					txtTypeName.selectAll();
				}else {
					tm.setType_id(lblTypeID.getText().toString());
					tm.setName(txtTypeName.getText().toString());
					if(Checking.IsValidName(tm.getName()) || (!Checking.IsAllDigit(tm.getName()))) {
						JOptionPane.showMessageDialog(null,"Invalid Name","Invalid", JOptionPane.ERROR_MESSAGE);
						txtTypeName.requestFocus(true);
						txtTypeName.selectAll();
					}else {
						try {
							if(tc.isduplicate(tm)) {
								JOptionPane.showMessageDialog(null,"There is a same type name","Fail", JOptionPane.ERROR_MESSAGE);
								txtTypeName.requestFocus(true);
								txtTypeName.selectAll();
							}else {
								int rs = tc.update(tm);
								if(rs==1) {
									JOptionPane.showMessageDialog(null,"Update Successfully","Successfully", JOptionPane.INFORMATION_MESSAGE);
									try {
										AutoID();
										showList();
										clear();
									} catch (ClassNotFoundException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									clear();
								}else {
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
		btnUpdate.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		btnUpdate.setBounds(550, 95, 93, 35);
		panel.add(btnUpdate);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TypeModel bm = new TypeModel();
				bm.setType_id(typeID);
				if(!bm.getType_id().isBlank()) {
					if(JOptionPane.showConfirmDialog(null,"Are you sure you want to delete?","Confrim",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION) {
						TypeController bc = new TypeController();
						int rs;
						try {
							rs = bc.delete(bm);
							if(rs==1) {
								
								try {
									JOptionPane.showMessageDialog(null,"Delete Successfully","Successfully", JOptionPane.INFORMATION_MESSAGE);

									try {
										AutoID();
									} catch (ClassNotFoundException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
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
		
			}
			}
		});
		btnDelete.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		btnDelete.setEnabled(false);
		btnDelete.setBounds(444, 95, 93, 35);
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
		btnClear.setBounds(360, 142, 93, 35);
		panel.add(btnClear);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		btnClose.setBounds(494, 142, 93, 35);
		panel.add(btnClose);
		
		JLabel lblNewLabel = new JLabel("Type Entry And Type List");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(241, 15, 281, 31);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Rockwell", Font.BOLD, 20));
		
		lblPhoto = new JLabel("");
		lblPhoto.setBounds(0, 0, 657, 191);
		panel.add(lblPhoto);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(8, 260, 643, 156);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(22, 14, 599, 130);
		panel_1.add(scrollPane_1);
		
		scrollPane = new JScrollPane();
		scrollPane_1.setViewportView(scrollPane);
		
		tblType = new JTable();
		tblType.setBackground(new Color(211, 211, 211));
		tblType.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				r = tblType.getSelectedColumn();
				typeID =(String) tblType.getValueAt(r, 0);
				lblTypeID.setText(typeID);
				txtTypeName.setText((String)tblType.getValueAt(r, 1));
				btnSave.setEnabled(false);
				btnUpdate.setEnabled(true);
				btnDelete.setEnabled(true);
				txtTypeName.requestFocus();
				txtTypeName.selectAll();
//				System.out.println(typeID);
			}
	
		});
		scrollPane.setViewportView(tblType);
		
		JLabel lblNewLabel_1_2 = new JLabel("Type ID:");
		lblNewLabel_1_2.setFont(new Font("Pyidaungsu", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(256, 218, 57, 28);
		contentPane.add(lblNewLabel_1_2);
		
		txtShowllAll = new JTextField();
		txtShowllAll.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				try {
					showOneList();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		txtShowllAll.setColumns(10);
		txtShowllAll.setBounds(332, 211, 138, 35);
		contentPane.add(txtShowllAll);
		
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
		btnShowAll.setFont(new Font("Pyidaungsu", Font.PLAIN, 15));
		btnShowAll.setBounds(478, 215, 93, 35);
		contentPane.add(btnShowAll);
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
	public void AutoID() throws ClassNotFoundException{
		lblTypeID.setText(AutoID.getAutoID("type_id", "type","TY-"));
	}
	public void setColumnWidth(int index,int width) {
		DefaultTableColumnModel tcm =(DefaultTableColumnModel) tblType.getColumnModel();
		TableColumn tc = tcm.getColumn(index);
		tc.setPreferredWidth(width);
	}
	public void createTable() {
		dtm.addColumn("Type ID");
		dtm.addColumn("Type Name");
		tblType.setModel(dtm);
		setColumnWidth(0,30);
		setColumnWidth(1,60);
	}
	
	public void clear() {
		btnSave.setEnabled(true);
		btnUpdate.setEnabled(false); 
		btnDelete.setEnabled(false);
		txtTypeName.setText("");
		txtTypeName.requestFocus();
	}
	public void showList() throws SQLException{
		String data[] = new String[2];
		TypeController tc = new TypeController();
		
		List<TypeModel>list = tc.selectall();
		dtm.setRowCount(0);
		for(TypeModel tm:list) {
			data[0]=tm.getType_id();
			data[1]=tm.getName();
			dtm.addRow(data);
		}
	}
	
	public void showOneList()throws SQLException{
		String data[] = new String[2];
		TypeController tc = new TypeController();
		TypeModel t = new TypeModel();
		t.setName(txtShowllAll.getText().toString().trim());
		List<TypeModel> list = tc.selectone(t);
		dtm.setRowCount(0);
		for(TypeModel tm:list) {
			data[0] = tm.getType_id();
			data[1] = tm.getName();
			dtm.addRow(data);
		}
	}
	
	public void displayImg() {
		ImageIcon imgIco = new ImageIcon(getClass().getResource("/My_Img/type.jpeg"));
		Image img = imgIco.getImage().getScaledInstance(lblPhoto.getWidth(), lblPhoto.getHeight(), Image.SCALE_SMOOTH);
		lblPhoto.setIcon(new ImageIcon(img));
	}

}
