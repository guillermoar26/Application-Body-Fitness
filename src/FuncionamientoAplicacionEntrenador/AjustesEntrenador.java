package FuncionamientoAplicacionEntrenador;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;

import InformacionPersona.Entrenadores;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

public class AjustesEntrenador {

	private JFrame frame;

	// No tocar
	public AjustesEntrenador(Entrenadores informacionEntrenador) {
		frame = new JFrame();
		frame.setBounds(100, 100, 382, 524);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel etiquetaLogo = new JLabel();
		BufferedImage imagenLogo = null;

		try {
			imagenLogo = ImageIO.read(getClass().getResource("/logo.jpg"));
			ImageIcon im = new ImageIcon(imagenLogo.getScaledInstance(70, 65, Image.SCALE_SMOOTH));
			etiquetaLogo.setIcon(im);
		} catch(Exception e) {
		}	
		etiquetaLogo.setBounds(298, 10, 70, 65);
		panel.add(etiquetaLogo);

		// Label cambiar informacion personal del entrenador
		JLabel etiquetaCambiarInfo = new JLabel("<html>CAMBIAR INFORMACIÓN PERSONAL<html>", SwingConstants.CENTER);
		etiquetaCambiarInfo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		etiquetaCambiarInfo.setBounds(31, 35, 268, 28);
		panel.add(etiquetaCambiarInfo);


		// boton atras
		JButton botonAtras = new JButton("<html>Atrás<html>");
		botonAtras.addActionListener(new ActionListener() {
			@ Override
			public void actionPerformed(ActionEvent e) {
				new PantallaPrincipalEntrenador(informacionEntrenador);
				frame.setVisible(false);
			}
		});
		botonAtras.setBounds(10, 456, 85, 21);
		panel.add(botonAtras);

		// Cambiar nombre del entrenador
		JButton botonCambiarNombre = new JButton("<html>NOMBRE<html>");
		botonCambiarNombre.setBounds(77, 63, 203, 37);
		panel.add(botonCambiarNombre);

		botonCambiarNombre.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new AjustesEntrenadorCambioNombre(informacionEntrenador);
				frame.setVisible(false);
			}
		});

		// Cambiar apellidos del entrenador
		JButton botonCambiarApellidos = new JButton("<html>APELLIDOS<html>");
		botonCambiarApellidos.setBounds(77, 128, 203, 37);
		panel.add(botonCambiarApellidos);

		botonCambiarApellidos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new AjustesEntrenadorCambioApellidos(informacionEntrenador);
				frame.setVisible(false);
			}
		});

		// Cambiar edad del entrenador
		JButton botonCambiarEdad = new JButton("<html>EDAD<html>");
		botonCambiarEdad.setBounds(77, 195, 203, 37);
		panel.add(botonCambiarEdad);

		botonCambiarEdad.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new AjustesEntrenadorCambioEdad(informacionEntrenador);
				frame.setVisible(false);
			}
		});

		// Cambiar correo electronico del entrenador
		JButton botonCambiarCorreo = new JButton("<html>CORREO ELECTRÓNICO<html>");
		botonCambiarCorreo.setBounds(77, 263, 203, 37);
		panel.add(botonCambiarCorreo);

		botonCambiarCorreo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new AjustesEntrenadorCambioCorreo(informacionEntrenador);
				frame.setVisible(false);
			}
		});

		// Cambiar contraseña del entrenador
		JButton botonCambiarContrasena = new JButton("<html>CONTRASEÑA<html>");
		botonCambiarContrasena.setBounds(77, 334, 203, 37);
		panel.add(botonCambiarContrasena);

		botonCambiarContrasena.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new AjustesEntrenadorCambioContrasena(informacionEntrenador);
				frame.setVisible(false);
			}
		});

		// boton cambiar genero del entrenador
		JButton botonCambiarGenero = new JButton("<html>GÉNERO<html>");
		botonCambiarGenero.setBounds(77, 398, 203, 37);
		panel.add(botonCambiarGenero);

		botonCambiarGenero.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new AjustesEntrenadorCambioGenero(informacionEntrenador);
				frame.setVisible(false);
			}
		});

		// Imagen Fondo
		JLabel etiquetaFondo = new JLabel();
		BufferedImage imagenFondo = null;

		try {
			imagenFondo = ImageIO.read(getClass().getResource("/imagenFondoVioleta.png"));
			ImageIcon im = new ImageIcon(imagenFondo.getScaledInstance(imagenFondo.getWidth(), imagenFondo.getHeight(), Image.SCALE_SMOOTH));
			etiquetaFondo.setIcon(im);
		} catch(Exception e) {
		}
		etiquetaFondo.setBounds(0, 0, 436, 496);
		panel.add(etiquetaFondo);

		frame.setVisible(true);
	}
}
