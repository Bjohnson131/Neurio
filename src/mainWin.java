/**
 * 
 * @author Brice Johnson
 * @category GUI
 * @version 0.01
 * */

import java.awt.EventQueue;

import javax.swing.JFrame;
/**
 * MainWin
 * ====
 * The soon to-be main window of Neurio.
 * 
 * This window will be used for mock-configuration of neur-io based applications, as well as generating configuration files.
 * */
public class mainWin {

	private JFrame frame;

	/**
	 * Launch the application with the main window.
	 * 
	 * TO BE DEPRECIATED SOON.
	 * 
	 * use The start class with parameters instead.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainWin window = new mainWin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Initializes the window
	 */
	public mainWin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
