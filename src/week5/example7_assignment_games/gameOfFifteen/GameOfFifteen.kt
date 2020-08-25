package week5.example7_assignment_games.gameOfFifteen

import week4.example2_assignment_board.Direction
import week4.example2_assignment_board.createGameBoard
import week5.example7_assignment_games.game.Game

/*
 * Implement the Game of Fifteen (https://en.wikipedia.org/wiki/15_puzzle).
 * When you finish, you can play the game by executing 'PlayGameOfFifteen'.
 */
fun newGameOfFifteen(initializer: GameOfFifteenInitializer = RandomGameInitializer()): Game =
        GameOfFifteen(initializer)

class GameOfFifteen(private val initializer: GameOfFifteenInitializer) : Game {
    private val board = createGameBoard<Int?>(4)

    override fun initialize() = initializer.initialPermutation
            .zip(board.getAllCells()).forEach { (value, cell) ->
                board.set(cell, value)
            }

    override fun canMove() = true

    override fun hasWon() = (get(4, 4) == null) &&
            (board.getAllCells().mapNotNull { board.get(it) }.zipWithNext().all { it.first < it.second })

    override fun processMove(direction: Direction): Unit = with(board) {
        getAllCells().find { get(it) == null }?.let { nullCell ->
            nullCell.getNeighbour(direction.reversed())
                    ?.let { neighbour ->
                        set(nullCell, get(neighbour))
                        set(neighbour, null)
                    }
        }
    }

    override fun get(i: Int, j: Int): Int? = board.run { get(getCell(i, j)) }
}
