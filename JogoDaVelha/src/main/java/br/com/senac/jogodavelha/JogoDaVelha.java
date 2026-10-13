/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.com.senac.jogodavelha;

import java.util.Scanner;

/**
 *
 * @author yago62977756
 */
public class JogoDaVelha {

    public static void main(String[] args) {
       
       Scanner entrada = new Scanner(System.in);
    
    Tabuleiro tabuleiro = new Tabuleiro("1 - Cada jogador deve escolher um símbolo;"
            + "2 - O jogador 1 inícia a partida;");
    
    Jogador jogador1 = new Jogador(1,"Yago",'X');
    
    Jogador jogador2 = new Jogador(2, "Davi", 'O');
    
  do{
    tabuleiro.mostrarTabuleiro();
    
     if (tabuleiro.getJogadorDaVez() == 1) {
                System.out.println("Jogador 1, escolha onde jogar: ");
            } else {
                System.out.println("Jogador 2, escolha onde jogar: ");
            }

            String local = entrada.nextLine();
            boolean jogadaValida;

            if (tabuleiro.getJogadorDaVez() == 1) {
                jogadaValida = tabuleiro.marcarJogada(
                    jogador1.getSimbolo(), local
                );
            } else {
                jogadaValida = tabuleiro.marcarJogada(
                    jogador2.getSimbolo(), local
                );
            }

            if (jogadaValida) {
                if (tabuleiro.getJogadorDaVez() == 1) {
                    tabuleiro.verificarGanhador(jogador1.getSimbolo(), local);
                } else {
                    tabuleiro.verificarGanhador(jogador2.getSimbolo(), local);
                }
                
                if (!tabuleiro.isHouveGanhadorUltimaRodada()) {
                    if (tabuleiro.getJogadorDaVez() == 1) {
                        tabuleiro.setJogadorDaVez(2);
                    } else {
                        tabuleiro.setJogadorDaVez(1);
                    }
                }
            }

        } while (!tabuleiro.isHouveGanhadorUltimaRodada());

        tabuleiro.mostrarTabuleiro();
        tabuleiro.isHouveGanhadorUltimaRodada();
        entrada.close();
    }
}
