//Hora de Codar 7: Um final em Terabithia. - 1) Quantos quartos são?

fun main() {
    val hotelNome = "Hotel King" // Nome do hotel
    var nome = "" // Nome do usuário
    val senhaCorreta = 2678 // Senha para acessar funcionalidades importantes
    val quartos = Array(20) { false } // false significa "livre", true significa "ocupado"
    var continuar = true

    // Função de verificação da senha
    fun validarSenha(): Boolean {
        print("Digite a sua senha: ")
        val senha = readLine()!!.toIntOrNull() ?: -1 // Lê a senha e trata entrada inválida
        if (senha != senhaCorreta) {
            println("Senha incorreta. Tente novamente.\n")
            return false // Retorna false se a senha estiver incorreta
        }
        return true // Retorna true se a senha estiver correta
    }

    // Função que exibe os quartos e suas ocupações
    fun exibirQuartos() {
        println("Lista de quartos e suas ocupações:")
        for (i in 0 until 20) {
            val status = if (quartos[i]) "ocupado" else "livre"
            println("${i + 1} - $status")
        }
    }

    // Função para realizar a reserva
    fun realizarReserva() {
        println("Qual o valor padrão da diária?")
        val valorDiaria = readLine()!!.toDoubleOrNull()
        if (valorDiaria == null || valorDiaria <= 0) {
            println("Valor inválido, $nome")
            return
        }

        println("Quantas diárias serão necessárias?")
        val dias = readLine()!!.toIntOrNull()
        if (dias == null || dias <= 0 || dias > 30) {
            println("Valor inválido, $nome")
            return
        }

        val totalHospedagem = valorDiaria * dias
        println("O valor de $dias dias de hospedagem é de R$$totalHospedagem")

        println("Qual o nome do hóspede?")
        val nomeHospede = readLine()!!

        var quartoValido = false
        var numeroQuarto: Int? = null

        // Laço para selecionar um quarto válido
        while (!quartoValido) {
            println("Qual o quarto para reserva? (1 - 20)?")
            numeroQuarto = readLine()!!.toIntOrNull()

            if (numeroQuarto == null || numeroQuarto !in 1..20) {
                println("Número de quarto inválido.")
            } else if (quartos[numeroQuarto - 1]) {
                println("Quarto já está ocupado. Escolha outro.")
                exibirQuartos()
            } else {
                quartoValido = true
            }
        }

        println("Quarto Livre.")

        // A confirmação da reserva
        println("$nome, você confirma a hospedagem para $nomeHospede por $dias dias para o quarto $numeroQuarto por R$$totalHospedagem? S/N")
        val confirmacao = readLine()!!

        if (confirmacao.equals("S", ignoreCase = true)) {
            // Aqui, vamos garantir que o número do quarto seja válido
            if (numeroQuarto != null) {
                quartos[numeroQuarto - 1] = true // Marca o quarto como ocupado
                println("$nome, reserva efetuada para $nomeHospede.")
            }
        }

        exibirQuartos()
    }

    // Função de erro caso a opção escolhida não exista
    fun erro() {
        println("Opção inválida. Por favor, escolha uma opção válida.\n")
    }

    // Função para saída do sistema
    fun sair() {
        println("Muito obrigado e até logo, $nome.")
    }

    // Função de início do sistema
    fun inicio() {
        println("Bem-vindo ao $hotelNome!")
        print("Informe seu nome: ")
        nome = readLine()!!
        println("Bem-vindo ao $hotelNome, $nome. É um imenso prazer ter você por aqui!")

        // Verificação da senha
        while (!validarSenha()) {}

        // Menu principal
        do {
            println("\nEscolha uma opção:")
            println("1. Realizar reserva")
            println("2. Exibir quartos")
            println("3. Sair")
            print("Digite a opção desejada: ")
            val opcao = readLine()!!.toIntOrNull() ?: -1

            when (opcao) {
                1 -> realizarReserva()
                2 -> exibirQuartos()
                3 -> sair().also { continuar = false }
                else -> erro()
            }
        } while (continuar)
    }

    // Chama a função de início
    inicio()
}
