package br.com.rg.gabrielsalles.calculator.Models

import br.com.rg.gabrielsalles.calculator.Helper.HelperMethods.Companion.add
import br.com.rg.gabrielsalles.calculator.Helper.HelperMethods.Companion.div
import br.com.rg.gabrielsalles.calculator.Helper.HelperMethods.Companion.mult
import br.com.rg.gabrielsalles.calculator.Helper.HelperMethods.Companion.sub


class Node {
    constructor()
    constructor(number: Double) {
        this.number = number
    }
    constructor(operation: Int) {
        this.operation = operation
    }

    val ADD  = 0
    val SUB  = 1
    val MULT = 2
    val DIV  = 3

    var operation = -1
    var number: Double = 0.0
    var father:   Node? = null
    var leftKid:  Node? = null
    var rightKid: Node? = null

    fun getValue(): Double {
        if (isLeaf()) {
            return number
        } else {
            when (operation) {
                ADD  -> number =  add(leftKid!!.getValue(), rightKid!!.getValue())
                SUB  -> number =  sub(leftKid!!.getValue(), rightKid!!.getValue())
                MULT -> number = mult(leftKid!!.getValue(), rightKid!!.getValue())
                DIV  -> number =  div(leftKid!!.getValue(), rightKid!!.getValue())
            }
            return number
        }
    }

    fun setOperationType(operationType: Int) {
        operation = operationType
    }

    private fun isLeaf():Boolean {
        return (leftKid == null && rightKid == null)
    }
}