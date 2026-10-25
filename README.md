# Introduction to Programming

**Yvan Richard · EPFL · Fall 2026**

Java code, notes and problem set solutions for *Introduction to Programming*, the first-year Computer Science course at EPFL. The course follows two MOOCs (procedural Java, then object-oriented Java) and comes with weekly problem sets.

> The course is taught in French, so parts of the code and notes are in French.

## Layout

```
.
├── mooc_i/          MOOC I: procedural programming, one folder per unit
├── mooc_ii/         MOOC II: object-oriented programming, one folder per unit
└── problem_sets/    Weekly problem sets (statements + solutions), one folder per week
```

Each week is worked on its own branch (e.g. `week7`) and merged into `main` when finished.

## Progress

### MOOC I

| Unit                         | Topics                                                         | Content                        |
| ---------------------------- | -------------------------------------------------------------- | ------------------------------ |
| `01_basics`                  | Printing, variables and types, constants, `Scanner`, expressions | `.java` files                |
| `02_conditional_statements`  | `if` / `else`, comparison and logical operators                | `notes.ipynb`, `lecture_notes/` |
| `03_loops`                   | `for`, `while`, `do…while`, nested loops, scope                | `notes.ipynb`                  |
| `04_arrays`                  | Declaring, indexing, for-each, arrays as references            | `notes.ipynb`                  |
| `05_strings_dynamic_arrays`  | `String`, `ArrayList`                                          | `notes.md` (placeholder)       |
| `06_functions`               | Defining methods, passing arguments                            | `notes.ipynb`                  |

### MOOC II

| Unit                   | Topics                                                                                           | Content                                      |
| ---------------------- | ------------------------------------------------------------------------------------------------ | -------------------------------------------- |
| `01_introduction_oop`  | Classes and objects, encapsulation, `this`, constructors (default, copy, chaining), `toString()` | `notes.ipynb`, Tic-Tac-Toe (`Main`, `TicTacToe`) |

### Problem sets

| Week | Theme                              | Solutions                                                                 |
| ---- | ---------------------------------- | ------------------------------------------------------------------------- |
| 02   | Variables, types and expressions   | 7 exercises (`IMC`, `Fondue`, `RosesBlanches`, …), statement in `set_week_02.md` |
| 03   | Conditionals and loops             | 10 exercises (`Degree2`, `GCD`, `Rebonds1/2`, …)                          |
| 04   | Strings and arrays                 | `Crypto` (Caesar cipher), `MostFrequent`, statement in `ps_04.pdf`        |
| 05   | *Five Java Missions* (custom set)  | Mission 1 `Touchdown` (lunar lander simulation, optimal-policy search still to do) |

## Running

Every `.java` file with a `main` method runs directly (JDK 11+, developed with OpenJDK 25):

```sh
java problem_sets/week_03/GCD.java
java problem_sets/week_05/01_touchdown/Touchdown.java
```

Multi-file programs are compiled together:

```sh
javac -d out mooc_ii/01_introduction_oop/*.java && java -cp out Main
```

`Rebonds1` and `Rebonds2` use an instance `main` method, which needs Java 25.

Notebooks need Jupyter with a Java kernel ([JJava](https://github.com/dflib/jjava)):

```sh
jupyter lab mooc_i/06_functions/notes.ipynb
```
