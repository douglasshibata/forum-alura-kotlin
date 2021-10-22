package br.com.alura.forum.service

import br.com.alura.forum.dto.NovoTopicoForm
import br.com.alura.forum.mapper.TopicoFormMapper
import br.com.alura.forum.mapper.TopicoViewMapper
import br.com.alura.forum.model.Curso
import br.com.alura.forum.model.Topico
import br.com.alura.forum.model.Usuario
import org.springframework.stereotype.Service
import java.util.*

@Service
class TopicoService(private var topicos: List<Topico> = ArrayList(),
                    private val topicoViewMapper: TopicoViewMapper,
                    private val topicoFormMapper: TopicoFormMapper
) {

    fun listar(): List<Topico> {
        return topicos
    }

    fun buscarPorId(id: Long): Topico {
        return topicos.stream().filter { t ->
            t.id == id
        }.findFirst().get()
    }

    fun cadastrar(form: NovoTopicoForm) {
        val topico = topicoFormMapper.map(form)
        topico.id = topicos.size.toLong() + 1
        topicos = topicos.plus(topico)
    }
}