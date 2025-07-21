package com.stringconcat.marsrover.domain.entity

class Plateau(val width: Int, val height: Int) {
    var rover: Rover? = null

    fun land(rover: Rover) {
        this.rover = rover
    }

    fun canRoverMove(): Boolean {
        return when (rover?.direction) {
            Direction.NORTH -> compareCoordinatesWithHeight(rover?.coordinates!!)
            Direction.EAST -> compareCoordinatesWithWidth(rover?.coordinates!!)
            else -> true
        }
    }

    private fun compareCoordinatesWithWidth(coordinate: Coordinate): Boolean {
        return coordinate.x < width - 1
    }

    private fun compareCoordinatesWithHeight(coordinate: Coordinate): Boolean {
        return coordinate.y < height - 1
    }

}
