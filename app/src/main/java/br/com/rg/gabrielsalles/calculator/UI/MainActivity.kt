package br.com.rg.gabrielsalles.calculator.UI

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.rg.gabrielsalles.calculator.R

class MainActivity : AppCompatActivity(), ViewInterface {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun getExpressionString(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateExpressionView(expression: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
