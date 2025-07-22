package com.stringconcat.marsrover.domain.error

import com.stringconcat.marsrover.domain.entity.Coordinate

class LandingCollisionException(coordinate: Coordinate) : RuntimeException() {

    override val message: String =
        "Two rovers collided and exploded at coordinate $coordinate. Landing on an occupied area is not allowed."
}
