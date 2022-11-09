package com.example.allinone

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.tasks.Task
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.button.MaterialButton
import com.google.android.material.navigation.NavigationBarView
import kotlinx.coroutines.android.awaitFrame
import org.w3c.dom.Text

public class MainActivity : AppCompatActivity() {
    private lateinit var mGoogleSignInClient: GoogleSignInClient
    private val userIsLoggedIn: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_login)

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken("YOUR_WEB_APPLICATION_CLIENT_ID")
            .requestEmail()
            .build()
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso)

        val googleLoginButton: ImageView = findViewById<ImageView>(R.id.google_button)

        googleLoginButton.setOnClickListener {
            signIn()

            setContentView(R.layout.activity_main)
            val navBar = findViewById<BottomNavigationView>(R.id.bottom_navigation)

            navBar.setOnItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.coin_flip -> {
                        loadFragment(fragment_coin_flip())
                        Toast.makeText(this, "This is a test also", Toast.LENGTH_SHORT).show()
                        true
                    }
                    R.id.rng -> {
                        loadFragment(fragment_rng())
                        Toast.makeText(this, "This is a test", Toast.LENGTH_SHORT).show()
                        true
                    }
                    R.id.spin_the_wheel -> {
                        loadFragment(fragment_spin_the_wheel())
                        true
                    }
                    R.id.magic_ball -> {
                        loadFragment(fragment_magic_ball())
                        true
                    }
                    R.id.history -> {
                        loadFragment(fragment_history())
                        true
                    }
                    else -> false
                }
            }
        }
    }


    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_container,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
    private fun signIn() {
        val signInIntent = mGoogleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    companion object{
        const val RC_SIGN_IN = 9001
    }


    fun onActiveResult(requestCode: Int, resultCode:Int,data: Intent?)
    {
        super.onActivityResult(requestCode, resultCode,data)
        if (requestCode == RC_SIGN_IN){
            userIsLoggedIn
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            handleSignInResult(task)

        }
    }

    private fun handleSignInResult(completedTask: Task<GoogleSignInAccount>){
        try{
            val account = completedTask.getResult(
                ApiException::class.java
            )
            // Signed in successfully
            val googleId = account?.id ?: ""
            Log.i("Google ID",googleId)
            val googleFirstName = account?.givenName ?: ""
            Log.i("Google First Name", googleFirstName)
            val googleLastName = account?.familyName ?: ""
            Log.i("Google Last Name", googleLastName)
            val googleEmail = account?.email ?: ""
            Log.i("Google Email", googleEmail)
            val googleProfilePicURL = account?.photoUrl.toString()
            Log.i("Google Profile Pic URL", googleProfilePicURL)
            val googleIdToken = account?.idToken ?: ""
            Log.i("Google ID Token", googleIdToken)
        } catch (e: ApiException) {
            // Sign in was unsuccessful
            Log.e(
                "failed code=", e.statusCode.toString()
            )
        }
    }

    private fun signOut() {
        mGoogleSignInClient.signOut()
            .addOnCompleteListener(this) {
                // Update your UI here
            }
    }

    private fun revokeAccess() {
        mGoogleSignInClient.revokeAccess()
            .addOnCompleteListener(this) {
                // Update your UI here
            }
    }


}