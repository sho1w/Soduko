/**
 * this is a gui tester of the soduku class 
 * @author ahmed shomali
 * @version 12/18/2021
 */
import javax.swing.*;
import javax.swing.text.*;

import java.awt.*;
import java.awt.event.*;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Random;

public class Maman13GuiTester {

    private JFrame frmTester;
    private JTextField[][] txtSudoku = new JTextField[9][9];
    private boolean changed = false;
    private static final int[][][] validPresets = { //#region
            { 
                {8, 4, 5, 6, 3, 2, 1, 7, 9},
                {7, 3, 2, 9, 1, 8, 6, 5, 4},
                {1, 9, 6, 7, 4, 5, 3, 2, 8},
                {6, 8, 3, 5, 7, 4, 9, 1, 2},
                {4, 5, 7, 2, 9, 1, 8, 3, 6},
                {2, 1, 9, 8, 6, 3, 5, 4, 7},
                {3, 6, 1, 4, 2, 9, 7, 8, 5},
                {5, 7, 4, 1, 8, 6, 2, 9, 3},
                {9, 2, 8, 3, 5, 7, 4, 6, 1}
            }, {
                {6, 7, 5, 9, 4, 8, 2, 1, 3},
                {3, 2, 8, 1, 6, 5, 9, 7, 4},
                {1, 4, 9, 7, 3, 2, 5, 6, 8},
                {2, 9, 1, 3, 5, 7, 4, 8, 6},
                {4, 8, 6, 2, 9, 1, 7, 3, 5},
                {5, 3, 7, 6, 8, 4, 1, 2, 9},
                {8, 1, 4, 5, 2, 3, 6, 9, 7},
                {9, 5, 2, 8, 7, 6, 3, 4, 1},
                {7, 6, 3, 4, 1, 9, 8, 5, 2}
            }, {
                {2, 9, 4, 8, 6, 3, 5, 1, 7},
                {7, 1, 5, 4, 2, 9, 6, 3, 8},
                {8, 6, 3, 7, 5, 1, 4, 9, 2},
                {1, 5, 2, 9, 4, 7, 8, 6, 3},
                {4, 7, 9, 3, 8, 6, 2, 5, 1},
                {6, 3, 8, 5, 1, 2, 9, 7, 4},
                {9, 8, 6, 1, 3, 4, 7, 2, 5},
                {5, 2, 1, 6, 7, 8, 3, 4, 9},
                {3, 4, 7, 2, 9, 5, 1, 8, 6}
            }, {
                {8, 4, 1, 3, 6, 5, 7, 9, 2},
                {7, 3, 6, 2, 9, 4, 8, 1, 5},
                {5, 2, 9, 1, 8, 7, 6, 3, 4},
                {2, 8, 5, 6, 7, 1, 3, 4, 9},
                {6, 9, 7, 4, 3, 2, 1, 5, 8},
                {4, 1, 3, 8, 5, 9, 2, 6, 7},
                {1, 7, 2, 5, 4, 3, 9, 8, 6},
                {3, 5, 8, 9, 2, 6, 4, 7, 1},
                {9, 6, 4, 7, 1, 8, 5, 2, 3}
            }, {
                {1, 3, 2, 6, 4, 9, 7, 8, 5},
                {7, 5, 8, 2, 1, 3, 6, 4, 9},
                {9, 6, 4, 7, 8, 5, 1, 2, 3},
                {5, 4, 3, 8, 9, 7, 2, 1, 6},
                {2, 7, 6, 5, 3, 1, 8, 9, 4},
                {8, 9, 1, 4, 2, 6, 5, 3, 7},
                {6, 1, 9, 3, 7, 8, 4, 5, 2},
                {3, 2, 7, 1, 5, 4, 9, 6, 8},
                {4, 8, 5, 9, 6, 2, 3, 7, 1}
            }
    }; //#endregion

    private static final int[][][] invalidPresets = { //#region
        {
            {1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1}
        }, {
            {1, 2, 3, 4, 5, 6, 7, 8, 9},
            {2, 3, 4, 5, 6, 7, 8, 9, 1},
            {3, 4, 5, 6, 7, 8, 9, 1, 2},
            {4, 5, 6, 7, 8, 9, 1, 2, 3},
            {5, 6, 7, 8, 9, 1, 2, 3, 4},
            {6, 7, 8, 9, 1, 2, 3, 4, 5},
            {7, 8, 9, 1, 2, 3, 4, 5, 6},
            {8, 9, 1, 2, 3, 4, 5, 6, 7},
            {9, 1, 2, 3, 4, 5, 6, 7, 8}
        }, {
            {1, 2, 3, 1, 2, 3, 1, 2, 3},
            {4, 5, 6, 4, 5, 6, 4, 5, 6},
            {7, 8, 9, 7, 8, 9, 7, 8, 9},
            {1, 2, 3, 1, 2, 3, 1, 2, 3},
            {4, 5, 6, 4, 5, 6, 4, 5, 6},
            {7, 8, 9, 7, 8, 9, 7, 8, 9},
            {1, 2, 3, 1, 2, 3, 1, 2, 3},
            {4, 5, 6, 4, 5, 6, 4, 5, 6},
            {7, 8, 9, 7, 8, 9, 7, 8, 9},
        }, {
            { 5, 3, 4, 5, 6, 7, 1, 1, 8 },
            { 9, 1, 9, 8, 8, 5, 1, 8, 7 },
            { 1, 5, 1, 5, 9, 7, 2, 4, 9 },
            { 1, 7, 5, 6, 3, 4, 6, 8, 2 },
            { 5, 8, 2, 4, 2, 8, 7, 9, 1 },
            { 5, 5, 7, 2, 7, 5, 2, 5, 9 },
            { 2, 6, 2, 2, 3, 4, 9, 5, 2 },
            { 5, 2, 5, 9, 3, 8, 7, 4, 4 },
            { 2, 7, 3, 3, 1, 3, 2, 8, 9 }
        }, {
            { 9, 6, 7, 7, 5, 3, 9, 7, 5 },
            { 7, 9, 9, 8, 7, 2, 8, 7, 2 },
            { 6, 5, 6, 3, 8, 2, 6, 1, 2 },
            { 2, 8, 3, 8, 6, 8, 9, 4, 4 },
            { 2, 3, 2, 3, 4, 6, 5, 1, 9 },
            { 5, 8, 1, 8, 7, 6, 7, 9, 1 },
            { 7, 9, 9, 8, 5, 9, 2, 9, 1 },
            { 6, 9, 5, 9, 2, 1, 8, 9, 5 },
            { 6, 9, 4, 3, 9, 3, 2, 5, 7 }
        }
    };//#endregion
    
