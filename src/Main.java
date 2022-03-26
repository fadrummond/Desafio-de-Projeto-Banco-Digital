
import java.util.Scanner;
import java.lang.Double;


public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
	while(true) {
		Cliente nomeCliente = new Cliente();
		
		System.out.print("** Abertura de Contas **  ** Digite 0 para encerrar. ** \n");
		System.out.print("Nome do Cliente:");
		nomeCliente.setNome(scan.next());
		
	  if (nomeCliente.nome.equals("0")) {		
			System.out.print("Sessão encerrada.");
			break;
			}
		else
		    {    Conta cc = new ContaCorrente(nomeCliente);
		         Conta poupanca = new ContaPoupanca(nomeCliente);

		  boolean continueLooping = true;
		  
	      do {      
		      try{     
		         String valorDeposito;
		         System.out.print("Valor deposito: ");
		         valorDeposito = scan.next();
		         double d = Double.parseDouble(valorDeposito);
		         continueLooping = false;
		         cc.depositar(d);
		         } catch (NumberFormatException e) {
		               System.out.println("Informe um valor válido.");
		         } 
	      } while(continueLooping);      
		        
	      continueLooping = true;
	      do {      
		      try{     
		         String valorPoupanca;
		         System.out.print("Valor poupança: ");
		         valorPoupanca = scan.next();
		         double d = Double.parseDouble(valorPoupanca);
		         continueLooping = false;
		         cc.transferir(d,poupanca);
		         } catch (NumberFormatException e) {
		               System.out.println("Informe um valor válido.");
		         } 
	      } while(continueLooping);         
	      
		         /*  Correto
		         double valorDeposito;
		         System.out.print("Valor deposito: ");
		         valorDeposito = scan.nextDouble();
		         cc.depositar(valorDeposito);
		         */
		         
		         /* Correto
		         double valorPoupanca;
		         System.out.print("Valor transferencia para a poupança: ");
		         valorPoupanca = scan.nextDouble();
		         cc.transferir(valorPoupanca,poupanca);			
                 */
		         cc.ImprimirExtrato();
		         poupanca.ImprimirExtrato();
		    }
		} 
	scan.close();
	}  
}
