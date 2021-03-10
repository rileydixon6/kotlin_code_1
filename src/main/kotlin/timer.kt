import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Calendar.*


class Times2 {

    val listTimes = mutableListOf<String>()
    val listHours = mutableListOf<String>()
    var hourMinSec = mutableListOf<Int>()
    val finalList = mutableListOf<Int>()
    val dates = mutableListOf<Int>()
    val hours = mutableListOf<Int>()
    val minutes = mutableListOf<Int>()
    val seconds = mutableListOf<Int>()



    fun getTime() {

        val current = LocalDateTime.now()
        val dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        val timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss")
        val timeFormatted:String = current.format(timeFormatter)
        val dateFormatted:String = current.format(dateFormatter)
        val now = getInstance()



        println("Current Date and Time is: $dateFormatted")

        listTimes.add(dateFormatted)
        listHours.add(timeFormatted)
        val date = now.get(DATE)
        val hour = now.get(HOUR)
        val min = now.get(MINUTE)
        val sec = now.get(SECOND)
        hourMinSec.add(date)
        hourMinSec.add(hour)
        hourMinSec.add(min)
        hourMinSec.add(sec)


    }

    fun calculate(): String {


        if(( hourMinSec[4] > hourMinSec[0]) and (hourMinSec[1] > hourMinSec[5])){
            finalList.add(hourMinSec[4] - hourMinSec[0] - 1)
        }
        else{
            finalList.add(hourMinSec[4] - hourMinSec[0])
        }

        if((hourMinSec[5] > hourMinSec[1]) and (hourMinSec[2] > hourMinSec[6])){
            finalList.add(hourMinSec[5] - hourMinSec[1] - 1)
        }
        else{
            finalList.add(hourMinSec[5] - hourMinSec[1])
        }
        if((hourMinSec[6] > hourMinSec[2]) and (hourMinSec[3] > hourMinSec[7])){
                finalList.add(hourMinSec[6] - hourMinSec[2] - 1)
            }
        else{
                finalList.add(hourMinSec[6] - hourMinSec[2])
        }
        if(hourMinSec[3] > hourMinSec[7]) {
            finalList.add(hourMinSec[7] - hourMinSec[3] + 60)
        }
        else{
            finalList.add(hourMinSec[7] - hourMinSec[3])
        }

        val diffDay = finalList[0]
        val diffHour = finalList[1]
        val diffMin = finalList[2]
        val diffSec = finalList[3]

        dates.add(diffDay)
        hours.add(diffHour)
        minutes.add(diffMin)
        seconds.add(diffSec)

        var difference : String = ""

        if((diffDay == 0) and (diffHour == 0) and (diffMin == 0)){
            difference = ("The time difference is: $diffSec seconds")
        }
        if((diffDay == 0) and (diffHour == 0) and (diffMin != 0)){
            difference = ("The time difference is: $diffMin minutes and $diffSec seconds")
        }
        if((diffDay == 0) and (diffHour != 0)){
            difference = ("The time difference is: $diffHour hours $diffMin minutes and $diffSec seconds")
        }
        if((diffDay != 0)){
            difference = ("The time difference is $diffDay days, $diffHour hours, $diffMin minutes, and $diffSec seconds")
        }

/*        val difference = when{
                ((diffDay == 0) and (diffHour == 0) and (diffMin == 0)) <- "The time difference is: $diffSec seconds"

                ((diffDay == 0) and (diffHour == 0) and (diffMin != 0)) <- "The time difference is: $diffMin minutes and $diffSec seconds"

                ((diffDay == 0) and (diffHour != 0)) <- "The time difference is: $diffHour hours $diffMin minutes and $diffSec seconds"

                (diffDay != 0) <- "The time difference is $diffDay days, $diffHour hours, $diffMin minutes, and $diffSec seconds"

                else <- "Error with difference calculation"
        }*/

        hourMinSec.removeAt(0)
        hourMinSec.removeAt(0)
        hourMinSec.removeAt(0)
        hourMinSec.removeAt(0)

        finalList.removeAt(0)
        finalList.removeAt(0)
        finalList.removeAt(0)
        finalList.removeAt(0)

        return difference
    }

    fun average() {

        var aveDate = dates.sum() / dates.size
        var aveHour = hours.sum() / hours.size
        var aveMin = minutes.sum() / minutes.size
        var aveSec = seconds.sum() / seconds.size


        if (aveSec > 60) {
            aveMin += (aveSec / 60)
        }
        if (aveSec > 60){
            aveSec %= 60
        }
        if (aveMin > 60){ aveHour += (aveMin / 60)
            aveMin %= 60
        }
        if (aveHour > 24){ aveDate += (aveHour / 24)
            aveHour %= 24
        }

        val average = when{
            (aveDate == 0) and (aveHour == 0) and (aveMin == 0) -> "$aveSec sec"

            (aveDate == 0) and (aveHour == 0) and (aveMin != 0) -> "$aveMin min and $aveSec sec"

            (aveDate == 0) and (aveHour != 0) -> "$aveHour hours, $aveMin min, and $aveSec sec"

            else -> "$aveDate days, $aveHour hours, $aveMin min, and $aveSec sec"
        }

        println(average)

    }

}
class Myapp2 {

    val time = Times2()

    fun begin() {

        while (true) {
            time.getTime()
            if (time.hourMinSec.size >= 8){
                println(time.calculate())
                time.average()
            }
            println("Press any 'Enter' to continue and E to Exit: ")
            val entered = readLine()
            if (entered == "E"){
                break
            }

        }
    }

}

fun main() {
    val app = Myapp2()
    app.begin()
}