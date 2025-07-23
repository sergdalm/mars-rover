package com.stringconcat.marsrover.domain.usecase

import com.stringconcat.marsrover.domain.entity.Direction
import com.stringconcat.marsrover.domain.error.NoPlateauException
import com.stringconcat.marsrover.domain.port.PlateauStorage
import com.stringconcat.marsrover.domain.service.RoverNavigator

class TurnRightRoverUseCase(private val plateauStorage: PlateauStorage) {

    operator fun invoke(): Direction {
        val plateau = plateauStorage.get() ?: throw NoPlateauException()
        val roverNavigator = RoverNavigator(plateau)

        roverNavigator.turnRoverRight()

        return roverNavigator.getRoverCurrentPosition().direction
    }
}
