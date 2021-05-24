package gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

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
import clasesPelicula.Pelicula;
import javax.swing.LayoutStyle.ComponentPlacement;
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
	private List<Pelicula> peliculas;

	/**
	 * Launch the application.
	 */

	public VentanaGestion(Controller controller, List<Pelicula> p) {
		this.controller = controller;
		this.peliculas = p;
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
				
				VentanaGestion.this.dispose();			
				GestionPelicula gp = new GestionPelicula(controller, peliculas);	
				gp.setVisible(true);
				



			}
		});
		lblPe.setForeground(Color.ORANGE);
		lblPe.setOpaque(true);
		lblPe.setBorder(new LineBorder(new Color(255, 200, 0), 5, true));
		
		JLabel lblGA = new JLabel("Gestión Clientes");
		lblGA.setForeground(Color.ORANGE);
		lblGA.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 15));
		JLabel lblGP = new JLabel("Anyadir Películas");
		lblGP.setForeground(Color.ORANGE);
		lblGP.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 15));

		JLabel lblG = new JLabel("Gestión - Cine Deusto PSC");
		lblG.setForeground(Color.ORANGE);
		lblG.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 25));
		
		JLabel lblPe_1 = new JLabel("");
		lblPe_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		lblPe_1.setOpaque(true);
		lblPe_1.setForeground(Color.ORANGE);
		lblPe_1.setBorder(new LineBorder(new Color(255, 200, 0), 5, true));
		lblPe_1.setBackground(Color.ORANGE);
		
		JLabel lblEliminarPrimeraPelcula = new JLabel("Eliminar primera película");
		lblEliminarPrimeraPelcula.setForeground(Color.ORANGE);
		lblEliminarPrimeraPelcula.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 15));
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addContainerGap(222, Short.MAX_VALUE)
									.addComponent(lblAd, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
									.addGap(146)
									.addComponent(lblPe, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addGap(445)
									.addComponent(lblG)))
							.addGap(79))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(266)
							.addComponent(lblGA)
							.addGap(222)
							.addComponent(lblGP)
							.addGap(117)))
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblEliminarPrimeraPelcula, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(156))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblPe_1, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(57)
					.addComponent(lblG)
					.addGap(136)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPe, GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
								.addComponent(lblAd, GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE))
							.addGap(25))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblPe_1, GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGA)
						.addComponent(lblGP)
						.addComponent(lblEliminarPrimeraPelcula, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addGap(77))
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
						InicioSesion is = new InicioSesion(controller, peliculas);
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
