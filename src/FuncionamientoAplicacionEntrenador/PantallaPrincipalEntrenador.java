package FuncionamientoAplicacionEntrenador;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import InformacionPersona.Entrenadores;
import Login.PanelUsuarioContrasena;

import javax.swing.SwingConstants;
import java.awt.Font;

public class PantallaPrincipalEntrenador {

	// Frame
	private JFrame frame;

	// Panel
	private JPanel panel;

	// Imágenes
	private BufferedImage imagenLogo;
	private BufferedImage imagenFondo;
	private BufferedImage imagenAjustes;
	private BufferedImage imagenDietas;
	private BufferedImage imagenCambiarDietas;
	private BufferedImage imagenCambiarEntrenamiento;
	private BufferedImage imagenCambiarDatos;
	private BufferedImage imagenRutinas;
	private BufferedImage imagenAnadirVideos;
	private BufferedImage imagenEliminarVideos;

	// Etiquetas
	private JLabel etiquetaFondo;
	private JLabel etiquetaLogo;
	private JLabel etiquetaNombre;
	private JLabel etiquetaApellidos;
	private JLabel etiquetaSaludo;
	private JLabel etiquetaEslogan;
	private JLabel etiquetaEdad;
	private JLabel etiquetaSexo;
	private JLabel etiquetaFecha;
	private JLabel etiquetaDietas;
	private JLabel etiquetaCambiarDietas;
	private JLabel etiquetaCambiarEntrenamiento;
	private JLabel etiquetaCambiarDatos;
	private JLabel etiquetaRutinas;
	private JLabel etiquetaAnadirVideos;
	private JLabel etiquetaEliminarVideos;

	// Botones
	private JButton botonAjustes;
	private JButton botonAnadirDietas;
	private JButton botonEliminarDietas;
	private JButton botonEliminarEntrenamiento;
	private JButton botonCambiarDatos;
	private JButton botonAnadirEntrenamiento;
	private JButton botonAnadirVideos;
	private JButton botonEliminarVideos;
	private JButton botonCerrarSesion;

