import java.awt.geom.Line2D;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class P102 {
	public static void main(String[] args) {
		P102 runner = new P102();
		runner.run();
	}

	public void run() {
		String filePath = "p102_triangles.txt";
		Point origin = new Point(0, 0);
		Point edge = new Point(1000, 0);
		Point[][] points = readFile(filePath);
		Line2D.Double center = new Line2D.Double(origin, edge);
		int counter = 0;
		for (int i = 0; i < points.length; i++) {
			Line2D.Double a = new Line2D.Double(points[i][0], points[i][1]);
			Line2D.Double b = new Line2D.Double(points[i][0], points[i][2]);
			Line2D.Double c = new Line2D.Double(points[i][1], points[i][2]);
			int intersects = 0;
			if (center.intersectsLine(a))
				intersects++;
			if (center.intersectsLine(b))
				intersects++;
			if (center.intersectsLine(c))
				intersects++;
			if (intersects == 1)
				counter++;
		}
		System.out.println(counter);
	}

	private Point[][] readFile(String filePath) {
		ArrayList<String> strings = new ArrayList<String>();
		BufferedReader br = null;
		String lines;
		try {
			br = new BufferedReader(new FileReader(filePath));

			while ((lines = br.readLine()) != null) {
				strings.add(lines);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		Point[][] points = new Point[strings.size()][3];

		for (int i = 0; i < strings.size(); i++) {
			String[] strs = strings.get(i).split(",");
			for (int j = 0; j < 3; j++) {
				int x = Integer.parseInt(strs[j*2]);
				int y = Integer.parseInt(strs[j*2+1]);
				points[i][j] = new Point(x, y);
			}
		}
		return points;
	}
}