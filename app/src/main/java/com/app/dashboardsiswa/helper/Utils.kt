package com.app.dashboardsiswa.helper

import android.app.TimePickerDialog
import android.content.Context
import android.content.SharedPreferences
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.amulyakhare.textdrawable.TextDrawable
import com.amulyakhare.textdrawable.util.ColorGenerator
import com.bumptech.glide.Glide
import es.dmoral.toasty.Toasty
import java.text.SimpleDateFormat
import java.util.*

object Utils {

    val TAG = "UtilsTAG"
    lateinit var mySharedPreferences: SharedPreferences
    private val PREF = "pref"


    private  val id ="id"
    private  val role ="role"

    fun setId(r :Int, context:Context) {
        mySharedPreferences = context.getSharedPreferences(PREF, Context.MODE_PRIVATE)
        val myEditor: SharedPreferences.Editor = mySharedPreferences.edit()
        myEditor.putInt(id, r)
        myEditor.commit()
        myEditor.apply()
    }

    fun getId(context: Context): Int? {
        mySharedPreferences = context.getSharedPreferences(PREF, Context.MODE_PRIVATE)
        return mySharedPreferences.getInt(id, 0)
    }


    fun setRole(r :Int, context:Context) {
        mySharedPreferences = context.getSharedPreferences(PREF, Context.MODE_PRIVATE)
        val myEditor: SharedPreferences.Editor = mySharedPreferences.edit()
        myEditor.putInt(role, r)
        myEditor.commit()
        myEditor.apply()
    }

    fun getRole(context: Context): Int? {
        mySharedPreferences = context.getSharedPreferences(PREF, Context.MODE_PRIVATE)
        return mySharedPreferences.getInt(role, 0)
    }

    fun Any.convertToYYYY(): String {
        val sf = SimpleDateFormat("yyyy-MM-dd")
        val date = sf.parse(this as String)

        val dateFormater = SimpleDateFormat("yyyy")
        return dateFormater.format(date)
    }

    fun convertToyyyMMdd(date: Long): String? {
        val dateFormater = SimpleDateFormat("yyyy-MM-dd")
        return dateFormater.format(date)
    }

    fun convertToEEEEyyyMMdd(date: String): String? {
        val sf = SimpleDateFormat("yyyy-MM-dd")
        val d =  sf.parse(date)
        val dateFormater = SimpleDateFormat("EEEE yyyy-MM-dd")
        return dateFormater.format(d)
    }

    fun convertToEEEE(date: String): String? {
        val sf = SimpleDateFormat("yyyy-MM-dd")
        val d =  sf.parse(date)
        val dateFormater = SimpleDateFormat("EEEE")
        return dateFormater.format(d)
    }

    fun loadImage(context: Context, url: String, imageView: ImageView) {
        Glide.with(context).load(url).into(imageView)
    }

    fun imageAlfabet( name:String, image:ImageView){
        val aplhabet = name.uppercase()?.subSequence(0, 1)
        val generator = ColorGenerator.MATERIAL
        val drawable = TextDrawable.builder()
            .beginConfig()
            .width(50) // width in px
            .height(50) // height in px
            .endConfig()
            .buildRect(aplhabet as String?, generator.getColor(name))
        image.setImageDrawable(drawable)
    }

    fun showToastInfo(context: Context, message: String) {
        Toasty.info(context, message, Toast.LENGTH_SHORT, true).show()
    }

    fun showToastError(context: Context, message: String) {
        Toasty.error(context, message, Toast.LENGTH_SHORT, true).show()
    }


    fun showToastSuccess(context: Context, message: String) {
        Toasty.success(context, message, Toast.LENGTH_SHORT, true).show()
    }

    fun showToastNormal(context: Context, message: String) {
        Toasty.normal(context, message, Toast.LENGTH_SHORT).show()
    }


    fun showToastWarning(context: Context, message: String) {
        Toasty.warning(context, message, Toast.LENGTH_SHORT, true).show()
    }

    fun showTimeDialog(context: Context, et: EditText) {
        val c = Calendar.getInstance()
        val hour = c[Calendar.HOUR_OF_DAY]
        val minute = c[Calendar.MINUTE]
       val timePickerDialog = TimePickerDialog(context, { timePicker, i, i2 ->
           et.setText("$i : $i2")
        }, hour, minute, true)
        timePickerDialog.show()
    }
}