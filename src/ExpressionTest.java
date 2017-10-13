
public class ExpressionTest {
	public static void main(String[] args) {
		try {
			throw new Exception();
		}catch(Exception e) {
			System.err.println("Level Order not supported.");
		}
		for(int i = 0; i < 10; i++){
			System.out.println("Hi");
		}
	}
}
