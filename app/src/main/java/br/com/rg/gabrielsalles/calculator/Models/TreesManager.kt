package br.com.rg.gabrielsalles.calculator.Models

import br.com.rg.gabrielsalles.calculator.Helper.Constants.Companion.OPERATIONS


class TreesManager {
    //private val operations = listOf<Char>('+', '-', '*', '/')

    fun giveResult(expression: String) : String {
        return createNewSubTreesWithoutParenthesis(expression)
    }

    private fun createNewSubTreesWithoutParenthesis(localExpression: String): String {
        val backupExpression = localExpression
        var localExpression = localExpression
        var openBracketPos  = -1
        var closeBracketPos = -1
        var openBracketsCounter  = 0
        var closeBracketsCounter = 0
        for (pos in backupExpression.indices) {
            if (backupExpression[pos].toString() == "(") {
                openBracketsCounter++
                if (closeBracketPos == -1) {
                    openBracketPos = pos
                }
            } else if (backupExpression[pos].toString() == ")") {
                closeBracketsCounter++
                if (closeBracketsCounter == 1) {
                    closeBracketPos = pos
                }
            }
        }

        if (openBracketsCounter != closeBracketsCounter) {
            return "Bad expression"
        }

        if (openBracketPos > -1) {

            var subtree = backupExpression.substring(openBracketPos + 1, closeBracketPos)
            if (subtree.contains("(")) {
                subtree = createNewSubTreesWithoutParenthesis(subtree)
            } else {
                subtree = createAndCalculateTreeController(subtree).getResult().toString()
            }

            localExpression =
                    backupExpression.substring(0, openBracketPos) +
                    subtree +
                    backupExpression.substring(closeBracketPos + 1, backupExpression.length)

            if ("(" in localExpression) {
                localExpression = createNewSubTreesWithoutParenthesis(localExpression)
            } else {
                localExpression = createAndCalculateTreeController(localExpression).getResult().toString()
            }

            return localExpression
        } else {
            return createAndCalculateTreeController(localExpression).getResult().toString()
        }
    }

    private fun createAndCalculateTreeController(expression: String): TreeController {
        var lastPos = -1
        var number = ""
        var operationType = ""
        for (pos in expression.indices) {
            if (isANumber(expression[pos], number.length)) {
                number += expression[pos]
            } else {
                operationType = expression[pos].toString()
                lastPos = pos
                break
            }
        }
        val treeController = TreeController(Node(number.toDouble()))
        number= ""

        for (pos in expression.indices) {
            if (pos > lastPos) {
                if (isANumber(expression[pos], number.length)) {
                    number += expression[pos]
                } else {
                    treeController.createNewNode(operationType, number)
                    number = ""
                    operationType = expression[pos].toString()
                }
            }
        }
        treeController.createNewNode(operationType, number)
        return treeController
    }

    private fun isANumber(char: Char, currentNumberSize : Int) : Boolean {
        when (char == '-' && currentNumberSize == 0) {
            true -> return true /** Negative number */
            false -> return !OPERATIONS.contains(char)
        }
    }

}