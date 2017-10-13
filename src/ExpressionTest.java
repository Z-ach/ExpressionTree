import TreePackage.ExpressionTree;

public class ExpressionTest {
	public static void main(String[] args) {
		ExpressionTree exp = new ExpressionTree(new String[]{"a", "b", "2", "/","+"});
		exp.setVariable("a", 1.5);
		exp.setVariable("b", 2);
		System.out.println(exp.evaluate());
		exp.displayPostfix();
	}
}
