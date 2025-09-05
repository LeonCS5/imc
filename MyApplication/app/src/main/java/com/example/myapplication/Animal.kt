package com.example.myapplication

open class Animal (){
    open fun tipo() : String{
        return "animal generico"
    }
    open fun come (): String{
        return "qualquer coisa"
    }
    open fun som (): String{
        return "qualquer som"
    }
}