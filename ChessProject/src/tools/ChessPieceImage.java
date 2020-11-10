package tools;


/**
 * @author francoise.perrin
 *
 */
public enum ChessPieceImage {


	@SuppressWarnings("javadoc")
	ROCKWHITE("RockWHITE", "rockWhiteS.png"),
	@SuppressWarnings("javadoc")
	KNIGHTWHITE("KnightWHITE", "knightWhiteS.png"), 
	@SuppressWarnings("javadoc")
	BISHOPWHITE("BishopWHITE",  "bishopWhiteS.png"), 
	@SuppressWarnings("javadoc")
	QUEENWHITE("QueenWHITE", "queenWhiteS.png"), 
	@SuppressWarnings("javadoc")
	KINGWHITE("KingWHITE", "kingWhiteS.png"),
	@SuppressWarnings("javadoc")
	PAWNWHITE("PawnWHITE", "pawnWhiteS.png"),

	@SuppressWarnings("javadoc")
	ROCKBLACK("RockBLACK", "rockBlackS.png"),
	@SuppressWarnings("javadoc")
	KNIGHTBLACK("KnightBLACK", "knightBlackS.png"), 
	@SuppressWarnings("javadoc")
	BISHOPBLACK( "BishopBLACK", "bishopBlackS.png"), 
	@SuppressWarnings("javadoc")
	QUEENBLACK("QueenBLACK", "queenBlackS.png"), 
	@SuppressWarnings("javadoc")
	KINGBLACK("KingBLACK", "kingBlackS.png"),
	@SuppressWarnings("javadoc")
	PAWNBLACK("PawnBLACK", "pawnBlackS.png")   
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

