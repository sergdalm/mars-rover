package com.stringconcat.marsrover

import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import kotlin.test.Test

class CoordinateTest {

    @Test
    fun `the same coordinates are equal`() {
        Coordinate(0, 0) shouldBe Coordinate(0, 0)
        Coordinate(0, 1) shouldBe Coordinate(0, 1)
    }

    @Test
    fun `not the same coordinates are NOT equal`() {
        Coordinate(0, 0) shouldNotBe  Coordinate(0, 5)
        Coordinate(5, 1) shouldNotBe  Coordinate(6, 1)
    }

    @Test
    fun `increment y`() {
        Coordinate(0, 0).incY() shouldBe Coordinate(0, 1)
    }

    @Test
    fun `increment x`() {
        Coordinate(0, 0).incX() shouldBe Coordinate(1, 0)
    }

    @Test
    fun `decrease y`() {
        Coordinate(1, 1).decrY() shouldBe Coordinate(1, 0)
    }

    @Test
    fun `decrease x`() {
        Coordinate(1, 1).decrX() shouldBe Coordinate(0, 1)
    }

    @Test
    fun `decrease 0 x - x should remain 0`() {
        Coordinate(0, 0).decrX() shouldBe Coordinate(0, 0)
    }

    @Test
    fun `decrease 0 y - y should remain 0`() {
        Coordinate(0, 0).decrY() shouldBe Coordinate(0, 0)
    }
}