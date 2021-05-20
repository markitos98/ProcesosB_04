package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import cine.controller.Controller;


/**
 * Ventana de Inicio de sesión para Admins
 * @author alex
 *
 */
public class InicioSesionAdmin {

	private JFrame frame;
	private JTextField txtUser;
	private JPasswordField passContr;
	private Controller controller;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InicioSesionAdmin window = new InicioSesionAdmin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InicioSesionAdmin() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setBounds(600, 300, 491, 356);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblUsu = new JLabel("Usuario");
		lblUsu.setForeground(Color.ORANGE);
		lblUsu.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 15));
		lblUsu.setBounds(67, 123, 132, 20);
		frame.getContentPane().add(lblUsu);

		JLabel lblContr = new JLabel("Constraseña");
		lblContr.setForeground(Color.ORANGE);
		lblContr.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 15));
		lblContr.setBounds(67, 175, 132, 20);
		frame.getContentPane().add(lblContr);

		txtUser = new JTextField();
		txtUser.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 20));
		txtUser.setBounds(235, 117, 163, 29);
		frame.getContentPane().add(txtUser);
		txtUser.setColumns(10);

		JLabel lblCine = new JLabel("CINE DEUSTO PSC-ADMIN");
		lblCine.setForeground(Color.ORANGE);
		lblCine.setBackground(Color.GRAY);
		lblCine.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 28));
		lblCine.setBounds(46, 28, 487, 51);
		frame.getContentPane().add(lblCine);

		JButton btnVol = new JButton("Volver");
		btnVol.setBackground(Color.ORANGE);
		btnVol.setForeground(Color.GRAY);
		btnVol.setOpaque(true);
		btnVol.setBorderPainted(false);
		btnVol.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 15));
		btnVol.setActionCommand("Open90");
		btnVol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();
				if(cmd.equals("Open90"))
				{
					frame.dispose();
					new InicioSesion(controller);

				}
			}
		});
		btnVol.setForeground(Color.GRAY);
		btnVol.setBounds(283, 241, 115, 29);
		frame.getContentPane().add(btnVol);

		JButton btnAcep = new JButton("Aceptar");
		btnAcep.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 15));
		btnAcep.setForeground(Color.GRAY);
		btnAcep.setBackground(Color.ORANGE);
		btnAcep.setOpaque(true);
		btnAcep.setBorderPainted(false);
		
		btnAcep.setBounds(97, 241, 115, 29);
		frame.getContentPane().add(btnAcep);

		passContr = new JPasswordField();
		passContr.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 20));
		passContr.setBounds(235, 169, 163, 29);
		frame.getContentPane().add(passContr);}

	
	//Método para abrir ventana
	public static void abrirInicioSesionAdmin() {
		InicioSesionAdmin login= new InicioSesionAdmin();

	}


}

