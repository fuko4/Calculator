package android.rustem.calculator

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View


class Fire(context: Context, attrs: AttributeSet?) : View(context, attrs) {


    private val firePalette: List<Long> = listOf(
        0xff070707,
        0xff1F0707,
        0xff2F0F07,
        0xff470F07,
        0xff571707,
        0xff671F07,
        0xff771F07,
        0xff8F2707,
        0xff9F2F07,
        0xffAF3F07,
        0xffBF4707,
        0xffC74707,
        0xffDF4F07,
        0xffDF5707,
        0xffDF5707,
        0xffD75F07,
        0xffD75F07,
        0xffD7670F,
        0xffCF6F0F,
        0xffCF770F,
        0xffCF7F0F,
        0xffCF8717,
        0xffC78717,
        0xffC78F17,
        0xffC7971F,
        0xffBF9F1F,
        0xffBF9F1F,
        0xffBFA727,
        0xffBFA727,
        0xffBFAF2F,
        0xffB7AF2F,
        0xffB7B72F,
        0xffB7B737,
        0xffCFCF6F,
        0xffDFDF9F,
        0xffEFEFC7,
        0xffFFFFFF
    )

    private var fireWidth: Int = 0
    private var fireHeight: Int = 0
    //private var firePixels: Array<IntArray>? = null
    //private var firePixels = mutableListOf<List<Int>>()
    var firePixels = Array(0) { IntArray(0) }


    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        fireWidth = w
        fireHeight = h
        //firePixels.add(fireWidth, listOf(fireHeight))
        firePixels = Array(fireHeight) { IntArray(fireWidth) }

        for (x in 0..fireWidth) {
            firePixels[fireHeight - 1][x] = firePalette.size - 1
        }
    }


    private val paint = Paint()

    override fun onDraw(canvas: Canvas?) {
        //drawFire(canvas)
        for (y in 0 .. fireHeight){
            for (x in 0 .. firePixels.size){

                var color: Long = firePalette[firePixels[y][x]]
                paint.setColor(color)
                canvas?.drawPoint(x.toFloat(), y.toFloat(), paint)
            }
        }
    }

//    @SuppressLint("NewApi")
//    private fun drawFire(canvas: Canvas?) {
//        for (x in 0..fireWidth) {
//            for (y in 0..fireHeight) {
//                var temperature = firePixels[x][y]
//
//                if (temperature < 0){
//                    temperature = 0
//                }
//
//                if (temperature >= firePalette.size){
//                    temperature = firePalette.size - 1
//                }
//                var color: Long = firePalette[temperature]
//                paint.setColor(color)
//
//                canvas?.drawPoint(x.toFloat(), y.toFloat(), paint)
//
//            }
//        }
//    }


}
