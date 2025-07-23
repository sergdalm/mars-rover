package com.stringconcat.marsrover.domain.service

import com.stringconcat.marsrover.domain.entity.Plateau
import com.stringconcat.marsrover.domain.entity.Position
import com.stringconcat.marsrover.domain.entity.Rover
import com.stringconcat.marsrover.domain.error.RoverNotPresentException

class RoverNavigator(private val plateau: Plateau) {

    init {
        if (plateau.rover == null) {
            throw RoverNotPresentException()
        }
    }

    fun moveRover() {
        val roverNextCoordinate = getRover().peekNextCoordinate()
        if (plateau.isInside(roverNextCoordinate) && !plateau.isAreaOccupied(roverNextCoordinate)) {
            getRover().move()

        }
    }

    fun turnRoverLeft() {
        getRover().turnLeft()
    }

    fun turnRoverRight() {
        getRover().turnRight()
    }

    fun getRoverCurrentPosition(): Position {
        return Position(getRover().coordinates, getRover().direction)
    }

    private fun getRover(): Rover {
        return plateau.rover ?: throw RoverNotPresentException()
    }
}