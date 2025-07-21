package com.stringconcat.marsrover

import io.kotest.matchers.shouldBe
import kotlin.test.Test

class RoverTest {

    @Test
    fun `rover created - with initial coordinates`() {
        val rover = Rover(Coordinate(x = 0, y = 0), Direction.NORTH)

        rover.coordinates shouldBe Coordinate(x = 0, y = 0)
        rover.direction shouldBe Direction.NORTH
    }

    @Test
    fun `north faced rover moves - increase y`() {
        val rover = Rover(Coordinate(0, 0), Direction.NORTH)
        rover.move()

        rover.coordinates shouldBe Coordinate(0, 1)
        rover.direction shouldBe Direction.NORTH
    }

    @Test
    fun `east faced rover moves - increase x`() {
        val rover = Rover(Coordinate(0, 0), Direction.EAST)
        rover.move()

        rover.coordinates shouldBe Coordinate(1, 0)
        rover.direction shouldBe Direction.EAST
    }

    @Test
    fun `south faced rover moves - decrease y`() {
        val rover = Rover(Coordinate(1, 1), Direction.SOUTH)
        rover.move()

        rover.coordinates shouldBe Coordinate(1, 0)
        rover.direction shouldBe Direction.SOUTH
    }

    @Test
    fun `west faced rover moves - decrease x`() {
        val rover = Rover(Coordinate(1, 1), Direction.WEST)
        rover.move()

        rover.coordinates shouldBe Coordinate(0, 1)
        rover.direction shouldBe Direction.WEST
    }


    @Test
    fun `x edge faced rover moves - coordinate does not change`() {
        val rover = Rover(Coordinate(0, 0), Direction.WEST)
        rover.move()

        rover.coordinates shouldBe Coordinate(0, 0)
        rover.direction shouldBe Direction.WEST
    }

    @Test
    fun `y edge faced rover moves - coordinate does not change`() {
        val rover = Rover(Coordinate(0, 0), Direction.SOUTH)
        rover.move()

        rover.coordinates shouldBe Coordinate(0, 0)
        rover.direction shouldBe Direction.SOUTH
    }

    @Test
    fun `rover turns right from north - direction should be east`() {
        val rover = Rover(Coordinate(0, 0), Direction.NORTH)
        rover.turnRight()

        rover.coordinates shouldBe Coordinate(0, 0)
        rover.direction shouldBe Direction.EAST
    }

    @Test
    fun `rover turns right 2 times from north - direction should be south`() {
        val rover = Rover(Coordinate(0, 0), Direction.NORTH)
        rover.turnRight()
        rover.turnRight()

        rover.coordinates shouldBe Coordinate(0, 0)
        rover.direction shouldBe Direction.SOUTH
    }

    @Test
    fun `rover turns left from north - direction should be west`() {
        val rover = Rover(Coordinate(0, 0), Direction.NORTH)
        rover.turnLeft()

        rover.coordinates shouldBe Coordinate(0, 0)
        rover.direction shouldBe Direction.WEST
    }

    @Test
    fun `rover turns left 2 times from north - direction should be south`() {
        val rover = Rover(Coordinate(0, 0), Direction.NORTH)
        rover.turnLeft()
        rover.turnLeft()

        rover.coordinates shouldBe Coordinate(0, 0)
        rover.direction shouldBe Direction.SOUTH
    }

    @Test
    fun `rover turns left 4 times from north - direction should not change`() {
        val rover = Rover(Coordinate(0, 0), Direction.NORTH)
        rover.turnLeft()
        rover.turnLeft()
        rover.turnLeft()
        rover.turnLeft()

        rover.coordinates shouldBe Coordinate(0, 0)
        rover.direction shouldBe Direction.NORTH
    }


    @Test
    fun `rover turns right from east - direction should be south`() {
        val rover = Rover(Coordinate(0, 0), Direction.EAST)
        rover.turnRight()

        rover.coordinates shouldBe Coordinate(0, 0)
        rover.direction shouldBe Direction.SOUTH
    }

    @Test
    fun `rover turns right 2 times from east - direction should be west`() {
        val rover = Rover(Coordinate(0, 0), Direction.EAST)
        rover.turnRight()
        rover.turnRight()

        rover.coordinates shouldBe Coordinate(0, 0)
        rover.direction shouldBe Direction.WEST
    }

