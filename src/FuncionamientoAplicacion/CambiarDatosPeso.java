package FuncionamientoAplicacion;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;

import javax.imageio.ImageIO;
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

import InformacionPersona.Usuario;
import javax.swing.JTextField;

public class CambiarDatosPeso {

	private JFrame frame;
	private JTextField textFieldPeso;

	public CambiarDatosPeso(Usuario informacionUsuario) {
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
		JLabel labelCambiarDatos = new JLabel("<html>CAMBIAR PESO<html>");
		labelCambiarDatos.setHorizontalAlignment(SwingConstants.CENTER);
		labelCambiarDatos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelCambiarDatos.setBounds(27, 42, 365, 13);
		panel.add(labelCambiarDatos);

		// Genero del usuario
		JLabel labelPeso = new JLabel("<html>Su peso actual:<html>");
		labelPeso.setBounds(85, 97, 93, 13);
		panel.add(labelPeso);

		String pesoActual = informacionUsuario.getPeso();
		JLabel labelGeneroActual = new JLabel(pesoActual + " kg");
		labelGeneroActual.setBounds(235, 97, 102, 13);
		panel.add(labelGeneroActual);

		// Nuevo genero del usuario
		JLabel labelNuevoPeso = new JLabel("<html>Introduzca su nuevo peso:<html>");
		labelNuevoPeso.setBounds(85, 132, 191, 13);
		panel.add(labelNuevoPeso);

		// Introducir el peso
		textFieldPeso = new JTextField();
		textFieldPeso.setBounds(241, 129, 96, 19);
		panel.add(textFieldPeso);
		textFieldPeso.setColumns(10);

		// boton Atras
		JButton botonAtras = new JButton("<html>Atrás<html>");
		botonAtras.setBounds(10, 232, 85, 21);
		panel.add(botonAtras);

		botonAtras.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int resp = JOptionPane.showOptionDialog(null, "¿Está seguro?", "Alerta!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] {"Sí", "No"}, "Sí");
				if (resp == 0) {
					new CambiarDatos(informacionUsuario);
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
				boolean datosBienIntroducidos= true;
				double peso = 0.0;

				if (textFieldPeso.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "<html>Existen campos vacíos. Inténtelo de nuevo<html>");
				} 
				else if (!(textFieldPeso.getText().equals(""))) {


					if (textFieldPeso.getText().contains(",")) {
						textFieldPeso.setText(textFieldPeso.getText().replace(",", "."));
					}

					// CAMBIAR LA COMA POR UN PUNTO, SI NO SALE ERROR
					try {
						peso = Double.parseDouble(textFieldPeso.getText());
					}
					catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(null, "<html>Introduce en el peso numeros no letras<html>");
						datosBienIntroducidos = false;
					}

					if (datosBienIntroducidos) {


						peso = Double.parseDouble(textFieldPeso.getText());

						if (peso < 0.0 || peso > 635.0) {
							JOptionPane.showMessageDialog(null, "<html>Por favor, introduce un dato válido<html>");
						}
						else {
							System.out.println("Peso usuario antes de cambiarlo: " + informacionUsuario.getPeso());
							informacionUsuario.setPeso(textFieldPeso.getText()); // Funcion de Usuario que te cambie en la base de datos
							System.out.println("Peso usuario despues de cambiarlo: " + informacionUsuario.getPeso());
							Usuario.guardarUsuariosEnBaseDatos(); // Para que se actualize en la base de datos
							new CambiarDatos(informacionUsuario);
							frame.setVisible(false);
						}
					} 
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
