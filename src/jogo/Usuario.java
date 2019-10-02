package jogo;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Usuario {
    
    private static String mensagem = "Bem vindo ao JoKenPo\n";
    private static String regras = "\n--REGRAS--\n - Pedra vence Tesoura\n - Tesoura vence papel\n - Papel vence pedra\n";

    public static void main(String args[]) throws Exception {

	String escolha;
	String resposta;
        boolean jogarNovamente = true;

	System.out.println(Usuario.mensagem);

	Scanner inFromUser = new Scanner(System.in);
        Scanner scan = new Scanner(System.in);

        do{
            Socket clientSocket = new Socket("127.0.0.1", 8080);
            PrintWriter outToServer = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            escolha = "";
            escolha = escolhaDaJogada(escolha, inFromUser);
            
            System.out.println("\nEsperando resposta...");

            envioDaJogada(outToServer, escolha);
            
            resposta = inFromServer.readLine();
            System.out.println(resposta);
            
            jogarNovamente = repetirJogo(jogarNovamente, scan);
            
            fecharConexoes(clientSocket, outToServer, inFromServer);
        }while(jogarNovamente);
    }
    
    public static String escolhaDaJogada(String escolha, Scanner inFromUser) throws IOException{
        
        do {
	    if (escolha.equals("REGRAS")) {
		System.out.println(Usuario.regras);
	    }
            
	    System.out.println("Utilize (R) para pedra (P) para papel, (S) para tesoura");
	    System.out.println("ou digite REGRAS para ler as regras\nDigite exit para sair");
	    escolha = inFromUser.nextLine();
            
	} while ((!escolha.equals("R") && !escolha.equals("P") && !escolha.equals("S")));
        
        return escolha;
    }
    
    public static void envioDaJogada(PrintWriter outToServer, String escolha) throws IOException{
        outToServer.println(escolha + "\n");
    }
    
    public static boolean repetirJogo(boolean jogarNovamente, Scanner scan){
        
        System.out.println("Jogar novamente?\n Digite false para não e true para sim");
        jogarNovamente = scan.nextBoolean();
        
        return jogarNovamente;
    }
    
    public static void fecharConexoes(Socket clientSocket, PrintWriter outToServer, BufferedReader inFromServer) throws IOException{
        clientSocket.close();
        outToServer.close();
        inFromServer.close();
    }
}
