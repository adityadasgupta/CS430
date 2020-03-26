//TEAM NAME = NULL
//TEAM MEMBERS = ADITYA DASGUPTA(seat 14) AND DEVYANI GAURI(seat 25)
//HW-3

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
	private int acc = 0;
	private int acc2 = 0;
	private int acc3 = 0;
	private int acc4 = 0;
	private long timeEl = 0 ;
	//GRAPH VARIABLES
	private final int SIZE = 320;
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
								    "Heap Sort",
								    "Quick Sort",
								    "All"};
	private String[] algInfo = {"Best Case: O (n)\nWorst Case: O (n^2)\nAverage: O (n^2)",
								"Best Case: O (nlogn)\nWorst Case: O (nlogn)\nAverage: O (nlogn)",
								"Left is Insert Sort\nRight is Merge Sort "
								};
	private String[] algNameIns = {"Insertion Sort",
									"Merge Sort",
									"Heap Sort",
									"Quick Sort",
									"Insertion Sort"
								  };
	private String[] algNameMerge = {"Insertion Sort",
									 "Merge Sort",
									 "Heap Sort",
									 "Quick Sort",
									 "Merge Sort"
									};
	private String[] algNameHeap = {"Insertion Sort",
			                        "Merge Sort",
			                        "Heap Sort",
			                        "Quick Sort",
			                        "Heap Sort"
			                       };
	private String[] algNameQuick = {"Insertion Sort",
                                     "Merge Sort",
                                     "Heap Sort",
                                     "Quick Sort",
                                     "Quick Sort"
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

	Random r = new Random();
	//PANELS
	JPanel tools = new JPanel();
	GraphCanvas canvas;
	GraphCanvas2 canvas2;
	GraphCanvas3 canvas3;
	GraphCanvas4 canvas4;
	//LABELS
	JLabel msL = new JLabel(spd+" ms");
	JLabel sizeL = new JLabel("Size :");
	JLabel lenL = new JLabel(len+"");
	JLabel compareL = new JLabel("Comparisons(Graph 1) : " + compare);
	JLabel compareL2 = new JLabel("Comparisons(Graph 2) : " + compare2);
	JLabel compareL3 = new JLabel("Comparisons(Graph 3) : " + compare3);
	JLabel compareL4 = new JLabel("Comparisons(Graph 4) : " + compare4);
	JLabel accessL = new JLabel("Array Accesses(Graph 1) : " + acc);
	JLabel accessL2 = new JLabel("Array Accesses(Graph 2) : " + acc2);
	JLabel accessL3 = new JLabel("Array Accesses(Graph 3) : " + acc3);
	JLabel accessL4 = new JLabel("Array Accesses(Graph 4) : " + acc4);

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

		//SET UP GRAPH 3 NAME
		algHeap.setBounds(30,40,230,30);
	    algHeap.setBackground(Color.decode("#ffffff"));
	    algHeap.setBorder(loweredetched);
	    algHeap.setForeground(Color.decode("#fcba03"));
	    algHeap.setFont(f);
	    algHeap.setEditable(false);
		tools.add(algHeap);

		//SET UP GRAPH 4 NAME
		algQuick.setBounds(720,40,230,30);
	    algQuick.setBackground(Color.decode("#ffffff"));
		algQuick.setBorder(loweredetched);
		algQuick.setForeground(Color.decode("#ce03fc"));
		algQuick.setFont(f);
		algQuick.setEditable(false);
		tools.add(algQuick);

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
		compareL.setBounds(720,90,500,25);
		compareL.setFont(f);
		tools.add(compareL);

		//SET UP COMPARISONS LABEL FOR 2ND GRAPH
		compareL2.setHorizontalAlignment(JLabel.LEFT);
	    compareL2.setBackground(Color.decode("#beebea"));
		compareL2.setBounds(1020,90,500,25);
		compareL2.setFont(f);
		tools.add(compareL2);

		//SET UP COMPARISONS LABEL FOR 3RD GRAPH
		compareL3.setHorizontalAlignment(JLabel.LEFT);
	    compareL3.setBackground(Color.decode("#beebea"));
		compareL3.setBounds(720,155,500,25);
		compareL3.setFont(f);
		tools.add(compareL3);

		//SET UP COMPARISONS LABEL FOR 4TH GRAPH
		compareL4.setHorizontalAlignment(JLabel.LEFT);
		compareL4.setBackground(Color.decode("#beebea"));
		compareL4.setBounds(1020,155,500,25);
		compareL4.setFont(f);
		tools.add(compareL4);

		//SET UP ARRAY ACCESS LABEL FOR 1ST GRAPH
        accessL.setHorizontalAlignment(JLabel.LEFT);
        accessL.setBackground(Color.decode("#beebea"));
		accessL.setBounds(720,120,500,25);
		accessL.setFont(f);
		tools.add(accessL);

		//SET UP ARRAY ACCESS LABEL FOR 2ND GRAPH
        accessL2.setHorizontalAlignment(JLabel.LEFT);
        accessL2.setBackground(Color.decode("#beebea"));
		accessL2.setBounds(1020,120,500,25);
		accessL2.setFont(f);
		tools.add(accessL2);

		//SET UP ARRAY ACCESS LABEL FOR 3RD GRAPH
        accessL3.setHorizontalAlignment(JLabel.LEFT);
        accessL3.setBackground(Color.decode("#beebea"));
		accessL3.setBounds(720,180,500,25);
		accessL3.setFont(f);
		tools.add(accessL3);

		//SET UP ARRAY ACCESS LABEL FOR 4TH GRAPH
        accessL4.setHorizontalAlignment(JLabel.LEFT);
        accessL4.setBackground(Color.decode("#beebea"));
		accessL4.setBounds(1020,180,500,25);
		accessL4.setFont(f);
		tools.add(accessL4);

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
		canvas2.setBounds(650,10,SIZE+100,SIZE);
		canvas2.setBorder(BorderFactory.createLineBorder(Color.black));
		jf.getContentPane().add(tools);
		jf.getContentPane().add(canvas2);
		//JTextPane textPane = new JTextPane();

		canvas3 = new GraphCanvas3();
		canvas3.setBounds(30,350,SIZE+100,SIZE);
		canvas3.setBorder(BorderFactory.createLineBorder(Color.black));
		jf.getContentPane().add(tools);
		jf.getContentPane().add(canvas3);

		canvas4 = new GraphCanvas4();
		canvas4.setBounds(650,350,SIZE+100,SIZE);
		canvas4.setBorder(BorderFactory.createLineBorder(Color.black));
		jf.getContentPane().add(tools);
		jf.getContentPane().add(canvas4);
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
		//This action listener sets the text of the name of Graph 3 based on what sorting algorithm we choose
		alg.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				curAlg = alg.getSelectedIndex();
				algQuick.setText(algNameQuick[curAlg]);
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
					acc = 0;
					acc2 = 0;
					acc3 = 0;
					acc4 = 0;
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
						break;
					case 1:
						algorithm1.mergeSort(0, len-1);
						algorithm2.mergeSort2(0, len-1);
						algorithm3.mergeSort3(0, len-1);
						algorithm4.mergeSort4(0, len-1);
						break;
					case 2:
						algorithm1.heapSort(0,len-1);
						algorithm2.heapSort2(0,len-1);
						algorithm3.heapSort3(0,len-1);
						algorithm4.heapSort4(0,len-1);
					case 3:
						algorithm1.quickSort(0,len-1);
						algorithm2.quickSort2(0,len-1);
						algorithm3.quickSort3(0,len-1);
						algorithm4.quickSort4(0,len-1);
					case 4:
						algorithm1.insertionSort(0,len-1);
						algorithm2.mergeSort2(0,len-1);
						algorithm3.heapSort3(0,len-1);
						algorithm4.quickSort4(0,len-1);
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
		compareL3.setText("Comparisons(Graph 2) : " + compare3);
		accessL3.setText("Array Accesses(Graph 2) : " + acc3);
		//timeElapsed.setText("Time Elapsed : " + timeEl + " units");
	}
	public void Update4() {
		width = (SIZE/len)+1;
		canvas.repaint();
		canvas2.repaint();
		canvas3.repaint();
		canvas4.repaint();
		compareL4.setText("Comparisons(Graph 2) : " + compare4);
		accessL4.setText("Array Accesses(Graph 2) : " + acc4);
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
				int HEIGHT = (list1[i]*width)-40;	//SETS THE HEIGHT OF THE ELEMENT ON THE GRAPH

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
			int HEIGHT = (list1[i]*width)-40;	//SETS THE HEIGHT OF THE ELEMENT ON THE GRAPH

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
				int HEIGHT = (list1[i] * width)-40; // SETS THE HEIGHT OF THE ELEMENT ON THE GRAPH

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

	}

	class SortingAlgorithms2 {

		//insertion sort algorithm
		public void insertionSort2(int start, int end) {
			//long startTime = Instant.now().toEpochMilli();
			for(int i = start+1; i <= end; i++) {
				current = i; //decides what element should be key
				int j = i;
				while(list[j] < list[j-1] && sorting) {
					swap2(j,j-1); //this is where the sorting takes place
					check = j;
					compare++;	acc+=2; //this is how we set the comparison and array access numbers

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
				if(list[swap] < list[child]) {
					swap = child;
				} if(child+1 <= end && list[swap] < list[child+1]) {
					swap = child+1;
				} if(swap == root) {
					return;
				} else {
					swap2(root,swap);
					check = root;
					root = swap;
				}
				compare+=3;	acc+=4;
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
			int pivot = list[hi];	acc++;
			int i = lo - 1;
			for(int j = lo; j < hi; j++) {
				check = j;
				if(!sorting)
					break;
				if(list[j] < pivot) {
					i++;
					swap2(i,j);
				}
				compare++;	acc++;
				Update();
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
							Update2();
							delay();
							k++;
					}

					while (i < n1 && sorting) {
							list[k] = L[i];	acc++;
							i++;
							k++;
							Update2();
							delay();
					}

					while (j < n2 && sorting) {
							list[k] = R[j];	acc++;
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
			int temp = list[i1];	acc++;
			list[i1] = list[i2];	acc+=2;
			list[i2] = temp;	acc++;
		}


		public boolean checkSorted2() {
			for(int i = 0; i < len-1; i++) {
				if(list[i] > list[i+1]) {	acc+=2;
					return false;
				}
			}
			return true;
		}

	}
	class SortingAlgorithms3 {

		//insertion sort algorithm
		public void insertionSort3(int start, int end) {
			//long startTime = Instant.now().toEpochMilli();
			for(int i = start+1; i <= end; i++) {
				current = i; //decides what element should be key
				int j = i;
				while(list[j] < list[j-1] && sorting) {
					swap3(j,j-1); //this is where the sorting takes place
					check = j;
					compare++;	acc+=2; //this is how we set the comparison and array access numbers

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
				if(list[swap] < list[child]) {
					swap = child;
				} if(child+1 <= end && list[swap] < list[child+1]) {
					swap = child+1;
				} if(swap == root) {
					return;
				} else {
					swap3(root,swap);
					check = root;
					root = swap;
				}
				compare+=3;	acc+=4;
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
			int pivot = list[hi];	acc++;
			int i = lo - 1;
			for(int j = lo; j < hi; j++) {
				check = j;
				if(!sorting)
					break;
				if(list[j] < pivot) {
					i++;
					swap3(i,j);
				}
				compare++;	acc++;
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
							Update3();
							delay();
							k++;
					}

					while (i < n1 && sorting) {
							list[k] = L[i];	acc++;
							i++;
							k++;
							Update3();
							delay();
					}

					while (j < n2 && sorting) {
							list[k] = R[j];	acc++;
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
			int temp = list[i1];	acc++;
			list[i1] = list[i2];	acc+=2;
			list[i2] = temp;	acc++;
		}


		public boolean checkSorted3() {
			for(int i = 0; i < len-1; i++) {
				if(list[i] > list[i+1]) {	acc+=2;
					return false;
				}
			}
			return true;
		}

	}
	class SortingAlgorithms4 {

		//insertion sort algorithm
		public void insertionSort4(int start, int end) {
			//long startTime = Instant.now().toEpochMilli();
			for(int i = start+1; i <= end; i++) {
				current = i; //decides what element should be key
				int j = i;
				while(list[j] < list[j-1] && sorting) {
					swap4(j,j-1); //this is where the sorting takes place
					check = j;
					compare++;	acc+=2; //this is how we set the comparison and array access numbers

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
				if(list[swap] < list[child]) {
					swap = child;
				} if(child+1 <= end && list[swap] < list[child+1]) {
					swap = child+1;
				} if(swap == root) {
					return;
				} else {
					swap4(root,swap);
					check = root;
					root = swap;
				}
				compare+=3;	acc+=4;
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
			int pivot = list[hi];	acc++;
			int i = lo - 1;
			for(int j = lo; j < hi; j++) {
				check = j;
				if(!sorting)
					break;
				if(list[j] < pivot) {
					i++;
					swap4(i,j);
				}
				compare++;	acc++;
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
							Update4();
							delay();
							k++;
					}

					while (i < n1 && sorting) {
							list[k] = L[i];	acc++;
							i++;
							k++;
							Update4();
							delay();
					}

					while (j < n2 && sorting) {
							list[k] = R[j];	acc++;
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
			int temp = list[i1];	acc++;
			list[i1] = list[i2];	acc+=2;
			list[i2] = temp;	acc++;
		}


		public boolean checkSorted4() {
			for(int i = 0; i < len-1; i++) {
				if(list[i] > list[i+1]) {	acc+=2;
					return false;
				}
			}
			return true;
		}


	}
}
