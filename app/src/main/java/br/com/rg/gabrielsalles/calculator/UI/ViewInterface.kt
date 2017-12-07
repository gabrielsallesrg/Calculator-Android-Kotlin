package br.com.rg.gabrielsalles.calculator.UI


interface ViewInterface {

    fun getExpressionString(): String
    fun updateExpressionView(expression : String)
}