    // =========== Main ===============

    public static void main(String[] args) {
        Maman13GuiTester window = new Maman13GuiTester();
        window.frmTester.setVisible(true);
    }

    // ============ Initialization ============
/**
 * 
 */
    public Maman13GuiTester() {
        initialize();
    }
/**
 * 
 */
    private void initialize() {
        frmTester = new JFrame();
        frmTester.setTitle("Sudoku Tester");
        frmTester.setBounds(100, 100, 640, 480);
        frmTester.setLocationRelativeTo(null);
        frmTester.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmTester.getContentPane().setLayout(new BorderLayout(0, 0));
        
        JComboBox<String> cmbPresets = new JComboBox<>();
        cmbPresets.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int i = cmbPresets.getSelectedIndex();
                if (i == -1) return;
                fillPreset(i);
            }
        });
        fillCmbPresets(cmbPresets);
        cmbPresets.setSelectedIndex(-1);
        frmTester.getContentPane().add(cmbPresets, BorderLayout.NORTH);
        
        JPanel pnlSudoku = new JPanel();
        pnlSudoku.setBackground(Color.BLACK);
        frmTester.getContentPane().add(pnlSudoku);
        pnlSudoku.setLayout(new GridLayout(3, 3, 2, 2));
        fillSudoku(pnlSudoku);
        
        JMenuBar menuBar = new JMenuBar();
        fillMenu(menuBar);
        frmTester.setJMenuBar(menuBar);
    }
    /**
     * 
     * @param pnl
     */
    private void fillSudoku(JPanel pnl) {
        final Font FONT_DEF = new JTextField().getFont();
        Font font = FONT_DEF.deriveFont(Math.max(FONT_DEF.getSize2D(), 30f));
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                JPanel panel = new JPanel(new GridLayout(3, 3, 2, 2));
                panel.setBackground(Color.GRAY);
                for (int i = 0; i < 9; i++) {
                    JTextField txt = new JTextField();
                    txt.setFont(font);
                    txt.setBackground(Color.WHITE);
                    txt.setHorizontalAlignment(JTextField.CENTER);
                    txt.setBorder(null);
                    ((PlainDocument)txt.getDocument()).setDocumentFilter(intFilterChange);
                    panel.add(txt);
                    txtSudoku[r*3 + i/3][c*3 + i%3] = txt;
                }
                pnl.add(panel);
            }
        }
    }
    
    private void fillCmbPresets(JComboBox<String> cmbPresets) {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        for(int i = 1; i <= validPresets.length; i++) {
            model.addElement("Valid Preset " + i);
        }
        for(int i = 1; i <= invalidPresets.length; i++) {
            model.addElement("Invalid Preset " + i);
        }
        cmbPresets.setModel(model);
    }
    
    private void fillMenu(JMenuBar menuBar) {
        // ======== File ===========
        JMenu mnFile = new JMenu("File");
        menuBar.add(mnFile);
        
        JMenuItem mntmFileNew = new JMenuItem("New Sudoku");
        mntmFileNew.setToolTipText("Create a new board with all values empty.");
        mntmFileNew.addActionListener(e -> fileNew());
        mnFile.add(mntmFileNew);

        mnFile.add(new JSeparator());
        
        JMenuItem mntmFileRow = new JMenuItem("Check Row");
        mntmFileRow.setToolTipText("Apply the 'whosThereRow()' method on a full "
            + "9 cell row, and show the contents of the boolean array in a message.");
        addMenuItemListener(mntmFileRow, e -> fileRow());
        mnFile.add(mntmFileRow);
        
        JMenuItem mntmFileCol = new JMenuItem("Check Column");
        mntmFileCol.setToolTipText("Apply the 'whosThereCol()' method on a full "
        + "9 cell column, and show the contents of the boolean array in a message.");
        addMenuItemListener(mntmFileCol, e -> fileCol());
        mnFile.add(mntmFileCol);

        mnFile.add(new JSeparator());
        
        JMenuItem mntmFileExit = new JMenuItem("Exit");
        mntmFileExit.setToolTipText("Exit the application.");
        mntmFileExit.addActionListener(e -> frmTester.dispose());
        mnFile.add(mntmFileExit);
        
        // ============== Square ================
        JMenu mnSquare = new JMenu("Square3x3");
        menuBar.add(mnSquare);
        
        JMenuItem mntmSqConstruct1 = new JMenuItem("Construct Empty Square");
        mntmSqConstruct1.setToolTipText("Construct a 3x3 sub-grid in the sudoku "
            + " grid using 'Square3x3()'.");
        //mntmSqConstruct1.addActionListener(e -> sqConstruct1());
        addMenuItemListener(mntmSqConstruct1, e -> sqConstruct1());
        mnSquare.add(mntmSqConstruct1);
        
        JMenuItem mntmSqConstruct2 = new JMenuItem("Construct int[][] Square");
        mntmSqConstruct2.setToolTipText("Construct a 3x3 sub-grid in the sudoku "
            + " grid using 'Square3x3(int[][])'.");
        addMenuItemListener(mntmSqConstruct2, e -> sqConstruct2());
        mnSquare.add(mntmSqConstruct2);
        
        JMenuItem mntmSqConstruct3 = new JMenuItem("Construct  Square");
        mntmSqConstruct3.setToolTipText("Construct a 3x3 sub-grid in the sudoku "
            + " grid using 'Square3x3(Square3x3)'.");
        addMenuItemListener(mntmSqConstruct3, e -> sqConstruct3());
        mnSquare.add(mntmSqConstruct3);

        mnSquare.add(new JSeparator());

        JMenuItem mntmSqGet = new JMenuItem("Get Cell");
        mntmSqGet.setToolTipText("Use the 'getCell()' method to show a cell's "
            + "contents in a message.");
        addMenuItemListener(mntmSqGet, e -> sqGet());
        mnSquare.add(mntmSqGet);
        
        JMenuItem mntmSqSet = new JMenuItem("Set XY");
        mntmSqSet.setToolTipText("Use the 'setXY()' method to change a cell's "
            + "contents.");
        addMenuItemListener(mntmSqSet, e -> sqSet());
        mnSquare.add(mntmSqSet);
        
        JMenuItem mntmSqAllThere = new JMenuItem("All There");
        mntmSqAllThere.setToolTipText("Apply the 'allThere()' method on a Square3x3 "
            + "and show the answer in a message.");
        addMenuItemListener(mntmSqAllThere, e -> sqAllThere());
        mnSquare.add(mntmSqAllThere);
        
        JMenuItem mntmSqRowThere = new JMenuItem("Who's There Row");
        mntmSqRowThere.setToolTipText("Apply the 'whosThereRow()' method on a 3 "
            + "cell row from a Square3x3 and show the boolean array in a message.");
        addMenuItemListener(mntmSqRowThere, e -> sqRowThere());
        mnSquare.add(mntmSqRowThere);
        
        JMenuItem mntmSqColThere = new JMenuItem("Who's There Col");
        mntmSqColThere.setToolTipText("Apply the 'whosThereCol()' method on a 3 "
            + "cell column from a Square3x3 and show the boolean array in a message.");
        addMenuItemListener(mntmSqColThere, e -> sqColThere());
        mnSquare.add(mntmSqColThere);

        mnSquare.add(new JSeparator());
        
        JMenuItem mntmSqToString = new JMenuItem("ToString");
        mntmSqToString.setToolTipText("Show the output of the 'toString()' "
            + "method in a message.");
        addMenuItemListener(mntmSqToString, e -> sqToString());
        mnSquare.add(mntmSqToString);
        
        // =========== Sudoku ==============
        JMenu mnSudoku = new JMenu("Sudoku");
        menuBar.add(mnSudoku);
        
        JMenuItem mntmSdConstruct1 = new JMenuItem("Construct Empty Sudoku");
        mntmSdConstruct1.setToolTipText("Does Nothings.");
        addMenuItemListener(mntmSdConstruct1, e -> sdConstruct1());
        mnSudoku.add(mntmSdConstruct1);
        /**
         * idk
         */
        JMenuItem mntmSdConstruct2 = new JMenuItem("Construct Sudoku ");
        mntmSdConstruct2.setToolTipText("Does Nothings.");
        addMenuItemListener(mntmSdConstruct2, e -> sdConstruct2());
        mnSudoku.add(mntmSdConstruct2);

        mnSudoku.add(new JSeparator());
        /**
         * idk
         */
        JMenuItem mntmSdIsValid = new JMenuItem("Is Valid");
        mntmSdIsValid.setToolTipText("Apply the 'isValid()' method on the Sudoku "
        + "grid and show the answer in a message.");
        addMenuItemListener(mntmSdIsValid, e -> sdIsValid());
        mnSudoku.add(mntmSdIsValid);

        // =========== Tests ==============
        JMenu mnTests = new JMenu("Tests");
        menuBar.add(mnTests);
        /**
         * idk
         */
        JMenuItem mntmTstIsValid = new JMenuItem("Test isValid()");
        addMenuItemListener(mntmTstIsValid, e -> tstIsValid());
        mntmTstIsValid.setToolTipText("Go over each preset and test the output "
            +  "of 'isValid()'.");
        mnTests.add(mntmTstIsValid);

        mnTests.add(new JSeparator());
        
        JMenuItem mntmTstGet = new JMenuItem("Test getCell()");
        addMenuItemListener(mntmTstGet, e -> tstGetCell());
        mntmTstGet.setToolTipText("Go over each cell of a 3x3 sub-grid and test "
            +  "if the method 'getCell()' returns the same cells as in the grid.");
        mnTests.add(mntmTstGet);
        
        JMenuItem mntmTstSet = new JMenuItem("Test setXY()");
        addMenuItemListener(mntmTstSet, e -> tstSetCell());
        mntmTstSet.setToolTipText("Go over each cell of a 3x3 sub-grid and test "
            +  "if the method 'setCell()' changes the right cells in the grid.");
        mnTests.add(mntmTstSet);

        mnTests.add(new JSeparator());
        
        JMenuItem mntmTstAllThere = new JMenuItem("Test allThere()");
        addMenuItemListener(mntmTstAllThere, e -> tstAllThere());
        mntmTstAllThere.setToolTipText("Go over each 3x3 sub-grid and test if the "
            +  "method 'allThere()' returns the correct answer.");
        mnTests.add(mntmTstAllThere);
        
        JMenuItem mntmTstRowThere = new JMenuItem("Test whosThereRow()");
        addMenuItemListener(mntmTstRowThere, e -> tstRowThere());
        mntmTstRowThere.setToolTipText("Go over each 3 cell row and test if the "
            +  "method 'whosThereRow()' returns the correct array.");
        mnTests.add(mntmTstRowThere);
        
        JMenuItem mntmTstColThere = new JMenuItem("Test whosThereCol()");
        addMenuItemListener(mntmTstColThere, e -> tstColThere());
        mntmTstColThere.setToolTipText("Go over each 3 cell column and test if the "
            +  "method 'whosThereCol()' returns the correct array.");
        mnTests.add(mntmTstColThere);

        mnTests.add(new JSeparator());
        
        JMenuItem mntmTstToString = new JMenuItem("Test toString()");
        addMenuItemListener(mntmTstToString, e -> tstToString());
        mntmTstToString.setToolTipText("Go over each 3x3 sub-grid and test if the "
            +  "method 'toString()' returns the correct string.");
        mnTests.add(mntmTstToString);
    }

    // =========== Actions =============

    private void fillPreset(int index) {
        if (!checkForChange()) return;
        
        int[][] preset;
        String title;

        if (index < validPresets.length) {
            preset = validPresets[index];
            title = "Sudoku Tester - Invalid Preset " + (index + 1);
        } else {
            index -= validPresets.length;
            preset = invalidPresets[index];
            title = "Sudoku Tester - Valid Preset " + (index + 1);
        }
        
        for(int r = 0; r < preset.length; r++) {
            for (int c = 0; c < preset[r].length; c++) {
                txtSudoku[r][c].setText("" + preset[r][c]);
            }
        }

        frmTester.setTitle(title);
        frmTester.setFont(frmTester.getFont().deriveFont(Font.PLAIN));
        changed = false;
    }

    private void change() {
        if (changed) return;
        changed = true;
        frmTester.setTitle(frmTester.getTitle() + " *");
        frmTester.setFont(frmTester.getFont().deriveFont(Font.BOLD));

        //check squares
    }
    /**
     * checks a change of a cell 
     * @return change
     */
    private boolean checkForChange() {
        if (!changed) return true;
        
        int res = JOptionPane.showConfirmDialog(frmTester,
                "The current sudoku will be erased!", "Are you sure?", JOptionPane.YES_NO_OPTION);
        changed = res != JOptionPane.YES_OPTION;
        return !changed;
    }

    // =========== Helpers ========
