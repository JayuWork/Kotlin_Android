package com.tansquare.secureapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_show_toast.setOnClickListener {
            log("Button click event captured")
        }
        kotlinTraining()
    }

    fun kotlinTraining() {
        ifAsExpression()
        whenAsExpression()
        functions()
        functionsAsExpression()
        extensionFunction()
        namedParameterAndDefaultParameter()
        extensionFunctionSecond()
        infixFunction()
        classDefination()
        objectDeclaration()
        companionObject()
        lambaFunctions()
        withAndApply()
        collections1()
        lambaInCollections()
        predicateInCollections()
        nullSafetyCalls()
        extraClass1()
        dataClass()
    }

    fun dataClass() {
        var dataObj = DataClassExample("jayu", "990", 32)
//        dataObj.
    }


    data class DataClassExample(var name: String, var phone: String, var age: Int) {

    }


    fun extraClass1() {
        var minList = listOf(1, 2, 3).reduce { sum, element -> sum + element }
        var minList2 = listOf(1, 2, 3).fold(0) { sum, element -> sum + element }

        log("" + minList + " --  " + minList2)

    }

    fun nullSafetyCalls() {
        // WAP to find out length of name
        val name: String? = "Steve"     // change it to null and see the effect in output

        // 1. Safe Call ( ?. )
        // Returns the length if 'name' is not null else returns NULL
        // Use it if you don't mind getting NULL value
        println("The length of name is ${name?.length}")


        // 2. Safe Call with let ( ?.let )
        // It executes the block ONLY IF name is NOT NULL
        name?.let {
            println("The length of name is ${name.length}")
        }


        // 3. Elvis-operator ( ?: )
        // When we have nullable reference 'name', we can say "is name is not null", use it,
        // otherwise use some non-null value"
        val len = if (name != null)
            name.length
        else
            -1

        val length = name?.length ?: -1
        println("The length of name is ${length}")

        // 4. Non-null assertion operator ( !! )
        // Use it when you are sure the value is NOT NULL
        // Throws NullPointerException if the value is found to be NULL

        println("The length of name is ${name!!.length}")

    }

    fun predicateInCollections() {
        val numbers = listOf(1, 3, 10, 35, 4, 9, 50)

        var myPredicate = { num: Int -> num > 10 }

        // Are all elements greater than 10?
        val checkAll = numbers.all(myPredicate)// { num -> num > 10 }
        log(" checkAll $checkAll")

        // Does any of these elements satisfy the predicate?
        val checkAny = numbers.any(myPredicate)// { num -> num > 10 }
        log(" checkAny $checkAny")

        // Number of elements that satify the predicate.
        val checkCount = numbers.count(myPredicate)// { num -> num > 10 }
        log(" checkCount $checkCount")

        // Number of elements that satify the predicate.
        val checkFirst = numbers.find(myPredicate)// { num -> num > 10 }
        log(" checkFirst $checkFirst")
    }

    fun lambaInCollections() {
        val intList: List<Int> = listOf(1, 3, 10, 35, 4, 9, 50)


//        val smallList = intList.filter { v -> v < 10 }
        val smallListit = intList.filter { it < 10 } // same as { v -> v < 10 }

        for (item in smallListit) {
            log(" Item " + item)
        }

//        val squareList = intList.map { v -> v * v }
        val squareListit = intList.map { it * it } // same as { v -> v * v }

        for (itemSq in squareListit) {
            log(" ItemSq " + itemSq)
        }

        val comboListSmallListSquare = intList.filter { it < 10 }.map { it * it }

        for (smallItemSq in comboListSmallListSquare) {
            log(" SmallItemSq " + smallItemSq)
        }

        val people = listOf(
            PersonClass("Me", 32),
            PersonClass("Sis", 28),
            PersonClass("Mum", 52),
            PersonClass("Wife", 27)
        )
        var names = people.map { it.name } // { p -> p.name }
        for (name in names) {
            log(" name " + name)
        }

        var namesStartWithM =
            people.filter { it.name.startsWith("M") }
                .map { it.name }  // person -> person.name.startsWith
        for (name in namesStartWithM) {
            log(" namewithM " + name)
        }
    }

    class PersonClass(var name: String, var age: Int) {

    }

    fun collections1() {

    }

    fun withAndApply() {

        var person = Person()

        with(person) {
            name = "Jayu"
            age = 32
            StartRunning()
        }

        person.apply {
            name = "Jayanand"
            age = 31

        }.StartRunning()

        person.StartRunning()

    }

    class Person() {
        var name: String = ""
        var age: Int = -1

        fun StartRunning() {
            println(" $name aged $age is ready to run now ")
        }
    }

    fun lambaFunctions() {

        val program = Program()

        program.addTwoNumbers(2, 7)     // Simple way... for better understanding

        program.addTwoNumbers(2, 7, object : MyInterface {   // Using Interface / OOPs way

            override fun execute(sum: Int) {
                println(sum)    // Body
            }
        })

        val test: String = "Hello"

        val myLambda: (Int) -> Unit = { s: Int -> println(s) }   // Lambda Expression [ Function ]
        // Variable Name   : Signature = {parameters->body}
        // val lambdaFunctionName: (Param1 Type, Param2 Type) -> return Type = { Param1: Type, Param2: Type -> body }
        program.addTwoNumbers(2, 7, myLambda)
    }


    class Program {

        // High Level Function with Lambda as Parameter
        fun addTwoNumbers(
            a: Int,
            b: Int,
            action: (Int) -> Unit
        ) {

            val sum = a + b
            action(sum)     // println(sum)
        }


        // Using Interface / Object Oriented Way
        fun addTwoNumbers(
            a: Int,
            b: Int,
            action: MyInterface
        ) {
            val sum = a + b
            action.execute(sum)
        }

        // Simple way.. Just for Better Understanding
        fun addTwoNumbers(
            a: Int,
            b: Int
        ) {

            val sum = a + b
            println(sum)
        }
    }

    interface MyInterface {
        fun execute(sum: Int)
    }

    fun companionObject() {
        // Static class declaration
        log("name is ${CompanionObjectClass.printMyName()}")
        CompanionObjectClass.name = "Jayanand"
        log("After changing name is ${CompanionObjectClass.printMyName()}")
    }

    class CompanionObjectClass {

        companion object {
            var name: String = "jayu"  // static variable
            fun printMyName() {    // static function
                println("student id is : ${name}")
            }
        }
    }

    fun objectDeclaration() {

        // Static class declaration
        log("name is ${StudentObjectClass.printMyName()}")
        StudentObjectClass.name = "Jayanand"
        log("After changing name is ${StudentObjectClass.printMyName()}")
    }


    object StudentObjectClass {
        var name: String = "jayu"  // static variable
        fun printMyName() {    // static function
            println("student id is : ${name}")
        }

        init {
            // Initialize if anything
        }
    }

    fun classDefination() {
        var student = StudentX("jayu", 10)
        log("student id is : ${student.id}")
    }

    class StudentX(var name: String) {
        var id: Int = -1

        init {
            //
            println("Student name is $name and id is $id")
        }

        constructor(n: String, i: Int) : this(n) {
            this.id = i
        }
    }

    fun infixFunction() {
        val x: Int = 10
        val y: Int = 20
        val greaterVal: Int = x GreaterValue y // same as x.GreaterValue(y)
    }

    infix fun Int.GreaterValue(aOther: Int): Int {
        if (this > aOther) {
            return this
        } else {
            return aOther
        }
    }

    fun extensionFunctionSecond() {
        val str1 = " Hello "
        val str2 = " World "
        var str3 = " Hey "

        log(str3.addStrings(str1, str2))
    }

    fun String.addStrings(str1: String, str2: String): String = this + str1 + str2


    fun namedParameterAndDefaultParameter() {
        // default Parameter
        var vol = calculateVolume(1, 4)
        log("default Parameter : $vol")

        // default Parameter 2
        vol = calculateVolume(1, 4, 30)
        log("default Parameter 2  : $vol")

        // named Parameter 1
        vol = calculateVolume(aLen = 1, aHt = 10, aBred = 4)
        log("named Parameter 1 : $vol")

        // named Parameter 2
        vol = calculateVolume(aHt = 10, aBred = 4, aLen = 1)
        log("named Parameter 2 : $vol")

        // named Parameter 3
        vol = calculateVolume(aHt = 10, aBred = 4, aLen = 1)
        log("named Parameter 3 : $vol")
    }

    fun calculateVolume(aLen: Int, aBred: Int, aHt: Int = 10): Int {
        return aLen * aBred * aHt
    }

    fun extensionFunction() {
        var extFunObj = ExtensionFunctionClass()
        var passedStudent = extFunObj.studentPassed(79)
        var distinctionStudent = extFunObj.isDistinction(79)
        log("Student passed : $passedStudent")
        log("Student Distinction : $distinctionStudent")

    }

    fun ExtensionFunctionClass.isDistinction(aMarks: Int): Boolean {
        return aMarks > 80
    }

    class ExtensionFunctionClass {
        fun studentPassed(aMarks: Int): Boolean {
            return aMarks > 35
        }
    }

    fun functionsAsExpression() {
        var maxVar = max(2, 3)
    }

    fun maxOneLine(aVariable: Int, bVariable: Int): Int =
        if (aVariable > bVariable) aVariable else bVariable


    fun max(aVariable: Int, bVariable: Int): Int {
        if (aVariable > bVariable) {
            return aVariable
        }
        return bVariable
    }

    fun functions() {
        var sum = add(2, 3)
        log("sum is $sum")
    }

    fun add(aVariable: Int, bVariable: Int): Int {

        return (aVariable + bVariable)
    }

    fun loopsIteration() {

        // range variable with auto increment
        for (i in 1..10) {
            log("Hello $i")
        }

        // Labeled forloop
        myLoop@ for (i in 1..3) {
            for (j in 1..3) {
                log("$i $j")
                if (i == 2 && j == 2)
                    break@myLoop
            }
        }

        // Labeled forloop
        myContLoop@ for (i in 1..3) {
            for (j in 1..3) {
                log("$i $j")
                if (i == 2 && j == 2)
                    continue@myContLoop
            }
        }

        var i = 1;
        while (i < 5) {
            log("hello while")
            i++
        }

        do {

        } while (i < 5)
    }

    fun ifAsExpression() {
        var a = 2
        var b = 5
        var maxValue: Int = if (a > b)
            a
        else
            b

        log("MaxValue $maxValue")
    }

    fun whenAsExpression() {
        val x = 3
        var str: String = when (x) {
            1 -> "x is 1"
            2 -> "x is 2 "
            in 3..5 -> " x lies in bw 3-5"
            else -> " x value is unknown"
        }

        log("WhileasExp value of str = $str")


        when (x) {
            1 -> log("x is 1")
            2 -> log("x is 2 ")
            in 3..5 -> log(" x lies in bw 3-5")
            else -> log(" x value is unknown")
        }
    }

    fun log(msg: String) {
        println("JU_LOGS $msg")
    }


}