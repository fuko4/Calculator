package android.rustem.calculator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class DemoDrawingView extends View {

    public DemoDrawingView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    private final Paint paint = new Paint();

    @Override
    protected void onDraw(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();

        // Will draw in rect (0,0) - (width, height)
        // Put your custom drawing code here

        paint.setColor(Color.GREEN);

        final int size = 100;
        for (int x = 0; x < width; x += size) {
            for (int y = 0; y < height; y += size) {
                paint.setColor(0x00ffffff & (1257823419 * x + 2118746214 * y) | 0xff000000);
                canvas.drawRect(x, y, x + size, y + size, paint);
            }
        }
    }
}
