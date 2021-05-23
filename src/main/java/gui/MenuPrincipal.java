package gui;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import cine.controller.Controller;
import clasesPelicula.Pelicula;
import clasesPelicula.Sesion;

import javax.swing.LayoutStyle.ComponentPlacement;


/**
 * Ventana Principal donde se accede a cartelera y peliculas
 * @author marcos
 *
 */
public class MenuPrincipal extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	public JLabel lblNewLabel_1= new JLabel();
	public JLabel lblPosM;
	private Controller controller;


	public MenuPrincipal(Controller controller) {
		this.controller = controller;
		ventana();
		this.setVisible(true);
	}
	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */

	private void ventana() {
		setBounds(60, 10, 1700, 1000);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel lblCine = new JLabel("CINE DEUSTO-PSC");
		lblCine.setForeground(Color.GRAY);
		lblCine.setOpaque(true);
		lblCine.setBackground(Color.ORANGE);
		lblCine.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 60));
		lblCine.setHorizontalAlignment(SwingConstants.CENTER);






		JButton btnCartelera = new JButton("Ir a Cartelera");
		btnCartelera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				MenuPrincipal.this.dispose();
			
				
					Cartelera cartelera = new Cartelera(controller);
					cartelera.setVisible(true);

				}
						
		});
		btnCartelera.setBackground(Color.ORANGE);
		btnCartelera.setForeground(Color.GRAY);
		btnCartelera.setOpaque(true);
		btnCartelera.setBorderPainted(false);
		btnCartelera.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 24));

		//Label en que apareceran los posterMenu de las peliculas cada x tiempo
		lblPosM = new JLabel("");
		lblPosM.setLabelFor(lblPosM);
		lblPosM.setHorizontalAlignment(SwingConstants.TRAILING);

		ImageIcon im= new ImageIcon("./PostersMenuPrincipal/avengers.jpeg");
		Icon ic= new ImageIcon(im.getImage().getScaledInstance(1445,597,Image.SCALE_DEFAULT));
		lblPosM.setIcon(ic);
		this.repaint();

		lblPosM.setBorder(BorderFactory.createLineBorder(Color.ORANGE,5));
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPanel.createSequentialGroup()
								.addComponent(lblCine, GroupLayout.DEFAULT_SIZE, 1678, Short.MAX_VALUE)
								.addContainerGap())
							.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
								.addComponent(lblPosM, GroupLayout.PREFERRED_SIZE, 1336, GroupLayout.PREFERRED_SIZE)
								.addGap(164)))
						.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
							.addComponent(btnCartelera, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
							.addGap(718))))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCine, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
					.addGap(90)
					.addComponent(lblPosM, GroupLayout.PREFERRED_SIZE, 482, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnCartelera, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(144, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);



		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.ORANGE);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Salir");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						MenuPrincipal.this.dispose();

						InicioSesion sesion =new  InicioSesion(controller);
						sesion.setVisible(true);
					}
				});
				cancelButton.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 18));
				cancelButton.setBackground(Color.GRAY);
				cancelButton.setOpaque(true);
				cancelButton.setBorderPainted(false);
				cancelButton.setForeground(Color.ORANGE);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
	}

	public void ejecutarVentana() {
		try {
			final MenuPrincipal Ventana = new MenuPrincipal(controller);
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

