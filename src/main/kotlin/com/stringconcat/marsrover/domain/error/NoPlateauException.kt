package com.stringconcat.marsrover.domain.error

class NoPlateauException : RuntimeException() {

    override val message: String = "Plateau has not been created yet"
}
