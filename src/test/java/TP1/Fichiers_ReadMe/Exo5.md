



# Exercice 5
## ❌  Bug détecté et  🛠️ Correction apportée:
Dans la boucle :

```
// Ancienne version incorrecte :
 for (int i = 0; i <= symbols.length; i++)
```
doit être:
```
// Ancienne version incorrecte :
 for (int i = 0; i < symbols.length; i++)
```

Erreur dans while (n > values[i]) → doit être n >= values[i] pour inclure les cas exacts (ex: n == 1000).


