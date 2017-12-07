package br.com.rg.gabrielsalles.calculator.Models


class TreeController constructor(root: Node) {

    var root = root
    var lastNode = root

    fun createNewNode(operationType: String, numberString: String) {
        val newNode = Node()
        if (operationType == "+") {
            newNode.operation = newNode.ADD
            puttingInTheRightPositionForAddOrSub(newNode, numberString.toDouble())
        } else if (operationType == "-") {
            newNode.operation = newNode.SUB
            puttingInTheRightPositionForAddOrSub(newNode, numberString.toDouble())
        } else if (operationType == "*") {
            puttingInTheRightPositionForMultOrDiv(newNode, numberString.toDouble(), root.MULT)
        } else if (operationType == "/") {
            puttingInTheRightPositionForMultOrDiv(newNode, numberString.toDouble(), root.DIV)
        }
    }

    private fun puttingInTheRightPositionForAddOrSub(newRoot: Node, rightKidValue: Double) {
        newRoot.leftKid = root
        newRoot.rightKid = Node(rightKidValue)
        root = newRoot
        root.leftKid!!.father = root
        root.rightKid!!.father = root
        lastNode = root.rightKid!!
    }

    private fun puttingInTheRightPositionForMultOrDiv(newNode: Node, rightKidValue: Double, operationType: Int) {
        newNode.number = lastNode.number
        lastNode.leftKid = newNode
        lastNode.leftKid!!.father = lastNode
        lastNode.operation = operationType
        lastNode.rightKid = Node(rightKidValue)
        lastNode.rightKid!!.father = lastNode
        lastNode = lastNode.rightKid!!
    }

    fun getResult() : Double {
        return root.getValue()
    }
}
