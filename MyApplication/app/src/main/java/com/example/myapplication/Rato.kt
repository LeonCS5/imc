package com.example.myapplication

class Rato : Animal(){
    override public fun tipo(): String {
        return "rato"
    }
    override public fun come(): String {
        return "queijo"
    }
    override public fun som(): String {
        return "Rrruu"
    }
}