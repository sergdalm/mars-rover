package com.stringconcat.marsrover.domain.entity

class Plateau(val width: Int, val height: Int) {
    var rover: Rover? = null

    fun land(rover: Rover) {
        this.rover = rover
    }

    fun isInside(coord: Coordinate): Boolean {
        return coord.x in 0 until width && coord.y in 0 until height
    }

}
