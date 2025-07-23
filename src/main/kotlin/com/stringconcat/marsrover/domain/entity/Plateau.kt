package com.stringconcat.marsrover.domain.entity

import com.stringconcat.marsrover.domain.error.IllegalLandingException
import com.stringconcat.marsrover.domain.error.LandingCollisionException
import com.stringconcat.marsrover.domain.service.RoverNavigator

class Plateau(val width: Int, val height: Int) {
    var rover: Rover? = null
    private val occupiedArea: MutableSet<Coordinate> = mutableSetOf()

    init {
        require(width >= 0 && height >= 0) {
            "Plateau size must be non-negative. Got width=$width, height=$height"
        }
    }

    fun land(rover: Rover): RoverNavigator {
        updateOccupiedArea()
        validateLanding(rover)

        this.rover = rover
        return RoverNavigator(this)
    }

    fun isInside(coord: Coordinate): Boolean {
        return coord.x in 0..width && coord.y in 0..height
    }

    fun isAreaOccupied(coord: Coordinate): Boolean {
        return occupiedArea.contains(coord)
    }

    private fun validateLanding(rover: Rover) {
        if (!isInside(rover.coordinates)) {
            throw IllegalLandingException(rover.coordinates)
        }
        if (occupiedArea.contains(rover.coordinates)) {
            this.rover = null
            throw LandingCollisionException(rover.coordinates)
        }
    }

    private fun updateOccupiedArea() {
        this.rover?.let { occupiedArea.add(it.coordinates) }
    }

}
