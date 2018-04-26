package br.edu.ifpr.paranagua.tads_recyclerview.app

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import br.edu.ifpr.paranagua.tads_recyclerview.remoto.servicos.BuscaTodasTarefasService
import br.edu.ifpr.paranagua.tads_recyclerview.R
import br.edu.ifpr.paranagua.tads_recyclerview.entidades.Tarefa
import br.edu.ifpr.paranagua.tads_recyclerview.remoto.dao.TarefaDaoRemoto
import br.edu.ifpr.paranagua.tads_recyclerview.remoto.servicos.TarefaRemotaListener
import br.edu.ifpr.paranagua.tads_recyclerview.ui.TarefasAdapter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity(), TarefaRemotaListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        carregarTarefas(TarefaDaoRemoto.TipoBusca.TODAS)


       val layout = LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false)

        listTarefas.layoutManager = layout

        btCarregar.setOnClickListener({ carregarTarefas(TarefaDaoRemoto.TipoBusca.PRONTAS) })
    }


    fun carregarTarefas(tipo: TarefaDaoRemoto.TipoBusca){
        var dao = TarefaDaoRemoto(this)
        //dao.buscarTodas()

        dao.buscarTarefas(tipo)
    }

    override fun onBuscaTodasReturn(tarefas: List<Tarefa>) {
        listTarefas.adapter = TarefasAdapter(tarefas)
    }

    override fun onTarefaError(mensagem: String) {

    }

    override fun onBuscaTarefasReturn(tarefas: List<Tarefa>) {
        listTarefas.adapter = TarefasAdapter(tarefas)
    }
}
