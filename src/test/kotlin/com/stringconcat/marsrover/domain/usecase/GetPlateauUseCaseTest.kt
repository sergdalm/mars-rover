package com.stringconcat.marsrover.domain.usecase

import com.stringconcat.marsrover.adapter.InMemoryPlateauStorage
import com.stringconcat.marsrover.domain.entity.Plateau
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import kotlin.test.Test

class GetPlateauUseCaseTest {

    @Test
    fun `should get saved plateau with size 5-5`() {
        val inMemoryPlateauStorage = InMemoryPlateauStorage()
        inMemoryPlateauStorage.save(Plateau(5, 5))
        val plateau = GetPlateauUseCase(inMemoryPlateauStorage).invoke()

        plateau shouldNotBe null
        plateau?.width shouldBe 5
        plateau?.height shouldBe 5
    }

    @Test
    fun `should get saved plateau with size 2-3`() {
        val inMemoryPlateauStorage = InMemoryPlateauStorage()
        inMemoryPlateauStorage.save(Plateau(2, 3))
        val plateau = GetPlateauUseCase(inMemoryPlateauStorage).invoke()

        plateau shouldNotBe null
        plateau?.width shouldBe 2
        plateau?.height shouldBe 3
    }
}