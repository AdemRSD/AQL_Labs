
# Exercice 3
## ❌  Bug détecté et 🛠️ Correction apportée :
Dans la boucle while :
la condition low < high doit être low <= high pour que le dernier élément soit bien considéré.
De plus, l’opérateur <= dans else if (array[mid] <= element) est incorrect pour une recherche binaire classique (cela pourrait sauter la bonne valeur).