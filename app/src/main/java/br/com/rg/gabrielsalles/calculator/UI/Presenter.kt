package br.com.rg.gabrielsalles.calculator.UI

import br.com.rg.gabrielsalles.calculator.Helper.Constants.Companion.NON_NEGATIVE_OPERATIONS
import br.com.rg.gabrielsalles.calculator.Helper.Constants.Companion.OPERATIONS
import br.com.rg.gabrielsalles.calculator.Models.TreesManager


class Presenter constructor(private var view: ViewInterface){

    private val treesManager = TreesManager()
    var expression = ""

    fun calculateAndShowResult() {
        if (finishesWithNumbers()) {
            val result = treesManager.giveResult(expression)
            view.updateExpressionView(result)
            expression = ""
        }
    }

    private fun finishesWithNumbers() : Boolean {
        return !(OPERATIONS.contains(expression.last()))
    }

    fun buttonPressed(char: Char) {
        if (!expression.isEmpty() || !NON_NEGATIVE_OPERATIONS.contains(char)) {
            expression += char
            view.updateExpressionView(expression)
        }
    }

    fun addMissingMult(expression: String): String {
        /** add Multiplication symbol where is missing in the expression */
        var localExpression = expression
        var regex = Regex("[0-9]\\(")
        var matchResults: Sequence<MatchResult> = regex.findAll(expression)
        for (match in matchResults) {
            val range = match.range
            localExpression = localExpression.replace(
                    expression.substring(range),
                    expression.substring(range.first, range.first + 1) + "*("
                    )
        }

        regex = Regex("\\)\\(")
        matchResults = regex.findAll(expression)
        for (match in matchResults) {
            val range = match.range
            localExpression = localExpression.replace(
                    expression.substring(range),
                    expression.substring(range.first, range.first + 1) + "*("
            )
        }

        regex = Regex("\\)[0-9]")
        matchResults = regex.findAll(expression)
        for (match in matchResults) {
            val range = match.range
            localExpression = localExpression.replace(
                    expression.substring(range),
                    expression.substring(
                            range.first, range.first+1) + "*" +
                            expression.substring(range.first+1, range.first+2)
            )
        }

        return localExpression
    }
}