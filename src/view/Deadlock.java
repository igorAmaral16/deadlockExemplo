package view;

public class Deadlock {
			
		public static void main(String[] args) {
			
			 String recurso1 = "Recurso 1";
			 String recurso2 = "Recurso 2";
			
			Thread t1 = new Thread() {
				public void run() {
					synchronized (recurso1){						
						System.out.println("Thread 1: bloqueou o " + recurso1);
						
						try {
							Thread.sleep(100);
							
						} catch (InterruptedException e) {
							e.printStackTrace();
							
						}
						
						System.out.println("Thread 1: tentando acessar o " + recurso2);
					
						synchronized (recurso2) {
							System.out.println("Thread 1: bloqueou o " + recurso2);
							
						}
					}
				}
			};
			
			Thread t2 = new Thread() {
				public void run() {
					synchronized (recurso2) {	
						System.out.println("Thread 2: bloqueou o " + recurso1);
						
						try {
							Thread.sleep(100);
							
						} catch (InterruptedException e) {
							e.printStackTrace();
							
						}
						
						System.out.println("Thread 2: tentando acessar o " + recurso1);
					
						synchronized (recurso1) {
							System.out.println("Thread 2; bloqueou o " + recurso1);
							
						}
					}
				}
			};
			
			t1.start();
			t2.start();
			
			//Esse é um exemplo de deadlock de posse e espera, pois a t1 possui o recurso1 e requer o recurso2,
			//e a t2 possui o recurso2 e requer o recurso1, ficando ambas as Threads em espera até a liberação de algum recurso
			
		}
		
}
