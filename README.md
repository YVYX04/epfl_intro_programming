# Introduction to Programming

**Yvan Richard · EPFL · Fall 2026**

Java code and notes for *Introduction to Programming*, the first-year Computer Science course at EPFL. The course follows two MOOCs and comes with weekly problem sets.

> The course is taught in French, so parts of the code and notes are in French.

## Layout

| Directory       | Contents                                     |
| --------------- | -------------------------------------------- |
| `mooc_i/`       | Code and notes from the first MOOC           |
| `mooc_ii/`      | Code from the second MOOC (not started)      |
| `problem_sets/` | Weekly problem sets and my solutions         |

Early units are plain `.java` files; from unit 02 on, the notes are Jupyter notebooks (`notes.ipynb`) running a Java kernel, so the examples can be executed cell by cell.

## Progress

| Unit                              | Topics                                                                         |
| --------------------------------- | ------------------------------------------------------------------------------ |
| `mooc_i/01_basics`                | First program, printing, variables and types, constants, `Scanner` input, expressions and integer division |
| `mooc_i/02_conditional_statements`| `if` / `else`, nested branching, comparison operators, logical operators (`&&`, `\|\|`, `^`, `!`), storing boolean results |
| `mooc_i/03_loops`                 | `for` loops, nested loops, variable scope and local variables, `do-while` and `while` loops |
| `problem_sets/week_02`            | BMI, swapping variables, type conversions, cubic equations, arithmetic exercises |

## Running the code

Each `.java` file is a standalone program with its own `main` method. A JDK is required (developed with OpenJDK 25).

```sh
java mooc_i/01_basics/HelloWorld.java
```

The notebooks need Jupyter together with a Java kernel ([JJava](https://github.com/dflib/jjava)):

```sh
jupyter lab mooc_i/03_loops/notes.ipynb
```

Compiled `.class` files are ignored by Git.
