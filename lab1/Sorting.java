package Sort;
/**
 *
 */

/**
 * @author adi
 *
 */
public class Sorting {
	private int count;
	boolean sorted = false;
	boolean shuffled = true;
	public Sorting() {
		count = 0;
	}
	int getCount() {
		return count;
	}

	public void InsertSort(int[] arr) { //the insertion sort method
		for(int j = 1; j<arr.length;j++) {
			int key = arr[j]; //making the jth element the key
			int i = j-1;
			while (i>=0 && arr[i]>key) {
				System.out.println("Comparing " + arr[i+1] + " to " + arr[i] );
				arr[i+1] = arr[i]; //compares the elements
				i--;
			}
		arr[i+1] = key; //a different element is made the key for the next iteration
		}
		shuffled = false;
		sorted = true;
		//return arr;
	}

	public static void merge(int[] arr, int l, int m, int r) {
	    int i, j, k;
	    int n1 = m - l + 1;
	    int n2 =  r - m;
	    /* create temporary arrays */
	    int[] L, R;
	    L = new int[n1];
	    R = new int[n2];
	    /* Copy data to temp arrays L[] and R[] */
	    for (i = 0; i < n1; i++) {
	        L[i] = (int) arr[l + i];
	    }
	    for (j = 0; j < n2; j++) {
	        R[j] = (int)arr[m + 1+ j];
	    }
	    /* Merge the temp arrays back into arr[l..r]*/
	    i = 0; // Initial index of first subarray
	    j = 0; // Initial index of second subarray
	    k = l; // Initial index of merged subarray
	    while (i < n1 && j < n2) { //comparing both the smaller arrays to put elements into the bigger array
	        if (L[i] <= R[j]) {
	            arr[k] = L[i]; //putting elements from left subarray into bigger array
	            i++;
	        } else{
	            arr[k] = R[j]; //putting elements from right subarray into bigger array
	            j++;
	        }
	        k++;
	    }

	    /* Copy the remaining elements of L[], if there
	       are any */
	    while (i < n1) {
	    	arr[k] = L[i];
	        i++;
	        k++;
	    }

	    /* Copy the remaining elements of R[], if there
	       are any */
	    while (j < n2){
	        arr[k] = R[j];
	        j++;
	        k++;
	    }
	    shuffled = false;
	    sorted = true;

	}
	  //the arrays are now merged into one array after sorting (at the end of merge)

	/* l is for left index and r is right index of the
	   sub-array of arr to be sorted */
	public void mergeSort(int[] arr, int l, int r) {
	    if (l < r) {
	        // Same as (l+r)/2, but avoids overflow for
	        // large l and h
	        int m = l+(r-l)/2;

	        // Sort first and second halves
	        count++;
	        mergeSort(arr, l, m);
	        count++;
	        mergeSort(arr, m+1, r);
	        count++;
	        merge(arr, l, m, r);
	    }
	}
	public void createList() {
		list = new int[len];	//CREATES A LIST EQUAL TO THE LENGTH
		for(int i = 0; i < len; i++) {	//FILLS THE LIST FROM 1-LEN
			list[i] = i+1;
		}
	}

	public void shuffleList() {
		createList();
		for(int a = 0; a < 500; a++) {	//SHUFFLE RUNS 500 TIMES
			for(int i = 0; i < len; i++) {	//ACCESS EACH ELEMENT OF THE LIST
				int rand = r.nextInt(len);	//PICK A RANDOM NUM FROM 0-LEN
				int temp = list[i];			//SETS TEMP INT TO CURRENT ELEMENT
				list[i] = list[rand];		//SWAPS THE CURRENT INDEX WITH RANDOM INDEX
				list[rand] = temp;			//SETS THE RANDOM INDEX TO THE TEMP
			}
		}
		sorted = false;
		shuffled = true;
	}
}
