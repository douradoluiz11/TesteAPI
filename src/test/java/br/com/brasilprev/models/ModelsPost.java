package br.com.brasilprev.models;

import javax.swing.JOptionPane;

public class ModelsPost {

   public static String nome = JOptionPane.showInputDialog(null, "Informe Nome Completo");
   public static  String cpf = JOptionPane.showInputDialog(null, "Informe CPF");
   int cpfw = Integer.parseInt(cpf);
   public static  String logradouro = JOptionPane.showInputDialog(null, "Informe Logradouro");
   public static  int num =  Integer.parseInt(JOptionPane.showInputDialog(null, "Informe Numero da Residência"));
   public static  String complemento = JOptionPane.showInputDialog(null, "Informe Complemento");
   public static  String bairro = JOptionPane.showInputDialog(null, "Informe Nome Bairro");
   public static  String cidade = JOptionPane.showInputDialog(null, "Informe Nome Cidade");
   public static  String estado = JOptionPane.showInputDialog(null, "Informe Nome Estado");
   public static  int ddd =  Integer.parseInt(JOptionPane.showInputDialog(null, "Informe DDD"));
   public static  int cel =  Integer.parseInt(JOptionPane.showInputDialog(null, "Informe Celular"));


}
