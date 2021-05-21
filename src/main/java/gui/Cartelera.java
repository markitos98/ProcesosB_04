package gui;


import java.awt.Color;


import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import database.Database;

import clases.Pelicula;
import gui.VentanaPelicula;

import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import cine.controller.Controller;





/**
 * Ventana Cartelera donde se visualizan las películas, se obtiene una lista de las películas de la base de datos y en funcion de su posicion se establecen en los labels, únicamente se visualizará en caso de haber 12 peliculas en la base de datos
 * @author leire
 *
 */
public class Cartelera extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Controller controller;
	List<Pelicula> peliculas=new ArrayList<Pelicula>();

	
	public Cartelera(Controller controller) {
		this.controller = controller;
		ventana();
		this.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	private void ventana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(60, 10, 1700, 1000);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(null);


		setContentPane(contentPane);
		
		try {
			peliculas = controller.getCl().getService().getPeliculas();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 
//		if(peliculas.isEmpty() ) {
//		
//			Pelicula p1 = 	controller.getPelicula("Annabelle vuelve a casa");
//			 
//			 System.out.println(p1.toString());
//			 
//			 peliculas.add(p1);
//		 	peliculas.add(controller.getPelicula("Escape Room"));
//		 	peliculas.add(controller.getPelicula("Fantasy Island"));
//		 	peliculas.add(controller.getPelicula("Malasaña 32"));
//		 	peliculas.add(controller.getPelicula("Los Vengadores"));
//		 	peliculas.add(controller.getPelicula("Escuadron suicida"));
//		 	peliculas.add(controller.getPelicula("Mortal Kombat"));
//		 	peliculas.add(controller.getPelicula("Mulan"));
//		 	peliculas.add(controller.getPelicula("Oxygen"));
//		 	peliculas.add(controller.getPelicula("Soul"));
//		 	peliculas.add(controller.getPelicula("Stowaway"));
//		 	peliculas.add(controller.getPelicula("Twist"));
//		 	
//		}
			System.out.println(peliculas.get(0));
		 	System.out.println(peliculas.get(1));
		 	System.out.println(peliculas.get(2));
		 	System.out.println(peliculas.get(3));
		 	System.out.println(peliculas.get(4));
		 	System.out.println(peliculas.get(5));
		 	System.out.println(peliculas.get(6));
		 	System.out.println(peliculas.get(7));
		 	System.out.println(peliculas.get(8));
		 	System.out.println(peliculas.get(9));
		 	System.out.println(peliculas.get(10));
		 	System.out.println(peliculas.get(11));
	
		 
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);


		JLabel lblCartelera = new JLabel("CARTELERA - CINE DEUSTO-PSC");
		lblCartelera.setBorder(BorderFactory.createLineBorder(Color.ORANGE,7));
		lblCartelera.setHorizontalAlignment(SwingConstants.CENTER);
		lblCartelera.setForeground(Color.GRAY);
		lblCartelera.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 60));
		lblCartelera.setOpaque(true);
		lblCartelera.setBackground(Color.ORANGE);



		JLabel lblP1= new JLabel();

		lblP1.setBorder(BorderFactory.createLineBorder(Color.ORANGE,4));
		lblP1.setIcon(peliculas.get(0).getPoster());
		lblP1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaPelicula vp= new VentanaPelicula(peliculas.get(0));
				vp.setVisible(true);



			}
		});

		JLabel lblP2= new JLabel();

		lblP2.setBorder(BorderFactory.createLineBorder(Color.ORANGE,4));
		lblP2.setIcon(peliculas.get(1).getPoster());

		lblP2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				VentanaPelicula vp= new VentanaPelicula(peliculas.get(1));
				vp.setVisible(true);



			}
		});

		JLabel lblP3 = new JLabel("");

		lblP3.setBorder(BorderFactory.createLineBorder(Color.ORANGE,4));
		lblP3.setIcon(peliculas.get(2).getPoster());

		lblP3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				VentanaPelicula vp= new VentanaPelicula(peliculas.get(2));
				vp.setVisible(true);



			}
		});



		JLabel lblP4 = new JLabel("");

		lblP4.setBorder(BorderFactory.createLineBorder(Color.ORANGE,4));
		lblP4.setIcon(peliculas.get(3).getPoster());

		lblP4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaPelicula vp= new VentanaPelicula(peliculas.get(3));
				vp.setVisible(true);



			}
		});


		JLabel lblP5 = new JLabel("");

		lblP5.setBorder(BorderFactory.createLineBorder(Color.ORANGE,4));
		lblP5.setIcon(peliculas.get(4).getPoster());

		lblP5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 
				VentanaPelicula vp= new VentanaPelicula(peliculas.get(4));
				vp.setVisible(true);



			}
		});

		JLabel lblP6 = new JLabel("");

		lblP6.setBorder(BorderFactory.createLineBorder(Color.ORANGE,4));
		lblP6.setIcon(peliculas.get(5).getPoster());

		lblP6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaPelicula vp= new VentanaPelicula(peliculas.get(5));
				vp.setVisible(true);



			}
		});



		JLabel lblP7 = new JLabel("");

		lblP7.setBorder(BorderFactory.createLineBorder(Color.ORANGE,4));
		lblP7.setIcon(peliculas.get(6).getPoster());


		lblP7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaPelicula vp= new VentanaPelicula(peliculas.get(6));
				vp.setVisible(true);



			}
		});

		JLabel lblP8 = new JLabel("");

		lblP8.setBorder(BorderFactory.createLineBorder(Color.ORANGE,4));
		lblP8.setIcon(peliculas.get(7).getPoster());

		lblP8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				VentanaPelicula vp= new VentanaPelicula(peliculas.get(7));
				vp.setVisible(true);



			}
		});



		JLabel lblP9 = new JLabel("");

		lblP9.setBorder(BorderFactory.createLineBorder(Color.ORANGE,4));
		lblP9.setIcon(peliculas.get(8).getPoster());

		lblP9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		
				VentanaPelicula vp= new VentanaPelicula(peliculas.get(8));
				vp.setVisible(true);



			}
		});


		JLabel lblP10 = new JLabel("");

		lblP10.setBorder(BorderFactory.createLineBorder(Color.ORANGE,4));
		lblP10.setIcon(peliculas.get(9).getPoster());

		lblP10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				VentanaPelicula vp= new VentanaPelicula(peliculas.get(9));
				vp.setVisible(true);



			}
		});

		JLabel lblP11 = new JLabel("");

		lblP11.setBorder(BorderFactory.createLineBorder(Color.ORANGE,4));
		lblP11.setIcon(peliculas.get(10).getPoster());

		lblP11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				VentanaPelicula vp= new VentanaPelicula(peliculas.get(10));
				vp.setVisible(true);



			}
		});



		JLabel lblP12 = new JLabel("");

		lblP12.setBorder(BorderFactory.createLineBorder(Color.ORANGE,4));
		lblP12.setIcon(peliculas.get(11).getPoster());

		lblP12.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				VentanaPelicula vp= new VentanaPelicula(peliculas.get(11));
				vp.setVisible(true);



			}
		});




		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 1680, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(14)
										.addComponent(lblCartelera, GroupLayout.PREFERRED_SIZE, 1653, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(75)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(lblP1, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblP7, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
										.addGap(66)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(lblP2, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblP8, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
										.addGap(67)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(lblP3, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblP9, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
										.addGap(65)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(lblP4, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblP10, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
										.addGap(71)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(lblP5, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblP11, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
										.addGap(65)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(lblP12, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblP6, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))))
						.addContainerGap(20, Short.MAX_VALUE))
				);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(14)
						.addComponent(lblCartelera, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(93)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblP1, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblP2, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblP3, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblP4, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblP5, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(91)
										.addComponent(lblP6, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE)))
						.addGap(60)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblP7, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblP8, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblP9, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblP10, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblP11, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblP12, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				);



		JButton btnNewButton = new JButton("Volver");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Cartelera.this.dispose();
				MenuPrincipal menu= new MenuPrincipal(controller);
				peliculas.clear();
				menu.setVisible(true);
			

			}
		});
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.setOpaque(true);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setForeground(Color.ORANGE);
		btnNewButton.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 18));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap(1572, Short.MAX_VALUE)
						.addComponent(btnNewButton)
						.addContainerGap())
				);
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap()
						.addComponent(btnNewButton)
						.addContainerGap(14, Short.MAX_VALUE))
				);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);


	}

	
	public void ejecutarVentana() {
		try {
			final Cartelera Ventana = new Cartelera(controller);
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
