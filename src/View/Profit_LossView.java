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

import Controller.ItemController;
import Controller.Loss_ProfitController;
import Model.ItemModel;
import Model.loss_profitModel;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JTextField;

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
		setBounds(100, 100, 481, 565);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 64));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Total Purchase Price:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 12));
		lblNewLabel.setBounds(44, 100, 182, 38);
		contentPane.add(lblNewLabel);
		
		JLabel lblTotalDeliveryPrice = new JLabel("Total Delivery Fees Price:");
		lblTotalDeliveryPrice.setForeground(new Color(255, 255, 255));
		lblTotalDeliveryPrice.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 12));
		lblTotalDeliveryPrice.setBounds(44, 152, 192, 38);
		contentPane.add(lblTotalDeliveryPrice);
		
		JLabel lblTotalSlaePrice = new JLabel("Total Slae Price:");
		lblTotalSlaePrice.setForeground(new Color(255, 255, 255));
		lblTotalSlaePrice.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 12));
		lblTotalSlaePrice.setBounds(44, 285, 138, 38);
		contentPane.add(lblTotalSlaePrice);
		
		JLabel lblTotalOrderPrice = new JLabel("Total Order Price:");
		lblTotalOrderPrice.setForeground(new Color(255, 255, 255));
		lblTotalOrderPrice.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 12));
		lblTotalOrderPrice.setBounds(44, 350, 149, 38);
		contentPane.add(lblTotalOrderPrice);
		
		JLabel lblProfitAndLoss = new JLabel("Profit And Loss");
		lblProfitAndLoss.setForeground(new Color(255, 255, 255));
		lblProfitAndLoss.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 15));
		lblProfitAndLoss.setBounds(155, 0, 149, 38);
		contentPane.add(lblProfitAndLoss);
		
		JLabel lblProfit = new JLabel("Profit");
		lblProfit.setForeground(new Color(255, 255, 255));
		lblProfit.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 15));
		lblProfit.setBounds(71, 433, 62, 38);
		contentPane.add(lblProfit);
		
		JLabel lblLoss = new JLabel("Loss");
		lblLoss.setForeground(new Color(255, 255, 255));
		lblLoss.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 15));
		lblLoss.setBounds(307, 433, 62, 38);
		contentPane.add(lblLoss);
		Border b = BorderFactory.createLineBorder(Color.white);
		
		lblPurchase = new JLabel("");
		lblPurchase.setForeground(new Color(255, 255, 255));
		lblPurchase.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 12));
		lblPurchase.setBounds(234, 100, 164, 38);
		lblPurchase.setBorder(b);
		contentPane.add(lblPurchase);
		
		lblDelivery = new JLabel("");
		lblDelivery.setForeground(new Color(255, 255, 255));
		lblDelivery.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 12));
		lblDelivery.setBounds(234, 152, 164, 38);
		lblDelivery.setBorder(b);
		contentPane.add(lblDelivery);
		
		lblSale = new JLabel("");
		lblSale.setForeground(new Color(255, 255, 255));
		lblSale.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 12));
		lblSale.setBounds(234, 285, 164, 38);
		lblSale.setBorder(b);
		contentPane.add(lblSale);
		
		lblOrder = new JLabel("");
		lblOrder.setForeground(new Color(255, 255, 255));
		lblOrder.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 12));
		lblOrder.setBounds(234, 350, 164, 38);
		lblOrder.setBorder(b);
		contentPane.add(lblOrder);
		
		lblProfit1 = new JLabel("");
		lblProfit1.setForeground(new Color(255, 255, 255));
		lblProfit1.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 12));
		lblProfit1.setBounds(51, 476, 82, 38);
		lblProfit1.setBorder(b);
		contentPane.add(lblProfit1);
		
		lblLoss1 = new JLabel("0");
		lblLoss1.setForeground(new Color(255, 255, 255));
		lblLoss1.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 12));
		lblLoss1.setBounds(287, 476, 82, 38);
		lblLoss1.setBorder(b);
		contentPane.add(lblLoss1);
		
	
		lblPhoto = new JLabel("");
		lblPhoto.setForeground(new Color(255, 255, 255));
		lblPhoto.setBounds(8, 45, 440, 167);
		lblPhoto.setBorder(b);
		contentPane.add(lblPhoto);
		
		lblPhoto1 = new JLabel("");
		lblPhoto1.setBounds(8, 238, 440, 167);
		lblPhoto1.setBorder(b);
		contentPane.add(lblPhoto1);
		
		JLabel lblOutgo = new JLabel("Outgo");
		lblOutgo.setForeground(Color.WHITE);
		lblOutgo.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 15));
		lblOutgo.setBounds(196, 52, 62, 38);
		contentPane.add(lblOutgo);
		
		JLabel Earnings = new JLabel("Earnings");
		Earnings.setForeground(Color.WHITE);
		Earnings.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 15));
		Earnings.setBounds(181, 239, 91, 38);
		contentPane.add(Earnings);
		
		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int centerX = (int) (screenDimension.getWidth() - getWidth()) / 2;
	    int centerY = (int) (screenDimension.getHeight() - getHeight()) / 2;
	    setLocation(centerX, centerY);
		
		showPurchase();
		showSale();
		showOrder();
		showDelivery();
		caculateProfitAndLoss();
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
}
