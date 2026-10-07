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
    
    if(tabuleiro.getJogadorDaVez() == 1){
        System.out.println("Jogador 1, escolhe onde jogar:");
        String local = entrada.nextLine();
        
        tabuleiro.marcarJogada(jogador1.getSimbolo(),local);
        tabuleiro.setJogadorDaVez(2);
        tabuleiro.mostrarTabuleiro();
        tabuleiro.verificarGanhador(jogador1.getSimbolo(), jogador1.getNome());
    }
    else{
        System.out.println("Jogador 2, escolhe onde jogar:");
        String local = entrada.nextLine();
        
        tabuleiro.marcarJogada(jogador2.getSimbolo(), local);
        tabuleiro.setJogadorDaVez(1);
        tabuleiro.mostrarTabuleiro();
        tabuleiro.verificarGanhador(jogador2.getSimbolo(), jogador2.getNome());
    }
     
      }while(tabuleiro.isHouveGanhadorUltimaRodada() == false);
    }
}
