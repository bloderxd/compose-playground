package com.bloder.myanimelist.core

suspend fun <T, E, P> T.fetch(data: P): E where T : Repository<P, E> = data.load()