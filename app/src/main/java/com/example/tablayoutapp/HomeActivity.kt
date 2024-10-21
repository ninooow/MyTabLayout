package com.example.tablayoutapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.text.Html
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tablayoutapp.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val actionBar: ActionBar? = supportActionBar
        val colorDrawable = ColorDrawable(Color.parseColor("#525BFF"))
        actionBar?.setBackgroundDrawable(colorDrawable)

        val textView = TextView(applicationContext)
        val params = ActionBar.LayoutParams(
            ActionBar.LayoutParams.WRAP_CONTENT,
            ActionBar.LayoutParams.WRAP_CONTENT
        )
        textView.layoutParams = params
        textView.text = actionBar?.title
        textView.setTextColor(Color.WHITE)
        textView.textSize = 16F
        textView.setTypeface(null, Typeface.BOLD)

        actionBar?.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
        actionBar?.customView = textView


        with(binding) {
            val getUsnRegister = intent.getStringExtra(RegisterFragment.Register.EXTRA_USERNAME)
            val getUsnLogin = intent.getStringExtra(LoginFragment.Login.EXTRA_USERNAME)
            val getUsn = getUsnRegister ?: getUsnLogin
            username.text = Html.fromHtml(
                "Welcome back &lt; <font color='#525BFF'>$getUsn</font> &gt;!",
                Html.FROM_HTML_MODE_LEGACY
            )
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate menu jika Anda ingin menggunakan Option Menu
        menuInflater.inflate(R.menu.menu_options, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.logout->{
                val intentToMain = Intent(this@HomeActivity, MainActivity::class.java)
                startActivity(intentToMain)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}