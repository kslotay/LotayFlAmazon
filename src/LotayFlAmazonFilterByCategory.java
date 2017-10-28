import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class LotayFlAmazonFilterByCategory extends JFrame {

	public ArrayList<JCheckBox> checkBoxes = new ArrayList<JCheckBox>();
	public String categories = "";
	public String categoriesLabel = "Current Category Filters: none";
	
	private JPanel contentPane;
	private final JLabel lblFilterByThe = new JLabel("Filter by the following categories:");
	private final JCheckBox chckbxAutomotive = new JCheckBox("Automotive");
	private final JCheckBox chckbxBooks = new JCheckBox("Books");
	private final JCheckBox chckbxComputers = new JCheckBox("Computers");
	private final JCheckBox chckbxClothing = new JCheckBox("Clothing");
	private final JCheckBox chckbxElectronics = new JCheckBox("Electronics");
	private final JCheckBox chckbxHomeGarden = new JCheckBox("Home & Garden");
	private final JCheckBox chckbxMusic = new JCheckBox("Music");
	private final JCheckBox chckbxSports = new JCheckBox("Sports");
	private final JCheckBox chckbxMovies = new JCheckBox("Movies");
	private final JButton btnApply = new JButton("Set Filter");
	private final JSeparator separator = new JSeparator();
	private final JButton btnClose = new JButton("Close");
	private final JCheckBox chckbxOther = new JCheckBox("Other");

	/**
	 * Create the frame.
	 */
	public LotayFlAmazonFilterByCategory() {
		jbInit();
	}
	private void jbInit() {
		setTitle("Filter By Category");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 359, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblFilterByThe.setToolTipText("<html>\r\n<h3 style=\"font-weight: bold; font-size: 13;\">Item Categories</h3>\r\n<p style=\"font-size: 12;\">Please select one or more item categories from below</p>\r\n<html>");
		lblFilterByThe.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFilterByThe.setBounds(47, 21, 245, 14);
		
		contentPane.add(lblFilterByThe);
		chckbxAutomotive.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxAutomotive.setBounds(49, 52, 97, 23);
		checkBoxes.add(chckbxAutomotive);
		contentPane.add(chckbxAutomotive);
		
		chckbxBooks.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxBooks.setBounds(195, 52, 97, 23);
		checkBoxes.add(chckbxBooks);
		contentPane.add(chckbxBooks);
		
		chckbxClothing.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxClothing.setBounds(49, 94, 97, 23);
		checkBoxes.add(chckbxClothing);
		contentPane.add(chckbxClothing);
		
		chckbxComputers.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxComputers.setBounds(195, 94, 97, 23);
		checkBoxes.add(chckbxComputers);
		
		contentPane.add(chckbxComputers);
		chckbxElectronics.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxElectronics.setBounds(49, 136, 97, 23);
		checkBoxes.add(chckbxElectronics);
		
		contentPane.add(chckbxElectronics);
		chckbxHomeGarden.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxHomeGarden.setBounds(195, 136, 127, 23);
		checkBoxes.add(chckbxHomeGarden);
		
		contentPane.add(chckbxHomeGarden);
		chckbxMovies.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxMovies.setBounds(49, 178, 97, 23);
		checkBoxes.add(chckbxMovies);
		
		contentPane.add(chckbxMovies);
		chckbxMusic.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxMusic.setBounds(195, 178, 97, 23);
		checkBoxes.add(chckbxMusic);
		
		contentPane.add(chckbxMusic);
		
		chckbxOther.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxOther.setBounds(195, 220, 97, 23);
		checkBoxes.add(chckbxOther);
		
		contentPane.add(chckbxOther);
		chckbxSports.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxSports.setBounds(49, 220, 97, 23);
		checkBoxes.add(chckbxSports);
		
		contentPane.add(chckbxSports);
		btnApply.setToolTipText("<html>\r\n<h3 style=\"font-weight: bold; font-size: 13;\">Apply Filter</h3>\r\n<p style=\"font-size: 12;\">Apply the above settings to filter your shopping cart</p>\r\n<html>");
		btnApply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnApply_actionPerformed(e);
			}
		});
		btnApply.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnApply.setBounds(55, 311, 89, 28);
		
		contentPane.add(btnApply);
		separator.setBounds(41, 273, 261, 10);
		
		contentPane.add(separator);
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnClose_actionPerformed(e);
			}
		});
		btnClose.setBounds(199, 311, 89, 28);
		
		contentPane.add(btnClose);
	}
	protected void do_btnApply_actionPerformed(ActionEvent e) {
		
		filterItems(checkBoxes);
		
		this.setVisible(false);
	}
	
	//Combine provided category filters and return full filter SQL
	protected void filterItems(ArrayList<JCheckBox> chkfilters){
		int count = 0;
		categories = "AND ((1=2) ";
		categoriesLabel = "Current Category Filters: ";
		
		for(int i = 0, l = chkfilters.size(); i < l; i++){
			if(chkfilters.get(i).isSelected()){
				categories += "OR category = '" + chkfilters.get(i).getText() + "' ";
				
				categoriesLabel += chkfilters.get(i).getText() + " ";
				count ++;
			}
		}
		
		if(count == 0){
			categories = "";
			categoriesLabel = "Current Category Filters: none";
		}
	}
	protected void do_btnClose_actionPerformed(ActionEvent e) {
		this.setVisible(false);
	}
}
