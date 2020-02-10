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
	public Sorting() {
		count = 0;
	}
	int getCount() {
		return count;
	}
	
	public void InsertSort(int[] arr) {
		for(int j = 1; j<arr.length;j++) {
			int key = arr[j];
			int i = j-1;
			while (i>=0 && arr[i]>key) {
				System.out.println("Comparing " + arr[i+1] + " to " + arr[i] );
				arr[i+1] = arr[i];
				i--;
			}
		arr[i+1] = key;
		}
		//return arr;
	}
	/*
	public void MergeSort(int[] arr, int l,int r) {
		if(l<r) {		//if left index greater than right index
			int mid = l+(r-l)/2;	//middle index to split
			
			//recursion time
			MergeSort(arr, l, mid);
			MergeSort(arr, (mid+1), r);
			Merge(arr, l ,mid ,r);
		}
		
	}

	public void Merge(int[] arr, int l,int mid,int r) {
		int n1 = mid-l+1; 
		int n2 = r-mid;
		
		int[] L,R; //temporary arrays of size n1 and n2;
		L = new int[n1];
		R = new int[n2];
		
		//initiating the L and R subarrays with values
		for (int i = 0; i < n1; i++) {
			L[i] = (int)arr[l+i];
		}
		for (int j = 0; j < n2; j++) {
			R[j] = (int)arr[mid+j];
		}
		
		//comparing elements from the two subarrays one by one and repopulating main array with sorted values
		int i = 0,j = 0,k = 0; 
		
		while ((i < n1) && (j < n2)) {
			if(L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			}
			else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}
		
		//possibility: elements still remaining in either L or/and R.
		
		while(i < n1) {
			arr[k] = L[i];
			i++;k++;
		}
		
		while(j< n2) {
			arr[k] = R[j];
			j++;k++;
		}
		
		
	}*/
	
	public static void merge(int[] arr, int l, int m, int r) { 
	    int i, j, k; 
	    int n1 = m - l + 1; 
	    int n2 =  r - m; 
	    /* create temp arrays */
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
	    while (i < n1 && j < n2) { 
	        if (L[i] <= R[j]) { 
	            arr[k] = L[i]; 
	            i++; 
	        } else{ 
	            arr[k] = R[j]; 
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
	  
	} 
	  
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
}
