package dailyCodingProblem;

public class _114_Reverse_Words_Delimiters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String input = "hello/world:here";
		int len = input.length();
		
		StringBuilder sb = new StringBuilder();
		int end = len - 1;
		
		while(end >= 0) {
			int i = end;
			
			while(i >= 0 && Character.isLetter(input.charAt(i))) {
				i--;
			}
			
			/*if(i == 0) {
				sb.append(input.substring(start, i-1));
				sb.append(input.charAt(i-1));
				break;
			}*/
				
			
			sb.append(input.substring(i + 1, end));
			sb.append(input.charAt(end));
			//sb = String.valueOf(input.charAt(i)).concat(sb.toString());
			end = i - 1;
			
			
		}

		System.out.println("Reversed String = " + sb.toString());
		
	}

}
