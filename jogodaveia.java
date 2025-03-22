import java.util.Scanner;
import java.util.Random;

public class jogodaveia{
	private static int[][] jogo = new int[3][3];
	private static int j;
	private static Boolean vitoria, partida;

	public static void main(String[] args){
		Scanner ler = new Scanner(System.in);
		Random sortea = new Random();
		int a, b, jogador;
		char rp;	
		Boolean jogando = true, funfa = true;
		do{
			System.out.println("Escolha o modo de jogo, digitando o valor mostrado: \n");
			System.out.println("1. Jogador VS Jogador");
			System.out.println("2. Jogador VS Maquina");
			System.out.println("3. Maquina VS Maquina");
			j = ler.nextInt();
			for(a=0;a<3;a++){
				for(b=0;b<3;b++){
					jogo[a][b]=0;
				}
			}
			vitoria=false;
			partida = true;
			if (j==1){
				jogador = sortea.nextInt(2);
				System.out.println("1 eh X, no caso, o Jogador 1!");
				System.out.println("2 eh O, no caso o Jogador 2!");
				
				while(partida){
					if(jogador==0 && !vitoria){
						System.out.println("Vez do Jogador 1 de jogar!");
						tab();
						do{
							System.out.print("Escolha a coluna: ");
							b = ler.nextInt();
							b--;
							System.out.print("Escolha a linha: ");
							a = ler.nextInt();
							a--;
							if(a<3 && b<3){
								if(jogo[a][b]==0 && a<3 && b<3){
									jogo[a][b]=1;
									funfa = false;
								}else{
									System.out.println("Lugar ja preeenchido!");
								}
							}
						}while(funfa);
						jogador=1;
						funfa=true;
					}
					tab();
					verificar();
					if(jogador==1 && !vitoria){
						System.out.println("Vez do Jogador 2!");
						tab();
						do{
							System.out.print("Escolha a coluna: ");
							b = ler.nextInt();
							b--;
							System.out.print("Escolha a linha: ");
							a = ler.nextInt();
							a--;
							if(a<3 && b<3){
								if(jogo[a][b]==0 && a<3 && b<3){
									jogo[a][b]=2;
									funfa = false;
								}else{
									System.out.println("Lugar ja preeenchido!");
								}
							}
						}while(funfa);
						tab();
						funfa=true;
						jogador=0;
						verificar();

					}
					
				}
				System.out.print("Deseja continuar jogando? [S/N]: ");
				rp = ler.next().charAt(0);
				if(rp=='n' || rp=='N'){
					jogando=false;
				}
			}
			if (j==2){
				jogador = sortea.nextInt(2);
				System.out.println("1 eh X, no caso, voce!");
				System.out.println("2 eh O, no caso o computador!");
				
				while(partida){
					if(jogador==0 && !vitoria){
						System.out.println("Sua vez de jogar!");
						tab();
						do{
							System.out.print("Escolha a coluna: ");
							b = ler.nextInt();
							b--;
							System.out.print("Escolha a linha: ");
							a = ler.nextInt();
							a--;
							if(a<3 && b<3){
								if(jogo[a][b]==0){
									jogo[a][b]=1;
									funfa = false;
								}else{
									System.out.println("Lugar ja preeenchido!");
								}
							}
						}while(funfa);
						jogador=1;
						funfa=true;
					}
					tab();
					verificar();
					if(jogador==1 && !vitoria){
						System.out.println("Vez do computador!");
						do{
							b = sortea.nextInt(3);
							a = sortea.nextInt(3);
							if(jogo[a][b]==0){
								jogo[a][b]=2;
								funfa = false;
							}
						}while(funfa);
						tab();
						funfa=true;
						jogador=0;
						verificar();

					}
					
				}
				System.out.print("Deseja continuar jogando? [S/N]: ");
				rp = ler.next().charAt(0);
				if(rp=='n' || rp=='N'){
					jogando=false;
				}
			}
			if(j==3){
				jogador = sortea.nextInt(2);
				System.out.println("1 eh X, no caso o computador!");
				System.out.println("2 eh O, no caso o computador!");
				
				while(partida){
					if(jogador==0 && !vitoria){
						System.out.println("Vez do computador 1!");
						do{
							b = sortea.nextInt(3);
							a = sortea.nextInt(3);
							if(jogo[a][b]==0){
								jogo[a][b]=1;
								funfa = false;
							}
						}while(funfa);
						tab();
						funfa=true;
						jogador=1;
						

					}
					verificar();
					if(jogador==1 && !vitoria){
						System.out.println("Vez do computador 2!");
						do{
							b = sortea.nextInt(3);
							a = sortea.nextInt(3);
							if(jogo[a][b]==0){
								jogo[a][b]=2;
								funfa = false;
							}
						}while(funfa);
						funfa=true;
						jogador=0;
						verificar();

					}
					tab();

					
				}
				System.out.print("Deseja continuar jogando? [S/N]: ");
				rp = ler.next().charAt(0);
				if(rp=='n' || rp=='N'){
					jogando=false;
				}


			}
		}while(jogando);
		
	}
	public static void tab(){
		int a, b;
		for(a=0;a<3;a++){
			for(b=0;b<3;b++){
				System.out.print(jogo[a][b]+" ");
								
			}
			System.out.println(" ");
		}
	}
	public static void verificar(){
		int i, k, cont;
		cont=0;
		for(i=0;i<3;i++){
			if((jogo[i][0]==jogo[i][1] && jogo[i][0]==jogo[i][2]) && (jogo[i][0]!=0 && jogo[i][1]!=0 && jogo[i][2]!=0)){
				if(j==1){
					if(jogo[i][0]==1){
						System.out.println("Jogador 1 ganhou!");
						vitoria = true;
						partida = false;
					}
					if(jogo[i][0]==2){
						System.out.println("Jogador 2 ganhou!");
						vitoria = true;
						partida = false;
					}
				}
				if(j==2){
					if(jogo[i][0]==1){
						System.out.println("Voce ganhou!");
						vitoria = true;
						partida = false;
					}
					if(jogo[i][0]==2){
						System.out.println("Voce perdeu pro computador!");
						vitoria = true;
						partida = false;
					}
				}
				if(j==3){
					if(jogo[i][0]==1){
						System.out.println("Computador 1 ganhou!");
						vitoria = true;
						partida = false;
					}
					if(jogo[i][0]==2){
						System.out.println("Computador 2 ganhou!");
						vitoria = true;
						partida = false;
					}
				}
			}
		}
		for(i=0;i<3;i++){
			if((jogo[0][i]==jogo[1][i] && jogo[0][i]==jogo[2][i]) && (jogo[0][i]!=0 && jogo[1][i]!=0 && jogo[2][i]!=0)){
				if(j==1){
					if(jogo[0][i]==1){
						System.out.println("Jogador 1 ganhou!");
						vitoria = true;
						partida = false;
					}
					if(jogo[0][i]==2){
						System.out.println("Jogador 2 ganhou!");
						vitoria = true;
						partida = false;
					}
				}
				if(j==2){
					if(jogo[0][i]==1){
						System.out.println("Voce ganhou!");
						vitoria = true;
						partida = false;
					}
					if(jogo[0][i]==2){
						System.out.println("Voce perdeu pro computador!");
						vitoria = true;
						partida = false;
					}
				}
				if(j==3){
					if(jogo[0][i]==1){
						System.out.println("Computador 1 ganhou!");
						vitoria = true;
						partida = false;
					}
					if(jogo[0][i]==2){
						System.out.println("Computador 2 ganhou!");
						vitoria = true;
						partida = false;
					}
				}
			}
		}
		if(((jogo[0][0]==jogo[1][1] && jogo[1][1]==jogo[2][2]) || (jogo[0][2]==jogo[1][1] && jogo[2][0]==jogo[1][1])) && jogo[1][1]!=0){
			if(j==1){
				if(jogo[1][1]==1){
					System.out.println("Jogador 1 ganhou!");
					vitoria = true;
					partida = false;
				}
				if(jogo[1][1]==2){
					System.out.println("Jogador 2 ganhou!");
					vitoria = true;
					partida = false;
				}
			}
			if(j==2){
				if(jogo[1][1]==1){
					System.out.println("Voce ganhou!");
					vitoria = true;
					partida = false;
				}
				if(jogo[1][1]==2){
					System.out.println("Voce perdeu pro computador!");
					vitoria = true;
					partida = false;
				}
			}
			if(j==3){
				if(jogo[1][1]==1){
					System.out.println("Computador 1 ganhou!");
					vitoria = true;
					partida = false;
				}
				if(jogo[1][1]==2){
					System.out.println("Computador 2 ganhou!");
					vitoria = true;
					partida = false;
				}
			}
		}
		for(i=0;i<3;i++){
			for(k=0;k<3;k++){
				if(jogo[i][k]!=0){
					cont++;
				}
			}
		}
		if(cont==9 && !vitoria){
			vitoria=true;
			partida=false;
			System.out.println("Deu velha!");
		}


	}

}