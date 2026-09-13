# Problem Set Week 02

## IMC

Nous voulons écrire un programme permettant de calculer l'IMC (indice de masse corporelle) d'une personne. L'IMC se calcule à partir du poids et de la taille suivant la formule : poids (en kg) divisé par le carré de sa taille (en m).

Préparez la "coquille vide" de base accueillant votre programme :

```java
class IMC {
    public static void main(String[] args) {
    }
}
```

Nous verrons plus tard dans le cours à quoi correspondent exactement toutes ces lignes, mais pour l'instant considérez cela comme la base minimale pour que votre programme fonctionne.

On peut maintenant commencer à attaquer notre problème.

Commençons notre programme en prévoyant des variables pour représenter les données de notre problème, à savoir un poids et une taille.
A priori ces grandeurs sont des nombres réels ; nous déclarons donc des variables de type double :

```java
class IMC {
    public static void main(String[] args) {
        double poids;
        double taille;
    }
}
```

Maintenant, le réflexe du bon programmeur : il faut penser à initialiser ces variables. Choisissons ici des valeurs raisonnables quelconques, par exemple :

```java
class IMC {
    public static void main(String[] args) {
        double poids  = 74.5  ;
        double taille =  1.75 ;
    }
}
```

On peut maintenant imaginer passer directement au calcul et à l'affichage de l'IMC. On pourrait par exemple directement afficher l'IMC, mais le but étant quand même de travailler un peu avec des variables, introduisons ici une variable pour l'IMC (même si pour un programme aussi simple ce n'est pas strictement nécessaire) :

```java
class IMC {
    public static void main(String[] args) {
        double poids  = 74.5  ;
        double taille =  1.75 ;

        double imc = poids / (taille * taille);

    }
}
```

puis affichons le, par exemple comme ceci :

```java
class IMC {
    public static void main(String[] args) {
        double poids  = 74.5  ;
        double taille =  1.75 ;

        double imc = poids / (taille * taille);

         System.out.println("Pour " + poids
                            + " kg et " + taille
                            + " m, l'IMC est de " + imc);
    }
}
```

Compilez puis exécutez votre programme. Votre programme devrait alors afficher :

```bash
Pour 74.5 kg et 1.75 m, l'IMC est de 24.326531
```

Un tel programme est évidemment d'un usage limité et il serait beaucoup plus utile de permettre le calcul de l'IMC pour n'importe quels taille et poids. On devrait donc pour cela demander le poids et la taille à l'utilisateur. Ceci se fait en introduisant un «Scanner» comme présenté en cours :

```java
import java.util.Scanner;
class IMC { public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double poids  = 74.5  ;
        double taille =  1.75 ;

        double imc = poids / (taille * taille);

         System.out.println("Pour " + poids
                            + " kg et " + taille
                            + " m, l'IMC est de " + imc);
    }
}
```

puis en posant les questions :

```java
import java.util.Scanner;
class IMC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double poids  = 74.5  ;
        double taille =  1.75 ;

        System.out.print("Entrez un poids  (en kg) : ");
        poids = scanner.nextDouble();
        System.out.print("Entrez une taille (en m) : ");
        taille = scanner.nextDouble();

        double imc = poids / (taille * taille);

         System.out.println("Pour " + poids
                            + " kg et " + taille
                            + " m, l'IMC est de " + imc);
    }
}
```

Notre programme peut maintenant calculer l'IMC pour n'importe quels poids et taille. Il peut être amélioré en contrôlant que les valeurs saisies soient bien raisonnables. Mais pour cela, il faut utiliser ce que l'on appelle des structures de contrôle (vues dès la semaine prochaine).

## Age

Ecrivez un programme `Age.java` qui :

1. demande son âge à l'utilisateur
2. lit la réponse de l'utilisateur et l'enregistre dans une variable age de type entier ;
3. calcule l'année de naissance (à un an près) de l'utilisateur et l'enregistre dans la variable annee de type entier ;
4. affiche l'année de naissance ainsi calculée.

**Exemple d'exécution du programme:**

```text
Donnez votre age : 
21
Votre annee de naissance est : 2005
```

## Fondue

Le but de cet exercice est d'écrire un programme qui permet d'adapter automatiquement, en fonction du nombre de convives, les quantités d'ingrédients nécessaires à la confection d'une fondue fribourgeoise.

Ecrivez un programme Fondue.java qui :

1. déclare une constante `BASE`, initialisée à 4, et qui indique le nombre de personnes pour laquelle est conçue la recette de base ;

2. déclare une variable `fromage`, initialisée à 800.0, qui donne la quantité de fromage en grammes nécessaire pour BASE personnes (du «Vacherin fribourgeois» en l'occurrence !) ;

3. déclare une variable `eau`, initialisée à 2.0, qui donne la quantité d'eau en décilitres nécessaire pour BASE personnes ;

4. déclare une variable `ail`, initialisée à 2.0, qui donne le nombre de gousses d'ail nécessaires pour BASE personnes (on choisit le type double car on veut pouvoir utiliser des moitiés de gousses par exemple) ;

5. déclare une variable `pain`, initialisée à 400.0, qui donne la quantité de pain en grammes nécessaire pour BASE personnes ;

6. demande à l'utilisateur d'introduire le nombre de convives pour lequel on veut préparer la recette ;

7. lit la réponse de l'utilisateur et l'enregistre dans une variable `nbConvives` de type entier ;

8. adapte les quantités de chaque ingrédient en faisant une règle de trois (`nouvelleQuantite = quantiteDeBase * nbConvives / BASE`) ;

9. et affiche la recette pour le nombre de convives voulus selon l'exemple ci-dessous.

**Exemple d'exécution du programme**

```txt
Entrez le nombre de personne(s) conviée(s) à la fondue : 3

Pour faire une fondue fribourgeoise pour 3 personnes, il vous faut : 
 - 600.0 gr de Vacherin fribourgeois
 - 1.5 dl d'eau
 - 1.5 gousse(s) d'ail
 - 300.0 gr de pain
 - du poivre à volonté
```
