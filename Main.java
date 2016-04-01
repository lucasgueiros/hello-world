import sun.misc.SharedSecrets;

import javax.swing.*;
import java.util.Scanner;

/**
 * Created by lucas on 31/03/16.
 */
public class Main {
    public static void main (String [] args) {
        String senha = JOptionPane.showInputDialog("Senha");
        String normal = JOptionPane.showInputDialog("Mensagem normal");
        String codificada = JOptionPane.showInputDialog("Mensagem codificada");

        if(codificada.equals("")){
            codificada = codificar(senha, normal);
            normal = decodificar(senha, codificada);
        }
        else {
            normal = decodificar(senha, codificada);
            codificada = codificar(senha,normal);
        }

        System.out.println("Codificada: " + codificada);
        System.out.println("Nomal: " + normal);

    }

    private static String codificar(String senha, String normal) {
        char [] mensagem = normal.toCharArray();
        char senha_char = senha.charAt(0);

        for(int i=0;i<mensagem.length;i++) {
            mensagem [i] = codificar(senha_char,mensagem[i]);
        }

        return new String(mensagem);
    }
