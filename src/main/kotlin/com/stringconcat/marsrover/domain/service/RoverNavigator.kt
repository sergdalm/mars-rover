package com.stringconcat.marsrover.domain.service

import com.stringconcat.marsrover.domain.entity.Plateau

class RoverNavigator(val plateau: Plateau) {
    fun moveRover() {

        val rover = plateau.rover
        rover?.let {
            val roverNextCoordinate = rover.peekNextCoordinate()
            if (plateau.isInside(roverNextCoordinate)) {
                rover.move()
            }
        }
    }

    fun turnRoverLeft() {
        plateau.rover?.turnLeft()
    }

    fun turnRoverRight() {
        plateau.rover?.turnRight()
    }
}