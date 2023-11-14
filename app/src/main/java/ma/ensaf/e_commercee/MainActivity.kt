package ma.ensaf.e_commercee
import android.graphics.Paint
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var textCafton: TextView
    private lateinit var textBabouches: TextView
    private lateinit var textTarbouch: TextView
    private lateinit var textDejallaba: TextView
    private lateinit var textSac: TextView
    private lateinit var viewPager: ViewPager2
    private lateinit var viewPager1: ViewPager2
    private lateinit var sliderDotspanel: LinearLayout
    private lateinit var sliderDotspanel1: LinearLayout
    private lateinit var viewPagerAdapter: ViewPagerAdapter

    private lateinit var dots: Array<ImageView?>
    private lateinit var dots1: Array<ImageView?>
    private lateinit var timer: Timer
    private var dotscount: Int = 0
    private var dotscount1: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.ViewPager)
        viewPager1 = findViewById(R.id.ViewPager1)
        sliderDotspanel = findViewById(R.id.SliderDots)
        sliderDotspanel1 = findViewById(R.id.SliderDots1)
        viewPagerAdapter = ViewPagerAdapter(this)
        viewPager.adapter = viewPagerAdapter
        val viewPagerAdapter1 = ViewPagerAdapter(this)
        viewPager1.adapter = viewPagerAdapter1
        dotscount = viewPagerAdapter.itemCount
        dotscount1 = viewPagerAdapter.itemCount
        dots = arrayOfNulls(dotscount)
        dots1 = arrayOfNulls(dotscount1)
        for (i in 0 until dotscount) {
            dots[i] = ImageView(this)
            dots[i]?.setImageDrawable(ContextCompat.getDrawable(applicationContext, R.drawable.nonactive_dot))

            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )

            params.setMargins(8, 0, 8, 0)

            sliderDotspanel.addView(dots[i], params)
        }
        viewPagerAdapter1.setData(
            arrayOf(R.drawable.caftan3, R.drawable.caftan10, R.drawable.caftan11),
            arrayOf("tous", "Gauche", "Droit"),
            arrayOf("tous1", "Gauche2", "Droit3")
        )

