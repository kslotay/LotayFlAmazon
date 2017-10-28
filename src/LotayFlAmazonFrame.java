/*
 * Kulvinder Lotay
 * FlAmazon Project
 * 7th April, 2016
 * 
 */

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowEvent;
import java.awt.Color;

public class LotayFlAmazonFrame extends JFrame {
	
	public ArrayList<String> itemFilters = new ArrayList();
	protected String sort = "";

	private JPanel contentPane;
	private final JTable tblShoppingCart = new JTable();
	private final JScrollPane scrollPane = new JScrollPane();
	private final JMenuBar menuBar = new JMenuBar();
	private final JMenu mnFile = new JMenu("File");
	private final JMenu mnTools = new JMenu("Tools");
	private final JMenu mnHelp = new JMenu("Help");
	private final JMenuItem mntmExit = new JMenuItem("Exit");
	private final JMenuItem mntmAddItem = new JMenuItem("Add Item...");
	private final JMenu mnSetSort = new JMenu("Set Sort");
	private final JMenu mnSetFilter = new JMenu("Set Filter");
	private final JMenuItem mntmByItemName = new JMenuItem("By Item Name");
	private final JMenuItem mntmByPrice = new JMenuItem("By Price");
	private final JMenuItem mntmByCategory = new JMenuItem("By Category");
	private final JLabel lblSort = new JLabel("Sorted by: ItemID");
	private final JMenuItem mntmByPrice_1 = new JMenuItem("By Price...");
	private final JMenuItem mntmByCategory_1 = new JMenuItem("By Category...");
	private final JLabel lblCatFilters = new JLabel("Current Category Filters:");
	private final JButton btnReset = new JButton("Reset");
	private final JMenuItem mntmHelp = new JMenuItem("Help...");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LotayFlAmazonFrame frame = new LotayFlAmazonFrame();
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
	public LotayFlAmazonFrame() {
		jbInit();
	}
	private void jbInit() {
		
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    
		}
		
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent arg0) {
				do_this_windowGainedFocus(arg0);
			}
			public void windowLostFocus(WindowEvent arg0) {
			}
		});
		setTitle("Lotay FlAmazon Shopping Cart");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 766, 518);
		
		setJMenuBar(menuBar);
		menuBar.add(mnFile);
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_mntmExit_actionPerformed(arg0);
			}
		});
		
		mnFile.add(mntmExit);
		menuBar.add(mnTools);
		mntmAddItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mntmAddItem_actionPerformed(e);
			}
		});
		
		mnTools.add(mntmAddItem);
		
		mnTools.add(mnSetSort);
		mntmByItemName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mntmByItemName_actionPerformed(e);
			}
		});
		
		mnSetSort.add(mntmByItemName);
		mntmByPrice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mntmByPrice_actionPerformed(e);
			}
		});
		
		mnSetSort.add(mntmByPrice);
		mntmByCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mntmByCategory_actionPerformed(e);
			}
		});
		
		mnSetSort.add(mntmByCategory);
		
		mnTools.add(mnSetFilter);
		mntmByPrice_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mntmByPrice_1_actionPerformed(e);
			}
		});
		
		mnSetFilter.add(mntmByPrice_1);
		mntmByCategory_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mntmByCategory_1_actionPerformed(e);
			}
		});
		
		mnSetFilter.add(mntmByCategory_1);
		menuBar.add(mnHelp);
		mntmHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_mntmHelp_actionPerformed(e);
			}
		});
		
		mnHelp.add(mntmHelp);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		scrollPane.setToolTipText("<html>\r\n<h3 style=\"font-weight: bold; font-size: 13;\">Your Shopping Cart!</h3>\r\n<p style=\"font-size: 12;\">Shows you the items currently in your shopping cart. Add Items from the Tools menu!</p>\r\n<html>");
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(47, 92, 656, 248);
		
		contentPane.add(scrollPane);
		tblShoppingCart.setFont(new Font("Courier New", Font.PLAIN, 12));
		tblShoppingCart.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"Item ID", "Item Name", "Category", "Quantity", "Price", "Shipping"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, Integer.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tblShoppingCart.getColumnModel().getColumn(1).setPreferredWidth(140);
		tblShoppingCart.getColumnModel().getColumn(1).setMinWidth(140);
		tblShoppingCart.getColumnModel().getColumn(2).setPreferredWidth(130);
		tblShoppingCart.getColumnModel().getColumn(2).setMinWidth(130);
		tblShoppingCart.getColumnModel().getColumn(3).setPreferredWidth(55);
		tblShoppingCart.getColumnModel().getColumn(3).setMinWidth(55);
		tblShoppingCart.getColumnModel().getColumn(4).setPreferredWidth(120);
		tblShoppingCart.getColumnModel().getColumn(4).setMinWidth(120);
		
		TableColumnModel m = tblShoppingCart.getColumnModel();
		m.getColumn(4).setCellRenderer(NumberRenderer.getCurrencyRenderer());
		m.getColumn(5).setCellRenderer(NumberRenderer.getCurrencyRenderer());
		
		scrollPane.setViewportView(tblShoppingCart);
		lblSort.setToolTipText("<html>\r\n<h3 style=\"font-weight: bold; font-size: 13;\">Current Sort Setting</h3>\r\n<p style=\"font-size: 12;\">Shows you the current sort setting, accessible via Tools, Set Sort</p>\r\n<html>");
		lblSort.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSort.setBounds(47, 58, 252, 14);
		
		contentPane.add(lblSort);
		lblCatFilters.setToolTipText("<html>\r\n<h3 style=\"font-weight: bold; font-size: 13;\">Current Category Filters</h3>\r\n<p style=\"font-size: 12;\">Shows you the current category filters, accessible via Tools, Set Filter</p>\r\n<html>");
		lblCatFilters.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCatFilters.setBounds(47, 362, 554, 14);
		
		contentPane.add(lblCatFilters);
		btnReset.setToolTipText("<html>\r\n<h3 style=\"font-weight: bold; font-size: 13;\">Reset Shopping Cart Filters/Sort</h3>\r\n<p style=\"font-size: 12;\">Clear the filters and sorting options</p>\r\n<html>");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnReset_actionPerformed(e);
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnReset.setBounds(614, 373, 89, 28);
		
		contentPane.add(btnReset);
		lblPriceFilters.setToolTipText("<html>\r\n<h3 style=\"font-weight: bold; font-size: 13;\">Current Price Filters</h3>\r\n<p style=\"font-size: 12;\">Shows you the current price filters, accessible via Tools, Set Filter</p>\r\n<html>");
		lblPriceFilters.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPriceFilters.setBounds(47, 387, 554, 14);
		
		contentPane.add(lblPriceFilters);
		lblLotayFlamazonShopping.setForeground(new Color(64, 64, 64));
		lblLotayFlamazonShopping.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblLotayFlamazonShopping.setBounds(238, 22, 273, 25);
		
		contentPane.add(lblLotayFlamazonShopping);
	}
	
	//Exit function, confirm on exit
	protected void do_mntmExit_actionPerformed(ActionEvent arg0) {
		int confirmed = JOptionPane.showConfirmDialog(null, 
		"Are you sure you want to exit the shopping cart?", "Exit Program",
	    JOptionPane.YES_NO_OPTION);

	    if (confirmed == JOptionPane.YES_OPTION) {
	      this.dispose();
	    }
	}
	
	//Open Add Item Frame
	protected void do_mntmAddItem_actionPerformed(ActionEvent e) {
		LotayFlAmazonAddItem additemframe = new LotayFlAmazonAddItem();
		additemframe.setVisible(true);
	}
	
	//Open Filter By Price Frame
	protected LotayFlAmazonFilterByPrice filterPriceFrame = new LotayFlAmazonFilterByPrice();
	protected void do_mntmByPrice_1_actionPerformed(ActionEvent e) {
		filterPriceFrame.setVisible(true);
	}
	
	//Open Filter By Category Frame
	protected LotayFlAmazonFilterByCategory filterCategoryFrame = new LotayFlAmazonFilterByCategory();
	private final JLabel lblPriceFilters = new JLabel("Current Price Filters:");
	private final JLabel lblLotayFlamazonShopping = new JLabel("Lotay FlAmazon Shopping Cart");
	protected void do_mntmByCategory_1_actionPerformed(ActionEvent e) {
		filterCategoryFrame.setVisible(true);
	}
	
	//Open Help frame
	protected void do_mntmHelp_actionPerformed(ActionEvent e) {
		LotayFlAmazonHelp helpFrame = new LotayFlAmazonHelp();
		helpFrame.setVisible(true);
	}
	
	//Display items in table
	protected void displayItems(String filter, String sort){
		ResultSet rs = null;
		Statement stmt = null;
		//default order by clause
		String orderClause = "ORDER BY ";
		
		Connection conn;
		try {
			//establish connection
			conn = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Public/FlAmazon.accdb");
			
			//create statement
			stmt = conn.createStatement();
			
			//if no filters selected, set to empty
			if(filter.isEmpty()){
				filter = "";
			}
			//if filter categories are selected, change order by clause
			else if(!filterCategoryFrame.categories.isEmpty()){
				orderClause = ") ORDER BY ";
			}
			
			//if no sort provided, use ItemID as default
			if(sort.isEmpty()){
				sort = "ItemID";
			}
			
			//build query
			String query = "SELECT ItemID, ItemName, Category, Quantity, Price, Shipping "
						 + "FROM ShoppingCart "
						 + "WHERE (1=1) "
						 + filter
						 + orderClause
						 + sort;
			
			//execute
			rs = stmt.executeQuery(query);
			
			//empty shopping cart
			while(tblShoppingCart.getRowCount() > 0){
				((DefaultTableModel) tblShoppingCart.getModel()).removeRow(0);
			}
			
			int columnNum = rs.getMetaData().getColumnCount();
			
			//repopulate shopping cart with correct data
			while(rs.next()){
				//create object to hold record
				Object[] row = new Object[columnNum];
				
				for(int i = 0; i < columnNum; i++){
					//grab record from resultset and make a row
					row[i] = rs.getObject(i+1); //resultsets 1 based vs 0 based array
				}
				
				((DefaultTableModel) tblShoppingCart.getModel()).insertRow(rs.getRow()-1, row);
				
			}
			
			rs.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("SQL Exception: " + e.getMessage());
			System.out.println("SQL State: " + e.getSQLState());
			System.out.println("Vendor Error: " + e.getErrorCode());
			e.printStackTrace();
		}
	}
	
	//Sort by Item Name
	protected void do_mntmByItemName_actionPerformed(ActionEvent e) {
		sort = " ItemName";
		
		displayItems((filterPriceFrame.priceFilter + filterCategoryFrame.categories), sort);
		lblSort.setText("Sorted by: Item Name");
	}
	
	//Sort by Price
	protected void do_mntmByPrice_actionPerformed(ActionEvent e) {
		sort = " Price";
		
		displayItems((filterPriceFrame.priceFilter + filterCategoryFrame.categories), sort);
		lblSort.setText("Sorted by: Price");
	}
	
	//Sort By Category
	protected void do_mntmByCategory_actionPerformed(ActionEvent e) {
		sort = " Category";
		
		displayItems((filterPriceFrame.priceFilter + filterCategoryFrame.categories), sort);
		lblSort.setText("Sorted by: Category");
	}
	
	//Refresh shopping cart table
	protected void do_this_windowGainedFocus(WindowEvent arg0) {
		displayItems((filterPriceFrame.priceFilter + filterCategoryFrame.categories), sort);
		lblCatFilters.setText(filterCategoryFrame.categoriesLabel);
		lblPriceFilters.setText(filterPriceFrame.priceLabel);
	}
	
	//Reset filters
	protected void do_btnReset_actionPerformed(ActionEvent e) {
		filterPriceFrame.priceFilter = "";
		filterCategoryFrame.categories = "";
		sort = "";
		
		for(int i = 0, l = filterCategoryFrame.checkBoxes.size(); i < l; i++){
			filterCategoryFrame.checkBoxes.get(i).setSelected(false);
		}
		
		filterCategoryFrame.categoriesLabel = "Current Category Filters: none";
		filterPriceFrame.priceLabel = "Current Price Filters: none";
		
		displayItems((filterPriceFrame.priceFilter + filterCategoryFrame.categories), sort);
		lblCatFilters.setText(filterCategoryFrame.categoriesLabel);
		lblPriceFilters.setText(filterPriceFrame.priceLabel);
		lblSort.setText("Sorted by: ItemID");
	}
}
