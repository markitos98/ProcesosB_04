package gui;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import org.pdfbox.exceptions.COSVisitorException;
import org.pdfbox.pdmodel.PDDocument;
import org.pdfbox.pdmodel.PDPage;
import org.pdfbox.pdmodel.edit.PDPageContentStream;
import org.pdfbox.pdmodel.font.PDType1Font;
import org.pdfbox.pdmodel.graphics.xobject.PDJpeg;

import cine.controller.Controller;
import clasesPelicula.Pelicula;
import clasesPelicula.Sesion;

import javax.swing.JPasswordField;


/**
 * 
 * @author alex
 *
 */
public class PagoPaypal extends JFrame {

	private JFrame frame3;
	private JTextField textCorreo;
	static int entraInicial=0;
	public int cantidad;
	public int preciot;
	public double precioT;
	private String horario;
	private Controller controller;
	private Pelicula peli;

	public static final String EMAIL_PATTER = 
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
					+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";


	private JPasswordField passwordField;
	private JTextField textField;
	/**
	 * Launch the application.
	 */

	public PagoPaypal(Controller controller, Pelicula p, double precioT, String horario) {
		this.controller = controller;
		this.peli = p;
		this.precioT = precioT;
		this.horario = horario;
		initialize(); 
		this.setVisible(true);
		
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		getContentPane().setBackground(Color.GRAY);
		setBounds(600, 300, 491, 356);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);


