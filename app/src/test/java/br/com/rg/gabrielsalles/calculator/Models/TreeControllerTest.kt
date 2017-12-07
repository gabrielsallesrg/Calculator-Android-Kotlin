package br.com.rg.gabrielsalles.calculator.Models

import org.junit.Assert.assertEquals
import org.junit.Test


class TreeControllerTest {
    @Test
    fun shouldReturnTheSameValueAsInitiated() {
        val treeController = TreeController(Node(5.0))
        assertEquals(5.0, treeController.getResult(), 0.001)
    }

    @Test
    fun shouldDoTheSum() {
        val treeController = TreeController(Node(5.0))
        treeController.createNewNode("+", "5")
        assertEquals(10.0, treeController.getResult(), 0.001)
    }

    @Test
    fun shouldDoTheSumAndSub() {
        val treeController = TreeController(Node(5.0))
        treeController.createNewNode("+", "5")
        treeController.createNewNode("-", "3")
        assertEquals(7.0, treeController.getResult(), 0.001)
    }

    @Test
    fun shouldDoTheMult() {
        val treeController = TreeController(Node(5.0))
        treeController.createNewNode("*", "5")
        assertEquals(25.0, treeController.getResult(), 0.001)
    }

    @Test
    fun shouldDoTheSumAndMult() {
        val treeController = TreeController(Node(5.0))
        treeController.createNewNode("+", "2")
        treeController.createNewNode("*", "3")
        assertEquals(11.0, treeController.getResult(), 0.001)
    }

    @Test
    fun shouldDoTheSumAndDiv() {
        val treeController = TreeController(Node(5.0))
        treeController.createNewNode("+", "2")
        treeController.createNewNode("/", "3")
        assertEquals(5.666, treeController.getResult(), 0.001)
    }

    @Test
    fun complicatedMaths() {
        val treeController = TreeController(Node(5.0))
        treeController.createNewNode("*", "2")
        treeController.createNewNode("+", "8")
        treeController.createNewNode("*", "2")
        treeController.createNewNode("+", "8")
        treeController.createNewNode("/", "7")
        treeController.createNewNode("-", "5")
        assertEquals(22.142, treeController.getResult(), 0.001)
    }

    @Test
    fun shouldReturnNegative() {
        val treeController = TreeController(Node(5.0))
        treeController.createNewNode("*", "-1")
        assertEquals(-5.0, treeController.getResult(), 0.001)
    }
}