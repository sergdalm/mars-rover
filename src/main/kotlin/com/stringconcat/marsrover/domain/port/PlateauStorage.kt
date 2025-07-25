package com.stringconcat.marsrover.domain.port

import com.stringconcat.marsrover.domain.entity.Plateau

interface PlateauStorage {

    fun save(plateau: Plateau): Plateau

    fun get(): Plateau?
}