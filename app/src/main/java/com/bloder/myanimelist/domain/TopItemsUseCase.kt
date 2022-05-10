package com.bloder.myanimelist.domain

import com.bloder.myanimelist.data.topitems.repository.TopItemsRepositoryType

class TopItemsUseCase(
    private val repository: TopItemsRepositoryType
) : TopItemsRepositoryType by repository