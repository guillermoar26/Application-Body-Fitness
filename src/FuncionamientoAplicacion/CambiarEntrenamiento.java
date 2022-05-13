package FuncionamientoAplicacion;

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

import InformacionPersona.Usuario;

import javax.swing.JRadioButton;

public class CambiarEntrenamiento {

	private JFrame frame;

	public CambiarEntrenamiento(Usuario informacionUsuario) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
		JLabel labelCambiarEntrenamiento = new JLabel("<html>CAMBIAR ENTRENAMIENTO SELECCIONADO<html>");
		labelCambiarEntrenamiento.setHorizontalAlignment(SwingConstants.CENTER);
		labelCambiarEntrenamiento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelCambiarEntrenamiento.setBounds(37, 46, 318, 13);
		panel.add(labelCambiarEntrenamiento);

		JLabel lblNewLabel_1 = new JLabel("<html>Su entrenamiento actual:<html>");
		lblNewLabel_1.setBounds(50, 82, 174, 34);
		panel.add(lblNewLabel_1);

		String entrenamientoActual = informacionUsuario.getEntrenamientoElegido();
		JLabel labelEntrenamientoActual = new JLabel(entrenamientoActual);
		labelEntrenamientoActual.setBounds(249, 93, 90, 13);
		panel.add(labelEntrenamientoActual);

		JLabel labelSeleccionarEntrenamiento = new JLabel("<html>Seleccione un entrenamiento:<html>");
		labelSeleccionarEntrenamiento.setBounds(50, 122, 174, 26);
		panel.add(labelSeleccionarEntrenamiento);

		// Seleccion para cambiar de dieta
		JRadioButton botonGanarMusculatura = new JRadioButton("<html>Ganar musculatura<html>");
		botonGanarMusculatura.setBounds(37, 161, 145, 21);
		botonGanarMusculatura.setOpaque(false);
		panel.add(botonGanarMusculatura);

		JRadioButton botonTonificar = new JRadioButton("<html>Tonificar<html>");
		botonTonificar.setBounds(184, 161, 115, 21);
		botonTonificar.setOpaque(false);
		panel.add(botonTonificar);

		JRadioButton botonDefinir = new JRadioButton("<html>Definir<html>");
		botonDefinir.setBounds(301, 161, 103, 21);
		botonDefinir.setOpaque(false);
		panel.add(botonDefinir);

		ButtonGroup botonesCambiarEntrenamiento = new ButtonGroup();
		botonesCambiarEntrenamiento.add(botonGanarMusculatura);
		botonesCambiarEntrenamiento.add(botonTonificar);
		botonesCambiarEntrenamiento.add(botonDefinir);

		// boton Atras
		JButton botonAtras = new JButton("<html>Atrás<html>");
		botonAtras.setBounds(10, 232, 85, 21);
		panel.add(botonAtras);

		botonAtras.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int resp = JOptionPane.showOptionDialog(null, "¿Está seguro?", "Alerta!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] {"Sí", "No"}, "Sí");
				if (resp == 0) {
					new PantallaPrincipalUsuario(informacionUsuario);
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
				if (!botonGanarMusculatura.isSelected() && !botonTonificar.isSelected() && !botonDefinir.isSelected()) {
					JOptionPane.showMessageDialog(null, "Existen campos vacios. Inténtelo de nuevo");
				} 

				else {
					if (botonGanarMusculatura.isSelected()) {
						System.out.println("Entrenamiento usuario antes de cambiarlo: " + informacionUsuario.getEntrenamientoElegido());
						informacionUsuario.setEntrenamientoElegido("Ganar musculo"); // Funcion de Usuario que te cambie en la base de datos
						System.out.println("Entrenamiento usuario despues de cambiarlo: " + informacionUsuario.getEntrenamientoElegido());
					}
					else if (botonTonificar.isSelected()) {
						System.out.println("Entrenamiento usuario antes de cambiarlo: " + informacionUsuario.getEntrenamientoElegido());
						informacionUsuario.setEntrenamientoElegido("Tonificar"); // Funcion de Usuario que te cambie en la base de datos
						System.out.println("Entrenamiento usuario despues de cambiarlo: " + informacionUsuario.getEntrenamientoElegido());
					}
					else if (botonDefinir.isSelected()) {
						System.out.println("Entrenamiento usuario antes de cambiarlo: " + informacionUsuario.getEntrenamientoElegido());
						informacionUsuario.setEntrenamientoElegido("Definir"); // Funcion de Usuario que te cambie en la base de datos
						System.out.println("Entrenamiento usuario despues de cambiarlo: " + informacionUsuario.getEntrenamientoElegido());
					}
					Usuario.guardarUsuariosEnBaseDatos(); // Para que se actualize en la base de datos
					new PantallaPrincipalUsuario(informacionUsuario);
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
