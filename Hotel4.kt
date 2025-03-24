//4) Que horas você pode?

import kotlin.math.ceil

fun main() {
    println("Parte 1: Quantidade de Convidados")
    print("Qual o número de convidados para o seu evento? ")
    val convidados = readLine()!!.toInt()

    if (convidados < 0 || convidados > 350) {
        println("Quantidade de convidados superior à capacidade máxima")
        return
    }

    val auditorio: String = if (convidados <= 150) {
        "Laranja"
    } else {
        "Colorado"
    }

    val cadeirasExtras = if (convidados in 151..350) convidados - 150 else 0

    println("Use o auditório $auditorio${if (cadeirasExtras > 0) " (inclua mais $cadeirasExtras cadeiras)" else ""}")
    println("Agora vamos ver a agenda do evento.")

    println("Parte 2: Agenda")
    print("Qual o dia do evento? ")
    val diaSemana = readLine()!!.lowercase()
    print("Qual é a hora do evento? ")
    val hora = readLine()!!.toInt()

    val disponivel = when (diaSemana) {
        "segunda", "terça", "quarta", "quinta", "sexta" -> hora in 7..23
        "sábado", "domingo" -> hora in 7..15
        else -> false
    }

    if (!disponivel) {
        println("Auditório indisponível")
        return
    }

    print("Qual o nome da empresa? ")
    val empresa = readLine()!!
    println("Auditório reservado para $empresa. ${diaSemana.replaceFirstChar { it.uppercase() }} às ${hora}h.")

    println("Parte 3: Equipe de Serviço")
    print("Qual a duração do evento em horas? ")
    val duracao = readLine()!!.toInt()

    val garconsNecessarios = ceil(convidados / 12.0).toInt() + (duracao / 2)
    val custoGarcons = garconsNecessarios * 10.50 * duracao

    println("São necessários $garconsNecessarios garçons.")
    println("Custo: R$ ${"%.2f".format(custoGarcons)}")
    println("Agora vamos calcular o buffet do hotel para o evento.")

    println("Parte 4: Buffet")
    val cafe = convidados * 0.2
    val agua = convidados * 0.5
    val salgados = convidados * 7

    val custoCafe = cafe * 0.80
    val custoAgua = agua * 0.40
    val custoSalgados = ceil(salgados / 100.0) * 34.0
    val custoBuffet = custoCafe + custoAgua + custoSalgados

    println("O evento precisará de ${cafe.toInt()} litros de café, ${agua.toInt()} litros de água, $salgados salgados.")

    println("Parte 5: Conferência")
    println("Evento no Auditório $auditorio.")
    println("Nome da Empresa: $empresa.")
    println("Data: ${diaSemana.replaceFirstChar { it.uppercase() }}, ${hora}h às ${hora + duracao}h.")
    println("Duração do evento: ${duracao}h.")
    println("Quantidade de garçons: $garconsNecessarios.")
    println("Quantidade de Convidados: $convidados")
    println("Custo dos garçons: R$ ${"%.2f".format(custoGarcons)}")
    println("Custo do Buffet: R$ ${"%.2f".format(custoBuffet)}")
    println("Valor total do Evento: R$ ${"%.2f".format(custoGarcons + custoBuffet)}")

    print("Gostaria de efetuar a reserva? S/N: ")
    val resposta = readLine()!!
    if (resposta.equals("S", ignoreCase = true)) {
        println("$empresa, reserva efetuada com sucesso.")
    } else {
        println("Reserva não efetuada.")
    }
}