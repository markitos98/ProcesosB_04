package gui;

import java.awt.Color;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import javax.swing.border.MatteBorder;

import cine.controller.Controller;
import clasesPelicula.Pelicula;
import clasesUsuario.Usuario;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.logging.Logger;


/**
 * Ventana de pago que genera un pdf al realizar una compra y añade una entrada a la base de datos
 * @author alex
 *
 */
public class Pago extends JFrame {

	private JFrame frame3;
	static int entraInicial=0;
	public int cantidad;
	public String persona;
	public Controller controller;
	private Image foto;
	private Image foto2;
	private Pelicula peli;
	private double precioT;
	private String horario;
	public int preciot;
	public static final String EMAIL_PATTER = 
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
					+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 * @wbp.parser.constructor
	 */
	public Pago(Controller controller, Pelicula p, double precioT,String horario) {
		this.controller = controller;
		this.peli = p;
		this.precioT = precioT;
		this.horario = horario;
		initialize();
		this.setVisible(true);
	}
	public Pago(String persona, int cantidad) {
		this.persona=persona;
		this.cantidad=cantidad;
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		System.out.println(controller.getCl().getService());
		
		
		frame3 = new JFrame();
		getContentPane().setBackground(Color.GRAY);
		setBounds(600, 300, 491, 356);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);


		JLabel lblIntroduceLosDatos = new JLabel("PAGO");
		lblIntroduceLosDatos.setForeground(Color.ORANGE);
		lblIntroduceLosDatos.setBackground(Color.GRAY);
		lblIntroduceLosDatos.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 28));
		lblIntroduceLosDatos.setHorizontalAlignment(SwingConstants.CENTER);
		lblIntroduceLosDatos.setBounds(-23, 16, 534, 49);
		getContentPane().add(lblIntroduceLosDatos);




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
					Pago.this.dispose();

				}
			}});

		btnCancel.setBounds(171, 264, 152, 29);
		getContentPane().add(btnCancel);
		
		JLabel lblNewLabel = new JLabel("",SwingConstants.CENTER);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setVerticalTextPosition(SwingConstants.TOP);
		lblNewLabel.addMouseListener(new MouseAdapter() {
		
			@Override
			public void mousePressed(MouseEvent e) {
				Pago.this.dispose();
				PagoPaypal paypal= new PagoPaypal(controller, peli, precioT, horario);
				
				paypal.setVisible(true);
				
			}
		});
		
	

		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("./src/main/resources/Imagenes/paypal.png"));
		lblNewLabel.setBounds(48, 83, 166, 153);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				Pago.this.dispose();
				PagoCC cc= new PagoCC(controller, peli, precioT, horario);
				cc.setVisible(true);	
				
			}
		});
		lblNewLabel_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon("./src/main/resources/Imagenes/tarjeta.png"));
		lblNewLabel_1.setBounds(240, 76, 231, 186);
		getContentPane().add(lblNewLabel_1);


	}	
	


}
