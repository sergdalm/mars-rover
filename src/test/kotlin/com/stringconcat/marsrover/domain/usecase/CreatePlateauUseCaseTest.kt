package com.stringconcat.marsrover.domain.usecase

import com.stringconcat.marsrover.adapter.InMemoryPlateauStorage
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.startWith
import kotlin.test.Test

class CreatePlateauUseCaseTest {

    @Test
    fun `create and check plateau`() {
        val inMemoryPlateauStorage = InMemoryPlateauStorage()
        val createPlateauUseCase = CreatePlateauUseCase(inMemoryPlateauStorage)
        val plateau = createPlateauUseCase(width = 5, height = 5)

        plateau.width shouldBe 5
        plateau.height shouldBe 5
        inMemoryPlateauStorage.get() shouldBe plateau
    }

    @Test
    fun `create plato with zero size`() {
        val inMemoryPlateauStorage = InMemoryPlateauStorage()
        val createPlateauUseCase = CreatePlateauUseCase(inMemoryPlateauStorage)
        val plateau = createPlateauUseCase(width = 0, height = 0)

        plateau.width shouldBe 0
        plateau.height shouldBe 0
        inMemoryPlateauStorage.get() shouldBe plateau
    }

    // Не очень понятно есть ли смысл таких текстов - ведь в PlateauTest мы уже протестировали тоже самое
    @Test
    fun `create plato with negative size - should throw exception`() {
        val inMemoryPlateauStorage = InMemoryPlateauStorage()
        val createPlateauUseCase = CreatePlateauUseCase(inMemoryPlateauStorage)

        val exception = shouldThrow<IllegalArgumentException> {
            createPlateauUseCase(width = -1, height = 0)
        }
        exception.message should startWith(
            "Plateau size must be non-negative. Got width=-1, height=0"
        )
    }
}