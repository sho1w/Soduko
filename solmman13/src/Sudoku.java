/**
 * this class represents a sudoku game and checks if its valid.
 * @author Ahmed shomali
 * @version 12/10/21
 */
public class Sudoku {
	Square3x3[][] _sudoku;
	private final int _SQUARE_SIZE = 3, _SUDOKU_SIZE = 10;
	/**
	 *  Constructs and initializes a 3-dimensional array of the objects Square3x3, with the values of -1 in eachg cell.
	 */
	public Sudoku() {
		_sudoku = new Square3x3[_SQUARE_SIZE][_SQUARE_SIZE];
		for (int i = 0; i < _sudoku.length; i++) {
			for (int j = 0; j < _sudoku[i].length; j++) {
				Square3x3 temp = new Square3x3();
				_sudoku[i][j] = temp;
			}
		}
	}
	/**
	 * Copy constructor. Construct a 3-dimensional array of the size 3X3
	 * @param square3x3Array the array to copy
	 */
	public Sudoku(Square3x3[][] square3x3Array) {
		_sudoku = new Square3x3 [_SQUARE_SIZE][_SQUARE_SIZE];
		for (int i = 0; i < _sudoku.length; i++) {
			for (int j = 0; j < _sudoku[i].length; j++) {
				Square3x3 temp = new Square3x3(square3x3Array[i][j]);
				_sudoku[i][j] = temp;
			}
		}
	}
	/**
	 * Return true if the Sudoku board is legal and false otherwise
	 * @return true if the Sudoku board is legal and false otherwise
	 */
public boolean isValid() {
		//Check if the box's are valid
		for (int i = 0; i < _sudoku.length; i++)
			for (int j = 0; j < _sudoku[i].length; j++)
				if (_sudoku[i][j].allThere() == false)
					return false;
		//Check if each row is valid 
		for (int row = 0; row < _sudoku.length; row++) {
			//The _sudoku's row (three Square3x3) values
			boolean[] row0Value = new boolean[_SUDOKU_SIZE];
			boolean[] row1Value = new boolean[_SUDOKU_SIZE];
			boolean[] row2Value = new boolean[_SUDOKU_SIZE];
			//Go over each col (three Square3x3) in the _sudoku
			for (int col = 0; col < _sudoku[row].length; col++) {
				//Go over each row of the square
				for(int squareRow = 0; squareRow < _SQUARE_SIZE; squareRow++) {
					boolean[] values = new boolean[_SUDOKU_SIZE];
					_sudoku[row][col].whosThereRow(squareRow, values);
					//Go over values in the boolean array and save the numbers in the rowValue
					for (int i = 1; i < values.length; i++) {
						if (values[i] == true) {
							if (squareRow == 0) {
								//if the number appeared in this row
								if (row0Value[i] == true)
									return false;
								//If the number didn't appear before
								else
									row0Value[i] = true;
							}
							if (squareRow == 1) {
								//If the number appeared in this row
								if (row1Value[i] == true)
									return false;
								//If the number didn't appear before
								else
									row1Value[i] = true;
								
							}
							if (squareRow == 2) {
								//If the number appeared in this row
								if (row2Value[i] == true)
									return false;
								//If the number didn't appear before
								else
									row2Value[i] = true;
							}
						}
					}
				}
			}
			//Check if all the values in the rowValue are true, if not return false
			for (int check = 1; check < row0Value.length; check++) {
				if (row0Value[check] == false)
					return false;
				if (row1Value[check] == false)
				return false;
				if (row2Value[check] == false)
				return false;
			}
			//Change all the values back to false
			for (int update = 1; update < row0Value.length; update++) {
				row0Value[update] = false;
				row1Value[update] = false;
				row2Value[update] = false;
			}
		}
		
		//Check if each colmun is valid 
		for (int col = 0; col < _sudoku[0].length; col++) {
			//The _sudoku's column  values
			boolean[] col0Value = new boolean[_SUDOKU_SIZE];
			boolean[] col1Value = new boolean[_SUDOKU_SIZE];
			boolean[] col2Value = new boolean[_SUDOKU_SIZE];
			//Goes over each row  in the _sudoku
			for (int row = 0; row < _sudoku.length; row++) {
				//Goes  over each column of the square
				for(int squareCol = 0; squareCol < _SQUARE_SIZE; squareCol++) {
					boolean[] values = new boolean[_SUDOKU_SIZE];
					_sudoku[row][col].whosThereCol(squareCol, values);
					//Go over values in the boolean array and save the numbers in the ColValue 
					for (int i = 1; i < values.length; i++) {
						if (values[i] == true) {
							if (squareCol == 0) {
								//if the number appear in this row
								if (col0Value[i] == true)
									return false;
								//if the number didn't appear before
								else
									col0Value[i] = true;
							}
							if (squareCol == 1) {
								//if the number appeared in this row
								if (col1Value[i] == true)
									return false;
								//if the number didn't appeared before
								else
									col1Value[i] = true;
							}
							if (squareCol ==2) {
								//if the number appeared in this row
								if (col2Value[i] == true)
									return false;
								//if the number didn't appeared before
								else
									col2Value[i] = true;
							}
						}
					}
				}
			}
			//Check if all the values in the ColValue are true, if not return false
			for (int check = 1; check < col0Value.length; check++) {
				if (col0Value[check] == false)
					return false;
				if (col1Value[check] == false)
					return false;
				if (col2Value[check] == false)
					return false;
			}
			//Change all the values back to false
			for (int update = 1; update < col0Value.length; update++) {
				col0Value[update] = false;
				col1Value[update] = false;
				col2Value[update] = false;
			}
		}
		
		return true;
	}
}
