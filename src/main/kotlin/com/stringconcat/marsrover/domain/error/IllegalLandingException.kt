package com.stringconcat.marsrover.domain.error

import com.stringconcat.marsrover.domain.entity.Coordinate

class IllegalLandingException(coordinate: Coordinate) : RuntimeException() {

    override val message: String = "Plateau does not allow coordinate $coordinate"
}
