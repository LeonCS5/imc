package com.example.myapplication

class Gato : Animal(){
    override public fun tipo(): String {
        return "gato"
    }
    override public fun come(): String {
        return "rato"
    }
    override public fun som(): String {
        return "miau"
    }
}