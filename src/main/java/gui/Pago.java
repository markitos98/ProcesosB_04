package gui;

import java.awt.Color;
import java.awt.Font;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


/**
 * Ventana de pago que genera un pdf al realizar una compra y añade una entrada a la base de datos
 * @author alex
 *
 */
public class Pago {

	private JFrame frame3;
	static int entraInicial=0;
	public int cantidad;
	public int preciot;
	public static final String EMAIL_PATTER = 
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
					+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					Pago window = new Pago();
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
	public Pago() {
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


		JLabel lblIntroduceLosDatos = new JLabel("PAGO PAYPAL");
		lblIntroduceLosDatos.setForeground(Color.ORANGE);
		lblIntroduceLosDatos.setBackground(Color.GRAY);
		lblIntroduceLosDatos.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 28));
		lblIntroduceLosDatos.setHorizontalAlignment(SwingConstants.CENTER);
		lblIntroduceLosDatos.setBounds(-23, 16, 534, 49);
		frame3.getContentPane().add(lblIntroduceLosDatos);




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

		btnCancel.setBounds(171, 264, 152, 29);
		frame3.getContentPane().add(btnCancel);
		
		JLabel lblNewLabel = new JLabel("",SwingConstants.CENTER);
		lblNewLabel.addMouseListener(new MouseAdapter() {
		
			@Override
			public void mousePressed(MouseEvent e) {
				PagoPaypal paypal= new PagoPaypal();
				
			}
		});
		
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("/Users/alex/git/ProcesosB_04/Imagenes/888870.png"));
		lblNewLabel.setBounds(60, 75, 130, 153);
		frame3.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				PagoCC cc= new PagoCC();
				
			}
		});
		lblNewLabel_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon("/Users/alex/git/ProcesosB_04/Imagenes/db972633301187368f9e36e722375b33-icono-de-tarjeta-de-credito.png"));
		lblNewLabel_1.setBounds(240, 76, 231, 186);
		frame3.getContentPane().add(lblNewLabel_1);


	}	
}
