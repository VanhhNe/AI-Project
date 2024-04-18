# SudokuParallel

## Run Sudoku Game 
```bash
# Compile file.java using javac command.
javac Main/*.java

# Run program
java Main.SudokuSolver
```

## Run time computation of Backtracking in sequential and parallel
``` bash
# Compile file.java using javac command. 
javac ResearchComputation/*.java
# Run program 
java ResearchComputation.MainRunner <\file_testcase.txt> <\option> <\kernel>
# file_testcase.txt: file is stored in Test_Cases
# option:The option for sequetial or parallel backtracking, including SequentialBacktracking (0), SequentialBruteForce (1), ParallelBruteForce (2)
# kernel: The kernel is specified to run ParallelBruteForce (2)
# Example for running in Ubuntu
javac ResearchComputation/*.java && java ResearchComputation.MainRunner Test_Cases/9x9_easy.txt 2 4

# Example for running in Window
javac ResearchComputation/*.java; java ResearchComputation.MainRunner Test_Cases/9x9_easy.txt 2 4
```