	public PantallaPrincipalEntrenador(Entrenadores informacionEntrenador) {
		frame = new JFrame();
		frame.setBounds(100, 100, 1920, 1080);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);

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
		} catch (Exception e) {

		}

		etiquetaLogo.setBounds(22, 24, 62, 57);
		panel.add(etiquetaLogo);

		// Botón Ajustes
		botonAjustes = new JButton();
		imagenAjustes = null;

		try {
			imagenAjustes = ImageIO.read(getClass().getResource("/ajustes.png"));
			ImageIcon im = new ImageIcon(imagenAjustes.getScaledInstance(62, 57, Image.SCALE_SMOOTH));
			botonAjustes.setIcon(im);
		} catch (Exception e) {

		}

		botonAjustes.setBounds(22, 265, 62, 57);
		panel.add(botonAjustes);

		botonAjustes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new AjustesEntrenador(informacionEntrenador);
				frame.setVisible(false);
			}
		});

		// Etiqueta Saludo
		etiquetaSaludo = new JLabel("<html>Hola, " + informacionEntrenador.getNombre());
		etiquetaSaludo.setBounds(117, 10, 153, 26);
		panel.add(etiquetaSaludo);

		// Etiqueta Eslogan
		etiquetaEslogan = new JLabel("<html>\u00A1Consigue el cuerpo que quieres!<html>");
		etiquetaEslogan.setBounds(117, 46, 210, 13);
		panel.add(etiquetaEslogan);

		// Etiqueta Nombre
		etiquetaNombre = new JLabel("<html>Nombre: " + informacionEntrenador.getNombre() + "<html>");
		etiquetaNombre.setBounds(1198, 119, 109, 13);
		panel.add(etiquetaNombre);
		
		// Etiqueta Apellidos
		etiquetaApellidos = new JLabel(informacionEntrenador.getApellidos());
		etiquetaApellidos.setBounds(1298, 119, 109, 13);
		panel.add(etiquetaApellidos);

		// Etiqueta Edad
		etiquetaEdad = new JLabel("<html>Edad: " + informacionEntrenador.getEdad() + " años<html>");
		etiquetaEdad.setBounds(1198, 251, 178, 32);
		panel.add(etiquetaEdad);

		// Etiqueta Sexo
		etiquetaSexo = new JLabel("<html>Sexo: " + informacionEntrenador.getSexo() + "<html>");
		etiquetaSexo.setBounds(1198, 280, 133, 38);
		panel.add(etiquetaSexo);

		// Etiqueta Fecha
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		String fecha = dtf.format(LocalDateTime.now());
		etiquetaFecha = new JLabel(fecha);
		etiquetaFecha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		System.out.println("Esta es la fecha y hora: " + dtf.format(LocalDateTime.now()));
		etiquetaFecha.setBounds(930, 24, 160, 26);
		panel.add(etiquetaFecha);

		// BOTON MIS DIETAS
		botonAnadirDietas = new JButton();
		imagenDietas = null;

		try {
			imagenDietas = ImageIO.read(getClass().getResource("/Dietas.jpg"));
			ImageIcon im = new ImageIcon(imagenDietas.getScaledInstance(133, 121, Image.SCALE_SMOOTH));
			botonAnadirDietas.setIcon(im);
		} catch (Exception e) {

		}
		botonAnadirDietas.setBounds(135, 86, 133, 121);
		panel.add(botonAnadirDietas);

		botonAnadirDietas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new AnadirDietas(informacionEntrenador);
				frame.setVisible(false);

			}
		});

		// Etiqueta MIS DIETAS
		etiquetaDietas = new JLabel("<html>AÑADIR DIETA<html>");
		etiquetaDietas.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaDietas.setBounds(145, 220, 123, 13);
		panel.add(etiquetaDietas);

		// BOTON CAMBIAR DIETA
		botonEliminarDietas = new JButton();
		imagenCambiarDietas = null;

		try {
			imagenCambiarDietas = ImageIO.read(getClass().getResource("/cambiarDieta.png"));
			ImageIcon imagenCD = new ImageIcon(imagenCambiarDietas.getScaledInstance(133, 121, Image.SCALE_SMOOTH));
			botonEliminarDietas.setIcon(imagenCD);
		} catch (Exception e) {
		}

		botonEliminarDietas.setBounds(135, 265, 133, 121);
		panel.add(botonEliminarDietas);

		botonEliminarDietas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new EliminarDietas(informacionEntrenador);
				frame.setVisible(false);
			}
		});

		// Etiqueta CAMBIAR DIETA
		etiquetaCambiarDietas = new JLabel("<html>QUITAR DIETA<html>");
		etiquetaCambiarDietas.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaCambiarDietas.setBounds(135, 396, 130, 23);
		panel.add(etiquetaCambiarDietas);

		// BOTON CAMBIAR ENTRENAMIENTOS
		botonEliminarEntrenamiento = new JButton();
		imagenCambiarEntrenamiento = null;

		try {
			imagenCambiarEntrenamiento = ImageIO.read(getClass().getResource("/cambiarEntrenamiento.png"));
			ImageIcon imagenCE = new ImageIcon(
					imagenCambiarEntrenamiento.getScaledInstance(133, 121, Image.SCALE_SMOOTH));
			botonEliminarEntrenamiento.setIcon(imagenCE);
		} catch (Exception e) {
		}

		botonEliminarEntrenamiento.setBounds(461, 265, 133, 121);
		panel.add(botonEliminarEntrenamiento);

		botonEliminarEntrenamiento.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new EliminarEntrenamientos(informacionEntrenador);
				frame.setVisible(false);
			}
		});

		// Etiqueta CAMBIAR ENTRENAMIENTOS
		etiquetaCambiarEntrenamiento = new JLabel("<html>QUITAR ENTRENAMIENTO<html>");
		etiquetaCambiarEntrenamiento.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaCambiarEntrenamiento.setBounds(438, 396, 178, 23);
		panel.add(etiquetaCambiarEntrenamiento);

		// BOTON CAMBIAR DATOS FISICOS
		botonCambiarDatos = new JButton();
		imagenCambiarDatos = null;

		try {
			imagenCambiarDatos = ImageIO.read(getClass().getResource("/cambiarDatos.png"));
			ImageIcon imagenCDS = new ImageIcon(imagenCambiarDatos.getScaledInstance(133, 121, Image.SCALE_SMOOTH));
			botonCambiarDatos.setIcon(imagenCDS);
		} catch (Exception e) {

		}

		botonCambiarDatos.setBounds(461, 439, 133, 121);
		panel.add(botonCambiarDatos);

		botonCambiarDatos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new AnadirRecomendacion(informacionEntrenador);
				frame.setVisible(false);

			}
		});

		// Etiqueta CAMBIAR DATOS FISICOS
		etiquetaCambiarDatos = new JLabel("<html>AÑADIR RECOMENDACIÓN<html>");
		etiquetaCambiarDatos.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaCambiarDatos.setBounds(438, 570, 178, 23);
		panel.add(etiquetaCambiarDatos);

		// BOTON AÑADIR VIDEOS
		botonAnadirVideos = new JButton();
		imagenAnadirVideos = null;

		try {
			imagenAnadirVideos = ImageIO.read(getClass().getResource("/anadirVideo.png"));
			ImageIcon imagenAV = new ImageIcon(imagenAnadirVideos.getScaledInstance(133, 121, Image.SCALE_SMOOTH));
			botonAnadirVideos.setIcon(imagenAV);
		} catch (Exception e) {

		}

		botonAnadirVideos.setBounds(811, 86, 133, 121);
		panel.add(botonAnadirVideos);

		botonAnadirVideos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new AnadirVideo(informacionEntrenador);
				frame.setVisible(false);
			}
		});

		// ETIQUETA AÑADIR VIDEOS
		etiquetaAnadirVideos = new JLabel("<html>AÑADIR VÍDEOS<html>");
		etiquetaAnadirVideos.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaAnadirVideos.setBounds(814, 210, 130, 23);
		panel.add(etiquetaAnadirVideos);

		// BOTON ELIMINAR VIDEO
		botonEliminarVideos = new JButton();
		imagenEliminarVideos = null;

		try {
			imagenEliminarVideos = ImageIO.read(getClass().getResource("/eliminarVideo.png"));
			ImageIcon imagenEV = new ImageIcon(imagenEliminarVideos.getScaledInstance(133, 121, Image.SCALE_SMOOTH));
			botonEliminarVideos.setIcon(imagenEV);
		} catch (Exception e) {

		}

		botonEliminarVideos.setBounds(811, 265, 133, 121);
		panel.add(botonEliminarVideos);

		botonEliminarVideos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new EliminarVideo(informacionEntrenador);
				frame.setVisible(false);
			}
		});

		// ETIQUETA ELIMINAR VIDEOS
		etiquetaEliminarVideos = new JLabel("<html>ELIMINAR VÍDEOS<html>");
		etiquetaEliminarVideos.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaEliminarVideos.setBounds(814, 396, 130, 23);
		panel.add(etiquetaEliminarVideos);

		// Boton MIS RUTINAS
		botonAnadirEntrenamiento = new JButton();
		imagenRutinas = null;

		try {
			imagenRutinas = ImageIO.read(getClass().getResource("/Rutinas.jpg"));
			ImageIcon im = new ImageIcon(imagenRutinas.getScaledInstance(133, 121, Image.SCALE_SMOOTH));
			botonAnadirEntrenamiento.setIcon(im);
		}

		catch (Exception e) {

		}

		botonAnadirEntrenamiento.setBounds(461, 86, 133, 121);
		panel.add(botonAnadirEntrenamiento);

		botonAnadirEntrenamiento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AnadirEntrenamientos(informacionEntrenador);
				frame.setVisible(false);
			}
		});


		etiquetaRutinas = new JLabel("<html>AÑADIR ENTRENAMIENTO<html>");
		etiquetaRutinas.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaRutinas.setBounds(438, 217, 178, 38);
		panel.add(etiquetaRutinas);

		
		botonCerrarSesion = new JButton("Cerrar Sesión");
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
		} catch (Exception e) {

		}
		panel.add(etiquetaFondo);

		frame.setVisible(true);
	}
}