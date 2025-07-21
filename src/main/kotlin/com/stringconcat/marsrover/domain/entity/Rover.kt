package com.stringconcat.marsrover.domain.entity

class Rover(
    var coordinates: Coordinate,
    var direction: Direction

) {
    fun turnLeft() {
        direction = direction.left()
    }

    fun move() {
        coordinates = peekNextCoordinate()
    }

    fun turnRight() {
        direction = direction.right()
    }

    fun peekNextCoordinate(): Coordinate {
        return when (direction) {
            Direction.EAST -> coordinates.incX()
            Direction.SOUTH -> coordinates.decrY()
            Direction.WEST -> coordinates.decrX()
            Direction.NORTH -> coordinates.incY()
        }
    }
}
