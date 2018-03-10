/**
 * @author Brice Johnson
 * @version 0.01
 * @category Data
 **/
package neurIO.gui;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.eclipse.wb.swing.FocusTraversalOnArray;

public class mainWin {

	private JFrame frmNeurio;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	private JPanel panel = new JPanel();
	private JPanel panel_3 = new JPanel();
	private JPanel panel_1 = new JPanel();
	private Panel panel_5 = new Panel();
	private Panel panel_2 = new Panel();
	private JButton btnSelect = new JButton("Select...");
	private JButton btnStart = new JButton("Start");
	private JButton btnStop = new JButton("Stop");
	private JButton btnSelect_1 = new JButton("Select...");
	private JButton btnBrowse = new JButton("Browse...");
	private JButton btnSelect_2 = new JButton("Select...");
	private JButton btnClear = new JButton("Clear");
	private JButton btnRandomize = new JButton("Randomize");
	private JComboBox comboBox = new JComboBox();
	private JSlider slider = new JSlider();
	private JTextArea textArea = new JTextArea();
	private JMenu mnHelp = new JMenu("Help");
	private JMenu mnConfig = new JMenu("Config");
	private JMenuItem mntmSave = new JMenuItem("Save...");
	private JMenuItem mntmSaveLog = new JMenuItem("Save Log..");
	private JMenuItem mntmLoad = new JMenuItem("Load...");
	private JMenu mnFile = new JMenu("File");
	private JMenuBar menuBar = new JMenuBar();
	private JCheckBox chckbxNewlineOrCariage = new JCheckBox("Newline, or carriage return");
	private JTextArea txtrConsole =  new JTextArea();
	private Canvas canvas = new Canvas();
	private JLabel lblNewLabel = new JLabel("Simulation");
	private JLabel lblSeed = new JLabel("Seed:");
	private JLabel lblGenerations = new JLabel("Generations:");
	private JLabel lblAlgorithm = new JLabel("Eval Algorithm:");
	private JLabel lblFitnessVTime = new JLabel("Fitness v. Time");
	private JLabel lblPool = new JLabel("Pool Size");
	private JLabel label_2 = new JLabel("4");
	private JLabel lblMutationAlgorithm = new JLabel("Mutation Algorithm:");
	private JLabel lblMutationParameters = new JLabel("Mutation Parameters:");
	private JLabel lblConsole = new JLabel("Console");
	private JLabel lblDelimiter = new JLabel("Delimiter");
	private JLabel lblInputFile = new JLabel("Input File");
	private JLabel lblData = new JLabel("Data");
	private JLabel lblLogFolder = new JLabel("Log Folder");
	private JLabel lblOutput = new JLabel("Output");
	private JLabel lblGeneticsMutation = new JLabel("Genetics & Mutation");
	private JLabel lblGridWidth = new JLabel("Grid Width");
	private JLabel lblGridHeight = new JLabel("Grid Height");
	
	private static int poolSize = 4;
	private static String evalJar = "";
	private static String mutationJar = "";
	private static String mutationParams = "";
	private static String logLevel = "Log";
	
	private static Random r;
	private long seed;
	
	private JTextField textField_4;
	private JTextField textField_Delimiter;
	private JTextField textField_6;
	private JTextField labelSeed;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
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
		frmNeurio.setBounds(100, 100, 892, 600);
		frmNeurio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNeurio.getContentPane().setLayout(null);
		
