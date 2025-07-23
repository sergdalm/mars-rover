package com.stringconcat.marsrover.adaptor.out

import com.stringconcat.marsrover.adapter.out.InMemoryPlateauStorage
import com.stringconcat.marsrover.domain.entity.Plateau
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import kotlin.test.Test

class InMemoryPlateauStorageTest {

    @Test
    fun `should save plateau`() {
        val inMemoryPlateauStorageTest = InMemoryPlateauStorage()
        val plateau = inMemoryPlateauStorageTest.save(Plateau(1, 2))

        plateau.width shouldBe 1
        plateau.height shouldBe 2
    }

    @Test
    fun `should save and get plateau`() {
        val inMemoryPlateauStorageTest = InMemoryPlateauStorage()
        inMemoryPlateauStorageTest.save(Plateau(1, 2))


        val savedPlateau = inMemoryPlateauStorageTest.get()
        savedPlateau shouldNotBe null
        savedPlateau!!.width shouldBe 1
        savedPlateau.height shouldBe 2
    }

    @Test
    fun `should return null when no plateau was saved`() {
        val inMemoryPlateauStorageTest = InMemoryPlateauStorage()

        val savedPlateau = inMemoryPlateauStorageTest.get()

        savedPlateau shouldBe null
    }

    @Test
    fun `save two plateaus - should return the last one`() {
        val inMemoryPlateauStorageTest = InMemoryPlateauStorage()
        inMemoryPlateauStorageTest.save(Plateau(1, 2))
        inMemoryPlateauStorageTest.save(Plateau(4, 5))


        val savedPlateau = inMemoryPlateauStorageTest.get()
        savedPlateau shouldNotBe null
        savedPlateau!!.width shouldBe 4
        savedPlateau.height shouldBe 5
    }
}