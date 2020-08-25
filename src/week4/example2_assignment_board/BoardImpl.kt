package week4.example2_assignment_board

import week4.example2_assignment_board.Direction.*

fun createSquareBoard(width: Int): SquareBoard = SquareBoardImpl(width)
fun <T> createGameBoard(width: Int): GameBoard<T> = GameBoardImpl(width)

internal open class SquareBoardImpl(override val width: Int) : SquareBoard {
    private val arr: Array<Array<Cell>>

    init {
        arr = Array(width) { i ->
            Array(width) { j ->
                Cell(i + 1, j + 1)
            }
        }
        for (i in 0 until width) {
            for (j in 0 until width) {
                print(arr[i][j])
            }
            println()
        }
    }

    private fun getInner(i: Int, j: Int): Cell = arr[i - 1][j - 1]

    override fun getCellOrNull(i: Int, j: Int): Cell? =
            if (i > width || j > width || i < 1 || j < 1) null else getInner(i, j)

    override fun getCell(i: Int, j: Int): Cell =
            getCellOrNull(i, j) ?: throw IllegalArgumentException()

    override fun getAllCells(): Collection<Cell> = arr.flatten()

    override fun getRow(i: Int, jRange: IntProgression): List<Cell> = jRange
            .filter { it in 1..width }
            .map { getInner(i, it) }

    override fun getColumn(iRange: IntProgression, j: Int): List<Cell> = iRange
            .filter { it in 1..width }
            .map { getInner(it, j) }

    override fun Cell.getNeighbour(direction: Direction): Cell? =
            when (direction) {
                UP -> getCellOrNull(i - 1, j)
                LEFT -> getCellOrNull(i, j - 1)
                DOWN -> getCellOrNull(i + 1, j)
                RIGHT -> getCellOrNull(i, j + 1)
            }
}

internal class GameBoardImpl<T>(width: Int) : GameBoard<T>, SquareBoardImpl(width) {
    val map: MutableMap<Cell, T> = mutableMapOf()

    override fun get(cell: Cell): T? = map[cell]

    override fun set(cell: Cell, value: T?) {
        if (value != null) map[cell] = value
        else map.remove(cell)
    }

    override fun filter(predicate: (T?) -> Boolean): Collection<Cell> =
        getAllCells().filter { predicate.invoke(map[it]) }

    override fun find(predicate: (T?) -> Boolean): Cell? =
        getAllCells().find { predicate.invoke(map[it]) }

    override fun any(predicate: (T?) -> Boolean): Boolean =
        getAllCells().any { predicate.invoke(map[it]) }

    override fun all(predicate: (T?) -> Boolean): Boolean =
        getAllCells().all { predicate.invoke(map[it]) }

}

fun main() {
    val board = createSquareBoard(2)
    println(board.getColumn(1..20, 1))
    println(board.getRow(1, 20 downTo 1))
    println()

    val game = createGameBoard<String>(2)
    val cell11 = game.getCell(1, 1)
    val cell22 = game.getCell(2, 2)
    game.set(cell11, "Hello, world!")
    game.set(cell22, "bb")
    println(game.get(cell11))
}
