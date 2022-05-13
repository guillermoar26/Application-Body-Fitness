package FuncionamientoAplicacion;

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

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

public class PantallaEjercicio3 {

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

	private JLabel etiquetaDescripcionEjercicio;
	private JLabel etiquetaSeriesEjercicio;
	private JLabel etiquetaRepesEjercicio;
	private JLabel etiquetaFotoEjercicio;
	private JLabel etiquetaVideoEjercicio;

	private Dimension dim;
	
	public PantallaEjercicio3(Usuario informacionUsuario, ArrayList<String> tresEjercicios) {
		frame = new JFrame();
		
		dim = frame.getToolkit().getScreenSize();
		//System.out.println(dim);
		frame.setMaximumSize(dim);
		
		frame.setBounds(100, 100, 1500, 830);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);

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
		JLabel etiquetaEjercicio = new JLabel("<html>Ejercicio 3 " + tresEjercicios.get(18) + "<html>");
		etiquetaEjercicio.setFont(new Font("Tahoma", Font.BOLD, 18));
		etiquetaEjercicio.setBounds(421, 64, 521, 53);
		panel.add(etiquetaEjercicio);

		etiquetaDescripcionEjercicio = new JLabel("<html>" + tresEjercicios.get(19) + "<html>");
		etiquetaDescripcionEjercicio.setBounds(65, 192, 306, 64);
		panel.add(etiquetaDescripcionEjercicio);

		etiquetaSeriesEjercicio = new JLabel("<html>" + tresEjercicios.get(20) + "<html>");
		etiquetaSeriesEjercicio.setBounds(65, 271, 229, 37);
		panel.add(etiquetaSeriesEjercicio);

		etiquetaRepesEjercicio = new JLabel("<html>" + tresEjercicios.get(21) + "<html>");
		etiquetaRepesEjercicio.setBounds(65, 318, 229, 37);
		panel.add(etiquetaRepesEjercicio);

		etiquetaFotoEjercicio = new JLabel();
		image = null;
		etiquetaFotoEjercicio.setBounds(1087, 44, 209, 173);

		try {
			System.out.println("Hola" + tresEjercicios.get(22));
			image = ImageIO.read(getClass().getResource(tresEjercicios.get(22)));
			ImageIcon imagenLogo = new ImageIcon(image.getScaledInstance(etiquetaFotoEjercicio.getWidth(), etiquetaFotoEjercicio.getHeight(), Image.SCALE_SMOOTH));
			etiquetaFotoEjercicio.setIcon(imagenLogo);	
		}
		catch (IOException e) {

		}

		
		panel.add(etiquetaFotoEjercicio);

		etiquetaVideoEjercicio = new JLabel("<html>" + tresEjercicios.get(23) + "<html>");
		etiquetaVideoEjercicio.setBounds(406, 177, 671, 364);
		panel.add(etiquetaVideoEjercicio);

		// Botón Anterior
		JButton botonAnterior = new JButton("<html>Anterior<html>");
		botonAnterior.setBounds(148, 691, 85, 21);
		panel.add(botonAnterior);

		// Botón Finalizar Tarea
		JButton botonFinalizar = new JButton("<html>Finalizar entrenamiento<html>");
		botonFinalizar.setBounds(772, 691, 170, 21);
		panel.add(botonFinalizar);

		// Imagen Fondo
		etiquetaFondo = new JLabel();
		imagenFondo = null;

		try {
			imagenFondo = ImageIO.read(getClass().getResource("/imagenFondoVioleta.png"));
			ImageIcon im = new ImageIcon(imagenFondo.getScaledInstance(imagenFondo.getWidth(), imagenFondo.getHeight(), Image.SCALE_SMOOTH));
			etiquetaFondo.setIcon(im);
		} catch(Exception e) {
		}				
		etiquetaFondo.setBounds(0, 0, 1536, 864);
		panel.add(etiquetaFondo);



		botonAnterior.addActionListener(new ActionListener() {
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
