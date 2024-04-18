# SudokuParallel
## Manage repository
### Initializing a local repository
Firstly, you need to create a local repository:
```bash
git init
git remote add origin https://github.com/VanhhNe/AI-Project.git
```
### Manage your own branch in GitHub
Each member will create their own branch individually using the following command:
```bash
git checkout -b <name_branch>
# Example: git checkout -b vanh
```
To upload files from your local machine to your branch, follow these steps:
```bash
# Add all changes to staging
git add .

# Commit the change with comments
git commit -m "Your message"

# Push to github repository
git push origin <your_branch_name>
# or simply
git push
```
In your own branch, you can make any changes you want. In the final version of the code, we will add the source code to the main branch.
### Switch to the Other Branch
First, switch to the branch from which you want to get source code.
```bash
git checkout <other_branch_name>
```
Pull the latest changes
```bash
git pull origin <other-branch_name>
```
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
