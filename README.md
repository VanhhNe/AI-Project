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
### Switch to the Other Branch
First, switch to the branch from which you want to get source code.
```bash
git branch -M <other_branch_name>
```
Pull the latest changes
```bash
git pull origin <other-branch_name>
```
To upload files from your local machine to your branch, follow these steps:
```bash
# Add all changes to staging
git add .

# Commit the change with comments
git commit -m "Your message"

# Push to github repository
git push origin <your_branch_name>
```
In your own branch, you can make any changes you want. In the final version of the code, we will add the source code to the main branch.

