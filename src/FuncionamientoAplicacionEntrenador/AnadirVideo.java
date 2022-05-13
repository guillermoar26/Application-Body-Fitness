package FuncionamientoAplicacionEntrenador;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;

import InformacionPersona.Entrenadores;

import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;

public class AnadirVideo {

	private JFrame frame;
	private JTextField textFieldLinkVideo;

	public AnadirVideo(Entrenadores informacionEntrenador) {
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

		JLabel etiquetaAnadirVideos = new JLabel("<html>A\u00D1ADIR VIDEOS<html>");
		etiquetaAnadirVideos.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaAnadirVideos.setFont(new Font("Tahoma", Font.PLAIN, 18));
		etiquetaAnadirVideos.setBounds(0, 11, 424, 67);
		panel.add(etiquetaAnadirVideos);

		JLabel etiquetaLinkVideo = new JLabel("<html>Link Video<html>");
		etiquetaLinkVideo.setBounds(49, 86, 72, 20);
		panel.add(etiquetaLinkVideo);

		// Input del usuario. Enlace que queremos añadir
		textFieldLinkVideo = new JTextField();
		textFieldLinkVideo.setBounds(157, 86, 153, 20);
		panel.add(textFieldLinkVideo);
		textFieldLinkVideo.setColumns(10);

		// Boton Atras
		JButton botonAtras = new JButton("<html>Atr\u00E1s <html>");
		botonAtras.setBounds(87, 159, 92, 35);
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

		// Boton Añadir Video
		JButton botonAnadirVideo = new JButton("<html>A\u00F1adir video<html>");
		botonAnadirVideo.setBounds(235, 159, 113, 35);
		panel.add(botonAnadirVideo);
		
		botonAnadirVideo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textFieldLinkVideo.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "<html>Debes introducir el link del video<html>", null,
							JOptionPane.ERROR_MESSAGE);
				} else {
					// Si el input no esta vacio e incluye el directorio correcto, seguimos con la implementacion
					if (textFieldLinkVideo.getText().contains("www.youtube.com/watch?v=")) {
						new PantallaPrincipalEntrenador(informacionEntrenador);
						frame.setVisible(false);

						FileWriter fichero = null;
						PrintWriter pw = null;
						File archivo = null;

						try {
							// Probamos a cargar el fichero de texto
							archivo = new File("data.txt");
							// Hacemos flag a true para escribirlo al final del fichero en lugar del principio (asi no sobreescribimos)
							fichero = new FileWriter(archivo, true);
							pw = new PrintWriter(fichero);

							// Imprimo el enlace en en el fichero de texto mas un salto de linea
							pw.write(textFieldLinkVideo.getText() + "\n");
						} catch (Exception ex) {
							ex.printStackTrace();
						} finally {
							try {
								if (null != fichero)
									fichero.close();
							} catch (Exception ex2) {
								ex2.printStackTrace();
							}
						}

					} else {
						// Si el texto introducido no incluye el directorio se lanza un mensaje de error 
						JOptionPane.showMessageDialog(null,
								"<html>Debes introducir un video disponible de Youtube<html>", null,
								JOptionPane.ERROR_MESSAGE);

					}
				}
			}
		});

		// Imagen Fondo
		JLabel etiquetaFondo = new JLabel();
		BufferedImage imagenFondo = null;

		try {
			imagenFondo = ImageIO.read(getClass().getResource("/imagenFondoVioleta.png"));
			ImageIcon im = new ImageIcon(
					imagenFondo.getScaledInstance(imagenFondo.getWidth(), imagenFondo.getHeight(), Image.SCALE_SMOOTH));
			etiquetaFondo.setIcon(im);
		} catch (Exception e) {
		}
		etiquetaFondo.setBounds(0, 0, 436, 496);
		panel.add(etiquetaFondo);

		frame.setVisible(true);
	}
}
