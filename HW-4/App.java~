//TEAM NAME = NULL
//TEAM MEMBERS = ADITYA DASGUPTA(seat 14) AND DEVYANI GAURI(seat 25)
//HW-4

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Arrays;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JTextPane;
import javax.swing.border.CompoundBorder;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

public class App {
	//FRAME
	private JFrame jf;
	private int len = 100;
	private int off = 0;
	private int curAlg = 0;
	private int spd = 15;
	private int compare = 0;
	private int compare2 = 0;
	private int compare3 = 0;
	private int compare4 = 0;
	private int compare5 = 0;
	private int compare6 = 0;
	private int acc = 0;
	private int acc2 = 0;
	private int acc3 = 0;
	private int acc4 = 0;
	private int acc5 = 0;
	private int acc6 = 0;
	private long timeEl = 0 ;
	//GRAPH VARIABLES
	private final int SIZE = 320;
	private int current = -1;
	private int check = -1;
	private int width = SIZE/len;
	private int type = 0;
	//ARRAYS
	private int[] list;
	private int[] list2;
	private int[] list3;
	private int[] list4;
	private int[] list5;
	private int[] list6;

	//list2 = list;
	private String[] types = {"Bar Graph"};
	private String[] algorithms = { "Insertion Sort",
								    "Merge Sort",
								    "Heap Sort",
								    "Quick Sort",
									"Counting Sort",
									"Radix Sort",
								    "All"};
	private String[] algInfo = {"Best Case: O (n)\nWorst Case: O (n^2)\nAverage: O (n^2)",
								"Best Case: O (nlogn)\nWorst Case: O (nlogn)\nAverage: O (nlogn)",
								"Left is Insert Sort\nRight is Merge Sort "
								};
	private String[] algNameIns = {"Insertion Sort",
									"Merge Sort",
									"Heap Sort",
									"Quick Sort",
									"Counting Sort",
									"Radix Sort",
									"Insertion Sort"
								  };
	private String[] algNameMerge = {"Insertion Sort",
									 "Merge Sort",
									 "Heap Sort",
									 "Quick Sort",
									 "Counting Sort",
									 "Radix Sort",
									 "Merge Sort"
									};
	private String[] algNameHeap = {"Insertion Sort",
			                        "Merge Sort",
			                        "Heap Sort",
			                        "Quick Sort",
			                        "Counting Sort",
									"Radix Sort",
			                        "Heap Sort"
			                       };
	private String[] algNameQuick = {"Insertion Sort",
                                     "Merge Sort",
                                     "Heap Sort",
                                     "Quick Sort",
                                     "Counting Sort",
									 "Radix Sort",
                                     "Quick Sort"
                                     };

	private String[] algNameCount = {"Insertion Sort",
                                     "Merge Sort",
                                     "Heap Sort",
                                     "Quick Sort",
                                     "Counting Sort",
									 "Radix Sort",
                                     "Counting Sort"
                                     };

	private String[] algNameRadix = {"Insertion Sort",
                                     "Merge Sort",
                                     "Heap Sort",
                                     "Quick Sort",
                                     "Counting Sort",
									 "Radix Sort",
                                     "Radix Sort"
                                     };

	Font f = new Font("Raleway", Font.BOLD,20);
	//BOOLEANS
	private boolean sorting = false;
	private boolean shuffled = true;
	//UTIL OBJECTS
	SortingAlgorithms algorithm1 = new SortingAlgorithms();
	SortingAlgorithms2 algorithm2 = new SortingAlgorithms2();
	SortingAlgorithms3 algorithm3 = new SortingAlgorithms3();
	SortingAlgorithms4 algorithm4 = new SortingAlgorithms4();
  SortingAlgorithms5 algorithm5 = new SortingAlgorithms5();
  SortingAlgorithms6 algorithm6 = new SortingAlgorithms6();

	Random r = new Random();
	//PANELS
	JPanel tools = new JPanel();
	GraphCanvas canvas;
	GraphCanvas2 canvas2;
	GraphCanvas3 canvas3;
	GraphCanvas4 canvas4;
	GraphCanvas5 canvas5;
	GraphCanvas6 canvas6;

	//LABELS
	JLabel msL = new JLabel(spd+" ms");
	JLabel sizeL = new JLabel("Size :");
	JLabel lenL = new JLabel(len+"");
	JLabel compareL = new JLabel("Comparisons(Graph 1) : " + compare);
	JLabel compareL2 = new JLabel("Comparisons(Graph 2) : " + compare2);
	JLabel compareL3 = new JLabel("Comparisons(Graph 3) : " + compare3);
	JLabel compareL4 = new JLabel("Comparisons(Graph 4) : " + compare4);
	JLabel compareL5 = new JLabel("Comparisons(Graph 5) : " + compare5);
	JLabel compareL6 = new JLabel("Comparisons(Graph 6) : " + compare6);
	JLabel accessL = new JLabel("Array Accesses(Graph 1) : " + acc);
	JLabel accessL2 = new JLabel("Array Accesses(Graph 2) : " + acc2);
	JLabel accessL3 = new JLabel("Array Accesses(Graph 3) : " + acc3);
	JLabel accessL4 = new JLabel("Array Accesses(Graph 4) : " + acc4);
	JLabel accessL5 = new JLabel("Array Accesses(Graph 5) : " + acc5);
	JLabel accessL6 = new JLabel("Array Accesses(Graph 6) : " + acc6);

	JLabel algorithmL = new JLabel("Algorithms");
	//DROP DOWN BOX
	JComboBox alg = new JComboBox(algorithms);
	JComboBox graph = new JComboBox(types);
	//TEXT AREA
	JTextArea information = new JTextArea(algInfo[curAlg]);
	JTextArea algIns = new JTextArea(algNameIns[curAlg]);
	JTextArea algMerge = new JTextArea(algNameMerge[curAlg]);
	JTextArea algHeap = new JTextArea(algNameHeap[curAlg]);
	JTextArea algQuick = new JTextArea(algNameQuick[curAlg]);
    JTextArea algCount = new JTextArea(algNameCount[curAlg]);
    JTextArea algRadix = new JTextArea(algNameRadix[curAlg]);
	JTextArea timeElapsed = new JTextArea("Time Elapsed : " + timeEl + " units");
	//BUTTONS
	JButton sort = new JButton("Sort");
	JButton shuffle = new JButton("Shuffle");
	//SLIDERS
	JSlider size = new JSlider(JSlider.HORIZONTAL,1,6,1);
	JSlider speed = new JSlider(JSlider.HORIZONTAL,0,100,spd);
	//BORDER STYLE
	Border loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
	//CONSTRUCTOR
	public App() {
		shuffleList();	//CREATE THE LIST
		initialize();	//INITIALIZE THE GUI
	}

	public void createList() {
		list = new int[len];
		list2 = new int[len];//CREATES TWO LISTS EQUAL TO THE LENGTH
		list3 = new int[len];
		list4 = new int[len];
		list5 = new int[len];
		list6 = new int[len];
		for(int i = 0; i < len; i++) {	//FILLS THE LIST FROM 1-LEN
			list[i] = i+1;
			list2[i] = i+1;
			list3[i] = i+1;
			list4[i] = i+1;
			list5[i] = i+1;
			list6[i] = i+1;
		}

	}

	public void shuffleList() {
		createList();
		for(int a = 0; a < 500; a++) {	//SHUFFLE RUNS 500 TIMES
			for(int i = 0; i < len; i++) {	//ACCESS EACH ELEMENT OF THE LIST
				int rand = r.nextInt(len);	//PICK A RANDOM NUM FROM 0-LEN
				int temp = list[i];
				int temp2 = list[i];//SETS TEMP INT TO CURRENT ELEMENT
				int temp3 = list[i];
				int temp4 = list[i];
				int temp5 = list[i];
				int temp6 = list[i];
				list[i] = list[rand];		//SWAPS THE CURRENT INDEX WITH RANDOM INDEX
				list[rand] = temp;
				list2[i] = list2[rand];
				list2[rand] = temp2;//SETS THE RANDOM INDEX TO THE TEMP
				list3[i] = list3[rand];
				list3[rand] = temp3;//SETS THE RANDOM INDEX TO THE TEMP
				list4[i] = list4[rand];
				list4[rand] = temp4;//SETS THE RANDOM INDEX TO THE TEMP
				list5[i] = list5[rand];
				list5[rand] = temp5;//SETS THE RANDOM INDEX TO THE TEMP
				list6[i] = list6[rand];
				list6[rand] = temp6;//SETS THE RANDOM INDEX TO THE TEMP
			}
		}
		sorting = false;
		shuffled = true;
	}

