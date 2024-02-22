package com.example.foodapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.foodapp.databinding.ActivitySignBinding
import com.google.firebase.auth.FirebaseAuth

class SignActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private val binding: ActivitySignBinding by lazy{
        ActivitySignBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        auth = FirebaseAuth.getInstance()

        val intent = Intent(this,LoginActivity::class.java )
        binding.alreadyhavebutton.setOnClickListener{
            startActivity(intent)
        }

        binding.createButton.setOnClickListener {
            val email=binding.email.text.toString()
            val userName=binding.userName.text.toString()
            val password=binding.password.text.toString()
            val repeatPassword=binding.repeatPassword.text.toString()

            if(email.isEmpty()||userName.isEmpty()||password.isEmpty()||repeatPassword.isEmpty()){
                Toast.makeText(this,"Pleae Fill All Details",Toast.LENGTH_SHORT).show()
            }else if(password != repeatPassword){
                Toast.makeText(this,"Repeat PassWord Must be Same",Toast.LENGTH_SHORT).show()
            }else{
                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this){task ->
                        if(task.isSuccessful){
                            Toast.makeText(this,"Sign Up Successfully",Toast.LENGTH_LONG).show()
                            startActivity(intent)
                        }else{
                            Toast.makeText(this,"Sign Up Faild:${task.exception?.message} ",Toast.LENGTH_LONG).show()
                        }
                    }
            }

        }
    }
}