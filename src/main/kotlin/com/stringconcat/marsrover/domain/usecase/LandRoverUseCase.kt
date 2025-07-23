package com.stringconcat.marsrover.domain.usecase

import com.stringconcat.marsrover.domain.entity.Coordinate
import com.stringconcat.marsrover.domain.entity.Direction
import com.stringconcat.marsrover.domain.entity.Rover
import com.stringconcat.marsrover.domain.error.NoPlateauException
import com.stringconcat.marsrover.domain.port.PlateauStorage
import com.stringconcat.marsrover.domain.service.RoverNavigator

class LandRoverUseCase(private val plateauStorage: PlateauStorage) {

    operator fun invoke(coordinate: Coordinate, direction: Direction): RoverNavigator {
        val plateau = plateauStorage.get() ?: throw NoPlateauException()
        return plateau.land(Rover(coordinate, direction))
    }
}
