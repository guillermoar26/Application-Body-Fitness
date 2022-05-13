package FuncionamientoAplicacion;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import DietasCuatroComidasDelDia.Domingo;
import DietasCuatroComidasDelDia.Jueves;
import DietasCuatroComidasDelDia.Lunes;
import DietasCuatroComidasDelDia.Martes;
import DietasCuatroComidasDelDia.Miercoles;
import DietasCuatroComidasDelDia.Sabado;
import DietasCuatroComidasDelDia.Viernes;
import InformacionPersona.Usuario;
import java.awt.Font;


public class MisDietas {

	// Frame
	private JFrame frame;

	// Etiquetas
	private JLabel etiquetaFondo;
	private JLabel etiquetaLogo;

	// Imágenes
	private BufferedImage imagenFondo;
	private BufferedImage image;

	private Dimension dim;

	public MisDietas(Usuario informacionUsuario) {
		frame = new JFrame();
		
		dim = frame.getToolkit().getScreenSize();
		frame.setMaximumSize(dim);
		frame.setBounds(100, 100, 1500, 830);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

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
		etiquetaLogo.setBounds(10, 10, 229, 157);
		panel.add(etiquetaLogo);

		Calendar now = Calendar.getInstance();
		String[] dias = new String[] {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
		String diaSemana =  dias[now.get(Calendar.DAY_OF_WEEK) - 2];
		System.out.println(dias[now.get(Calendar.DAY_OF_WEEK) - 2]);

		// Etiqueta Días de la Semana
		JLabel etiquetaDiasSemana = new JLabel("<html>" + diaSemana  + " " + now.get(Calendar.DATE) + "<html>");
		etiquetaDiasSemana.setFont(new Font("Tahoma", Font.BOLD, 18));
		etiquetaDiasSemana.setBounds(600, 71, 204, 49);
		panel.add(etiquetaDiasSemana);



		JLabel etiquetaDesayuno = new JLabel("<html>DESAYUNO<html>");
		etiquetaDesayuno.setFont(new Font("Tahoma", Font.BOLD, 14));
		etiquetaDesayuno.setBounds(354, 223, 149, 13);
		panel.add(etiquetaDesayuno);

		JLabel etiquetaInformacionDesayuno = new JLabel("<html>Información desayuno<html>");
		etiquetaInformacionDesayuno.setBounds(354, 273, 149, 13);
		panel.add(etiquetaInformacionDesayuno);

		JLabel etiquetaComida = new JLabel("<html>COMIDA<html>");
		etiquetaComida.setFont(new Font("Tahoma", Font.BOLD, 14));
		etiquetaComida.setBounds(354, 439, 149, 13);
		panel.add(etiquetaComida);

		JLabel etiquetaInformacionComida = new JLabel("<html>Información comida<html>");
		etiquetaInformacionComida.setBounds(354, 476, 149, 13);
		panel.add(etiquetaInformacionComida);

		JLabel etiquetaAlmuerzo = new JLabel("<html>ALMUERZO<html>");
		etiquetaAlmuerzo.setFont(new Font("Tahoma", Font.BOLD, 14));
		etiquetaAlmuerzo.setBounds(907, 223, 149, 13);
		panel.add(etiquetaAlmuerzo);

		JLabel etiquetaInformacionAlmuerzo = new JLabel("<html>Información almuerzo<html>");
		etiquetaInformacionAlmuerzo.setBounds(907, 273, 149, 13);
		panel.add(etiquetaInformacionAlmuerzo);

		JLabel etiquetaCena = new JLabel("<html>CENA<html>");
		etiquetaCena.setFont(new Font("Tahoma", Font.BOLD, 14));
		etiquetaCena.setBounds(907, 439, 149, 13);
		panel.add(etiquetaCena);

		JLabel etiquetaInformacionCena = new JLabel("<html>Información cena<html>");
		etiquetaInformacionCena.setBounds(907, 476, 149, 13);
		panel.add(etiquetaInformacionCena);

		ArrayList<String> dieta = null;

		diaSemana =  dias[now.get(Calendar.DAY_OF_WEEK) - 2];
		switch (diaSemana) { // Hay una funcion de dieta aleatorio depende del dia
		case "Lunes":
			dieta = Lunes.dietaAleatorioLunes(informacionUsuario.getDietaElegida());
			break;
		case "Martes":
			dieta = Martes.dietaAleatorioMartes(informacionUsuario.getDietaElegida());
			break;
		case "Miércoles":
			dieta = Miercoles.dietaAleatorioMiercoles(informacionUsuario.getDietaElegida());
			break;
		case "Jueves":
			dieta = Jueves.dietaAleatorioJueves(informacionUsuario.getDietaElegida());
			break;
		case "Viernes":
			dieta = Viernes.dietaAleatorioViernes(informacionUsuario.getDietaElegida());
			break;
		case "Sábado":
			dieta = Sabado.dietaAleatorioSabado(informacionUsuario.getDietaElegida());
			System.out.println("aa");
			break;
		case "Domingo":
			dieta = Domingo.dietaAleatorioDomingo(informacionUsuario.getDietaElegida());	

		}

		// Aqui ponemos en las etiquetas los valores de la dieta aleatoria correspondiente
		etiquetaInformacionDesayuno.setText(dieta.get(2));
		etiquetaInformacionComida.setText(dieta.get(3));
		etiquetaInformacionAlmuerzo.setText(dieta.get(4));
		etiquetaInformacionCena.setText(dieta.get(5));

		// Boton retorno
		JButton botonRetorno = new JButton("<html>Volver al menú<html>");
		botonRetorno.setBounds(781, 690, 162, 21);
		panel.add(botonRetorno);
		botonRetorno.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new PantallaPrincipalUsuario(informacionUsuario);
				frame.setVisible(false);
			}
		});

		// Imagen Fondo
		etiquetaFondo = new JLabel();
		imagenFondo = null;

		try {
			imagenFondo = ImageIO.read(getClass().getResource("/imagenFondoVioleta.png"));
			ImageIcon im = new ImageIcon(imagenFondo.getScaledInstance(imagenFondo.getWidth(), imagenFondo.getHeight(), Image.SCALE_SMOOTH));
			etiquetaFondo.setIcon(im);
		} 
		
		catch(Exception e) {
			
		}				
		etiquetaFondo.setBounds(0, 0, 1500, 830);
		panel.add(etiquetaFondo);


		frame.setVisible(true);
	}
}
