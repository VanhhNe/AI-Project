package ResearchComputation;

import java.io.IOException;

import Interface.MODES;
import java.util.Vector;
public class MainRunner {
	static TestSudoku testValid;

	public static void main(String[] args) throws IOException, CloneNotSupportedException {
		testValid = new TestSudoku();
		String fileName = "";
		MODES MODE = null;
		int kernel = 4;
		if (args.length >= 2) {
			fileName = args[0];
			int option = Integer.parseInt(args[1]);
			System.out.println("Option model: " + option);
			switch (option) {
			case 0:
				MODE = MODES.SEQUENTIAL_BACKTRACKING;
				break;
			case 1:
				MODE = MODES.SEQUENTIAL_BRUTEFORCE;
				break;
			case 2:
				MODE = MODES.PARALLEL_BRUTEFORCE;
				break;
			default:
				MODE = MODES.SEQUENTIAL_BACKTRACKING;
				break;
			}
		}
		if (args.length == 3) {
			kernel = Integer.parseInt(args[2]);
			System.out.println(MODE);
		}
		printTitle();
		if (MODE.equals(MODES.SEQUENTIAL_BACKTRACKING)) {
			runSequentialBackTracking(fileName);
		} else if (MODE.equals(MODES.SEQUENTIAL_BRUTEFORCE)) {
			runSequentialBruteForce(fileName);
		} else if (MODE.equals(MODES.PARALLEL_BRUTEFORCE)) {
			runParallelBruteForce(fileName, kernel);
		} else {
			System.out.print("Incorrect Option for Algorithm!");
		}
	}

	public static void runSequentialBruteForce(String fileName) throws CloneNotSupportedException {
		SudokuBoard board;
		try {
			board = new SudokuBoard(fileName);
			System.out
					.println("************************************* INPUT GRID *************************************");
			System.out.println("Initialzie empty cells: " + board.get_INIT_NUM_EMPTY_CELLS());
			System.out.println("BOX_SIZE: " + board.get_BOX_SIZE());
			board.printBoard(board);
			System.out.println("Total number cells: " + board.getNumTotalCells());
			SequentialBruteForce solver = new SequentialBruteForce(board, true);
			long begin = System.currentTimeMillis();
			solver.solve();
			long end = System.currentTimeMillis();
			System.out.println("Print in main");
			double time = (double) (end - begin) / 1e3;
			board.printBoard(solver.getSolution());
			System.out.println("[Solved in " + time + " seconds]");
		} catch (IOException e) {
			System.out.println(e.getMessage());

		}
	}

	public static void runSequentialBackTracking(String fileName) throws IOException {
		Vector<Double> logTime = new Vector<Double>();
		for (int i = 0; i < 100; i++) {
			String tempFile = fileName + "_v" + Integer.toString(i) + ".txt";
			SudokuBoard board = new SudokuBoard(tempFile);
			System.out.println("************************************* INPUT GRID *************************************");
			System.out.println("Initialzie empty cells: " + board.get_INIT_NUM_EMPTY_CELLS());
			board.printBoard(board);
			SequentialBackTracking solver = new SequentialBackTracking(board, true);
			long begin = System.currentTimeMillis();
			solver.solve();
			long end = System.currentTimeMillis();
			double time = (double) (end - begin) / 1e3;
			System.out.println("************************************* OUTPUT GRID *************************************");
			board.printBoard(solver.getSolution(), true);
			System.out.println("[Solved in " + time + " seconds]");
			logTime.add(time);
		}
		double sum = 0;
		for (int i = 0; i < logTime.size(); i++) {
			System.out.printf("Test %d: %.4fs%n", i, logTime.elementAt(i));
			sum += logTime.elementAt(i);
		}
		
		System.out.printf("Average time: %4fs%n" , sum/logTime.size());
	}

	public static void runParallelBruteForce(String fileName, int kernel) throws CloneNotSupportedException {
		Vector<Double> logTime = new Vector<Double>();
		for (int i = 0; i < 100; i++) {
			SudokuBoard board;
			try {
				String tempFile = fileName + "_v" + Integer.toString(i) + ".txt";
				board = new SudokuBoard(tempFile);
				System.out
						.println("************************************* INPUT GRID *************************************");
				System.out.println("BOX_SIZE: " + board.get_BOX_SIZE());
				board.printBoard(board);
				System.out.println("Total number cells: " + board.getNumTotalCells());
				System.out.println("Initialzie empty cells: " + board.get_INIT_NUM_EMPTY_CELLS());
				System.out.println("File name " + tempFile);
				ParallelBruteForce solver = new ParallelBruteForce(board, true, kernel);
				System.out.println("************************************* OUTPUT GRID *************************************");
				long begin = System.currentTimeMillis();
				solver.solve();
				long end = System.currentTimeMillis();
				double time = (double) (end - begin) / 1e3;
				System.out.println("Total number of solution: " + solver.getNumberOfSolutions());
				System.out.println("[Solved in " + time + " seconds]");
				logTime.add(time);
			} catch (IOException e) {
				System.out.println(e.getMessage());

			}
		}
		double sum = 0;
		for (int i = 0; i < logTime.size(); i++) {
			System.out.printf("Test %d: %.4fs%n", i, logTime.elementAt(i));
			sum += logTime.elementAt(i);
		}
		
		System.out.printf("Average time: %4fs%n" , sum/logTime.size());
	}

	public static void printTitle() {
		System.out.println("\n"
				+ "███████╗██╗   ██╗██████╗  ██████╗ ██╗  ██╗██╗   ██╗    ███████╗ ██████╗ ██╗    ██╗   ██╗███████╗██████╗ \n"
				+ "██╔════╝██║   ██║██╔══██╗██╔═══██╗██║ ██╔╝██║   ██║    ██╔════╝██╔═══██╗██║    ██║   ██║██╔════╝██╔══██╗\n"
				+ "███████╗██║   ██║██║  ██║██║   ██║█████╔╝ ██║   ██║    ███████╗██║   ██║██║    ██║   ██║█████╗  ██████╔╝\n"
				+ "╚════██║██║   ██║██║  ██║██║   ██║██╔═██╗ ██║   ██║    ╚════██║██║   ██║██║    ╚██╗ ██╔╝██╔══╝  ██╔══██╗\n"
				+ "███████║╚██████╔╝██████╔╝╚██████╔╝██║  ██╗╚██████╔╝    ███████║╚██████╔╝███████╗╚████╔╝ ███████╗██║  ██║\n"
				+ "╚══════╝ ╚═════╝ ╚═════╝  ╚═════╝ ╚═╝  ╚═╝ ╚═════╝     ╚══════╝ ╚═════╝ ╚══════╝ ╚═══╝  ╚══════╝╚═╝  ╚═╝\n");
	}
}