    @Test
    fun `rover turns left from east - direction should be north`() {
        val rover = Rover(Coordinate(0, 0), Direction.EAST)
        rover.turnLeft()

        rover.coordinates shouldBe Coordinate(0, 0)
        rover.direction shouldBe Direction.NORTH
    }

    @Test
    fun `rover turns left 2 times from east - direction should be west`() {
        val rover = Rover(Coordinate(0, 0), Direction.EAST)
        rover.turnLeft()
        rover.turnLeft()

        rover.coordinates shouldBe Coordinate(0, 0)
        rover.direction shouldBe Direction.WEST
    }

    @Test
    fun `rover turns left 4 times from east - direction should not change`() {
        val rover = Rover(Coordinate(0, 0), Direction.EAST)
        rover.turnLeft()
        rover.turnLeft()
        rover.turnLeft()
        rover.turnLeft()

        rover.coordinates shouldBe Coordinate(0, 0)
        rover.direction shouldBe Direction.EAST
    }

    @Test
    fun `rover turns right from south - direction should be west`() {
        val rover = Rover(Coordinate(0, 0), Direction.SOUTH)
        rover.turnRight()

        rover.coordinates shouldBe Coordinate(0, 0)
        rover.direction shouldBe Direction.WEST
    }

    @Test
    fun `rover turns right 2 times from south - direction should be north`() {
        val rover = Rover(Coordinate(0, 0), Direction.SOUTH)
        rover.turnRight()
        rover.turnRight()

        rover.coordinates shouldBe Coordinate(0, 0)
        rover.direction shouldBe Direction.NORTH
    }

    @Test
    fun `rover turns left from south - direction should be east`() {
        val rover = Rover(Coordinate(0, 0), Direction.SOUTH)
        rover.turnLeft()

        rover.coordinates shouldBe Coordinate(0, 0)
        rover.direction shouldBe Direction.EAST
    }

    @Test
    fun `rover turns left 2 times from south - direction should be north`() {
        val rover = Rover(Coordinate(0, 0), Direction.SOUTH)
        rover.turnLeft()
        rover.turnLeft()

        rover.coordinates shouldBe Coordinate(0, 0)
        rover.direction shouldBe Direction.NORTH
    }

    @Test
    fun `rover turns left 4 times from south - direction should not change`() {
        val rover = Rover(Coordinate(0, 0), Direction.SOUTH)
        rover.turnLeft()
        rover.turnLeft()
        rover.turnLeft()
        rover.turnLeft()

        rover.coordinates shouldBe Coordinate(0, 0)
        rover.direction shouldBe Direction.SOUTH
    }


    @Test
    fun `rover turns right from west - direction should be north`() {
        val rover = Rover(Coordinate(0, 0), Direction.WEST)
        rover.turnRight()

        rover.coordinates shouldBe Coordinate(0, 0)
        rover.direction shouldBe Direction.NORTH
    }

    @Test
    fun `rover turns right 2 times from west - direction should be east`() {
        val rover = Rover(Coordinate(0, 0), Direction.WEST)
        rover.turnRight()
        rover.turnRight()

        rover.coordinates shouldBe Coordinate(0, 0)
        rover.direction shouldBe Direction.EAST
    }

    @Test
    fun `rover turns left from west - direction should be south`() {
        val rover = Rover(Coordinate(0, 0), Direction.WEST)
        rover.turnLeft()

        rover.coordinates shouldBe Coordinate(0, 0)
        rover.direction shouldBe Direction.SOUTH
    }

    @Test
    fun `rover turns left 2 times from west - direction should be east`() {
        val rover = Rover(Coordinate(0, 0), Direction.WEST)
        rover.turnLeft()
        rover.turnLeft()

        rover.coordinates shouldBe Coordinate(0, 0)
        rover.direction shouldBe Direction.EAST
    }

    @Test
    fun `rover turns left 4 times from west - direction should not change`() {
        val rover = Rover(Coordinate(0, 0), Direction.WEST)
        rover.turnLeft()
        rover.turnLeft()
        rover.turnLeft()
        rover.turnLeft()

        rover.coordinates shouldBe Coordinate(0, 0)
        rover.direction shouldBe Direction.WEST
    }
}