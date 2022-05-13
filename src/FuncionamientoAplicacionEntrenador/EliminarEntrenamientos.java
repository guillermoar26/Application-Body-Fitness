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

public class EliminarEntrenamientos {

	private JFrame frame;
	private JTextField textoTipoEntrenamiento;
	private JTextField textoGrupoMuscular;
	private JTextField textoNombreEjercicio;

	public EliminarEntrenamientos(Entrenadores informacionEntrenador) {
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

		JLabel lblEliminarEntrenamiento = new JLabel("<html>Eliminar Entrenamiento<html>");
		lblEliminarEntrenamiento.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminarEntrenamiento.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEliminarEntrenamiento.setBounds(30, 11, 414, 14);
		panel.add(lblEliminarEntrenamiento);

		textoTipoEntrenamiento = new JTextField();
		textoTipoEntrenamiento.setColumns(10);
		textoTipoEntrenamiento.setBounds(193, 70, 147, 20);
		panel.add(textoTipoEntrenamiento);

		textoGrupoMuscular = new JTextField();
		textoGrupoMuscular.setColumns(10);
		textoGrupoMuscular.setBounds(193, 105, 147, 20);
		panel.add(textoGrupoMuscular);

		JLabel lblTipoDeEntrenamiento = new JLabel("<html>Tipo de entrenamiento<html>");
		lblTipoDeEntrenamiento.setBounds(46, 70, 137, 24);
		panel.add(lblTipoDeEntrenamiento);

		textoNombreEjercicio = new JTextField();
		textoNombreEjercicio.setColumns(10);
		textoNombreEjercicio.setBounds(193, 141, 147, 20);
		panel.add(textoNombreEjercicio);

		JLabel lblGrupoMuscular = new JLabel("<html>Grupo muscular<html>");
		lblGrupoMuscular.setBounds(47, 105, 101, 25);
		panel.add(lblGrupoMuscular);

		JLabel lblNombreDelEjercicio = new JLabel("<html>Nombre del ejercicio<html>");
		lblNombreDelEjercicio.setBounds(47, 141, 136, 24);
		panel.add(lblNombreDelEjercicio);

		JButton boton_atras = new JButton("<html>Atr\u00E1s<html>");
		boton_atras.setBounds(47, 216, 89, 23);
		panel.add(boton_atras);

		JButton botonEliminar = new JButton("<html>Eliminar<html>");
		botonEliminar.setBounds(287, 216, 89, 23);
		panel.add(botonEliminar);

		boton_atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PantallaPrincipalEntrenador(informacionEntrenador);
				frame.setVisible(false);
			}
		});


		botonEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textoTipoEntrenamiento.getText().equals("") || textoGrupoMuscular.getText().equals("") || textoNombreEjercicio.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "<html>Debes introducir todos los datos<html>", null, JOptionPane.ERROR_MESSAGE);
				}
				else {

					if (Definir.existeEntrenamiento(textoNombreEjercicio.getText()) || GanarMusculo.existeEntrenamiento(textoNombreEjercicio.getText()) || Tonificar.existeEntrenamiento(textoNombreEjercicio.getText())) {
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
								Entrenamiento.eliminarBinomiosNivel3(tipoEntrenamiento, grupoMuscular, nombreEjercicio);

								if (tipoEntrenamiento.equals("Definir")) {
									Definir.eliminarEjercicioDefinir(nombreEjercicio);
								}
								else if (tipoEntrenamiento.equals("Ganar musculo")) {
									GanarMusculo.eliminarEjercicioGanarMusculo(nombreEjercicio);
								}
								else if (tipoEntrenamiento.equals("Tonificar")) {
									Tonificar.eliminarEjercicioTonificar(nombreEjercicio);
								}

								Entrenamiento.guardarEntrenamientosEnBaseDatos();


							}
						}
						new PantallaPrincipalEntrenador(informacionEntrenador);
						frame.setVisible(false);
					}

					else {
						JOptionPane.showMessageDialog(null, "Ese entrenamiento no esta en nuestra base de datos, introduce otro por favor", null, JOptionPane.WARNING_MESSAGE);
					}

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
