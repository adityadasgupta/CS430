package Sort;
import Sort.Sorting;
import java.util.Random;
import java.util.Scanner;
public class main {

	public static void main(String[] args) {
		//Sorting s = new Sorting();
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		int sz; //size of array
		System.out.println("Enter the size of the array b [min 100] ");
		sz = sc.nextInt();
		int[] a1 = new int[sz];
		int[] a2 = new int[sz];
		for (int i=0;i<sz;i++) {
			int rand = r.nextInt(100);
			a1[i] = rand;
			a2[i] = rand;
		}
		// print the array
		System.out.println("Here's a random array: ");
		for (int i = 0; i<sz; i++) {
			System.out.println(a2[i]);
		}
		
		Sorting sort = new Sorting();
		sort.InsertSort(a1);
		
		System.out.println("Here's the sorted array using Insertion Sort : ");
		for (int i = 0; i<sz; i++) {
			System.out.println("\t" + a1[i]);
		}
		
		System.out.println("Here's the same random array: ");
		for (int i = 0; i<sz; i++) {
			System.out.println(a2[i]);
		}
		
		sort.mergeSort(a2, 0, a2.length-1);
		
		System.out.println("Here's the same sorted array using Merge Sort : ");
		for (int i = 0; i<sz; i++) {
			System.out.println("\t" + a2[i]);
		}
		

	}

}
