package br.com.rg.gabrielsalles.calculator.UI

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito


class PresenterTest {
    lateinit private var presenter: Presenter

    @Mock
    private var view = Mockito.mock(ViewInterface::class.java)


    @Before
    fun setUp() {
        presenter = Presenter(view)
    }

    @Test
    fun shouldFixMissingMultEquals() {
        assertEquals("5*(2+3)+5*(2+3)", presenter.addMissingMult("5(2+3)+5(2+3)"))
    }

    @Test
    fun shouldFixMissingMultBackToBackParenthesis() {
        assertEquals("(1+2)*(3+4)", presenter.addMissingMult("(1+2)(3+4)"))
    }

    @Test
    fun shouldFixMissingMult() {
        assertEquals("1+2*(3+4)*(9*(5*2))", presenter.addMissingMult("1+2(3+4)(9(5*2))"))
    }

    @Test
    fun shouldFixParenthesisThenNumber() {
        assertEquals("(1+2)*3+4", presenter.addMissingMult("(1+2)3+4"))
    }

    @Test
    fun shouldFixParenthesisMultiIssues() {
        assertEquals("(1+2)*3+4*(7+8)*5*((9+2)*(3-0)*3-4)", presenter.addMissingMult("(1+2)3+4(7+8)5((9+2)(3-0)3-4)"))
    }

    @Test
    fun firstCharShouldBeNumber() {
        presenter.buttonPressed('+')
        presenter.buttonPressed('2')
        assertEquals("2", presenter.expression)
    }

    @Test
    fun firstCharShouldBeNegativeNumber() {
        presenter.buttonPressed('-')
        presenter.buttonPressed('2')
        assertEquals("-2", presenter.expression)
    }

    @Test
    fun shouldUpdateTheExpression() {
        presenter.buttonPressed('1')
        presenter.buttonPressed('2')
        presenter.buttonPressed('+')
        assertEquals("12+", presenter.expression)
        presenter.calculateAndShowResult()
        assertEquals("12+", presenter.expression)
        presenter.buttonPressed('3')
        assertEquals("12+3", presenter.expression)
        presenter.calculateAndShowResult()
        assertEquals("", presenter.expression)
    }

}