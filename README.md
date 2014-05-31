ConstraintSolver
================

Forward Checking Constraint Solver which deploys d-way branching for simplicity. The Forward Checking algorithm is designed to work on binary constraints, hence the application only implements binary constraints.

All the tests and benchmark problem models have been included inside the file “Main.java”. To try this, simply call “test CrystalMaze()” or “test Sudoku()” inside the main. To try the heuristics, before starting the search, tell the solver by invoking the one of the following functions :
￼￼
• solver.enableDynamic();

• solver.enablestaticsdf();

• solver.enablelargedf();

• solver.enablemostConstrained();
