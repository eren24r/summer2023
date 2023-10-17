package filesKt

import java.util.Scanner
import java.util.concurrent.TimeUnit

fun consoleP(x: Int, y: Int, symUpDown: String, symRightLeft: String): String{
    var poleX = ""
    for(i in 1..y){
        poleX += symUpDown
    }
    var empty = ""
    for(i in 3..y){
        empty += " "
    }
    var poleY = symRightLeft + empty + symRightLeft
    for(i in 3..x){
        poleY = poleY + "\n" + symRightLeft + empty + symRightLeft
    }

    return poleX + "\n" + poleY + "\n" + poleX
}

fun main(){
    val corX = 40
    val corY = 40

    var console = consoleP(corX,corY,"≣", "║")
    //var console = consoleP(corX,corY,"⚄", "⁑")

    println(console)

    while (true) {
        val tmpFig = Figure(corX, corY)
        var tmpX = 1
        val tmpY = 15
        console = tmpFig.print(tmpX, tmpY, console)
        clearCns()
        println(console)
        var tmpConsole = ""

        while (true) {
            var scn = Scanner(System.`in`)
            var dr = scn.nextLine();
            if(dr == "d"){
                tmpConsole = tmpFig.moveToRight(console)
                if(tmpConsole != "error") {
                    console = tmpConsole
                    clearCns()
                    println(console)
                    TimeUnit.MILLISECONDS.sleep(250)
                }
            }

            if(dr == "a"){
                tmpConsole = tmpFig.moveToLeft(console)
                if(tmpConsole != "error") {
                    console = tmpConsole
                    clearCns()
                    println(console)
                    TimeUnit.MILLISECONDS.sleep(250)
                }else{
                    continue
                }
            }

            if(dr == "s"){
                tmpConsole = tmpFig.moveToDown(console)
                if(tmpConsole != "error") {
                    console = tmpConsole
                    clearCns()
                    println(console)
                    TimeUnit.MILLISECONDS.sleep(250)
                }else{
                    break
                }
            }
        }
    }

}

class Figure(private var x: Int, private var y: Int) {
    private var fig = "  ▇▇    " + "\n" +
                      "  ▇▇    " + "\n" +
                      "▇▇▇▇▇▇▇▇" + "\n" +
                      "▇▇▇▇▇▇▇▇"

    private var corX = 0
    private var corY = 0

    fun moveToDown(console: String): String{
        var newConsole = console

        var cntNewLine = 0
        var sizeNewLine = fig.count{it == '\n'}
        var tmpINew = 0
        var isCan = true

        for(i in fig.indices){
            if(cntNewLine == sizeNewLine){
                //println(fig[i] + "-" + newConsole[(this.corX + cntNewLine) * this.x + this.corY + 1 + tmpINew + this.corX + cntNewLine + this.y])
                if(fig[i] != ' '){
                    if (newConsole[(this.corX + cntNewLine) * this.x + this.corY + 1 + tmpINew + this.corX + cntNewLine + this.y + 1] != ' '){
                        isCan = false
                        break
                    }
                }
                tmpINew++
            }
            if(fig[i] == '\n'){
                cntNewLine++
            }
        }

        if(isCan) {
            for (i in fig.indices) {
                if (fig[i] != '\n') {
                    newConsole = newConsole.substring(0, (this.corX) * this.x + this.corY + 1 + i + this.corX) + ' ' + newConsole.substring((this.corX) * this.x + this.corY + 1 + i + this.corX + 1, newConsole.length)
                } else {
                    break
                }
            }

            this.corX += 1
            return print(this.corX, this.corY, newConsole)
        }else{
            return "error"
        }
    }

