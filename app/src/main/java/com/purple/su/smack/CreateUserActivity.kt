package com.purple.su.smack

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_create_user.*
import kotlin.random.Random

class CreateUserActivity : AppCompatActivity() {

    var userAvatar = "profileDefault"
    var avatarColor = "[0.5, 0.5, 0.5, 1]"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_user)
    }

    fun createUserAvatarImgClicked(view: View) {
        val random = Random
        var color = random.nextInt(2)
        var avatar = random.nextInt(28)

        userAvatar = when(color) {
                        0 -> "light$avatar"
                        else -> "dark$avatar"
                    }

        val resourceId = resources.getIdentifier(userAvatar, "drawable", packageName)
        createUserAvatarImgView.setImageResource(resourceId)
    }

    fun createUserGenerateBgColorBtnClicked(view: View) {
        val random = Random
        val r = random.nextInt(255)
        val g = random.nextInt(255)
        val b = random.nextInt(255)

        createUserAvatarImgView.setBackgroundColor(Color.rgb(r, g, b))

        val savedR = r.toDouble() / 255
        val savedG = g.toDouble() / 255
        val savedB = b.toDouble() / 255

        avatarColor = "[$savedR, $savedG, $savedB, 1]"
    }

    fun createUserCreateBtnClicked(view: View) {

    }
}
