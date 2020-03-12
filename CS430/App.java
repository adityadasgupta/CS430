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
	private String[] algorithms = { "Heap Sort",
								    "Quick Sort",
								    "Both"};
	private String[] algInfo = {"Best Case: O (nlogn)\nWorst Case: O (nlogn)\nAverage: O (nlogn)",
								"Best Case: O (nlogn)\nWorst Case: O (n^2)\nAverage: O (nlogn)",
								"Left is Heap Sort\nRight is Quick Sort "
								};
	private String[] algNameHeap = {"Heap Sort",
									"Quick Sort",
									"Heap Sort"
								  };
	private String[] algNameQuick = {"Heap Sort",
									 "Quick Sort",
									 "Quick Sort"
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
	    algHeap.setBounds(30,10,230,30);
	    algHeap.setBackground(Color.decode("#ffffff"));
	    algHeap.setBorder(loweredetched);
	    algHeap.setForeground(Color.decode("#03DAC5"));
	    algHeap.setFont(f);
	    algHeap.setEditable(false);
		tools.add(algHeap);

		//SET UP GRAPH 2 NAME
	    algQuick.setBounds(720,10,230,30);
	    algQuick.setBackground(Color.decode("#ffffff"));
	    algQuick.setBorder(loweredetched);
	    algQuick.setForeground(Color.decode("#da4703"));
	    algQuick.setFont(f);
	    algQuick.setEditable(false);
		tools.add(algQuick);

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
				algHeap.setText(algNameHeap[curAlg]);
			}

		});

		//This action listener sets the text of the name of Graph 2 based on what sorting algorithm we choose
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
						algorithm1.heapSort(0, len-1);
						algorithm2.heapSort1(0, len-1);
						break;
					case 1:
						algorithm1.quickSort(0, len-1);
						algorithm2.quickSort1(0, len-1);
						break;
					case 2:
						algorithm1.heapSort(0,len-1);
						algorithm2.quickSort1(0,len-1);
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

					g.setColor(Color.decode("#ce03fc"));	//DEFAULT COLOR
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

		public void swap(int i1, int i2) {
			int temp = list[i1];	acc++;
			list[i1] = list[i2];	acc+=2;
			list[i2] = temp;	acc++;
		}
		//heap sort algorithm
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

	}
	//the same algorithms but for graph 2
class SortingAlgorithms1 {

	public void swap1(int i1, int i2) {
		int temp = list1[i1];	acc1++;
		list1[i1] = list1[i2];	acc1+=2;
		list1[i2] = temp;	acc1++;
	}
	public void heapSort1(int start, int end) {
		heapify1(len);
		end = len-1;
		while(end > 0 && sorting) {
			current = end;
			swap1(end,0);
			end--;
			siftDown1(0,end);
			Update1();
			delay();
		}
	}
	//heapify
	public void heapify1(int n) {
		int start = iParent(n-1);
		while(start >= 0 && sorting) {
			siftDown1(start, n-1);
			start--;
			Update1();
			delay();
		}
	}
	//siftdown
	public void siftDown1(int start, int end) {
		int root = start;
		while(iLeftChild(root) <= end && sorting) {
			int child = iLeftChild(root);
			int swap = root;
			check = root;
			if(list1[swap] < list1[child]) {
				swap = child;
			} if(child+1 <= end && list1[swap] < list1[child+1]) {
				swap = child+1;
			} if(swap == root) {
				return;
			} else {
				swap1(root,swap);
				check = root;
				root = swap;
			}
			compare1+=3;	acc1+=4;
			Update1();
			delay();
		}
	}
	public int iParent(int i) { return ((i-1)/2); } //parent of node in heap
	public int iLeftChild(int i) { return 2*i + 1; } //left child of a node

	//quicksort
	public void quickSort1(int lo, int hi) {
		if(!sorting)
			return;
		current = hi;
		if(lo < hi) {
			int p = partition1(lo,hi);
			quickSort1(lo,p-1);
			quickSort1(p+1, hi);
		}
	}

	//partition
	public int partition1(int lo, int hi) {
		int pivot = list1[hi];	acc1++;
		int i = lo - 1;
		for(int j = lo; j < hi; j++) {
			check = j;
			if(!sorting)
				break;
			if(list1[j] < pivot) {
				i++;
				swap1(i,j);
			}
			compare1++;	acc1++;
			Update1();
			delay();
		}
		swap1(i+1,hi);
		Update1();
		delay();
		return i+1;
	}
}
}