/**
 * returns true if the number between 1-9 else returns false
 * @param str the value	
 * @return true or false
 */
    private boolean isNum(String str) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!(Character.isDigit(c) || c == '-')) return false;
        }
        return true;
    }
/**
 * 
 * @param str 
 * @return
 */
    private int[][] parseIntArr(String str) {        
        String[] lines = str.split("\\r?\\n");
        int[][] arr = new int[lines.length][];
        for (int l = 0; l < lines.length; l++) {
            int i = 0;
            int[] temp = new int[lines[l].length()];
            int num = 0, sign = 1;
            for (int c = 0; c < lines[l].length(); c++) {
                char ch = lines[l].charAt(c);
                if (num == 0 && ch == '-') sign = -1;
                else if (Character.isDigit(ch)) num = num*10 + ch - '0';
                else if ((Character.isWhitespace(ch) || ch == ',') && num != 0) {
                        temp[i++] = num * sign;
                        num = 0;
                        sign = 1;
                    }
            }
            if (num != 0) temp[i++] = num * sign;
            arr[l] = new int[i];
            while (--i >= 0) arr[l][i] = temp[i];
        }
        
        return arr;
    }

    private Square3x3 getSquare(int row, int col) {
        StringBuilder builder = new StringBuilder(9+8+3);
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                String text = txtSudoku[row * 3 + r][col * 3 + c].getText();
                if (text.isEmpty() || text.isBlank()) text = "-1";
                builder.append(text).append(' ');
            }
            builder.append('\n');
        }
        return new Square3x3(parseIntArr(builder.toString()));
    }

    private void setSquare(Square3x3 square, int row, int col) {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                txtSudoku[row * 3 + r][col * 3 + c].setText(square.getCell(r, c) + "");
            }
        }
    }

    private String tabToSpaces(String str) {
        StringBuilder builder = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '\t') builder.append("    ");
            else builder.append(c);
        }
        
        return builder.toString();
    }

    private Sudoku getSudoku(int[][] preset) {
        Square3x3[][] grid = new Square3x3[3][3];

        for (int gr = 0; gr < 3; gr++) for (int gc = 0; gc < 3; gc++) {
            int[][] square = new int[3][3];
            for (int sr = 0; sr < 3; sr++) for (int sc = 0; sc < 3; sc++) {
                square[sr][sc] = preset[gr*3 + sr][gc*3 + sc];
            }
            grid[gr][gc] = new Square3x3(square);
        }

        return new Sudoku(grid);
        /**
         * 
         */
    }

    private boolean arrEquals(boolean[] arr, boolean[] arr2) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != arr2[i]) return false;
        }
        return true;
    }

    // =========== Listeners ============

    private void addMenuItemListener(JMenuItem item, ActionListener listener){
        item.addActionListener(e -> {
            try {
                listener.actionPerformed(e);
            } catch (Exception ex) {
                StringWriter writer = new StringWriter();
                ex.printStackTrace(new PrintWriter(writer));

                JTextArea txt = new JTextArea();
                txt.setRows(20);
                float font = Math.max(txt.getFont().getSize2D(), 14f);
                txt.setFont(txt.getFont().deriveFont(font));
                txt.setText("The tester crashed:\n" +  writer.toString());
                txt.setCaretPosition(0);
                txt.setEditable(false);

                JScrollPane pane = new JScrollPane(txt);

                JOptionPane.showMessageDialog(frmTester, pane, ex.getClass().getName(),
                    JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    private DocumentFilter intFilter = new DocumentFilter() { //#region
        @Override
        public void insertString(FilterBypass fb, int offset, String string,
                AttributeSet attr) throws BadLocationException {
            if (!isNum(string)) return;

            super.insertString(fb, offset, string, attr);
        }

        @Override
        public void remove(FilterBypass fb, int offset, int length)
                throws BadLocationException {
            super.remove(fb, offset, length);
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String text,
                AttributeSet attrs)throws BadLocationException {
            if (!isNum(text)) return;

            super.replace(fb, offset, length, text, attrs);
        }
    }; //#endregion
    
    private DocumentFilter intFilterChange = new DocumentFilter() { //#region
        @Override
        public void insertString(FilterBypass fb, int offset, String string,
                AttributeSet attr) throws BadLocationException {
            if (!isNum(string)) return;

            super.insertString(fb, offset, string, attr);
            change();
        }

        @Override
        public void remove(FilterBypass fb, int offset, int length)
                throws BadLocationException {
            super.remove(fb, offset, length);
            change();
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String text,
                AttributeSet attrs)throws BadLocationException {
            if (!isNum(text)) return;

            super.replace(fb, offset, length, text, attrs);
            change();
        }
    }; //#endregion

    private DocumentFilter squareFilter = new DocumentFilter() { //#region
        private boolean check(char c) {
            return Character.isWhitespace(c) || Character.isDigit(c) || c == '-'
                || c == ',';
        }
        private boolean check(String str) {
            for (int i = 0; i < str.length(); i++) {
                if (!check(str.charAt(i)))
                    return false;
            }
            return true;
        }

        @Override
        public void insertString(FilterBypass fb, int offset, String string,
                AttributeSet attr) throws BadLocationException {
            if (!check(string)) return;

            super.insertString(fb, offset, string, attr);
        }

        @Override
        public void remove(FilterBypass fb, int offset, int length)
                throws BadLocationException {
            super.remove(fb, offset, length);
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String text,
                AttributeSet attrs)throws BadLocationException {
            if (!check(text)) return;

            super.replace(fb, offset, length, text, attrs);
        }
    }; //#endregion

    // ========= File ==========
    
    private void fileNew() {
        if (!checkForChange()) return;
        frmTester.setTitle("Sudoku Tester - New");
        frmTester.setFont(frmTester.getFont().deriveFont(Font.PLAIN));
        
        for(int r = 0; r < txtSudoku.length; r++) {
            for (int c = 0; c < txtSudoku[r].length; c++) {
                txtSudoku[r][c].setText("");
            }
        }
    }
    /**
     * 
     * 
     */
    private void fileRow() {
        JPanel pnl = new JPanel();
        pnl.setLayout(new BoxLayout(pnl, BoxLayout.X_AXIS));

        JLabel lblRow = new JLabel("Row: ");
        pnl.add(lblRow);

        JTextField txtRow = new JTextField();
        ((PlainDocument)txtRow.getDocument()).setDocumentFilter(intFilter);
        pnl.add(txtRow);

        int res = JOptionPane.showConfirmDialog(frmTester, pnl,
            "Check whole row", JOptionPane.OK_CANCEL_OPTION);
        
        if (res != JOptionPane.OK_OPTION) return;
        int r = txtRow.getText().isBlank() ? -1 : Integer.parseInt(txtRow.getText());
        boolean[] values = { false, false, false, false, false, false, false,
            false, false, false };
        
        for (int c = 0; c < 3; c++) {
            getSquare(r / 3, c).whosThereRow(r % 3, values);
        }

        final int CAP = 10 * (1 + 2 + 5 + 1); //i + ": " + "false" + "\n"
        StringBuilder builder = new StringBuilder(CAP);
        for (int i = 0; i < values.length; i++){
            builder.append(i).append(": ").append(values[i]).append("\n");
        }
        
        JOptionPane.showMessageDialog(frmTester, builder.toString());
    }

    private void fileCol() {
        JPanel pnl = new JPanel();
        pnl.setLayout(new BoxLayout(pnl, BoxLayout.X_AXIS));

        JLabel lblCol = new JLabel("Column: ");
        pnl.add(lblCol);

        JTextField txtCol = new JTextField();
        ((PlainDocument)txtCol.getDocument()).setDocumentFilter(intFilter);
        pnl.add(txtCol);

        int res = JOptionPane.showConfirmDialog(frmTester, pnl,
            "Check whole column", JOptionPane.OK_CANCEL_OPTION);
        
        if (res != JOptionPane.OK_OPTION) return;
        int c = txtCol.getText().isBlank() ? -1 : Integer.parseInt(txtCol.getText());
        boolean[] values = { false, false, false, false, false, false, false,
            false, false, false };
        
        for (int r = 0; r < 3; r++) {
            getSquare(r, c / 3).whosThereCol(c % 3, values);
        }

        final int CAP = 10 * (1 + 2 + 5 + 1); //i + ": " + "false" + "\n"
        StringBuilder builder = new StringBuilder(CAP);
        for (int i = 0; i < values.length; i++){
            builder.append(i).append(": ").append(values[i]).append("\n");
        }
        
        JOptionPane.showMessageDialog(frmTester, builder.toString());}

    // ======== Square3x3 ========

    private void sqConstruct1() {
        JComboBox<String> cmb = new JComboBox<>( new String[] {
            "Top Left", "Top Middle", "Top Right", "Middle Left", "Middle",
            "Middle Right", "Bottom Left", "Bottom Middle", "Bottom Right"
        });
        int res = JOptionPane.showConfirmDialog(frmTester, cmb,
            "Which square to construct?", JOptionPane.OK_CANCEL_OPTION);
        
        if (res != JOptionPane.OK_OPTION) return;
        int r = cmb.getSelectedIndex() / 3, c = cmb.getSelectedIndex() % 3;
        
        setSquare(new Square3x3(), r, c);
    }

    private void sqConstruct2() {
        JPanel pnl = new JPanel();
        pnl.setLayout(new BoxLayout(pnl, BoxLayout.Y_AXIS));

        JComboBox<String> cmb = new JComboBox<>( new String[] {
            "Top Left", "Top Middle", "Top Right", "Middle Left", "Middle",
            "Middle Right", "Bottom Left", "Bottom Middle", "Bottom Right"
        });
        pnl.add(cmb);

        JLabel lbl = new JLabel("Input int[][] array for constructor.");
        pnl.add(lbl);

        JTextArea txt = new JTextArea();
        ((PlainDocument)txt.getDocument()).setDocumentFilter(squareFilter);
        txt.setText("1 2 3\n4 5\n6 7 8 9");
        txt.setRows(5);
        pnl.add(txt);

        int res = JOptionPane.showConfirmDialog(frmTester, pnl,
            "Square Construct", JOptionPane.OK_CANCEL_OPTION);
        
        if (res != JOptionPane.OK_OPTION) return;
        int row = cmb.getSelectedIndex() / 3, col = cmb.getSelectedIndex() % 3;
        
        setSquare(new Square3x3(parseIntArr(txt.getText())), row, col);
    }

    private void sqConstruct3() {
        JPanel pnl = new JPanel();
        pnl.setLayout(new BoxLayout(pnl, BoxLayout.Y_AXIS));
        
        JLabel lblFrom = new JLabel(":");
        pnl.add(lblFrom);

        JComboBox<String> cmbFrom = new JComboBox<>( new String[] {
            "Top Left", "Top Middle", "Top Right", "Middle Left", "Middle",
            "Middle Right", "Bottom Left", "Bottom Middle", "Bottom Right"
        });
        pnl.add(cmbFrom);
        
        JLabel lblTo = new JLabel("To:");
        pnl.add(lblTo);

        JComboBox<String> cmbTo = new JComboBox<>( new String[] {
            "Top Left", "Top Middle", "Top Right", "Middle Left", "Middle",
            "Middle Right", "Bottom Left", "Bottom Middle", "Bottom Right"
        });
        pnl.add(cmbTo);

        int res = JOptionPane.showConfirmDialog(frmTester, pnl,
            "Square Construct", JOptionPane.OK_CANCEL_OPTION);
        
        if (res != JOptionPane.OK_OPTION) return;
        int fr = cmbFrom.getSelectedIndex()/3, fc = cmbFrom.getSelectedIndex()%3;
        int tr = cmbTo.getSelectedIndex()/3, tc = cmbTo.getSelectedIndex()%3;
        
        setSquare(new Square3x3(getSquare(fr, fc)), tr, tc);
    }
    
    private void sqGet() {
        JPanel pnl = new JPanel();
        pnl.setLayout(new BoxLayout(pnl, BoxLayout.Y_AXIS));

        JComboBox<String> cmb = new JComboBox<>( new String[] {
            "Top Left", "Top Middle", "Top Right", "Middle Left", "Middle",
            "Middle Right", "Bottom Left", "Bottom Middle", "Bottom Right"
        });
        pnl.add(cmb);

        JPanel pnlRow = new JPanel();
        pnlRow.setLayout(new BoxLayout(pnlRow, BoxLayout.X_AXIS));
        pnl.add(pnlRow);

        JLabel lblRow = new JLabel("Row: ");
        pnlRow.add(lblRow);

        JTextField txtRow = new JTextField();
        ((PlainDocument)txtRow.getDocument()).setDocumentFilter(intFilter);
        pnlRow.add(txtRow);

        JLabel lblCol = new JLabel("Column: ");
        pnlRow.add(lblCol);

        JTextField txtCol = new JTextField();
        ((PlainDocument)txtCol.getDocument()).setDocumentFilter(intFilter);
        pnlRow.add(txtCol);

        int res = JOptionPane.showConfirmDialog(frmTester, pnl,
            "Get Cell", JOptionPane.OK_CANCEL_OPTION);
        
        if (res != JOptionPane.OK_OPTION) return;
        int row = cmb.getSelectedIndex() / 3, col = cmb.getSelectedIndex() % 3;
        int sr = txtRow.getText().isBlank() ? -1 : Integer.parseInt(txtRow.getText());
        int sc = txtCol.getText().isBlank() ? -1 : Integer.parseInt(txtCol.getText());
        
        JOptionPane.showMessageDialog(frmTester, getSquare(row, col).getCell(sr, sc));
    }
    
    private void sqSet() {
        JPanel pnl = new JPanel();
        pnl.setLayout(new BoxLayout(pnl, BoxLayout.Y_AXIS));

        JComboBox<String> cmb = new JComboBox<>( new String[] {
            "Top Left", "Top Middle", "Top Right", "Middle Left", "Middle",
            "Middle Right", "Bottom Left", "Bottom Middle", "Bottom Right"
        });
        pnl.add(cmb);

        JPanel pnlRow = new JPanel();
        pnlRow.setLayout(new BoxLayout(pnlRow, BoxLayout.X_AXIS));
        pnl.add(pnlRow);

        JLabel lblRow = new JLabel("Row: ");
        pnlRow.add(lblRow);

        JTextField txtRow = new JTextField();
        ((PlainDocument)txtRow.getDocument()).setDocumentFilter(intFilter);
        pnlRow.add(txtRow);

        JLabel lblCol = new JLabel("Column: ");
        pnlRow.add(lblCol);

        JTextField txtCol = new JTextField();
        ((PlainDocument)txtCol.getDocument()).setDocumentFilter(intFilter);
        pnlRow.add(txtCol);

        JPanel pnlRow2 = new JPanel();
        pnlRow2.setLayout(new BoxLayout(pnlRow2, BoxLayout.X_AXIS));
        pnl.add(pnlRow2);

        JLabel lblVal = new JLabel("Value : ");
        pnlRow2.add(lblVal);

        JTextField txtVal = new JTextField("");
        ((PlainDocument)txtVal.getDocument()).setDocumentFilter(intFilter);
        pnlRow2.add(txtVal);

        int res = JOptionPane.showConfirmDialog(frmTester, pnl,
            "Set XY", JOptionPane.OK_CANCEL_OPTION);
        
        if (res != JOptionPane.OK_OPTION) return;
        int row = cmb.getSelectedIndex() / 3, col = cmb.getSelectedIndex() % 3;
        int sr = txtRow.getText().isBlank() ? -1 : Integer.parseInt(txtRow.getText());
        int sc = txtCol.getText().isBlank() ? -1 : Integer.parseInt(txtCol.getText());
        int val = txtVal.getText().isBlank() ? -1 : Integer.parseInt(txtVal.getText());
        
        Square3x3 sq = getSquare(row, col);
        sq.setXY(sr, sc, val);
        setSquare(sq, row, col);
    }

    private void sqAllThere() {
        JComboBox<String> cmb = new JComboBox<>( new String[] {
            "Top Left", "Top Middle", "Top Right", "Middle Left", "Middle",
            "Middle Right", "Bottom Left", "Bottom Middle", "Bottom Right"
        });
        int res = JOptionPane.showConfirmDialog(frmTester, cmb,
            "All There", JOptionPane.OK_CANCEL_OPTION);
        
        if (res != JOptionPane.OK_OPTION) return;
        int r = cmb.getSelectedIndex() / 3, c = cmb.getSelectedIndex() % 3;
        
        JOptionPane.showMessageDialog(frmTester,  getSquare(r, c).allThere(),
            "All There", JOptionPane.PLAIN_MESSAGE);
    }

    private void sqRowThere() {
        JPanel pnl = new JPanel();
        pnl.setLayout(new BoxLayout(pnl, BoxLayout.Y_AXIS));

        JComboBox<String> cmb = new JComboBox<>( new String[] {
            "Top Left", "Top Middle", "Top Right", "Middle Left", "Middle",
            "Middle Right", "Bottom Left", "Bottom Middle", "Bottom Right"
        });
        pnl.add(cmb);

        JPanel pnlRow = new JPanel();
        pnlRow.setLayout(new BoxLayout(pnlRow, BoxLayout.X_AXIS));
        pnl.add(pnlRow);

        JLabel lblRow = new JLabel("Row: ");
        pnlRow.add(lblRow);

        JTextField txtRow = new JTextField();
        ((PlainDocument)txtRow.getDocument()).setDocumentFilter(intFilter);
        pnlRow.add(txtRow);

        int res = JOptionPane.showConfirmDialog(frmTester, pnl,
            "Who's There Row", JOptionPane.OK_CANCEL_OPTION);
        
        if (res != JOptionPane.OK_OPTION) return;
        int row = cmb.getSelectedIndex() / 3, col = cmb.getSelectedIndex() % 3;
        int sr = txtRow.getText().isBlank() ? -1 : Integer.parseInt(txtRow.getText());
        boolean[] values = { false, false, false, false, false, false, false,
            false, false, false };
        getSquare(row, col).whosThereRow(sr, values);

        final int CAP = 10 * (1 + 2 + 5 + 1); //i + ": " + "false" + "\n"
        StringBuilder builder = new StringBuilder(CAP);
        for (int i = 0; i < values.length; i++){
            builder.append(i).append(": ").append(values[i]).append("\n");
        }
        
        JOptionPane.showMessageDialog(frmTester, builder.toString());
    }

    private void sqColThere() {
        JPanel pnl = new JPanel();
        pnl.setLayout(new BoxLayout(pnl, BoxLayout.Y_AXIS));

        JComboBox<String> cmb = new JComboBox<>( new String[] {
            "Top Left", "Top Middle", "Top Right", "Middle Left", "Middle",
            "Middle Right", "Bottom Left", "Bottom Middle", "Bottom Right"
        });
        pnl.add(cmb);

        JPanel pnlRow = new JPanel();
        pnlRow.setLayout(new BoxLayout(pnlRow, BoxLayout.X_AXIS));
        pnl.add(pnlRow);

        JLabel lblCol = new JLabel("Column: ");
        pnlRow.add(lblCol);

        JTextField txtCol = new JTextField();
        ((PlainDocument)txtCol.getDocument()).setDocumentFilter(intFilter);
        pnlRow.add(txtCol);

        int res = JOptionPane.showConfirmDialog(frmTester, pnl,
            "Who's There Column", JOptionPane.OK_CANCEL_OPTION);
        
        if (res != JOptionPane.OK_OPTION) return;
        int row = cmb.getSelectedIndex() / 3, col = cmb.getSelectedIndex() % 3;
        int sc = txtCol.getText().isBlank() ? -1 : Integer.parseInt(txtCol.getText());
        boolean[] values = { false, false, false, false, false, false, false,
            false, false, false };
        getSquare(row, col).whosThereCol(sc, values);

        final int CAP = 10 * (1 + 2 + 5 + 1); //i + ": " + "false" + "\n"
        StringBuilder builder = new StringBuilder(CAP);
        for (int i = 0; i < values.length; i++){
            builder.append(i).append(": ").append(values[i]).append("\n");
        }
        
        JOptionPane.showMessageDialog(frmTester, builder.toString());
    }

    private void sqToString() {
        JComboBox<String> cmb = new JComboBox<>( new String[] {
            "Top Left", "Top Middle", "Top Right", "Middle Left", "Middle",
            "Middle Right", "Bottom Left", "Bottom Middle", "Bottom Right"
        });

        int res = JOptionPane.showConfirmDialog(frmTester, cmb,
            "ToString", JOptionPane.OK_CANCEL_OPTION);
        
        if (res != JOptionPane.OK_OPTION) return;
        int row = cmb.getSelectedIndex() / 3, col = cmb.getSelectedIndex() % 3;

        String str = tabToSpaces(getSquare(row, col).toString());
        
        JOptionPane.showMessageDialog(frmTester, str);
    }

    // ========== Sudoku ============

    private void sdConstruct1() {
        JOptionPane.showMessageDialog(frmTester, "I have no idea how to check this.");
    }

    private void sdConstruct2() {
        JOptionPane.showMessageDialog(frmTester, "I have no idea how to check this.");}

    private void sdIsValid() {
        Square3x3[][] grid = new Square3x3[3][3];
        for (int r = 0; r < 3; r++) for (int c = 0; c < 3; c++) {
            grid[r][c] = getSquare(r, c);
        }

        Sudoku sudoku = new Sudoku(grid);
        JOptionPane.showMessageDialog(frmTester, sudoku.isValid());
    }

    // ============ Tests ===========

    private void tstIsValid() {
        StringBuilder builder = new StringBuilder();
        boolean success = true;

        for (int i = 0; i < validPresets.length; i++) {
            int[][] preset = validPresets[i];
            Sudoku sudoku = getSudoku(preset);
            builder.append("Testing Preset ").append(i+1).append(": ");
            boolean expected = true;
            boolean actual = sudoku.isValid();
            if (actual == expected) builder.append("OK\n");
            else {
                builder.append("ERROR - expected: ").append(expected)
                    .append(", actual: ").append(actual).append('\n');
                success = false;
            }
        }

        for (int i = 0; i < invalidPresets.length; i++) {
            int[][] preset = invalidPresets[i];
            Sudoku sudoku = getSudoku(preset);
            builder.append("Testing Invalid Preset ").append(i+1).append(": ");
            boolean expected = false;
            boolean actual = sudoku.isValid();
            if (actual == expected) builder.append("OK\n");
            else {
                builder.append("ERROR - expected: ").append(expected)
                    .append(", actual: ").append(actual).append('\n');
                success = false;
            }
        }

        int type = success ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE;
        String title = "isValid() Test " + (success ? "Passed!" : "Failed!");
        JOptionPane.showMessageDialog(frmTester, builder.toString(), title, type);
    }

    private void tstGetCell() {
        StringBuilder builder = new StringBuilder();
        boolean success = true;
        for (int gr = 0; gr < 3; gr++) for (int gc = 0; gc < 3; gc++) {
            Square3x3 square = getSquare(gr, gc);
            builder.append("Testing Square [").append(gr).append("][").append(gc)
                .append("]: \n");
            int index = builder.length() - 1;
            boolean squareOk = true;

            for (int sr = 0; sr < 3; sr++) for (int sc = 0; sc < 3; sc++) {
                builder.append("    Testing Cell [").append(sr).append("][").append(sc)
                .append("]: ");
                String txt = txtSudoku[gr * 3 + sr][gc * 3 + sc].getText();
                int expected = txt.isBlank() ? -1 : Integer.parseInt(txt);
                int actual = square.getCell(sr, sc);
                if (expected == actual) builder.append("OK\n");
                else {
                    builder.append("ERROR - expected: ").append(expected)
                        .append(", actual: ").append(actual).append('\n');
                    success = false;
                    squareOk = false;
                }
            }
            if (squareOk) builder.insert(index, "OK");
            else builder.insert(index, "ERROR");
        }

        
        JTextArea txt = new JTextArea(builder.toString());
        txt.setRows(30);
        txt.setMargin(new Insets(0, 0, 0, 30));
        txt.setEditable(false);
        txt.setOpaque(false);

        JScrollPane pane = new JScrollPane(txt);
        pane.setBorder(null);

        int type = success ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE;
        String title = "getCell() Test " + (success ? "Passed!" : "Failed!");
        JOptionPane.showMessageDialog(frmTester, pane, title, type);
    }

    private void tstSetCell() {
        StringBuilder builder = new StringBuilder();
        boolean success = true;
        Random rnd = new Random();
        for (int gr = 0; gr < 3; gr++) for (int gc = 0; gc < 3; gc++) {
            Square3x3 square = getSquare(gr, gc);
            builder.append("Testing Square [").append(gr).append("][").append(gc)
                .append("]: \n");
            int index = builder.length() - 1;
            boolean squareOk = true;

            for (int sr = 0; sr < 3; sr++) for (int sc = 0; sc < 3; sc++) {
                builder.append("    Testing Cell [").append(sr).append("][").append(sc)
                .append("]: ");
                int expected = rnd.nextInt(100);
                square.setXY(sr, sc, expected);
                int actual = square.getCell(sr, sc);
                if (expected == actual) builder.append("OK\n");
                else {
                    builder.append("ERROR - expected: ").append(expected)
                        .append(", actual: ").append(actual).append('\n');
                    success = false;
                    squareOk = false;
                }
            }
            if (squareOk) builder.insert(index, "OK");
            else builder.insert(index, "ERROR");
        }

        JTextArea txt = new JTextArea(builder.toString());
        txt.setRows(30);
        txt.setMargin(new Insets(0, 0, 0, 30));
        txt.setEditable(false);
        txt.setOpaque(false);

        JScrollPane pane = new JScrollPane(txt);
        pane.setBorder(null);

        int type = success ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE;
        String title = "setXY() Test " + (success ? "Passed!" : "Failed!");
        JOptionPane.showMessageDialog(frmTester, pane, title, type);
    }

    private void tstAllThere() {
        StringBuilder builder = new StringBuilder();
        boolean success = true;

        for (int r = 0; r < 3; r++) for (int c = 0; c < 3; c++) {
            Square3x3 sq = getSquare(r, c);
            builder.append("Testing [" + r + "][" + c + "]: ");
            boolean actual = sq.allThere(), expected = true;
            boolean[] values = { false, false, false, false, false,
                false, false, false, false}; //size 9
            for (int sr = 0; sr < 3; sr++) for (int sc = 0; sc < 3; sc++) {
                int num = sq.getCell(sr, sc);
                if (num > 0 && num < 10 && !values[num-1]) values[num-1] = true;
                else {
                    expected = false;
                    break;
                }
            }
            if (expected) for (int i = 0; i < 9; i++) if (!values[i]) expected = false;

            if (actual == expected) builder.append("OK\n");
            else {
                builder.append("ERROR - expected: ").append(expected)
                    .append(", actual: ").append(actual).append('\n');
                success = false;
            }
        }

        int type = success ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE;
        String title = "allThere() Test " + (success ? "Passed!" : "Failed!");
        JOptionPane.showMessageDialog(frmTester, builder.toString(), title, type);
    }

    private void tstRowThere() {
        StringBuilder builder = new StringBuilder();
        boolean success = true;

        for (int gr = 0; gr < 3; gr++) for (int gc = 0; gc < 3; gc++) {
            Square3x3 square = getSquare(gr, gc);
            builder.append("Testing Square [").append(gr).append("][").append(gc)
                .append("]: \n");
            int index = builder.length() - 1;
            boolean squareOk = true;

            for (int sr = 0; sr < 3; sr++) {
                builder.append("    Testing Row ").append(sr).append(": ");
                boolean[] expected = { false, false, false, false, false,
                    false, false, false, false, false}; //size 10
                boolean[] actual = { false, false, false, false, false,
                    false, false, false, false, false}; //size 10
                square.whosThereRow(sr, actual);
                for (int sc = 0; sc < 3; sc++) {
                    int i = square.getCell(sr, sc);
                    if (i > 0 && i < 10) expected[i] = true;
                }
                if (arrEquals(expected, actual)) builder.append("OK\n");
                else {
                    builder.append(whosThereError(expected, actual)).append('\n');
                    success = false;
                    squareOk = false;
                }
            }

            if (squareOk) builder.insert(index, "OK");
            else builder.insert(index, "ERROR");
        }

        int type = success ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE;
        String title = "whosThereRow() Test " + (success ? "Passed!" : "Failed!");
        JOptionPane.showMessageDialog(frmTester, builder.toString(), title, type);
    }

    private void tstColThere() {
        StringBuilder builder = new StringBuilder();
        boolean success = true;

        for (int gr = 0; gr < 3; gr++) for (int gc = 0; gc < 3; gc++) {
            Square3x3 square = getSquare(gr, gc);
            builder.append("Testing Square [").append(gr).append("][").append(gc)
                .append("]: \n");
            int index = builder.length() - 1;
            boolean squareOk = true;

            for (int sc = 0; sc < 3; sc++) {
                builder.append("    Testing Col ").append(sc).append(": ");
                boolean[] expected = { false, false, false, false, false,
                    false, false, false, false, false}; //size 10
                boolean[] actual = { false, false, false, false, false,
                    false, false, false, false, false}; //size 10
                square.whosThereCol(sc, actual);
                for (int sr = 0; sr < 3; sr++) {
                    int i = square.getCell(sr, sc);
                    if (i > 0 && i < 10) expected[i] = true;
                }
                if (arrEquals(expected, actual)) builder.append("OK\n");
                else {
                    builder.append(whosThereError(expected, actual)).append('\n');
                    success = false;
                    squareOk = false;
                }
            }

            if (squareOk) builder.insert(index, "OK");
            else builder.insert(index, "ERROR");
        }

        int type = success ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE;
        String title = "whosThereCol() Test " + (success ? "Passed!" : "Failed!");
        JOptionPane.showMessageDialog(frmTester, builder.toString(), title, type);

    }

    private void tstToString() {
        StringBuilder builder = new StringBuilder();
        boolean success = true;
        for (int r = 0; r < 3; r++) for (int c = 0; c < 3; c++) {
            Square3x3 sq = getSquare(r, c);
            builder.append("Testing [" + r + "][" + c + "]: ");
            String actual = sq.toString();
            String expected = String.format("%d\t%d\t%d\n%d\t%d\t%d\n%d\t%d\t%d\n",
                sq.getCell(0, 0), sq.getCell(0, 1), sq.getCell(0, 2),
                sq.getCell(1, 0), sq.getCell(1, 1), sq.getCell(1, 2),
                sq.getCell(2, 0), sq.getCell(2, 1), sq.getCell(2, 2)
            );
            if (actual.equals(expected)) builder.append("OK\n");
            else {
                builder.append(toStringError(expected, actual)).append('\n');
                success = false;
            }
        }

        int type = success ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE;
        String title = "toString() Test " + (success ? "Passed!" : "Failed!");
        JOptionPane.showMessageDialog(frmTester, builder.toString(), title, type);
    }

    // =========== Errors ==========

    private String toStringError(String expected, String actual) {
        StringBuilder builder = new StringBuilder(expected.length());
        builder.append("ERROR - expected: \"");
        for (int i = 0; i < expected.length(); i++) {
            char c = expected.charAt(i);
            if (c == '\t') builder.append("\\t");
            if (c == '\n') builder.append("\\n");
            else builder.append(c);
        }
        builder.append("\", actual: \"");
        for (int i = 0; i < actual.length(); i++) {
            char c = actual.charAt(i);
            if (c == '\t') builder.append("\\t");
            if (c == '\n') builder.append("\\n");
            else builder.append(c);
        }
        builder.append('\"');
        
        return builder.toString();
    }

    private String whosThereError(boolean[] expected, boolean[] actual){
        StringBuilder builder = new StringBuilder(expected.length);
        builder.append("ERROR - expected: { ").append(expected[0]);
        for (int i = 1; i < expected.length; i++) {
            builder.append(", ").append(expected[i]);
        }
        builder.append(" }, actual: { ").append(expected[0]);
        for (int i = 1; i < actual.length; i++) {
            builder.append(", ").append(actual[i]);
        }
        builder.append('}');
        
        return builder.toString();
    }

}
