package com.example.myapplication

class Cao : Animal(){
    override public fun tipo(): String {
        return "cao"
    }
    override public fun come(): String {
        return "osso"
    }
    override public fun som(): String {
        return "au au"
    }
}