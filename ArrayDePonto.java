import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

class ArrayDePonto {
    public static void main(String[] args) {
        Scanner edu = new Scanner(System.in);
        
        DateTimeFormatter parser = DateTimeFormatter.ofPattern("HH:mm");
        
        System.out.println("=================================================");
        System.out.println("DADOS DE PONTO A SEREM VERIFICADOS PARA APROVAÇÃO");
        System.out.println("=================================================");
        
        System.out.print("FUNCIONARIO: ");
        String funcionario = edu.nextLine();
        edu.nextLine();
        
        System.out.print("ID: ");
        int id_de_funcionario = edu.nextInt();
        edu.nextLine();
        
        System.out.print("Qual seu salario " + funcionario + " ? ");
        double salario = edu.nextDouble();
        edu.nextLine();
        
        System.out.print("Qual a taxa em caso de descumprimento da folha de ponto? ");
        double taxa = edu.nextDouble();
        edu.nextLine();
        
        
        System.out.println("================================================");
        System.out.println("==================DADOS SALVOS!=================");
        System.out.println("================================================");
        
        String[] entradas = {"Entrada 1", "Saida 1", "Entrada 2", "Saida 2"};
        LocalTime[] horarios = new LocalTime[4];
        
        for(int i = 0; i < entradas.length; i++) {
            System.out.print(entradas[i] + ": ");
            
            horarios[i] = LocalTime.parse(edu.nextLine(), parser);
        }
        
        System.out.println("===========VERIFICANDO...============");
        
        System.out.print("Qual horario você realmente entrou?: ");
        LocalTime entradaReal = LocalTime.parse(edu.nextLine(), parser);
        
        if(entradaReal.isAfter(horarios[0])) {
            System.out.println("[ERROR] VERIFICAR HORARIO COM RH OU GERENTE LOCAL ! ");
            System.out.println("[ | SALARIO: " + salario + " | TAXA: " + taxa + " | ]");
        }
        else {
            System.out.println("[OK] PARABÈNS " + funcionario + " SEUS HORARIOS ESTÃO EM DIA ! ");
            System.out.println("[ | CHECK-LIST DE " + funcionario + " | ]");
            System.out.println("[ | ENTRADA 1: ...[OK] | ]" );
            System.out.println("[ | SAIDA 1: ...[OK] | ]" );
            System.out.println("[ | ENTRADA 2: ...[OK] | ]" );
            System.out.println("[ | SAIDA 2: ...[OK] | ]" );
            System.out.println("[ | GERANDO REALTORIO FINAL... | ]" );
        } 
        
        System.out.println("===============================================");
        System.out.println("==============REALTORIO FINAL==================");
        System.out.printf("| ID: %d | FUNCIONARIO: %s\n |", id_de_funcionario, funcionario + " | ");
        
        for(int i = 0; i < entradas.length; i++) {
            System.out.println("ENTRADAS: " + entradas[i] + " | " + horarios[i] + " | ");
        }
        
        System.out.println("ENTRADA REAL: " + entradaReal);
        System.out.printf("[ | TOTAL DO SALARIO A RECEBER: %.2f", salario - taxa / 100, " | ]");
        
        System.out.println("===============================================");
        
    }
}