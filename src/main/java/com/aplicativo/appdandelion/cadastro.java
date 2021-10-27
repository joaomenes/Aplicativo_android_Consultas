package com.aplicativo.appdandelion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.os.StrictMode;
import android.content.Context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class cadastro extends AppCompatActivity implements View.OnClickListener {

    EditText textNomeCompleto, textEmail, textemailconfrimacao, texsenha, textsenhaconfirmacao,textcpf, texttelefone,textcep,
    textnacionalidade;
            ImageView botao_cadastro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        textEmail = (EditText) findViewById(R.id.textEmail);
        textNomeCompleto = (EditText) findViewById(R.id.textNomeCompleto);
        textemailconfrimacao = (EditText) findViewById(R.id.textemailconfrimacao);
        textsenhaconfirmacao = (EditText) findViewById(R.id.textsenhaconfirmacao);
        texsenha = (EditText) findViewById(R.id.texsenha);
        textcpf = (EditText) findViewById(R.id.textcpf);
        texttelefone = (EditText) findViewById(R.id.texttelefone);
        textcep = (EditText) findViewById(R.id.textcep);
        textnacionalidade = (EditText) findViewById(R.id.textnacionalidade);
        botao_cadastro = (ImageView) findViewById(R.id.botao_cadastro);

        botao_cadastro.setOnClickListener(this);
    }
    public void onClick(View view){
        botao_cadastro();
    }

    public void botao_cadastro() {
        String nome = textNomeCompleto.getText().toString().trim();
        String email = textEmail.getText().toString().trim();
        String senha = texsenha.getText().toString().trim();
        String confsenha = textsenhaconfirmacao.getText().toString().trim();


        if (senha.equals(confsenha))
        {
            Connection cn = getConnection();
            try {
                Statement stm = cn.createStatement();
                stm.executeUpdate("insert into usuarios (nome,email,senha) values("
                        + "'" + nome + "','" + email + "','"+ senha + "')");
                mensagem("Dados gravados com sucesso!!");

                stm.close();
                cn.close();
            } catch (Exception e) {
                Log.e("BANCO", "GRAVAR=" + e.getMessage());
                mensagem("Erro ao Salvar os Dados");
            }
            limparCampos();
        }

        }
        public void limparCampos() {
            textEmail.setText("");
            texsenha.setText("");
            textsenhaconfirmacao.setText("");
            textemailconfrimacao.setText("");
            textNomeCompleto.setText("");
            textnacionalidade.setText("");
            textcep.setText("");
            textcpf.setText("");
            texttelefone.setText("");
            textEmail.requestFocus();
        }
        public static Connection getConnection() {

            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);

            Connection cn = null;
            try {
                // Para acessar do Emulador o banco Localhost
                // use --> 10.0.2.2:portBD
                //
                String banco = "login";
                String id_usuario = "jdbc:mysql://10.0.2.2:3306/" + banco ;
                String email = "root";
                String senha = "";

                Class.forName("com.mysql.jdbc.Driver").newInstance();
                cn = DriverManager.getConnection(id_usuario, email, senha);

                Log.e("BANCO", "Conexão Aberta");
            } catch (ClassNotFoundException e) {
                Log.e("BANCO2", e.getMessage());
            } catch (SQLException e) {
                Log.e("BANCO1", e.getMessage());
            } catch (Exception e) {
                Log.e("BANCO3", e.getMessage());
            }
            return cn;
        }


    private void mensagem(String msg) {
        Context contexto = getApplicationContext();
        int duracao = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(contexto, msg, duracao);
        toast.show();

    }
    }