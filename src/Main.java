import java.util.HashMap;
import java.util.Scanner;

public class Main {

	static int n;
	static int k;
	
	static HashMap<Line, Integer> lines = new HashMap<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		k=sc.nextInt();
		
		for (int i=0;i<n;i++) { // iterate all mushrooms
			int x = sc.nextInt()-1;
			int y= sc.nextInt()-1;
			
			for (int direction = 0; direction<4;direction++) { //iterate all line directions
				Line line = getLine(x,y,direction); // get the line that passes (x,y) with direction
				int count = increaseCount(line); // increase the number of points on the line.
				if (count>=k) { // the number of points on the line approaches k, we finish.
					System.out.println(i+1);
					return;
				}
			}
			
		}
		
		System.out.println(-1); // cannot approach k.
	}

	private static int increaseCount(Line line) {
		// TODO Auto-generated method stub
		if (lines.containsKey(line)) {
			int oldCount = lines.get(line);
			lines.put(line, oldCount+1);
			return oldCount+1;
		} else {
			lines.put(line, 1);
			return 1;
		}
		
	}

	private static Line getLine(int x, int y, int direction) {
		// TODO Auto-generated method stub
		switch (direction) {
		case 0:
			return new Line(0,y,direction);
		case 1:
			return new Line(x-y,0,direction);
		case 2:
			return new Line(x,0,direction);
		case 3:
			return new Line(x+y,0,direction);
		default:
			return null;
		}
	}

}

class Line {
	int x,y,dir;
	
	public Line(int x, int y, int dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dir;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Line other = (Line) obj;
		if (dir != other.dir)
			return false;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
	
}
