
public class Main {

	public static void main(String[] args) {
		for (int i = 1; i < 10; i++) {
			System.out.print("   "+i);
		}
		System.out.println();
		
		//直排
		for (int i = 1; i < 10; i++) {
			System.out.print(i);
			
			//橫排
			for (int j = 1; j < 10; j++) {
				if (j == 1) {
					System.out.print("  ");
				}else {
					if (i*j >= 10) {
						System.out.print("  ");
					}else {
						System.out.print("   ");
					}
				}
				System.out.print(i*j);
			}
			
			System.out.println();
		}
	}

}
