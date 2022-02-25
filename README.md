# IN205_Projet
Toutes les questions ont été faites, y compris les bonus.
Création du .jar dans le dossier target.
Pour exécuter le .jar, il sufiit de faire java -jar nom_du_fichier.jar

4 modes jeux explicites au moment du lancement de l'exécutable.

Le programme est par défaut, avec une grille de taille 10, mais l'affichage s'adapte à toutes les tailles. (Il suffirait d'augmenter la taille des boards dans la création des boards
dans la fonction init des fichiers sources Game.java et Game2P.java).
Il y a eu une correction de l'IA qui ne se détectait jamais les orientations verticales des bateaux.

Dans la suite, nous expliquons globalement comment jouer au jeu.

Etape Placement de bateaux :

 Navires:                   Frappes:
   A B C D E F G H I J        A B C D E F G H I J     
 1 . . . . . . . . . .      1 . . . . . . . . . .     
 2 . . . . . . . . . .      2 . . . . . . . . . .     
 3 . . . . . . . . . .      3 . . . . . . . . . .     
 4 . . . . . . . . . .      4 . . . . . . . . . .     
 5 . . . . . . . . . .      5 . . . . . . . . . .     
 6 . . . . . . . . . .      6 . . . . . . . . . .     
 7 . . . . . . . . . .      7 . . . . . . . . . .     
 8 . . . . . . . . . .      8 . . . . . . . . . .     
 9 . . . . . . . . . .      9 . . . . . . . . . .     
10 . . . . . . . . . .     10 . . . . . . . . . .     
Placer 1 : Destroyer(2)
A1 south

Placement du bateau Destroyer de taille 2, en A1 direction SUD (vers le bas)
Ce qui donne:

 Navires:                   Frappes:
   A B C D E F G H I J        A B C D E F G H I J     
 1 D . . . . . . . . .      1 . . . . . . . . . .     
 2 D . . . . . . . . .      2 . . . . . . . . . .     
 3 . . . . . . . . . .      3 . . . . . . . . . .     
 4 . . . . . . . . . .      4 . . . . . . . . . .     
 5 . . . . . . . . . .      5 . . . . . . . . . .     
 6 . . . . . . . . . .      6 . . . . . . . . . .     
 7 . . . . . . . . . .      7 . . . . . . . . . .     
 8 . . . . . . . . . .      8 . . . . . . . . . .     
 9 . . . . . . . . . .      9 . . . . . . . . . .     
10 . . . . . . . . . .     10 . . . . . . . . . .   


Etape Dérouler du jeu :

Joueur Humain
 Navires:                   Frappes:
   A B C D E F G H I J        A B C D E F G H I J     
 1 D S S B C . . . . .      1 . . . . . . . . . .     
 2 D S S B C . . . . .      2 . . . . . . . . . .     
 3 . S S B C . . . . .      3 . . . . . . . . . .     
 4 . . . B C . . . . .      4 . . . . . . . . . .     
 5 . . . . C . . . . .      5 . . . . . . . . . .     
 6 . . . . . . . . . .      6 . . . . . . . . . .     
 7 . . . . . . . . . .      7 . . . . . . . . . .     
 8 . . . . . . . . . .      8 . . . . . . . . . .     
 9 . . . . . . . . . .      9 . . . . . . . . . .     
10 . . . . . . . . . .     10 . . . . . . . . . .     
Où voulez-vous frapper ?
A1 

Ce qui donne une frappe en A1.

=> Frappe en A1 : manqué   //Indication de la frappe réalisée
<= Frappe en E2 : touché   //Indication de la frappe ennemie
 Navires:                   Frappes:
   A B C D E F G H I J        A B C D E F G H I J     
 1 D S S B C . . . . .      1 X . . . . . . . . .     
 2 D S S B C . . . . .      2 . . . . . . . . . .     
 3 . S S B C . . . . .      3 . . . . . . . . . .     
 4 . . . B C . . . . .      4 . . . . . . . . . .     
 5 . . . . C . . . . .      5 . . . . . . . . . .     
 6 . . . . . . . . . .      6 . . . . . . . . . .     
 7 . . . . . . . . . .      7 . . . . . . . . . .     
 8 . . . . . . . . . .      8 . . . . . . . . . .     
 9 . . . . . . . . . .      9 . . . . . . . . . .     
10 . . . . . . . . . .     10 . . . . . . . . . .     
<= Frappe en E1 : touché  //Indication de la frappe ennemie
<= Frappe en A9 : manqué  //Indication de la frappe ennemie
