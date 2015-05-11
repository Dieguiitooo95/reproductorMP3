/**
 * 
 */
package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * @author Fernando de la Mata
 *
 */
public class Interfaz extends JFrame implements ActionListener {

	/**
	 * @param args
	 */
	private Cancion cancionActual;
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem menuCargar;
	private JButton buttonPlay;
	private JTextArea playlist;
	private JSlider barra;
	private JButton buttonStop;
		
	public Interfaz() {
		super("Reproductor mp3");
		menuBar = new JMenuBar();
		menu = new JMenu("Archivo");
		menuCargar = new JMenuItem("Cargar");
		menuCargar.addActionListener(new ActionListener(){
			public void actionPerformed (ActionEvent e){
				JFileChooser fc = new JFileChooser();
		        //Mostrar la ventana para abrir archivo y recoger la respuesta
		        //En el parámetro del showOpenDialog se indica la ventana
		        //  al que estará asociado. Con el valor this se asocia a la
		        //  ventana que la abre.
			

		        int respuesta = fc.showOpenDialog(menuCargar);
		        //Comprobar si se ha pulsado Aceptar
		        if (respuesta == JFileChooser.APPROVE_OPTION)
		        {
		            //Crear un objeto File con el archivo elegido
		            File archivoElegido = fc.getSelectedFile();
		            //Mostrar el nombre del archvivo en un campo de texto
							try {
								cancionActual = new Cancion(archivoElegido.getPath());
								playlist.append(archivoElegido.getName()+"\n");
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
				
		;		
		        }
		        

			}
		});
		menu.add(menuCargar);
		menuBar.add(menu);

		JPanel panel = new JPanel();
		//panel.setLayout(null);

		//JLabel label = new JLabel("This is a label!");
		//panel.add(label);

		buttonPlay = new JButton(new ImageIcon(this.getClass().getResource("/img/play.png")));
		buttonPlay.setBounds(100,400,100,100);
		buttonPlay.setFocusPainted(false);
		buttonPlay.addActionListener(new ActionListener(){
			public void actionPerformed (ActionEvent e){
				try {
					cancionActual.play();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	     
			}
		});
		
		buttonStop = new JButton(new ImageIcon(this.getClass().getResource("/img/stop.png")));
		buttonStop.setBounds(200,400,100,100);
		buttonStop.setFocusPainted(false);
		buttonStop.addActionListener(new ActionListener(){
			public void actionPerformed (ActionEvent e){
				try {
					cancionActual.stop();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	     
			}
		});
/*		
		Icon icono = new Icon();
		icono.
		button.setIcon(defaultIcon);
		button.setText("Press me");
*/		
		playlist = new JTextArea(5, 20);
		JScrollPane scrollPane = new JScrollPane(playlist); 
		playlist.setEditable(false);
		add(playlist, BorderLayout.EAST);
		
		barra = new JSlider(JSlider.HORIZONTAL,0, 400, 0);
		
		barra.addChangeListener(new ChangeListener() {
		      public void stateChanged(ChangeEvent event) {
		          int value = barra.getValue();
		          if (value == 0) {
		            System.out.println("0");
		          } else if (value > 0 && value <= 30) {
		            System.out.println("value > 0 && value <= 30");
		          } else if (value > 30 && value < 80) {
		            System.out.println("value > 30 && value < 80");
		          } else {
		            System.out.println("max");
		          }
		        }
		      });
		
		add(barra, BorderLayout.SOUTH);
		add(buttonStop);
		add(buttonPlay);

		add(panel);
		setJMenuBar(menuBar);
		pack();
		setMinimumSize(new Dimension(800, 600)); 
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e){
		        		

		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Interfaz ventana = new Interfaz();
		
	}

}
