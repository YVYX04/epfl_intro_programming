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

Concernant la lecture de données introduites au clavier, il convient de faire les remarques suivantes:

La solution montrée ci-dessus utilise le bagage actuel : celui avec lequel vous ne savez mettre des instructions que dans le corps de la méthode main. L'objetscanner de type Scanner qui permet de lire des données introduites depuis le terminal est déclaré et initialisé dans la méthode main. Si vous procédez de cette manière, un message de mise en garde sera généré pour vous indiquer que scanner n'a pas été fermé. Les causes de ce message dépassent les notions vues dans le cadre de ce cours d'introduction et ce message n'aura aucune incidence sur l'exécution de votre programme. Pour l'éviter il suffira d'ajouter l'instruction scanner.close(); avant la dernière accolade de main; c'est à dire juste après le dernier System.out.println(...) dans le code précédent. Une façon alternative de déclarer cette variable de type Scanner est présentée dans le corrigé de l'exercice 7.
Si vous travaillez sur votre propre machine et que l'introduction de valeur de type double avec un point décimal provoque une erreur d'exécution («InputMismatchException») c'est probablement que votre environnement est configuré avec des «Locales» (paramètres régionaux) non anglo-saxons. Vous pouvez faire en sorte qu'une séquence particulière d'entrées se fasse selon les conventions anglo-saxonnes. Ceci se fait en ajoutant l'instruction nomDeLaVariableScanner.useLocale(Locale.ENGLISH)avant l'utilisation de nomDeLaVariableScanner (donc dans notre exemple ci-dessus nomDeLaVariableScanner serait à remplacer par scanner). Il faut pour cela avoir écrit la directive d'importation suivante en début de programme : import java.util.Locale; Dans IntelliJ, vous pouvez modifier les "Locale" de l'exécution en faisant un clic-gauche sur la petite flèche verte, puis modify run configuration. Sous VM options mettre par exemple -Duser.country=FR -Duser.language=fr si l'on veut avoir le , comme séparateur décimal ou -Duser.country=US -Duser.language=en si l'on veut que ce soit le .