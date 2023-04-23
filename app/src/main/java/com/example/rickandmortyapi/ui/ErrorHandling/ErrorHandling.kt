package com.example.rickandmortyapi.ui.ErrorHandling

import com.example.rickandmortyapi.data.model.errorHandling.ResultOf

object ErrorHandling {
    inline fun <reified T> ResultOf<T>.doIfFailure(callback: (error: String?, throwable: Throwable?) -> Unit) {
        if (this is ResultOf.Failure) {
            callback(message, throwable)
        }
    }

    inline fun <reified T> ResultOf<T>.doIfSuccess(callback: (value: T) -> Unit) {
        if (this is ResultOf.Success) {
            callback(value)
        }
    }
}