
# Exercice 2
## ❌  Bug détecté :
Dans la boucle :

```java
// Ancienne version incorrecte :
for (int i = 0; i <= s1.length(); i++)
    
```
## 🛠️ Correction apportée

```java
for (int i = 0; i < s1.length(); i++)

