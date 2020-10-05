package src.solutions.dailySolutions;

public class _113_ReverseStringInGroup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String input = "hello world here";
		String[] arr = input.split("\\s+");
		StringBuilder sb = new StringBuilder();
		for(int index = arr.length - 1; index >= 0; index--) {
			if(sb.length() > 1)
				sb.append(" ");
			sb.append(arr[index]);
		}
		System.out.println("Reversed String = " + sb.toString());
	}

}