		panel.setBounds(35, 85, 461, 455);
		frmNeurio.getContentPane().add(panel);
		panel.setLayout(null);
		
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 11, 70, 14);
		panel.add(lblNewLabel);
		
		lblSeed.setBounds(10, 36, 70, 14);
		panel.add(lblSeed);
		
		lblGenerations.setBounds(10, 86, 70, 14);
		panel.add(lblGenerations);
		
		lblAlgorithm.setBounds(10, 61, 75, 14);
		panel.add(lblAlgorithm);
		
		textField = new JTextField();
		textField.setBounds(95, 58, 257, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		btnSelect.setBounds(360, 57, 89, 23);
		panel.add(btnSelect);
		
		btnStart.setBounds(263, 97, 89, 23);
		panel.add(btnStart);
		
		btnStop.setBounds(360, 97, 89, 23);
		panel.add(btnStop);
		
		lblFitnessVTime.setBounds(10, 307, 80, 14);
		panel.add(lblFitnessVTime);
		
		panel_5.setBackground(Color.LIGHT_GRAY);
		panel_5.setBounds(10, 126, 451, 175);
		panel.add(panel_5);
		panel_5.setLayout(null);
		
		lblPool.setBounds(10, 11, 48, 14);
		panel_5.add(lblPool);

		slider.setMaximum(600);
		slider.setBackground(Color.LIGHT_GRAY);
		slider.setValue(4);
		slider.setMinimum(4);
		slider.setBounds(110, 11, 222, 14);
		panel_5.add(slider);
		
		label_2.setBounds(385, 11, 46, 14);
		panel_5.add(label_2);
		
		lblMutationAlgorithm.setBounds(10, 36, 101, 14);
		panel_5.add(lblMutationAlgorithm);
		
		textField_1 = new JTextField();
		textField_1.setBounds(110, 36, 232, 20);
		panel_5.add(textField_1);
		textField_1.setColumns(10);
		
		btnSelect_1.setBackground(Color.LIGHT_GRAY);
		btnSelect_1.setBounds(352, 34, 89, 23);
		panel_5.add(btnSelect_1);
		
		lblMutationParameters.setBounds(10, 65, 114, 14);
		panel_5.add(lblMutationParameters);
		
		textArea.setBounds(10, 86, 174, 78);
		panel_5.add(textArea);
		
		lblGridHeight.setBounds(194, 120, 62, 14);
		panel_5.add(lblGridHeight);
		
		lblGridWidth.setBounds(194, 145, 50, 14);
		panel_5.add(lblGridWidth);
		
		textField_2 = new JTextField();
		textField_2.setBounds(251, 117, 86, 20);
		panel_5.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(251, 144, 86, 20);
		panel_5.add(textField_3);
		textField_3.setColumns(10);
		
		panel_2.setBounds(10, 327, 441, 107);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		canvas.setBackground(Color.WHITE);
		canvas.setBounds(0, 0, 441, 107);
		panel_2.add(canvas);
		
		lblGeneticsMutation.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGeneticsMutation.setBounds(10, 111, 133, 14);
		panel.add(lblGeneticsMutation);
		
		btnRandomize.setBounds(261, 32, 89, 23);
		panel.add(btnRandomize);
		
		labelSeed = new JTextField();
		labelSeed.setBounds(95, 33, 156, 20);
		panel.add(labelSeed);
		labelSeed.setColumns(10);
		panel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{btnStart, btnStop, btnSelect}));
		
		panel_1.setBounds(0, 85, 36, 476);
		frmNeurio.getContentPane().add(panel_1);
		
		panel_3.setBounds(506, 149, 370, 412);
		frmNeurio.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		txtrConsole.setEditable(false);
		txtrConsole.setBounds(10, 39, 350, 328);
		txtrConsole.setText("Console");
		txtrConsole.setTabSize(4);
		txtrConsole.setRows(20);
		panel_3.add(txtrConsole);
		
		lblConsole.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblConsole.setBounds(10, 11, 64, 17);
		panel_3.add(lblConsole);
		
		btnClear.setBounds(271, 10, 89, 23);
		panel_3.add(btnClear);
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Log", "Verbose", "Profiling", "Debug"}));
		comboBox.setBounds(84, 10, 177, 20);
		panel_3.add(comboBox);
		
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblData.setBounds(35, 11, 46, 14);
		frmNeurio.getContentPane().add(lblData);
		
		lblInputFile.setBounds(35, 36, 46, 14);
		frmNeurio.getContentPane().add(lblInputFile);
		
		textField_4 = new JTextField();
		textField_4.setBounds(91, 33, 295, 20);
		frmNeurio.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		btnSelect_2.setBounds(396, 32, 89, 23);
		frmNeurio.getContentPane().add(btnSelect_2);
		
		lblDelimiter.setBounds(35, 61, 46, 14);
		frmNeurio.getContentPane().add(lblDelimiter);
		
		textField_Delimiter = new JTextField();
		textField_Delimiter.setBounds(91, 58, 86, 20);
		frmNeurio.getContentPane().add(textField_Delimiter);
		textField_Delimiter.setColumns(10);
		
		chckbxNewlineOrCariage.setBounds(183, 55, 160, 23);
		frmNeurio.getContentPane().add(chckbxNewlineOrCariage);
		
		lblOutput.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblOutput.setBounds(506, 13, 46, 14);
		frmNeurio.getContentPane().add(lblOutput);
		
		textField_6 = new JTextField();
		textField_6.setBounds(576, 33, 194, 20);
		frmNeurio.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		lblLogFolder.setBounds(506, 36, 60, 14);
		frmNeurio.getContentPane().add(lblLogFolder);
		
		btnBrowse.setBounds(780, 32, 89, 23);
		frmNeurio.getContentPane().add(btnBrowse);
		
		frmNeurio.setJMenuBar(menuBar);
		
		menuBar.add(mnFile);
		
		mnFile.add(mntmSaveLog);
		
		menuBar.add(mnConfig);
		
		mnConfig.add(mntmLoad);
		
		mnConfig.add(mntmSave);
		
		menuBar.add(mnHelp);

		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtrConsole.setText("");
			}
		});

		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logLevel = (String)comboBox.getSelectedItem();
				System.out.println(logLevel);
			}
		});
		
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				label_2.setText( String.valueOf((int)(Math.pow( 1.2, ((float)slider.getValue())/13 ))+3) );
			}
		});

		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});

		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		btnSelect_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileDialog selection = new FileDialog(frmNeurio);
				selection.setVisible(true);
				String file = selection.getDirectory()+selection.getFile();
				textField_1.setText(file);
			}
		});

		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileDialog selection = new FileDialog(frmNeurio);
				selection.setVisible(true);
				String file = selection.getDirectory()+selection.getFile();
				textField.setText(file);
			}
		});

		btnSelect_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});

		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnRandomize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seed = (long)r.nextInt()*r.nextInt();
				labelSeed.setText(String.valueOf(seed));
				r.setSeed(seed);				
			}
		});
		
		chckbxNewlineOrCariage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewlineOrCariage.isSelected()) {
				textField_Delimiter.setEditable(false);
				}else {
					textField_Delimiter.setEditable(true);					
				}
					
			}
		});
		
		r = new Random();
		seed = (long)r.nextInt()*r.nextInt();
		labelSeed.setText(String.valueOf(seed));
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(95, 86, 156, 14);
		panel.add(label_1);
		r.setSeed(seed);
		
	}
}
