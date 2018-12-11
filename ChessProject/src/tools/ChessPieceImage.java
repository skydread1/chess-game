package tools;


/**
 * @author francoise.perrin
 *
 */
public enum ChessPieceImage {


	@SuppressWarnings("javadoc")
	TOURBLANC("TourBLANC", "tourBlancS.png"),
	@SuppressWarnings("javadoc")
	CAVALIERBLANC("CavalierBLANC", "cavalierBlancS.png"), 
	@SuppressWarnings("javadoc")
	FOUBLANC("FouBLANC",  "fouBlancS.png"), 
	@SuppressWarnings("javadoc")
	REINEBLANC("ReineBLANC", "reineBlancS.png"), 
	@SuppressWarnings("javadoc")
	ROIBLANC("RoiBLANC", "roiBlancS.png"),
	@SuppressWarnings("javadoc")
	PIONBLANC("PionBLANC", "pionBlancS.png"),

	@SuppressWarnings("javadoc")
	TOURNOIR("TourNOIR", "tourNoireS.png"),
	@SuppressWarnings("javadoc")
	CAVALIERNOIR("CavalierNOIR", "cavalierNoirS.png"), 
	@SuppressWarnings("javadoc")
	FOUNOIR( "FouNOIR", "fouNoirS.png"), 
	@SuppressWarnings("javadoc")
	REINENOIR("ReineNOIR", "reineNoireS.png"), 
	@SuppressWarnings("javadoc")
	ROINOIR("RoiNOIR", "roiNoirS.png"),
	@SuppressWarnings("javadoc")
	PIONNOIR("PionNOIR", "pionNoirS.png")   
	; 



	/**
	 * name
	 */
	public String nom;
	/**
	 * image file
	 */
	public  String imageFile ;   

	ChessPieceImage(String nom,  String imageFile) { 
		this.nom = nom;
		this.imageFile = imageFile;
	} 

}

