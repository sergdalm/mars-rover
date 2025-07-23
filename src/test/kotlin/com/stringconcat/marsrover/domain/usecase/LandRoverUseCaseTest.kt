package com.stringconcat.marsrover.domain.usecase

import com.stringconcat.marsrover.adapter.InMemoryPlateauStorage
import com.stringconcat.marsrover.domain.entity.Coordinate
import com.stringconcat.marsrover.domain.entity.Direction
import com.stringconcat.marsrover.domain.entity.Plateau
import com.stringconcat.marsrover.domain.entity.Position
import com.stringconcat.marsrover.domain.error.NoPlateauException
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.startWith
import kotlin.test.Test

class LandRoverUseCaseTest {

    @Test
    fun `create rover and land it on plateau - get current position`() {
        val inMemoryPlateauStorage = InMemoryPlateauStorage()
        inMemoryPlateauStorage.save(Plateau(5, 5))
        val landRoverUseCase = LandRoverUseCase(inMemoryPlateauStorage)

        val roverNavigator =
            landRoverUseCase(coordinate = Coordinate(x = 1, y = 1), direction = Direction.NORTH)

        roverNavigator.getRoverCurrentPosition() shouldBe Position(coordinate = Coordinate(x = 1, y = 1), direction = Direction.NORTH)
    }

    @Test
    fun `try to land rover when plato not exists - exception`() {
        val inMemoryPlateauStorage = InMemoryPlateauStorage()
        val landRoverUseCase = LandRoverUseCase(inMemoryPlateauStorage)

        val exception = shouldThrow<NoPlateauException> {
            landRoverUseCase(coordinate = Coordinate(x = 1, y = 1), direction = Direction.NORTH)
        }
        exception.message should startWith(
            "Plateau has not been created yet"
        )
    }
}