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
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.JPasswordField;


/**
 * 
 * @author alex
 *
 */
public class PagoPaypal {

	private JFrame frame3;
	private JTextField textCorreo;
	static int entraInicial=0;
	public int cantidad;
	public int preciot;
	public static final String EMAIL_PATTER = 
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
					+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";


	private JPasswordField passwordField;
	private JTextField textField;
	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					PagoPaypal window = new PagoPaypal();
					window.frame3.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	/**
	 * Create the application.
	 */
	public PagoPaypal() {
		super();
		initialize();
		frame3.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame3 = new JFrame();
		frame3.getContentPane().setBackground(Color.GRAY);
		frame3.setBounds(600, 300, 491, 356);
		frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame3.getContentPane().setLayout(null);


		JLabel lblNumeroTarjeta = new JLabel("Correo Electrónico");
		lblNumeroTarjeta.setForeground(Color.ORANGE);
		lblNumeroTarjeta.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 15));
		lblNumeroTarjeta.setBounds(55, 124, 157, 20);
		frame3.getContentPane().add(lblNumeroTarjeta);


		JLabel lblIntroduceLosDatos = new JLabel("PAGO PAYPAL");
		lblIntroduceLosDatos.setForeground(Color.ORANGE);
		lblIntroduceLosDatos.setBackground(Color.GRAY);
		lblIntroduceLosDatos.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 28));
		lblIntroduceLosDatos.setHorizontalAlignment(SwingConstants.CENTER);
		lblIntroduceLosDatos.setBounds(-23, 23, 534, 49);
		frame3.getContentPane().add(lblIntroduceLosDatos);

		textCorreo= new JTextField();
		textCorreo.setBounds(263, 122, 152, 26);
		frame3.getContentPane().add(textCorreo);
		textCorreo.setColumns(10);


		JButton btnPagar = new JButton("Aceptar");
		btnPagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (!textCorreo.getText().matches(EMAIL_PATTER)) {
					JOptionPane.showMessageDialog(null, "Email no valido", "ERROR", JOptionPane.ERROR_MESSAGE);
				}	}});
		btnPagar.setBackground(UIManager.getColor("Button.select"));
		btnPagar.setForeground(Color.ORANGE);
		btnPagar.setOpaque(true);
		btnPagar.setBorderPainted(false);
		btnPagar.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 15));
		btnPagar.setBounds(80, 247, 138, 29);
		frame3.getContentPane().add(btnPagar);




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
					frame3.dispose();

				}
			}});

		btnCancel.setBounds(263, 247, 152, 29);
		frame3.getContentPane().add(btnCancel);

		JLabel lblFecha = new JLabel("Contraseña");
		lblFecha.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 15));
		lblFecha.setForeground(Color.ORANGE);
		lblFecha.setBounds(55, 156, 126, 16);
		frame3.getContentPane().add(lblFecha);

		passwordField = new JPasswordField();
		passwordField.setBounds(263, 152, 152, 26);
		frame3.getContentPane().add(passwordField);
		
		textField = new JTextField();
		textField.setBounds(263, 90, 152, 26);
		frame3.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 15));
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setBounds(55, 92, 70, 20);
		frame3.getContentPane().add(lblNewLabel);


	}	
}
