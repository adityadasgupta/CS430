public void countSort(int n, int exp) {
	int output[] = new int[n];	//OUTPUT SORTED LIST
	int i;
	int count[] = new int[10];  //THE INDEX ARRAY
	Arrays.fill(count, 0);
	
	for(i = 0; i < n; i++)	{
		count[(list[i]/exp)%10]++;	acc5++;  //STORE THE COUNT OF EACH ELEMENT IN LIST
	}
	
	for(i = 1; i < 10; i++) {
		count[i] += count[i - 1];  //count[i] NOW STORES ACTUAL POSITIONS OF ELEMENTS IN OUTPUT ARRAY
	}
	
	for(i = n -1; i >= 0; i--) {
		output[count[(list[i] / exp) % 10] - 1] = list[i];	acc5++;  //BUILDING THE OUTPUT ARRAY
		count[(list[i] / exp) % 10]--;	acc5++;
	}
	for(i = 0; i < n; i++) {
		if(!sorting)
			break;
		check = i;
		list[i] = output[i];	acc5++;  //SET THE SORTED LIST TO THE ORIGINAL LIST
		Update5();
		delay();
	}
}

public void radixSort(int n) {
	int m = getMax(n);
	 for(int exp = 1; m/exp > 0; exp *= 10) {	//USES EACH DIGIT TO RUN COUNTSORT ON UNTIL WE RUN OUT OF DIGITS
	 	if(!sorting)
	 		break;
		//countSort(n,exp);
		int output[] = new int[n];	//OUTPUT SORTED LIST
		int i;
		int count[] = new int[10];  //THE INDEX ARRAY
		Arrays.fill(count, 0);
		
		for(i = 0; i < n; i++)	{
			count[(list[i]/exp)%10]++;	acc6++;  //STORE THE COUNT OF EACH ELEMENT IN LIST
		}
		
		for(i = 1; i < 10; i++) {
			count[i] += count[i - 1];  //count[i] NOW STORES ACTUAL POSITIONS OF ELEMENTS IN OUTPUT ARRAY
		}
		
		for(i = n -1; i >= 0; i--) {
			output[count[(list[i] / exp) % 10] - 1] = list[i];	acc6++;  //BUILDING THE OUTPUT ARRAY
			count[(list[i] / exp) % 10]--;	acc6++;
		}
		for(i = 0; i < n; i++) {
			if(!sorting)
				break;
			check = i;
			list[i] = output[i];	acc6++;  //SET THE SORTED LIST TO THE ORIGINAL LIST
			Update6();
			delay();
		}
		Update6();
		delay();
	 }
}