    fun moveToRight(console: String): String{
        var newConsole = console

        var cntNewLine = 0
        var tmpINew = 0
        var isCanGl = true
        var lastSind = 0

        for(i in fig.indices){
            if(fig[i] != ' '){
                lastSind = tmpINew
            }
            if(fig[i] == '\n'){
                //println(newConsole[(this.corX + cntNewLine) * this.x + this.corY + 1 + lastSind + this.corX + cntNewLine + 1])
                if(newConsole[(this.corX + cntNewLine) * this.x + this.corY + 1 + lastSind + this.corX + cntNewLine + 1] != ' '){
                    isCanGl = false
                    break
                }
                tmpINew = 0
                cntNewLine++
            }else{
                tmpINew++
            }
        }

        //println(newConsole[(this.corX + cntNewLine) * this.x + this.corY + 1 + lastSind + this.corX + cntNewLine])
        if(newConsole[(this.corX + cntNewLine) * this.x + this.corY + 1 + lastSind + this.corX + cntNewLine + 1] != ' '){
            isCanGl = false
        }

        if(isCanGl) {
            var isCan = true
            var tmp = 0
            var cntN = this.corX

            for (i in fig.indices) {
                if (fig[i] != '\n' && isCan) {
                    newConsole = newConsole.substring(
                        0,
                        (this.corX + tmp) * this.x + this.corY + 1 + cntN
                    ) + ' ' + newConsole.substring(
                        (this.corX + tmp) * this.x + this.corY + 1 + cntN + 1,
                        newConsole.length
                    )
                    isCan = false
                } else if (fig[i] == '\n') {
                    tmp += 1
                    cntN += 1
                    isCan = true
                }
            }

            this.corY += 1
            return print(this.corX, this.corY, newConsole)
        }else{
            return "error"
        }
    }

    fun moveToLeft(console: String): String{
        var newConsole = console

        var cntNewLine = 0
        var tmpINew = 0
        var isCanGl = true
        var isLeft = true

        for(i in fig.indices){
            if(fig[i] != ' ' && isLeft){
                isLeft = false
                if(newConsole[(this.corX + cntNewLine) * this.x + this.corY + 1 + tmpINew + this.corX + cntNewLine - 1] != ' '){
                    isCanGl = false
                    break
                }
            }
            if(fig[i] == '\n'){
                cntNewLine++
                tmpINew = 0
                isLeft = true
            }else{
                tmpINew++
            }
        }

        if(isCanGl) {
            var tmp = 0
            var cntN = this.corX
            var tmpI = 0

            for (i in 0 until fig.length - 1) {
                if (fig[i] != '\n' && fig[i + 1] == '\n') {
                    newConsole = newConsole.substring(
                        0,
                        (this.corX + tmp) * this.x + this.corY + 1 + cntN + tmpI
                    ) + ' ' + newConsole.substring(
                        (this.corX + tmp) * this.x + this.corY + 1 + cntN + 1 + tmpI,
                        newConsole.length
                    )
                } else if (fig[i] != '\n') {
                    tmpI += 1
                } else {
                    tmp += 1
                    cntN += 1
                    tmpI = 0
                }
            }
            newConsole = newConsole.substring(
                0,
                (this.corX + tmp) * this.x + this.corY + 1 + cntN + tmpI
            ) + ' ' + newConsole.substring(
                (this.corX + tmp) * this.x + this.corY + 1 + cntN + 1 + tmpI,
                newConsole.length
            )

            this.corY -= 1
            return print(this.corX, this.corY, newConsole)
        }else{
            return "error"
        }
    }

    fun print(x: Int, y: Int, console: String): String{
        this.corX = x
        this.corY = y

        var newConsole = console
        var tmp = 0
        var tmpI = 0
        var cntN = corX

        for(i in fig.indices){
            if(fig[i] != '\n'){
                newConsole = newConsole.substring(0, (x + tmp) * this.x + y + 1 + tmpI + cntN) + fig[i] +  newConsole.substring((x + tmp) * this.x + y + 1 + tmpI + cntN + 1, newConsole.length)
                tmpI += 1
            }else{
                tmp += 1
                tmpI = 0
                cntN += 1
            }
        }
        //print("\u001b[H\u001b[2J")
        return newConsole
    }
}

fun clearCns(){
    ProcessBuilder("clear").inheritIO().start().waitFor()
}