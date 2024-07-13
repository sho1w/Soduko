/**
 * this class represents a quadratic 2D array of integers in a 3x3 size
 * @author Ahmed shomali
 * @version 12/10/21
 */
public class Square3x3 {
	private final int SIZE_ROW =3;
	private final int SIZE_COL =3;
	private int [][] _square;
	/**
	 * Constructor for objects of class Square3X3. Constructs and initializes a 2-dimensional 
	 * array of the size 3X3, with the values of –1 in each cell.
	 */
	public Square3x3() {
		_square = new int [SIZE_ROW][SIZE_COL];
		for (int i=0; i < SIZE_ROW;i++)
			for (int j = 0; j < SIZE_COL; j++)
				_square[i][j] = -1;
	}
	/**
	 * Constructs a 2-dimensional array of the size 3X3, whose values are taken from the given
	 * array. If the given array’s size is bigger than 3X3, only the first 3X3 cells are taken. If the
	 * given array is smaller, the rest of the cells are initialized to –1
	 * @param given array to create board from
	 */
	public Square3x3(int[][]array) {
		_square = new int [SIZE_ROW][SIZE_COL];
		for(int i=0; i < _square.length; i++ ) {
			for  (int j=0; j < _square[i].length; j++){
				if (i >= array.length)
					_square[i][j] = -1;
				else {
					if (j >= array[i].length)
						_square[i][j] = -1;
					else
						_square[i][j] = array[i][j];
				
				}
			}
		}
	}
	/**
	 * Copy constructor. Constructs a 2-dimensional array of the size 3X3, whose values are
	 * taken from the array of the given Square3x3 object. 
	 * @param other the square to copy 
	 */
	public Square3x3(Square3x3 other) {
		_square = new int[SIZE_ROW][SIZE_COL];
				if (other == null) {
					System.out.println("error");
					return;
				}
				for (int i=0; i < other._square.length; i++) {
					for (int j=0; j < other._square[i].length; j++) {
					_square[i][j] = other._square[i][j];
				}
			}
	}
	/**
	 * Returns a String representation of the array.
	 */
	public String toString() {
		String cell = "";
		for (int i=0; i < _square.length; i++) {
			for (int j=0; j < _square[i].length; j++) {
				cell = cell + _square[i][j];
				if (j < _square.length -1)
					cell = cell + "\t";
			   }
			if (i < _square[i].length -1)
				cell = cell + "\n";
			}
		return cell;
		}
	/**
	 * Returns the value in the (row, column) cell. If the row and/or column are out of the array bounds, returns –1. 
	 * @param row the row
	 * @param col the column
	 * @return the value in the (row, column) cell. If the row and/or column are out of the array bounds, returns –1.
	 */
	public int getCell(int row, int col) {
		if (row < 0 || col < 0 || row >= _square.length || col >= _square[0].length)
			return -1;
		else
			return _square[row][col];
	}
	/**
	 * Sets the cell (row, column) in the array to the given value. 
	 * @param row the row
	 * @param col the column
	 * @param value the given value
	 */
	public void setXY(int row, int col, int value) {
		if (row >= 0 && row < _square.length && col >= 0 && col < _square[0].length)
			_square[row][col] = value;
	}
	/**
	 * Return true if all the numbers 1-9 are in the array, if not returns false
	 * @return true if all the numbers 1-9 are in the array, if not returns false
	 */
	public boolean allThere() {
		boolean[] tester = new boolean[10]; 
		for (int i = 0; i < _square.length; i++) {
			for (int j = 0; j < _square[i].length; j++) {
				if (_square[i][j] < 1 || _square[i][j] > 9)
					return false;
				else {
					if (tester[_square[i][j]] == false)
						tester[_square[i][j]] = true;
					else
						return false;
				}
			}
		}
		return true;
	}
	/**
	 * i forgor 2 cchanage wow
	 * @param row the row to check
	 * @param values the value
	 */
	public void whosThereRow(int row,boolean[] values) {
        for(int i=0;i<SIZE_ROW;i++) {
            int num =_square[row][i];
            if(num>=1&&num<=9)
                values[num]=true;
        }
    }
	/**
	 * @param col the column to check
	 * @param values the value
	 */
	public void whosThereCol(int col, boolean[] values) {
		for(int j=0;j<SIZE_COL;j++) {
            int num =_square[j][col];
            if(num>=1&&num<=9)
                values[num]=true;
        }
	}
}
