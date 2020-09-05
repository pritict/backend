import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a="9";
		String b="3";
		System.out.println(a.compareTo(b));
List<String> list = new ArrayList<String>();
list.stream().collect(Collectors.joining());
	}
}
