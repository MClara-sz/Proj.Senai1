package com.example.projsenai1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

data class UserModelo(val email: String, val senha: String)

class MainActivity : AppCompatActivity() {

    private val autentication by lazy {
        FirebaseAuth.getInstance()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btnLogin = findViewById<Button>(R.id.btnlogin)
        var btnCadastro = findViewById<Button>(R.id.btncadastro)

        var etEmail = findViewById<EditText>(R.id.edtEmail)
        var etSenha = findViewById<EditText>(R.id.edtSenha)
        if (etEmail.toString().isNullOrEmpty() || etSenha.toString().isNullOrEmpty()) {
            //aviso ao usúarios que precisa preencher os campos
        } else {
            //toast com o valor preenchido nos campos
        }

        // Configurar o clique do botão de login



        // Configurar o clique do botão de registrar

    }
    fun btnCadastro_click(View: View) {
        val etEmail = findViewById<EditText>(R.id.edtEmail)
        val etSenha = findViewById<EditText>(R.id.edtSenha)
        var email = etEmail.text.toString()
        var senha = etSenha.text.toString()
        autentication.createUserWithEmailAndPassword(
            email, senha
        ).addOnSuccessListener {
            Toast.makeText(this, "cadastrado com sucesso!", Toast.LENGTH_LONG).show()
        }.addOnFailureListener {
            Toast.makeText(this, "erro ao efetuar o cadastro", Toast.LENGTH_LONG).show()
        }

    }
    fun btnLogin_click(View: View) {
        var edtEmail = findViewById<EditText>(R.id.edtSenha)
        var edtSenha = findViewById<EditText>(R.id.edtEmail)
        var senha = edtEmail.text.toString()
        var email = edtSenha.text.toString()
        autentication.signInWithEmailAndPassword(
            email, senha
        ).addOnSuccessListener {
            Toast.makeText(this, "logadodo com sucesso!", Toast.LENGTH_LONG).show()
            val intent = Intent(this, TelaInicioActivity::class.java).apply {
                putExtra("Senha", senha)
                putExtra("email", email)
            }
            startActivity(intent)
        }.addOnSuccessListener {
            Toast.makeText(this, "erro ao efetuar o login", Toast.LENGTH_LONG).show()
        }
    }

}


    /*
    private val autentication by lazy {
        FirebaseAuth.getInstance()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnLogin = findViewById<Button>(R.id.btnlogin)
        val btnCadastrar = findViewById<Button>(R.id.btncadastro)



        fun cadastrar{

        }


        fun login{

        }
        btnLogin.setOnClickListener {

            var senhacolocada = findViewById<EditText>(R.id.edtSenha)
            var emailcolocado = findViewById<EditText>(R.id.edtEmail)
            if (senhacolocada.text.toString().isNullOrEmpty() || emailcolocado.text.toString()
                    .isNullOrEmpty()
            ) {
                Toast.makeText(this, "Preencha o campo SENHA ou EMAIL", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, TelaInicioActivity::class.java).apply {

                }
                startActivity(intent)
                Toast.makeText(this, "Login Completo", Toast.LENGTH_SHORT).show()

            }
            val data = Intent()
            var emailcolocadon = emailcolocado?.text.toString()
            var email = "maria.com"
            var senha = 1234
            var senhacolocadan = senhacolocada?.text.toString()

            val intent = Intent(this, TelaInicioActivity::class.java).apply {

                startActivity(intent)

            }


            btnCadastrar.setOnClickListener {
                val edtEmail = findViewById<EditText>(R.id.edtEmail)
                val edtSenha = findViewById<EditText>(R.id.edtSenha)
                var email = edtEmail.text.toString()
                var senha = edtSenha.text.toString()
                autentication.createUserWithEmailAndPassword(
                    email, senha
                ).addOnSuccessListener {
                    Toast.makeText(this, "cadastrado com sucesso!", Toast.LENGTH_LONG).show()
                }.addOnFailureListener {
                    Toast.makeText(this, "erro ao efetuar o cadastro", Toast.LENGTH_LONG).show()
                }

            }

            override fun onStart() {
                super.onStart()
                verificarLogin()
            }

            private fun verificarLogin(){
                val user = autentication.currentUser
                if ](user != null) {
                    abrirInicio()
                }
            }

        }
    }
}
*/