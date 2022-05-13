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

public class CambiarDieta {

	private JFrame frame;

	public CambiarDieta(Usuario informacionUsuario) {
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
		etiquetaLogo.setBounds(338, 17, 70, 65);
		panel.add(etiquetaLogo);
		
		// Cabecera cambiar dieta seleccionada
		JLabel labelCambiarDieta = new JLabel("<html>CAMBIAR DIETA SELECCIONADA<html>");
		labelCambiarDieta.setHorizontalAlignment(SwingConstants.CENTER);
		labelCambiarDieta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelCambiarDieta.setBounds(101, 49, 238, 13);
		panel.add(labelCambiarDieta);

		JLabel etiquetaDietaAcutal = new JLabel("<html>Su dieta actual:<html>");
		etiquetaDietaAcutal.setBounds(50, 82, 103, 34);
		panel.add(etiquetaDietaAcutal);

		String dietaActual = informacionUsuario.getDietaElegida();
		JLabel labelDietaActual = new JLabel(dietaActual);
		labelDietaActual.setBounds(145, 93, 90, 13);
		panel.add(labelDietaActual);

		JLabel labelSeleccionarDieta = new JLabel("<html>Seleccione nueva dieta:<html>");
		labelSeleccionarDieta.setBounds(50, 122, 152, 26);
		panel.add(labelSeleccionarDieta);

		// Seleccion para cambiar de dieta
		JRadioButton botonGanarPeso = new JRadioButton("<html>Ganar peso<html>");
		botonGanarPeso.setBounds(50, 161, 103, 21);
		botonGanarPeso.setOpaque(false);
		panel.add(botonGanarPeso);

		JRadioButton botonMantenerPeso = new JRadioButton("<html>Mantener peso<html>");
		botonMantenerPeso.setBounds(161, 161, 115, 21);
		botonMantenerPeso.setOpaque(false);
		panel.add(botonMantenerPeso);

		JRadioButton botonPerderPeso = new JRadioButton("<html>Perder peso<html>");
		botonPerderPeso.setBounds(291, 161, 103, 21);
		botonPerderPeso.setOpaque(false);
		panel.add(botonPerderPeso);

		ButtonGroup botonesCambiarDieta = new ButtonGroup();
		botonesCambiarDieta.add(botonGanarPeso);
		botonesCambiarDieta.add(botonMantenerPeso);
		botonesCambiarDieta.add(botonPerderPeso);

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

				if (!botonGanarPeso.isSelected() && !botonMantenerPeso.isSelected() && !botonPerderPeso.isSelected()) {
					JOptionPane.showMessageDialog(null, "Existen campos vacíos. Inténtelo de nuevo");
				} 

				else {
					if (botonGanarPeso.isSelected()) {
						System.out.println("Dieta usuario antes de cambiarlo: " + informacionUsuario.getDietaElegida());
						informacionUsuario.setDietaElegida("Ganar peso"); // Funcion de Usuario que te cambie en la base de datos
						System.out.println("Genero usuario despues de cambiarlo: " + informacionUsuario.getDietaElegida());
					}
					else if (botonMantenerPeso.isSelected()) {
						System.out.println("Dieta usuario antes de cambiarlo: " + informacionUsuario.getDietaElegida());
						informacionUsuario.setDietaElegida("Mantenerme"); // Funcion de Usuario que te cambie en la base de datos
						System.out.println("Dieta usuario despues de cambiarlo: " + informacionUsuario.getDietaElegida());
					}
					else if (botonPerderPeso.isSelected()) {
						System.out.println("Dieta usuario antes de cambiarlo: " + informacionUsuario.getDietaElegida());
						informacionUsuario.setDietaElegida("Perder peso"); // Funcion de Usuario que te cambie en la base de datos
						System.out.println("Dieta usuario despues de cambiarlo: " + informacionUsuario.getDietaElegida());
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
