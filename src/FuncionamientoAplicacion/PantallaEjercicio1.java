package FuncionamientoAplicacion;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import InformacionPersona.Usuario;
import java.awt.Font;

public class PantallaEjercicio1 {

	// Frame
	private JFrame frame;

	// Panel 
	private JPanel panel;

	// Imágenes
	private BufferedImage imagenFondo;
	private BufferedImage image;

	// Etiquetas
	private JLabel etiquetaFondo;
	private JLabel etiquetaLogo;

	// Botones
	private JButton botonSiguiente;
	private JLabel etiquetaDescripcionEjercicio;
	private JLabel etiquetaSeriesEjercicio;
	private JLabel etiquetaRepesEjercicio;
	private JLabel etiquetaFotoEjercicio;
	private JLabel etiquetaVideoEjercicio;
	private JButton botonFinalizar;
	
	private Dimension dim;

	public PantallaEjercicio1(Usuario informacionUsuario, ArrayList<String> tresEjercicios) {
		frame = new JFrame();
		frame.setMaximumSize(dim);
		frame.setBounds(100, 100, 1500, 830);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);

		dim = frame.getToolkit().getScreenSize();
		System.out.println("Dimension: " + dim);
		
		panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		// Imagen Logo
		etiquetaLogo = new JLabel();
		image = null;

		try {
			image = ImageIO.read(getClass().getResource("/logo.jpg"));
			ImageIcon imagenLogo = new ImageIcon(image.getScaledInstance(image.getWidth(), image.getHeight(), Image.SCALE_SMOOTH));
			etiquetaLogo.setIcon(imagenLogo);	
		}
		catch (IOException e) {
		}
		etiquetaLogo.setBounds(10, 10, 229, 157);
		panel.add(etiquetaLogo);
		
		
		// Aqui cada etiqueta tiene una funcion en concreto y los valores que tiene que coger esta en el ArrayList de tresEjercicios
		// Etiqueta Dieta Recomendada
		JLabel etiquetaEjercicio = new JLabel("<html>Ejercicio 1 " + tresEjercicios.get(2) + "<html>");
		etiquetaEjercicio.setFont(new Font("Tahoma", Font.BOLD, 18));
		etiquetaEjercicio.setBounds(421, 64, 606, 53);
		panel.add(etiquetaEjercicio);

		etiquetaDescripcionEjercicio = new JLabel("<html>" + tresEjercicios.get(3) +"<html>");
		etiquetaDescripcionEjercicio.setBounds(65, 192, 306, 64);
		panel.add(etiquetaDescripcionEjercicio);

		etiquetaSeriesEjercicio = new JLabel("<html>" + tresEjercicios.get(4) + "<html>");
		etiquetaSeriesEjercicio.setBounds(65, 271, 229, 37);
		panel.add(etiquetaSeriesEjercicio);

		etiquetaRepesEjercicio = new JLabel("<html>" + tresEjercicios.get(5) +"<html>");
		etiquetaRepesEjercicio.setBounds(65, 318, 229, 37);
		panel.add(etiquetaRepesEjercicio);

		etiquetaFotoEjercicio = new JLabel();
		image = null;
		etiquetaFotoEjercicio.setBounds(1087, 44, 209, 173);

		try {
			image = ImageIO.read(getClass().getResource(tresEjercicios.get(6)));
			ImageIcon imagenLogo = new ImageIcon(image.getScaledInstance(etiquetaFotoEjercicio.getWidth(), etiquetaFotoEjercicio.getHeight(), Image.SCALE_SMOOTH));
			etiquetaFotoEjercicio.setIcon(imagenLogo);	
		}
		catch (IOException e) {

		}

		
		panel.add(etiquetaFotoEjercicio);

		etiquetaVideoEjercicio = new JLabel("<html>" + tresEjercicios.get(7) + "<html>");
		etiquetaVideoEjercicio.setBounds(406, 177, 671, 364);
		panel.add(etiquetaVideoEjercicio);



		// Boton Siguiente
		botonSiguiente = new JButton("<html>Siguiente<html>");
		botonSiguiente.setBounds(285, 691, 85, 21);
		panel.add(botonSiguiente);


		// Botón Finalizar Tarea
		botonFinalizar = new JButton("<html>Finalizar entrenamiento<html>");
		botonFinalizar.setBounds(772, 691, 170, 21);
		panel.add(botonFinalizar);

		// Imagen Fondo
		etiquetaFondo = new JLabel();
		imagenFondo = null;

		try {
			imagenFondo = ImageIO.read(getClass().getResource("/imagenFondoVioleta.png"));
			ImageIcon im = new ImageIcon(imagenFondo.getScaledInstance(imagenFondo.getWidth(), imagenFondo.getHeight(), Image.SCALE_SMOOTH));
			etiquetaFondo.setIcon(im);
		} 

		catch(Exception e) {

		}				
		etiquetaFondo.setBounds(0, 0, 1536, 864);
		panel.add(etiquetaFondo);	

		botonSiguiente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new PantallaEjercicio2 (informacionUsuario, tresEjercicios);
			}
		});

		botonFinalizar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new PantallaPrincipalUsuario (informacionUsuario);
			}
		});

		frame.setVisible(true);

	}
}
