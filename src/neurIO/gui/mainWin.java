/**
 * @author Brice Johnson
 * @version 0.01
 * @category Data
 **/
package neurIO.gui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JPanel;

public class mainWin {

	private JFrame frmNeurio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainWin window = new mainWin();
					window.frmNeurio.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public mainWin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNeurio = new JFrame();
		frmNeurio.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Brice\\Pictures\\neurio.png"));
		frmNeurio.setTitle("NeurIO");
		frmNeurio.setBounds(100, 100, 800, 600);
		frmNeurio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNeurio.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(100, 117, 461, 444);
		frmNeurio.getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 117, 100, 444);
		frmNeurio.getContentPane().add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(560, 117, 100, 444);
		frmNeurio.getContentPane().add(panel_2);
	}
}
