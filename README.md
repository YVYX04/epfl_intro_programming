# Introduction to Programming

**Yvan Richard · EPFL · Fall 2026**

My code, notes and solutions for *Introduction to Programming*, the first-year Computer Science course at EPFL. The course is taught in Java and follows two MOOCs.

> **Note:** The course is taught in French, so some comments in the code are written in French.

## Repository layout

| Directory       | Contents                                                   |
| --------------- | ---------------------------------------------------------- |
| `mooc_i/`       | Code and notes for the first MOOC                          |
| `mooc_ii/`      | Code and notes for the second MOOC                         |
| `problem_sets/` | Weekly EPFL problem sets and my solutions                  |

```txt
.
├── README.md
├── mooc_i/
│   └── 01_basics/
│       ├── HelloWorld.java
│       ├── Variables01.java
│       ├── Variables02.java
│       ├── Variables03.java
│       └── Expressions.java
└── mooc_ii/
```

## Progress

### MOOC I

| Module         | Topics                                                                      |
| -------------- | --------------------------------------------------------------------------- |
| `01_basics`    | First program, printing, variables and types, constants, user input with `Scanner`, expressions and integer division |

### MOOC II

Not started yet.

## Running the code

Each file is a standalone program with its own `main` method. You need a JDK installed (developed with OpenJDK 25).

With Java 11 or later, a single file can be run directly:

```sh
java mooc_i/01_basics/HelloWorld.java
```

Or compile first and then run:

```sh
cd mooc_i/01_basics
javac HelloWorld.java
java HelloWorld
```

Compiled `.class` files are ignored by Git.
