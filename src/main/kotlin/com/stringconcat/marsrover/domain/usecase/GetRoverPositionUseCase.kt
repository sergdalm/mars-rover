package com.stringconcat.marsrover.domain.usecase

import com.stringconcat.marsrover.domain.entity.Position
import com.stringconcat.marsrover.domain.error.NoPlateauException
import com.stringconcat.marsrover.domain.port.PlateauStorage
import com.stringconcat.marsrover.domain.service.RoverNavigator

class GetRoverPositionUseCase(private val plateauStorage: PlateauStorage) {

    operator fun invoke(): Position {
        val plateau = plateauStorage.get() ?: throw NoPlateauException()
        val roverNavigator = RoverNavigator(plateau)

        return roverNavigator.getRoverCurrentPosition()
    }
}
