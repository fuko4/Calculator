package android.rustem.calculator

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View





class Drawing(context: Context, attrs: AttributeSet?) : View(context, attrs){

    var paint = Paint()

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val width: Int = getWidth()
        val height: Int =getHeight()

        paint.setColor(Color.GREEN)

        var size = getWidth()/3
        for (x in 0 .. width step size){
            for(y in 0 .. height step size){
                paint.color = 0x00ffffff and 1257823419 * x + 2118746214 * y or -0x1000000
                canvas?.drawRect(x.toFloat(), y.toFloat(), x + size.toFloat(), y + size.toFloat(), paint)
            }

        }
    }
}