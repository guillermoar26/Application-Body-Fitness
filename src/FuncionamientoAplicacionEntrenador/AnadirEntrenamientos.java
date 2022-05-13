package FuncionamientoAplicacionEntrenador;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;

import InformacionAplicacionGeneral.Entrenamiento;
import InformacionPersona.Entrenadores;
import TiposEjerciciosClases.Definir;
import TiposEjerciciosClases.GanarMusculo;
import TiposEjerciciosClases.Tonificar;

import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.event.ActionEvent;


public class AnadirEntrenamientos {
	private JFrame frame;
	private JTextField textoTipoEntrenamiento;
	private JTextField textoGrupoMuscular;
	private JTextField textoNombreEjercicio;
	private JTextField textoDescripcionEjercicio;
	private JTextField textoSeries;
	private JTextField textoRepeticiones;


	public AnadirEntrenamientos(Entrenadores informacionEntrenador) {
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

		JLabel lblAadirEntrenamiento = new JLabel("<html>A\u00F1adir Entrenamiento<html>");
		lblAadirEntrenamiento.setHorizontalAlignment(SwingConstants.CENTER);
		lblAadirEntrenamiento.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAadirEntrenamiento.setBounds(96, 11, 273, 28);
		panel.add(lblAadirEntrenamiento);

		textoTipoEntrenamiento = new JTextField();
		textoTipoEntrenamiento.setColumns(10);
		textoTipoEntrenamiento.setBounds(163, 49, 147, 20);
		panel.add(textoTipoEntrenamiento);

		textoGrupoMuscular = new JTextField();
		textoGrupoMuscular.setColumns(10);
		textoGrupoMuscular.setBounds(163, 80, 147, 20);
		panel.add(textoGrupoMuscular);

		JLabel lblTipoDeEntrenamiento = new JLabel("<html>Tipo de entrenamiento<html>");
		lblTipoDeEntrenamiento.setBounds(39, 52, 147, 17);
		panel.add(lblTipoDeEntrenamiento);

		textoNombreEjercicio = new JTextField();
		textoNombreEjercicio.setColumns(10);
		textoNombreEjercicio.setBounds(163, 111, 147, 20);
		panel.add(textoNombreEjercicio);

		JLabel lblGrupoMuscular = new JLabel("<html>Grupo muscular<html>");
		lblGrupoMuscular.setBounds(39, 81, 113, 17);
		panel.add(lblGrupoMuscular);

		JLabel lblNombreDelEjercicio = new JLabel("<html>Nombre del ejercicio<html>");
		lblNombreDelEjercicio.setBounds(39, 110, 125, 26);
		panel.add(lblNombreDelEjercicio);

		JButton botonAtras = new JButton("<html>Atr\u00E1s<html>");
		botonAtras.setBounds(27, 239, 89, 23);
		panel.add(botonAtras);

		JLabel lblNewLabel = new JLabel("<html>Descripci\u00F3n del ejercicio<html>");
		lblNewLabel.setBounds(39, 144, 125, 26);
		panel.add(lblNewLabel);

		textoDescripcionEjercicio = new JTextField();
		textoDescripcionEjercicio.setBounds(162, 148, 148, 20);
		panel.add(textoDescripcionEjercicio);
		textoDescripcionEjercicio.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("<html>Series<html>");
		lblNewLabel_1.setBounds(39, 176, 58, 26);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("<html>Repeticiones<html>");
		lblNewLabel_2.setBounds(39, 208, 77, 29);
		panel.add(lblNewLabel_2);

		textoSeries = new JTextField();
		textoSeries.setBounds(163, 179, 147, 20);
		panel.add(textoSeries);
		textoSeries.setColumns(10);

		textoRepeticiones = new JTextField();
		textoRepeticiones.setBounds(163, 210, 147, 20);
		panel.add(textoRepeticiones);
		textoRepeticiones.setColumns(10);

		JButton botonAnadir = new JButton("<html>A\u00F1adir<html>");
		botonAnadir.setBounds(347, 239, 89, 23);
		panel.add(botonAnadir);


		botonAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PantallaPrincipalEntrenador(informacionEntrenador);
				frame.setVisible(false);
			}
		});

		botonAnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textoTipoEntrenamiento.getText().equals("") || textoGrupoMuscular.getText().equals("") || textoNombreEjercicio.getText().equals("") || textoDescripcionEjercicio.getText().equals("") || textoSeries.getText().equals("") ||textoRepeticiones.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "<html>Debes introducir todos los datos<html>", null, JOptionPane.ERROR_MESSAGE);
				}
				else {
					String tipoEntrenamiento = textoTipoEntrenamiento.getText();
					String primeraLetra = tipoEntrenamiento.substring(0, 1);
					String restoDeLetras = tipoEntrenamiento.substring(1, tipoEntrenamiento.length());

					primeraLetra = primeraLetra.toUpperCase();
					tipoEntrenamiento = primeraLetra + restoDeLetras;
					System.out.println("The modified string is: " + tipoEntrenamiento);

					if (tipoEntrenamiento.equals("Definir") || tipoEntrenamiento.equals("Ganar musculo") || tipoEntrenamiento.equals("Tonificar")) {
						String grupoMuscular = textoGrupoMuscular.getText();
						primeraLetra = grupoMuscular.substring(0, 1);
						restoDeLetras = grupoMuscular.substring(1, grupoMuscular.length());

						primeraLetra = primeraLetra.toUpperCase();
						grupoMuscular = primeraLetra + restoDeLetras;
						System.out.println("The modified string is: " + grupoMuscular);
						if (grupoMuscular.equals("Hombros y espalda") || grupoMuscular.equals("Pierna") || grupoMuscular.equals("Brazo") || grupoMuscular.equals("Pecho") || grupoMuscular.equals("Abdominales") || grupoMuscular.equals("Glúteos") || grupoMuscular.equals("Gluteos")) {
							String nombreEjercicio = textoNombreEjercicio.getText();
							primeraLetra = nombreEjercicio.substring(0, 1);
							restoDeLetras = nombreEjercicio.substring(1, nombreEjercicio.length());

							primeraLetra = primeraLetra.toUpperCase();
							nombreEjercicio = primeraLetra + restoDeLetras;
							System.out.println("The modified string is: " + nombreEjercicio);



							if (tipoEntrenamiento.equals("Definir")) {
								if (grupoMuscular.equals("Hombros y espalda")) {
									new Definir(tipoEntrenamiento, grupoMuscular, nombreEjercicio, textoDescripcionEjercicio.getText(), textoSeries.getText(), textoRepeticiones.getText(), "", "");
									Entrenamiento.anadirNivel3(tipoEntrenamiento, grupoMuscular, "-Nombre ejercicio " + String.valueOf(Definir.tamanoEntrenamientoHombrosYEspalda() + 1), nombreEjercicio);
									Entrenamiento.anadirNivel3(tipoEntrenamiento, grupoMuscular, "-Descripcion ejercicio " + String.valueOf(Definir.tamanoEntrenamientoHombrosYEspalda() + 1), textoDescripcionEjercicio.getText());
									Entrenamiento.anadirNivel3(tipoEntrenamiento, grupoMuscular, "-Series ejercicio " + String.valueOf(Definir.tamanoEntrenamientoHombrosYEspalda() + 1), textoSeries.getText());
									Entrenamiento.anadirNivel3(tipoEntrenamiento, grupoMuscular, "-Repeticiones ejercicio " + String.valueOf(Definir.tamanoEntrenamientoHombrosYEspalda() + 1),  textoRepeticiones.getText());
									Entrenamiento.anadirNivel3(tipoEntrenamiento, grupoMuscular, "-Direccion Imagen ejercicio " + String.valueOf(Definir.tamanoEntrenamientoHombrosYEspalda() + 1),  "");
									Entrenamiento.anadirNivel3(tipoEntrenamiento, grupoMuscular, "-Direccion Video ejercicio " + String.valueOf(Definir.tamanoEntrenamientoHombrosYEspalda() + 1),  "");

								}
								else if (grupoMuscular.equals("Pierna")) {
									new Definir(tipoEntrenamiento, grupoMuscular, nombreEjercicio, textoDescripcionEjercicio.getText(), textoSeries.getText(), textoRepeticiones.getText(), "", "");
									Entrenamiento.anadirNivel3(tipoEntrenamiento, grupoMuscular, "-Nombre ejercicio " + String.valueOf(Definir.tamanoEntrenamientoPierna() + 1), nombreEjercicio);
									Entrenamiento.anadirNivel3(tipoEntrenamiento, grupoMuscular, "-Descripcion ejercicio " + String.valueOf(Definir.tamanoEntrenamientoPierna() + 1), textoDescripcionEjercicio.getText());
									Entrenamiento.anadirNivel3(tipoEntrenamiento, grupoMuscular, "-Series ejercicio " + String.valueOf(Definir.tamanoEntrenamientoPierna() + 1), textoSeries.getText());
									Entrenamiento.anadirNivel3(tipoEntrenamiento, grupoMuscular, "-Repeticiones ejercicio " + String.valueOf(Definir.tamanoEntrenamientoPierna() + 1),  textoRepeticiones.getText());
									Entrenamiento.anadirNivel3(tipoEntrenamiento, grupoMuscular, "-Direccion Imagen ejercicio " + String.valueOf(Definir.tamanoEntrenamientoPierna() + 1),  "");
									Entrenamiento.anadirNivel3(tipoEntrenamiento, grupoMuscular, "-Direccion Video ejercicio " + String.valueOf(Definir.tamanoEntrenamientoPierna() + 1),  "");
								}

							}
							else if (tipoEntrenamiento.equals("Ganar musculo")) {
								if (grupoMuscular.equals("Brazo")) {
									new GanarMusculo(tipoEntrenamiento, grupoMuscular, nombreEjercicio, textoDescripcionEjercicio.getText(), textoSeries.getText(), textoRepeticiones.getText(), "", "");
									Entrenamiento.anadirNivel3(tipoEntrenamiento, grupoMuscular, "-Nombre ejercicio " + String.valueOf(GanarMusculo.tamanoEntrenamientoBrazo() + 1), nombreEjercicio);
									Entrenamiento.anadirNivel3(tipoEntrenamiento, grupoMuscular, "-Descripcion ejercicio " + String.valueOf(GanarMusculo.tamanoEntrenamientoBrazo() + 1), textoDescripcionEjercicio.getText());
									Entrenamiento.anadirNivel3(tipoEntrenamiento, grupoMuscular, "-Series ejercicio " + String.valueOf(GanarMusculo.tamanoEntrenamientoBrazo() + 1), textoSeries.getText());
									Entrenamiento.anadirNivel3(tipoEntrenamiento, grupoMuscular, "-Repeticiones ejercicio " + String.valueOf(GanarMusculo.tamanoEntrenamientoBrazo() + 1),  textoRepeticiones.getText());
									Entrenamiento.anadirNivel3(tipoEntrenamiento, grupoMuscular, "-Direccion Imagen ejercicio " + String.valueOf(GanarMusculo.tamanoEntrenamientoBrazo() + 1),  "");
									Entrenamiento.anadirNivel3(tipoEntrenamiento, grupoMuscular, "-Direccion Video ejercicio " + String.valueOf(GanarMusculo.tamanoEntrenamientoBrazo() + 1),  "");
								}
								else if (grupoMuscular.equals("Pecho")) {
									new GanarMusculo(tipoEntrenamiento, grupoMuscular, nombreEjercicio, textoDescripcionEjercicio.getText(), textoSeries.getText(), textoRepeticiones.getText(), "", "");
									Entrenamiento.anadirNivel3(tipoEntrenamiento, grupoMuscular, "-Nombre ejercicio " + String.valueOf(GanarMusculo.tamanoEntrenamientoPecho() + 1), nombreEjercicio);
									Entrenamiento.anadirNivel3(tipoEntrenamiento, grupoMuscular, "-Descripcion ejercicio " + String.valueOf(GanarMusculo.tamanoEntrenamientoPecho() + 1), textoDescripcionEjercicio.getText());
									Entrenamiento.anadirNivel3(tipoEntrenamiento, grupoMuscular, "-Series ejercicio " + String.valueOf(GanarMusculo.tamanoEntrenamientoPecho() + 1), textoSeries.getText());
									Entrenamiento.anadirNivel3(tipoEntrenamiento, grupoMuscular, "-Repeticiones ejercicio " + String.valueOf(GanarMusculo.tamanoEntrenamientoPecho() + 1),  textoRepeticiones.getText());
									Entrenamiento.anadirNivel3(tipoEntrenamiento, grupoMuscular, "-Direccion Imagen ejercicio " + String.valueOf(GanarMusculo.tamanoEntrenamientoPecho() + 1),  "");
									Entrenamiento.anadirNivel3(tipoEntrenamiento, grupoMuscular, "-Direccion Video ejercicio " + String.valueOf(GanarMusculo.tamanoEntrenamientoPecho() + 1),  "");
								}
							}
							else if (tipoEntrenamiento.equals("Tonificar")) {
								if (grupoMuscular.equals("Abdominales")) {
									new Tonificar(tipoEntrenamiento, grupoMuscular, nombreEjercicio, textoDescripcionEjercicio.getText(), textoSeries.getText(), textoRepeticiones.getText(), "", "");
									Entrenamiento.anadirNivel3(tipoEntrenamiento, grupoMuscular, "-Nombre ejercicio " + String.valueOf(Tonificar.tamanoEntrenamientoAbdominales() + 1), nombreEjercicio);
									Entrenamiento.anadirNivel3(tipoEntrenamiento, grupoMuscular, "-Descripcion ejercicio " + String.valueOf(Tonificar.tamanoEntrenamientoAbdominales() + 1), textoDescripcionEjercicio.getText());
									Entrenamiento.anadirNivel3(tipoEntrenamiento, grupoMuscular, "-Series ejercicio " + String.valueOf(Tonificar.tamanoEntrenamientoAbdominales() + 1), textoSeries.getText());
									Entrenamiento.anadirNivel3(tipoEntrenamiento, grupoMuscular, "-Repeticiones ejercicio " + String.valueOf(Tonificar.tamanoEntrenamientoAbdominales() + 1),  textoRepeticiones.getText());
									Entrenamiento.anadirNivel3(tipoEntrenamiento, grupoMuscular, "-Direccion Imagen ejercicio " + String.valueOf(Tonificar.tamanoEntrenamientoAbdominales() + 1),  "");
									Entrenamiento.anadirNivel3(tipoEntrenamiento, grupoMuscular, "-Direccion Video ejercicio " + String.valueOf(Tonificar.tamanoEntrenamientoAbdominales() + 1),  "");
								}
								else if (grupoMuscular.equals("Gluteos") || grupoMuscular.equals("Glúteos")) {
									new Tonificar(tipoEntrenamiento, grupoMuscular, nombreEjercicio, textoDescripcionEjercicio.getText(), textoSeries.getText(), textoRepeticiones.getText(), "", "");
									Entrenamiento.anadirNivel3(tipoEntrenamiento, grupoMuscular, "-Nombre ejercicio " + String.valueOf(Tonificar.tamanoEntrenamientoGluteos() + 1), nombreEjercicio);
									Entrenamiento.anadirNivel3(tipoEntrenamiento, grupoMuscular, "-Descripcion ejercicio " + String.valueOf(Tonificar.tamanoEntrenamientoGluteos() + 1), textoDescripcionEjercicio.getText());
									Entrenamiento.anadirNivel3(tipoEntrenamiento, grupoMuscular, "-Series ejercicio " + String.valueOf(Tonificar.tamanoEntrenamientoGluteos() + 1), textoSeries.getText());
									Entrenamiento.anadirNivel3(tipoEntrenamiento, grupoMuscular, "-Repeticiones ejercicio " + String.valueOf(Tonificar.tamanoEntrenamientoGluteos() + 1),  textoRepeticiones.getText());
									Entrenamiento.anadirNivel3(tipoEntrenamiento, grupoMuscular, "-Direccion Imagen ejercicio " + String.valueOf(Tonificar.tamanoEntrenamientoGluteos() + 1),  "");
									Entrenamiento.anadirNivel3(tipoEntrenamiento, grupoMuscular, "-Direccion Video ejercicio " + String.valueOf(Tonificar.tamanoEntrenamientoGluteos() + 1),  "");
								}


							}


							Entrenamiento.guardarEntrenamientosEnBaseDatos();
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
