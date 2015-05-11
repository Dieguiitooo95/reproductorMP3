/**
 * 
 */
package main;


import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javax.print.DocFlavor.URL;
import javax.print.attribute.standard.Media;

import javazoom.jl.player.Player;







/**
 * @author Fernando de la Mata
 *
 */
public class Cancion {
	
	private String ruta;
	private Player player;

	

	
	/**
	 * @return the ruta
	 */
	public String getRuta() {
		return ruta;
	}



	/**
	 * @param ruta the ruta to set
	 */
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}



	public Cancion(String ruta) throws Exception{
	


	
		/*// Take the path of the audio file from command line
		 File f=new File(ruta);


		 // Create a Player OBJECT that realizes the audio
		 final Player p=Manager.createRealizedPlayer(f.toURI().toURL());


		  // Start the music
		  p.start();*/
		  
		  File file=new File(ruta);
		  FileInputStream fis     = new FileInputStream(file);
		  BufferedInputStream bis = new BufferedInputStream(fis);

		  player = new Player(bis);
		  
	

	}
	public void play() throws Exception{
		  player.play();
	}
	
	public void stop(){
		player.close();
	}
}
