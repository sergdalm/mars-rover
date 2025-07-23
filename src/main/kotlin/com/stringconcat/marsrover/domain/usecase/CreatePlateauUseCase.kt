package com.stringconcat.marsrover.domain.usecase

import com.stringconcat.marsrover.domain.entity.Plateau
import com.stringconcat.marsrover.domain.port.PlateauStorage

class CreatePlateauUseCase(private val plateauStorage: PlateauStorage) {

    operator fun invoke(width: Int, height: Int): Plateau {
        val plateau = Plateau(width, height)
        plateauStorage.save(plateau)
        return plateau
    }
}
