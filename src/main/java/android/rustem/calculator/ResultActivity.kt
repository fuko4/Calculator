package android.rustem.calculator

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {
    companion object {
        private val EXTRA_RES = "android.rustem.calculator.res"
        private val RES_SAVE_VIEW_VALUE = "result_save_view_value"

        fun newIntent(packageContext: Context?, res: Int): Intent? {
            val intent = Intent(packageContext, ResultActivity::class.java)
            return intent.putExtra(EXTRA_RES, res)
        }
    }

    private lateinit var mresultSaveView: TextView

    private var resultSaveViewValue = ""
    private var test = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        mresultSaveView = findViewById(R.id.result_save_view)

        test = intent.getIntExtra(EXTRA_RES, 0).toString()
        resultSaveViewValue += test+"\n"
        mresultSaveView.setText(resultSaveViewValue)

        if (savedInstanceState != null) {
            resultSaveViewValue = savedInstanceState.getString(RES_SAVE_VIEW_VALUE, "")
        }
        println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!resultSaveViewValue = $resultSaveViewValue")
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState!!.putString(RES_SAVE_VIEW_VALUE, resultSaveViewValue)
    }
}