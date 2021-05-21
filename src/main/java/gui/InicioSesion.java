package gui;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import database.Database;

import cine.controller.Controller;
import clases.Sesion;


/**
 * Ventana de Inicio de Sesion para Clientes
 * @author alex
 *
 */
public class InicioSesion extends JFrame {

	public JFrame frame;
	public JTextField textField;
	public JPasswordField passwordField;
	public static Logger log;
	private Controller controller;

	/**
	 * Launch the application.
	 */
	
	
	
	public InicioSesion(Controller controller) {
		this.controller = controller;
		initialize();
		this.setVisible(true);
	}
	
	
	public void ventana(){

		//Creacion del Logger
		try {
			log = Logger.getLogger("logger");
			Handler h = new FileHandler("Datosprograma.xml");
			log.addHandler(h);
			//log.setUseParentHandlers(false);
			log.setLevel(Level.FINEST);
			h.setLevel(Level.FINEST);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
			log.log(Level.INFO, "Inicio del programa " + new Date());
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					try {
						InicioSesion window = new InicioSesion(controller);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}catch(Exception e) {
			log.log(Level.SEVERE, "Error en el inicio de la aplicacion",e);
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error grave", "ERROR",JOptionPane.ERROR_MESSAGE);
		}

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
	
		getContentPane().setBackground(Color.GRAY);
		setResizable(false);
		setForeground(Color.DARK_GRAY);
		getContentPane().setForeground(Color.DARK_GRAY);
		setBounds(600, 300, 491, 356);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Usuario\r\n");
		lblNewLabel.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 15));
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setBounds(85, 105, 91, 20);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Contraseña");
		lblNewLabel_1.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 15));
		lblNewLabel_1.setForeground(Color.ORANGE);
		lblNewLabel_1.setBounds(85, 137, 128, 20);
		getContentPane().add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBounds(254, 104, 146, 26);
		getContentPane().add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(254, 135, 146, 26);
		getContentPane().add(passwordField);

		JButton btnNewButton = new JButton("Cancelar\r\n");
		btnNewButton.setOpaque(true);
		btnNewButton.setBorderPainted(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				InicioSesion.this.dispose();
			}
		});
		btnNewButton.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 15));
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.setForeground(Color.GRAY);
		btnNewButton.setBounds(254, 194, 142, 29);
		getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Aceptar\r\n");
		btnNewButton_1.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 15));
		btnNewButton_1.setOpaque(true);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				String passText = new String(passwordField.getPassword());
				
				
				try {
					if(controller.comprobarUsurio(textField.getText(), passText)) {
						
						MenuPrincipal menuprincipal = new MenuPrincipal(controller);
						menuprincipal.setVisible(true);
						InicioSesion.this.dispose();

					
					
					}else {
						
						JOptionPane.showMessageDialog(frame, "El usuario y la contraseña no coinciden");
					}
				} catch (HeadlessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				
			


			}
		});
		btnNewButton_1.setForeground(Color.GRAY);
		btnNewButton_1.setBackground(Color.ORANGE);
		btnNewButton_1.setBounds(85, 194, 141, 29);
		getContentPane().add(btnNewButton_1);

		JLabel lblIntroduceTusDatos = new JLabel("CINE DEUSTO-PSC");
		lblIntroduceTusDatos.setForeground(Color.ORANGE);
		lblIntroduceTusDatos.setHorizontalAlignment(SwingConstants.CENTER);
		lblIntroduceTusDatos.setBackground(Color.WHITE);
		lblIntroduceTusDatos.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 28));
		lblIntroduceTusDatos.setBounds(43, 24, 398, 50);
		getContentPane().add(lblIntroduceTusDatos);

		JLabel lblNewLabel_2 = new JLabel("¿No tienes cuenta?");
		lblNewLabel_2.setForeground(Color.ORANGE);
		lblNewLabel_2.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(85, 244, 168, 16);
		getContentPane().add(lblNewLabel_2);

		JButton btnNewButton_2 = new JButton("Registrarse");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Registro registro= new Registro(controller);
				registro.setVisible(true);
			}
		});
		btnNewButton_2.setBackground(Color.ORANGE);
		btnNewButton_2.setOpaque(true);
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setActionCommand("Open"); 





		btnNewButton_2.setForeground(Color.GRAY);
		btnNewButton_2.setBackground(Color.ORANGE);
		btnNewButton_2.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 15));
		btnNewButton_2.setBounds(254, 242, 138, 29);
		getContentPane().add(btnNewButton_2);
	}
		

	public void ejecutarVentana() {
		try {
			final InicioSesion Ventana = new InicioSesion(controller);
			SwingUtilities.invokeAndWait(new Runnable() {
				public void run() {
					Ventana.setVisible(true);
				}
			});
		} catch (Exception e) {
			System.exit(1);  
		}
}


}