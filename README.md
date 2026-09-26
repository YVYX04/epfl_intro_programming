# Introduction to Programming

**Yvan Richard · EPFL · Fall 2026**

Java code and notes for *Introduction to Programming*, the first-year Computer Science course at EPFL. The course follows two MOOCs and comes with weekly problem sets.

> The course is taught in French, so parts of the code and notes are in French.

## Layout

```
.
├── mooc_i/                         First MOOC: code and notes, one folder per unit
│   ├── 01_basics/                  Plain .java files
│   ├── 02_conditional_statements/  notes.ipynb + lecture_notes/
│   └── 03_loops/                   notes.ipynb
├── mooc_ii/                        Second MOOC (not started)
└── problem_sets/                   Weekly problem sets and my solutions
    ├── week_02/
    └── week_03/
```

Each unit covers one topic. A week's work is done on its own branch (e.g. `w03`) and merged into `main` once it is finished.

## Progress

### MOOC I

| Unit                               | Topics                                                                                                          |
| ---------------------------------- | --------------------------------------------------------------------------------------------------------------- |
| `mooc_i/01_basics`                 | First program, printing, variables and types, constants, `Scanner` input, expressions and integer division      |
| `mooc_i/02_conditional_statements` | `if` / `else`, nested branching, comparison operators, logical operators (`&&`, `\|\|`, `^`, `!`), storing boolean results |
| `mooc_i/03_loops`                  | `for` loops, nested loops, variable scope and local variables, `do-while` and `while` loops                     |

### Problem sets

**Week 02: variables, types and expressions** (statement in [`set_week_02.md`](problem_sets/week_02/set_week_02.md))

| File                 | Exercise                                             |
| -------------------- | ---------------------------------------------------- |
| `IMC.java`           | Body mass index from weight and height               |
| `MySwap.java`        | Swapping two variables                               |
| `Types.java`         | Type conversions and casts, with the value of each line annotated (deliberately does not compile) |
| `Degre3.java`        | Evaluating a polynomial expression in *a*, *b*, *c*, *x* |
| `Age.java`           | Birth year from an age                               |
| `Fondue.java`        | Scaling a fondue recipe to the number of guests      |
| `RosesBlanches.java` | *Tante Fortunée*: splitting a budget with integer division and modulo |

**Week 03: conditionals and loops**

| File                  | Exercise                                                                          |
| --------------------- | --------------------------------------------------------------------------------- |
| `Even.java`           | Is an integer positive or negative, odd or even                                   |
| `Interval.java`       | Which interval a real number belongs to                                           |
| `Degree2.java`        | Solving `a·x² + b·x + c = 0`, with the user interface kept apart from the solver |
| `Multiplication.java` | Multiplication tables from 2 to 10                                                |
| `SameLoop.java`       | The same loop written with `for`, `do…while` and `while`                          |
| `MeanMaxMin.java`     | Mean, maximum and minimum of *n* integers                                         |
| `GCD.java`            | Greatest common divisor of two positive integers                                  |
| `Arrangements.java`   | `n!/(n−k)!` and `n!/((n−k)!·k!)` (small *n* only)                                 |
| `Rebonds1.java`       | Bouncing ball: height after a given number of bounces                             |
| `Rebonds2.java`       | Bouncing ball: number of bounces before the height drops below a threshold        |

## Running the code

Each `.java` file is a standalone program with its own `main` method. A JDK is required (developed with OpenJDK 25). Java 11+ can run a single source file directly:

```sh
java mooc_i/01_basics/HelloWorld.java
java problem_sets/week_03/GCD.java
```

`Rebonds1` and `Rebonds2` use an instance `main` method, which needs Java 25 (or an earlier JDK with `--enable-preview`).

The notebooks need Jupyter together with a Java kernel ([JJava](https://github.com/dflib/jjava)):

```sh
jupyter lab mooc_i/03_loops/notes.ipynb
```

Compiled `.class` files are ignored by Git.
