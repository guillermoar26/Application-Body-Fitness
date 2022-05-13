package FuncionamientoAplicacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import InformacionPersona.Usuario;
import Login.PanelUsuarioContrasena;
import TiposEjerciciosClases.Definir;
import TiposEjerciciosClases.GanarMusculo;
import TiposEjerciciosClases.Tonificar;
import java.awt.Font;


public class PantallaPrincipalUsuario {

	// Frame
	private JFrame frame;

	// Panel
	private JPanel panel;

	// Imágenes
	private BufferedImage imagenLogo;
	private BufferedImage imagenFondo;
	private BufferedImage imagenAjustes;
	private BufferedImage imagenCalendario;
	private BufferedImage imagenDietas;
	private BufferedImage imagenCambiarDietas;
	private BufferedImage imagenCambiarEntrenamiento;
	private BufferedImage imagenCambiarDatos;
	private BufferedImage imagenRutinas;

	// Etiquetas
	private JLabel etiquetaFondo; 
	private JLabel etiquetaLogo;
	private JLabel etiquetaNombre;
	private JLabel etiquetaApellidos;
	private JLabel etiquetaSaludo;
	private JLabel etiquetaEslogan;
	private JLabel etiquetaAltura;
	private JLabel etiquetaPeso;
	private JLabel etiquetaEdad;
	private JLabel etiquetaSexo;
	private JLabel etiquetaIMC;
	private JLabel etiquetaGrasaCorporal;
	private JLabel etiquetaFecha;
	private JLabel etiquetaDietas;
	private JLabel etiquetaCambiarDietas;
	private JLabel etiquetaCambiarEntrenamiento;
	private JLabel etiquetaCambiarDatos;
	private JLabel etiquetaRutinas;

	//Botones
	private JButton botonAjustes;
	private JButton botonCalendario;
	private JButton botonDietas;
	private JButton botonCambiarDietas;
	private JButton botonCambiarEntrenamiento;
	private JButton botonCambiarDatos;
	private JButton botonRutinas;
	private JButton botonCerrarSesion;


	public PantallaPrincipalUsuario(Usuario informacionUsuario) {
		frame = new JFrame();
		frame.setBounds(100, 100, 1920, 1080);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);

		panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		// Imagen Logo
		etiquetaLogo = new JLabel();
		imagenLogo = null;

		try {
			imagenLogo = ImageIO.read(getClass().getResource("/logo.jpg"));
			ImageIcon im = new ImageIcon(imagenLogo.getScaledInstance(62, 57, Image.SCALE_SMOOTH));
			etiquetaLogo.setIcon(im);
		} 
		catch(Exception e) {

		}		

		etiquetaLogo.setBounds(10, 24, 79, 87);
		panel.add(etiquetaLogo);

		// Botón Ajustes
		botonAjustes = new JButton();
		imagenAjustes = null;

		try {
			imagenAjustes = ImageIO.read(getClass().getResource("/ajustes.png"));
			ImageIcon im = new ImageIcon(imagenAjustes.getScaledInstance(62, 57, Image.SCALE_SMOOTH));
			botonAjustes.setIcon(im);
		} 
		catch(Exception e) {

		}

		botonAjustes.setBounds(10, 143, 62, 57);
		panel.add(botonAjustes);

