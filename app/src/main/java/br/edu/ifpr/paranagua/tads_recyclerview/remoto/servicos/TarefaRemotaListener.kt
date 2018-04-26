package br.edu.ifpr.paranagua.tads_recyclerview.remoto.servicos

import br.edu.ifpr.paranagua.tads_recyclerview.entidades.Tarefa

/**
 * Created by aluno on 26/04/18.
 */
interface TarefaRemotaListener {
    fun onBuscaTodasReturn(tarefas: List<Tarefa>)
    fun onTarefaError(mensagem: String)
    fun onBuscaTarefasReturn(tarefas: List<Tarefa>)
}