package FuncionamientoAplicacionEntrenador;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.SwingConstants;
import InformacionPersona.Entrenadores;
import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class EliminarVideo {

	private JFrame frame;
	private JTextField textFieldLinkVideo;

	public EliminarVideo(Entrenadores informacionEntrenador) {
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

		JLabel etiquetaEliminarVideos = new JLabel("<html>ELIMINAR VIDEOS<html>");
		etiquetaEliminarVideos.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaEliminarVideos.setFont(new Font("Tahoma", Font.PLAIN, 18));
		etiquetaEliminarVideos.setBounds(0, 11, 424, 67);
		panel.add(etiquetaEliminarVideos);

		JLabel etiquetaLinkVideo = new JLabel("<html>Link Video<html>");
		etiquetaLinkVideo.setBounds(49, 86, 72, 20);
		panel.add(etiquetaLinkVideo);

		// Input del usuario. Supone el enlace que tenemos que borrar
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

		// Boton eliminar video
		JButton botonEliminarVideo = new JButton("<html>Eliminar video<html>");
		botonEliminarVideo.setBounds(235, 159, 130, 35);
		panel.add(botonEliminarVideo);

		botonEliminarVideo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textFieldLinkVideo.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "<html>Debes introducir el link del video<html>", null,JOptionPane.ERROR_MESSAGE);
				} else {
					// Si el input no esta vacio e incluye el directorio correcto, seguimos con la implementacion
					if (textFieldLinkVideo.getText().contains("www.youtube.com/watch?v=")) {
						new PantallaPrincipalEntrenador(informacionEntrenador);
						frame.setVisible(false);

						File archivo = null;
						File temp = null;

						try {
							// Primero intentamos cargar los ficheros de texto
							archivo = new File("data.txt");
							temp = new File("temp.txt");

							// Intentamos instanciar un BufferedReader y BufferedWriter
							// Leo todas las filas del archivo original y las escribo en la temporal
							try (BufferedReader br = new BufferedReader(new FileReader(archivo));
									BufferedWriter bw = new BufferedWriter(new FileWriter(temp))) {
								String linea;
								// Iteramos cada linea del fichero original
								while ((linea = br.readLine()) != null) {
									// Si la linea no corresponde con lo que quiero eliminar, la escribo en el fichero temporal
									if (!linea.equals(textFieldLinkVideo.getText())) {
										bw.write(linea);
										bw.newLine();
									}
								}
							}
							// Borramos el fichero de texto original
							if (archivo.delete()) {
								// Y cambiamos el nombre de temp por el otro fichero, de esta manera se guardan los cambios
								if (!temp.renameTo(archivo)) {
									// Si no ha sido posible renombrarlo, lanzo una excepcion
									throw new IOException("<html>No se pudo renombrar el archivo<html>");
								}
							} else {
								// Si no he podido borrar el fichero original, lanzo de nuevo otra excepcion
								throw new IOException("<html>No se pudo borrar el archivo original<html>");
							}
						} catch (IOException ex) {
							ex.printStackTrace();
						}
					} else {
						// Notifico si el usuario no incluye un enlace con el directorio de YouTubbe
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
