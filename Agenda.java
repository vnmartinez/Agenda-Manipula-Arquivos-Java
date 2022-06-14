import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Agenda {
    public static void main(String[] args) {
    pessoa contato = new pessoa();
    Scanner sc = new Scanner(System.in);
    FileWriter gravador;
    FileReader leitor;
    String linha;
    int i;
    
    do{
        System.out.printf("1. Gravar novo Contato\n2.Ler Contatos Salvos\n0.Sair\n");
        i=sc.nextInt();
        sc.nextLine();
    switch (i) {
        case 1:
            System.out.printf("Informe o nome do contato: ");
            contato.nome=sc.nextLine();
            System.out.println("Informe o telefone do contato: ");
            contato.telefone = sc.nextLine();

            try {             
                gravador = new FileWriter("arq.txt",true);
                gravador.write("Contato: "+contato.nome);    
                gravador.write("Telefone: "+contato.telefone+"\n\n");
                gravador.close();
                } 
                catch (Exception e) {
                    System.out.println("Erro"+e.getMessage());
                }
            
            break;
        case 2:
            try {
                leitor = new FileReader("arq.txt");
                BufferedReader buffer = new BufferedReader(leitor);
                linha = buffer.readLine();
                while (linha != null){
                    System.out.println(linha+"\n");
                    linha = buffer.readLine();
                }
                
            } catch (Exception e) {
                System.out.println("Erro"+e.getMessage());
            }

        case 0:
            System.out.println("Saindo do programa!!");
            break;
        default:
                System.out.println("Comando não reconhecido, digite novamente");
            break;
    }
    
    }while(i!=0);

    }
}

class pessoa{
    String nome;
    String telefone;
}
