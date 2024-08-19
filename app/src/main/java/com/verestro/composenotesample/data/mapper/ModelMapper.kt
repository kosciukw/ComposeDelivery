package com.verestro.composenotesample.data.mapper

interface ModelMapper<Input, Result> {
    fun map(input: Input): Result
}