	public void initialize() {
		//SET UP FRAME
		jf = new JFrame();
		jf.setSize(1400,1400);
		jf.setTitle("Team NULL Sort Visualizer");
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setResizable(false);
		jf.setLocationRelativeTo(null);
        jf.getContentPane().setLayout(null);


		//SET UP TOOLBAR
		tools.setLayout(null);
        tools.setBounds(12,680,1600,500);
        tools.setBackground(Color.decode("#beebea"));
		tools.setBorder(new CompoundBorder());

		//SET UP GRAPH 1 NAME
	    algIns.setBounds(30,10,230,30);
	    algIns.setBackground(Color.decode("#ffffff"));
	    algIns.setBorder(loweredetched);
	    algIns.setForeground(Color.decode("#03DAC5"));
	    algIns.setFont(f);
	    algIns.setEditable(false);
		tools.add(algIns);

		//SET UP GRAPH 2 NAME
	    algMerge.setBounds(460,10,230,30);
	    algMerge.setBackground(Color.decode("#ffffff"));
	    algMerge.setBorder(loweredetched);
	    algMerge.setForeground(Color.decode("#da4703"));
	    algMerge.setFont(f);
	    algMerge.setEditable(false);
		tools.add(algMerge);

		//SET UP GRAPH 3 NAME
		algHeap.setBounds(900,10,230,30);
	    algHeap.setBackground(Color.decode("#ffffff"));
	    algHeap.setBorder(loweredetched);
	    algHeap.setForeground(Color.decode("#fcba03"));
	    algHeap.setFont(f);
	    algHeap.setEditable(false);
		tools.add(algHeap);

		//SET UP GRAPH 4 NAME
		algQuick.setBounds(30,40,230,30);
	  algQuick.setBackground(Color.decode("#ffffff"));
		algQuick.setBorder(loweredetched);
		algQuick.setForeground(Color.decode("#ce03fc"));
		algQuick.setFont(f);
		algQuick.setEditable(false);
		tools.add(algQuick);

   //SET UP GRAPH 5 NAME
		algCount.setBounds(460,40,230,30);
	    algCount.setBackground(Color.decode("#ffffff"));
		algCount.setBorder(loweredetched);
		algCount.setForeground(Color.decode("#5c97f7"));
		algCount.setFont(f);
		algCount.setEditable(false);
		tools.add(algCount);

    //SET UP GRAPH 6 NAME
		algRadix.setBounds(900,40,230,30);
		algRadix.setBackground(Color.decode("#ffffff"));
		algRadix.setBorder(loweredetched);
		algRadix.setForeground(Color.decode("#90f75c"));
		algRadix.setFont(f);
		algRadix.setEditable(false);
		tools.add(algRadix);

		//SET UP ALGORITHM LABEL
		algorithmL.setHorizontalAlignment(JLabel.CENTER);
		algorithmL.setBounds(20,70,170,30);
		algorithmL.setFont(new Font("Raleway", Font.BOLD, 25));
		tools.add(algorithmL);

		//SET UP DROP DOWN
        alg.setBounds(30,110,170,30);
        alg.setBackground(Color.decode("#ffffff"));
        alg.setFont(f);
		tools.add(alg);

		//SET UP SORT BUTTON
        sort.setBounds(220,110,120,30);
        sort.setBackground(Color.decode("#ffffff"));
        sort.setFont(f);
		tools.add(sort);

		//SET UP SHUFFLE BUTTON
        shuffle.setBounds(350,110,120,30);
        shuffle.setFont(f);
        shuffle.setBackground(Color.decode("#ffffff"));
		tools.add(shuffle);

		//SET UP MS LABEL
		msL.setHorizontalAlignment(JLabel.LEFT);
        msL.setBounds(30,150,70,25);
        msL.setFont(f);
        msL.setBackground(Color.decode("#beebea"));
		tools.add(msL);

		//SET UP SPEED SLIDER
		speed.setMajorTickSpacing(5);
		speed.setBounds(90,150,100,30);
        speed.setPaintTicks(false);
        speed.setBackground(Color.decode("#beebea"));
		tools.add(speed);

		/*//SET UP SIZE LABEL
		sizeL.setHorizontalAlignment(JLabel.LEFT);
        sizeL.setBounds(30,180,100,25);
        sizeL.setFont(f);
        sizeL.setBackground(Color.decode("#beebea"));
		tools.add(sizeL);*/

		/*//SET UP LEN LABEL
		lenL.setHorizontalAlignment(JLabel.LEFT);
        lenL.setBounds(190,180,50,25);
        lenL.setBackground(Color.decode("#beebea"));
		tools.add(lenL);*/

		/*//SET UP SIZE SLIDER
		size.setMajorTickSpacing(50);
		size.setBounds(92,180,100,30);
        size.setPaintTicks(false);
        size.setBackground(Color.decode("#beebea"));
		tools.add(size);*/

		//SET UP COMPARISONS LABEL FOR 1ST GRAPH
    compareL.setHorizontalAlignment(JLabel.LEFT);
    compareL.setBackground(Color.decode("#beebea"));
		compareL.setBounds(720,100,500,25);
		compareL.setFont(f);
		tools.add(compareL);

		//SET UP COMPARISONS LABEL FOR 2ND GRAPH
		compareL2.setHorizontalAlignment(JLabel.LEFT);
	  compareL2.setBackground(Color.decode("#beebea"));
		compareL2.setBounds(1020,100,500,25);
		compareL2.setFont(f);
		tools.add(compareL2);

		//SET UP COMPARISONS LABEL FOR 3RD GRAPH
		compareL3.setHorizontalAlignment(JLabel.LEFT);
	  compareL3.setBackground(Color.decode("#beebea"));
		compareL3.setBounds(720,165,500,25);
		compareL3.setFont(f);
		tools.add(compareL3);

		//SET UP COMPARISONS LABEL FOR 4TH GRAPH
		compareL4.setHorizontalAlignment(JLabel.LEFT);
		compareL4.setBackground(Color.decode("#beebea"));
		compareL4.setBounds(1020,165,500,25);
		compareL4.setFont(f);
		tools.add(compareL4);

		//SET UP COMPARISONS LABEL FOR 5TH GRAPH
		compareL5.setHorizontalAlignment(JLabel.LEFT);
		compareL5.setBackground(Color.decode("#beebea"));
		compareL5.setBounds(720,225,500,25);
		compareL5.setFont(f);
		tools.add(compareL5);

		//SET UP COMPARISONS LABEL FOR 6TH GRAPH
		compareL6.setHorizontalAlignment(JLabel.LEFT);
		compareL6.setBackground(Color.decode("#beebea"));
		compareL6.setBounds(1020,225,500,25);
		compareL6.setFont(f);
		tools.add(compareL6);

		//SET UP ARRAY ACCESS LABEL FOR 1ST GRAPH
    accessL.setHorizontalAlignment(JLabel.LEFT);
    accessL.setBackground(Color.decode("#beebea"));
		accessL.setBounds(720,130,500,25);
		accessL.setFont(f);
		tools.add(accessL);

		//SET UP ARRAY ACCESS LABEL FOR 2ND GRAPH
    accessL2.setHorizontalAlignment(JLabel.LEFT);
    accessL2.setBackground(Color.decode("#beebea"));
		accessL2.setBounds(1020,130,500,25);
		accessL2.setFont(f);
		tools.add(accessL2);

		//SET UP ARRAY ACCESS LABEL FOR 3RD GRAPH
    accessL3.setHorizontalAlignment(JLabel.LEFT);
    accessL3.setBackground(Color.decode("#beebea"));
		accessL3.setBounds(720,190,500,25);
		accessL3.setFont(f);
		tools.add(accessL3);

		//SET UP ARRAY ACCESS LABEL FOR 4TH GRAPH
    accessL4.setHorizontalAlignment(JLabel.LEFT);
    accessL4.setBackground(Color.decode("#beebea"));
		accessL4.setBounds(1020,190,500,25);
		accessL4.setFont(f);
		tools.add(accessL4);

		//SET UP ARRAY ACCESS LABEL FOR 4TH GRAPH
	    accessL5.setHorizontalAlignment(JLabel.LEFT);
	    accessL5.setBackground(Color.decode("#beebea"));
			accessL5.setBounds(720,250,500,25);
			accessL5.setFont(f);
			tools.add(accessL5);

			//SET UP ARRAY ACCESS LABEL FOR 4TH GRAPH
		    accessL6.setHorizontalAlignment(JLabel.LEFT);
		    accessL6.setBackground(Color.decode("#beebea"));
				accessL6.setBounds(1020,250,500,25);
				accessL6.setFont(f);
				tools.add(accessL6);

/*		//SET UP INFO AREA
        information.setBounds(720,170,230,90);
        information.setBackground(Color.decode("#ffffff"));
        information.setFont(f);
		information.setEditable(false);
		tools.add(information);
*/

		//SET UP CANVAS FOR FIRST GRAPH
		canvas = new GraphCanvas();
		canvas.setBounds(30,10,SIZE+100,SIZE);
		canvas.setBorder(BorderFactory.createLineBorder(Color.black));
		jf.getContentPane().add(tools);
		jf.getContentPane().add(canvas);


		//SET UP CANVAS FOR SECOND GRAPH
		canvas2 = new GraphCanvas2();
		canvas2.setBounds(470,10,SIZE+100,SIZE);
		canvas2.setBorder(BorderFactory.createLineBorder(Color.black));
		jf.getContentPane().add(tools);
		jf.getContentPane().add(canvas2);
		//JTextPane textPane = new JTextPane();

		//SET UP CANVAS FOR THIRD GRAPH
		canvas3 = new GraphCanvas3();
		canvas3.setBounds(910,10,SIZE+100,SIZE);
		canvas3.setBorder(BorderFactory.createLineBorder(Color.black));
		jf.getContentPane().add(tools);
		jf.getContentPane().add(canvas3);

		//SET UP CANVAS FOR FOURTH GRAPH
		canvas4 = new GraphCanvas4();
		canvas4.setBounds(30,SIZE+20,SIZE+100,SIZE);
		canvas4.setBorder(BorderFactory.createLineBorder(Color.black));
		jf.getContentPane().add(tools);
		jf.getContentPane().add(canvas4);

		//SET UP CANVAS FOR FIFTH GRAPH
		canvas5 = new GraphCanvas5();
		canvas5.setBounds(470,SIZE+20,SIZE+100,SIZE);
		canvas5.setBorder(BorderFactory.createLineBorder(Color.black));
		jf.getContentPane().add(tools);
		jf.getContentPane().add(canvas5);

		//SET UP CANVAS FOR FOURTH GRAPH
		canvas6 = new GraphCanvas6();
		canvas6.setBounds(910,SIZE+20,SIZE+100,SIZE);
		canvas6.setBorder(BorderFactory.createLineBorder(Color.black));
		jf.getContentPane().add(tools);
		jf.getContentPane().add(canvas6);

		//ADD ACTION LISTENERS
		//This action listener sets the text of "information" based on what sorting algorithm we choose
		alg.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				curAlg = alg.getSelectedIndex();
				information.setText(algInfo[curAlg]);
			}

		});

		//This action listener sets the text of the name of Graph 1 based on what sorting algorithm we choose
		alg.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				curAlg = alg.getSelectedIndex();
				algIns.setText(algNameIns[curAlg]);
			}

		});

		//This action listener sets the text of the name of Graph 2 based on what sorting algorithm we choose
		alg.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				curAlg = alg.getSelectedIndex();
				algMerge.setText(algNameMerge[curAlg]);
			}

		});
		//This action listener sets the text of the name of Graph 3 based on what sorting algorithm we choose
		alg.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				curAlg = alg.getSelectedIndex();
				algHeap.setText(algNameHeap[curAlg]);
			}

		});
		//This action listener sets the text of the name of Graph 4 based on what sorting algorithm we choose
		alg.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				curAlg = alg.getSelectedIndex();
				algQuick.setText(algNameQuick[curAlg]);
			}

		});

		//This action listener sets the text of the name of Graph 5 based on what sorting algorithm we choose
		alg.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				curAlg = alg.getSelectedIndex();
				algCount.setText(algNameCount[curAlg]);
			}

		});

		//This action listener sets the text of the name of Graph 6 based on what sorting algorithm we choose
		alg.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				curAlg = alg.getSelectedIndex();
				algRadix.setText(algNameRadix[curAlg]);
			}

		});
		// This action listener sets the number of comparisons and access to 0 if we just created a new random list
		sort.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(shuffled) {
					sorting = true;
					compare = 0;
					compare2 = 0;
					compare3 = 0;
					compare4 = 0;
					compare5 = 0;
					compare6 = 0;
					acc = 0;
					acc2 = 0;
					acc3 = 0;
					acc4 = 0;
					acc5 = 0;
					acc6 = 0;
					//timeEl = 0;

				}

			}
		});

		//This action listener shuffles the list
		shuffle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				shuffleList();
				reset();
			}
		});

		//This action listener sets up and changes the speed slider and its values
		speed.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				spd = (int)speed.getValue();
				msL.setText(spd+" ms");
			}
		});

		//This action listener sets up and changes the size slider and its values
		size.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				int val = size.getValue();
				if(size.getValue() == 3 || size.getValue() == 4 || size.getValue() == 5|| size.getValue() == 6)
					val = 3;
				len = val * 100;
				lenL.setText(len+"");
				if(list.length != len)
					shuffleList();
				reset();
			}

		});

		sorting();
	}

	//SORTING STATE
	public void sorting() {
		if(sorting) {
			try {
				switch(curAlg) {	//CURRENT ALGORITHM IS EXECUTED
					case 0:
						algorithm1.insertionSort(0, len-1);
						algorithm2.insertionSort2(0, len-1);
						algorithm3.insertionSort3(0, len-1);
						algorithm4.insertionSort4(0, len-1);
						algorithm5.insertionSort5(0, len-1);
						algorithm6.insertionSort6(0, len-1);
						break;
					case 1:
						algorithm1.mergeSort(0, len-1);
						algorithm2.mergeSort2(0, len-1);
						algorithm3.mergeSort3(0, len-1);
						algorithm4.mergeSort4(0, len-1);
						algorithm5.mergeSort5(0, len-1);
						algorithm6.mergeSort6(0, len-1);
						break;
					case 2:
						algorithm1.heapSort(0,len-1);
						algorithm2.heapSort2(0,len-1);
						algorithm3.heapSort3(0,len-1);
						algorithm4.heapSort4(0,len-1);
						algorithm5.heapSort5(0, len-1);
						algorithm6.heapSort6(0, len-1);
						break;
					case 3:
						algorithm1.quickSort(0,len-1);
						algorithm2.quickSort2(0,len-1);
						algorithm3.quickSort3(0,len-1);
						algorithm4.quickSort4(0,len-1);
						algorithm5.quickSort5(0,len-1);
						algorithm6.quickSort6(0,len-1);
						break;
					case 4:
						algorithm1.countSort(0,len-1);
						algorithm2.countSort2(0,len-1);
						algorithm3.countSort3(0,len-1);
						algorithm4.countSort4(0,len-1);
						algorithm5.countSort5(0,len-1);
						algorithm6.countSort6(0,len-1);
						break;
					case 5:
						algorithm1.radixSort(len-1);
						algorithm2.radixSort2(len-1);
						algorithm3.radixSort3(len-1);
						algorithm4.radixSort4(len-1);
						algorithm5.radixSort5(len-1);
						algorithm6.radixSort6(len-1);
						break;
					case 6:
						algorithm1.insertionSort(0,len-1);
						algorithm2.mergeSort2(0,len-1);
						algorithm3.heapSort3(0,len-1);
						algorithm4.quickSort4(0,len-1);
						algorithm5.countSort5(0,len-1);
						algorithm6.radixSort6(len-1);
						break;


				}
			} catch(IndexOutOfBoundsException e) {}	//EXCEPTION HANDLER INCASE LIST ACCESS IS OUT OF BOUNDS
		}
		reset();	//RESET
		pause();	//GO INTO PAUSE STATE
	}

	//PAUSE STATE
	public void pause() {
		int i = 0;
		while(!sorting) {	//LOOP RUNS UNTIL SORTING STARTS
			i++;
			if(i > 100)
				i = 0;
			try {
				Thread.sleep(1);
			} catch(Exception e) {}
		}
		sorting();	//EXIT THE LOOP AND START SORTING
	}

	//RESET SOME VARIABLES
	public void reset() {
		sorting = false;
		current = -1;
		check = -1;
		off = 0;
		Update();
	}

	//DELAY METHOD
	public void delay() {
		try {
			Thread.sleep(spd);  //change spd to 10 ms constant. Is 15 by default.
		} catch(Exception e) {}
	}

	//UPDATES GRAPH 1  AND LABELS
	public void Update() {
		width = (int) ((SIZE/len)+ 1);
		canvas.repaint();
		canvas2.repaint();
		canvas3.repaint();
		canvas4.repaint();
		canvas5.repaint();
		canvas6.repaint();
		compareL.setText("Comparisons(Graph1) : " + compare);
		accessL.setText("Array Accesses(Graph 1) : " + acc);
		//timeElapsed.setText("Time Elapsed : " + timeEl + " units");
	}

	//UPDATES GRAPH 2  AND LABELS
	public void Update2() {
		width = (SIZE/len)+1;
		canvas.repaint();
		canvas2.repaint();
		canvas3.repaint();
		canvas4.repaint();
		canvas5.repaint();
		canvas6.repaint();
		compareL2.setText("Comparisons(Graph 2) : " + compare2);
		accessL2.setText("Array Accesses(Graph 2) : " + acc2);
		//timeElapsed.setText("Time Elapsed : " + timeEl + " units");
	}
	public void Update3() {
		width = (SIZE/len)+1;
		canvas.repaint();
		canvas2.repaint();
		canvas3.repaint();
		canvas4.repaint();
		canvas5.repaint();
		canvas6.repaint();
		compareL3.setText("Comparisons(Graph 3) : " + compare3);
		accessL3.setText("Array Accesses(Graph 3) : " + acc3);
		//timeElapsed.setText("Time Elapsed : " + timeEl + " units");
	}
	public void Update4() {
		width = (SIZE/len)+1;
		canvas.repaint();
		canvas2.repaint();
		canvas3.repaint();
		canvas4.repaint();
		canvas5.repaint();
		canvas6.repaint();
		compareL4.setText("Comparisons(Graph 4) : " + compare4);
		accessL4.setText("Array Accesses(Graph 4) : " + acc4);
		//timeElapsed.setText("Time Elapsed : " + timeEl + " units");
	}

	public void Update5() {
		width = (SIZE/len)+1;
		canvas.repaint();
		canvas2.repaint();
		canvas3.repaint();
		canvas4.repaint();
		canvas5.repaint();
		canvas6.repaint();
		compareL5.setText("Comparisons(Graph 5) : " + compare5);
		accessL5.setText("Array Accesses(Graph 5) : " + acc5);
		//timeElapsed.setText("Time Elapsed : " + timeEl + " units");
	}
	public void Update6() {
		width = (SIZE/len)+1;
		canvas.repaint();
		canvas2.repaint();
		canvas3.repaint();
		canvas4.repaint();
		canvas5.repaint();
		canvas6.repaint();
		compareL6.setText("Comparisons(Graph 6) : " + compare6);
		accessL6.setText("Array Accesses(Graph 6) : " + acc6);
		//timeElapsed.setText("Time Elapsed : " + timeEl + " units");
	}

	//MAIN METHOD
	public static void main(String[] args) {
		new App();
	}

	//SUB CLASS TO CONTROL GRAPH 1
	class GraphCanvas extends JPanel {

		public GraphCanvas() {
			setBackground(Color.white);
		}

		//PAINTS THE GRAPH
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			for(int i = 0; i < len; i++) {	//RUNS TROUGH EACH ELEMENT OF THE LIST
				int HEIGHT = (list[i]*width)-40;	//SETS THE HEIGHT OF THE ELEMENT ON THE GRAPH

					g.setColor(Color.decode("#03DAC5"));	//DEFAULT COLOR
					if(current > -1 && i == current) {
						g.setColor(Color.green);	//COLOR OF CURRENT
					}
					if(check > -1 && i == check) {
						g.setColor(Color.red);	//COLOR OF CHECKING
					}
					//DRAWS THE BAR AND THE BLACK OUTLINE
					g.fillRect(i*width, SIZE-HEIGHT, width, HEIGHT);
					g.setColor(Color.black);
					g.drawRect(i*width, SIZE-HEIGHT, width, HEIGHT);
			}
		}
	}
	//SUB CLASS TO CONTROL GRAPH 2
