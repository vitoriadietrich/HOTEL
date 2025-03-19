//2) Como soletra?

fun main() {

    var valorPadrao = 0.0
    var usuario = ""

    var nome = ""
    var idade: Int = 0

    var segundoNome = ""
    var segundaIdade: Int = 0

    var terceiroNome = ""
    var terceiraIdade: Int = 0

    var quartoNome = ""
    var quartaIdade: Int = 0

    var totalHospedagem = 0.0
    var gratuidade = 0
    var meia = 0

    // Pergunta o valor da diária apenas uma vez
    println("Qual o valor padrão da diária?")
    val entrada = readlnOrNull()
    valorPadrao = entrada?.toDoubleOrNull() ?: return // Sai do programa se não for número
    println("O valor padrão definido é: R$ $valorPadrao")

    while (true) { //A PARTIR DA IDADE 25
        println("Qual o nome do hóspede?")
        nome = readln().toString()

        println("Qual a idade do hóspede?")
        idade = readln().toIntOrNull() ?: continue // Evita erro se não for número

        println("$nome cadastrado(a) com sucesso.")
        totalHospedagem += valorPadrao // Adiciona ao total
        //FIM DE PARTIR DA IDADE 25


        //A PARTIR DA IDADE 6
        println("Qual o nome do hóspede?")
        segundoNome = readln().toString()

        println("Qual a idade do hóspede?")
        segundaIdade = readln().toIntOrNull() ?: continue
        if (segundaIdade < 6) {
            println("$segundoNome cadastrado(a) com sucesso. $segundoNome possui gratuidade.")
            gratuidade++
        } else {
            println("Hóspede pagará normalmente.")
            totalHospedagem += valorPadrao
        }
        //FIM DE PARTIR DA IDADE 6


        //A PARTIR DA IDADE 19
        println("Qual o nome do hóspede?")
        terceiroNome = readln().toString()

        println("Qual a idade do hóspede?")
        terceiraIdade = readln().toIntOrNull() ?: continue

        println("$terceiroNome cadastrado(a) com sucesso.")
        totalHospedagem += valorPadrao
        //FIM DE PARTIR DA IDADE 19


        //IDADE MAIS DE 60
        println("Qual o nome do hóspede?")
        quartoNome = readln().toString()

        println("Qual a idade do hóspede?")
        quartaIdade = readln().toIntOrNull() ?: continue
        if (quartaIdade > 60) {
            println("$quartoNome cadastrado(a) com sucesso. $quartoNome paga meia")
            meia++
            totalHospedagem += valorPadrao / 2
        } else {
            println("Hóspede paga inteiro.")
            totalHospedagem += valorPadrao
        }
        //FIM DE MAIS DE 60


        // Pergunta se quer encerrar
        println("Digite 'PARE' para encerrar ou pressione ENTER para continuar:")
        usuario = readln().toString()
        if (usuario == "PARE") {
            println("Resumo das hospedagens:")
            println("Total arrecadado: R$ %.2f".format(totalHospedagem))
            println("Gratuidades: $gratuidade")
            println("Meias: $meia")
            break
        }
    }
}
