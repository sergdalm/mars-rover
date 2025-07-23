package com.stringconcat.marsrover.domain.usecase

import com.stringconcat.marsrover.domain.entity.Plateau
import com.stringconcat.marsrover.domain.port.PlateauStorage

class GetPlateauUseCase(private val plateauStorage: PlateauStorage) {

    operator fun invoke(): Plateau? {
        return plateauStorage.get()
    }
}
