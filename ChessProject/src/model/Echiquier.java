package model;

import java.util.List;
/**
 * @author lucas/loïc
 * Classe echiquier 
 *
 */
public class Echiquier extends java.lang.Object
implements BoardGames{

	private Jeu jeu_blanc;
	private Jeu  jeu_noir;
	private Jeu  jeu_courant;
	private Jeu jeu_non_courant;
	private String message="erreur";

	/**
	 * 
	 */
	public Echiquier(){
		this.jeu_blanc=new Jeu(Couleur.BLANC);
		this.jeu_noir=new Jeu(Couleur.NOIR);
		this.jeu_courant=this.jeu_blanc;
		this.jeu_non_courant=this.jeu_noir;
	}

	/**
	 * @return liste de pièces IHM contenant toutes les pieces de l'echiquier (courantes et non courantes)
	 */
	public java.util.List<PieceIHM> getPiecesIHM(){
		List<PieceIHM> ret=null;
		List<PieceIHM> listounette=this.jeu_courant.getPiecesIHM();
		if(listounette.addAll(this.jeu_non_courant.getPiecesIHM())){
			ret= listounette;
		}
		else{
			setMessage("KO: pas de liste de piﾃｨces non courantes (c'est vraiment pas normal)");
		}
		return ret;
	}

	/**
	 * Change le joueur courant lorsqu'un joueur termine son tour
	 */
	public void switchJoueur(){
		Jeu temp;
		temp=this.jeu_courant;
		this.jeu_courant=this.jeu_non_courant;
		this.jeu_non_courant=temp;

	}

	/**
	 * @param xInit
	 * @param yInit
	 * @param xFinal
	 * @param yFinal
	 * @return un boolén 
	 */
	public boolean isPieceInBetween(int xInit,int yInit,int xFinal,int yFinal){
		boolean ret=false;
		boolean reste=true;
		//si la pièce qui va se dépacer est un fou ou une reine(déplacement diagonal), on regarde si elle va croiser une autre pièce lors de son déplacement
		if(this.jeu_courant.getPieceType(xInit, yInit).equals("Fou") || this.jeu_courant.getPieceType(xInit, yInit).equals("Reine")){
			if(xInit!=xFinal && yInit!=yFinal){//on verifie que le déplacement est bien celui d'un fou (pour la reine)
				//on va regarder s'il y a une pièce sur chaque case qui sépare le point de départ et le point d'arrivée
				for(int i=1; i<(Math.abs(xFinal-xInit)) && reste ;i++){ //si le fou va de 1,3 a 3,5 on aura i<2+1 avec i=1 au début: le fou se déplacant bien de 2 cases on entre 2 fois dans la boucle
					if(xFinal-xInit>0){//si le déplacement est positif selon les x
						if(yFinal-yInit>0){//si le déplacement est positif selon les y
							if(this.jeu_blanc.isPieceHere(xInit+i, yInit+i) || this.jeu_noir.isPieceHere(xInit+i, yInit+i)){
								ret=true;
								reste=false;
							}
						}
						else{//si le déplacement est negatif selon les y
							if(this.jeu_blanc.isPieceHere(xInit+i, yInit-i) || this.jeu_noir.isPieceHere(xInit+i, yInit-i)){
								ret=true;
								reste=false;
							}
						}
					}

					else{ //si le déplacement est negatif selon les x
						if(yFinal-yInit>0){//si le déplacement est positif selon les y
							if(this.jeu_blanc.isPieceHere(xInit-i, yInit+i) || this.jeu_noir.isPieceHere(xInit-i, yInit+i)){
								ret=true;
								reste=false;
							}
						}
						else{//si le déplacement est negatif selon les y
							if(this.jeu_blanc.isPieceHere(xInit-i, yInit-i) || this.jeu_noir.isPieceHere(xInit-i, yInit-i)){
								ret=true;
								reste=false;
							}
						}

					}
				}
			}
		}
		//si la pièce qui va se dépacer est une tour ou une reine(déplacement en ligne droite), on regarde si elle va croiser une autre pièce lors de son déplacement
		if(this.jeu_courant.getPieceType(xInit, yInit).equals("Tour") || this.jeu_courant.getPieceType(xInit, yInit).equals("Reine")){
			if((xFinal==xInit || yFinal==yInit)){//on verifie que le déplacement est bien celui d'une tour (pour la reine)
				if(yFinal==yInit){  //si le déplacement est horizontal
					//on va regarder s'il y a une pièce sur chaque case qui sépare le point de départ et le point d'arrivée
					for(int i=1; i<(Math.abs((xFinal-xInit))) && reste ;i++ ){ //si la tour va de 1,3 a 3,3 on aura i<2+1 avec i=1 au début: la tour se déplacant bien de 2 cases on entre 2 fois dans la boucle
						if((xFinal-xInit)>0){//si le déplacement est positif
							if(this.jeu_blanc.isPieceHere(xInit+i, yInit) || this.jeu_noir.isPieceHere(xInit+i, yInit)){
								ret=true;
								reste=false;
							}
						}
						else{//si le déplacement est négatif
							if(this.jeu_blanc.isPieceHere(xInit-i, yInit) || this.jeu_noir.isPieceHere(xInit-i, yInit)){
								ret=true;
								reste=false;
							}
						}
					}
				}

				else{//si le déplacement est vertical
					//on va regarder s'il y a une pièce sur chaque case qui sépare le point de départ et le point d'arrivée
					for(int i=1; i<(Math.abs((yFinal-yInit))) && reste ;i++){ //si la tour va de 1,3 a 1,5 on aura i<2+1 avec i=1 au début: la tour se déplacant bien de 2 cases on entre 2 fois dans la boucle
						if((yFinal-yInit)>0){//si le déplacement est positif
							if(this.jeu_blanc.isPieceHere(xInit, yInit+i) || this.jeu_noir.isPieceHere(xInit, yInit+i)){
								ret=true;
								reste=false;
							}
						}
						else{//si le déplacement est négatif
							if(this.jeu_blanc.isPieceHere(xInit, yInit-i) || this.jeu_noir.isPieceHere(xInit, yInit-i)){
								ret=true;
								reste=false;
							}
						}
					}
				}
			}

		}

		return ret;
	}



	/**
	 * @param xInit
	 * @param yInit
	 * @param xFinal
	 * @param yFinal
	 * @return un booléen indiquant si le mouvement est possible
	 */
	public boolean isMoveOk(int xInit,int yInit,int xFinal,int yFinal){
		boolean ret=false;

		//piece appartient au joueur
		if(this.getColorCurrentPlayer().equals(this.getPieceColor(xInit,yInit))) {	
			//verif si il y a bien deplacement
			if(!(xInit==xFinal && yInit==yFinal)){ 
				//il y a bien deplacement
				//cas de la capture
				if(this.jeu_non_courant.isPieceHere(xFinal,yFinal)){
					ret= jeu_non_courant.isCapturePossible(xFinal, yFinal) && jeu_courant.isMoveOk(xInit, yInit, xFinal, yFinal) ;
					//si la pièce est un pion on vérifie la prise en diagonale
					if(this.jeu_courant.getPieceType(xInit, yInit).equals("Pion")) 
					{
						if(this.jeu_non_courant.isCapturePossible(xFinal, yFinal)){
							ret=((Pion) this.jeu_courant.findPiece(xInit,yInit)).isMoveDiagOk(xFinal,yFinal);
						}
					}
				}
				else{ 
					//cas ou piece arrivee est mm couleur que piece joueur courant
					if(this.jeu_courant.isPieceHere(xFinal,yFinal)){
						ret=false;
					}
					else{//cas deplacement simple
						ret= jeu_courant.isMoveOk(xInit, yInit, xFinal, yFinal);	
					}
				}
				//la fonction retourne true si il y a une piece qui gene le déplacement 
				if(isPieceInBetween(xInit,yInit,xFinal,yFinal)){
					ret=false;
					setMessage("KO: il y a une pièce qui gène le déplacement");
				}
			}
			else{
				setMessage("KO: vous n'avez pas bougé");
				ret=false;
			}
		}
		else{
			setMessage("KO: vous ne pouvez deplacer que des pieces de votre couleur");
		}
		return ret;		
	}


	public boolean move(int xInit,int yInit,int xFinal,int yFinal){
		boolean ret=false;

		if(this.isMoveOk(xInit, yInit, xFinal, yFinal))
		{
			//gestion capture
			this.jeu_non_courant.isCapture(xFinal,yFinal);
			ret= (this.jeu_courant.move(xInit, yInit, xFinal, yFinal));
		}	
		else{
			setMessage("KO: Problème déplacement impossible");
		}		
		return ret;
	}

	public  String toString(){
		return "Jeu Blanc: \r" + this.jeu_blanc.toString() + " \r Jeu Noir: \r" + this.jeu_noir.toString()+ "\r";
	}

	public Couleur getColorCurrentPlayer(){
		return this.jeu_courant.getCouleur();
	}

	public Couleur getPieceColor(int x,int y){
		return this.jeu_courant.getPieceColor(x,y);
	}

	public java.lang.String getMessage(){
		return this.message;		

	}

	private  void setMessage(String message){
		this.message=message;
	}

	public boolean isEnd(){
		return false;
		/*
		 * a coder
		 */
	}








}
