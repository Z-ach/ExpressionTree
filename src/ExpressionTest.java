import TreePackage.ExpressionTree;

public class ExpressionTest {
	public static void main(String[] args) {
		ExpressionTree exp = new ExpressionTree(new String[]{"a", "b", "5", "/","+"});
		exp.setVariable("a", 1.5);
		exp.setVariable("b", 2000);
		System.out.println(exp.evaluate());
		exp.displayPostfix();
	}
}
