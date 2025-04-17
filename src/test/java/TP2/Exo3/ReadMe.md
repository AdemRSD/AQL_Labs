# changements clés
## Modification de UserService : 
Ajout de la validation de l'email pour le scénario 2, rendant la classe plus robuste face aux entrées invalides.
## Extension de Utilisateur : 
Ajout d'un champ id avec getter/setter pour le scénario 3, permettant de tester la définition d'un identifiant unique.
## Correction des incohérences :
Remplacement de thenReturn(true) par doAnswer (scénario 3) et doNothing (scénario 4) pour respecter la signature void de creerUtilisateur.