		JLabel lblNumeroTarjeta = new JLabel("Correo Electrónico");
		lblNumeroTarjeta.setForeground(Color.ORANGE);
		lblNumeroTarjeta.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 15));
		lblNumeroTarjeta.setBounds(55, 124, 157, 20);
		getContentPane().add(lblNumeroTarjeta);


		JLabel lblIntroduceLosDatos = new JLabel("PAGO PAYPAL");
		lblIntroduceLosDatos.setForeground(Color.ORANGE);
		lblIntroduceLosDatos.setBackground(Color.GRAY);
		lblIntroduceLosDatos.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 28));
		lblIntroduceLosDatos.setHorizontalAlignment(SwingConstants.CENTER);
		lblIntroduceLosDatos.setBounds(-23, 23, 534, 49);
		getContentPane().add(lblIntroduceLosDatos);

		textCorreo= new JTextField();
		textCorreo.setBounds(263, 122, 152, 26);
		getContentPane().add(textCorreo);
		textCorreo.setColumns(10);


		JButton btnPagar = new JButton("Aceptar");
		btnPagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (!textCorreo.getText().matches(EMAIL_PATTER)) {
					JOptionPane.showMessageDialog(null, "Email no valido", "ERROR", JOptionPane.ERROR_MESSAGE);
					
				}else {
					
					
					VentanaEntrada ve= new VentanaEntrada(controller, peli);
					ve.setVisible(false);
					ArrayList<Integer> numeros= new ArrayList<Integer>();
					numeros.clear();
					numeros.add(ve.numAleatorio);
					
					

					
						controller.anyadirEntrada(ve.numAleatorio, peli.getTitulo(), horario , 9, (int)precioT/9, (int)precioT, textCorreo.getText());

						PagoPaypal.this.dispose();
						
				
					try {
					PDDocument entrada;
					
					entrada = new PDDocument();
					PDPage pagina= new PDPage();
					entrada.addPage(pagina);
					String nombre="entrada"+ String.valueOf(numeros.get(0))+".pdf";

					InputStream in = new FileInputStream(new File(peli.getRutaFoto()));
					PDJpeg img = new PDJpeg(entrada, in);
					img.setHeight(400);
					img.setWidth(200);

					
					PDPageContentStream contenido= new PDPageContentStream(entrada,pagina);

					contenido.beginText();
					contenido.setFont(PDType1Font.COURIER,18);
					contenido.moveTextPositionByAmount(100,650);
					contenido.drawString("CINE DEUSTO");
					contenido.endText();

					contenido.beginText();
					contenido.setFont(PDType1Font.COURIER,18);
					contenido.moveTextPositionByAmount(100,650);		
					contenido.drawString("___________");		 		 		
					contenido.endText();

					contenido.beginText();
					contenido.setFont(PDType1Font.COURIER,16);
					contenido.moveTextPositionByAmount(100,580);		
					contenido.drawString("Numero de compra: "+ numeros.get(0));	 		 		
					contenido.endText();

					contenido.beginText();
					contenido.setFont(PDType1Font.COURIER,16);
					contenido.moveTextPositionByAmount(100,560);		
					contenido.drawString("Correo: " +textCorreo.getText());	 		 		
					contenido.endText();

					contenido.beginText();
					contenido.setFont(PDType1Font.COURIER,16);
					contenido.moveTextPositionByAmount(100,540);		
					contenido.drawString("Pelicula: "+ peli.getTitulo());		 		
					contenido.endText();

					contenido.beginText();
					contenido.setFont(PDType1Font.COURIER,16);
					contenido.moveTextPositionByAmount(100,520);		
					contenido.drawString("Sesion: "+ horario);		 		
					contenido.endText();

					contenido.beginText();
					contenido.setFont(PDType1Font.COURIER,16);
					contenido.moveTextPositionByAmount(100,500);		
					contenido.drawString("Sala: "+ peli.getSala());	 		
					contenido.endText();

		
					contenido.beginText();
					contenido.setFont(PDType1Font.COURIER,16);
					contenido.moveTextPositionByAmount(100,460);		
					contenido.drawString("Precio por entrada: "+ ve.txtPrecU.getText());
					contenido.endText();

					contenido.beginText();
					contenido.setFont(PDType1Font.COURIER,16);
					contenido.moveTextPositionByAmount(100,440);		
					contenido.drawString("Precio total: "+ precioT);
					contenido.endText();




					contenido.beginText();
					contenido.drawImage(img, 380, 250);
					contenido.endText();



					contenido.close();
					entrada.save(nombre);

					int EntraInicial=0;
					File entradapdf= new File(nombre);
					File carpetaEntrada = new File("./Entradas/"+nombre);
					Copiar(entradapdf,carpetaEntrada);
					File f= new File(nombre);
					abrirFichero(carpetaEntrada);

					f.delete();
					
			
				

					} catch (IOException | COSVisitorException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
					
					Sesion s = new Sesion(horario);
					
					
					
				}
					
					
					
					
					
					
					
					}});
		btnPagar.setBackground(UIManager.getColor("Button.select"));
		btnPagar.setForeground(Color.ORANGE);
		btnPagar.setOpaque(true);
		btnPagar.setBorderPainted(false);
		btnPagar.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 15));
		btnPagar.setBounds(80, 247, 138, 29);
		getContentPane().add(btnPagar);




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
					PagoPaypal.this.dispose();

				}
			}});

		btnCancel.setBounds(263, 247, 152, 29);
		getContentPane().add(btnCancel);

		JLabel lblFecha = new JLabel("Contraseña");
		lblFecha.setFont(new Font(".AppleSystemUIFont", Font.BOLD, 15));
		lblFecha.setForeground(Color.ORANGE);
		lblFecha.setBounds(55, 156, 126, 16);
		getContentPane().add(lblFecha);

		passwordField = new JPasswordField();
		passwordField.setBounds(263, 152, 152, 26);
		getContentPane().add(passwordField);
		
		textField = new JTextField();
		textField.setBounds(263, 90, 152, 26);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 15));
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setBounds(55, 92, 70, 20);
		getContentPane().add(lblNewLabel);


	}	
	//Método recursivo para copiar fichero de una carpeta a otra
		public static void Copiar(File FOrigen,File FDestino){
			//si el origen no es una carpeta
			if(!FOrigen.isDirectory()){
				//Llamo la funcion que lo copia
				CopiarFichero(FOrigen,FDestino);
			}else{

				entraInicial++; 

				if(entraInicial==1){

					FDestino=new File(FDestino.getAbsolutePath()+"/"+FOrigen.getName()); 

					if(!FDestino.exists()){
						FDestino.mkdir();
					}
				} 

				String []Rutas=FOrigen.list();

				for(int i=0;i<Rutas.length;i++){

					File FnueOri=new File(FOrigen.getAbsolutePath()+"/"+Rutas[i]);

					File FnueDest= new File(FDestino.getAbsolutePath()+"/"+Rutas[i]);

					if(FnueOri.isDirectory() && !FnueDest.exists()){
						FnueDest.mkdir();                        
					}

					Copiar(FnueOri,FnueDest); 
				}
			}

		}    
		public static void CopiarFichero(File FOrigen,File FDestino){
			try {
				//Si el archivo a copiar existe
				if(FOrigen.exists()){
					String copiar="S";
					//si el fichero destino ya existe
					if(FDestino.exists()){
						System.out.println("El fichero ya existe, Desea Sobre Escribir:S/N ");
						copiar = ( new BufferedReader(new InputStreamReader(System.in))).readLine();
					}
					//si puedo copiar
					if(copiar.toUpperCase().equals("S")){

						FileInputStream LeeOrigen= new FileInputStream(FOrigen);

						OutputStream Salida = new FileOutputStream(FDestino);
						//separo un buffer de 1MB de lectura
						byte[] buffer = new byte[1024];
						int tamaño;
						//leo el fichero a copiar cada 1MB
						while ((tamaño = LeeOrigen.read(buffer)) > 0) {
							//Escribe el MB en el fichero destino
							Salida.write(buffer, 0, tamaño);
						}
						System.out.println(FOrigen.getName()+" Copiado con Exito!!");
						//cierra los flujos de lectura y escritura
						Salida.close();
						LeeOrigen.close();
					}

				}else{//l fichero a copiar no existe                
					System.out.println("El fichero a copiar no existe..."+FOrigen.getAbsolutePath());
				}

			} catch (Exception ex) {
				System.out.println(ex.getMessage());

			}


		}
		public static void abrirFichero(File fichero) {
		    Desktop ficheroAEjecutar = Desktop.getDesktop();
		    try {
		         ficheroAEjecutar.open(fichero);
		    } catch (IOException e) {
		         JOptionPane.showMessageDialog(null,
		                    e.getMessage(),
		                    "Error",
		                    JOptionPane.ERROR_MESSAGE);
		    }
		    }
	}

		

