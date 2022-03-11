package br.com.empresa.esg

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FormularioCadastro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getSupportActionBar()?.hide();
        setContentView(R.layout.activity_formulario_cadastro)

        val voltar: Button = findViewById<androidx.appcompat.widget.AppCompatButton>(R.id.button_voltar)

        voltar.setOnClickListener{
            val i = Intent(this, FormLogin::class.java)
            startActivity(i)
        }

        val salvaralteracoes: Button = findViewById<androidx.appcompat.widget.AppCompatButton>(R.id.button_salvaralteracoes)

        salvaralteracoes.setOnClickListener{
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }

        val pesquisaCep : AppCompatButton = findViewById(R.id.button7)
        val cep : EditText = findViewById(R.id.edt_cep)
        val rua : EditText = findViewById(R.id.edt_rua)
        val bairro : EditText = findViewById(R.id.edt_bairro)
        val cidade : EditText = findViewById(R.id.edt_cidade)
        val uf : EditText = findViewById(R.id.edt_uf)

        pesquisaCep.setOnClickListener{
            val call = RetrofitFactory().retrofitService().getCEP(cep.text.toString())

            call.enqueue(object : Callback<CEP>{
                override fun onResponse(call: Call<CEP>, response: Response<CEP>) {

                    response.body()?.let {
                        Log.i("CEP", it.toString())

                        Toast.makeText(this@FormularioCadastro, it.toString(), Toast.LENGTH_LONG).show()
                    } ?: Toast.makeText(this@FormularioCadastro, "CEP não localizado", Toast.LENGTH_LONG).show()
                }

                override fun onFailure(call: Call<CEP>?, t: Throwable?) {
                    t?.message?.let { it1 ->
                        Log.e("Erro", it1)
                    }
                }
            })

            }
    }

}

