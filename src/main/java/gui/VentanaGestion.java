package gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import cine.controller.Controller;
/**
 * Ventana donde se podrán acceder a las distintas gestiones de la aplicación
 * @author Marcos
 *
 */
public class VentanaGestion extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblAd;
	private Controller controller;

	/**
	 * Launch the application.
	 */

	public VentanaGestion(Controller controller) {
		this.controller = controller;
		ventana();
		this.setVisible(true);
	}

	/**
	 * Create the dialog.
	 */
	public void ventana() {

		setBounds(250, 50, 1200, 900);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.WEST);
		{
			//Abre GestionAdministrador
			lblAd = new JLabel("");
			lblAd.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
				}
			});
			lblAd.setBackground(Color.ORANGE);
			lblAd.setOpaque(true);
			lblAd.setIcon(new ImageIcon("./src/main/resources/Imagenes/clientes.png"));		
			lblAd.setBorder(new LineBorder(new Color(255, 200, 0), 5, true));
		}
		//Abre GestionPeliculas
		JLabel lblPe = new JLabel("");
		lblPe.setBackground(Color.ORANGE);
		lblPe.setIcon(new ImageIcon("./src/main/resources/Imagenes/pelis.png"));
		lblPe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				



			}
		});
		lblPe.setForeground(Color.ORANGE);
		lblPe.setOpaque(true);
		lblPe.setBorder(new LineBorder(new Color(255, 200, 0), 5, true));
		
		JLabel lblGA = new JLabel("Gestión Clientes");
		lblGA.setForeground(Color.ORANGE);
		lblGA.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 15));
		JLabel lblGP = new JLabel("Gestión Películas");
		lblGP.setForeground(Color.ORANGE);
		lblGP.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 15));

		JLabel lblG = new JLabel("Gestión - Cine Deusto PSC");
		lblG.setForeground(Color.ORANGE);
		lblG.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 25));
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addGap(336)
									.addComponent(lblAd, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE))
								.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
									.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblGA)
									.addGap(45)))
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addGap(70)
									.addComponent(lblPe, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addGap(96)
									.addComponent(lblGP))))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(445)
							.addComponent(lblG)))
					.addContainerGap(443, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(57)
					.addComponent(lblG)
					.addGap(136)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPe, GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
						.addComponent(lblAd, GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE))
					.addGap(55)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGP)
						.addComponent(lblGA))
					.addGap(102))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.ORANGE);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Salir");
				cancelButton.setBackground(Color.GRAY);
				cancelButton.setForeground(Color.ORANGE);
				cancelButton.setOpaque(true);
				cancelButton.setBorderPainted(false);
				cancelButton.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 15));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						VentanaGestion.this.dispose();
						InicioSesion is = new InicioSesion(controller);
						is.setVisible(true);
						

					}
				});
				//Cierra Ventana
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
