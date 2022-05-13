package FuncionamientoAplicacionEntrenador;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import InformacionAplicacionGeneral.Recomendacion;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;

import InformacionPersona.Usuario;
import TiposEjerciciosClases.Definir;
import TiposEjerciciosClases.GanarMusculo;
import TiposEjerciciosClases.Tonificar;
import InformacionPersona.Entrenadores;

public class AnadirRecomendacion {

	private JFrame frame;

	public Usuario usuario;
	public Entrenadores entrenador;

	private JTextField textFieldTipoEntrenamiento;
	private JTextField textFieldGrupoMuscular;
	private JTextField textFieldNombreEjercicio;
	private JTextField textFieldAnadirRecomendacion;

	public AnadirRecomendacion(Entrenadores informacionEntrenador) {
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

		// Titulo principal de la ventana
		JLabel textoTituloRecomendacion = new JLabel("<html>AÑADIR RECOMENDACIÓN<html>");
		textoTituloRecomendacion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textoTituloRecomendacion.setHorizontalAlignment(SwingConstants.CENTER);
		textoTituloRecomendacion.setBounds(10, 10, 416, 21);
		panel.add(textoTituloRecomendacion);

		// Tipo de entrenamiento
		JLabel labelTipoEntrenamiento = new JLabel("<html>Tipo de entrenamiento: <html>");
		labelTipoEntrenamiento.setBounds(51, 44, 134, 13);
		panel.add(labelTipoEntrenamiento);

		textFieldTipoEntrenamiento = new JTextField();
		textFieldTipoEntrenamiento.setBounds(195, 41, 148, 19);
		panel.add(textFieldTipoEntrenamiento);
		textFieldTipoEntrenamiento.setColumns(10);

		// Grupo muscular
		JLabel labelGrupoMuscular = new JLabel("<html>Grupo muscular: <html>");
		labelGrupoMuscular.setBounds(51, 87, 134, 13);
		panel.add(labelGrupoMuscular);

		textFieldGrupoMuscular = new JTextField();
		textFieldGrupoMuscular.setColumns(10);
		textFieldGrupoMuscular.setBounds(195, 84, 148, 19);
		panel.add(textFieldGrupoMuscular);

		// Nombre ejercicio
		JLabel labelNombreEjercicio = new JLabel("<html>Nombre ejercicio: <html>");
		labelNombreEjercicio.setBounds(51, 134, 134, 13);
		panel.add(labelNombreEjercicio);

		textFieldNombreEjercicio = new JTextField();
		textFieldNombreEjercicio.setColumns(10);
		textFieldNombreEjercicio.setBounds(195, 131, 148, 19);
		panel.add(textFieldNombreEjercicio);

		// Añadir recomendacion por parte del entrenador
		JLabel labelAnadirRecomendacion = new JLabel("<html>Añadir recomendación: <html>");
		labelAnadirRecomendacion.setBounds(51, 177, 134, 13);
		panel.add(labelAnadirRecomendacion);

		textFieldAnadirRecomendacion = new JTextField();
		textFieldAnadirRecomendacion.setBounds(195, 177, 148, 43);
		panel.add(textFieldAnadirRecomendacion);
		textFieldAnadirRecomendacion.setColumns(10);

		// Boton Atras
		JButton botonAtras = new JButton("<html>Atrás<html>");
		botonAtras.setBounds(10, 232, 85, 21);
		panel.add(botonAtras);

		botonAtras.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int resp = JOptionPane.showOptionDialog(null, "¿Está seguro?", "Alerta!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] {"Sí", "No"}, "Sí");
				if (resp == 0) {
					new PantallaPrincipalEntrenador(informacionEntrenador);
					frame.setVisible(false);
				}
				
			}
		});

		// Boton Siguiente
		JButton botonSiguiente = new JButton("<html>Finalizar<html>");
		botonSiguiente.setBounds(341, 232, 85, 21);
		panel.add(botonSiguiente);

		botonSiguiente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (textFieldTipoEntrenamiento.getText().equals("") || textFieldGrupoMuscular.getText().equals("") || textFieldNombreEjercicio.getText().equals("") || textFieldAnadirRecomendacion.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Existen campos vacíos. Inténtelo de nuevo");
				} 

				else {
					if (textFieldTipoEntrenamiento.getText().equals("Definir") || textFieldTipoEntrenamiento.getText().equals("Ganar musculo") || textFieldTipoEntrenamiento.getText().equals("Tonificar")) {
						if (textFieldGrupoMuscular.getText().equals("Hombros y espalda") || textFieldGrupoMuscular.getText().equals("Pierna") || textFieldGrupoMuscular.getText().equals("Brazo") || textFieldGrupoMuscular.getText().equals("Pecho") || textFieldGrupoMuscular.getText().equals("Abdominales") || textFieldGrupoMuscular.getText().equals("Glúteos") || textFieldGrupoMuscular.getText().equals("Gluteos")) {

							if (Definir.existeEntrenamiento(textFieldNombreEjercicio.getText())) {
								new Recomendacion ("Recomendacion " + String.valueOf(Recomendacion.tamanoArray() + 1), textFieldTipoEntrenamiento.getText(), textFieldGrupoMuscular.getText(), textFieldNombreEjercicio.getText(), textFieldAnadirRecomendacion.getText());
								Recomendacion.guardarRecomendacionEnBaseDatos();

								new PantallaPrincipalEntrenador(informacionEntrenador);
								frame.setVisible(false);
							}

							else if (GanarMusculo.existeEntrenamiento(textFieldNombreEjercicio.getText())) {
								new Recomendacion ("Recomendacion " + String.valueOf(Recomendacion.tamanoArray() + 1), textFieldTipoEntrenamiento.getText(), textFieldGrupoMuscular.getText(), textFieldNombreEjercicio.getText(), textFieldAnadirRecomendacion.getText());
								Recomendacion.guardarRecomendacionEnBaseDatos();

								new PantallaPrincipalEntrenador(informacionEntrenador);
								frame.setVisible(false);
							}

							else if (Tonificar.existeEntrenamiento(textFieldNombreEjercicio.getText())) {
								new Recomendacion ("Recomendacion " + String.valueOf(Recomendacion.tamanoArray() + 1), textFieldTipoEntrenamiento.getText(), textFieldGrupoMuscular.getText(), textFieldNombreEjercicio.getText(), textFieldAnadirRecomendacion.getText());
								Recomendacion.guardarRecomendacionEnBaseDatos();

								new PantallaPrincipalEntrenador(informacionEntrenador);
								frame.setVisible(false);
							}

							else {
								JOptionPane.showMessageDialog(null, "<html>El nombre del ejercicio no existe, inténtelo de nuevo<html>", null, JOptionPane.ERROR_MESSAGE);

							}
						}	
						else {
							JOptionPane.showMessageDialog(null, "<html>El grupo muscular no existe, intentalo de nuevo<html>", null, JOptionPane.ERROR_MESSAGE);
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "<html>El tipo de entrenamiento no existe, intentalo de nuevo<html>", null, JOptionPane.ERROR_MESSAGE);
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