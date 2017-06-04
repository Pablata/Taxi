package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Caja {

	protected JFrame frameCajaTotal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Caja window = new Caja();
					window.frameCajaTotal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Caja() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameCajaTotal = new JFrame();
		frameCajaTotal.setTitle("Caja Total del Dia");
		frameCajaTotal.setBounds(100, 100, 450, 300);
		frameCajaTotal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameCajaTotal.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Total Caja:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(124, 104, 177, 77);
		frameCajaTotal.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Fecha:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(124, 34, 177, 59);
		frameCajaTotal.getContentPane().add(lblNewLabel_1);

		JButton btnDiaAtras = new JButton("Anterior");
		btnDiaAtras.setBounds(23, 34, 89, 59);
		frameCajaTotal.getContentPane().add(btnDiaAtras);

		JButton btnDiaAdelante = new JButton("Siguiente");
		btnDiaAdelante.setBounds(311, 34, 89, 59);
		frameCajaTotal.getContentPane().add(btnDiaAdelante);

		JButton btnVolverInicio = new JButton("Volver");
		btnVolverInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inicio ventanaInicio = new Inicio();
				ventanaInicio.frameInicio.setVisible(true);
				frameCajaTotal.dispose();

			}
		});
		btnVolverInicio
				.setIcon(new ImageIcon(Caja.class.getResource("/com/sun/javafx/scene/web/skin/Redo_16x16_JFX.png")));
		btnVolverInicio.setBounds(154, 192, 106, 44);
		frameCajaTotal.getContentPane().add(btnVolverInicio);
	}
}
