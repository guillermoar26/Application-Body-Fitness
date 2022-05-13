package FuncionamientoAplicacionEntrenador;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;

import DietasCuatroComidasDelDia.*;
import InformacionAplicacionGeneral.Dietas;
import InformacionPersona.Entrenadores;

import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class EliminarDietas {

	private JFrame frame;
	private JTextField texto_tipo_dieta;
	private JTextField texto_dia_semana;
	private JTextField texto_desayuno;
	private JTextField texto_comida;
	private JTextField texto_almuerzo;
	private JTextField texto_cena;


	public EliminarDietas(Entrenadores informacionEntrenador) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		// Imagen Logo
		JLabel etiquetaLogo = new JLabel();
		BufferedImage image = null;

		try {
			image = ImageIO.read(getClass().getResource("/logo.jpg"));
			ImageIcon imagenLogo = new ImageIcon(image.getScaledInstance(90, 71, Image.SCALE_SMOOTH));
			etiquetaLogo.setIcon(imagenLogo);	
		}

		catch (IOException e) {

		}		
		etiquetaLogo.setBounds(346, 11, 90, 71);
		panel.add(etiquetaLogo);

		JLabel titulo = new JLabel("<html>Eliminar Dieta<html>");
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		titulo.setBounds(114, 10, 240, 20);
		panel.add(titulo);

		JLabel tipo_dieta = new JLabel("<html>Tipo de dieta<html>");
		tipo_dieta.setBounds(66, 56, 106, 25);
		panel.add(tipo_dieta);

		JLabel dia_semana = new JLabel("<html>D\u00EDa de la semana<html>");
		dia_semana.setBounds(66, 92, 106, 17);
		panel.add(dia_semana);

		texto_tipo_dieta = new JTextField();
		texto_tipo_dieta.setColumns(10);
		texto_tipo_dieta.setBounds(179, 53, 147, 20);
		panel.add(texto_tipo_dieta);

		texto_dia_semana = new JTextField();
		texto_dia_semana.setColumns(10);
		texto_dia_semana.setBounds(179, 89, 147, 20);
		panel.add(texto_dia_semana);

		JLabel desayuno = new JLabel("<html>Desayuno<html>");
		desayuno.setBounds(66, 125, 70, 14);
		panel.add(desayuno);

		texto_desayuno = new JTextField();
		texto_desayuno.setColumns(10);
		texto_desayuno.setBounds(179, 122, 147, 20);
		panel.add(texto_desayuno);

		JLabel comida = new JLabel("<html>Comida<html>");
		comida.setBounds(66, 153, 46, 14);
		panel.add(comida);

		JLabel almuerzo = new JLabel("<html>Almuerzo<html>");
		almuerzo.setBounds(66, 183, 70, 14);
		panel.add(almuerzo);

		JLabel cena = new JLabel("<html>Cena<html>");
		cena.setBounds(66, 214, 46, 14);
		panel.add(cena);

		texto_comida = new JTextField();
		texto_comida.setColumns(10);
		texto_comida.setBounds(179, 150, 147, 20);
		panel.add(texto_comida);

		texto_almuerzo = new JTextField();
		texto_almuerzo.setColumns(10);
		texto_almuerzo.setBounds(179, 180, 147, 20);
		panel.add(texto_almuerzo);

		texto_cena = new JTextField();
		texto_cena.setColumns(10);
		texto_cena.setBounds(179, 211, 147, 20);
		panel.add(texto_cena);

		JButton botonAtras = new JButton("<html>Atr\u00E1s<html>");
		botonAtras.setBounds(12, 238, 89, 23);
		panel.add(botonAtras);

		JButton botonEliminar = new JButton("<html>Eliminar<html>");
		botonEliminar.setBounds(335, 238, 89, 23);
		panel.add(botonEliminar);

		botonAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PantallaPrincipalEntrenador(informacionEntrenador);
				frame.setVisible(false);
			}
		});


		botonEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (texto_tipo_dieta.getText().equals("") || texto_dia_semana.getText().equals("") || texto_desayuno.getText().equals("") || texto_comida.getText().equals("") || texto_almuerzo.getText().equals("") || texto_cena.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "<html>Debes introducir todos los datos<html>", null, JOptionPane.ERROR_MESSAGE);
				}
				else {
					String tipoDieta = texto_tipo_dieta.getText();
					String primeraLetra = tipoDieta.substring(0, 1);
					String restoDeLetras = tipoDieta.substring(1, tipoDieta.length());

					primeraLetra = primeraLetra.toUpperCase();
					tipoDieta = primeraLetra + restoDeLetras;
					System.out.println("The modified string is: " + tipoDieta);

					if (tipoDieta.equals("Ganar peso") || tipoDieta.equals("Mantenerme") || tipoDieta.equals("Perder peso")) {
						String diaDeLaSemana = texto_dia_semana.getText();
						primeraLetra = diaDeLaSemana.substring(0, 1);
						restoDeLetras = diaDeLaSemana.substring(1, diaDeLaSemana.length());

						primeraLetra = primeraLetra.toUpperCase();
						diaDeLaSemana = primeraLetra + restoDeLetras;
						System.out.println("The modified string is: " + diaDeLaSemana);
						if (diaDeLaSemana.equals("Lunes") || diaDeLaSemana.equals("Martes") || diaDeLaSemana.equals("Miercoles") || diaDeLaSemana.equals("Miércoles") || diaDeLaSemana.equals("Jueves") || diaDeLaSemana.equals("Viernes") || diaDeLaSemana.equals("Sabado") || diaDeLaSemana.equals("Sábado") || diaDeLaSemana.equals("Domingo")) {
							String desayuno = texto_desayuno.getText();
							primeraLetra = desayuno.substring(0, 1);
							restoDeLetras = desayuno.substring(1, desayuno.length());

							primeraLetra = primeraLetra.toUpperCase();
							desayuno = primeraLetra + restoDeLetras;
							System.out.println("The modified string is: " + desayuno);
							if (Lunes.existeDieta(desayuno) || Martes.existeDieta(desayuno) || Miercoles.existeDieta(desayuno) || Jueves.existeDieta(desayuno) || Viernes.existeDieta(desayuno) || Sabado.existeDieta(desayuno) || Domingo.existeDieta(desayuno)) {

								Dietas.eliminarBinomiosNivel3(tipoDieta, diaDeLaSemana, desayuno);
								Dietas.guardarDietasEnBaseDatos();
								if (diaDeLaSemana.equals("Lunes")) {
									Lunes.eliminarDietaLunes(desayuno);
								}
								else if (diaDeLaSemana.equals("Martes")) {
									Martes.eliminarDietaMartes(desayuno);
								}

								else if (diaDeLaSemana.equals("Miercoles") || diaDeLaSemana.equals("Miércoles")) {
									Miercoles.eliminarDietaMiercoles(desayuno);
								}

								else if (diaDeLaSemana.equals("Jueves")) {
									Jueves.eliminarDietaJueves(desayuno);
								}

								else if (diaDeLaSemana.equals("Viernes")) {
									Viernes.eliminarDietaViernes(desayuno);
								}

								else if (diaDeLaSemana.equals("Sabado") || diaDeLaSemana.equals("Sábado")) {
									Sabado.eliminarDietaSabado(desayuno);
								}

								else if (diaDeLaSemana.equals("Domingo")) {
									Domingo.eliminarDietaDomingo(desayuno);
								}
								
								// AQUI HACE FALTA TAMBIEN PONER LA COMIDA, EL ALMUERZO Y LA CENA
							}
							else {
								JOptionPane.showMessageDialog(null, "Esta dieta no esta en nuestra base de datos, introduce otro por favor", null, JOptionPane.WARNING_MESSAGE);
							}
						}
					}
					new PantallaPrincipalEntrenador(informacionEntrenador);
					frame.setVisible(false);
				}
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
