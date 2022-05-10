package com.bloder.myanimelist.core

interface Repository<P, T> {

    suspend fun P.load(): T
}