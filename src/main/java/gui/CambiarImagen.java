package gui;

import java.awt.Image;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import cine.controller.Controller;
import clasesPelicula.Pelicula;

/**
 * Clase que permite mediante una tarea que las imagenes vayan cambiando en base a un Timer
 * @author alex
 *
 */
public class CambiarImagen {

	static int contador=0;
	
	


	
	public static void main (Controller controller,List<Pelicula>	p) {



		int velocidad=3;

		Timer timer;
		TimerTask tarea;

		int velmil= velocidad*1000;

		
		
		
		MenuPrincipal cartelera = new MenuPrincipal(controller, p);
		cartelera.setVisible(true);

		//tarea para ir cambiando las imágenes del menú principal cada x segundos
		tarea= new TimerTask() {

			@Override
			public void run() {
				Icon icono;

				switch(contador) {

				case 0:

					contador=1;

					ImageIcon im= new ImageIcon("./PostersMenuPrincipal/anabelle.jpg");
					Icon ic= new ImageIcon(im.getImage().getScaledInstance(1445,597,Image.SCALE_DEFAULT));

					cartelera.lblPosM.setIcon(ic);
					cartelera.repaint();


					break;

				case 1:

					contador=2;

					ImageIcon im1= new ImageIcon("./PostersMenuPrincipal/malasaña32.jpg");
					Icon ic1= new ImageIcon(im1.getImage().getScaledInstance(1445,597,Image.SCALE_DEFAULT));
					cartelera.lblPosM.setIcon(ic1);
					cartelera.repaint();

					break;


				case 2:
					contador=3;
					ImageIcon im2= new ImageIcon("./PostersMenuPrincipal/escape.jpg");
					Icon ic2= new ImageIcon(im2.getImage().getScaledInstance(1445,597,Image.SCALE_DEFAULT));
					cartelera.lblPosM.setIcon(ic2);
					cartelera.repaint();


					break;

				case 3:
					contador=4;
					ImageIcon im3= new ImageIcon("./PostersMenuPrincipal/fantasy.jpg");
					Icon ic3= new ImageIcon(im3.getImage().getScaledInstance(1445,597,Image.SCALE_DEFAULT));
					cartelera.lblPosM.setIcon(ic3);
					cartelera.repaint();


					break;
				


				case 4:
					contador=0;
					ImageIcon im11= new ImageIcon(".PostersMenuPrincipal/avengers.jpeg");
					Icon ic11= new ImageIcon(im11.getImage().getScaledInstance(1445,597,Image.SCALE_DEFAULT));
					cartelera.lblPosM.setIcon(ic11);
					cartelera.repaint();


					break;





				}

			}


		};

		timer = new Timer();
		timer.scheduleAtFixedRate(tarea,velmil,velmil);
	}


}
