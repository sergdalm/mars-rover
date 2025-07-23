package com.stringconcat.marsrover.domain.usecase

import com.stringconcat.marsrover.domain.entity.Coordinate
import com.stringconcat.marsrover.domain.error.NoPlateauException
import com.stringconcat.marsrover.domain.port.PlateauStorage
import com.stringconcat.marsrover.domain.service.RoverNavigator

class MoveRoverUseCase(private val plateauStorage: PlateauStorage) {

    operator fun invoke(): Coordinate {
        val plateau = plateauStorage.get() ?: throw NoPlateauException()
        val roverNavigator = RoverNavigator(plateau)

        roverNavigator.moveRover()

        return roverNavigator.getRoverCurrentPosition().coordinate
    }
}
