package com.example.mvvm_firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.mvvm_firebase.utils.replaceView
import com.example.mvvm_firebase.view.ContentFragment
import com.example.mvvm_firebase.view.SignInFragment
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        if (FirebaseAuth.getInstance().currentUser != null) {
            replaceView(ContentFragment.newInstance())
        } else {
            replaceView(SignInFragment.newInstance())
        }

//        fun replaceFragment(fragment: Fragment) {
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.container, fragment)
//                .commitNow()
//        }
    }
}
