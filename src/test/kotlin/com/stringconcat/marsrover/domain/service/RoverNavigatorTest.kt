package com.stringconcat.marsrover.domain.service

import com.stringconcat.marsrover.domain.entity.*
import com.stringconcat.marsrover.domain.error.LandingCollisionException
import com.stringconcat.marsrover.domain.error.NoRoverException
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.startWith
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
        val plateau = Plateau(2, 0)
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

    @Test
    fun `rover try to land on occupied place - rovers explode`() {
        val plateau = Plateau(5, 5)
        val rover1 = Rover(Coordinate(x = 0, y = 0), Direction.NORTH)
        plateau.land(rover1)
        val rover2 = Rover(Coordinate(x = 0, y = 0), Direction.WEST)

        val exception = shouldThrow<LandingCollisionException> {
            plateau.land(rover2)
        }
        exception.message should startWith(
            "Two rovers collided and exploded at coordinate Coordinate(x=0, y=0). " +
                    "Landing on an occupied area is not allowed"
        )
    }

    @Test
    fun `two rovers land and move - get current coordinates and directions`() {
        val plateau = Plateau(5, 5)
        val rover1 = Rover(Coordinate(x = 1, y = 2), Direction.NORTH)
        val rover1Navigator = plateau.land(rover1)

        rover1Navigator.turnRoverLeft()
        rover1Navigator.moveRover()
        rover1Navigator.turnRoverLeft()
        rover1Navigator.moveRover()
        rover1Navigator.turnRoverLeft()
        rover1Navigator.moveRover()
        rover1Navigator.turnRoverLeft()
        rover1Navigator.moveRover()
        rover1Navigator.moveRover()

        rover1Navigator.getRoverCurrentPosition() shouldBe Position(Coordinate(1, 3), Direction.NORTH)

        val rover2 = Rover(Coordinate(x = 3, y = 3), Direction.EAST)
        val rover2Navigator = plateau.land(rover2)

        rover2Navigator.moveRover()
        rover2Navigator.moveRover()
        rover2Navigator.turnRoverRight()
        rover2Navigator.moveRover()
        rover2Navigator.moveRover()
        rover2Navigator.turnRoverRight()
        rover2Navigator.moveRover()
        rover2Navigator.turnRoverRight()
        rover2Navigator.turnRoverRight()
        rover2Navigator.moveRover()

        rover2Navigator.getRoverCurrentPosition() shouldBe Position(Coordinate(5, 1), Direction.EAST)
    }

    @Test
    fun `create rover navigator without rover - should throw exception`() {
        val plateau = Plateau(5, 5)

        val exception = shouldThrow<NoRoverException> {
            RoverNavigator(plateau)
        }
        exception.message should startWith(
            "Rover is not present on the plateau"
        )
    }

    @Test
    fun `two rovers explode on plato - try to get rover position - should throw exception`() {
        val plateau = Plateau(5, 5)
        val rover1 = Rover(Coordinate(x = 0, y = 0), Direction.NORTH)
        val roverNavigator = plateau.land(rover1)
        val rover2 = Rover(Coordinate(x = 0, y = 0), Direction.WEST)

        shouldThrow<LandingCollisionException> {
            plateau.land(rover2)
        }

        val noRoverException = shouldThrow<NoRoverException> {
            roverNavigator.getRoverCurrentPosition()
        }
        noRoverException.message should startWith(
            "Rover is not present on the plateau"
        )
    }
}