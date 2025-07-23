package com.stringconcat.marsrover.domain.usecase

import com.stringconcat.marsrover.adapter.InMemoryPlateauStorage
import com.stringconcat.marsrover.domain.entity.Coordinate
import com.stringconcat.marsrover.domain.entity.Direction
import com.stringconcat.marsrover.domain.entity.Plateau
import com.stringconcat.marsrover.domain.entity.Rover
import io.kotest.matchers.shouldBe
import kotlin.test.Test

class TurnRightRoverUseCaseTest {

    @Test
    fun `turn rover right from north - direction is east`() {
        val inMemoryPlateauStorage = InMemoryPlateauStorage()
        val plateau = Plateau(5, 5)
        plateau.land(Rover(Coordinate(1, 1), Direction.NORTH))
        inMemoryPlateauStorage.save(plateau)
        val turnRightRoverUseCase = TurnRightRoverUseCase(inMemoryPlateauStorage)

        val newDirection = turnRightRoverUseCase()

        newDirection shouldBe Direction.EAST
    }

    @Test
    fun `turn rover right from east - direction is south`() {
        val inMemoryPlateauStorage = InMemoryPlateauStorage()
        val plateau = Plateau(5, 5)
        plateau.land(Rover(Coordinate(1, 1), Direction.EAST))
        inMemoryPlateauStorage.save(plateau)
        val turnRightRoverUseCase = TurnRightRoverUseCase(inMemoryPlateauStorage)

        val newDirection = turnRightRoverUseCase()

        newDirection shouldBe Direction.SOUTH
    }

    @Test
    fun `turn rover right from south - direction is west`() {
        val inMemoryPlateauStorage = InMemoryPlateauStorage()
        val plateau = Plateau(5, 5)
        plateau.land(Rover(Coordinate(1, 1), Direction.SOUTH))
        inMemoryPlateauStorage.save(plateau)
        val turnRightRoverUseCase = TurnRightRoverUseCase(inMemoryPlateauStorage)

        val newDirection = turnRightRoverUseCase()

        newDirection shouldBe Direction.WEST
    }

    @Test
    fun `turn rover right from west - direction is north`() {
        val inMemoryPlateauStorage = InMemoryPlateauStorage()
        val plateau = Plateau(5, 5)
        plateau.land(Rover(Coordinate(1, 1), Direction.WEST))
        inMemoryPlateauStorage.save(plateau)
        val turnRightRoverUseCase = TurnRightRoverUseCase(inMemoryPlateauStorage)

        val newDirection = turnRightRoverUseCase()

        newDirection shouldBe Direction.NORTH
    }
}