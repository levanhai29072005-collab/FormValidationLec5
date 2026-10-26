package com.ute.formvalidationlec5

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtFullName = findViewById<TextInputEditText>(R.id.edtFullName)
        val edtEmail = findViewById<TextInputEditText>(R.id.edtEmail)
        val edtPhone = findViewById<TextInputEditText>(R.id.edtPhone)
        val edtAddress = findViewById<TextInputEditText>(R.id.edtAddress)
        val btnCancel = findViewById<Button>(R.id.btnCancel)
        val btnRegister = findViewById<Button>(R.id.btnRegister)

        btnCancel.setOnClickListener {
            edtFullName.text?.clear()
            edtEmail.text?.clear()
            edtPhone.text?.clear()
            edtAddress.text?.clear()
            edtFullName.requestFocus()
            Snackbar.make(it, "Đã xóa trắng form nhập liệu", Snackbar.LENGTH_SHORT).show()
        }