package br.edu.ifpr.paranagua.tads_recyclerview.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.edu.ifpr.paranagua.tads_recyclerview.R
import br.edu.ifpr.paranagua.tads_recyclerview.entidades.Tarefa
import kotlinx.android.synthetic.main.tarefa_item.view.*

class TarefasAdapter(val tarefas: List<Tarefa>) :
        RecyclerView.Adapter<TarefasAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
            parent: ViewGroup?, viewType: Int): ViewHolder {

        val view = LayoutInflater
                .from(parent?.context)
                .inflate(R.layout.tarefa_item,
                        parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = tarefas.size

    override fun onBindViewHolder(
            holder: ViewHolder?, position: Int) {
        val tarefa = tarefas[position]
        holder?.let {
            it.preencherView(tarefa)
        }
    }

    class ViewHolder(view: View) :
            RecyclerView.ViewHolder(view) {

        fun preencherView(tarefa: Tarefa) {
            itemView.txtTarefaTitulo.text = tarefa.titulo
            itemView.txtTarefaDescricao.text = tarefa.descricao
        }
    }
}

