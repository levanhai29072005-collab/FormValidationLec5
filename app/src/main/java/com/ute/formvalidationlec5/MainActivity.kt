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
        btnRegister.setOnClickListener {
            val name = edtFullName.text.toString().trim()
            val email = edtEmail.text.toString().trim()
            val phone = edtPhone.text.toString().trim()
            val address = edtAddress.text.toString().trim()

            if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || address.isEmpty()) {
                Snackbar.make(it, "Vui lòng nhập đầy đủ các trường!", Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Snackbar.make(it, "Định dạng email không hợp lệ!", Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (phone.length < 10) {
                Snackbar.make(it, "Số điện thoại phải từ 10 số trở lên!", Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val user = User(fullName = name, email = email, phone = phone, address = address)
            val intent = Intent(this, HomeActivity::class.java).apply {
                putExtra("EXTRA_USER", user)
            }
            startActivity(intent)
        }
    }
}