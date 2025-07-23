package com.stringconcat.marsrover.adapter

import com.stringconcat.marsrover.domain.entity.Plateau
import com.stringconcat.marsrover.domain.port.PlateauStorage

class InMemoryPlateauStorage : PlateauStorage {
    var plateau: Plateau? = null

    override fun save(plateau: Plateau) {
        this.plateau = plateau
    }

    override fun get(): Plateau? {
        return plateau
    }
}