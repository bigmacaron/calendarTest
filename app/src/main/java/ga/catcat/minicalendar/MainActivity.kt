package ga.catcat.minicalendar

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import ga.catcat.minicalendar.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var mCal : Calendar
    private lateinit var binding : ActivityMainBinding
    private var page = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.tvTest.setOnClickListener {
            initView()
        }

        binding.button.setOnClickListener {
            page -= 1
            setDate(page)

        }
        binding.button2.setOnClickListener {

            page += 1

            setDate(page)
        }


    }



    private fun initView(){
        val now : Long = System.currentTimeMillis()
        val date = Date(now)

        val curYearFormat = SimpleDateFormat("yyyy", Locale.KOREA)
        val curMonthFormat = SimpleDateFormat("MM", Locale.KOREA)
        val curDayFormat = SimpleDateFormat("dd", Locale.KOREA)

        val arr = ArrayList<Any>()
        val dayList = ArrayList<String>()
        dayList.add("일")
        dayList.add("월")
        dayList.add("화")
        dayList.add("수")
        dayList.add("목")
        dayList.add("금")
        dayList.add("토")
        mCal = Calendar.getInstance()
        mCal.set(Integer.parseInt(curYearFormat.format(date)), Integer.parseInt(curMonthFormat.format(date))+page, 1)
        Log.d("이번년", "${mCal.get(Calendar.YEAR)}")
        Log.d("이번달", "${mCal.get(Calendar.MONTH)+1}")
        Log.d("오늘", "${mCal.get(Calendar.DATE)}")
        val dayNum: Int = mCal.get(Calendar.DAY_OF_WEEK)
        Log.d("dayNum","$dayNum")
        for(i in 1 until dayNum){
            dayList.add("공백")
        }
        for(i in 1 .. mCal.getActualMaximum(Calendar.DAY_OF_MONTH)){
            dayList.add(i.toString())
        }
        for(i in dayList){
            Log.d("i ", "${i}")
        }
    }



    private fun setDate(page : Int){
        val now : Long = System.currentTimeMillis()
        val date = Date(now)

        val curYearFormat = SimpleDateFormat("yyyy", Locale.KOREA)
        val curMonthFormat = SimpleDateFormat("MM", Locale.KOREA)
        val curDayFormat = SimpleDateFormat("dd", Locale.KOREA)

        val arr = ArrayList<Any>()
        val dayList = ArrayList<String>()
        dayList.add("일")
        dayList.add("월")
        dayList.add("화")
        dayList.add("수")
        dayList.add("목")
        dayList.add("금")
        dayList.add("토")
        mCal = Calendar.getInstance()
        mCal.set(Integer.parseInt(curYearFormat.format(date)), Integer.parseInt(curMonthFormat.format(date))+page, 1)
        Log.d("이번년", "${mCal.get(Calendar.YEAR)}")
        Log.d("이번달", "${mCal.get(Calendar.MONTH)+1}")
        Log.d("오늘", "${mCal.get(Calendar.DATE)}")
        val dayNum: Int = mCal.get(Calendar.DAY_OF_WEEK)
        Log.d("dayNum","$dayNum")
        for(i in 1 until dayNum){
            dayList.add("공백")
        }
        for(i in 1 .. mCal.getActualMaximum(Calendar.DAY_OF_MONTH)){
            dayList.add(i.toString())
        }
        for(i in dayList){
            Log.d("i ", "${i}")
        }
    }
}