package com.stringconcat.marsrover

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

}