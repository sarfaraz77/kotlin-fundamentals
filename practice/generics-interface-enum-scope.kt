data class Question<T>(
    val questionText: String, 
    val answer: T, 
    val difficulty: Difficulty
)
enum class Difficulty {
    EASY, MEDIUM, HARD
}

class Quiz: ProgressPrintable {
    override val progressText: String
    	get() = "${answered} of ${total} answered" 
    override fun printProgressBar() {
        repeat(Quiz.answered) { print("▓")}
   		repeat(Quiz.total - Quiz.answered ) { print("▒")}
    	println()
    	println(progressText)
    	}
    
    val question1 = Question<String>("Sodium is an ___","Element", Difficulty.MEDIUM)
    val question2 = Question<Boolean>("Sky is Green. True or False", false , Difficulty.EASY)
    val question3 = Question<Int>("25 x 4", 100, Difficulty.HARD)
    
    fun printQuiz() {
        question1.let {
        	println(it.questionText)
        	println(it.answer)
        	println(it.difficulty)
    	}
    	println()
    	question2.let {
        	println(it.questionText)
        	println(it.answer)
        	println(it.difficulty)
    	}
    	println()
    	question3.let {
        	println(it.questionText)
        	println(it.answer)
        	println(it.difficulty)
    	}
    	println()
    }

	companion object StudentProgress {
    	var total: Int = 10
    	var answered: Int = 3
}
}

interface ProgressPrintable {
    val progressText: String
    fun printProgressBar()
}


fun main() {
    Quiz().apply {
        printQuiz()
    }
}