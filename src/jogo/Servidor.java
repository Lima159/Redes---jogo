package jogo;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {
        
    public static void main(String args[]) throws Exception {

        String retornoUsuarioVermelho = "";
        String retornoUsuarioAzul = "";
        String entradaUsuarioVermelho;
        String entradaUsuarioAzul;
        ServerSocket server = new ServerSocket(8080);
        
        System.out.println("\nServidor rodando na porta 1234");

        while (!server.isClosed()) {
            
            Socket UsuarioVermelho = server.accept();
            if (UsuarioVermelho.isConnected()) {
                System.out.println("\nJogador vermelho (" + (UsuarioVermelho.getLocalAddress().toString()).substring(1) + ":"
                        + UsuarioVermelho.getLocalPort() + ") logado!");
            }
            DataOutputStream outUsuarioVermelho = new DataOutputStream(UsuarioVermelho.getOutputStream());
            Scanner inUsuarioVermelho = new Scanner(UsuarioVermelho.getInputStream());

            Socket UsuarioAzul = server.accept();
            if (UsuarioAzul.isConnected()) {
                System.out.println("jogador azul (" + (UsuarioAzul.getLocalAddress().toString()).substring(1) + ":"
                        + UsuarioVermelho.getLocalPort() + ") logado!");
            }
            DataOutputStream outUsuarioAzul = new DataOutputStream(UsuarioAzul.getOutputStream());
            Scanner inUsuarioAzul = new Scanner(UsuarioAzul.getInputStream());

            entradaUsuarioVermelho = inUsuarioVermelho.nextLine();
            entradaUsuarioAzul = inUsuarioAzul.nextLine();

            if (entradaUsuarioVermelho.equals(entradaUsuarioAzul)) {
                retornoUsuarioVermelho = "Empate";
                retornoUsuarioAzul = "Empate";
                System.out.println("EMPATE CONCEBIDO");
            }
            else if (entradaUsuarioVermelho.equals("R") && entradaUsuarioAzul.equals("S")) {
                retornoUsuarioVermelho = "VITÓRIA";
                retornoUsuarioAzul = "DERROTA";
                System.out.println("VERMELHO VENCE!");

            }
            else if (entradaUsuarioVermelho.equals("S") && entradaUsuarioAzul.equals("R")) {
                retornoUsuarioVermelho = "DERROTA";
                retornoUsuarioAzul = "VITÓRIA";
                System.out.println("AZUL VENCE");
            }
            else if (entradaUsuarioVermelho.equals("R") && entradaUsuarioAzul.equals("P")) {
                retornoUsuarioVermelho = "DERROTA";
                retornoUsuarioAzul = "VITÓRIA";
                System.out.println("AZUL VENCE");
            }
            else if (entradaUsuarioVermelho.equals("P") && entradaUsuarioAzul.equals("R")) {
                retornoUsuarioVermelho = "VITÓRIA";
                retornoUsuarioAzul = "DERROTA";
                System.out.println("VERMELHO VENCE");
            }
            else if (entradaUsuarioVermelho.equals("S") && entradaUsuarioAzul.equals("P")) {
                retornoUsuarioVermelho = "VITÓRIA";
                retornoUsuarioAzul = "DERROTA";
                System.out.println("VERMELHO VENCE");
            }
            else if (entradaUsuarioVermelho.equals("P") && entradaUsuarioAzul.equals("S")) {
                retornoUsuarioVermelho = "DERROTA";
                retornoUsuarioAzul = "VITÓRIA";
                System.out.println("AZUL VENCE");
            }
                        
            outUsuarioVermelho.writeBytes(retornoUsuarioVermelho.toUpperCase());
            outUsuarioAzul.writeBytes(retornoUsuarioAzul.toUpperCase());
            UsuarioVermelho.close();
            UsuarioAzul.close();

        }
        server.close();
    }
}
