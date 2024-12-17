package com.app.dsa.binary_search_space;

public class BinarySearchOnSpaceMain {
	public static void main(String[] args) {
		BookAllocation solver = new BookAllocation();
		int[] books = {12, 34, 67, 90};
		int students = 2;
		System.out.println("Minimum pages: " + solver.solve(books, students));
	}
	//    public static void main(String[] args) {
	//         BookAllocation solver = new BookAllocation();
	//         int[] books = {10, 20, 30, 40};
	//         int students = 2;
	//         System.out.println("Minimum pages: " + solver.solve(books, students));
	//     }
}
