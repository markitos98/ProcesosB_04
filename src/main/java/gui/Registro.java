package gui;
import java.awt.Color;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.PrintStream;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import database.*;


/**
 * Ventana de registro para clientes
 * @author gorkazarate
 *
 */
public class Registro {

	public JFrame frame1;
	public JTextField txtUser;
	public JTextField txtEmail;
	public JTextField txtApe1;
	public JTextField txtApe2;
	public JTextField txtNombre;
	public JTextField txtFecha;
	public JPasswordField passContr;
	static PrintStream log;
	public HashMap<String, String> clientes = new HashMap<String, String>();
	public static final String EMAIL_PATTER = 
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
					+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";


	/**
	 * Create the application.
	 */
	public Registro() {
		super();
		initialize();
		frame1.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame1 = new JFrame();
		frame1.getContentPane().setBackground(Color.GRAY);
		frame1.setBackground(Color.GRAY);
		frame1.setBounds(600, 250, 450, 500);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.getContentPane().setLayout(null);

		JLabel lblUser = new JLabel("Username\r\n");
		lblUser.setForeground(Color.ORANGE);
		lblUser.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 15));
		lblUser.setBounds(46, 87, 115, 20);
		frame1.getContentPane().add(lblUser);

		JLabel lblApe1 = new JLabel("1er Apellido");
		lblApe1.setForeground(Color.ORANGE);
		lblApe1.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 15));
		lblApe1.setBounds(46, 191, 115, 20);
		frame1.getContentPane().add(lblApe1);

		JLabel lblApe2 = new JLabel("2ndo Apellido");
		lblApe2.setForeground(Color.ORANGE);
		lblApe2.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 15));
		lblApe2.setBounds(46, 227, 135, 20);
		frame1.getContentPane().add(lblApe2);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(Color.ORANGE);
		lblEmail.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 15));
		lblEmail.setBounds(46, 123, 69, 20);
		frame1.getContentPane().add(lblEmail);



		JButton btnCancelar = new JButton("Cancelar\r\n");
		btnCancelar.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 15));
		btnCancelar.setBackground(Color.ORANGE);
		btnCancelar.setForeground(Color.GRAY);
		btnCancelar.setOpaque(true);
		btnCancelar.setBorderPainted(false);

		btnCancelar.setActionCommand("Open70");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();

				if(cmd.equals("Open70"))
				{
					frame1.dispose();
					//Abre Inicio de Sesion
					

				}
			}
		});

		btnCancelar.setBounds(254, 362, 155, 29);
		frame1.getContentPane().add(btnCancelar);





		txtUser = new JTextField();
		txtUser.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		txtUser.setBounds(250, 85, 146, 26);
		frame1.getContentPane().add(txtUser);
		txtUser.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		txtEmail.setBounds(250, 121, 146, 26);
		frame1.getContentPane().add(txtEmail);
		txtEmail.setColumns(10);

		txtApe1 = new JTextField();
		txtApe1.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		txtApe1.setBounds(250, 189, 146, 26);
		frame1.getContentPane().add(txtApe1);
		txtApe1.setColumns(10);
		txtApe1.addKeyListener(new KeyListener(){

			public void keyTyped(KeyEvent e){
				char c= e.getKeyChar();
				if (!Character.isAlphabetic(c))

					e.consume();

			}

			public void keyPressed(KeyEvent arg0) {
			}

			public void keyReleased(KeyEvent arg0) {
			}
		});


		txtApe2 = new JTextField();
		txtApe2.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		txtApe2.setBounds(250, 225, 146, 26);
		frame1.getContentPane().add(txtApe2);
		txtApe2.setColumns(10);
		txtApe2.addKeyListener(new KeyListener(){

			public void keyTyped(KeyEvent e){
				char c= e.getKeyChar();
				if (!Character.isAlphabetic(c))

					e.consume();

			}

			public void keyPressed(KeyEvent arg0) {
			}

			public void keyReleased(KeyEvent arg0) {
			}
		});


		JLabel lblIntroduceTusDatos = new JLabel("Crea una cuenta nueva");
		lblIntroduceTusDatos.setForeground(Color.ORANGE);
		lblIntroduceTusDatos.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 28));
		lblIntroduceTusDatos.setBounds(46, 17, 398, 52);
		frame1.getContentPane().add(lblIntroduceTusDatos);

		JButton btnVueltaAlLogin = new JButton("Volver a Inicio de Sesión");
		btnVueltaAlLogin.setBackground(Color.GRAY);
		btnVueltaAlLogin.setForeground(Color.ORANGE);
		btnVueltaAlLogin.setOpaque(true);
		btnVueltaAlLogin.setBorderPainted(false);
		btnVueltaAlLogin.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 15));
		btnVueltaAlLogin.setActionCommand("Open1");
		btnVueltaAlLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd1 = e.getActionCommand();

				if(cmd1.equals("Open1"))
				{
					frame1.dispose();
					new InicioSesion();
				}
			}
		});
		btnVueltaAlLogin.setBounds(112, 415, 229, 31);
		frame1.getContentPane().add(btnVueltaAlLogin);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(Color.ORANGE);
		lblNombre.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 15));
		lblNombre.setBounds(46, 155, 87, 20);
		frame1.getContentPane().add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		txtNombre.setBounds(250, 151, 146, 26);
		frame1.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		txtNombre.addKeyListener(new KeyListener(){

			public void keyTyped(KeyEvent e){
				char c= e.getKeyChar();
				if (!Character.isAlphabetic(c))

					e.consume();

			}

			public void keyPressed(KeyEvent arg0) {
			}

			public void keyReleased(KeyEvent arg0) {
			}
		});

		JLabel lblFechaNacimiento = new JLabel("Fecha nacimiento");
		lblFechaNacimiento.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 15));
		lblFechaNacimiento.setForeground(Color.ORANGE);
		lblFechaNacimiento.setBounds(46, 262, 155, 20);
		frame1.getContentPane().add(lblFechaNacimiento);

		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 15));
		lblContrasea.setForeground(Color.ORANGE);
		lblContrasea.setBounds(46, 294, 103, 20);
		frame1.getContentPane().add(lblContrasea);

		txtFecha = new JTextField();
		txtFecha.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		txtFecha.setBounds(250, 262, 146, 26);
		frame1.getContentPane().add(txtFecha);
		txtFecha.setColumns(10);

		passContr = new JPasswordField();
		passContr.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 13));
		passContr.setBounds(250, 292, 146, 26);
		frame1.getContentPane().add(passContr);
		
		JButton btnRegis = new JButton("Registrarse\r\n");
		btnRegis.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 15));
		btnRegis.setBackground(Color.ORANGE);
		btnRegis.setForeground(Color.GRAY);
		btnRegis.setOpaque(true);
		btnRegis.setBorderPainted(false);

		
		btnRegis.setBounds(46, 362, 155, 29);
		frame1.getContentPane().add(btnRegis);
		btnRegis.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
			
			Database db = new Database();
			
			
			if(db.comprobarEmail(txtEmail.getText())) {
				
				String passText = new String(passContr.getPassword());
		          db.anyadirUsuario(txtUser.getText(),passText,txtEmail.getText(), txtNombre.getText(), txtApe1.getText(), txtApe2.getText(), txtFecha.getText());
		      
		          JOptionPane.showMessageDialog(frame1, "Usuario registrado");
		          frame1.dispose();
		          
		          
			}else {
				
				JOptionPane.showMessageDialog(frame1, "Ya hay un usuario registrado con este correo");
			}
			
				
}
		});
		
		
		
	
		
			}
	public static void abrirRegistro() {
		Registro registro = new Registro();
	}
}
