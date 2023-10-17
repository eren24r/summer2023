package algorithm
/*
Поиск в ширину
 */

fun main(){
    val graph = MyMap<String, Array<String>>()
    graph.addElement("you", arrayOf("alice", "bob", "clairee"))
    graph.addElement("bob", arrayOf("anuj", "peggy"))
    graph.addElement("alice", arrayOf("peggy"))
    graph.addElement("clairee", arrayOf("thom", "jonny"))
    graph.addElement("anuj", arrayOf())
    graph.addElement("peggy", arrayOf())
    graph.addElement("thom", arrayOf())
    graph.addElement("jonny", arrayOf())

    val dequeMans = ArrayDeque<String>()
    graph.getValue("you")?.forEach { dequeMans.add(it) }
    var listOfDec = emptyArray<String>()

    while (!dequeMans.isEmpty()){
        val person = dequeMans.first()
        dequeMans.removeFirst()
        if(person !in listOfDec){
            println(person)
            if(isThisMan(person)){
                println("$person this Person!")
                break
            }else{
                graph.getValue(person)?.forEach { dequeMans.add(it) }
            }
        }
        listOfDec = listOfDec.plus(person)
    }
}

fun isThisMan(name: String): Boolean{
    return name[0] == 'k' || name[0] == 't'
}