import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.NumberFormatter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.text.NumberFormat;

import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JSpinner;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.SwingConstants;

public class LotayFlAmazonAddItem extends JFrame {
	
	//Create Number formatter for input verification
	NumberFormat numFormat = NumberFormat.getNumberInstance();
	

	private JPanel contentPane;
	private final JLabel lblItemId = new JLabel("Item ID:");
	private final JLabel lblItemName = new JLabel("Item Name:");
	private final JLabel lblCategory = new JLabel("Category:");
	private final JLabel lblQuantity = new JLabel("Quantity:");
	private final JLabel lblPrice = new JLabel("Price ($):");
	private final JLabel lblShipping = new JLabel("Shipping ($):");
	private final JFormattedTextField ftfItemID = new JFormattedTextField(numFormat);
	private final JTextField tfItemName = new JTextField();
	private final JComboBox comboBoxCategory = new JComboBox();
	private final JFormattedTextField ftfPrice = new JFormattedTextField(numFormat);
	private final JFormattedTextField ftfShipping = new JFormattedTextField(numFormat);
	private final JButton btnOk = new JButton("OK");
	private final JButton btnCancel = new JButton("Cancel");
	private final JSeparator separator = new JSeparator();
	private final JSpinner spinQuantity = new JSpinner();


	/**
	 * Create the frame.
	 */
	public LotayFlAmazonAddItem() {
		tfItemName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				do_tfItemName_focusLost(arg0);
			}
		});
		tfItemName.setToolTipText("<html>\r\n<h3 style=\"font-weight: bold; font-size: 13;\">Item Name</h3>\r\n<p style=\"font-size: 12;\">Please enter the Item Name</p>\r\n<html>");
		tfItemName.setBounds(149, 66, 159, 23);
		tfItemName.setColumns(10);
		jbInit();
	}
	private void jbInit() {
		setTitle("Add Item");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 403, 392);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblItemId.setToolTipText("<html>\r\n<h3 style=\"font-weight: bold; font-size: 13;\">Item ID</h3>\r\n<p style=\"font-size: 12;\">Please Enter the Item ID</p>\r\n<html>");
		lblItemId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblItemId.setBounds(56, 32, 70, 15);
		
		contentPane.add(lblItemId);
		ftfItemID.setHorizontalAlignment(SwingConstants.RIGHT);
		ftfItemID.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
				do_ftfItemID_propertyChange(arg0);
			}
		});
		ftfItemID.setToolTipText("<html>\r\n<h3 style=\"font-weight: bold; font-size: 13;\">Item ID</h3>\r\n<p style=\"font-size: 12;\">Please Enter the Item ID</p>\r\n<html>");
		ftfItemID.setBounds(149, 29, 70, 23);
		
		contentPane.add(ftfItemID);
		lblItemName.setToolTipText("<html>\r\n<h3 style=\"font-weight: bold; font-size: 13;\">Item Name</h3>\r\n<p style=\"font-size: 12;\">Please enter the Item Name</p>\r\n<html>");
		lblItemName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblItemName.setBounds(56, 69, 70, 15);
		
		contentPane.add(lblItemName);
		
		contentPane.add(tfItemName);
		lblCategory.setToolTipText("<html>\r\n<h3 style=\"font-weight: bold; font-size: 13;\">Item Category</h3>\r\n<p style=\"font-size: 12;\">Please select an item category</p>\r\n<html>");
		lblCategory.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCategory.setBounds(56, 106, 70, 15);
		
		contentPane.add(lblCategory);
		comboBoxCategory.setToolTipText("<html>\r\n<h3 style=\"font-weight: bold; font-size: 13;\">Item Category</h3>\r\n<p style=\"font-size: 12;\">Please select an item category</p>\r\n<html>");
		comboBoxCategory.setModel(new DefaultComboBoxModel(new String[] {"Automotive", "Books", "Clothing", "Computers", "Electronics", "Home & Garden", "Movies", "Music", "Sports", "Other"}));
		comboBoxCategory.setBounds(149, 103, 159, 23);
		
		contentPane.add(comboBoxCategory);
		lblQuantity.setToolTipText("<html>\r\n<h3 style=\"font-weight: bold; font-size: 13;\">Item Quantity</h3>\r\n<p style=\"font-size: 12;\">Please specify the item quantity</p>\r\n<html>");
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblQuantity.setBounds(56, 143, 70, 15);
		
		contentPane.add(lblQuantity);
		lblPrice.setToolTipText("<html>\r\n<h3 style=\"font-weight: bold; font-size: 13;\">Item Price</h3>\r\n<p style=\"font-size: 12;\">Please enter the item price</p>\r\n<html>");
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPrice.setBounds(56, 180, 70, 15);
		
		contentPane.add(lblPrice);
		ftfPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		ftfPrice.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
				do_ftfPrice_propertyChange(arg0);
			}
		});
		ftfPrice.setToolTipText("<html>\r\n<h3 style=\"font-weight: bold; font-size: 13;\">Item Price</h3>\r\n<p style=\"font-size: 12;\">Please enter the item price</p>\r\n<html>");
		ftfPrice.setBounds(149, 177, 70, 23);
		
		contentPane.add(ftfPrice);
		lblShipping.setToolTipText("<html>\r\n<h3 style=\"font-weight: bold; font-size: 13;\">Shipping</h3>\r\n<p style=\"font-size: 12;\">Please enter the shipping charge</p>\r\n<html>");
		lblShipping.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblShipping.setBounds(56, 217, 82, 15);
		
		contentPane.add(lblShipping);
		ftfShipping.setHorizontalAlignment(SwingConstants.RIGHT);
		ftfShipping.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
				do_ftfShipping_propertyChange(arg0);
			}
		});
		ftfShipping.setToolTipText("<html>\r\n<h3 style=\"font-weight: bold; font-size: 13;\">Shipping</h3>\r\n<p style=\"font-size: 12;\">Please enter the shipping charge</p>\r\n<html>");
		ftfShipping.setBounds(149, 211, 70, 23);
		
		contentPane.add(ftfShipping);
		separator.setBounds(53, 263, 281, 2);
		
		contentPane.add(separator);
		btnOk.setToolTipText("<html>\r\n<h3 style=\"font-weight: bold; font-size: 13;\">Add Item</h3>\r\n<p style=\"font-size: 12;\">Add Item to your shopping cart</p>\r\n<html>");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnOk_actionPerformed(e);
			}
		});
		btnOk.setBounds(69, 292, 89, 23);
		
		contentPane.add(btnOk);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnCancel_actionPerformed(e);
			}
		});
		btnCancel.setBounds(227, 292, 89, 23);
		
		contentPane.add(btnCancel);
		
		//Load the driver
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		}
		catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		spinQuantity.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_spinQuantity_focusLost(e);
			}
		});
		spinQuantity.setBounds(149, 140, 70, 23);
		
		contentPane.add(spinQuantity);
	}
	
	protected void do_btnOk_actionPerformed(ActionEvent e) {
		Statement stmt = null;
		
		//Error checking/validation
		if(ftfItemID.getText().trim().isEmpty()){
			show_Error_Message("Please specify an ItemID!");
			foregroundChange(lblItemId, 1);
			ftfItemID.grabFocus();
		}
		else if((Long)(ftfItemID.getValue()) < 0){
			show_Error_Message("Please specify a positive ItemID!");
			foregroundChange(lblItemId, 1);
			ftfItemID.grabFocus();
		}
		else if(tfItemName.getText().trim().isEmpty()){
			show_Error_Message("Please specify an Item Name!");
			foregroundChange(lblItemName, 1);
			tfItemName.grabFocus();
		}
		else if(spinQuantity.getValue().equals(0)){
			show_Error_Message("Please specify the Item Quantity");
			foregroundChange(lblQuantity, 1);
			spinQuantity.grabFocus();
		}
		else if(ftfPrice.getText().trim().isEmpty()){
			show_Error_Message("Please specify the Item Price");
			foregroundChange(lblPrice, 1);
			ftfPrice.grabFocus();
		}
		else if(ftfShipping.getText().trim().isEmpty()){
			show_Error_Message("Please specify the Item Shipping Cost");
			foregroundChange(lblShipping, 1);
			ftfShipping.grabFocus();
		}
		else{
			
			//reset label color to black
			foregroundChange(lblItemId, 0);
			foregroundChange(lblItemName, 0);
			foregroundChange(lblQuantity, 0);
			foregroundChange(lblPrice, 0);
			foregroundChange(lblShipping, 0);
			
			try {
				//2. Establish the connection
				Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Public/FlAmazon.accdb");
				
				//3. create the statement to
				//different type to allow insert/update
				stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				
				String query = "INSERT INTO ShoppingCart (ItemId, ItemName, Category, Quantity, Price, Shipping) VALUES (";
				query += ftfItemID.getValue() + ", ";
				query += "'" + tfItemName.getText().trim() + "' , ";
				query += "'" + comboBoxCategory.getSelectedItem() + "' , ";
				query += spinQuantity.getValue() + ", ";
				query += ftfPrice.getValue() + ", ";
				query += ftfShipping.getValue() + ")";
				
				System.out.println(query);
				
				//Execute the statement (and process results)
				if(stmt.executeUpdate(query) != 0) {
					System.out.println("Sucessful");
				} 
				else { 
					System.out.println("Nope");
				}
				
			conn.close();
			
			}//try
			catch (SQLException ex){
				System.out.println("SQL Exception: " + ex.getMessage());
				System.out.println("SQL State: " + ex.getSQLState());
				System.out.println("Vendor Error: " + ex.getErrorCode());
				//ex.printStackTrace();
				
				if(ex.getMessage().contains("violation: unique constraint")){
					show_Error_Message("Please enter a unique value for Item ID!");
				}
				
				return;
			} //catch
			
			this.dispose();
		}
	}
	protected void do_btnCancel_actionPerformed(ActionEvent e) {
		this.dispose();
	}
	
	//Change the component foreground color
	protected void foregroundChange(JComponent com, Integer status){
		switch(status){
		case 0:
			com.setForeground(Color.BLACK);
			break;
		case 1:
			com.setForeground(Color.RED);
			break;
		case 2:
			com.setForeground(Color.GRAY);
			break;
		}
	}
	
	//Show error message, with message provided as parameter
	protected void show_Error_Message(String msg){
		JOptionPane.showMessageDialog(getFocusOwner(), "<html><h3 style=\"font-size: 14\">" + msg + "</h3></html>", "Form Incomplete!", JOptionPane.ERROR_MESSAGE);
	}

	protected void do_spinQuantity_focusLost(FocusEvent e) {
		if(spinQuantity.getValue().equals(0)){
			foregroundChange(lblQuantity, 1);
		}
		else if (((Integer)(spinQuantity.getValue())) < 0){
			foregroundChange(lblQuantity, 1);
		}
		else {
			foregroundChange(lblQuantity, 0);
		}
	}
	protected void do_ftfItemID_propertyChange(PropertyChangeEvent arg0) {
		if(ftfItemID.getText().trim().isEmpty()){
			foregroundChange(lblItemId, 1);
		}
		else if((Long)(ftfItemID.getValue()) < 0){
			foregroundChange(lblItemId, 1);
		}
		else{
			foregroundChange(lblItemId, 0);
		}
	}
	
	protected void do_ftfPrice_propertyChange(PropertyChangeEvent arg0) {
		if(ftfPrice.getText().trim().isEmpty()){
			foregroundChange(lblPrice, 1);
		}
		else if((Long)(ftfPrice.getValue()) < 0){
			foregroundChange(lblPrice, 1);
		}
		else{
			foregroundChange(lblPrice, 0);
		}
	}
	
	protected void do_ftfShipping_propertyChange(PropertyChangeEvent arg0) {
		if(ftfShipping.getText().trim().isEmpty()){
			foregroundChange(lblShipping, 1);
		}
		else if((Long)(ftfShipping.getValue()) < 0){
			foregroundChange(lblShipping, 1);
		}
		else{
			foregroundChange(lblShipping, 0);
		}
	}
	protected void do_tfItemName_focusLost(FocusEvent arg0) {
		if(tfItemName.getText().trim().isEmpty()){
			foregroundChange(lblItemName, 1);
		}
		else{
			foregroundChange(lblItemName, 0);
		}
	}
}
