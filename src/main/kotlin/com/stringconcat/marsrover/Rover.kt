package com.stringconcat.marsrover

class Rover(
    var coordinates: Coordinate,
    var direction: Direction

) {
    fun turnLeft() {
        direction = direction.left()
    }

    fun move() {
        coordinates = coordinates.incY()
    }

    fun turnRight() {
        direction =  direction.right()
    }

    fun direction(): Direction {
        TODO("Not yet implemented")
    }

}
