package com.stringconcat.marsrover.domain.service

import com.stringconcat.marsrover.domain.entity.Coordinate
import com.stringconcat.marsrover.domain.entity.Direction
import com.stringconcat.marsrover.domain.entity.Plateau
import com.stringconcat.marsrover.domain.entity.Rover
import io.kotest.matchers.shouldBe
import kotlin.test.Test

internal class RoverNavigatorTest {

    @Test
    fun `move rover on a plateau`() {
        val plateau = Plateau(5, 5)
        val rover = Rover(Coordinate(x = 0, y = 0), Direction.NORTH)
        val roverNavigator = plateau.land(rover)
        roverNavigator.moveRover()

        rover.coordinates shouldBe Coordinate(0, 1)
        rover.direction shouldBe Direction.NORTH
    }

    @Test
    fun `land rover on plateau edge - rover try to move - rover coordinates dose not change`() {
        val plateau = Plateau(3, 1)
        val rover = Rover(Coordinate(x = 0, y = 0), Direction.NORTH)
        val roverNavigator = plateau.land(rover)
        roverNavigator.moveRover()

        rover.coordinates shouldBe Coordinate(0, 0)
        rover.direction shouldBe Direction.NORTH
    }

    @Test
    fun `land rover on 1-1 plateau - rover tries to move - rover coordinates dose not change`() {
        val plateau = Plateau(1, 1)
        val rover = Rover(Coordinate(x = 0, y = 0), Direction.NORTH)
        val roverNavigator = plateau.land(rover)
        roverNavigator.moveRover()
        roverNavigator.turnRoverRight()
        roverNavigator.moveRover()
        roverNavigator.turnRoverRight()
        roverNavigator.moveRover()
        roverNavigator.turnRoverRight()
        roverNavigator.moveRover()
        roverNavigator.turnRoverRight()

        rover.coordinates shouldBe Coordinate(0, 0)
        rover.direction shouldBe Direction.NORTH
    }

    @Test
    fun `rover try to move on occupied place - rover can't move`() {
        val plateau = Plateau(5, 5)
        val rover1 = Rover(Coordinate(x = 0, y = 0), Direction.NORTH)
        plateau.land(rover1)
        val rover2 = Rover(Coordinate(x = 1, y = 0), Direction.WEST)
        val roverNavigator = plateau.land(rover2)
        roverNavigator.moveRover()

        rover2.coordinates shouldBe Coordinate(1, 0)
        rover2.direction shouldBe Direction.WEST
    }
}