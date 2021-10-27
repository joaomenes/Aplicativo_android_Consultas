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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public  class MainActivity extends AppCompatActivity implements View.OnClickListener {

     Button botaoCadastrese; //atributo do botão
     ImageView botaologar;  //atributo do botão
    EditText textEmail, texsenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textEmail = (EditText) findViewById(R.id.textEmail);
        texsenha = (EditText) findViewById(R.id.texsenha);
        botaologar = (ImageView) findViewById(R.id.botaologar);
        botaoCadastrese = (Button) findViewById(R.id.botaoCadastrese);


        botaologar.setOnClickListener(this);
        botaoCadastrese.setOnClickListener(this);



    }

    public void onClick (View view) {


        if (view.getId() == R.id.botaologar) {
            consultarUsuario();
        }
        if (view.getId() == R.id.botaoCadastrese) {
            consultarUsuario();
            Intent tela = new Intent(this, cadastro.class);
            startActivity(tela);
        }


    }
    public void consultarUsuario() {
        String email = textEmail.getText().toString() ;
        String senha = texsenha.getText().toString() ;

        Connection cn = getConnection();
        try {
            Statement stm = cn.createStatement();
            ResultSet rs = stm
                    .executeQuery("select * from usuarios where email = '" + email + "' and senha = '" + senha + "'");
            if (rs.next()) {
                email = rs.getString("email");
                Intent tela = new Intent(this, home.class);
                startActivity(tela);


            } else {
                mensagem("Usuário ou Senha estão inválidos ou CADASTRE-SE!");
                limparCampos();
            }
            rs.close();
            stm.close();
            cn.close();
        } catch (Exception e) {
            Log.e("BANCO", "Consultar =" + e.getMessage());
            mensagem("Erro ao Logar");
        }



    }
    public void limparCampos() {
        textEmail.setText("");
        texsenha.setText("");
    }

    public void mensagem(String msg) {
        Context contexto = getApplicationContext();
        int duracao = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(contexto, msg, duracao);
        toast.show();
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
}
