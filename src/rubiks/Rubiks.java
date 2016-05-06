/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rubiks;

/**
 *
 * @author benwagley
 */
public class Rubiks {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		Cube rubiks = new Cube();

		rubiks.scramble();

		rubiks.display();
	}

}
