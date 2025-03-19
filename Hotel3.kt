import kotlin.system.exitProcess

// 3) Com "S" ou com "Z"?
fun main() {
    cadastrarHospedes()
}

fun cadastrarHospedes() {
    val listaHospedes = mutableListOf(
        "Carlos Villagran",
        "Maria Antonieta de las Nieves",
        "Roberto Gómez Bolaños",
        "Florinda Meza",
        "Ramón Valdés",
        "Rubén Aguirre",
        "Angelines Fernández",
        "Edgar Vivar",
        "Horácio Gómez Bolaños",
        "Raúl Padilla",
        "Vitoria Dietrich",
        "Wanderlei Dietrich",
        "Neide de Jesus",
        "Carolina Viana",
        "Jackson Rodrigo"

    )

    while (true) {
        println("""Cadastro de Hóspedes
        Selecione uma opção:
        1. Cadastrar
        2. Pesquisar
        3. Sair"""
        )

        val escolha = readln().toIntOrNull()

        when (escolha) {
            1 -> cadastrarNovoHospede(listaHospedes)
            2 -> pesquisarHospede(listaHospedes)
            3 -> sairCadastroDeHospedes()
            else -> erroCadastroDeHospedes()
        }
    }
}

fun cadastrarNovoHospede(listaHospedes: MutableList<String>) {
    println("Cadastro de Hóspedes.\nPor favor, informe o nome do Hóspede:")
    val novoHospede = readln()

    if (novoHospede.isNotBlank()) {
        listaHospedes.add(novoHospede)
        println("$novoHospede cadastrado(a) com sucesso!")
        println("Lista de Hóspedes atuais: $listaHospedes")
    } else {
        println("Nome inválido! O cadastro não pode ser vazio.")
    }
}

fun pesquisarHospede(listaHospedes: MutableList<String>) {
    println("Pesquisa de Hóspedes.\nPor favor, informe o nome do Hóspede:")
    val nomeHospede = readln()

    val encontrados = listaHospedes.filter { it.contains(nomeHospede, ignoreCase = true) }

    if (encontrados.isNotEmpty()) {
        println("\nEncontramos a(s) hóspede(s):")
        encontrados.forEach { println(it) }
    } else {
        println("Não encontramos nenhuma hóspede com esse nome.")
    }
}

fun sairCadastroDeHospedes() {
    println("Você deseja sair? S/N")
    val escolha = readln()

    when (escolha.uppercase()) {
        "S" -> {
            println("Hasta la vista, Baby.")
            exitProcess(0)
        }
        "N" -> println("Ok, voltando ao início.")
        else -> {
            println("Desculpe, mas não compreendi.")
            sairCadastroDeHospedes()
        }
    }
}

fun erroCadastroDeHospedes() {
    println("Por favor, informe um número entre 1 e 3.")
}
