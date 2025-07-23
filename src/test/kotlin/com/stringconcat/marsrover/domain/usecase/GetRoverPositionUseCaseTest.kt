package com.stringconcat.marsrover.domain.usecase

import com.stringconcat.marsrover.adapter.InMemoryPlateauStorage
import com.stringconcat.marsrover.domain.entity.Coordinate
import com.stringconcat.marsrover.domain.entity.Direction
import com.stringconcat.marsrover.domain.entity.Plateau
import com.stringconcat.marsrover.domain.entity.Rover
import com.stringconcat.marsrover.domain.error.NoRoverException
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.startWith
import kotlin.test.Test

class GetRoverPositionUseCaseTest {

    @Test
    fun `land rover with position 1-2 west - get position`() {
        val plateau = Plateau(5, 5)
        plateau.land(Rover(Coordinate(1, 2), Direction.WEST))
        val inMemoryPlateauStorage = InMemoryPlateauStorage()
        inMemoryPlateauStorage.save(plateau)
        val getRoverPositionUseCase = GetRoverPositionUseCase(inMemoryPlateauStorage)

        val position = getRoverPositionUseCase()

        position.direction shouldBe Direction.WEST
        position.coordinate.x shouldBe 1
        position.coordinate.y shouldBe 2
    }

    @Test
    fun `land rover with position 3-4 north - get position`() {
        val plateau = Plateau(5, 5)
        plateau.land(Rover(Coordinate(3, 4), Direction.NORTH))
        val inMemoryPlateauStorage = InMemoryPlateauStorage()
        inMemoryPlateauStorage.save(plateau)
        val getRoverPositionUseCase = GetRoverPositionUseCase(inMemoryPlateauStorage)

        val position = getRoverPositionUseCase()

        position.direction shouldBe Direction.NORTH
        position.coordinate.x shouldBe 3
        position.coordinate.y shouldBe 4
    }

    @Test
    fun `get position with no rover - should throw exception`() {
        val plateau = Plateau(5, 5)
        val inMemoryPlateauStorage = InMemoryPlateauStorage()
        inMemoryPlateauStorage.save(plateau)
        val getRoverPositionUseCase = GetRoverPositionUseCase(inMemoryPlateauStorage)

        val exception = shouldThrow<NoRoverException> {
            getRoverPositionUseCase()
        }
        exception.message should startWith(
            "Rover is not present on the plateau"
        )
    }
}