		botonAjustes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Ajustes(informacionUsuario);
				frame.setVisible(false);
			}
		});

		// Botón Calendario
		botonCalendario = new JButton();
		imagenCalendario = null;

		try {
			imagenCalendario = ImageIO.read(getClass().getResource("/calendario.png"));
			ImageIcon im = new ImageIcon(imagenCalendario.getScaledInstance(62, 57, Image.SCALE_SMOOTH));
			botonCalendario.setIcon(im);
		}
		catch(Exception e) {

		}

		botonCalendario.setBounds(10, 243, 62, 57);
		panel.add(botonCalendario);

		botonCalendario.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// ESTA FUNCIONALIDAD AUN NO ESTA AÑADIDA
				/*new Calendario();
				frame.setVisible(false);*/
				botonCalendario.setEnabled(false);
				JOptionPane.showMessageDialog(null, "<html>Funcionalidad disponible próximamente<html>");

			}
		});

		// Etiqueta Saludo
		etiquetaSaludo = new JLabel("<html>Hola, " + informacionUsuario.getNombre()); 
		etiquetaSaludo.setBounds(116, 10, 153, 26);
		panel.add(etiquetaSaludo);

		// Etiqueta Eslogan
		etiquetaEslogan = new JLabel("<html>\u00A1Consigue el cuerpo que quieres!<html>");
		etiquetaEslogan.setBounds(116, 46, 210, 13);
		panel.add(etiquetaEslogan);

		// Etiqueta Nombre
		etiquetaNombre = new JLabel("<html>Nombre: " + informacionUsuario.getNombre() + "<html>");
		etiquetaNombre.setBounds(1256, 143, 109, 13);
		panel.add(etiquetaNombre);
		
		// Etiqueta Apellidos
		etiquetaApellidos = new JLabel(informacionUsuario.getApellidos());
		etiquetaApellidos.setBounds(1356, 143, 109, 13);
		panel.add(etiquetaApellidos);

		// Etiqueta Altura
		etiquetaAltura = new JLabel("<html>Altura: " + informacionUsuario.getAltura() + " cm<html>");
		etiquetaAltura.setBounds(1187, 206, 155, 38);
		panel.add(etiquetaAltura);

		// Etiqueta Peso
		etiquetaPeso = new JLabel("<html>Peso: " + informacionUsuario.getPeso() + " kg<html>");
		etiquetaPeso.setBounds(1187, 249, 109, 26);
		panel.add(etiquetaPeso);

		// Etiqueta Edad
		etiquetaEdad = new JLabel("<html>Edad: " + informacionUsuario.getEdad() + " años<html>");
		etiquetaEdad.setBounds(1187, 276, 178, 32);
		panel.add(etiquetaEdad);

		// Etiqueta Sexo
		etiquetaSexo = new JLabel("<html>Sexo: " + informacionUsuario.getSexo() + "<html>");
		etiquetaSexo.setBounds(1187, 305, 133, 38);
		panel.add(etiquetaSexo);

		// Etiqueta IMC
		etiquetaIMC = new JLabel("<html>Índice Masa Corporal (IMC): " + informacionUsuario.getIMC() + "<html>");
		etiquetaIMC.setBounds(1187, 453, 210, 26);
		panel.add(etiquetaIMC);
		
		// Etiqueta Intervalos IMC
		JLabel etiquetaIntervalosIMC = new JLabel();
		//etiquetaIntervalosIMC.setBounds(1187, 512, 45, 13);
		float imc = Float.parseFloat(informacionUsuario.getIMC());
		if(imc < 18.5) {
			etiquetaIntervalosIMC = new JLabel("<html>Bajo Peso<html>");
			etiquetaIntervalosIMC.setBounds(1187, 512, 100, 13);
			etiquetaIntervalosIMC.setForeground(Color.BLUE);
		} else if(imc >= 18.5 && imc <= 24.9) {
			etiquetaIntervalosIMC = new JLabel("<html>Peso Normal<html>");
			etiquetaIntervalosIMC.setBounds(1187, 512, 100, 13);
			etiquetaIntervalosIMC.setForeground(Color.GREEN);
		} else if(imc >= 25 && imc <= 29.9) {
			etiquetaIntervalosIMC = new JLabel("<html>Sobrepeso<html>");
			etiquetaIntervalosIMC.setBounds(1187, 512, 100, 13);
			etiquetaIntervalosIMC.setForeground(Color.YELLOW);
		} else if(imc >= 30.0) {
			etiquetaIntervalosIMC = new JLabel("<html>Obesidad<html>");
			etiquetaIntervalosIMC.setBounds(1187, 512, 100, 13);
			etiquetaIntervalosIMC.setForeground(Color.RED);
		}
		panel.add(etiquetaIntervalosIMC);

		// Etiqueta % grasa corporal
		etiquetaGrasaCorporal = new JLabel("<html>Porcentaje Grasa Corporal: " + informacionUsuario.getPorcentajeDeGrasaCorporal() + " %<html>");
		etiquetaGrasaCorporal.setBounds(1187, 393, 210, 38);
		panel.add(etiquetaGrasaCorporal);

		// Etiqueta Fecha
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		String fecha = dtf.format(LocalDateTime.now());
		etiquetaFecha = new JLabel(fecha);
		etiquetaFecha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		System.out.println ("Esta es la fecha y hora: " + dtf.format(LocalDateTime.now()));
		etiquetaFecha.setBounds(943, 23, 148, 36);
		panel.add(etiquetaFecha);

		// BOTON MIS DIETAS
		botonDietas = new JButton();
		imagenDietas = null;

		try {
			imagenDietas = ImageIO.read(getClass().getResource("/Dietas.jpg"));
			ImageIcon im = new ImageIcon(imagenDietas.getScaledInstance(133, 121, Image.SCALE_SMOOTH));
			botonDietas.setIcon(im);
		} 
		catch(Exception e) {

		}
		
		botonDietas.setBounds(149, 179, 133, 121);
		panel.add(botonDietas);

		botonDietas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MisDietas(informacionUsuario);
				frame.setVisible(false);

			}
		});

		// Etiqueta MIS DIETAS
		etiquetaDietas = new JLabel("<html>MIS DIETAS<html>");
		etiquetaDietas.setBounds(180, 309, 70, 13);
		panel.add(etiquetaDietas);

		// BOTON CAMBIAR DIETA
		botonCambiarDietas = new JButton();
		imagenCambiarDietas = null;

		try {
			imagenCambiarDietas = ImageIO.read(getClass().getResource("/cambiarDieta.png"));
			ImageIcon imagenCD = new ImageIcon(imagenCambiarDietas.getScaledInstance(133, 121, Image.SCALE_SMOOTH));
			botonCambiarDietas.setIcon(imagenCD);
		} catch(Exception e) {}

		botonCambiarDietas.setBounds(149, 358, 133, 121);
		panel.add(botonCambiarDietas);

		botonCambiarDietas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new CambiarDieta(informacionUsuario);
				frame.setVisible(false);
			}
		});

		// Etiqueta CAMBIAR DIETA
		etiquetaCambiarDietas = new JLabel("<html>CAMBIAR DIETAS<html>");
		etiquetaCambiarDietas.setBounds(165, 489, 130, 23);
		panel.add(etiquetaCambiarDietas);

		// BOTON CAMBIAR ENTRENAMIENTOS
		botonCambiarEntrenamiento = new JButton();
		imagenCambiarEntrenamiento = null;

		try {
			imagenCambiarEntrenamiento = ImageIO.read(getClass().getResource("/cambiarEntrenamiento.png"));
			ImageIcon imagenCE = new ImageIcon(imagenCambiarEntrenamiento.getScaledInstance(133, 121, Image.SCALE_SMOOTH));
			botonCambiarEntrenamiento.setIcon(imagenCE);
		} catch(Exception e) {}

		botonCambiarEntrenamiento.setBounds(415, 358, 133, 121);
		panel.add(botonCambiarEntrenamiento);

		botonCambiarEntrenamiento.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new CambiarEntrenamiento(informacionUsuario);
				frame.setVisible(false);
			}
		});

		// Etiqueta CAMBIAR ENTRENAMIENTOS
		etiquetaCambiarEntrenamiento = new JLabel("<html>CAMBIAR ENTRENAMIENTO<html>");
		etiquetaCambiarEntrenamiento.setBounds(401, 489, 200, 23);
		panel.add(etiquetaCambiarEntrenamiento);

		// BOTON CAMBIAR DATOS FISICOS
		botonCambiarDatos = new JButton();
		imagenCambiarDatos = null;

		try {
			imagenCambiarDatos = ImageIO.read(getClass().getResource("/cambiarDatos.png"));
			ImageIcon imagenCDS = new ImageIcon(imagenCambiarDatos.getScaledInstance(133, 121, Image.SCALE_SMOOTH));
			botonCambiarDatos.setIcon(imagenCDS);
		} 
		
		catch(Exception e) {

		}

		botonCambiarDatos.setBounds(684, 359, 133, 121);
		panel.add(botonCambiarDatos);

		botonCambiarDatos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new CambiarDatos(informacionUsuario);
				frame.setVisible(false);
			}
		});

		// Etiqueta CAMBIAR DATOS FISICOS
		etiquetaCambiarDatos = new JLabel("<html>ACTUALIZAR DATOS<html>");
		etiquetaCambiarDatos.setBounds(692, 489, 130, 23);
		panel.add(etiquetaCambiarDatos);



		// Boton MIS RUTINAS
		botonRutinas = new JButton();
		imagenRutinas = null;

		try {
			imagenRutinas = ImageIO.read(getClass().getResource("/Rutinas.jpg"));
			ImageIcon im = new ImageIcon(imagenRutinas.getScaledInstance(133, 121, Image.SCALE_SMOOTH));
			botonRutinas.setIcon(im);
		} 

		catch(Exception e) {

		}

		botonRutinas.setBounds(684, 179, 133, 121);
		panel.add(botonRutinas);

		botonRutinas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> tresEjercicios = new  ArrayList<String> ();
				if (informacionUsuario.getEntrenamientoElegido().equals("Definir")) {
					tresEjercicios = Definir.tresEjercicioAleatorioDefinir();
				}
				else if (informacionUsuario.getEntrenamientoElegido().equals("Ganar Musculo")) {
					tresEjercicios = GanarMusculo.tresEjercicioAleatorioGanarMusculo();
				}
				else if (informacionUsuario.getEntrenamientoElegido().equals("Tonificar")) {
					tresEjercicios = Tonificar.tresEjercicioAleatorioTonificar();
				}

				new PantallaEjercicio1(informacionUsuario, tresEjercicios);
				frame.setVisible(false);
			}
		});

		etiquetaRutinas = new JLabel("<html>MIS RUTINAS<html>");
		etiquetaRutinas.setBounds(713, 309, 100, 13);
		panel.add(etiquetaRutinas);
		
		botonCerrarSesion = new JButton("Cerrar Sesion");
		botonCerrarSesion.setBounds(724, 24, 115, 35);
		panel.add(botonCerrarSesion);
		
		botonCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resp = JOptionPane.showOptionDialog(null, "¿Está seguro que quiere cerrar sesión?", "Alerta!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] {"Sí", "No"}, "Sí");
				if (resp == 0) {
					new PanelUsuarioContrasena();
					frame.setVisible(false);
				}
			}
		});

		// Imagen Fondo
		etiquetaFondo = new JLabel();
		imagenFondo = null;
		etiquetaFondo.setBounds(0, 0, 1550, 900);
		
		try {
			imagenFondo = ImageIO.read(getClass().getResource("/fondo_pantallaprincipal (medidas).png"));
			ImageIcon im = new ImageIcon(imagenFondo.getScaledInstance(etiquetaFondo.getWidth(), etiquetaFondo.getHeight(), Image.SCALE_SMOOTH));
			etiquetaFondo.setIcon(im);
		} 
		catch(Exception e) {

		}
		
		
		panel.add(etiquetaFondo);

		frame.setVisible(true);
	}
}