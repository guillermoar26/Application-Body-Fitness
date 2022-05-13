package Login;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JRadioButton;

import InformacionPersona.Usuario;

import javax.swing.JButton;

public class EleccionOpciones {

	// Frame
	private JFrame frame;

	// Imágenes
	private BufferedImage imagenFondo;
	private BufferedImage image;

	// Etiquetas
	private JLabel etiquetaFondo;
	private JLabel etiquetaLogo;
	private JLabel etiquetaObjetivos;
	private JLabel etiquetaDieta;
	private JLabel etiquetaRutina;

	// Radiobuttons
	private static JRadioButton botonGanarPeso;
	private static JRadioButton botonMantenerPeso;
	private static JRadioButton botonPerderPeso;
	private JRadioButton botonGanarMusculatura;
	private JRadioButton botonTonificar;
	private JRadioButton botonDefinir;

	// ButtonGroups
	private ButtonGroup grupoBotonesDieta;
	private ButtonGroup grupoBotonesRutina;

	// Botones
	private JButton botonCancelar;
	private JButton botonAceptar;

	// Aqui hace falta poner como parametros toda la informacion del usuario y despues cargarla en la base de datos

	/* TENGO QUE UTILIZAR ESTO PARA GUARDAR LA INFORMACION, el apellido siempre va a estar vacio
	Usuario nuevoUsuario = new Usuario("marta", "Marta", "González", "11", "313", "1,54", "marta@hotmail.com", "a", "0", "0", "Nignuno", "Mujer");
	Usuario.guardarUsuariosEnBaseDatos();
	 */
	//String IMC, String porcentajeGrasaDosDecimales, String sexo
	public EleccionOpciones(String usuario, String nombre, String apellidos, String edad, String peso, String altura, String email, String contrasena, String IMC, String porcentajeGrasaDosDecimales, String sexo) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 533);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		// Etiqueta Objetivos
		etiquetaObjetivos = new JLabel("<html>\u00BFCu\u00E1les son tus objetivos?<html>");
		etiquetaObjetivos.setBounds(146, 152, 157, 13);
		panel.add(etiquetaObjetivos);

		// Imagen Logo
		etiquetaLogo = new JLabel();
		image = null;

		try {
			image = ImageIO.read(getClass().getResource("/logo.jpg"));
			ImageIcon imagenLogo = new ImageIcon(image.getScaledInstance(image.getWidth(), image.getHeight(), Image.SCALE_SMOOTH));
			etiquetaLogo.setIcon(imagenLogo);	
		}

		catch (IOException e) {

		}		
		etiquetaLogo.setBounds(98, 10, 229, 157);
		panel.add(etiquetaLogo);

		// Etiqueta Dieta
		etiquetaDieta = new JLabel("<html>DIETA<html>");
		etiquetaDieta.setBounds(41, 202, 45, 13);
		panel.add(etiquetaDieta);

		// Botones Dieta
		botonGanarPeso = new JRadioButton("<html>Ganar peso<html>");
		botonGanarPeso.setOpaque(false);
		botonGanarPeso.setBounds(19, 221, 103, 21);
		panel.add(botonGanarPeso);

		botonMantenerPeso = new JRadioButton("<html>Mantener peso<html>");
		botonMantenerPeso.setOpaque(false);
		botonMantenerPeso.setBounds(19, 278, 164, 21);
		panel.add(botonMantenerPeso);

		botonPerderPeso = new JRadioButton("<html>Perder peso<html>");
		botonPerderPeso.setOpaque(false);
		botonPerderPeso.setBounds(19, 335, 103, 21);
		panel.add(botonPerderPeso);

		grupoBotonesDieta = new ButtonGroup();
		grupoBotonesDieta.add(botonGanarPeso);
		grupoBotonesDieta.add(botonMantenerPeso);
		grupoBotonesDieta.add(botonPerderPeso);

		// Etiqueta Rutina
		etiquetaRutina = new JLabel("<html>RUTINA<html>");
		etiquetaRutina.setBounds(282, 202, 45, 13);
		panel.add(etiquetaRutina);

		botonGanarMusculatura = new JRadioButton("<html>Ganar musculatura<html>");
		botonGanarMusculatura.setOpaque(false);
		botonGanarMusculatura.setBounds(259, 221, 157, 21);
		panel.add(botonGanarMusculatura);

		botonTonificar = new JRadioButton("<html>Tonificar<html>");
		botonTonificar.setOpaque(false);
		botonTonificar.setBounds(259, 278, 103, 21);
		panel.add(botonTonificar);

		botonDefinir = new JRadioButton("<html>Definir<html>");
		botonDefinir.setOpaque(false);
		botonDefinir.setBounds(259, 335, 103, 21);
		panel.add(botonDefinir);

		grupoBotonesRutina = new ButtonGroup();
		grupoBotonesRutina.add(botonGanarMusculatura);
		grupoBotonesRutina.add(botonTonificar);
		grupoBotonesRutina.add(botonDefinir);

		botonCancelar = new JButton("<html>Anterior<html>");
		botonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new SegundaParte_RegistroUsuario(nombre, email, usuario, contrasena);
			}
		});
		botonCancelar.setBounds(57, 426, 85, 21);
		panel.add(botonCancelar);

		botonAceptar = new JButton("<html>Fin<html>");
		botonAceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Hacer optionpane de los botones no seleccionados				
				if((botonGanarPeso.isSelected() || botonMantenerPeso.isSelected() || botonPerderPeso.isSelected()) && (botonGanarMusculatura.isSelected() || botonTonificar.isSelected() || botonDefinir.isSelected())) {
					System.out.println("aaa");
					String dieta = "";
					String tipoEntrenamiento = "";
					if (botonGanarPeso.isSelected()) {
						dieta = "Ganar peso";
					}
					else if (botonMantenerPeso.isSelected()) {
						dieta = "Mantenerme";
					}
					else if (botonPerderPeso.isSelected()) {
						dieta = "Perder peso";
					}

					if (botonGanarMusculatura.isSelected()) {
						tipoEntrenamiento = "Ganar musculo";
					}
					else if (botonTonificar.isSelected()) {
						tipoEntrenamiento = "Tonificar";
					}
					else if (botonDefinir.isSelected()) {
						tipoEntrenamiento = "Definir";
					}

					new Usuario (usuario, nombre, "", edad, peso, altura, email, contrasena, IMC, porcentajeGrasaDosDecimales, tipoEntrenamiento, sexo, dieta);


					Usuario.guardarUsuariosEnBaseDatos();
					frame.setVisible(false);
					new PanelUsuarioContrasena();
				} 
				else if(!botonGanarPeso.isSelected() || !botonMantenerPeso.isSelected() || !botonPerderPeso.isSelected()){
					JOptionPane.showMessageDialog(null, "<html>Debe seleccionar una opción de las tres posibles en ambas columnas de opciones<html>");
				} else if(!botonGanarMusculatura.isSelected() || !botonTonificar.isSelected() || !botonDefinir.isSelected()) {
					JOptionPane.showMessageDialog(null, "<html>Debe seleccionar una opción de las tres posibles en ambas columnas de opciones<html>");
				}
			}
		});
		botonAceptar.setBounds(257, 426, 85, 21);
		panel.add(botonAceptar);

		// Imagen Fondo
		etiquetaFondo = new JLabel();
		imagenFondo = null;

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
