package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

import container.Listas;
import models.Cliente;

public class Inicio {

	protected JFrame frameInicio;
	private JLabel lblHora;
	private int indiceClientes;
	private JButton btnSubidaViajero;
	private JButton btnTotalGanado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio window = new Inicio();
					window.frameInicio.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Inicio() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameInicio = new JFrame();
		frameInicio.setTitle("Inicio");
		frameInicio.setBounds(100, 100, 450, 300);
		frameInicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameInicio.getContentPane().setLayout(null);

		btnSubidaViajero = new JButton("Subida Viajero");
		btnSubidaViajero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Pagos ventanaPrincipal = new Pagos();
//
//				indiceClientes = 0;
//
//				// Cliente c = Listas.listaClientes.get(indiceClientes);
//				Cliente c = new Cliente();
//				Listas.listaClientes.add(c);
				
				
				
				
				
				

				ventanaPrincipal.framePagoYBajada.setVisible(true);
				frameInicio.dispose();

			}
		});
		btnSubidaViajero.setBounds(50, 90, 117, 102);
		frameInicio.getContentPane().add(btnSubidaViajero);

		btnTotalGanado = new JButton("Total Ganado");
		btnTotalGanado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Caja ventanaGanancias = new Caja();
				ventanaGanancias.frameCajaTotal.setVisible(true);
				frameInicio.dispose();
			}
		});
		btnTotalGanado.setBounds(238, 90, 117, 102);
		frameInicio.getContentPane().add(btnTotalGanado);

		lblHora = new JLabel("Hora");
		lblHora.setBounds(50, 40, 106, 26);
		frameInicio.getContentPane().add(lblHora);
	}

	public void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio window = new Inicio();
					window.frameInicio.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
