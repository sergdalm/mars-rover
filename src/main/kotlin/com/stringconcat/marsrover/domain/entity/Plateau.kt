package com.stringconcat.marsrover.domain.entity

import com.stringconcat.marsrover.domain.error.RoversExplodedException
import com.stringconcat.marsrover.domain.service.RoverNavigator

class Plateau(val width: Int, val height: Int) {
    var rover: Rover? = null
    private val occupiedArea: MutableSet<Coordinate> = mutableSetOf()

    fun land(rover: Rover): RoverNavigator {
        this.rover?.let {
            occupiedArea.add(this.rover!!.coordinates)
        }

        if (occupiedArea.contains(rover.coordinates)) {
            throw RoversExplodedException(rover.coordinates)
        }

        this.rover = rover
        return RoverNavigator(this)
    }

    fun isInside(coord: Coordinate): Boolean {
        return coord.x in 0 until width && coord.y in 0 until height
    }

    fun isAreaOccupied(coord: Coordinate): Boolean {
        return occupiedArea.contains(coord)
    }

}
