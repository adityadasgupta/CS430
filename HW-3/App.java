//TEAM NAME = NULL
//TEAM MEMBERS = ADITYA DASGUPTA(seat 14) AND DEVYANI GAURI(seat 25)
//HW-1

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
	private int compare1 = 0;
	private int acc = 0;
	private int acc1 = 0;
	private long timeEl = 0 ;
	//GRAPH VARIABLES
	private final int SIZE = 650;
	private int current = -1;
	private int check = -1;
	private int width = SIZE/len;
	private int type = 0;
	//ARRAYS
	private int[] list;
	private int[] list1;
	//list2 = list;
	private String[] types = {"Bar Graph"};
	private String[] algorithms = { "Insertion Sort",
								    "Merge Sort",
								    "Both"};
	private String[] algInfo = {"Best Case: O (n)\nWorst Case: O (n^2)\nAverage: O (n^2)",
								"Best Case: O (nlogn)\nWorst Case: O (nlogn)\nAverage: O (nlogn)",
								"Left is Insert Sort\nRight is Merge Sort "
								};
	private String[] algNameIns = {"Insertion Sort",
									"Merge Sort",
									"Insertion Sort"
								  };
	private String[] algNameMerge = {"Insertion Sort",
									 "Merge Sort",
									 "Merge Sort"
									};

	Font f = new Font("Raleway", Font.BOLD,20);
	//BOOLEANS
	private boolean sorting = false;
	private boolean shuffled = true;
	//UTIL OBJECTS
	SortingAlgorithms algorithm1 = new SortingAlgorithms();
	SortingAlgorithms1 algorithm2 = new SortingAlgorithms1();
	Random r = new Random();
	//PANELS
	JPanel tools = new JPanel();
	GraphCanvas canvas;
	GraphCanvas1 canvas2;
	//LABELS
	JLabel msL = new JLabel(spd+" ms");
	JLabel sizeL = new JLabel("Size :");
	JLabel lenL = new JLabel(len+"");
	JLabel compareL = new JLabel("Comparisons(Graph 1) : " + compare);
	JLabel accessL = new JLabel("Array Accesses(Graph 1) : " + acc);
	JLabel compareL1 = new JLabel("Comparisons(Graph 2) : " + compare1);
	JLabel accessL1 = new JLabel("Array Accesses(Graph 2) : " + acc1);
	JLabel algorithmL = new JLabel("Algorithms");
	//DROP DOWN BOX
	JComboBox alg = new JComboBox(algorithms);
	JComboBox graph = new JComboBox(types);
	//TEXT AREA
	JTextArea information = new JTextArea(algInfo[curAlg]);
	JTextArea algIns = new JTextArea(algNameIns[curAlg]);
	JTextArea algMerge = new JTextArea(algNameMerge[curAlg]);
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
		list1 = new int[len];//CREATES TWO LISTS EQUAL TO THE LENGTH
		for(int i = 0; i < len; i++) {	//FILLS THE LIST FROM 1-LEN
			list[i] = i+1;
			list1[i] = i+1;
		}

	}

	public void shuffleList() {
		createList();
		for(int a = 0; a < 500; a++) {	//SHUFFLE RUNS 500 TIMES
			for(int i = 0; i < len; i++) {	//ACCESS EACH ELEMENT OF THE LIST
				int rand = r.nextInt(len);	//PICK A RANDOM NUM FROM 0-LEN
				int temp = list[i];
				int temp1 = list[i];//SETS TEMP INT TO CURRENT ELEMENT
				list[i] = list[rand];		//SWAPS THE CURRENT INDEX WITH RANDOM INDEX
				list[rand] = temp;
				list1[i] = list1[rand];
				list1[rand] = temp1;//SETS THE RANDOM INDEX TO THE TEMP
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
	    algMerge.setBounds(720,10,230,30);
	    algMerge.setBackground(Color.decode("#ffffff"));
	    algMerge.setBorder(loweredetched);
	    algMerge.setForeground(Color.decode("#da4703"));
	    algMerge.setFont(f);
	    algMerge.setEditable(false);
		tools.add(algMerge);

		//SET UP ALGORITHM LABEL
		algorithmL.setHorizontalAlignment(JLabel.CENTER);
		algorithmL.setBounds(20,50,170,30);
		algorithmL.setFont(new Font("Raleway", Font.BOLD, 25));
		tools.add(algorithmL);

		//SET UP DROP DOWN
        alg.setBounds(30,90,170,30);
        alg.setBackground(Color.decode("#ffffff"));
        alg.setFont(f);
		tools.add(alg);

		//SET UP SORT BUTTON
        sort.setBounds(220,90,120,30);
        sort.setBackground(Color.decode("#ffffff"));
        sort.setFont(f);
		tools.add(sort);

		//SET UP SHUFFLE BUTTON
        shuffle.setBounds(350,90,120,30);
        shuffle.setFont(f);
        shuffle.setBackground(Color.decode("#ffffff"));
		tools.add(shuffle);

		//SET UP MS LABEL
		msL.setHorizontalAlignment(JLabel.LEFT);
        msL.setBounds(30,130,70,25);
        msL.setFont(f);
        msL.setBackground(Color.decode("#beebea"));
		tools.add(msL);

		//SET UP SPEED SLIDER
		speed.setMajorTickSpacing(5);
		speed.setBounds(90,130,100,30);
        speed.setPaintTicks(false);
        speed.setBackground(Color.decode("#beebea"));
		tools.add(speed);

		//SET UP SIZE LABEL
		sizeL.setHorizontalAlignment(JLabel.LEFT);
        sizeL.setBounds(30,180,100,25);
        sizeL.setFont(f);
        sizeL.setBackground(Color.decode("#beebea"));
		tools.add(sizeL);

		//SET UP LEN LABEL
		lenL.setHorizontalAlignment(JLabel.LEFT);
        lenL.setBounds(190,180,50,25);
        lenL.setBackground(Color.decode("#beebea"));
		tools.add(lenL);

		//SET UP SIZE SLIDER
		size.setMajorTickSpacing(50);
		size.setBounds(92,180,100,30);
        size.setPaintTicks(false);
        size.setBackground(Color.decode("#beebea"));
		tools.add(size);

		//SET UP COMPARISONS LABEL FOR 1ST GRAPH
        compareL.setHorizontalAlignment(JLabel.LEFT);
        compareL.setBackground(Color.decode("#beebea"));
		compareL.setBounds(30,215,500,25);
		compareL.setFont(f);
		tools.add(compareL);

		//SET UP COMPARISONS LABEL FOR 2ND GRAPH
		compareL1.setHorizontalAlignment(JLabel.LEFT);
	    compareL1.setBackground(Color.decode("#beebea"));
		compareL1.setBounds(720,90,500,25);
		compareL1.setFont(f);
		tools.add(compareL1);

		//SET UP ARRAY ACCESS LABEL FOR 1ST GRAPH
        accessL.setHorizontalAlignment(JLabel.LEFT);
        accessL.setBackground(Color.decode("#beebea"));
		accessL.setBounds(30,245,500,25);
		accessL.setFont(f);
		tools.add(accessL);

		//SET UP ARRAY ACCESS LABEL FOR 2ND GRAPH
        accessL1.setHorizontalAlignment(JLabel.LEFT);
        accessL1.setBackground(Color.decode("#beebea"));
		accessL1.setBounds(720,120,500,25);
		accessL1.setFont(f);
		tools.add(accessL1);

		//SET UP INFO AREA
        information.setBounds(720,170,230,90);
        information.setBackground(Color.decode("#ffffff"));
        information.setFont(f);
		information.setEditable(false);
		tools.add(information);


		//SET UP CANVAS FOR FIRST GRAPH
		canvas = new GraphCanvas();
		canvas.setBounds(20,10,SIZE,SIZE);
		canvas.setBorder(BorderFactory.createLineBorder(Color.black));
		jf.getContentPane().add(tools);
		jf.getContentPane().add(canvas);


		//SET UP CANVAS FOR SECOND GRAPH
		canvas2 = new GraphCanvas1();
		canvas2.setBounds(720,10,SIZE,SIZE);
		canvas2.setBorder(BorderFactory.createLineBorder(Color.black));
		jf.getContentPane().add(tools);
		jf.getContentPane().add(canvas2);
		//JTextPane textPane = new JTextPane();


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

		// This action listener sets the number of comparisons and access to 0 if we just created a new random list
		sort.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(shuffled) {
					sorting = true;
					compare = 0;
					compare1 = 0;
					acc = 0;
					acc1 = 0;
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
						algorithm2.insertionSort1(0, len-1);
						break;
					case 1:
						algorithm1.mergeSort(0, len-1);
						algorithm2.mergeSort1(0, len-1);
						break;
					case 2:
						algorithm1.insertionSort(0,len-1);
						algorithm2.mergeSort1(0,len-1);
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
		width = SIZE/len;
		canvas.repaint();
		canvas2.repaint();
		compareL.setText("Comparisons(Graph1) : " + compare);
		accessL.setText("Array Accesses(Graph 1) : " + acc);
		//timeElapsed.setText("Time Elapsed : " + timeEl + " units");
	}

	//UPDATES GRAPH 2  AND LABELS
	public void Update1() {
		width = SIZE/len;
		canvas.repaint();
		canvas2.repaint();
		compareL1.setText("Comparisons(Graph 2) : " + compare1);
		accessL1.setText("Array Accesses(Graph 2) : " + acc1);
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
				int HEIGHT = list[i]*width;	//SETS THE HEIGHT OF THE ELEMENT ON THE GRAPH

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
class GraphCanvas1 extends JPanel {

		public GraphCanvas1() {
			setBackground(Color.white);
		}

		//PAINTS THE GRAPH
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			for(int i = 0; i < len; i++) {	//RUNS TROUGH EACH ELEMENT OF THE LIST
				int HEIGHT = list1[i]*width;	//SETS THE HEIGHT OF THE ELEMENT ON THE GRAPH

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

	}
	//the same algorithms but for graph 2
class SortingAlgorithms1 {

		public void insertionSort1(int start, int end) {
			//long startTime = Instant.now().toEpochMilli();
			for(int i = start+1; i <= end; i++) {
				current = i;
				int j = i;
				while(list1[j] < list1[j-1] && sorting) {
					swap1(j,j-1);
					check = j;
					compare1++;	acc1+=2;
					Update1();
					delay();
					if(j > start+1)
						j--;
				}
			}
		}




		void merge1(int l, int m, int r)
	    {
	        int n1 = m - l + 1;
	        int n2 = r - m;

	        int L[] = new int [n1];
	        int R[] = new int [n2];

	        for (int i=0; i<n1; i++) {
	            L[i] = list1[l + i];	acc1++;
	        }
	        for (int j=0; j<n2; j++) {
	            R[j] = list1[m + 1+ j];	acc1++;
	        }
	        int i = 0, j = 0;

	        int k = l;
	        while (i < n1 && j < n2 && sorting) {
	        	check = k;
	            if (L[i] <= R[j]) {
	                list1[k] = L[i];	acc1++;
	                i++;
	            } else {
	                list1[k] = R[j];	acc1++;
	                j++;
	            }
	            compare1++;
	            Update1();
	            delay();
	            k++;
	        }

	        while (i < n1 && sorting) {
	            list1[k] = L[i];	acc1++;
	            i++;
	            k++;
	            Update1();
	            delay();
	        }

	        while (j < n2 && sorting) {
	            list1[k] = R[j];	acc1++;
	            j++;
	            k++;
	            Update1();
	            delay();
	        }
	    }

	    public void mergeSort1(int l, int r) {
	        if (l < r) {
	            int m = (l+r)/2;
	            current = r;
	            mergeSort1(l, m);
	            mergeSort1(m+1, r);

	            merge1(l, m, r);
	        }
	    }


		public void swap1(int i1, int i2) {
			int temp = list1[i1];	acc1++;
			list1[i1] = list1[i2];	acc1+=2;
			list1[i2] = temp;	acc1++;
		}

		public boolean checkSorted1() {
			for(int i = 0; i < len-1; i++) {
				if(list1[i] > list1[i+1]) {	acc1+=2;
					return false;
				}
			}
			return true;
		}
	}
}

//sorting algorithm 3 
class SortingAlgorithms2 {

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

}
