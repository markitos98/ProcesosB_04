package gui;

import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Asientos {
	public static void main(){
		int size=6;
		char salaCine[][]=new char[size][size];
		salaCine=create(size);
		boolean ban=true; //para ejecutar programa

		do{
			UIManager UI=new UIManager();
			UI.put("OptionPane.background", Color.ORANGE);
			UI.put("Panel.background", Color.GRAY);
			UI.put("OptionPane.messageForeground", Color.ORANGE);

			int opcion=(int)Integer.parseInt(JOptionPane.showInputDialog("\nASIENTOS:\n"+
					"1.- Ver estado de la Sala.\n"

					));

			switch(opcion){
			case 1: display(salaCine); break;
			default: ban=false;
			}
		}while(ban);
	}

	public static char[][] create(int size){
		char matriz[][]=new char[size][size];
		for(int i=0;i<size;i++)
			for(int j=0;j<size;j++)
				matriz[i][j]='v';
		return matriz;
	}


	public static void display(char mat[][]){
		String cad="";
		for(int i=0;i<mat.length;i++){
			for(int j=0; j<mat[i].length; j++){
				cad+=mat[i][j]+" ";
			}
			cad+="\n";
		}
		JOptionPane.showMessageDialog(null,cad);
	}
}
