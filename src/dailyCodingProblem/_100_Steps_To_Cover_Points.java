package dailyCodingProblem;

public class _100_Steps_To_Cover_Points {

	public static void main(String[] args) {
		
		int[][] points = new int[][] {
			{0,1},
			{2,2}
		};
		
		int steps = 0;
		for(int index = 0; index < points.length - 1; index++) {
			steps += findSteps(points[index], points[index+1]);
		}
		
		System.out.println("# of steps = " + steps);

	}
	
	private static int findSteps(int[] point1, int[] point2) {
		int x = Math.abs(point1[0] - point2[0]);
		int y = Math.abs(point1[1] - point2[1]);
		
		return Math.max(x, y);
	}
	
}
