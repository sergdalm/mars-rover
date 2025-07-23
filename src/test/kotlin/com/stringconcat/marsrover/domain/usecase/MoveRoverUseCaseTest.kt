package com.stringconcat.marsrover.domain.usecase

import com.stringconcat.marsrover.adapter.out.InMemoryPlateauStorage
import com.stringconcat.marsrover.domain.entity.Coordinate
import com.stringconcat.marsrover.domain.entity.Direction
import com.stringconcat.marsrover.domain.entity.Plateau
import com.stringconcat.marsrover.domain.entity.Rover
import io.kotest.matchers.shouldBe
import kotlin.test.Test

class MoveRoverUseCaseTest {

    @Test
    fun `move rover to north`() {
        val inMemoryPlateauStorage = InMemoryPlateauStorage()
        val plateau = Plateau(5, 5)
        plateau.land(Rover(Coordinate(1, 1), Direction.NORTH))
        inMemoryPlateauStorage.save(plateau)
        val moveRoverUseCase = MoveRoverUseCase(inMemoryPlateauStorage)

        val coordinate = moveRoverUseCase()

        coordinate.x shouldBe 1
        coordinate.y shouldBe 2
    }

    @Test
    fun `move rover to east`() {
        val inMemoryPlateauStorage = InMemoryPlateauStorage()
        val plateau = Plateau(5, 5)
        plateau.land(Rover(Coordinate(1, 1), Direction.EAST))
        inMemoryPlateauStorage.save(plateau)
        val moveRoverUseCase = MoveRoverUseCase(inMemoryPlateauStorage)

        val coordinate = moveRoverUseCase()

        coordinate.x shouldBe 2
        coordinate.y shouldBe 1
    }

    @Test
    fun `move rover to edge of plato - coordinate does not change`() {
        val inMemoryPlateauStorage = InMemoryPlateauStorage()
        val plateau = Plateau(5, 5)
        plateau.land(Rover(Coordinate(0, 1), Direction.WEST))
        inMemoryPlateauStorage.save(plateau)
        val moveRoverUseCase = MoveRoverUseCase(inMemoryPlateauStorage)

        val coordinate = moveRoverUseCase()

        coordinate.x shouldBe 0
        coordinate.y shouldBe 1
    }
}