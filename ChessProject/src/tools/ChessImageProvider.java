package tools;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import model.Color;

/**
 * @author Loic and Lucas
 * 
 * Uses ChessPieceImqge to provide the name of the piece images
 * that are used in the HMI
 *  
 */
public class ChessImageProvider {

	private static Map<String, String> mapImage;

	static {		
		mapImage = new HashMap<String, String>();
		for (int i = 0; i < ChessPieceImage.values().length; i++) {
			mapImage.put(ChessPieceImage.values()[i].nom, ChessPieceImage.values()[i].imageFile);
		}	
	}

	/**
	 * Is private to avoid instantiation
	 */
	private ChessImageProvider() {

	}	

	/**
	 * @param pieceType
	 * @param pieceColor
	 * @return file name of the piece image
	 */
	public static String getImageFile(String pieceType, Color pieceColor){
		String ret, key, value;
		ret = null;
		key = pieceType + pieceColor.name();
		value = mapImage.get(key);
		File g=new File("");
		ret  = g.getAbsolutePath()+ "/images/" + value;

		return ret;		
	}

	/**
	 * Unit test
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(ChessImageProvider.getImageFile("Knight", Color.WHITE));
	}

}
