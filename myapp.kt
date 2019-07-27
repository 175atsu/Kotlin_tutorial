//kotlinc myapp.kt -include-runtime -d myapp.jar
//java -jar myapp.jar
//変数
// -val 変数変更できない
// -var　変数変更できる

/* fun main(args: Array<String>){
  //型の話
  //文字列String 、文字：Char
  val msg: String = "Hello World"
  println(msg)
  val c:Char = 'a'

  //Byte, Short, Int, Long 右に行くほど桁数が多い
  val i: Int = 100
  val l: Long = 55555555555555L

  //Float,Double 基本Double
  //F をつけてあげないといけないのですが、L の方は必ず大文字にしないといけないのですが、F の方は小文字でも大文字でも構いません。
  val d: Double = 234.523
  val f: Float = 12.344F

  //Boolean (true/false)
  var flag: Boolean = true

  //演算
  val x = 10
  print(x/3)
  println(x/3.0)
  println(x%3)

  var y = 5
  y++
  println(y) //6
  y--
  println(y) //5

  var z = 4
  //z = z +12
  z += 12

  //AND OR NOT = && || !
  println(!flag) //false

  println("hello" + "World")
  val name = "taguchi"
  println("my name is $name")
  println("my score is ${12+32}")

  // \n:改行　　\t:タブ
  println("hello\n wor\tld")

  //if
  val score = 30
  if (score > 80) {
    println("great!")
  } else if (score > 60) {
    println("Good!")
  } else{
    println("so so ...")
  }

  //値を返せる
  val result = if (score > 80) "Great" else "so so .."
  println(result)

  //when
  val num = 5
  when (num) {
    0 -> println("Zero")
    1 -> println("One")
    2,3 -> println("Two or Three")
    in 4..10 -> println("Many")
    else -> println("other")
  }
  //値を返せる
  val result2 = when (num) {
    0 -> "Zero"
    1 -> "One"
    2,3 -> "Two or Three"
    in 4..10 -> "Many"
    else -> "other"
  }
  println(result2)

  //while
  var i = 100
  while (i < 10) {
    println("loop: $i")
    i++
  }
  //do-while
  do {
    println("loop2: $i")
    i++
  } while (i <10)

  //for(変数　in データの集合)　処理
  //break ループ抜け出す
  //continue 処理を実行せずに次のループへ写る
  for (i in 0..9) {
     if (i == 5) break
     if (i == 5) continue
    println(i)
  }

  //関数
  //初期値入れられる
  fun sayHi(name: String = "taguchi", age: Int = 23){
    println("hi! $name ($age)")

  }
  sayHi() //初期値入る
  sayHi("tom",22) //引数
  sayHi("bob", 20)

  fun sayHi():String {
    return "hi!"
  }
  fun sayHi() = "hi!" //こう書くこともできる。

  val msg = sayHi()
  println(msg)

  //Class
  // -data: properpty
  // -fun: method
  //val user:User = User()
  val tom = User("tom") //インスタンス
  println(tom.team) //RED
  tom.team = "blue"
  println(tom.team)
  tom.team = ""
  println(tom.team) //BLUE
  val bob = AdminUser("bob")
  println(bob.name)
  bob.sayHello() // hello
  bob.sayHi()  //[admini] hi bob
}

 open class User(var name: String) { //コンストラクタ引数
  var name = name
  var team = "red"
    //getter
    get() {
      return field.toUpperCase()
    }
    get() = field.toUpperCase()
    //setter
    set(value)  {
      if (value != "") {
        field = value
      }
    }
  init {
    println("instance created, name: $name, team: $team")
  }
  open fun sayHi() {
    println("hi $name")
  }
  //User -> AdminUser
}

class AdminUser(name: String): User(name){
  fun sayHello() {
    println("hello $name")
  }
  override fun sayHi() {
    println("[admin] hi $name")
  }
}


//18
// アクセス修飾子
// - public どこからでも
// - protected そのクラス＋サブクラス
// - private そのクラス

class AdminUser(name: String): User(name) {
  fun sayHello() {
    println("hello $name")
  }
  override fun sayHi() {
    println("[admin] hi $name")
  }
}
open class User(private var name: String) {
  open fun sayHi() {
    println("hi $name")
  }
}

fun main(args: Array<String>) {
  val bob = AdminUser("bob")
  println(bob.name)
  bob.sayHello()
  bob.sayHi()
}

//19クラスを拡張
// 拡張

fun User.sayHello() {
  println("hello $name")
}

fun User.sayHi() {
  println("[ext] hi $name")
}

val User.myName: String
  get() = "I am $name"

class User(var name: String) {
  fun sayHi() {
    println("hi $name")
  }
}

fun main(args: Array<String>) {
  val tom = User("tom")
  tom.sayHello() // hello tom
  tom.sayHi() // hi tom
  println(tom.myName) // i am tom
}


//20抽象クラス
// 抽象クラス -> 具象クラス
// User -> Japanese, American

abstract class User {
  abstract fun sayHi()
}

class Japanese: User() {
  override fun sayHi() {
    println("こんにちは！")
  }
}

class American: User() {
  override fun sayHi() {
    println("Hi!")
  }
}

fun main(args: Array<String>) {
  val tom = American()
  val aki = Japanese()
  tom.sayHi()
  aki.sayHi()
}

//21インターフェース
// Interface

 interface Sharable {
  // 抽象プロパティ
  val version: Double
  // 抽象メソッド
  fun share()
  // メソッド
  fun getInfo() {
    println("Share I/F ($version)")
  }
}

class User: Sharable {
  override val version = 1.1
  override fun share() {
    println("Sharing...")
  }
}

fun main(args: Array<String>) {
  val user = User()
  user.share()
  user.getInfo()
}

//22ジェネリクス
// generics

class MyInteger {
  fun getThree(x: Int) {
    println(x)
    println(x)
    println(x)
  }
}

 class MyData<T> {
  fun getThree(x: T) {
    println(x)
    println(x)
    println(x)
  }
}

fun main(args: Array<String>) {
  val mi = MyInteger()
  mi.getThree(55)
  val i = MyData<Int>()
  i.getThree(32)
  val s = MyData<String>()
  s.getThree("hello")
}


//23データクラス
// data class

data class Point(val x: Int, val y: Int)

fun main(args: Array<String>){
  val p1 = Point(3, 5)
  val p2 = p1.copy()
  val p2 = Point(3, 5)

  println(p1)
  println(if (p1 == p2) "same" else "not same")

  val (x, y) = p1
  println("$x:$y")
}


//24List
// Collection

- List (Immutable/Mutable)
- Set (Immutable/Mutable)
- Map (Immutable/Mutable)


fun main(args: Array<String>) {
  //val sales: List<Int> = listOf(20, 30, 40)
  //val sales = listOf(20, 30, 40)
  val sales = mutableListOf(20, 30, 40)
  println(sales[1]) // 30
  sales[1] = 50
  println(sales.size) // 3
  for (sale in sales) {
    println(sale)
  }
}

//25Setを操作する
// Collection
- List (Immutable/Mutable)
- Set (Immutable/Mutable)
- Map (Immutable/Mutable)


fun main(args: Array<String>) {
  /*val answers: Set<Int> = setOf(5, 3, 8, 5)
  val answers = setOf(5, 3, 8, 5)
  val answers = mutableSetOf(5, 3, 8, 5)
  answers.add(15)
  answers.remove(3)
  println(answers)
  println(answers.contains(3)) // true

  val set1 = setOf(1, 3, 5, 8)
  val set2 = setOf(3, 5, 8, 9)
  println(set1.intersect(set2))
  println(set1.union(set2))
  println(set1.subtract(set2))
}

//26Mapを操作
// Collection

- List (Immutable/Mutable)
- Set (Immutable/Mutable)
- Map (Immutable/Mutable)

fun main(args: Array<String>) {
  //val users: Map<String, Int> = mapOf("taguchi" to 40, "fkoji" to 80, "dotinstall" to 60)
  val users = mapOf("taguchi" to 40, "fkoji" to 80, "dotinstall" to 60)
  //val users = mutableMapOf("taguchi" to 40, "fkoji" to 80, "dotinstall" to 60)
  println(users["taguchi"])  40
  //users["taguchi"] = 55
  println(users.size) // 3
  println(users.keys)
  println(users.values)
  println(users.entries)
}

//27

fun main(args: Array<String>) {
  val prices = listOf(53.2, 48.2, 32.8)
  prices
    .map { n -> n * 1.08 } // 引数 -> 処理
    .map { it * 1.08 }
    .filter { n -> n > 50 }
    .filter { it > 50 }
    .forEach { println(it) }
} */

//28
// 例外処理

class MyException(message: String): Throwable(message)

fun div(a: Int, b: Int) {
  try {
    if (b < 0) {
      throw MyException("not minus!")
    }
    println(a / b)
  } catch (e: ArithmeticException) {
    println(e.message)
  } catch (e: MyException) {
    println(e.message)
  } finally {
    println(" -- end -- ")
  }
}

fun main(args: Array<String>) {
  div(3, 0)
  div(3, -3)
}

// null

fun main(args: Array<String>) {
  /*val s: String = null*/
  val s: String? = null // nullable
  /*println(s)*/

  /*if (s != null) {
    println(s.length)
  } else {
    println(null)
  }*/
  /*println(s?.length)*/
  /*println(s?.length ?: -1)*/
  println(s!!.length)
}