class GraphCanvas2 extends JPanel {

		public GraphCanvas2() {
			setBackground(Color.white);
		}

		//PAINTS THE GRAPH
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			for(int i = 0; i < len; i++) {	//RUNS TROUGH EACH ELEMENT OF THE LIST
				int HEIGHT = (list2[i]*width)-40;	//SETS THE HEIGHT OF THE ELEMENT ON THE GRAPH

					g.setColor(Color.decode("#da4703"));	//DEFAULT COLOR
					if(current > -1 && i == current) {
						g.setColor(Color.green);	//COLOR OF CURRENT
					}
					if(check > -1 && i == check) {
						g.setColor(Color.red);	//COLOR OF CHECKING
					}
					//DRAWS THE BAR AND THE BLACK OUTLINE
					g.fillRect(i*width, SIZE-HEIGHT, width, HEIGHT);
					g.setColor(Color.black);
					g.drawRect(i*width, SIZE-HEIGHT, width, HEIGHT);

			}
		}
	}
class GraphCanvas3 extends JPanel {

	public GraphCanvas3() {
		setBackground(Color.white);
	}

	//PAINTS THE GRAPH
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(int i = 0; i < len; i++) {	//RUNS TROUGH EACH ELEMENT OF THE LIST
			int HEIGHT = (list3[i]*width)-40;	//SETS THE HEIGHT OF THE ELEMENT ON THE GRAPH

				g.setColor(Color.decode("#fcba03"));	//DEFAULT COLOR
				if(current > -1 && i == current) {
					g.setColor(Color.green);	//COLOR OF CURRENT
				}
				if(check > -1 && i == check) {
					g.setColor(Color.red);	//COLOR OF CHECKING
				}
				//DRAWS THE BAR AND THE BLACK OUTLINE
				g.fillRect(i*width, SIZE-HEIGHT, width, HEIGHT);
				g.setColor(Color.black);
				g.drawRect(i*width, SIZE-HEIGHT, width, HEIGHT);

		}
	}
}

	class GraphCanvas4 extends JPanel {

		public GraphCanvas4() {
			setBackground(Color.white);
		}

		// PAINTS THE GRAPH
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			for (int i = 0; i < len; i++) { // RUNS TROUGH EACH ELEMENT OF THE LIST
				int HEIGHT = (list4[i] * width)-40; // SETS THE HEIGHT OF THE ELEMENT ON THE GRAPH

				g.setColor(Color.decode("#ce03fc")); // DEFAULT COLOR
				if (current > -1 && i == current) {
					g.setColor(Color.green); // COLOR OF CURRENT
				}
				if (check > -1 && i == check) {
					g.setColor(Color.red); // COLOR OF CHECKING
				}
				// DRAWS THE BAR AND THE BLACK OUTLINE
				g.fillRect(i * width, SIZE - HEIGHT, width, HEIGHT);
				g.setColor(Color.black);
				g.drawRect(i * width, SIZE - HEIGHT, width, HEIGHT);

			}
		}
	}

	class GraphCanvas5 extends JPanel {

		public GraphCanvas5() {
			setBackground(Color.white);
		}

		// PAINTS THE GRAPH
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			for (int i = 0; i < len; i++) { // RUNS TROUGH EACH ELEMENT OF THE LIST
				int HEIGHT = (list5[i] * width)-40; // SETS THE HEIGHT OF THE ELEMENT ON THE GRAPH

				g.setColor(Color.decode("#5c97f7")); // DEFAULT COLOR
				if (current > -1 && i == current) {
					g.setColor(Color.green); // COLOR OF CURRENT
				}
				if (check > -1 && i == check) {
					g.setColor(Color.red); // COLOR OF CHECKING
				}
				// DRAWS THE BAR AND THE BLACK OUTLINE
				g.fillRect(i * width, SIZE - HEIGHT, width, HEIGHT);
				g.setColor(Color.black);
				g.drawRect(i * width, SIZE - HEIGHT, width, HEIGHT);

			}
		}
	}

	class GraphCanvas6 extends JPanel {

		public GraphCanvas6() {
			setBackground(Color.white);
		}

		// PAINTS THE GRAPH
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			for (int i = 0; i < len; i++) { // RUNS TROUGH EACH ELEMENT OF THE LIST
				int HEIGHT = (list6[i] * width)-40; // SETS THE HEIGHT OF THE ELEMENT ON THE GRAPH

				g.setColor(Color.decode("#90f75c")); // DEFAULT COLOR
				if (current > -1 && i == current) {
					g.setColor(Color.green); // COLOR OF CURRENT
				}
				if (check > -1 && i == check) {
					g.setColor(Color.red); // COLOR OF CHECKING
				}
				// DRAWS THE BAR AND THE BLACK OUTLINE
				g.fillRect(i * width, SIZE - HEIGHT, width, HEIGHT);
				g.setColor(Color.black);
				g.drawRect(i * width, SIZE - HEIGHT, width, HEIGHT);

			}
		}
	}
	//SUB CLASS FOR ALGORITHMS
	class SortingAlgorithms {

		//insertion sort algorithm
		public void insertionSort(int start, int end) {
			//long startTime = Instant.now().toEpochMilli();
			for(int i = start+1; i <= end; i++) {
				current = i; //decides what element should be key
				int j = i;
				while(list[j] < list[j-1] && sorting) {
					swap(j,j-1); //this is where the sorting takes place
					check = j;
					compare++;	acc+=2; //this is how we set the comparison and array access numbers

					Update();
					delay();
					if(j > start+1)
						j--;
				}
			}
		}
		public void heapSort(int start, int end) {
			heapify(len);
			end = len-1;
			while(end > 0 && sorting) {
				current = end;
				swap(end,0);
				end--;
				siftDown(0,end);
				Update();
				delay();
			}
		}
		//heapify
		public void heapify(int n) {
			int start = iParent(n-1);
			while(start >= 0 && sorting) {
				siftDown(start, n-1);
				start--;
				Update();
				delay();
			}
		}
		//siftdown
		public void siftDown(int start, int end) {
			int root = start;
			while(iLeftChild(root) <= end && sorting) {
				int child = iLeftChild(root);
				int swap = root;
				check = root;
				if(list[swap] < list[child]) {
					swap = child;
				} if(child+1 <= end && list[swap] < list[child+1]) {
					swap = child+1;
				} if(swap == root) {
					return;
				} else {
					swap(root,swap);
					check = root;
					root = swap;
				}
				compare+=3;	acc+=4;
				Update();
				delay();
			}
		}
		public int iParent(int i) { return ((i-1)/2); } //parent of node in heap
		public int iLeftChild(int i) { return 2*i + 1; } //left child of a node

		//quicksort
		public void quickSort(int lo, int hi) {
			if(!sorting)
				return;
			current = hi;
			if(lo < hi) {
				int p = partition(lo,hi);
				quickSort(lo,p-1);
				quickSort(p+1, hi);
			}
		}

		//partition
		public int partition(int lo, int hi) {
			int pivot = list[hi];	acc++;
			int i = lo - 1;
			for(int j = lo; j < hi; j++) {
				check = j;
				if(!sorting)
					break;
				if(list[j] < pivot) {
					i++;
					swap(i,j);
				}
				compare++;	acc++;
				Update();
				delay();
			}
			swap(i+1,hi);
			Update();
			delay();
			return i+1;
		}


		void merge(int l, int m, int r)
	    {
	        int n1 = m - l + 1;
	        int n2 = r - m;
	        //the 2 subarrays
	        int L[] = new int [n1];
	        int R[] = new int [n2];

	        for (int i=0; i<n1; i++) {
	            L[i] = list[l + i];	acc++;
	        }
	        for (int j=0; j<n2; j++) {
	            R[j] = list[m + 1+ j];	acc++;
	        }
	        int i = 0, j = 0;

	        int k = l;
	        //merges the two subarrays into a big array
	        while (i < n1 && j < n2 && sorting) {
	        	check = k;
	            if (L[i] <= R[j]) {
	                list[k] = L[i];	acc++;
	                i++;
	            } else {
	                list[k] = R[j];	acc++;
	                j++;
	            }
	            compare++;
	            Update();
	            delay();
	            k++;
	        }

	        while (i < n1 && sorting) {
	            list[k] = L[i];	acc++;
	            i++;
	            k++;
	            Update();
	            delay();
	        }

	        while (j < n2 && sorting) {
	            list[k] = R[j];	acc++;
	            j++;
	            k++;
	            Update();
	            delay();
	        }
	    }

		//merge sort algorithm
	    public void mergeSort(int l, int r) {
	        if (l < r) {
	            int m = (l+r)/2;
	            current = r;
	            mergeSort(l, m);
	            mergeSort(m+1, r);

	            merge(l, m, r);
	        }
	    }
	    //this is where the sorting happens
		public void swap(int i1, int i2) {
			int temp = list[i1];	acc++;
			list[i1] = list[i2];	acc+=2;
			list[i2] = temp;	acc++;
		}


		public boolean checkSorted() {
			for(int i = 0; i < len-1; i++) {
				if(list[i] > list[i+1]) {	acc+=2;
					return false;
				}
			}
			return true;
		}
		public void countSort(int n, int exp) {
			int output[] = new int[n];	//OUTPUT SORTED LIST
			int i;
			int count[] = new int[10];  //THE INDEX ARRAY
			Arrays.fill(count, 0);

			for(i = 0; i < n; i++)	{
				count[(list[i]/exp)%10]++;	acc++;  //STORE THE COUNT OF EACH ELEMENT IN LIST
			}

			for(i = 1; i < 10; i++) {
				count[i] += count[i - 1];  //count[i] NOW STORES ACTUAL POSITIONS OF ELEMENTS IN OUTPUT ARRAY
			}

			for(i = n -1; i >= 0; i--) {
				output[count[(list[i] / exp) % 10] - 1] = list[i];	acc++;  //BUILDING THE OUTPUT ARRAY
				count[(list[i] / exp) % 10]--;	acc++;
			}
			for(i = 0; i < n; i++) {
				if(!sorting)
					break;
				check = i;
				list[i] = output[i];	acc++;  //SET THE SORTED LIST TO THE ORIGINAL LIST
				Update();
				delay();
			}
		}
		public int getMax(int n) {
			int mx = list[0];
			for(int i = 1; i < n; i++) {
				if(list[i] > mx)
					mx = list[i];
				compare++;	acc++;
			}
			return mx;
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
					count[(list[i]/exp)%10]++;	acc++;  //STORE THE COUNT OF EACH ELEMENT IN LIST
				}

				for(i = 1; i < 10; i++) {
					count[i] += count[i - 1];  //count[i] NOW STORES ACTUAL POSITIONS OF ELEMENTS IN OUTPUT ARRAY
				}

				for(i = n -1; i >= 0; i--) {
					output[count[(list[i] / exp) % 10] - 1] = list[i];	acc++;  //BUILDING THE OUTPUT ARRAY
					count[(list[i] / exp) % 10]--;	acc++;
				}
				for(i = 0; i < n; i++) {
					if(!sorting)
						break;
					check = i;
					list[i] = output[i];	acc++;  //SET THE SORTED LIST TO THE ORIGINAL LIST
					Update();
					delay();
				}
				Update();
				delay();
			 }
		}

	}

	class SortingAlgorithms2 {

		//insertion sort algorithm
		public void insertionSort2(int start, int end) {
			//long startTime = Instant.now().toEpochMilli();
			for(int i = start+1; i <= end; i++) {
				current = i; //decides what element should be key
				int j = i;
				while(list2[j] < list2[j-1] && sorting) {
					swap2(j,j-1); //this is where the sorting takes place
					check = j;
					compare2++;	acc2+=2; //this is how we set the comparison and array access numbers

					Update2();
					delay();
					if(j > start+1)
						j--;
				}
			}
		}
		public void heapSort2(int start, int end) {
			heapify2(len);
			end = len-1;
			while(end > 0 && sorting) {
				current = end;
				swap2(end,0);
				end--;
				siftDown2(0,end);
				Update2();
				delay();
			}
		}
		//heapify
		public void heapify2(int n) {
			int start = iParent(n-1);
			while(start >= 0 && sorting) {
				siftDown2(start, n-1);
				start--;
				Update2();
				delay();
			}
		}
		//siftdown
		public void siftDown2(int start, int end) {
			int root = start;
			while(iLeftChild(root) <= end && sorting) {
				int child = iLeftChild(root);
				int swap = root;
				check = root;
				if(list2[swap] < list2[child]) {
					swap = child;
				} if(child+1 <= end && list2[swap] < list2[child+1]) {
					swap = child+1;
				} if(swap == root) {
					return;
				} else {
					swap2(root,swap);
					check = root;
					root = swap;
				}
				compare2+=3;	acc2+=4;
				Update2();
				delay();
			}
		}
		public int iParent(int i) { return ((i-1)/2); } //parent of node in heap
		public int iLeftChild(int i) { return 2*i + 1; } //left child of a node

		//quicksort
		public void quickSort2(int lo, int hi) {
			if(!sorting)
				return;
			current = hi;
			if(lo < hi) {
				int p = partition2(lo,hi);
				quickSort2(lo,p-1);
				quickSort2(p+1, hi);
			}
		}

		//partition
		public int partition2(int lo, int hi) {
			int pivot = list2[hi];	acc2++;
			int i = lo - 1;
			for(int j = lo; j < hi; j++) {
				check = j;
				if(!sorting)
					break;
				if(list2[j] < pivot) {
					i++;
					swap2(i,j);
				}
				compare2++;	acc2++;
				Update2();
				delay();
			}
			swap2(i+1,hi);
			Update2();
			delay();
			return i+1;
		}


		void merge2(int l, int m, int r)
			{
					int n1 = m - l + 1;
					int n2 = r - m;
					//the 2 subarrays
					int L[] = new int [n1];
					int R[] = new int [n2];

					for (int i=0; i<n1; i++) {
							L[i] = list2[l + i];	acc2++;
					}
					for (int j=0; j<n2; j++) {
							R[j] = list2[m + 1+ j];	acc2++;
					}
					int i = 0, j = 0;

					int k = l;
					//merges the two subarrays into a big array
					while (i < n1 && j < n2 && sorting) {
						check = k;
							if (L[i] <= R[j]) {
									list2[k] = L[i];	acc2++;
									i++;
							} else {
									list2[k] = R[j];	acc2++;
									j++;
							}
							compare2++;
							Update2();
							delay();
							k++;
					}

					while (i < n1 && sorting) {
							list2[k] = L[i];	acc2++;
							i++;
							k++;
							Update2();
							delay();
					}

					while (j < n2 && sorting) {
							list2[k] = R[j];	acc2++;
							j++;
							k++;
							Update2();
							delay();
					}
			}

		//merge sort algorithm
			public void mergeSort2(int l, int r) {
					if (l < r) {
							int m = (l+r)/2;
							current = r;
							mergeSort2(l, m);
							mergeSort2(m+1, r);

							merge2(l, m, r);
					}
			}
			//this is where the sorting happens
		public void swap2(int i1, int i2) {
			int temp2 = list2[i1];	acc2++;
			list2[i1] = list2[i2];	acc2+=2;
			list2[i2] = temp2;	acc2++;
		}


		public boolean checkSorted2() {
			for(int i = 0; i < len-1; i++) {
				if(list2[i] > list2[i+1]) {	acc2+=2;
					return false;
				}
			}
			return true;
		}
		public void countSort2(int n, int exp) {
			int output[] = new int[n];	//OUTPUT SORTED LIST
			int i;
			int count[] = new int[10];  //THE INDEX ARRAY
			Arrays.fill(count, 0);

			for(i = 0; i < n; i++)	{
				count[(list2[i]/exp)%10]++;	acc2++;  //STORE THE COUNT OF EACH ELEMENT IN LIST
			}

			for(i = 1; i < 10; i++) {
				count[i] += count[i - 1];  //count[i] NOW STORES ACTUAL POSITIONS OF ELEMENTS IN OUTPUT ARRAY
			}

			for(i = n -1; i >= 0; i--) {
				output[count[(list2[i] / exp) % 10] - 1] = list2[i];	acc2++;  //BUILDING THE OUTPUT ARRAY
				count[(list2[i] / exp) % 10]--;	acc2++;
			}
			for(i = 0; i < n; i++) {
				if(!sorting)
					break;
				check = i;
				list2[i] = output[i];	acc2++;  //SET THE SORTED LIST TO THE ORIGINAL LIST
				Update2();
				delay();
			}
		}
		public int getMax2(int n) {
			int mx = list2[0];
			for(int i = 1; i < n; i++) {
				if(list2[i] > mx)
					mx = list2[i];
				compare2++;	acc2++;
			}
			return mx;
		}
		public void radixSort2(int n) {
			int m = getMax2(n);
			 for(int exp = 1; m/exp > 0; exp *= 10) {	//USES EACH DIGIT TO RUN COUNTSORT ON UNTIL WE RUN OUT OF DIGITS
			 	if(!sorting)
			 		break;
				//countSort(n,exp);
				int output[] = new int[n];	//OUTPUT SORTED LIST
				int i;
				int count[] = new int[10];  //THE INDEX ARRAY
				Arrays.fill(count, 0);

				for(i = 0; i < n; i++)	{
					count[(list2[i]/exp)%10]++;	acc2++;  //STORE THE COUNT OF EACH ELEMENT IN LIST
				}

				for(i = 1; i < 10; i++) {
					count[i] += count[i - 1];  //count[i] NOW STORES ACTUAL POSITIONS OF ELEMENTS IN OUTPUT ARRAY
				}

				for(i = n -1; i >= 0; i--) {
					output[count[(list2[i] / exp) % 10] - 1] = list2[i];	acc2++;  //BUILDING THE OUTPUT ARRAY
					count[(list2[i] / exp) % 10]--;	acc2++;
				}
				for(i = 0; i < n; i++) {
					if(!sorting)
						break;
					check = i;
					list2[i] = output[i];	acc2++;  //SET THE SORTED LIST TO THE ORIGINAL LIST
					Update2();
					delay();
				}
				Update2();
				delay();
			 }
		}

	}
	class SortingAlgorithms3 {

		//insertion sort algorithm
		public void insertionSort3(int start, int end) {
			//long startTime = Instant.now().toEpochMilli();
			for(int i = start+1; i <= end; i++) {
				current = i; //decides what element should be key
				int j = i;
				while(list3[j] < list3[j-1] && sorting) {
					swap3(j,j-1); //this is where the sorting takes place
					check = j;
					compare3++;	acc3+=2; //this is how we set the comparison and array access numbers

					Update3();
					delay();
					if(j > start+1)
						j--;
				}
			}
		}
		public void heapSort3(int start, int end) {
			heapify3(len);
			end = len-1;
			while(end > 0 && sorting) {
				current = end;
				swap3(end,0);
				end--;
				siftDown3(0,end);
				Update3();
				delay();
			}
		}
		//heapify
		public void heapify3(int n) {
			int start = iParent(n-1);
			while(start >= 0 && sorting) {
				siftDown3(start, n-1);
				start--;
				Update3();
				delay();
			}
		}
		//siftdown
		public void siftDown3(int start, int end) {
			int root = start;
			while(iLeftChild(root) <= end && sorting) {
				int child = iLeftChild(root);
				int swap = root;
				check = root;
				if(list3[swap] < list3[child]) {
					swap = child;
				} if(child+1 <= end && list3[swap] < list3[child+1]) {
					swap = child+1;
				} if(swap == root) {
					return;
				} else {
					swap3(root,swap);
					check = root;
					root = swap;
				}
				compare3+=3;	acc3+=4;
				Update3();
				delay();
			}
		}
		public int iParent(int i) { return ((i-1)/2); } //parent of node in heap
		public int iLeftChild(int i) { return 2*i + 1; } //left child of a node

		//quicksort
		public void quickSort3(int lo, int hi) {
			if(!sorting)
				return;
			current = hi;
			if(lo < hi) {
				int p = partition3(lo,hi);
				quickSort3(lo,p-1);
				quickSort3(p+1, hi);
			}
		}

		//partition
		public int partition3(int lo, int hi) {
			int pivot = list3[hi];	acc3++;
			int i = lo - 1;
			for(int j = lo; j < hi; j++) {
				check = j;
				if(!sorting)
					break;
				if(list3[j] < pivot) {
					i++;
					swap3(i,j);
				}
				compare3++;	acc3++;
				Update3();
				delay();
			}
			swap3(i+1,hi);
			Update3();
			delay();
			return i+1;
		}


		void merge3(int l, int m, int r)
			{
					int n1 = m - l + 1;
					int n2 = r - m;
					//the 2 subarrays
					int L[] = new int [n1];
					int R[] = new int [n2];

					for (int i=0; i<n1; i++) {
							L[i] = list3[l + i];	acc3++;
					}
					for (int j=0; j<n2; j++) {
							R[j] = list3[m + 1+ j];	acc3++;
					}
					int i = 0, j = 0;

					int k = l;
					//merges the two subarrays into a big array
					while (i < n1 && j < n2 && sorting) {
						check = k;
							if (L[i] <= R[j]) {
									list3[k] = L[i];	acc3++;
									i++;
							} else {
									list3[k] = R[j];	acc3++;
									j++;
							}
							compare3++;
							Update3();
							delay();
							k++;
					}

					while (i < n1 && sorting) {
							list3[k] = L[i];	acc3++;
							i++;
							k++;
							Update3();
							delay();
					}

					while (j < n2 && sorting) {
							list3[k] = R[j];	acc3++;
							j++;
							k++;
							Update3();
							delay();
					}
			}

		//merge sort algorithm
			public void mergeSort3(int l, int r) {
					if (l < r) {
							int m = (l+r)/2;
							current = r;
							mergeSort3(l, m);
							mergeSort3(m+1, r);

							merge3(l, m, r);
					}
			}
			//this is where the sorting happens
		public void swap3(int i1, int i2) {
			int temp3 = list3[i1];	acc3++;
			list3[i1] = list3[i2];	acc3+=2;
			list3[i2] = temp3;	acc3++;
		}


		public boolean checkSorted3() {
			for(int i = 0; i < len-1; i++) {
				if(list3[i] > list3[i+1]) {	acc3+=2;
					return false;
				}
			}
			return true;
		}
		public void countSort3(int n, int exp) {
			int output[] = new int[n];	//OUTPUT SORTED LIST
			int i;
			int count[] = new int[10];  //THE INDEX ARRAY
			Arrays.fill(count, 0);

			for(i = 0; i < n; i++)	{
				count[(list3[i]/exp)%10]++;	acc3++;  //STORE THE COUNT OF EACH ELEMENT IN LIST
			}

			for(i = 1; i < 10; i++) {
				count[i] += count[i - 1];  //count[i] NOW STORES ACTUAL POSITIONS OF ELEMENTS IN OUTPUT ARRAY
			}

			for(i = n -1; i >= 0; i--) {
				output[count[(list3[i] / exp) % 10] - 1] = list3[i];	acc3++;  //BUILDING THE OUTPUT ARRAY
				count[(list3[i] / exp) % 10]--;	acc3++;
			}
			for(i = 0; i < n; i++) {
				if(!sorting)
					break;
				check = i;
				list3[i] = output[i];	acc3++;  //SET THE SORTED LIST TO THE ORIGINAL LIST
				Update3();
				delay();
			}
		}
		public int getMax3(int n) {
			int mx = list3[0];
			for(int i = 1; i < n; i++) {
				if(list3[i] > mx)
					mx = list3[i];
				compare3++;	acc3++;
			}
			return mx;
		}
		public void radixSort3(int n) {
			int m = getMax3(n);
			 for(int exp = 1; m/exp > 0; exp *= 10) {	//USES EACH DIGIT TO RUN COUNTSORT ON UNTIL WE RUN OUT OF DIGITS
			 	if(!sorting)
			 		break;
				//countSort(n,exp);
				int output[] = new int[n];	//OUTPUT SORTED LIST
				int i;
				int count[] = new int[10];  //THE INDEX ARRAY
				Arrays.fill(count, 0);

				for(i = 0; i < n; i++)	{
					count[(list3[i]/exp)%10]++;	acc3++;  //STORE THE COUNT OF EACH ELEMENT IN LIST
				}

				for(i = 1; i < 10; i++) {
					count[i] += count[i - 1];  //count[i] NOW STORES ACTUAL POSITIONS OF ELEMENTS IN OUTPUT ARRAY
				}

				for(i = n -1; i >= 0; i--) {
					output[count[(list3[i] / exp) % 10] - 1] = list3[i];	acc3++;  //BUILDING THE OUTPUT ARRAY
					count[(list3[i] / exp) % 10]--;	acc3++;
				}
				for(i = 0; i < n; i++) {
					if(!sorting)
						break;
					check = i;
					list3[i] = output[i];	acc3++;  //SET THE SORTED LIST TO THE ORIGINAL LIST
					Update3();
					delay();
				}
				Update3();
				delay();
			 }
		}
	}
	class SortingAlgorithms4 {

		//insertion sort algorithm
		public void insertionSort4(int start, int end) {
			//long startTime = Instant.now().toEpochMilli();
			for(int i = start+1; i <= end; i++) {
				current = i; //decides what element should be key
				int j = i;
				while(list4[j] < list4[j-1] && sorting) {
					swap4(j,j-1); //this is where the sorting takes place
					check = j;
					compare4++;	acc4+=2; //this is how we set the comparison and array access numbers

					Update4();
					delay();
					if(j > start+1)
						j--;
				}
			}
		}
		public void heapSort4(int start, int end) {
			heapify4(len);
			end = len-1;
			while(end > 0 && sorting) {
				current = end;
				swap4(end,0);
				end--;
				siftDown4(0,end);
				Update4();
				delay();
			}
		}
		//heapify
		public void heapify4(int n) {
			int start = iParent(n-1);
			while(start >= 0 && sorting) {
				siftDown4(start, n-1);
				start--;
				Update4();
				delay();
			}
		}
		//siftdown
		public void siftDown4(int start, int end) {
			int root = start;
			while(iLeftChild(root) <= end && sorting) {
				int child = iLeftChild(root);
				int swap = root;
				check = root;
				if(list4[swap] < list4[child]) {
					swap = child;
				} if(child+1 <= end && list4[swap] < list4[child+1]) {
					swap = child+1;
				} if(swap == root) {
					return;
				} else {
					swap4(root,swap);
					check = root;
					root = swap;
				}
				compare4+=3;	acc4+=4;
				Update4();
				delay();
			}
		}
		public int iParent(int i) { return ((i-1)/2); } //parent of node in heap
		public int iLeftChild(int i) { return 2*i + 1; } //left child of a node

		//quicksort
		public void quickSort4(int lo, int hi) {
			if(!sorting)
				return;
			current = hi;
			if(lo < hi) {
				int p = partition4(lo,hi);
				quickSort4(lo,p-1);
				quickSort4(p+1, hi);
			}
		}

		//partition
		public int partition4(int lo, int hi) {
			int pivot = list4[hi];	acc4++;
			int i = lo - 1;
			for(int j = lo; j < hi; j++) {
				check = j;
				if(!sorting)
					break;
				if(list4[j] < pivot) {
					i++;
					swap4(i,j);
				}
				compare4++;	acc4++;
				Update4();
				delay();
			}
			swap4(i+1,hi);
			Update4();
			delay();
			return i+1;
		}


		void merge4(int l, int m, int r)
			{
					int n1 = m - l + 1;
					int n2 = r - m;
					//the 2 subarrays
					int L[] = new int [n1];
					int R[] = new int [n2];

					for (int i=0; i<n1; i++) {
							L[i] = list4[l + i];	acc4++;
					}
					for (int j=0; j<n2; j++) {
							R[j] = list4[m + 1+ j];	acc4++;
					}
					int i = 0, j = 0;

					int k = l;
					//merges the two subarrays into a big array
					while (i < n1 && j < n2 && sorting) {
						check = k;
							if (L[i] <= R[j]) {
									list4[k] = L[i];	acc4++;
									i++;
							} else {
									list4[k] = R[j];	acc4++;
									j++;
							}
							compare4++;
							Update4();
							delay();
							k++;
					}

					while (i < n1 && sorting) {
							list4[k] = L[i];	acc4++;
							i++;
							k++;
							Update4();
							delay();
					}

					while (j < n2 && sorting) {
							list4[k] = R[j];	acc4++;
							j++;
							k++;
							Update4();
							delay();
					}
			}

		//merge sort algorithm
			public void mergeSort4(int l, int r) {
					if (l < r) {
							int m = (l+r)/2;
							current = r;
							mergeSort4(l, m);
							mergeSort4(m+1, r);

							merge4(l, m, r);
					}
			}
			//this is where the sorting happens
		public void swap4(int i1, int i2) {
			int temp4 = list4[i1];	acc4++;
			list4[i1] = list4[i2];	acc4+=2;
			list4[i2] = temp4;	acc4++;
		}


		public boolean checkSorted4() {
			for(int i = 0; i < len-1; i++) {
				if(list4[i] > list4[i+1]) {	acc4+=2;
					return false;
				}
			}
			return true;
		}
		public void countSort4(int n, int exp) {
			int output[] = new int[n];	//OUTPUT SORTED LIST
			int i;
			int count[] = new int[10];  //THE INDEX ARRAY
			Arrays.fill(count, 0);

			for(i = 0; i < n; i++)	{
				count[(list4[i]/exp)%10]++;	acc4++;  //STORE THE COUNT OF EACH ELEMENT IN LIST
			}

			for(i = 1; i < 10; i++) {
				count[i] += count[i - 1];  //count[i] NOW STORES ACTUAL POSITIONS OF ELEMENTS IN OUTPUT ARRAY
			}

			for(i = n -1; i >= 0; i--) {
				output[count[(list4[i] / exp) % 10] - 1] = list4[i];	acc4++;  //BUILDING THE OUTPUT ARRAY
				count[(list4[i] / exp) % 10]--;	acc4++;
			}
			for(i = 0; i < n; i++) {
				if(!sorting)
					break;
				check = i;
				list4[i] = output[i];	acc4++;  //SET THE SORTED LIST TO THE ORIGINAL LIST
				Update4();
				delay();
			}
		}
		public int getMax4(int n) {
			int mx = list4[0];
			for(int i = 1; i < n; i++) {
				if(list4[i] > mx)
					mx = list4[i];
				compare4++;	acc4++;
			}
			return mx;
		}
		public void radixSort4(int n) {
			int m = getMax4(n);
			 for(int exp = 1; m/exp > 0; exp *= 10) {	//USES EACH DIGIT TO RUN COUNTSORT ON UNTIL WE RUN OUT OF DIGITS
			 	if(!sorting)
			 		break;
				//countSort(n,exp);
				int output[] = new int[n];	//OUTPUT SORTED LIST
				int i;
				int count[] = new int[10];  //THE INDEX ARRAY
				Arrays.fill(count, 0);

				for(i = 0; i < n; i++)	{
					count[(list4[i]/exp)%10]++;	acc4++;  //STORE THE COUNT OF EACH ELEMENT IN LIST
				}

				for(i = 1; i < 10; i++) {
					count[i] += count[i - 1];  //count[i] NOW STORES ACTUAL POSITIONS OF ELEMENTS IN OUTPUT ARRAY
				}

				for(i = n -1; i >= 0; i--) {
					output[count[(list4[i] / exp) % 10] - 1] = list4[i];	acc4++;  //BUILDING THE OUTPUT ARRAY
					count[(list4[i] / exp) % 10]--;	acc4++;
				}
				for(i = 0; i < n; i++) {
					if(!sorting)
						break;
					check = i;
					list4[i] = output[i];	acc4++;  //SET THE SORTED LIST TO THE ORIGINAL LIST
					Update4();
					delay();
				}
				Update4();
				delay();
			 }
		}
	}

	class SortingAlgorithms5 {

		//insertion sort algorithm
		public void insertionSort5(int start, int end) {
			//long startTime = Instant.now().toEpochMilli();
			for(int i = start+1; i <= end; i++) {
				current = i; //decides what element should be key
				int j = i;
				while(list5[j] < list5[j-1] && sorting) {
					swap5(j,j-1); //this is where the sorting takes place
					check = j;
					compare5++;	acc5+=2; //this is how we set the comparison and array access numbers

					Update5();
					delay();
					if(j > start+1)
						j--;
				}
			}
		}
		public void heapSort5(int start, int end) {
			heapify5(len);
			end = len-1;
			while(end > 0 && sorting) {
				current = end;
				swap5(end,0);
				end--;
				siftDown5(0,end);
				Update5();
				delay();
			}
		}
		//heapify
		public void heapify5(int n) {
			int start = iParent(n-1);
			while(start >= 0 && sorting) {
				siftDown5(start, n-1);
				start--;
				Update5();
				delay();
			}
		}
		//siftdown
		public void siftDown5(int start, int end) {
			int root = start;
			while(iLeftChild(root) <= end && sorting) {
				int child = iLeftChild(root);
				int swap = root;
				check = root;
				if(list5[swap] < list5[child]) {
					swap = child;
				} if(child+1 <= end && list5[swap] < list5[child+1]) {
					swap = child+1;
				} if(swap == root) {
					return;
				} else {
					swap5(root,swap);
					check = root;
					root = swap;
				}
				compare5+=3;	acc5+=4;
				Update5();
				delay();
			}
		}
		public int iParent(int i) { return ((i-1)/2); } //parent of node in heap
		public int iLeftChild(int i) { return 2*i + 1; } //left child of a node

		//quicksort
		public void quickSort5(int lo, int hi) {
			if(!sorting)
				return;
			current = hi;
			if(lo < hi) {
				int p = partition5(lo,hi);
				quickSort5(lo,p-1);
				quickSort5(p+1, hi);
			}
		}

		//partition
		public int partition5(int lo, int hi) {
			int pivot = list5[hi];	acc5++;
			int i = lo - 1;
			for(int j = lo; j < hi; j++) {
				check = j;
				if(!sorting)
					break;
				if(list5[j] < pivot) {
					i++;
					swap5(i,j);
				}
				compare5++;	acc5++;
				Update5();
				delay();
			}
			swap5(i+1,hi);
			Update5();
			delay();
			return i+1;
		}


		void merge5(int l, int m, int r)
			{
					int n1 = m - l + 1;
					int n2 = r - m;
					//the 2 subarrays
					int L[] = new int [n1];
					int R[] = new int [n2];

					for (int i=0; i<n1; i++) {
							L[i] = list5[l + i];	acc5++;
					}
					for (int j=0; j<n2; j++) {
							R[j] = list5[m + 1+ j];	acc5++;
					}
					int i = 0, j = 0;

					int k = l;
					//merges the two subarrays into a big array
					while (i < n1 && j < n2 && sorting) {
						check = k;
							if (L[i] <= R[j]) {
									list5[k] = L[i];	acc5++;
									i++;
							} else {
									list5[k] = R[j];	acc5++;
									j++;
							}
							compare5++;
							Update5();
							delay();
							k++;
					}

					while (i < n1 && sorting) {
							list5[k] = L[i];	acc5++;
							i++;
							k++;
							Update5();
							delay();
					}

					while (j < n2 && sorting) {
							list5[k] = R[j];	acc5++;
							j++;
							k++;
							Update5();
							delay();
					}
			}

		//merge sort algorithm
			public void mergeSort5(int l, int r) {
					if (l < r) {
							int m = (l+r)/2;
							current = r;
							mergeSort5(l, m);
							mergeSort5(m+1, r);

							merge5(l, m, r);
					}
			}
			//this is where the sorting happens
		public void swap5(int i1, int i2) {
			int temp5 = list5[i1];	acc5++;
			list5[i1] = list5[i2];	acc5+=2;
			list5[i2] = temp5;	acc5++;
		}


		public boolean checkSorted5() {
			for(int i = 0; i < len-1; i++) {
				if(list5[i] > list5[i+1]) {	acc5+=2;
					return false;
				}
			}
			return true;
		}
		public void countSort5(int n, int exp) {
			int output[] = new int[n];	//OUTPUT SORTED LIST
			int i;
			int count[] = new int[10];  //THE INDEX ARRAY
			Arrays.fill(count, 0);

			for(i = 0; i < n; i++)	{
				count[(list5[i]/exp)%10]++;	acc5++;  //STORE THE COUNT OF EACH ELEMENT IN LIST
			}

			for(i = 1; i < 10; i++) {
				count[i] += count[i - 1];  //count[i] NOW STORES ACTUAL POSITIONS OF ELEMENTS IN OUTPUT ARRAY
			}

			for(i = n -1; i >= 0; i--) {
				output[count[(list5[i] / exp) % 10] - 1] = list5[i];	acc5++;  //BUILDING THE OUTPUT ARRAY
				count[(list5[i] / exp) % 10]--;	acc5++;
			}
			for(i = 0; i < n; i++) {
				if(!sorting)
					break;
				check = i;
				list5[i] = output[i];	acc5++;  //SET THE SORTED LIST TO THE ORIGINAL LIST
				Update5();
				delay();
			}
		}
		public int getMax5(int n) {
			int mx = list5[0];
			for(int i = 1; i < n; i++) {
				if(list5[i] > mx)
					mx = list5[i];
				compare5++;	acc5++;
			}
			return mx;
		}
		public void radixSort5(int n) {
			int m = getMax5(n);
			 for(int exp = 1; m/exp > 0; exp *= 10) {	//USES EACH DIGIT TO RUN COUNTSORT ON UNTIL WE RUN OUT OF DIGITS
			 	if(!sorting)
			 		break;
				//countSort(n,exp);
				int output[] = new int[n];	//OUTPUT SORTED LIST
				int i;
				int count[] = new int[10];  //THE INDEX ARRAY
				Arrays.fill(count, 0);

				for(i = 0; i < n; i++)	{
					count[(list5[i]/exp)%10]++;	acc5++;  //STORE THE COUNT OF EACH ELEMENT IN LIST
				}

				for(i = 1; i < 10; i++) {
					count[i] += count[i - 1];  //count[i] NOW STORES ACTUAL POSITIONS OF ELEMENTS IN OUTPUT ARRAY
				}

				for(i = n -1; i >= 0; i--) {
					output[count[(list5[i] / exp) % 10] - 1] = list5[i];	acc5++;  //BUILDING THE OUTPUT ARRAY
					count[(list5[i] / exp) % 10]--;	acc5++;
				}
				for(i = 0; i < n; i++) {
					if(!sorting)
						break;
					check = i;
					list5[i] = output[i];	acc5++;  //SET THE SORTED LIST TO THE ORIGINAL LIST
					Update5();
					delay();
				}
				Update5();
				delay();
			 }
		}
	}

	class SortingAlgorithms6 {

		//insertion sort algorithm
		public void insertionSort6(int start, int end) {
			//long startTime = Instant.now().toEpochMilli();
			for(int i = start+1; i <= end; i++) {
				current = i; //decides what element should be key
				int j = i;
				while(list6[j] < list6[j-1] && sorting) {
					swap6(j,j-1); //this is where the sorting takes place
					check = j;
					compare6++;	acc6+=2; //this is how we set the comparison and array access numbers

					Update6();
					delay();
					if(j > start+1)
						j--;
				}
			}
		}
		public void heapSort6(int start, int end) {
			heapify6(len);
			end = len-1;
			while(end > 0 && sorting) {
				current = end;
				swap6(end,0);
				end--;
				siftDown6(0,end);
				Update6();
				delay();
			}
		}
		//heapify
		public void heapify6(int n) {
			int start = iParent(n-1);
			while(start >= 0 && sorting) {
				siftDown6(start, n-1);
				start--;
				Update6();
				delay();
			}
		}
		//siftdown
		public void siftDown6(int start, int end) {
			int root = start;
			while(iLeftChild(root) <= end && sorting) {
				int child = iLeftChild(root);
				int swap = root;
				check = root;
				if(list6[swap] < list6[child]) {
					swap = child;
				} if(child+1 <= end && list6[swap] < list6[child+1]) {
					swap = child+1;
				} if(swap == root) {
					return;
				} else {
					swap6(root,swap);
					check = root;
					root = swap;
				}
				compare6+=3;	acc6+=4;
				Update6();
				delay();
			}
		}
		public int iParent(int i) { return ((i-1)/2); } //parent of node in heap
		public int iLeftChild(int i) { return 2*i + 1; } //left child of a node

		//quicksort
		public void quickSort6(int lo, int hi) {
			if(!sorting)
				return;
			current = hi;
			if(lo < hi) {
				int p = partition6(lo,hi);
				quickSort6(lo,p-1);
				quickSort6(p+1, hi);
			}
		}

		//partition
		public int partition6(int lo, int hi) {
			int pivot = list6[hi];	acc6++;
			int i = lo - 1;
			for(int j = lo; j < hi; j++) {
				check = j;
				if(!sorting)
					break;
				if(list6[j] < pivot) {
					i++;
					swap6(i,j);
				}
				compare6++;	acc6++;
				Update6();
				delay();
			}
			swap6(i+1,hi);
			Update6();
			delay();
			return i+1;
		}


		void merge6(int l, int m, int r)
			{
					int n1 = m - l + 1;
					int n2 = r - m;
					//the 2 subarrays
					int L[] = new int [n1];
					int R[] = new int [n2];

					for (int i=0; i<n1; i++) {
							L[i] = list6[l + i];	acc6++;
					}
					for (int j=0; j<n2; j++) {
							R[j] = list6[m + 1+ j];	acc6++;
					}
					int i = 0, j = 0;

					int k = l;
					//merges the two subarrays into a big array
					while (i < n1 && j < n2 && sorting) {
						check = k;
							if (L[i] <= R[j]) {
									list6[k] = L[i];	acc6++;
									i++;
							} else {
									list6[k] = R[j];	acc6++;
									j++;
							}
							compare6++;
							Update6();
							delay();
							k++;
					}

					while (i < n1 && sorting) {
							list6[k] = L[i];	acc6++;
							i++;
							k++;
							Update6();
							delay();
					}

					while (j < n2 && sorting) {
							list6[k] = R[j];	acc6++;
							j++;
							k++;
							Update6();
							delay();
					}
			}

		//merge sort algorithm
			public void mergeSort6(int l, int r) {
					if (l < r) {
							int m = (l+r)/2;
							current = r;
							mergeSort6(l, m);
							mergeSort6(m+1, r);

							merge6(l, m, r);
					}
			}
			//this is where the sorting happens
		public void swap6(int i1, int i2) {
			int temp6 = list6[i1];	acc6++;
			list6[i1] = list6[i2];	acc6+=2;
			list6[i2] = temp6;	acc6++;
		}


		public boolean checkSorted6() {
			for(int i = 0; i < len-1; i++) {
				if(list6[i] > list6[i+1]) {	acc6+=2;
					return false;
				}
			}
			return true;
		}
		public void countSort6(int n, int exp) {
			int output[] = new int[n];	//OUTPUT SORTED LIST
			int i;
			int count[] = new int[10];  //THE INDEX ARRAY
			Arrays.fill(count, 0);

			for(i = 0; i < n; i++)	{
				count[(list6[i]/exp)%10]++;	acc6++;  //STORE THE COUNT OF EACH ELEMENT IN LIST
			}

			for(i = 1; i < 10; i++) {
				count[i] += count[i - 1];  //count[i] NOW STORES ACTUAL POSITIONS OF ELEMENTS IN OUTPUT ARRAY
			}

			for(i = n -1; i >= 0; i--) {
				output[count[(list6[i] / exp) % 10] - 1] = list6[i];	acc6++;  //BUILDING THE OUTPUT ARRAY
				count[(list6[i] / exp) % 10]--;	acc6++;
			}
			for(i = 0; i < n; i++) {
				if(!sorting)
					break;
				check = i;
				list6[i] = output[i];	acc6++;  //SET THE SORTED LIST TO THE ORIGINAL LIST
				Update6();
				delay();
			}
		}
		public int getMax6(int n) {
			int mx = list6[0];
			for(int i = 1; i < n; i++) {
				if(list6[i] > mx)
					mx = list6[i];
				compare6++;	acc6++;
			}
			return mx;
		}
		public void radixSort6(int n) {
			int m = getMax6(n);
			 for(int exp = 1; m/exp > 0; exp *= 10) {	//USES EACH DIGIT TO RUN COUNTSORT ON UNTIL WE RUN OUT OF DIGITS
			 	if(!sorting)
			 		break;
				//countSort(n,exp);
				int output[] = new int[n];	//OUTPUT SORTED LIST
				int i;
				int count[] = new int[10];  //THE INDEX ARRAY
				Arrays.fill(count, 0);

				for(i = 0; i < n; i++)	{
					count[(list6[i]/exp)%10]++;	acc6++;  //STORE THE COUNT OF EACH ELEMENT IN LIST
				}

				for(i = 1; i < 10; i++) {
					count[i] += count[i - 1];  //count[i] NOW STORES ACTUAL POSITIONS OF ELEMENTS IN OUTPUT ARRAY
				}

				for(i = n -1; i >= 0; i--) {
					output[count[(list6[i] / exp) % 10] - 1] = list6[i];	acc6++;  //BUILDING THE OUTPUT ARRAY
					count[(list6[i] / exp) % 10]--;	acc6++;
				}
				for(i = 0; i < n; i++) {
					if(!sorting)
						break;
					check = i;
					list6[i] = output[i];	acc6++;  //SET THE SORTED LIST TO THE ORIGINAL LIST
					Update6();
					delay();
				}
				Update6();
				delay();
			 }
		}
	}
}
