package com.stringconcat.marsrover.domain.entity

data class Coordinate(
    val x: Int,
    val y: Int
) {
    fun incY(): Coordinate {
        return Coordinate(x, y + 1)
    }

    fun decrY(): Coordinate {
        return Coordinate(x, decreaseValue(y))
    }

    fun incX(): Coordinate {
        return Coordinate(x + 1, y)
    }

    fun decrX(): Coordinate {
        return Coordinate(decreaseValue(x), y)
    }

    private fun decreaseValue(oldValue : Int) : Int {
        if (oldValue == 0) {
            return 0
        }
        return oldValue - 1
    }
}