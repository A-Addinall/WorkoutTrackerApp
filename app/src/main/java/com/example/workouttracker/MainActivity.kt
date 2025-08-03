package com.example.workouttracker

import android.app.AlertDialog
import android.graphics.Color
import android.os.Bundle
import android.text.InputType
import android.view.Gravity
import android.view.View
import android.widget.*
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.workouttracker.data.entity.Exercise
import com.example.workouttracker.ui.WorkoutViewModel
import com.example.workouttracker.ui.WorkoutViewModelFactory

class MainActivity : AppCompatActivity() {

    private val vm by viewModels<WorkoutViewModel> {
        WorkoutViewModelFactory((application as WorkoutApplication).repository)
    }

    private lateinit var layout: LinearLayout
    private lateinit var btnA: Button; private lateinit var btnB: Button; private lateinit var btnC: Button
    private var etMin: EditText? = null; private var etSec: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState); setContentView(R.layout.activity_main)
        layout = findViewById(R.id.layoutExercises)
        btnA = findViewById(R.id.btnDayA); btnB = findViewById(R.id.btnDayB); btnC = findViewById(R.id.btnDayC)

        btnA.setOnClickListener { selectDay(1) }; btnB.setOnClickListener { selectDay(2) }; btnC.setOnClickListener { selectDay(3) }

        /* observers */
        vm.allExercises.observe(this, Observer { render(it) })
        vm.lastWeights  .observe(this) { render(vm.allExercises.value ?: emptyList()) }
        vm.lastMetconSec.observe(this) { render(vm.allExercises.value ?: emptyList()) }

        selectDay(1)    // initial
    }

    private fun selectDay(id:Int){ vm.currentWtId=id; vm.loadWorkout(id) }

    /* ===========  UI BUILD  =========== */
    private fun render(list: List<Exercise>) {
        layout.removeAllViews(); etMin=null; etSec=null
        val strength=list.filter{it.category=="Strength"}
        val metcon  =list.filter{it.category=="Metcon"}

        fun title(t:String)=TextView(this).apply{
            text=t; textSize=18f; setTypeface(null,android.graphics.Typeface.BOLD); setPadding(0,24,0,12)
        }

        if(strength.isNotEmpty()){
            layout.addView(title("Strength Work"))
            strength.forEach{ addStrengthRow(it) }
        }

        if(metcon.isNotEmpty()){
            layout.addView(title("Metcon Circuit"))
            metcon.forEach{ addInfo("• ${it.name} – ${it.repRange}") }
            addMetconTimeInputs()
        }

        addCompleteBtn()
    }

    private fun addStrengthRow(ex:Exercise){
        val lastWt=vm.lastWeights.value?.get(ex.id)
        val wrap=LinearLayout(this).apply{orientation=LinearLayout.VERTICAL;setPadding(16,8,16,8)}
        wrap.addView(TextView(this).apply{
            text="${ex.name} – ${ex.repRange}" + (lastWt?.let{"  (last ${it}kg)"}?:"")
            textSize=16f; setTypeface(null,android.graphics.Typeface.BOLD)
        })
        val row=LinearLayout(this).apply{orientation=LinearLayout.HORIZONTAL}
        fun box(h:String)=EditText(this).apply{
            hint=h; inputType=InputType.TYPE_CLASS_NUMBER or InputType.TYPE_NUMBER_FLAG_DECIMAL
            layoutParams=LinearLayout.LayoutParams(120,LinearLayout.LayoutParams.WRAP_CONTENT)
        }
        row.addView(TextView(this).apply{text="Sets:"}); val eS=box("3");row.addView(eS)
        row.addView(TextView(this).apply{text=" Reps:"});val eR=box("10");row.addView(eR)
        row.addView(TextView(this).apply{text=" Wt:"});  val eW=box("kg");row.addView(eW)
        wrap.addView(row)
        wrap.addView(Button(this).apply{
            text="Log"; setOnClickListener{
            val s=eS.text.toString().toIntOrNull()?:0
            val r=eR.text.toString().toIntOrNull()?:0
            val w=eW.text.toString().toDoubleOrNull()
            if(s>0&&r>0){ vm.logStrength(ex.id,s,r,w); eS.text.clear();eR.text.clear();eW.text.clear() }
            else Toast.makeText(context,"Enter sets & reps",Toast.LENGTH_SHORT).show()
        }
        })
        wrap.addView(separator())
        layout.addView(wrap)
    }

    private fun addMetconTimeInputs(){
        addInfo("") // spacer
        val last=vm.lastMetconSec.value?:0L
        if(last>0) addInfo("Last time: ${last/60}m ${last%60}s")
        val row=LinearLayout(this).apply{orientation=LinearLayout.HORIZONTAL;setPadding(16,8,16,8)}
        fun tBox(h:String)=EditText(this).apply{
            hint=h; inputType=InputType.TYPE_CLASS_NUMBER
            layoutParams=LinearLayout.LayoutParams(160,LinearLayout.LayoutParams.WRAP_CONTENT)
        }
        row.addView(TextView(this).apply{text="Min:"}); etMin=tBox("0"); row.addView(etMin)
        row.addView(TextView(this).apply{text=" Sec:"}); etSec=tBox("00");row.addView(etSec)
        layout.addView(row); layout.addView(separator())
    }

    private fun addInfo(txt:String)=layout.addView(TextView(this).apply{text=txt;textSize=16f;setPadding(16,4,16,4)})

    private fun addCompleteBtn(){
        val wrap=LinearLayout(this).apply{gravity=Gravity.CENTER;setPadding(0,32,0,32)}
        wrap.addView(Button(this).apply{
            text="Complete Workout"; textSize=18f
            setOnClickListener{complete()}
        })
        layout.addView(wrap)
    }

    private fun complete(){
        val min=etMin?.text?.toString()?.toLongOrNull()?:0L
        val sec=etSec?.text?.toString()?.toLongOrNull()?:0L
        val tot=min*60+sec
        if(tot>0) vm.logMetcon(vm.currentWtId,tot)
        AlertDialog.Builder(this)
            .setTitle("Saved")
            .setMessage(if(tot>0)"Metcon ${min}m ${sec}s saved" else "Strength saved")
            .setPositiveButton("OK",null).show()
    }

    private fun separator()=View(this).apply{
        layoutParams=LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,2)
        setBackgroundColor(Color.LTGRAY)
    }
}
