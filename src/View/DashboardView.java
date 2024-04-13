package View;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import javax.swing.border.LineBorder;
import javax.swing.JSpinner;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DashboardView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblPhoto;
	private JLabel lblEdit;
	private JLabel lblEdit1;
	private JLabel lblEdit2;
	private JLabel lblItem;
	private JLabel lblSupplier;
	private JLabel lblPurchase;
	private JLabel lblSupplier1;
	private JLabel lblCustomer;
	private JLabel lblSale;
	private JLabel lblOrder;
	private JLabel lblDeliver;
	private JLabel lblDelivery;
	private JPanel pType;
	private JPanel pBrand;
	private JPanel pItem;
	private JPanel pSupplier;
	private JPanel pPurchase;
	private JPanel pCustomer;
	private JPanel pSale;
	private JPanel pOrder;
	private JPanel pDeliver;
	private JPanel pDelivery;
	private JPanel pPurchaseView;
	private JPanel pSaleView;
	private JPanel pOrderView;
	private JPanel pDeliveryView;
	private JLabel lblDb;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DashboardView frame = new DashboardView();
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
	public DashboardView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 852, 544);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(0, 0, 0,80));
		panel.setBounds(191, 35, 499, 107);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Pos system for Baby Accessories ");
		lblNewLabel.setForeground(new Color(255, 255, 0));
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
		lblNewLabel.setBounds(97, 14, 314, 34);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Welcome to Our Admin Dashboard");
		lblNewLabel_1.setForeground(new Color(255, 255, 0));
		lblNewLabel_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(128, 48, 249, 28);
		panel.add(lblNewLabel_1);
		
		lblPhoto = new JLabel("");
		lblPhoto.setBounds(-198, -32, 845, 497);
		panel.add(lblPhoto);
		lblPhoto.setForeground(new Color(0, 0, 0));
		lblPhoto.setBackground(new Color(0, 0, 0));
		
		JSpinner spinner = new JSpinner();
		spinner.setForeground(new Color(0, 0, 0));
		spinner.setBackground(new Color(0, 0, 0));
		spinner.setBounds(-13, 162, 916, 9);
		contentPane.add(spinner);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setBounds(-13, 0, 851, 507);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		pType = new JPanel();
		pType.setBackground(new Color(255, 255, 255));
		pType.setBorder(new LineBorder(new Color(0, 0, 0)));
		pType.setBounds(23, 204, 123, 51);
		panel_1.add(pType);
		pType.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Edit Type");
		lblNewLabel_3.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(8, 14, 76, 17);
		pType.add(lblNewLabel_3);
		lblEdit = new JLabel("");
		lblEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TypeView tv;
				try {
					tv = new TypeView();
					tv.setVisible(true);
					tv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		lblEdit.setBounds(46, 0, 69, 49);
		pType.add(lblEdit);
		
		pBrand = new JPanel();
		pBrand.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BrandView bv = new BrandView();
				bv.setVisible(true);
				bv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		pBrand.setLayout(null);
		pBrand.setBorder(new LineBorder(new Color(0, 0, 0)));
		pBrand.setBounds(182, 204, 123, 51);
		panel_1.add(pBrand);
		
		JLabel lblNewLabel_3_1 = new JLabel("Edit Brand");
		lblNewLabel_3_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		lblNewLabel_3_1.setBounds(8, 14, 76, 17);
		pBrand.add(lblNewLabel_3_1);
		
		lblEdit1 = new JLabel("");
		lblEdit1.setBounds(48, 0, 69, 49);
		pBrand.add(lblEdit1);
		
		JLabel lblEdit_2 = new JLabel("");
		lblEdit_2.setBounds(59, 0, 69, 49);
		pBrand.add(lblEdit_2);
		
		pItem = new JPanel();
		pItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ItemView iv = new ItemView();
				iv.setVisible(true);
				iv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		pItem.setLayout(null);
		pItem.setBorder(new LineBorder(new Color(0, 0, 0)));
		pItem.setBounds(351, 204, 123, 51);
		panel_1.add(pItem);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Edit Item");
		lblNewLabel_3_1_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		lblNewLabel_3_1_1.setBounds(8, 14, 76, 17);
		pItem.add(lblNewLabel_3_1_1);
		
		lblItem = new JLabel("");
		lblItem.setBounds(69, 0, 48, 49);
		pItem.add(lblItem);
		
		JLabel lblEdit_2_1 = new JLabel("");
		lblEdit_2_1.setBounds(59, 0, 69, 49);
		pItem.add(lblEdit_2_1);
		
		lblEdit2 = new JLabel("");
		lblEdit2.setBounds(48, 0, 69, 49);
		pItem.add(lblEdit2);
		
		pPurchase = new JPanel();
		pPurchase.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PurchaseView pv = new PurchaseView();
				pv.setVisible(true);
				pv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		pPurchase.setLayout(null);
		pPurchase.setBorder(new LineBorder(new Color(0, 0, 0)));
		pPurchase.setBounds(693, 204, 123, 51);
		panel_1.add(pPurchase);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("Edit Purchase");
		lblNewLabel_3_1_1_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		lblNewLabel_3_1_1_1.setBounds(8, 14, 91, 17);
		pPurchase.add(lblNewLabel_3_1_1_1);
		
		lblSupplier = new JLabel("");
		lblSupplier.setBounds(91, 0, 37, 49);
		pPurchase.add(lblSupplier);
		
		JLabel lblEdit_2_1_1 = new JLabel("");
		lblEdit_2_1_1.setBounds(59, 0, 69, 49);
		pPurchase.add(lblEdit_2_1_1);
		
		JLabel lblEdit2_1 = new JLabel("");
		lblEdit2_1.setBounds(48, 0, 69, 49);
		pPurchase.add(lblEdit2_1);
		
		pSupplier = new JPanel();
		pSupplier.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SupplierView sv = new SupplierView();
				sv.setVisible(true);
				sv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		pSupplier.setLayout(null);
		pSupplier.setBorder(new LineBorder(new Color(0, 0, 0)));
		pSupplier.setBounds(521, 204, 123, 51);
		panel_1.add(pSupplier);
		
		JLabel lblNewLabel_3_1_1_1_1 = new JLabel("Edit Supplier");
		lblNewLabel_3_1_1_1_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		lblNewLabel_3_1_1_1_1.setBounds(8, 14, 91, 17);
		pSupplier.add(lblNewLabel_3_1_1_1_1);
		
		lblSupplier1 = new JLabel("");
		lblSupplier1.setBounds(80, 0, 48, 49);
		pSupplier.add(lblSupplier1);
		
		lblPurchase = new JLabel("");
		lblPurchase.setBounds(59, 0, 69, 49);
		pSupplier.add(lblPurchase);
		
		JLabel lblEdit2_1_1 = new JLabel("");
		lblEdit2_1_1.setBounds(48, 0, 69, 49);
		pSupplier.add(lblEdit2_1_1);
		
		pCustomer = new JPanel();
		pCustomer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CustomerView cv = new CustomerView();
				cv.setVisible(true);
				cv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		pCustomer.setLayout(null);
		pCustomer.setBorder(new LineBorder(new Color(0, 0, 0)));
		pCustomer.setBounds(23, 299, 123, 51);
		panel_1.add(pCustomer);
		
		JLabel lblNewLabel_3_2 = new JLabel("Edit Customer");
		lblNewLabel_3_2.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		lblNewLabel_3_2.setBounds(8, 14, 89, 17);
		pCustomer.add(lblNewLabel_3_2);
		
		lblCustomer = new JLabel("");
		lblCustomer.setBounds(75, 0, 48, 49);
		pCustomer.add(lblCustomer);
		
		pSale = new JPanel();
		pSale.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SaleView sv = new SaleView();
				sv.setVisible(true);
				sv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		pSale.setLayout(null);
		pSale.setBorder(new LineBorder(new Color(0, 0, 0)));
		pSale.setBounds(182, 299, 123, 51);
		panel_1.add(pSale);
		
		JLabel lblNewLabel_3_2_1 = new JLabel("Edit Sale");
		lblNewLabel_3_2_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		lblNewLabel_3_2_1.setBounds(8, 14, 64, 17);
		pSale.add(lblNewLabel_3_2_1);
		
		lblSale = new JLabel("");
		lblSale.setBounds(75, 0, 48, 49);
		pSale.add(lblSale);
		
		pOrder = new JPanel();
		pOrder.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				OrderView ov;
				try {
					ov = new OrderView();
					ov.setVisible(true);
					ov.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		pOrder.setLayout(null);
		pOrder.setBorder(new LineBorder(new Color(0, 0, 0)));
		pOrder.setBounds(351, 299, 123, 51);
		panel_1.add(pOrder);
		
		JLabel lblNewLabel_3_2_1_1 = new JLabel("Edit Order");
		lblNewLabel_3_2_1_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		lblNewLabel_3_2_1_1.setBounds(8, 14, 64, 17);
		pOrder.add(lblNewLabel_3_2_1_1);
		
		lblOrder = new JLabel("");
		lblOrder.setBounds(75, 0, 48, 49);
		pOrder.add(lblOrder);
		
		pDeliver = new JPanel();
		pDeliver.setLayout(null);
		pDeliver.setBorder(new LineBorder(new Color(0, 0, 0)));
		pDeliver.setBounds(521, 299, 123, 51);
		panel_1.add(pDeliver);
		
		JLabel lblNewLabel_3_2_1_1_1 = new JLabel("Edit Deliver");
		lblNewLabel_3_2_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DeliverView dv = new DeliverView();
				dv.setVisible(true);
				dv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		lblNewLabel_3_2_1_1_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		lblNewLabel_3_2_1_1_1.setBounds(8, 14, 73, 17);
		pDeliver.add(lblNewLabel_3_2_1_1_1);
		
		lblDeliver = new JLabel("");
		lblDeliver.setBounds(75, 0, 48, 49);
		pDeliver.add(lblDeliver);
		
		pDelivery = new JPanel();
		pDelivery.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DeliveryView dv = new DeliveryView();
				dv.setVisible(true);
				dv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		pDelivery.setLayout(null);
		pDelivery.setBorder(new LineBorder(new Color(0, 0, 0)));
		pDelivery.setBounds(693, 299, 123, 51);
		panel_1.add(pDelivery);
		
		JLabel lblNewLabel_3_2_1_1_1_1 = new JLabel("Edit Delivery");
		lblNewLabel_3_2_1_1_1_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		lblNewLabel_3_2_1_1_1_1.setBounds(8, 14, 90, 17);
		pDelivery.add(lblNewLabel_3_2_1_1_1_1);
		
		lblDelivery = new JLabel("");
		lblDelivery.setBounds(67, 0, 56, 49);
		pDelivery.add(lblDelivery);
		
		pPurchaseView = new JPanel();
		pPurchaseView.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PurchaseDetailView pdv = new PurchaseDetailView();
				pdv.setVisible(true);
				pdv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		pPurchaseView.setBorder(new LineBorder(new Color(0, 0, 0)));
		pPurchaseView.setBounds(158, 380, 205, 33);
		panel_1.add(pPurchaseView);
		pPurchaseView.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Purchase Detail View");
		lblNewLabel_2.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(33, 0, 150, 31);
		pPurchaseView.add(lblNewLabel_2);
		
		pSaleView = new JPanel();
		pSaleView.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SaleDetailView sdv = new SaleDetailView();
				sdv.setVisible(true);
				sdv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		pSaleView.setLayout(null);
		pSaleView.setBorder(new LineBorder(new Color(0, 0, 0)));
		pSaleView.setBounds(521, 380, 205, 33);
		panel_1.add(pSaleView);
		
		JLabel lblNewLabel_2_1 = new JLabel("Sale Detail View");
		lblNewLabel_2_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		lblNewLabel_2_1.setBounds(52, 0, 120, 31);
		pSaleView.add(lblNewLabel_2_1);
		
		pOrderView = new JPanel();
		pOrderView.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				OrderDetailView odv = new OrderDetailView();
				odv.setVisible(true);
				odv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		pOrderView.setLayout(null);
		pOrderView.setBorder(new LineBorder(new Color(0, 0, 0)));
		pOrderView.setBounds(158, 442, 205, 33);
		panel_1.add(pOrderView);
		
		JLabel lblNewLabel_2_2 = new JLabel("Order Detail View");
		lblNewLabel_2_2.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		lblNewLabel_2_2.setBounds(48, 0, 123, 31);
		pOrderView.add(lblNewLabel_2_2);
		
		pDeliveryView = new JPanel();
		pDeliveryView.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DeliveryDetailView dvd = new DeliveryDetailView();
				dvd.setVisible(true);
				dvd.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		pDeliveryView.setLayout(null);
		pDeliveryView.setBorder(new LineBorder(new Color(0, 0, 0)));
		pDeliveryView.setBounds(521, 442, 205, 33);
		panel_1.add(pDeliveryView);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Delivery Detail View");
		lblNewLabel_2_2_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		lblNewLabel_2_2_1.setBounds(34, 0, 149, 31);
		pDeliveryView.add(lblNewLabel_2_2_1);
		
		lblDb = new JLabel("");
		lblDb.setBounds(8, 0, 843, 507);
		panel_1.add(lblDb);
		
		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int centerX = (int) (screenDimension.getWidth() - getWidth()) / 2;
	    int centerY = (int) (screenDimension.getHeight() - getHeight()) / 2;
	    setLocation(centerX, centerY);
	    displayImg();
	    displayEdit();
	    displayBrandEdit();
	    displayItemEdit();
	    displaySupplierEdit();
	    displayPurchaseEdit();
	    displayCustomerEdit();
	    displaySaleEdit();
	    displayOrderEdit();
	    displayDeliverEdit();
	    displayDeliveryEdit();
	    displayBackground();
	}
	public void displayImg() {
		ImageIcon imgIco = new ImageIcon(getClass().getResource("/My_Img/dashboard.jpeg"));
		Image img = imgIco.getImage().getScaledInstance(lblPhoto.getWidth(), lblPhoto.getHeight(), Image.SCALE_SMOOTH);
		lblPhoto.setIcon(new ImageIcon(img));
	}
	public void displayEdit() {
		ImageIcon imgIco = new ImageIcon(getClass().getResource("/My_Img/edit (2).png"));
		Image img = imgIco.getImage().getScaledInstance(lblEdit.getWidth(), lblEdit.getHeight(), Image.SCALE_SMOOTH);
		lblEdit.setIcon(new ImageIcon(img));
	}
	public void displayBrandEdit() {
		ImageIcon imgIco = new ImageIcon(getClass().getResource("/My_Img/edit (2).png"));
		Image img = imgIco.getImage().getScaledInstance(lblEdit1.getWidth(), lblEdit1.getHeight(), Image.SCALE_SMOOTH);
		lblEdit1.setIcon(new ImageIcon(img));
	}
	public void displayItemEdit() {
		ImageIcon imgIco = new ImageIcon(getClass().getResource("/My_Img/item.png"));
		Image img = imgIco.getImage().getScaledInstance(lblItem.getWidth(), lblItem.getHeight(), Image.SCALE_SMOOTH);
		lblItem.setIcon(new ImageIcon(img));
	}
	public void displayPurchaseEdit() {
		ImageIcon imgIco = new ImageIcon(getClass().getResource("/My_Img/purchase (4).png"));
		Image img = imgIco.getImage().getScaledInstance(lblSupplier.getWidth(), lblSupplier.getHeight(), Image.SCALE_SMOOTH);
		lblSupplier.setIcon(new ImageIcon(img));
	}
	public void displaySupplierEdit() {
		ImageIcon imgIco = new ImageIcon(getClass().getResource("/My_Img/supplier.png"));
		Image img = imgIco.getImage().getScaledInstance(lblSupplier1.getWidth(), lblSupplier1.getHeight(), Image.SCALE_SMOOTH);
		lblSupplier1.setIcon(new ImageIcon(img));
	}
	public void displayCustomerEdit() {
		ImageIcon imgIco = new ImageIcon(getClass().getResource("/My_Img/customer.png"));
		Image img = imgIco.getImage().getScaledInstance(lblCustomer.getWidth(), lblCustomer.getHeight(), Image.SCALE_SMOOTH);
		lblCustomer.setIcon(new ImageIcon(img));
	}
	public void displaySaleEdit() {
		ImageIcon imgIco = new ImageIcon(getClass().getResource("/My_Img/sale.png"));
		Image img = imgIco.getImage().getScaledInstance(lblSale.getWidth(), lblSale.getHeight(), Image.SCALE_SMOOTH);
		lblSale.setIcon(new ImageIcon(img));
	}
	public void displayOrderEdit() {
		ImageIcon imgIco = new ImageIcon(getClass().getResource("/My_Img/order.png"));
		Image img = imgIco.getImage().getScaledInstance(lblOrder.getWidth(), lblOrder.getHeight(), Image.SCALE_SMOOTH);
		lblOrder.setIcon(new ImageIcon(img));
	};
	public void displayDeliverEdit() {
		ImageIcon imgIco = new ImageIcon(getClass().getResource("/My_Img/deliver.png"));
		Image img = imgIco.getImage().getScaledInstance(lblDeliver.getWidth(), lblDeliver.getHeight(), Image.SCALE_SMOOTH);
		lblDeliver.setIcon(new ImageIcon(img));
	};
	public void displayDeliveryEdit() {
		ImageIcon imgIco = new ImageIcon(getClass().getResource("/My_Img/delivery.png"));
		Image img = imgIco.getImage().getScaledInstance(lblDelivery.getWidth(), lblDelivery.getHeight(), Image.SCALE_SMOOTH);
		lblDelivery.setIcon(new ImageIcon(img));
	};
	public void displayBackground() {
		ImageIcon imgIco = new ImageIcon(getClass().getResource("/My_Img/dbbg.jpeg"));
		Image img = imgIco.getImage().getScaledInstance(lblDb.getWidth(), lblDb.getHeight(), Image.SCALE_SMOOTH);
		lblDb.setIcon(new ImageIcon(img));
	};
}
