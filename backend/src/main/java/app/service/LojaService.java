package app.service;
import app.models.Carro;
import app.models.ObjetoArquivo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lucas
 */
@Service
public class LojaService {



    //Servico responsavel por calcular o valor de locacao
    public Carro calcularValorLocacao(ObjetoArquivo objetoArquivo){

        List<Carro> carros = new ArrayList<>();

        carros.add(new Carro("SouthCar","COMPACTO",4, new int[][]{{210,200},{150,90}}));
        carros.add(new Carro("WestCar","FERRARI",2, new int[][]{{530,200},{150,90}}));
        carros.add(new Carro("NorthCar","NAVIGATOR",7, new int[][]{{630,600},{580,590}}));

        List<Integer> resultadoValorCarro = new ArrayList<>();

        String categoriaCarro = objetoArquivo.getTipoCarro();
        int quantidadePessoas = objetoArquivo.getQuantidadePassageiros();
        String intervaloLocacao[] = objetoArquivo.getIntervaloData();

        int valor=0, tipoCliente=0;
        int quantidadeDias = intervaloLocacao.length; //Armazena a quantidade de dias reservados para locacao

        for(Carro carro: carros) {
            resultadoValorCarro.add(0);
            //Caso o numero de passageiros atenda a capacidade de pessoas e exista carros disponiveis, calcula-se o valor da loca��o
            if (quantidadePessoas <= carro.getCapacidadeLimite() && carro.isDisponibilidade()) {
                if (!categoriaCarro.equals("Normal")) { //Verifica se o cliente e do tipo "Normal" ou "Premium"
                    tipoCliente = 1; //Caso ele seja "Premium" recebera o valor 1
                }

                for (int i = 0; i < quantidadeDias; i++) { //laco responsavel por calcular cada dia de locacao
                    //se o dia da locacao for final de semana, analisando pela posicao do dia da semana no arquivo de entrada
                    if (intervaloLocacao[i].substring(11, 14).equals("sab") || intervaloLocacao[i].substring(11, 14).equals("dom")) {
                        valor += carro.getTaxa()[tipoCliente][1]; //acumula o valor da locacao a cada iteracao para cliente "Premium"
                        resultadoValorCarro.set(carros.indexOf(carro), valor);
                    } else {
                        valor += carro.getTaxa()[tipoCliente][0]; //acumula o valor da locacao a cada iteracao para cliente "Normal"
                        resultadoValorCarro.set(carros.indexOf(carro), valor);
                    }
                }
            }
        }

        int menorValorAtual = 0;
        Carro melhorCarro = null;

        for(Integer resultado: resultadoValorCarro){

            carros.get(resultadoValorCarro.indexOf(resultado)).setValorTotal(resultado);

            if(menorValorAtual == 0){
                menorValorAtual = resultado;
            }
            else if(resultado.compareTo(menorValorAtual) < 0){
                menorValorAtual = resultado;
            }
            melhorCarro = carros.get(resultadoValorCarro.indexOf(menorValorAtual));
        }

        return melhorCarro;
    }  
}
