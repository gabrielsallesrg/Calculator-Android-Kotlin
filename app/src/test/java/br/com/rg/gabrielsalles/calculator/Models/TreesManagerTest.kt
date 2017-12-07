package br.com.rg.gabrielsalles.calculator.Models

import org.junit.Assert.assertEquals
import org.junit.Test


class TreesManagerTest {

    val tm = TreesManager()

    @Test
    fun creatingNewSubExpression(){
        assertEquals("6.0", tm.giveResult("4+(2*(4*(3+4)))/(30-2)"))
        assertEquals("3.0", tm.giveResult("1+2+3-2-1"))
    }

    @Test
    fun creatingNegativeNewSubExpression(){
        assertEquals("-2.0", tm.giveResult("(2*(4*(3+4)))/-(30-2)"))
    }

    @Test
    fun creatingNewSubExpression2(){
        assertEquals("9.0", tm.giveResult("4+5"))
    }

    @Test
    fun badExpression(){
        assertEquals("Bad expression", tm.giveResult("(4+5"))
    }

    @Test
    fun divisionByZero(){
        assertEquals("Infinity", tm.giveResult("5/0"))
    }

    @Test
    fun divisionByZeroHardVersion(){
        assertEquals("Infinity", tm.giveResult("10/0+5"))
    }

    @Test
    fun infinity(){
        assertEquals("Infinity", tm.giveResult("Infinity"))
    }

    @Test
    fun shouldReturnNegative(){
        assertEquals("-25.0", tm.giveResult("5*-5"))
    }
}