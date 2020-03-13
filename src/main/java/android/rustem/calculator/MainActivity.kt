package android.rustem.calculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    companion object {
        private val TAG = "calculator"
        private val CALC_VIEW = "calac_view_index"
        private val CALC_RES = "calac_RES_index"

    }

    private lateinit var mSaveResultButton: Button
    private lateinit var mShareResultButton: Button
    private lateinit var mCalcView: TextView
    private lateinit var mAnswerView: TextView
    private lateinit var mCanselButton: Button
    private lateinit var mUmnogenButton: Button
    private lateinit var mDelenieButton: Button
    private lateinit var mButton0: Button
    private lateinit var mButton1: Button
    private lateinit var mButton2: Button
    private lateinit var mButton3: Button
    private lateinit var mButtonMinus: Button
    private lateinit var mButton5: Button
    private lateinit var mButton6: Button
    private lateinit var mButton7: Button
    private lateinit var mButtonPlus: Button
    private lateinit var mButton9: Button
    private lateinit var mButton10: Button
    private lateinit var mButton11: Button
    private lateinit var mButtonCulc: Button

    private var calcString = ""
    private var calcList = mutableListOf<String>()
    private var res = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState != null) {
            calcString = savedInstanceState.getString(CALC_VIEW, "")
            res = savedInstanceState.getInt(CALC_RES, 0)
        }

        mSaveResultButton = findViewById(R.id.save_result)
        mShareResultButton = findViewById(R.id.share_result)
        mCalcView = findViewById(R.id.calc_view)
        mAnswerView = findViewById(R.id.answer_view)
        mCanselButton = findViewById(R.id.cansel_button)
        mButton0 = findViewById(R.id.button13)
        mUmnogenButton = findViewById(R.id.button14)
        mDelenieButton = findViewById(R.id.button15)
        mButton1 = findViewById(R.id.button9)
        mButton2 = findViewById(R.id.button10)
        mButton3 = findViewById(R.id.button11)
        mButtonMinus = findViewById(R.id.button4)
        mButton5 = findViewById(R.id.button5)
        mButton6 = findViewById(R.id.button6)
        mButton7 = findViewById(R.id.button7)
        mButtonPlus = findViewById(R.id.button8)
        mButton9 = findViewById(R.id.button1)
        mButton10 = findViewById(R.id.button2)
        mButton11 = findViewById(R.id.button3)
        mButtonCulc = findViewById(R.id.button12)

        mCalcView.setText(calcString)
        calcList.add(res.toString())
        mAnswerView.setText(res.toString())

        mShareResultButton.setOnClickListener {
            val sendIntent = Intent()
            sendIntent.action = Intent.ACTION_SEND
            sendIntent.putExtra(Intent.EXTRA_TEXT, res.toString())
            sendIntent.type = "text/plain"

            var chooser: Intent = Intent.createChooser(sendIntent, "Выберите приложение")

            if (sendIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(chooser)
            }
        }

        mSaveResultButton.setOnClickListener {
            //val resultIntent = Intent(this, ResultActivity::class.java)
            val intent = ResultActivity.newIntent(this, res)
            startActivity(intent)
        }

        mButton1.setOnClickListener {
            calcString += "1"
            mCalcView.setText(calcString)
            calcList.add("1")
        }

        mButton2.setOnClickListener {
            calcString += "2"
            mCalcView.setText(calcString)
            calcList.add("2")
        }

        mButton3.setOnClickListener {
            calcString += "3"
            mCalcView.setText(calcString)
            calcList.add("3")
        }

        mButton5.setOnClickListener {
            calcString += "4"
            mCalcView.setText(calcString)
            calcList.add("4")
        }

        mButton6.setOnClickListener {
            calcString += "5"
            mCalcView.setText(calcString)
            calcList.add("5")
        }

        mButton7.setOnClickListener {
            calcString += "6"
            mCalcView.setText(calcString)
            calcList.add("6")
        }

        mButtonPlus.setOnClickListener {
            calcString += "+"
            mCalcView.setText(calcString)
            calcList.add("+")
        }

        mButton9.setOnClickListener {
            calcString += "7"
            mCalcView.setText(calcString)
            calcList.add("7")
        }

        mButton10.setOnClickListener {
            calcString += "8"
            mCalcView.setText(calcString)
            calcList.add("8")
        }

        mButton11.setOnClickListener {
            calcString += "9"
            mCalcView.setText(calcString)
            calcList.add("9")
        }

        mButtonMinus.setOnClickListener {
            calcString += "-"
            mCalcView.setText(calcString)
            calcList.add("-")
        }

        mButton0.setOnClickListener {
            calcString += "0"
            mCalcView.setText(calcString)
            calcList.add("0")
        }

        mUmnogenButton.setOnClickListener {
            calcString += "*"
            mCalcView.setText(calcString)
            calcList.add("*")
        }
        mDelenieButton.setOnClickListener {
            calcString += "/"
            mCalcView.setText(calcString)
            calcList.add("/")
        }

        mButtonCulc.setOnClickListener {

            var a = ""
            var b = ""
            var index = 0

            for (i in 0 until calcList.size) {
                if (calcList[i] == "+" || calcList[i] == "-" || calcList[i] == "*" || calcList[i] == "/") {
                    index = i
                }
            }

            if (calcList.last() != "+" && calcList.last() != "-" && calcList.last() != "*" && calcList.last() != "/" && calcList.last() != "0") {

                for (i in 0 until index) {
                    a += calcList[i]
                }

                for (i in index + 1 until calcList.size) {
                    b += calcList[i]
                }

                when (calcList[index]) {
                    "+" -> res = a.toInt() + b.toInt()
                    "-" -> res = a.toInt() - b.toInt()
                    "*" -> res = a.toInt() * b.toInt()
                    "/" -> res = a.toInt() / b.toInt()
                }

                mAnswerView.setText(res.toString())

            } else {
                mAnswerView.setText(R.string.error_text)
                Toast.makeText(this, "Нажмите клавишу \"C\"", Toast.LENGTH_LONG).show()
            }

            calcList.clear()
            calcList.add(res.toString())

            println("res=$res")
            println("calcString=$calcString")

        }

        mCanselButton.setOnClickListener {
            calcString = ""
            mAnswerView.setText("0")
            if (calcString == "") mCalcView.setText("0")
            calcList.clear()
        }
        println("!!!!!!!!!!!!!!!!!!!!!!!!!!!res = $res")
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState!!.putString(CALC_VIEW, calcString)
        outState!!.putInt(CALC_RES, res)
    }

}
