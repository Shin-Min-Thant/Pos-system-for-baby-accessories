package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import Connection.date;
import Controller.Loss_ProfitController;
import Model.loss_profitModel;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.text.DateFormatSymbols;
import java.time.LocalDate;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Profit_LossView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblPurchase;
	private JLabel lblDelivery;
	private JLabel lblSale;
	private JLabel lblOrder;
	private JLabel lblProfit1;
	private JLabel lblLoss1;
	private JLabel lblPhoto;
	private JLabel lblPhoto1;
	private JLabel lblDate;
	private JComboBox cboMonth;
	private JLabel lblBg;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Profit_LossView frame = new Profit_LossView();
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
	public Profit_LossView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 495, 644);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 64));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Total Purchase Price:");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 12));
		lblNewLabel.setBounds(44, 181, 182, 38);
		contentPane.add(lblNewLabel);
		
		JLabel lblTotalDeliveryPrice = new JLabel("Total Delivery Fees Price:");
		lblTotalDeliveryPrice.setForeground(new Color(0, 0, 0));
		lblTotalDeliveryPrice.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 12));
		lblTotalDeliveryPrice.setBounds(44, 233, 192, 38);
		contentPane.add(lblTotalDeliveryPrice);
		
		JLabel lblTotalSlaePrice = new JLabel("Total Sale Price:");
		lblTotalSlaePrice.setForeground(new Color(0, 0, 0));
		lblTotalSlaePrice.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 12));
		lblTotalSlaePrice.setBounds(44, 364, 138, 38);
		contentPane.add(lblTotalSlaePrice);
		
		JLabel lblTotalOrderPrice = new JLabel("Total Order Price:");
		lblTotalOrderPrice.setForeground(new Color(0, 0, 0));
		lblTotalOrderPrice.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 12));
		lblTotalOrderPrice.setBounds(46, 429, 149, 38);
		contentPane.add(lblTotalOrderPrice);
		
		JLabel lblProfitAndLoss = new JLabel("3 Months Profit And Loss");
		lblProfitAndLoss.setForeground(new Color(0, 0, 0));
		lblProfitAndLoss.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 15));
		lblProfitAndLoss.setBounds(140, 79, 243, 38);
		contentPane.add(lblProfitAndLoss);
		
		JLabel lblProfit = new JLabel("Profit");
		lblProfit.setForeground(new Color(0, 0, 0));
		lblProfit.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 15));
		lblProfit.setBounds(81, 512, 62, 38);
		contentPane.add(lblProfit);
		
		JLabel lblLoss = new JLabel("Loss");
		lblLoss.setForeground(new Color(0, 0, 0));
		lblLoss.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 15));
		lblLoss.setBounds(317, 512, 62, 38);
		contentPane.add(lblLoss);
		Border b = BorderFactory.createLineBorder(Color.black);
		
		lblPurchase = new JLabel("");
		lblPurchase.setForeground(new Color(0, 0, 0));
		lblPurchase.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 12));
		lblPurchase.setBounds(244, 179, 164, 38);
		lblPurchase.setBorder(b);
		contentPane.add(lblPurchase);
		
		lblDelivery = new JLabel("");
		lblDelivery.setForeground(new Color(0, 0, 0));
		lblDelivery.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 12));
		lblDelivery.setBounds(244, 231, 164, 38);
		lblDelivery.setBorder(b);
		contentPane.add(lblDelivery);
		
		lblSale = new JLabel("");
		lblSale.setForeground(new Color(0, 0, 0));
		lblSale.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 12));
		lblSale.setBounds(244, 364, 164, 38);
		lblSale.setBorder(b);
		contentPane.add(lblSale);
		
		lblOrder = new JLabel("");
		lblOrder.setForeground(new Color(0, 0, 0));
		lblOrder.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 12));
		lblOrder.setBounds(244, 429, 164, 38);
		lblOrder.setBorder(b);
		contentPane.add(lblOrder);
		
		lblProfit1 = new JLabel("0");
		lblProfit1.setForeground(new Color(0, 0, 0));
		lblProfit1.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 12));
		lblProfit1.setBounds(61, 555, 82, 38);
		lblProfit1.setBorder(b);
		contentPane.add(lblProfit1);
		
		lblLoss1 = new JLabel("0");
		lblLoss1.setForeground(new Color(0, 0, 0));
		lblLoss1.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 12));
		lblLoss1.setBounds(297, 555, 82, 38);
		lblLoss1.setBorder(b);
		contentPane.add(lblLoss1);
		
	
		lblPhoto = new JLabel("");
		lblPhoto.setForeground(new Color(255, 255, 255));
		lblPhoto.setBounds(18, 124, 440, 167);
		lblPhoto.setBorder(b);
		contentPane.add(lblPhoto);
		
		lblPhoto1 = new JLabel("");
		lblPhoto1.setBounds(18, 317, 440, 167);
		lblPhoto1.setBorder(b);
		contentPane.add(lblPhoto1);
		
		JLabel lblOutgo = new JLabel("Outcome");
		lblOutgo.setForeground(new Color(0, 0, 0));
		lblOutgo.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 15));
		lblOutgo.setBounds(206, 131, 91, 38);
		contentPane.add(lblOutgo);
		
		JLabel Earnings = new JLabel("Earnings");
		Earnings.setForeground(new Color(0, 0, 0));
		Earnings.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 15));
		Earnings.setBounds(191, 318, 91, 38);
		contentPane.add(Earnings);
		
		lblDate = new JLabel("");
		lblDate.setForeground(new Color(0, 0, 0));
		lblDate.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 12));
		lblDate.setBounds(8, 14, 91, 38);
		lblDate.setBorder(b);
		contentPane.add(lblDate);
		
		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int centerX = (int) (screenDimension.getWidth() - getWidth()) / 2;
	    int centerY = (int) (screenDimension.getHeight() - getHeight()) / 2;
	    setLocation(centerX, centerY);
		
	    JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayData();
			}
		});
		
		btnSearch.setFont(new Font("Pyidaungsu", Font.PLAIN, 13));
		btnSearch.setBounds(391, 22, 82, 25);
		contentPane.add(btnSearch);
		
		cboMonth = new JComboBox();
		cboMonth.setBounds(244, 23, 124, 25);
		String[] months = new DateFormatSymbols().getMonths();
		for (String month : months) {
			cboMonth.addItem(month);
		}
		contentPane.add(cboMonth);
		

        // Update the selected month label
        date d = new date();
		lblDate.setText(d.getMySQLDateFormat());
		
		lblBg = new JLabel("");
		lblBg.setBounds(0, 0, 481, 607);
		contentPane.add(lblBg);
		defaultZero();
		displayImg();
	}
	
	public void caculateProfitAndLoss() {
		int totalPurchase = showPurchase();
		int totalDelivery = showDelivery();
		int totalSale = showSale();
		int totalOrder = showOrder();
		int go = totalPurchase + totalDelivery ;
		int out = totalSale + totalOrder;
		int profit = out - go;
		int loss = go - out;
		if(profit <0) {
			lblProfit1.setText("0");
		}else {
			lblProfit1.setText(profit+"");
		}
		if(loss<0) {
			lblLoss1.setText("0");
		}else {
			lblLoss1.setText(loss + "");
		}
		
	}
	
	
	public int showPurchase() {
	    int totalPurchase = 0; // Initialize total purchase price
	    StringBuilder purchaseText = new StringBuilder(); // StringBuilder to accumulate purchase text
	    
	    Loss_ProfitController ic = new Loss_ProfitController();
	    try {
	        List<loss_profitModel> list = ic.showPurchase();
	        for(loss_profitModel im:list) {
	            String purchase = im.getTotal_purchase();
	            if (purchase != null && !purchase.isEmpty()) {
	                // Extracting numeric value from the purchase string
	                int purchasePrice = Integer.parseInt(purchase.replaceAll("[^\\d]", ""));
	                totalPurchase += purchasePrice; // Accumulate the total purchase price
	            }
	        }
	        // Update the text to display in lblPurchase
	        purchaseText.append(totalPurchase);
	        lblPurchase.setText(purchaseText.toString());
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return totalPurchase;
	}
	
	public int showSale() {
	    int totalSale = 0; // Initialize total purchase price
	    StringBuilder saleText = new StringBuilder(); // StringBuilder to accumulate purchase text
	    
	    Loss_ProfitController ic = new Loss_ProfitController();
	    try {
	        List<loss_profitModel> list = ic.showSale();
	        for(loss_profitModel im:list) {
	            String sale = im.getTotal_sale();
	            if (sale != null && !sale.isEmpty()) {
	                // Extracting numeric value from the purchase string
	                int purchasePrice = Integer.parseInt(sale.replaceAll("[^\\d]", ""));
	                totalSale += purchasePrice; // Accumulate the total purchase price
	            }
	        }
	        // Update the text to display in lblPurchase
	        saleText.append(totalSale);
	        lblSale.setText(saleText.toString());
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return totalSale;
	}
	
	public int showOrder() {
	    int totalOrder = 0; // Initialize total purchase price
	    StringBuilder orerText = new StringBuilder(); // StringBuilder to accumulate purchase text
	    
	    Loss_ProfitController ic = new Loss_ProfitController();
	    try {
	        List<loss_profitModel> list = ic.showOrder();
	        for(loss_profitModel im:list) {
	            String sale = im.getTotal_sale();
	            if (sale != null && !sale.isEmpty()) {
	                // Extracting numeric value from the purchase string
	                int orderPrice = Integer.parseInt(sale.replaceAll("[^\\d]", ""));
	                totalOrder += orderPrice; // Accumulate the total purchase price
	            }
	        }
	        // Update the text to display in lblPurchase
	        orerText.append(totalOrder);
	        lblOrder.setText(orerText.toString());
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return totalOrder;
	}
	

	public int showDelivery() {
	    int totaldeli = 0; // Initialize total purchase price
	    StringBuilder deliText = new StringBuilder(); // StringBuilder to accumulate purchase text
	    
	    Loss_ProfitController ic = new Loss_ProfitController();
	    try {
	        List<loss_profitModel> list = ic.showDelivery();
	        for(loss_profitModel im:list) {
	            String deli = im.getTotal_sale();
	            if (deli != null && !deli.isEmpty()) {
	                // Extracting numeric value from the purchase string
	                int orderPrice = Integer.parseInt(deli.replaceAll("[^\\d]", ""));
	                totaldeli += orderPrice; // Accumulate the total purchase price
	            }
	        }
	        // Update the text to display in lblPurchase
	        deliText.append(totaldeli);
	        lblDelivery.setText(deliText.toString());
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return totaldeli;
	}
	
	 public void displayData() {
	        String selectedMonth = (String) cboMonth.getSelectedItem();
	        int selectedMonthIndex = cboMonth.getSelectedIndex() + 1; // Month index is 0-based
	        int currentMonth = LocalDate.now().getMonthValue();
	        
	        int monthdifference = selectedMonthIndex - currentMonth;
	        if(monthdifference >= 0 && monthdifference <=2) {
	        	 showSale();
			     showOrder();
			     showDelivery();
			     caculateProfitAndLoss();
	        }else {
	        	defaultZero();
	        }

	    }
	 
	 public void defaultZero() {
		 lblPurchase.setText("0");
     	lblSale.setText("0");
     	lblOrder.setText("0");
     	lblDelivery.setText("0");
     	lblProfit1.setText("0");
     	lblLoss1.setText("0");
	 }
	 
		public void displayImg() {
			ImageIcon imgIco = new ImageIcon(getClass().getResource("/My_Img/profit.jpeg"));
			Image img = imgIco.getImage().getScaledInstance(lblBg.getWidth(), lblBg.getHeight(), Image.SCALE_SMOOTH);
			lblBg.setIcon(new ImageIcon(img));
		}
}
