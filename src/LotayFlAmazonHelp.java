import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class LotayFlAmazonHelp extends JFrame {

	private JPanel contentPane;
	private final JLabel lblWelcomeToLotay = new JLabel("Welcome to Lotay's FlAmazon Shopping Cart!");
	private final JButton btnClose = new JButton("Close");
	private final JLabel lblTheLotayFlamazon = new JLabel("<html>The Lotay FlAmazon Shopping Cart provides you with powerful tools to enable you to quickly sort through and filter your shopping cart.\r\nOn the homepage, you will see a table showing your selected shopping items, as well as sorting information above it and filter information below.\r\nPlease use the menu items to navigate the application. Hover over any control to learn more!\r\n<br>\r\n<br>\r\nYou may add items to your shopping cart from <b>Tools, Add Item...</b>\r\n<br>\r\nYou may sort your shopping cart from <b>Tools, Set Sort</b>\r\n<br>\r\nYou may filter your shopping cart from <b>Tools, Set Filter</b>\r\n<br><br>\r\nYou may contact me at kulvinder.lotay1@marist.edu for any queries/questions</html>");

	/**
	 * Create the frame.
	 */
	public LotayFlAmazonHelp() {
		jbInit();
	}
	private void jbInit() {
		setTitle("Lotay FlAmazon Shopping Cart Help!");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 706, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblWelcomeToLotay.setForeground(new Color(0, 0, 139));
		lblWelcomeToLotay.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblWelcomeToLotay.setBounds(146, 38, 397, 25);
		
		contentPane.add(lblWelcomeToLotay);
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnClose_actionPerformed(e);
			}
		});
		btnClose.setBounds(300, 323, 89, 25);
		
		contentPane.add(btnClose);
		lblTheLotayFlamazon.setVerticalAlignment(SwingConstants.TOP);
		lblTheLotayFlamazon.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTheLotayFlamazon.setBounds(95, 93, 499, 203);
		
		contentPane.add(lblTheLotayFlamazon);
	}

	protected void do_btnClose_actionPerformed(ActionEvent e) {
		this.dispose();
	}
}
