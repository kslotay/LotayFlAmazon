import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JSeparator;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class LotayFlAmazonFilterByPrice extends JFrame {
	
	NumberFormat numFormat = NumberFormat.getNumberInstance();

	public String priceFilter = "";
	public String priceLabel = "Current Price Filters: none";
	private String priceFilterType = "";
	
	private JPanel contentPane;
	private final JRadioButton rdbtnLessThan = new JRadioButton("Less Than");
	private final JRadioButton rdbtnGreaterThan = new JRadioButton("Greater Than");
	private final JRadioButton rdbtnBetween = new JRadioButton("Between (Specify Range):");
	private final JLabel lblFilterByPrice = new JLabel("Show Me Items With A Price ($):");
	private final JFormattedTextField tfLowerRange = new JFormattedTextField(numFormat);
	private final JFormattedTextField tfUpperRange = new JFormattedTextField(numFormat);
	private final JLabel label = new JLabel("<        PRICE ($)        <");
	private final JButton btnSetFilter = new JButton("Set Filter");
	private final JSeparator separator = new JSeparator();
	private final JFormattedTextField tfLessGreater = new JFormattedTextField(numFormat);
	private final JSeparator separator_1 = new JSeparator();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final JButton button = new JButton("Close");

	/**
	 * Create the frame.
	 */
	public LotayFlAmazonFilterByPrice() {
		tfLowerRange.setToolTipText("<html>\r\n<h3 style=\"font-weight: bold; font-size: 13;\">Lower Range</h3>\r\n<p style=\"font-size: 12;\">Please specify the lower bound for price</p>\r\n<html>");
		tfLowerRange.setBounds(47, 168, 86, 28);
		tfLowerRange.setColumns(10);
		jbInit();
	}
	private void jbInit() {
		setTitle("Filter By Price");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 367);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblFilterByPrice.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFilterByPrice.setBounds(38, 31, 288, 14);
		
		contentPane.add(lblFilterByPrice);
		buttonGroup.add(rdbtnLessThan);
		rdbtnLessThan.setToolTipText("<html>\r\n<h3 style=\"font-weight: bold; font-size: 13;\">Price Filters</h3>\r\n<p style=\"font-size: 12;\">Please select one type of price filter and fill in the required details</p>\r\n<html>");
		rdbtnLessThan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_rdbtnLessThan_actionPerformed(e);
			}
		});
		rdbtnLessThan.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnLessThan.setBounds(38, 69, 95, 23);
		
		contentPane.add(rdbtnLessThan);
		buttonGroup.add(rdbtnGreaterThan);
		rdbtnGreaterThan.setToolTipText("<html>\r\n<h3 style=\"font-weight: bold; font-size: 13;\">Price Filters</h3>\r\n<p style=\"font-size: 12;\">Please select one type of price filter and fill in the required details</p>\r\n<html>");
		rdbtnGreaterThan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_rdbtnGreaterThan_actionPerformed(e);
			}
		});
		rdbtnGreaterThan.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnGreaterThan.setBounds(133, 69, 109, 23);
		
		contentPane.add(rdbtnGreaterThan);
		tfLessGreater.setToolTipText("<html>\r\n<h3 style=\"font-weight: bold; font-size: 13;\">Lesser/Greater than Price</h3>\r\n<p style=\"font-size: 12;\">Please specify the price to be used to filter</p>\r\n<html>");
		tfLessGreater.setColumns(10);
		tfLessGreater.setBounds(288, 67, 109, 28);
		
		contentPane.add(tfLessGreater);
		separator_1.setBounds(38, 111, 360, 21);
		
		contentPane.add(separator_1);
		buttonGroup.add(rdbtnBetween);
		rdbtnBetween.setToolTipText("<html>\r\n<h3 style=\"font-weight: bold; font-size: 13;\">Price Filters</h3>\r\n<p style=\"font-size: 12;\">Please select one type of price filter and fill in the required details</p>\r\n<html>");
		rdbtnBetween.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_rdbtnBetween_actionPerformed(e);
			}
		});
		rdbtnBetween.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnBetween.setBounds(38, 132, 204, 23);
		
		contentPane.add(rdbtnBetween);
		
		contentPane.add(tfLowerRange);
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setBounds(148, 174, 149, 14);
		
		contentPane.add(label);
		tfUpperRange.setToolTipText("<html>\r\n<h3 style=\"font-weight: bold; font-size: 13;\">Upper Range</h3>\r\n<p style=\"font-size: 12;\">Please specify the upper bound for price</p>\r\n<html>");
		tfUpperRange.setColumns(10);
		tfUpperRange.setBounds(311, 168, 86, 28);
		
		contentPane.add(tfUpperRange);
		separator.setBounds(38, 222, 360, 21);
		
		contentPane.add(separator);
		btnSetFilter.setToolTipText("<html>\r\n<h3 style=\"font-weight: bold; font-size: 13;\">Apply Filter</h3>\r\n<p style=\"font-size: 12;\">Apply the filter to your shopping cart</p>\r\n<html>");
		btnSetFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnSetFilter_actionPerformed(e);
			}
		});
		btnSetFilter.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSetFilter.setBounds(85, 254, 89, 28);
		
		contentPane.add(btnSetFilter);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_button_actionPerformed(arg0);
			}
		});
		button.setBounds(259, 254, 89, 28);
		
		contentPane.add(button);
	}
	protected void do_rdbtnLessThan_actionPerformed(ActionEvent e) {
		priceFilterType = "LESS";
		tfLessGreater.setEnabled(true);
		tfLowerRange.setEnabled(false);
		tfUpperRange.setEnabled(false);
	}
	protected void do_rdbtnGreaterThan_actionPerformed(ActionEvent e) {
		priceFilterType = "GREATER";
		tfLessGreater.setEnabled(true);
		tfLowerRange.setEnabled(false);
		tfUpperRange.setEnabled(false);
	}
	protected void do_rdbtnBetween_actionPerformed(ActionEvent e) {
		priceFilterType = "RANGE";
		tfLowerRange.setEnabled(true);
		tfUpperRange.setEnabled(true);
		tfLessGreater.setEnabled(false);
	}
	
	protected void do_btnSetFilter_actionPerformed(ActionEvent e) {
		
		switch(priceFilterType){
		case "LESS":
		case "GREATER":
			if(!tfLessGreater.getText().trim().equals("")){
				priceFilter = filterByPrice(priceFilterType);
			}
			else{
				JOptionPane.showMessageDialog(getFocusOwner(), "<html><h3 style=\"font-size: 14\">Please specify a value!", "Form Incomplete!", JOptionPane.ERROR_MESSAGE);
				return;
			}
			break;
		case "RANGE":
			if(!(tfUpperRange.getText().trim().equals("")) && !(tfLowerRange.getText().trim().equals(""))){
				if((Long)(tfUpperRange.getValue()) > (Long)(tfLowerRange.getValue())){
					priceFilter = filterByPrice("RANGE");
					break;
				}
				else if((Long)(tfUpperRange.getValue()) < (Long)(tfLowerRange.getValue())){
					JOptionPane.showMessageDialog(getFocusOwner(), "<html><h3 style=\"font-size: 14\">Please specify a max value greater than the specified miniumum!</h3></html>", "Form Incomplete!", JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
			else{
				JOptionPane.showMessageDialog(getFocusOwner(), "<html><h3 style=\"font-size: 14\">Please specify a range!", "Form Incomplete!", JOptionPane.ERROR_MESSAGE);
				return;
			}
			break;
		}
		
		
		this.setVisible(false);
	}
	
	//Price filter function
	protected String filterByPrice(String filterType){
		String returnStr = "";
		
		if(filterType == "LESS"){
			returnStr = "AND price < " + tfLessGreater.getValue() + " "; 
			priceLabel = "Current Price Filters: less than $" + tfLessGreater.getValue();
		}
		else if(filterType == "GREATER"){
			returnStr = "AND price > " + tfLessGreater.getValue() + " "; 
			priceLabel = "Current Price Filters: greater than $" + tfLessGreater.getValue();
		}
		else if(filterType == "RANGE"){
			returnStr = "AND price < " + tfUpperRange.getValue() + " AND price > " + tfLowerRange.getValue() + " ";
			priceLabel = "Current Price Filters: between $" + tfLowerRange.getValue() + " and $" + tfUpperRange.getValue();
		}
		else{
			priceLabel = "Current Price Filters: none";
		}
		
		return returnStr;
	}
	protected void do_button_actionPerformed(ActionEvent arg0) {
		this.setVisible(false);
	}
}
