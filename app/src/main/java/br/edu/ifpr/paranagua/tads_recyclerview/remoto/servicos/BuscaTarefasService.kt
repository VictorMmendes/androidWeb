package br.edu.ifpr.paranagua.tads_recyclerview.remoto.servicos

/**
 * Created by aluno on 26/04/18.
 */
import br.edu.ifpr.paranagua.tads_recyclerview.entidades.Tarefa
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by aluno on 19/04/18.
 */
interface BuscaTarefasService {
    @GET("busca_{tipo}.php")
    fun buscaTarefas(@Path("tipo") tipo: String): Call<List<Tarefa>>
}