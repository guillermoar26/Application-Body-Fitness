package FuncionamientoAplicacion;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.SwingConstants;

import InformacionPersona.Usuario;

public class CambiarDatos {

	private JFrame frame;

	public CambiarDatos(Usuario informacionUsuario) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
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
		etiquetaLogo.setBounds(356, 10, 70, 65);
		panel.add(etiquetaLogo);
		
		// Cabecera cambiar dieta seleccionada
		JLabel labelCambiarDatos = new JLabel("<html>CAMBIAR PARÁMETROS FÍSICOS<html>");
		labelCambiarDatos.setHorizontalAlignment(SwingConstants.CENTER);
		labelCambiarDatos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelCambiarDatos.setBounds(24, 25, 365, 13);
		panel.add(labelCambiarDatos);

		// boton Atras
		JButton botonAtras = new JButton("<html>Atrás<html>");
		botonAtras.setBounds(10, 232, 85, 21);
		panel.add(botonAtras);

		botonAtras.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new PantallaPrincipalUsuario(informacionUsuario);
				frame.setVisible(false);
			}
		});

		// boton Finalizar
		JButton botonFinalizar = new JButton("<html>Finalizar<html>");
		botonFinalizar.setBounds(341, 232, 85, 21);
		panel.add(botonFinalizar);

		botonFinalizar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new PantallaPrincipalUsuario(informacionUsuario);
				frame.setVisible(false);
			}
		});

		// boton cambiar altura
		JButton botonCambiarAltura = new JButton("<html>CAMBIAR ALTURA<html>");
		botonCambiarAltura.setBounds(134, 70, 156, 31);
		panel.add(botonCambiarAltura);

		botonCambiarAltura.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new CambiarDatosAltura(informacionUsuario);
				frame.setVisible(false);
			}
		});

		// boton cambiar peso
		JButton botonCambiarPeso = new JButton("<html>CAMBIAR PESO<html>");
		botonCambiarPeso.setBounds(134, 111, 156, 31);
		panel.add(botonCambiarPeso);

		botonCambiarPeso.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new CambiarDatosPeso(informacionUsuario);
				frame.setVisible(false);
			}
		});

		// boton cambiar genero
		JButton botonCambiarGenero = new JButton("<html>CAMBIAR GÉNERO<html>");
		botonCambiarGenero.setBounds(134, 151, 156, 31);
		panel.add(botonCambiarGenero);

		botonCambiarGenero.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new CambiarDatosGenero(informacionUsuario);
				frame.setVisible(false);
			}
		});
		
		JLabel etiquetaFondo = new JLabel();
		BufferedImage imagenFondo = null;

		try {
			imagenFondo = ImageIO.read(getClass().getResource("/imagenFondoVioleta.png"));
			ImageIcon im = new ImageIcon(imagenFondo.getScaledInstance(imagenFondo.getWidth(), imagenFondo.getHeight(), Image.SCALE_SMOOTH));
			etiquetaFondo.setIcon(im);
		} 
		catch(Exception e) {

		}
		etiquetaFondo.setBounds(0, 0, 436, 496);
		panel.add(etiquetaFondo);

		frame.setVisible(true);
	}
}
