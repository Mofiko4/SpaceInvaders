package fr.unilim.iut.spaceinvaders;
  
public class SpaceInvaders {

	private static final char MARQUE_FIN_LIGNE = '\n';
	private static final char MARQUE_VIDE = '.';
	private static final char MARQUE_VAISSEAU = 'V';
	int longueur;
	int hauteur;
	Vaisseau vaisseau;

	public SpaceInvaders(int longueur, int hauteur) {
	   this.longueur = longueur;
	   this.hauteur = hauteur;
	}
	
	public void positionnerUnNouveauVaisseau(int x, int y) {
        this.vaisseau = new Vaisseau(x, y);
	}
	
	@Override
	public String toString() {
		return recupererEspaceJeuDansChaineASCII();
	}

	private String recupererEspaceJeuDansChaineASCII() {
		StringBuilder espaceDeJeu = new StringBuilder();
		for (int y = 0; y < hauteur; y++) {
			for (int x = 0; x < longueur; x++) {
				espaceDeJeu.append(recupererMarqueDeLaPostition(x, y));
			}
			espaceDeJeu.append(MARQUE_FIN_LIGNE);
		}
		return espaceDeJeu.toString();
	}

	private char recupererMarqueDeLaPostition(int x, int y) {
		char marque;
		if (this.aUnVaisseauQuiOccupeLaPostion(x, y))
				      marque=MARQUE_VAISSEAU;
			    else
				      marque=MARQUE_VIDE;
		return marque;
	}

	private boolean aUnVaisseauQuiOccupeLaPostion(int y, int x) {
		return this.aUnVaisseau() && vaisseau.occupeLaPosition(x, y);
	}

	private boolean aUnVaisseau() {
		return vaisseau!=null;
	}
}