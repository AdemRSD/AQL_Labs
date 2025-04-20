# README : Exercice 4 - Jeu de dés

## 1. Objets mockés pour tester la méthode `jouer`

**Question** : Quels objets dont dépend la classe `Jeu` sont forcément mockés dans un test pour automatiser `jouer` ? Pourquoi ?

**Réponse** :  
Les objets suivants doivent être mockés pour tester la méthode `jouer` en isolation :

- **Banque** : La classe `Jeu` dépend d'une instance de `Banque` pour gérer les mises et les gains (`crediter`, `debiter`, `est_solvable`). Mocker `Banque` permet de contrôler son comportement (par exemple, simuler la solvabilité ou un débit) sans dépendre d'une implémentation réelle, qui pourrait être complexe ou avoir des dépendances externes.
- **Joueur** : La classe `Jeu` interagit avec un `Joueur` pour obtenir la mise (`mise`), débiter la mise (`debiter`), et créditer les gains (`crediter`). Mocker `Joueur` permet de simuler différents scénarios, comme une mise spécifique ou une insolvabilité (`DebitImpossibleException`).
- **De1 et De2** : Les deux dés (`De`) sont utilisés pour obtenir les valeurs des lancers (`lancer`). Mocker les dés permet de contrôler les valeurs retournées (par exemple, somme = 7 ou ≠ 7) pour tester les cas de gain ou de perte sans dépendre de l'aléatoire.

**Pourquoi ?**
- Ces objets sont des dépendances externes de `Jeu`. Les mocker permet d'isoler la logique de `Jeu` et de tester son comportement de manière déterministe.
- Les mocks offrent un contrôle total sur les interactions (par exemple, vérifier que `Banque.crediter` est appelé) et les retours (par exemple, `De.lancer` retourne une valeur spécifique).

## 2. Scénarios (classes d'équivalence) pour tester `jouer`

**Question** : Lister les scénarios (classes d'équivalence) que vous allez écrire pour tester `jouer`, en les décrivant.

**Réponse** :  
Les scénarios suivants couvrent les cas possibles pour la méthode `jouer` :

1. **Jeu fermé** :
    - **Description** : Le jeu est fermé (`estOuvert() = false`), et `jouer` doit lever une `JeuFermeException`.
    - **Objectif** : Vérifier que le jeu empêche de jouer si fermé.

2. **Joueur insolvable** :
    - **Description** : Le joueur propose une mise, mais `Joueur.debiter` lève une `DebitImpossibleException` (insolvabilité).
    - **Objectif** : Vérifier que le jeu s'arrête sans lancer les dés ni interagir avec la banque.

3. **Somme des dés ≠ 7 (perte)** :
    - **Description** : Le jeu est ouvert, le joueur est solvable, la mise est débitée et créditée à la banque, les dés sont lancés, et leur somme ≠ 7.
    - **Objectif** : Vérifier que le joueur perd (pas de gain crédité) et que la banque conserve la mise.

4. **Somme des dés = 7 (gain, banque solvable)** :
    - **Description** : Le jeu est ouvert, le joueur est solvable, la mise est débitée et créditée à la banque, les dés donnent une somme = 7, la banque paye 2 × mise, et la banque reste solvable.
    - **Objectif** : Vérifier que le joueur est crédité de 2 × mise et que le jeu reste ouvert.

5. **Somme des dés = 7 (gain, banque insolvable)** :
    - **Description** : Comme le scénario 4, mais la banque devient insolvable après avoir payé le gain (`est_solvable() = false`).
    - **Objectif** : Vérifier that the player receives their gain, but the game closes.

## 4. Test du cas où le jeu est fermé

**Question** : Écrire le test le plus simple : le cas où le jeu est fermé. Est-ce un test d’état ou un test des interactions ?

**Réponse** :
- **Test** : Le test vérifie que `jouer` lève une `JeuFermeException` lorsque le jeu est fermé (`estOuvert() = false`).
- **Type de test** : C'est un **test d'état**, car il vérifie le résultat de l'appel à `jouer` (levée d'une exception) sans se concentrer sur les interactions avec les dépendances (`Banque`, `Joueur`, `De`). Aucune interaction avec les mocks n'est vérifiée dans ce test.

## 5. Test du cas où le joueur est insolvable

**Question** : Tester le cas où le joueur est insolvable. Comment tester que le jeu ne touche pas aux dés ? Est-ce un test d’état ou un test des interactions ?

**Réponse** :
- **Test** : Le test configure `Joueur.mise` pour retourner une mise positive, mais `Joueur.debiter` lève une `DebitImpossibleException`. Il vérifie que l'exception is thrown and that the dice are not rolled.
- **Vérification des dés** : On utilise `verify(de1, never()).lancer()` et `verify(de2, never()).lancer()` pour confirmer que les méthodes `lancer` des dés ne sont pas appelées.
- **Type de test** : C'est un **test d'interaction**, car il vérifie les interactions (ou leur absence) avec les dépendances (les dés via `never()`, et implicitement `Joueur.debiter`). La levée de l'exception est une vérification d'état, mais l'accent est mis sur les interactions.