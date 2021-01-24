import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import java.util.Calendar.*


class Times {

    val listTimes = mutableListOf<String>()
    val listHours = mutableListOf<String>()
    val listNows = mutableListOf<Calendar>()
    var hourminsec = mutableListOf<Int>()



    fun getTime() {

        val current = LocalDateTime.now()
        val dateformatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        val timeformatter = DateTimeFormatter.ofPattern("HH:mm:ss")
        val timeformatted:String = current.format(timeformatter)
        val dateformatted:String = current.format(dateformatter)
        var now = Calendar.getInstance()



        println("Current Date and Time is: $dateformatted")

        listTimes.add(dateformatted)
        listHours.add(timeformatted)
        listNows.add(now)
        var hours = now.get(HOUR)
        var min = now.get(MINUTE)
        var sec = now.get(SECOND)
        hourminsec.add(hours)
        hourminsec.add(min)
        hourminsec.add(sec)

        println(hourminsec)

    }

    fun calculate() {
        val final_list = mutableListOf<Int>()

        if(hourminsec[3] > hourminsec[0]) {
            final_list.add(hourminsec[3] - hourminsec[0] - 1)
        }
        else {
            final_list.add(hourminsec[3] - hourminsec[0])
        }


        if((hourminsec[4] > hourminsec[1]) and (hourminsec[2] > hourminsec[5])){
                final_list.add(hourminsec[4] - hourminsec[1] - 1)
            }
        else{
                final_list.add(hourminsec[4] - hourminsec[1])
        }

        if(hourminsec[2] > hourminsec[5]) {
            final_list.add(hourminsec[5] - hourminsec[2] + 60)
        }
        else{
            final_list.add(hourminsec[5] - hourminsec[2])
        }

        listNows.removeAt(0)
        var diffhour = final_list[0]
        var diffmin = final_list[1]
        var diffsec = final_list[2]

        println("The difference is $diffhour hours, $diffmin minutes, and $diffsec seconds")
        hourminsec.removeAt(0)
        hourminsec.removeAt(0)
        hourminsec.removeAt(0)

    }

}
class Myapp {

    val time = Times()

    fun begin() {

        while (true) {
            time.getTime()
//            println(time.listTimes)
            if (time.listNows.size >= 2){
                time.calculate()
            }
            println("Press C to continue and E to Exit: ")
            val entered = readLine()
            if (entered == "E"){
                break
            }
        }
    }

}

fun main() {
    val app = Myapp()
    app.begin()
}