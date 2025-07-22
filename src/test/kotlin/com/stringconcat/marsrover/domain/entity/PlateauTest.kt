package com.stringconcat.marsrover.domain.entity

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Assertions.assertNotNull
import kotlin.test.Test

internal class PlateauTest {

    @Test
    fun `create plateau`() {
        val plateau = Plateau(3, 5)
        plateau.width shouldBe 3
        plateau.height shouldBe 5
    }

    @Test
    fun `rover lends on plateau`() {
        val plateau = Plateau(5, 5)
        val rover = Rover(Coordinate(x = 0, y = 0), Direction.NORTH)
        plateau.land(rover)

        assertNotNull(plateau.rover)
        plateau.rover?.coordinates shouldBe Coordinate(x = 0, y = 0)
        plateau.rover?.direction shouldBe Direction.NORTH
    }

    @Test
    fun `rover is on north edge - check if rover can move on plateau - no`() {
        val plateau = Plateau(2, 0)
        val rover = Rover(Coordinate(x = 0, y = 0), Direction.NORTH)
        plateau.land(rover)

        val peekNextCoordinate = rover.peekNextCoordinate()
        plateau.isInside(peekNextCoordinate) shouldBe false
    }

    @Test
    fun `rover is on east edge - check if rover can move on plateau - no`() {
        val plateau = Plateau(0, 2)
        val rover = Rover(Coordinate(x = 0, y = 0), Direction.EAST)
        plateau.land(rover)

        val peekNextCoordinate = rover.peekNextCoordinate()
        plateau.isInside(peekNextCoordinate) shouldBe false
    }

    @Test
    fun `check if rover can move on plateau - yes`() {
        val plateau = Plateau(5, 5)
        val rover = Rover(Coordinate(x = 0, y = 0), Direction.NORTH)
        plateau.land(rover)

        val peekNextCoordinate = rover.peekNextCoordinate()
        plateau.isInside(peekNextCoordinate) shouldBe true
    }
}