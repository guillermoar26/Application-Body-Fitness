package FuncionamientoAplicacionEntrenador;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;

import DietasCuatroComidasDelDia.Domingo;
import DietasCuatroComidasDelDia.Jueves;
import DietasCuatroComidasDelDia.Lunes;
import DietasCuatroComidasDelDia.Martes;
import DietasCuatroComidasDelDia.Miercoles;
import DietasCuatroComidasDelDia.Sabado;
import DietasCuatroComidasDelDia.Viernes;
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

public class AnadirDietas {

	private JFrame frame;
	private JTextField texto_tipo_dieta;
	private JTextField texto_dia_semana;
	private JTextField texto_desayuno;
	private JTextField texto_comida;
	private JTextField texto_almuerzo;
	private JTextField texto_cena;

	public AnadirDietas(Entrenadores informacionEntrenador) {
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

		JLabel titulo = new JLabel("<html>A\u00F1adir Dieta<html>");
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		titulo.setBounds(114, 10, 240, 20);
		panel.add(titulo);

		JLabel tipo_dieta = new JLabel("<html>Tipo de dieta<html>");
		tipo_dieta.setBounds(66, 56, 90, 17);
		panel.add(tipo_dieta);

		JLabel dia_semana = new JLabel("<html>D\u00EDa de la semana<html>");
		dia_semana.setBounds(66, 92, 103, 14);
		panel.add(dia_semana);

		texto_tipo_dieta = new JTextField();
		texto_tipo_dieta.setBounds(179, 50, 147, 20);
		panel.add(texto_tipo_dieta);
		texto_tipo_dieta.setColumns(10);

		texto_dia_semana = new JTextField();
		texto_dia_semana.setBounds(179, 86, 147, 20);
		panel.add(texto_dia_semana);
		texto_dia_semana.setColumns(10);

		JLabel desayuno = new JLabel("<html>Desayuno<html>");
		desayuno.setBounds(66, 125, 70, 14);
		panel.add(desayuno);

		texto_desayuno = new JTextField();
		texto_desayuno.setBounds(179, 119, 147, 20);
		panel.add(texto_desayuno);
		texto_desayuno.setColumns(10);

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
		texto_comida.setBounds(179, 147, 147, 20);
		panel.add(texto_comida);
		texto_comida.setColumns(10);

		texto_almuerzo = new JTextField();
		texto_almuerzo.setBounds(179, 177, 147, 20);
		panel.add(texto_almuerzo);
		texto_almuerzo.setColumns(10);

		texto_cena = new JTextField();
		texto_cena.setBounds(179, 208, 147, 20);
		panel.add(texto_cena);
		texto_cena.setColumns(10);

		JButton botonAtras = new JButton("<html>Atr\u00E1s<html>");
		botonAtras.setBounds(12, 238, 89, 23);
		panel.add(botonAtras);

		JButton botonAnadir = new JButton("<html>A\u00F1adir<html>");
		botonAnadir.setBounds(335, 238, 89, 23);
		panel.add(botonAnadir);


		botonAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PantallaPrincipalEntrenador(informacionEntrenador);
				frame.setVisible(false);
			}
		});

		botonAnadir.addActionListener(new ActionListener() {
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
						if (diaDeLaSemana.equals("Lunes") || diaDeLaSemana.equals("Martes") || diaDeLaSemana.equals("Miercoles") || diaDeLaSemana.equals("Jueves") || diaDeLaSemana.equals("Viernes") || diaDeLaSemana.equals("Sabado") || diaDeLaSemana.equals("Sábado") || diaDeLaSemana.equals("Domingo")) {


							if (diaDeLaSemana.equals("Lunes")) {
								if (tipoDieta.equals("Ganar peso")) {
									Dietas.anadirNivel3(tipoDieta, diaDeLaSemana, "-Desayuno " + String.valueOf(Lunes.tamanoDietasGanarPeso() + 1), texto_desayuno.getText());
									Dietas.anadirNivel3(tipoDieta, diaDeLaSemana, "-Comida " + String.valueOf(Lunes.tamanoDietasGanarPeso() + 1), texto_comida.getText());
									Dietas.anadirNivel3(tipoDieta, diaDeLaSemana, "-Almuerzo " + String.valueOf(Lunes.tamanoDietasGanarPeso() + 1), texto_almuerzo.getText());
									Dietas.anadirNivel3(tipoDieta, diaDeLaSemana, "-Cena " + String.valueOf(Lunes.tamanoDietasGanarPeso() + 1), texto_cena.getText());
									new Lunes(tipoDieta, diaDeLaSemana, texto_desayuno.getText(), texto_comida.getText(), texto_almuerzo.getText(), texto_cena.getText());
								}
								else if (tipoDieta.equals("Mantenerme")) {
									Dietas.anadirNivel3(tipoDieta, diaDeLaSemana, "-Desayuno " + String.valueOf(Lunes.tamanoDietasMantenerme() + 1), texto_desayuno.getText());
									Dietas.anadirNivel3(tipoDieta, diaDeLaSemana, "-Comida " + String.valueOf(Lunes.tamanoDietasMantenerme() + 1), texto_comida.getText());
									Dietas.anadirNivel3(tipoDieta, diaDeLaSemana, "-Almuerzo " + String.valueOf(Lunes.tamanoDietasMantenerme() + 1), texto_almuerzo.getText());
									Dietas.anadirNivel3(tipoDieta, diaDeLaSemana, "-Cena " + String.valueOf(Lunes.tamanoDietasMantenerme() + 1), texto_cena.getText());
									new Lunes(tipoDieta, diaDeLaSemana, texto_desayuno.getText(), texto_comida.getText(), texto_almuerzo.getText(), texto_cena.getText());
								}

								else if (tipoDieta.equals("Perder peso")) {
									Dietas.anadirNivel3(tipoDieta, diaDeLaSemana, "-Desayuno " + String.valueOf(Lunes.tamanoDietasPerderPeso() + 1), texto_desayuno.getText());
									Dietas.anadirNivel3(tipoDieta, diaDeLaSemana, "-Comida " + String.valueOf(Lunes.tamanoDietasPerderPeso() + 1), texto_comida.getText());
									Dietas.anadirNivel3(tipoDieta, diaDeLaSemana, "-Almuerzo " + String.valueOf(Lunes.tamanoDietasPerderPeso() + 1), texto_almuerzo.getText());
									Dietas.anadirNivel3(tipoDieta, diaDeLaSemana, "-Cena " + String.valueOf(Lunes.tamanoDietasPerderPeso() + 1), texto_cena.getText());
									new Lunes(tipoDieta, diaDeLaSemana, texto_desayuno.getText(), texto_comida.getText(), texto_almuerzo.getText(), texto_cena.getText());
								}
							}
							else if (diaDeLaSemana.equals("Martes")) {
								if (tipoDieta.equals("Ganar peso")) {
									Dietas.anadirNivel3(tipoDieta, diaDeLaSemana, "-Desayuno " + String.valueOf(Martes.tamanoDietasGanarPeso() + 1), texto_desayuno.getText());
									Dietas.anadirNivel3(tipoDieta, diaDeLaSemana, "-Comida " + String.valueOf(Martes.tamanoDietasGanarPeso() + 1), texto_comida.getText());
									Dietas.anadirNivel3(tipoDieta, diaDeLaSemana, "-Almuerzo " + String.valueOf(Martes.tamanoDietasGanarPeso() + 1), texto_almuerzo.getText());
									Dietas.anadirNivel3(tipoDieta, diaDeLaSemana, "-Cena " + String.valueOf(Martes.tamanoDietasGanarPeso() + 1), texto_cena.getText());
									new Martes(tipoDieta, diaDeLaSemana, texto_desayuno.getText(), texto_comida.getText(), texto_almuerzo.getText(), texto_cena.getText());
								}

								else if (tipoDieta.equals("Mantenerme")) {
									Dietas.anadirNivel3(tipoDieta, diaDeLaSemana, "-Desayuno " + String.valueOf(Martes.tamanoDietasMantenerme() + 1), texto_desayuno.getText());
									Dietas.anadirNivel3(tipoDieta, diaDeLaSemana, "-Comida " + String.valueOf(Martes.tamanoDietasMantenerme() + 1), texto_comida.getText());
									Dietas.anadirNivel3(tipoDieta, diaDeLaSemana, "-Almuerzo " + String.valueOf(Martes.tamanoDietasMantenerme() + 1), texto_almuerzo.getText());
									Dietas.anadirNivel3(tipoDieta, diaDeLaSemana, "-Cena " + String.valueOf(Martes.tamanoDietasMantenerme() + 1), texto_cena.getText());
									new Martes(tipoDieta, diaDeLaSemana, texto_desayuno.getText(), texto_comida.getText(), texto_almuerzo.getText(), texto_cena.getText());
								}

								else if (tipoDieta.equals("Perder peso")) {
									Dietas.anadirNivel3(tipoDieta, diaDeLaSemana, "-Desayuno " + String.valueOf(Martes.tamanoDietasPerderPeso() + 1), texto_desayuno.getText());
									Dietas.anadirNivel3(tipoDieta, diaDeLaSemana, "-Comida " + String.valueOf(Martes.tamanoDietasPerderPeso() + 1), texto_comida.getText());
									Dietas.anadirNivel3(tipoDieta, diaDeLaSemana, "-Almuerzo " + String.valueOf(Martes.tamanoDietasPerderPeso() + 1), texto_almuerzo.getText());
									Dietas.anadirNivel3(tipoDieta, diaDeLaSemana, "-Cena " + String.valueOf(Martes.tamanoDietasPerderPeso() + 1), texto_cena.getText());
									new Martes(tipoDieta, diaDeLaSemana, texto_desayuno.getText(), texto_comida.getText(), texto_almuerzo.getText(), texto_cena.getText());
								}
							}

							else if (diaDeLaSemana.equals("Miercoles")) {
								if (tipoDieta.equals("Ganar peso")) {
									Dietas.anadirNivel3(tipoDieta, diaDeLaSemana, "-Desayuno " + String.valueOf(Miercoles.tamanoDietasGanarPeso() + 1), texto_desayuno.getText());
									Dietas.anadirNivel3(tipoDieta, diaDeLaSemana, "-Comida " + String.valueOf(Miercoles.tamanoDietasGanarPeso() + 1), texto_comida.getText());
									Dietas.anadirNivel3(tipoDieta, diaDeLaSemana, "-Almuerzo " + String.valueOf(Miercoles.tamanoDietasGanarPeso() + 1), texto_almuerzo.getText());
									Dietas.anadirNivel3(tipoDieta, diaDeLaSemana, "-Cena " + String.valueOf(Miercoles.tamanoDietasGanarPeso() + 1), texto_cena.getText());
									new Miercoles(tipoDieta, diaDeLaSemana, texto_desayuno.getText(), texto_comida.getText(), texto_almuerzo.getText(), texto_cena.getText());
								}

								else if (tipoDieta.equals("Mantenerme")) {
									Dietas.anadirNivel3(tipoDieta, diaDeLaSemana, "-Desayuno " + String.valueOf(Miercoles.tamanoDietasMantenerme() + 1), texto_desayuno.getText());
									Dietas.anadirNivel3(tipoDieta, diaDeLaSemana, "-Comida " + String.valueOf(Miercoles.tamanoDietasMantenerme() + 1), texto_comida.getText());
									Dietas.anadirNivel3(tipoDieta, diaDeLaSemana, "-Almuerzo " + String.valueOf(Miercoles.tamanoDietasMantenerme() + 1), texto_almuerzo.getText());
									Dietas.anadirNivel3(tipoDieta, diaDeLaSemana, "-Cena " + String.valueOf(Miercoles.tamanoDietasMantenerme() + 1), texto_cena.getText());
									new Miercoles(tipoDieta, diaDeLaSemana, texto_desayuno.getText(), texto_comida.getText(), texto_almuerzo.getText(), texto_cena.getText());
								}

								else if (tipoDieta.equals("Perder peso")) {
									Dietas.anadirNivel3(tipoDieta, diaDeLaSemana, "-Desayuno " + String.valueOf(Miercoles.tamanoDietasPerderPeso() + 1), texto_desayuno.getText());
									Dietas.anadirNivel3(tipoDieta, diaDeLaSemana, "-Comida " + String.valueOf(Miercoles.tamanoDietasPerderPeso() + 1), texto_comida.getText());
									Dietas.anadirNivel3(tipoDieta, diaDeLaSemana, "-Almuerzo " + String.valueOf(Miercoles.tamanoDietasPerderPeso() + 1), texto_almuerzo.getText());
									Dietas.anadirNivel3(tipoDieta, diaDeLaSemana, "-Cena " + String.valueOf(Miercoles.tamanoDietasPerderPeso() + 1), texto_cena.getText());
									new Miercoles(tipoDieta, diaDeLaSemana, texto_desayuno.getText(), texto_comida.getText(), texto_almuerzo.getText(), texto_cena.getText());
								}
							}

							else if (diaDeLaSemana.equals("Jueves")) {
								if (tipoDieta.equals("Ganar peso")) {
									Dietas.anadirNivel3(tipoDieta, diaDeLaSemana, "-Desayuno " + String.valueOf(Jueves.tamanoDietasGanarPeso() + 1), texto_desayuno.getText());
									Dietas.anadirNivel3(tipoDieta, diaDeLaSemana, "-Comida " + String.valueOf(Jueves.tamanoDietasGanarPeso() + 1), texto_comida.getText());
									Dietas.anadirNivel3(tipoDieta, diaDeLaSemana, "-Almuerzo " + String.valueOf(Jueves.tamanoDietasGanarPeso() + 1), texto_almuerzo.getText());
									Dietas.anadirNivel3(tipoDieta, diaDeLaSemana, "-Cena " + String.valueOf(Jueves.tamanoDietasGanarPeso() + 1), texto_cena.getText());
									new Jueves(tipoDieta, diaDeLaSemana, texto_desayuno.getText(), texto_comida.getText(), texto_almuerzo.getText(), texto_cena.getText());
								}
								else if (tipoDieta.equals("Mantenerme")) {
									Dietas.anadirNivel3(tipoDieta, diaDeLaSemana, "-Desayuno " + String.valueOf(Jueves.tamanoDietasMantenerme() + 1), texto_desayuno.getText());
									Dietas.anadirNivel3(tipoDieta, diaDeLaSemana, "-Comida " + String.valueOf(Jueves.tamanoDietasMantenerme() + 1), texto_comida.getText());
									Dietas.anadirNivel3(tipoDieta, diaDeLaSemana, "-Almuerzo " + String.valueOf(Jueves.tamanoDietasMantenerme() + 1), texto_almuerzo.getText());
									Dietas.anadirNivel3(tipoDieta, diaDeLaSemana, "-Cena " + String.valueOf(Jueves.tamanoDietasMantenerme() + 1), texto_cena.getText());
									new Jueves(tipoDieta, diaDeLaSemana, texto_desayuno.getText(), texto_comida.getText(), texto_almuerzo.getText(), texto_cena.getText());
								}

								else if (tipoDieta.equals("Perder peso")) {
									Dietas.anadirNivel3(tipoDieta, diaDeLaSemana, "-Desayuno " + String.valueOf(Jueves.tamanoDietasPerderPeso() + 1), texto_desayuno.getText());
									Dietas.anadirNivel3(tipoDieta, diaDeLaSemana, "-Comida " + String.valueOf(Jueves.tamanoDietasPerderPeso() + 1), texto_comida.getText());
									Dietas.anadirNivel3(tipoDieta, diaDeLaSemana, "-Almuerzo " + String.valueOf(Jueves.tamanoDietasPerderPeso() + 1), texto_almuerzo.getText());
									Dietas.anadirNivel3(tipoDieta, diaDeLaSemana, "-Cena " + String.valueOf(Jueves.tamanoDietasPerderPeso() + 1), texto_cena.getText());
									new Jueves(tipoDieta, diaDeLaSemana, texto_desayuno.getText(), texto_comida.getText(), texto_almuerzo.getText(), texto_cena.getText());
								}
							}

							else if (diaDeLaSemana.equals("Viernes")) {
								if (tipoDieta.equals("Ganar peso")) {
									Dietas.anadirNivel3(tipoDieta, diaDeLaSemana, "-Desayuno " + String.valueOf(Viernes.tamanoDietasGanarPeso() + 1), texto_desayuno.getText());
									Dietas.anadirNivel3(tipoDieta, diaDeLaSemana, "-Comida " + String.valueOf(Viernes.tamanoDietasGanarPeso() + 1), texto_comida.getText());
									Dietas.anadirNivel3(tipoDieta, diaDeLaSemana, "-Almuerzo " + String.valueOf(Viernes.tamanoDietasGanarPeso() + 1), texto_almuerzo.getText());
									Dietas.anadirNivel3(tipoDieta, diaDeLaSemana, "-Cena " + String.valueOf(Viernes.tamanoDietasGanarPeso() + 1), texto_cena.getText());
									new Viernes(tipoDieta, diaDeLaSemana, texto_desayuno.getText(), texto_comida.getText(), texto_almuerzo.getText(), texto_cena.getText());
								}
								else if (tipoDieta.equals("Mantenerme")) {
									Dietas.anadirNivel3(tipoDieta, diaDeLaSemana, "-Desayuno " + String.valueOf(Viernes.tamanoDietasMantenerme() + 1), texto_desayuno.getText());
									Dietas.anadirNivel3(tipoDieta, diaDeLaSemana, "-Comida " + String.valueOf(Viernes.tamanoDietasMantenerme() + 1), texto_comida.getText());
									Dietas.anadirNivel3(tipoDieta, diaDeLaSemana, "-Almuerzo " + String.valueOf(Viernes.tamanoDietasMantenerme() + 1), texto_almuerzo.getText());
									Dietas.anadirNivel3(tipoDieta, diaDeLaSemana, "-Cena " + String.valueOf(Viernes.tamanoDietasMantenerme() + 1), texto_cena.getText());
									new Viernes(tipoDieta, diaDeLaSemana, texto_desayuno.getText(), texto_comida.getText(), texto_almuerzo.getText(), texto_cena.getText());
								}

								else if (tipoDieta.equals("Perder peso")) {
									Dietas.anadirNivel3(tipoDieta, diaDeLaSemana, "-Desayuno " + String.valueOf(Viernes.tamanoDietasPerderPeso() + 1), texto_desayuno.getText());
									Dietas.anadirNivel3(tipoDieta, diaDeLaSemana, "-Comida " + String.valueOf(Viernes.tamanoDietasPerderPeso() + 1), texto_comida.getText());
									Dietas.anadirNivel3(tipoDieta, diaDeLaSemana, "-Almuerzo " + String.valueOf(Viernes.tamanoDietasPerderPeso() + 1), texto_almuerzo.getText());
									Dietas.anadirNivel3(tipoDieta, diaDeLaSemana, "-Cena " + String.valueOf(Viernes.tamanoDietasPerderPeso() + 1), texto_cena.getText());
									new Viernes(tipoDieta, diaDeLaSemana, texto_desayuno.getText(), texto_comida.getText(), texto_almuerzo.getText(), texto_cena.getText());
								}
							}

							else if (diaDeLaSemana.equals("Sabado") || diaDeLaSemana.equals("Sábado")) {
								if (tipoDieta.equals("Ganar peso")) {
									Dietas.anadirNivel3(tipoDieta, diaDeLaSemana, "-Desayuno " + String.valueOf(Sabado.tamanoDietasGanarPeso() + 1), texto_desayuno.getText());
									Dietas.anadirNivel3(tipoDieta, diaDeLaSemana, "-Comida " + String.valueOf(Sabado.tamanoDietasGanarPeso() + 1), texto_comida.getText());
									Dietas.anadirNivel3(tipoDieta, diaDeLaSemana, "-Almuerzo " + String.valueOf(Sabado.tamanoDietasGanarPeso() + 1), texto_almuerzo.getText());
									Dietas.anadirNivel3(tipoDieta, diaDeLaSemana, "-Cena " + String.valueOf(Sabado.tamanoDietasGanarPeso() + 1), texto_cena.getText());
									new Sabado(tipoDieta, diaDeLaSemana, texto_desayuno.getText(), texto_comida.getText(), texto_almuerzo.getText(), texto_cena.getText());
								}
								else if (tipoDieta.equals("Mantenerme")) {
									Dietas.anadirNivel3(tipoDieta, diaDeLaSemana, "-Desayuno " + String.valueOf(Sabado.tamanoDietasMantenerme() + 1), texto_desayuno.getText());
									Dietas.anadirNivel3(tipoDieta, diaDeLaSemana, "-Comida " + String.valueOf(Sabado.tamanoDietasMantenerme() + 1), texto_comida.getText());
									Dietas.anadirNivel3(tipoDieta, diaDeLaSemana, "-Almuerzo " + String.valueOf(Sabado.tamanoDietasMantenerme() + 1), texto_almuerzo.getText());
									Dietas.anadirNivel3(tipoDieta, diaDeLaSemana, "-Cena " + String.valueOf(Sabado.tamanoDietasMantenerme() + 1), texto_cena.getText());
									new Sabado(tipoDieta, diaDeLaSemana, texto_desayuno.getText(), texto_comida.getText(), texto_almuerzo.getText(), texto_cena.getText());
								}

								else if (tipoDieta.equals("Perder peso")) {
									Dietas.anadirNivel3(tipoDieta, diaDeLaSemana, "-Desayuno " + String.valueOf(Sabado.tamanoDietasPerderPeso() + 1), texto_desayuno.getText());
									Dietas.anadirNivel3(tipoDieta, diaDeLaSemana, "-Comida " + String.valueOf(Sabado.tamanoDietasPerderPeso() + 1), texto_comida.getText());
									Dietas.anadirNivel3(tipoDieta, diaDeLaSemana, "-Almuerzo " + String.valueOf(Sabado.tamanoDietasPerderPeso() + 1), texto_almuerzo.getText());
									Dietas.anadirNivel3(tipoDieta, diaDeLaSemana, "-Cena " + String.valueOf(Sabado.tamanoDietasPerderPeso() + 1), texto_cena.getText());
									new Sabado(tipoDieta, diaDeLaSemana, texto_desayuno.getText(), texto_comida.getText(), texto_almuerzo.getText(), texto_cena.getText());
								}
							}

							else if (diaDeLaSemana.equals("Domingo")) {
								if (tipoDieta.equals("Ganar peso")) {
									Dietas.anadirNivel3(tipoDieta, diaDeLaSemana, "-Desayuno " + String.valueOf(Domingo.tamanoDietasGanarPeso() + 1), texto_desayuno.getText());
									Dietas.anadirNivel3(tipoDieta, diaDeLaSemana, "-Comida " + String.valueOf(Domingo.tamanoDietasGanarPeso() + 1), texto_comida.getText());
									Dietas.anadirNivel3(tipoDieta, diaDeLaSemana, "-Almuerzo " + String.valueOf(Domingo.tamanoDietasGanarPeso() + 1), texto_almuerzo.getText());
									Dietas.anadirNivel3(tipoDieta, diaDeLaSemana, "-Cena " + String.valueOf(Domingo.tamanoDietasGanarPeso() + 1), texto_cena.getText());
									new Domingo(tipoDieta, diaDeLaSemana, texto_desayuno.getText(), texto_comida.getText(), texto_almuerzo.getText(), texto_cena.getText());
								}
								else if (tipoDieta.equals("Mantenerme")) {
									Dietas.anadirNivel3(tipoDieta, diaDeLaSemana, "-Desayuno " + String.valueOf(Domingo.tamanoDietasMantenerme() + 1), texto_desayuno.getText());
									Dietas.anadirNivel3(tipoDieta, diaDeLaSemana, "-Comida " + String.valueOf(Domingo.tamanoDietasMantenerme() + 1), texto_comida.getText());
									Dietas.anadirNivel3(tipoDieta, diaDeLaSemana, "-Almuerzo " + String.valueOf(Domingo.tamanoDietasMantenerme() + 1), texto_almuerzo.getText());
									Dietas.anadirNivel3(tipoDieta, diaDeLaSemana, "-Cena " + String.valueOf(Domingo.tamanoDietasMantenerme() + 1), texto_cena.getText());
									new Domingo(tipoDieta, diaDeLaSemana, texto_desayuno.getText(), texto_comida.getText(), texto_almuerzo.getText(), texto_cena.getText());
								}

								else if (tipoDieta.equals("Perder peso")) {
									Dietas.anadirNivel3(tipoDieta, diaDeLaSemana, "-Desayuno " + String.valueOf(Domingo.tamanoDietasPerderPeso() + 1), texto_desayuno.getText());
									Dietas.anadirNivel3(tipoDieta, diaDeLaSemana, "-Comida " + String.valueOf(Domingo.tamanoDietasPerderPeso() + 1), texto_comida.getText());
									Dietas.anadirNivel3(tipoDieta, diaDeLaSemana, "-Almuerzo " + String.valueOf(Domingo.tamanoDietasPerderPeso() + 1), texto_almuerzo.getText());
									Dietas.anadirNivel3(tipoDieta, diaDeLaSemana, "-Cena " + String.valueOf(Domingo.tamanoDietasPerderPeso() + 1), texto_cena.getText());
									new Domingo(tipoDieta, diaDeLaSemana, texto_desayuno.getText(), texto_comida.getText(), texto_almuerzo.getText(), texto_cena.getText());
								}
							}
							Dietas.guardarDietasEnBaseDatos();
							// AQUI HACE FALTA TAMBIEN PONER LA COMIDA, EL ALMUERZO Y LA CENA
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