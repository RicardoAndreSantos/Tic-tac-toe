# Tic-tac-toe

Work developed for Artificial Intelligence course.

## Objectives

Implement the Tic-tac-toe game, using two algorithms:

* [Minimax](https://en.wikipedia.org/wiki/Minimax)

* [Alpha-beta](https://en.wikipedia.org/wiki/Alpha–beta_pruning)


## Implementation

#### There are four files:

* **Jogo_Do_Galo** </br>
  Responsible for the entire user interface and choice of algorithms

* **Gerais** </br>
  Here are some utils functions:
	* *getScore* -> get game score
	* *isTerminal* -> Check if victory exists
	* *endGame* -> Print message to the winner
	* *evalmovimento* -> Check if the move is valid
	* *printestado* -> Print game board
  
  among others.

* **Minimax** </br>
  Implementation of the Minimax algorithm

* **Alphabeta** </br>
  Implementation of the Alpha-beta algorithm
  
  
## Execution

Compile : `javac Jogo_Do_Galo.java`<br />
Run     : `java Jogo_Do_Galo`

First we need to choose which of the algorithms we want to run.
```
Algorithm ?
1 - Min-Max
2 - Alpha Beta
```

After that, we choose if we want to be the first to play and make the moves using the following description in "How to play".
```
How to play
1 | 2 | 3 | 
4 | 5 | 6 | 
7 | 8 | 9 | 

Be the first to play?
1 - Yes
2 - No
```
