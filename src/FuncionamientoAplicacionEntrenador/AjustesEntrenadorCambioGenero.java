package FuncionamientoAplicacionEntrenador;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.SwingConstants;

import InformacionPersona.Entrenadores;
import javax.swing.JRadioButton;

public class AjustesEntrenadorCambioGenero {

	private JFrame frame;

	public AjustesEntrenadorCambioGenero(Entrenadores informacionEntrenador) {
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
		JLabel labelCambiarDatos = new JLabel("<html>CAMBIAR GÉNERO<html>");
		labelCambiarDatos.setHorizontalAlignment(SwingConstants.CENTER);
		labelCambiarDatos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelCambiarDatos.setBounds(27, 42, 365, 13);
		panel.add(labelCambiarDatos);

		// Genero del usuario
		JLabel labelGenero = new JLabel("<html>Su género:<html>");
		labelGenero.setBounds(61, 93, 93, 13);
		panel.add(labelGenero);

		String generoActual = informacionEntrenador.getSexo();
		JLabel labelGeneroActual = new JLabel(generoActual);
		labelGeneroActual.setBounds(211, 93, 102, 13);
		panel.add(labelGeneroActual);

		// Nuevo genero del usuario
		JLabel labelNuevoGenero = new JLabel("<html>Seleccione su nuevo género:<html>");
		labelNuevoGenero.setBounds(61, 128, 191, 13);
		panel.add(labelNuevoGenero);

		JRadioButton botonGeneroMasculino = new JRadioButton("<html>Masculino<html>");
		botonGeneroMasculino.setBounds(92, 151, 103, 21);
		botonGeneroMasculino.setOpaque(false);
		panel.add(botonGeneroMasculino);

		JRadioButton botonGeneroFemenino = new JRadioButton("<html>Femenino<html>");
		botonGeneroFemenino.setBounds(225, 151, 103, 21);
		botonGeneroFemenino.setOpaque(false);
		panel.add(botonGeneroFemenino);

		ButtonGroup botonesGeneros = new ButtonGroup();
		botonesGeneros.add(botonGeneroMasculino);
		botonesGeneros.add(botonGeneroFemenino);

		// boton Atras
		JButton botonAtras = new JButton("<html>Atrás<html>");
		botonAtras.setBounds(10, 232, 85, 21);
		panel.add(botonAtras);

		botonAtras.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int resp = JOptionPane.showOptionDialog(null, "¿Está seguro?", "Alerta!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] {"Sí", "No"}, "Sí");
				if (resp == 0) {
					new AjustesEntrenador(informacionEntrenador);
					frame.setVisible(false);
				}
			}
		});

		// boton Finalizar
		JButton botonFinalizar = new JButton("<html>Finalizar<html>");
		botonFinalizar.setBounds(341, 232, 85, 21);
		panel.add(botonFinalizar);

		botonFinalizar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!botonGeneroMasculino.isSelected() && !botonGeneroFemenino.isSelected()) {
					JOptionPane.showMessageDialog(null, "Existen campos vacíos. Inténtelo de nuevo");
				} else {
					if (botonGeneroMasculino.isSelected()) {
						System.out.println("Genero usuario antes de cambiarlo: " + informacionEntrenador.getSexo());
						informacionEntrenador.setSexo("Masculino");
						System.out.println("Genero usuario despues de cambiarlo: " + informacionEntrenador.getSexo());
					}
					else if (botonGeneroFemenino.isSelected()) {
						System.out.println("Genero usuario antes de cambiarlo: " + informacionEntrenador.getSexo());
						informacionEntrenador.setSexo("Femenino");
						System.out.println("Genero usuario despues de cambiarlo: " + informacionEntrenador.getSexo());
					}
					Entrenadores.guardarUsuariosEntrenadoresEnBaseDatos();
					new AjustesEntrenador(informacionEntrenador);
					frame.setVisible(false);
				}
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
