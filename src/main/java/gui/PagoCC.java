package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import cine.controller.Controller;
import clasesPelicula.Pelicula;
/**
 * 
 * @author alex
 *
 */

public class PagoCC extends JFrame{

	private JFrame frame3;
	private JTextField textTarjeta;
	private JTextField textCCV;
	private int limiteTarjeta =16;
	private int limiteCCV=3;
	private JTextField textNombre;
	static int entraInicial=0;
	public int cantidad;
	public int preciot;
	private Controller controller;
	private Pelicula peli;
	/**
	 * Launch the application.
	 */

	public PagoCC(Controller controller, Pelicula p) {
		this.controller = controller;
		initialize();
		this.peli = p;
		this.setVisible(true);
		
	}

	/**
	 * Create the application.
	 * @param cantidad2 
	 * @param persona 
	 */
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame3 = new JFrame();
		getContentPane().setBackground(Color.GRAY);
		setBounds(600, 300, 491, 356);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);


		JLabel lblNumeroTarjeta = new JLabel("Número tarjeta");
		lblNumeroTarjeta.setForeground(Color.ORANGE);
		lblNumeroTarjeta.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 15));
		lblNumeroTarjeta.setBounds(55, 124, 157, 20);
		getContentPane().add(lblNumeroTarjeta);


		JLabel lblCcv = new JLabel("CCV");
		lblCcv.setForeground(Color.ORANGE);
		lblCcv.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 15));
		lblCcv.setBounds(55, 184, 69, 20);
		getContentPane().add(lblCcv);


		JLabel lblDniCliente = new JLabel("Nombre");
		lblDniCliente.setForeground(Color.ORANGE);
		lblDniCliente.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 15));
		lblDniCliente.setBounds(55, 92, 126, 20);
		getContentPane().add(lblDniCliente);


		JLabel lblIntroduceLosDatos = new JLabel("PAGO TARJETA DE CRÉDITO");
		lblIntroduceLosDatos.setForeground(Color.ORANGE);
		lblIntroduceLosDatos.setBackground(Color.GRAY);
		lblIntroduceLosDatos.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 28));
		lblIntroduceLosDatos.setHorizontalAlignment(SwingConstants.CENTER);
		lblIntroduceLosDatos.setBounds(-23, 23, 534, 49);
		getContentPane().add(lblIntroduceLosDatos);

		textTarjeta= new JTextField();
		textTarjeta.setBounds(263, 122, 152, 26);
		getContentPane().add(textTarjeta);
		textTarjeta.setColumns(10);
		textTarjeta.addKeyListener(new KeyListener(){

			public void keyTyped(KeyEvent e){
				char c= e.getKeyChar();
				if (textTarjeta.getText().length()== limiteTarjeta | !Character.isDigit(c))

					e.consume();

			}

			public void keyPressed(KeyEvent arg0) {
			}

			public void keyReleased(KeyEvent arg0) {
			}
		});

		textCCV = new JTextField();
		textCCV.setBounds(263, 182, 62, 26);
		getContentPane().add(textCCV);
		textCCV.setColumns(10);
		textCCV.addKeyListener(new KeyListener(){


			public void keyTyped(KeyEvent e)

			{
				char c=e.getKeyChar();
				if (textCCV.getText().length()== limiteCCV| !Character.isDigit(c)) {

					e.consume();}
			}

			public void keyPressed(KeyEvent arg0) {
			}

			public void keyReleased(KeyEvent arg0) {
			}
		});

		//Al clickar genera la entrada en un pdf (Contenido del fichero no terminado)
		JButton btnPagar = new JButton("Aceptar");
		btnPagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				controller.anyadirEntrada((int)Math.random(), peli, null, preciot, cantidad, preciot, getName());
				
			}
		});
		btnPagar.setBackground(UIManager.getColor("Button.select"));
		btnPagar.setForeground(Color.ORANGE);
		btnPagar.setOpaque(true);
		btnPagar.setBorderPainted(false);
		btnPagar.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 15));
		btnPagar.setBounds(80, 247, 138, 29);
		getContentPane().add(btnPagar);



		JButton btnCancel = new JButton("Cancelar");
		btnCancel.setBackground(Color.ORANGE);
		btnCancel.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 15));
		btnCancel.setForeground(Color.GRAY);
		btnCancel.setOpaque(true);
		btnCancel.setBorderPainted(false);
		btnCancel.setActionCommand("Open20");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new JButton("Vuelta al login");
				String cmd20 = e.getActionCommand();

				if(cmd20.equals("Open20"))
				{
					dispose();

				}
			}});

		btnCancel.setBounds(263, 247, 152, 29);
		getContentPane().add(btnCancel);



		JComboBox MescomboBox = new JComboBox();
		MescomboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		MescomboBox.setMaximumRowCount(12);
		MescomboBox.setBounds(263, 153, 72, 27);
		getContentPane().add(MescomboBox);

		JComboBox AnyocomboBox_1 = new JComboBox();
		AnyocomboBox_1.setBackground(Color.GRAY);
		AnyocomboBox_1.setMaximumRowCount(40);
		AnyocomboBox_1.setModel(new DefaultComboBoxModel(new String[] {"20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40"}));
		AnyocomboBox_1.setBounds(351, 153, 72, 27);
		getContentPane().add(AnyocomboBox_1);

		JLabel lblFecha = new JLabel("Fecha cad.");
		lblFecha.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 15));
		lblFecha.setForeground(Color.ORANGE);
		lblFecha.setBounds(55, 156, 126, 16);
		getContentPane().add(lblFecha);

		textNombre = new JTextField();
		textNombre.setBounds(263, 90, 152, 22);
		getContentPane().add(textNombre);
		textNombre.setColumns(10);

		JLabel lblB = new JLabel("/");
		lblB.setForeground(Color.ORANGE);
		lblB.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 15));
		lblB.setBounds(338, 156, 18, 16);
		getContentPane().add(lblB);

	}


	

	
}
