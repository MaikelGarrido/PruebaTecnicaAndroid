package com.example.pruebatecnicaandroid.ui.scaffold


sealed class ScaffoldEvent {
    data class QUERY(val sessionName: String): ScaffoldEvent()
}