// Set new data for the second carousel
        viewPagerAdapter1.setData(
            arrayOf(R.drawable.caftan9, R.drawable.caftan2, R.drawable.jj),
            arrayOf("Title1", "Title2", "Title3"),
            arrayOf("Description1", "Description2", "Description3")
        )

        for (i in 0 until dotscount1) {
            dots1[i] = ImageView(this)
            dots1[i]?.setImageDrawable(ContextCompat.getDrawable(applicationContext, R.drawable.nonactive_dot))

            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )

            params.setMargins(8, 0, 8, 0)

            sliderDotspanel1.addView(dots1[i], params)
        }
        dots[0]?.setImageDrawable(ContextCompat.getDrawable(applicationContext, R.drawable.active_dot))
        dots1[0]?.setImageDrawable(ContextCompat.getDrawable(applicationContext, R.drawable.active_dot))

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                for (i in 0 until dotscount) {
                    dots[i]?.setImageDrawable(ContextCompat.getDrawable(applicationContext, R.drawable.nonactive_dot))
                }

                dots[position]?.setImageDrawable(ContextCompat.getDrawable(applicationContext, R.drawable.active_dot))
            }
        })
        viewPager1.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                for (i in 0 until dotscount1) {
                    dots1[i]?.setImageDrawable(ContextCompat.getDrawable(applicationContext, R.drawable.nonactive_dot))
                }

                dots1[position]?.setImageDrawable(ContextCompat.getDrawable(applicationContext, R.drawable.active_dot))
            }
        })

        timer = Timer()
        timer.scheduleAtFixedRate(MyTimerTask(viewPager, dotscount), 2000, 4000)
        timer.scheduleAtFixedRate(MyTimerTask(viewPager1, dotscount1), 2000, 4000)

        textCafton = findViewById(R.id.textCafton)
        textBabouches = findViewById(R.id.textBabouches)
        textTarbouch = findViewById(R.id.textTarbouches)
        textDejallaba = findViewById(R.id.textDjellaba)
        textSac = findViewById(R.id.textsac)

        // Sous-lignez le texte Cafton par défaut
        textCafton.paintFlags = textCafton.paintFlags or Paint.UNDERLINE_TEXT_FLAG

        textCafton.setOnClickListener {
            textCafton.paintFlags = textCafton.paintFlags or Paint.UNDERLINE_TEXT_FLAG
            textBabouches.paintFlags = textBabouches.paintFlags and Paint.UNDERLINE_TEXT_FLAG.inv()
            textTarbouch.paintFlags = textTarbouch.paintFlags and Paint.UNDERLINE_TEXT_FLAG.inv()
            textDejallaba.paintFlags = textDejallaba.paintFlags and Paint.UNDERLINE_TEXT_FLAG.inv()
            textSac.paintFlags = textSac.paintFlags and Paint.UNDERLINE_TEXT_FLAG.inv()
        }

        textBabouches.setOnClickListener {
            textBabouches.paintFlags = textBabouches.paintFlags or Paint.UNDERLINE_TEXT_FLAG
            textCafton.paintFlags = textCafton.paintFlags and Paint.UNDERLINE_TEXT_FLAG.inv()
            textTarbouch.paintFlags = textTarbouch.paintFlags and Paint.UNDERLINE_TEXT_FLAG.inv()
            textDejallaba.paintFlags = textDejallaba.paintFlags and Paint.UNDERLINE_TEXT_FLAG.inv()
            textSac.paintFlags = textSac.paintFlags and Paint.UNDERLINE_TEXT_FLAG.inv()
        }

        textTarbouch.setOnClickListener {
            textTarbouch.paintFlags = textTarbouch.paintFlags or Paint.UNDERLINE_TEXT_FLAG
            textCafton.paintFlags = textCafton.paintFlags and Paint.UNDERLINE_TEXT_FLAG.inv()
            textBabouches.paintFlags = textBabouches.paintFlags and Paint.UNDERLINE_TEXT_FLAG.inv()
            textDejallaba.paintFlags = textDejallaba.paintFlags and Paint.UNDERLINE_TEXT_FLAG.inv()
            textSac.paintFlags = textSac.paintFlags and Paint.UNDERLINE_TEXT_FLAG.inv()
        }

        textDejallaba.setOnClickListener {
            textDejallaba.paintFlags = textDejallaba.paintFlags or Paint.UNDERLINE_TEXT_FLAG
            textCafton.paintFlags = textCafton.paintFlags and Paint.UNDERLINE_TEXT_FLAG.inv()
            textBabouches.paintFlags = textBabouches.paintFlags and Paint.UNDERLINE_TEXT_FLAG.inv()
            textTarbouch.paintFlags = textTarbouch.paintFlags and Paint.UNDERLINE_TEXT_FLAG.inv()
            textSac.paintFlags = textSac.paintFlags and Paint.UNDERLINE_TEXT_FLAG.inv()
        }

        textSac.setOnClickListener {
            textSac.paintFlags = textSac.paintFlags or Paint.UNDERLINE_TEXT_FLAG
            textCafton.paintFlags = textCafton.paintFlags and Paint.UNDERLINE_TEXT_FLAG.inv()
            textBabouches.paintFlags = textBabouches.paintFlags and Paint.UNDERLINE_TEXT_FLAG.inv()
            textTarbouch.paintFlags = textTarbouch.paintFlags and Paint.UNDERLINE_TEXT_FLAG.inv()
            textDejallaba.paintFlags = textDejallaba.paintFlags and Paint.UNDERLINE_TEXT_FLAG.inv()
        }
    }

    class MyTimerTask(private val viewPager: ViewPager2, private val dotscount: Int) : TimerTask() {
        override fun run() {
            viewPager.post {
                val currentItem = viewPager.currentItem
                viewPager.setCurrentItem((currentItem + 1) % dotscount, true)
            }
        }
    }
}
