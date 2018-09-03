package practice.acm;

import java.util.ArrayList;
import java.util.List;

import javafx.util.Pair;

/**
* Read more about shoe-lace formula, https://en.wikipedia.org/wiki/Shoelace_formula
*
* @problem : https://helloacm.com/how-to-find-largest-triangle-area-using-shoelace-formula/
* @author  : swayam raina
* @type    : math
*
*/
public class AreoOfPolynomial {

	public static void main(String args[]) {
		List<Pair<Integer, Integer>> points = new ArrayList<>();
		points.add(new Pair<Integer, Integer>(3,4));
		points.add(new Pair<Integer, Integer>(5,11));
		points.add(new Pair<Integer, Integer>(12,8));
		points.add(new Pair<Integer, Integer>(9,5));
		points.add(new Pair<Integer, Integer>(5,6));
		System.out.println(getArea(points));
	}
	
	private static float getArea(List<Pair<Integer, Integer>> points) {
		int add = 0, sub = 0;
		int N = points.size();
		for (int i=0; i<N; i++) {
			add += points.get(i).getKey() * points.get((i+1)%N).getValue();
		}
		for (int i=0; i<N; i++) {
			sub -= points.get(i).getValue() * points.get((i+1)%N).getKey();
		}
		return Math.abs(add+sub)/2;
	}
	
}
